package org.formationApp.DB.models;

public abstract class User_model {

    private String username,email , password ,role="";
    public String getUsername(){
        return username;
    }


    public String getPassword(){
        return password;
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
    public void setPassword(String password){
        this.password = password;
    }
    public void setRole(String role){
        this.role= role;
    }

}
