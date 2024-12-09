package org.formationApp.DB.models;

import org.formationApp.contexs.Contex;

public class Teacher extends User_model{
    public Teacher(String email, String username  ){
        Contex.accepted = true;
        this.setUsername(username);
        this.setRole("teacher");
        this.setEmail(email);
    }
}
