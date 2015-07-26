package com.qihoo.feiyang.util;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by maxiaowei on 2015/7/25.
 */


public class LoginInterface {
    private SharedPreferences m_preferences;
    private SharedPreferences.Editor m_editor;
    //��¼�ӿ���Ĵ������ö��,nomal-����;invalidUserName-�Ƿ��û���;
    // invalidUserName-�Ƿ�����;userNameHasExisted-�û����Ѵ��ڣ�ע��ʱ����
    //userNameNotExist-�û��������ڣ���֤����ʱ����
    public enum errorCode{nomal, invalidUserName, invalidPassword, userNameHasExisted, userNameNotExist}
    private  errorCode m_errorCode;

    public LoginInterface(Context context)
    {
        String preferencesName = "loginData";
        m_preferences = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        m_editor = m_preferences.edit();
        m_errorCode = errorCode.nomal;
    }

    //�����û��Ƿ����--userNameָ���û���������true��ʾ���ڣ�����false��ʾ������
    public boolean isUserExist(String userName)
    {
        //�û����Ƿ���ʾ�û�������
        if (!isValidName(userName))
        {
            m_errorCode = errorCode.invalidUserName;
            return false;
        }
        String key = userName + ' ' + "userName";

        //key�����ڣ���ʾ�û�������
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

    //ע���û�--userNameָ���û�����passwordָ������
    public boolean userRegist(String userName, String password)
    {
        //�Ƿ��û���
        if (!isValidName(userName))
        {
            m_errorCode = errorCode.invalidUserName;
            return false;
        }

        //�Ƿ�����
        if (!isValidPassword(password))
        {
            m_errorCode = errorCode.invalidPassword;
            return false;
        }

        //�û����Ѵ��ڣ�ע��ʧ��
        String nameKey = userName + ' ' + "name";
        if (m_preferences.contains(nameKey))
        {
            m_errorCode = errorCode.userNameHasExisted;
            return false;
        }

        //ע���û�
        String passwordKey = userName + ' ' + "password";
        m_editor.putString(nameKey, userName);
        m_editor.putString(passwordKey, password);
        m_editor.commit();

        m_errorCode = errorCode.nomal;
        return true;
    }

    //��¼������֤
    public boolean isRightPassword(String userName, String password)
    {
        //�Ƿ��û���
        if (!isValidName(userName))
        {
            m_errorCode = errorCode.invalidUserName;
            return false;
        }

        //�Ƿ�����
        if (!isValidPassword(password))
        {
            m_errorCode = errorCode.invalidPassword;
            return false;
        }

        String nameKey = userName + ' ' + "name";
        String passwordKey = userName + ' ' + "password";

        //�û��������ڣ��������
        if (!m_preferences.contains(nameKey))
        {
            m_errorCode = errorCode.userNameNotExist;
            return false;
        }
        //�������
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


    //�ж��û����Ƿ�Ϸ�
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

    //�ж������Ƿ�Ϸ�
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
                return "����";
            case invalidUserName:
                return "�Ƿ��û���";
            case invalidPassword:
                return "�Ƿ�����";
            case userNameHasExisted:
                return "�û����Ѵ���";
            case userNameNotExist:
                return "�û���������";
        }

        return m_errorCode.toString();
    }
}
