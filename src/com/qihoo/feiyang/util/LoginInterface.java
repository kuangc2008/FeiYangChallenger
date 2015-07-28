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

    //??????????????????,nomal-????;invalidUserName-????????;
    // invalidUserName-???????;userNameHasExisted-???????????????????
    //userNameNotExist-????????????????????????;invalidNickName(??????)
    //nickNameHasExisted?????????????????
    public enum errorCode {
        nomal, invalidUserName, invalidPassword, userNameHasExisted, userNameNotExist, invalidNickName, nickNameHasExisted
    }

    private errorCode m_errorCode;

    private enum keyWords {name, password, nickName}

    public LoginInterface(Context context) {
        String preferencesName = "loginData";
        m_context = context;
        m_preferences = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        m_editor = m_preferences.edit();
        m_errorCode = errorCode.nomal;
    }

    //?????????????--userName??????????????true????????????false?????????
    public boolean isUserExist(String userName) {
        //????????????????????
        if (!isValidName(userName)) {
            m_errorCode = errorCode.invalidUserName;
            return false;
        }
        String key = userName + ' ' + keyWords.name.toString();

        //key???????????????????
        if (!m_preferences.contains(key)) {
            m_errorCode = errorCode.nomal;
            return false;
        } else {
            m_errorCode = errorCode.nomal;
            return true;
        }
    }

    //??????--userName??????????password???????nickname??????
    public boolean userRegist(String userName, String password, String nickname) {
        //????????
        if (!isValidName(userName)) {
            m_errorCode = errorCode.invalidUserName;
            return false;
        }

        //??????
        if (!isValidName(nickname)) {
            m_errorCode = errorCode.invalidNickName;
            return false;
        }

        //???????
        if (!isValidPassword(password)) {
            m_errorCode = errorCode.invalidPassword;
            return false;
        }

        //?????????????????
        String nameKey = userName + ' ' + keyWords.name.toString();
        if (m_preferences.contains(nameKey)) {
            m_errorCode = errorCode.userNameHasExisted;
            return false;
        }

        //???????????????
        String nickNameKey = userName + ' ' + keyWords.nickName.toString();
        if (m_preferences.contains(nickNameKey)) {
            m_errorCode = errorCode.nickNameHasExisted;
            return false;
        }

        //??????
        String passwordKey = userName + ' ' + keyWords.password.toString();
        m_editor.putString(nameKey, userName);
        m_editor.putString(nickNameKey, nickname);
        m_editor.putString(passwordKey, password);
        m_editor.commit();

        m_errorCode = errorCode.nomal;
        return true;
    }

    //??????
    public String userName_to_nickName(String userName) {
        //????????
        if (!isValidName(userName)) {
            m_errorCode = errorCode.invalidUserName;
            return null;
        }

        String nameKey = userName + ' ' + keyWords.name.toString();
        String nickNameKey = userName + ' ' + keyWords.nickName.toString();

        //???????????
        if (!m_preferences.contains(nameKey)) {
            m_errorCode = errorCode.userNameNotExist;
            return null;
        }

        m_errorCode = errorCode.nomal;
        return m_preferences.getString(nickNameKey, null);
    }

    //??????????
    public boolean isRightPassword(String userName, String password) {
        //????????
        if (!isValidName(userName)) {
            m_errorCode = errorCode.invalidUserName;
            return false;
        }

        //???????
        if (!isValidPassword(password)) {
            m_errorCode = errorCode.invalidPassword;
            return false;
        }

        String nameKey = userName + ' ' + keyWords.name.toString();
        String passwordKey = userName + ' ' + keyWords.password.toString();

        //???????????????????
        if (!m_preferences.contains(nameKey)) {
            m_errorCode = errorCode.userNameNotExist;
            return false;
        }
        //???????
        if (!password.equals(m_preferences.getString(passwordKey, null))) {
            m_errorCode = errorCode.nomal;
            return false;
        } else {
            m_errorCode = errorCode.nomal;
            return true;
        }

    }


    //?§Ø???????????
    private boolean isValidName(String name) {
        if (name == null) {
            return false;
        }
        if (name.indexOf(" ") != -1) {
            return false;
        }
        if (name.isEmpty()) {
            return false;
        }

        return true;
    }

    //?§Ø??????????
    private boolean isValidPassword(String password) {
        if (password == null)

            if (password.indexOf(" ") != -1) {
                return false;
            }

        if (password.isEmpty()) {
            return false;
        }

        return true;
    }

    public errorCode getErrorNum() {
        return m_errorCode;
    }

    //????????????????
    public String getErrorString() {
        switch (m_errorCode) {
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
