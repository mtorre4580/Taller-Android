package com.dev.retrofit;


public class Usuario {

    private String username;
    private String email;

    public Usuario(String username,String email){
        this.username = username;
        this.email = email;
    }

    public Usuario(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
