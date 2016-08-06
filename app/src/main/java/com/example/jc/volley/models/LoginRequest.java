package com.example.jc.volley.models;

/**
 * Created by jc on 13/07/16.
 */
public class LoginRequest {

    private String user;
    private String password;
    private int attempt;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    @Override
    public String toString() {
        return "LoginRequestActivity{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", attempt=" + attempt +
                '}';
    }
}
