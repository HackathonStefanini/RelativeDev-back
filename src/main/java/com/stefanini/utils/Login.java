package com.stefanini.utils;

public class Login {

    private String nickname;
    private String password;

    public Login(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public String getLogin() {
        return nickname;
    }

    public void setLogin(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
