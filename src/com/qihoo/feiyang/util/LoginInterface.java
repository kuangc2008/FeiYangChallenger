package com.qihoo.feiyang.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.qihoo.feiyang.challenger.R;


/**
 * Created by maxiaowei on 2015/7/25.
 */


public class LoginInterface {
    private SharedPreferences m_preferences;
    private SharedPreferences.Editor m_editor;
    private Context m_context;
    //登录接口类的错误代码枚举,nomal-正常;invalidUserName-非法用户名;
    // invalidUserName-非法密码;userNameHasExisted-用户名已存在（注册时错误）
    //userNameNotExist-用户名不存在（验证密码时错误）;invalidNickName(非法昵称)
    //nickNameHasExisted昵称已存在（注册时错误）
    public enum errorCode{nomal, invalidUserName, invalidPassword, userNameHasExisted, userNameNotExist
        ,invalidNickName, nickNameHasExisted}
    private  errorCode m_errorCode;
    private enum keyWords{name, password, nickName}

    public LoginInterface(Context context)
    {
        String preferencesName = "loginData";
        m_context = context;
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
        String key = userName + ' ' + keyWords.name.toString();

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

    //注册用户--userName指定用户名，password指定密码，nickname指定昵称
    public boolean userRegist(String userName, String password, String nickname)
    {
        //非法用户名
        if (!isValidName(userName))
        {
            m_errorCode = errorCode.invalidUserName;
            return false;
        }

        //非法昵称
        if(!isValidName(nickname))
        {
            m_errorCode = errorCode.invalidNickName;
            return false;
        }

        //非法密码
        if (!isValidPassword(password))
        {
            m_errorCode = errorCode.invalidPassword;
            return false;
        }

        //用户名已存在，注册失败
        String nameKey = userName + ' ' + keyWords.name.toString();
        if (m_preferences.contains(nameKey))
        {
            m_errorCode = errorCode.userNameHasExisted;
            return false;
        }

        //昵称已存在，注册失败
        String nickNameKey = userName + ' ' + keyWords.nickName.toString();
        if (m_preferences.contains(nickNameKey))
        {
            m_errorCode = errorCode.nickNameHasExisted;
            return false;
        }

        //注册用户
        String passwordKey = userName + ' ' + keyWords.password.toString();
        m_editor.putString(nameKey, userName);
        m_editor.putString(nickNameKey, nickname);
        m_editor.putString(passwordKey, password);
        m_editor.commit();

        m_errorCode = errorCode.nomal;
        return true;
    }

    public String userName_to_nickName(String userName)
    {
        //非法用户名
        if (!isValidName(userName))
        {
            m_errorCode = errorCode.invalidUserName;
            return null;
        }

        String nameKey = userName + ' ' + keyWords.name.toString();
        String nickNameKey = userName + ' ' + keyWords.nickName.toString();

        //用户名不存在
        if (!m_preferences.contains(nameKey))
        {
            m_errorCode = errorCode.userNameNotExist;
            return null;
        }

        m_errorCode = errorCode.nomal;
        return m_preferences.getString(nickNameKey, null);
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

        String nameKey = userName + ' ' + keyWords.name.toString();
        String passwordKey = userName + ' ' + keyWords.password.toString();

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
        if(name == null)
        {
            return false;
        }
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
        if (password == null)

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

    //获取错误代码的字符串
    public String getErrorString()
    {
        switch (m_errorCode){
            case nomal:
                return m_context.getResources().getString(R.string.login_interface_error_string_nomal);
            case invalidUserName:
                return m_context.getResources().getString(R.string.login_interface_error_string_invalidUserName);
            case invalidPassword:
                return m_context.getResources().getString(R.string.login_interface_error_string_invalidPassword);
            case userNameHasExisted:
                return m_context.getResources().getString(R.string.login_interface_error_string_userNameHasExisted);
            case userNameNotExist:
                return m_context.getResources().getString(R.string.login_interface_error_string_userNameNotExist);
            case invalidNickName:
                return m_context.getResources().getString(R.string.login_interface_error_string_invalidNickName);
            case nickNameHasExisted:
                return m_context.getResources().getString(R.string.login_interface_error_string_nickNameHasExisted);
        }

        return m_errorCode.toString();
    }
}
