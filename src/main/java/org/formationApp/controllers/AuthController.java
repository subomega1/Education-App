package org.formationApp.controllers;

import org.formationApp.DB.models.Teacher_model;
import org.formationApp.contexs.Contex;
import org.formationApp.DB.ConnectToDB;
import org.formationApp.DB.models.Student_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthController {
  //public static boolean logSucc =false;

  public   static  void login(String email , String password  ) throws Exception  {

                if (email.isEmpty() || password.isEmpty()){
                    throw new Exception("please fill the email and password fields");}
                else {

                    Connection connection = ConnectToDB.getConnection();
                    PreparedStatement statement = connection.prepareStatement("select * from user_table where email = ? and password = ? ");
                    statement.setString(1, email);
                    statement.setString(2, password);
                    ResultSet resultSet = statement.executeQuery();
                    if (!resultSet.next()) {
                        throw new Exception("Invalid email or password.");
                    } else {
                        System.out.println(resultSet.getString("role"));
                        if (resultSet.getString("role").equals("student")){
                           Contex.userModel= new Student_model(resultSet.getString("email"),resultSet.getString("email"));
                        }else{
                            Contex.userModel= new Teacher_model(resultSet.getString("email"),resultSet.getString("email"));

                        }






                    }
            }
  }
}
