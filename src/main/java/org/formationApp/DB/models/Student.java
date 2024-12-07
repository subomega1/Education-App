package org.formationApp.DB.models;

import org.formationApp.Contex;

public class Student extends User_model{

    public Student(String email, String username){
        Contex.accepted = true;
        this.setUsername(username);
        this.setRole("student");
        this.setEmail(email);

    }


}
