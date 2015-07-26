package com.qihoo.feiyang.util;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by maxiaowei on 2015/7/25.
 */


public class LoginInterface {
    private SharedPreferences m_preferences;
    private SharedPreferences.Editor m_editor;
    //登录接口类的错误代码枚举,nomal-正常;invalidUserName-非法用户名;
    // invalidUserName-非法密码;userNameHasExisted-用户名已存在（注册时错误）
    //userNameNotExist-用户名不存在（验证密码时错误）
    public enum errorCode{nomal, invalidUserName, invalidPassword, userNameHasExisted, userNameNotExist}
    private  errorCode m_errorCode;

    public LoginInterface(Context context)
    {
        String preferencesName = "loginData";
        m_preferences = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        m_editor = m_preferences.edit();
        m_errorCode = errorCode.nomal;
    }

    //查找用户是否存在--userName指定用户名，返回true表示存在，返回false表示不存在
    public boolean isUserExist(String userName)
    {
        //用户名非法表示用户不存在
        if (!isValidName(userName))
        {
            m_errorCode = errorCode.invalidUserName;
            return false;
        }
        String key = userName + ' ' + "userName";

        //key不存在，表示用户不存在
        if(!m_preferences.contains(key))
        {
            m_errorCode = errorCode.nomal;
            return  false;
        }
        else
        {
            m_errorCode = errorCode.nomal;
            return true;
        }
    }

    //注册用户--userName指定用户名，password指定密码
    public boolean userRegist(String userName, String password)
    {
        //非法用户名
        if (!isValidName(userName))
        {
            m_errorCode = errorCode.invalidUserName;
            return false;
        }

        //非法密码
        if (!isValidPassword(password))
        {
            m_errorCode = errorCode.invalidPassword;
            return false;
        }

        //用户名已存在，注册失败
        String nameKey = userName + ' ' + "name";
        if (m_preferences.contains(nameKey))
        {
            m_errorCode = errorCode.userNameHasExisted;
            return false;
        }

        //注册用户
        String passwordKey = userName + ' ' + "password";
        m_editor.putString(nameKey, userName);
        m_editor.putString(passwordKey, password);
        m_editor.commit();

        m_errorCode = errorCode.nomal;
        return true;
    }

    //登录密码验证
    public boolean isRightPassword(String userName, String password)
    {
        //非法用户名
        if (!isValidName(userName))
        {
            m_errorCode = errorCode.invalidUserName;
            return false;
        }

        //非法密码
        if (!isValidPassword(password))
        {
            m_errorCode = errorCode.invalidPassword;
            return false;
        }

        String nameKey = userName + ' ' + "name";
        String passwordKey = userName + ' ' + "password";

        //用户名不存在，密码错误
        if (!m_preferences.contains(nameKey))
        {
            m_errorCode = errorCode.userNameNotExist;
            return false;
        }
        //检测密码
        if (!password.equals(m_preferences.getString(passwordKey, null)))
        {
            m_errorCode = errorCode.nomal;
            return false;
        }
        else
        {
            m_errorCode = errorCode.nomal;
            return true;
        }

    }


    //判断用户名是否合法
    private boolean isValidName(String name)
    {
        if(name.indexOf(" ")!=-1){
            return false;
        }
        if (name.isEmpty()){
            return false;
        }

        return true;
    }

    //判断密码是否合法
    private boolean isValidPassword(String password)
    {
        if(password.indexOf(" ")!=-1){
            return false;
        }

        if (password.isEmpty()){
            return false;
        }

        return true;
    }

    public errorCode getErrorNum()
    {
        return m_errorCode;
    }

    public String getErrorString()
    {
        switch (m_errorCode){
            case nomal:
                return "正常";
            case invalidUserName:
                return "非法用户名";
            case invalidPassword:
                return "非法密码";
            case userNameHasExisted:
                return "用户名已存在";
            case userNameNotExist:
                return "用户名不存在";
        }

        return m_errorCode.toString();
    }
}
