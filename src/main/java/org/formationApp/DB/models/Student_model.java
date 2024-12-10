package org.formationApp.DB.models;

import org.formationApp.contexs.Contex;

public class Student_model extends User_model{

    public Student_model(String email, String username){
        Contex.accepted = true;
        this.setUsername(username);
        this.setRole("student");
        this.setEmail(email);

    }


}
