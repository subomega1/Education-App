package org.formationApp.DB.models;

public abstract class User_model {

    private String username,email  ,role="";

    public String getUsername(){
        return username;
    }
    public String getEmail(){
        return email;
    }
    public String getRole(){
        return role;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public void setEmail(String email){
        this.email= email;
    }
    public void setRole(String role){
        this.role= role;
    }

}
