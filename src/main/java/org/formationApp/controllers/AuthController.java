package org.formationApp.controllers;

import org.formationApp.DB.models.Teacher;
import org.formationApp.contexs.Contex;
import org.formationApp.DB.ConnectToDB;
import org.formationApp.DB.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthController {
  //public static boolean logSucc =false;

  public   static  void login(String username , String password  ) throws Exception  {

                if (username.isEmpty() || password.isEmpty()){
                    throw new Exception("please fill the username and password fields");}
                else {

                    Connection connection = ConnectToDB.getConnection();
                    PreparedStatement statement = connection.prepareStatement("select * from user_table where username = ? and password = ? ");
                    statement.setString(1, username);
                    statement.setString(2, password);
                    ResultSet resultSet = statement.executeQuery();
                    if (!resultSet.next()) {
                        throw new Exception("Invalid username or password.");
                    } else {
                        System.out.println(resultSet.getString("role"));
                        if (resultSet.getString("role").equals("student")){
                           Contex.userModel= new Student(resultSet.getString("email"),resultSet.getString("username"));
                        }else{
                            Contex.userModel= new Teacher(resultSet.getString("email"),resultSet.getString("username"));

                        }






                    }
            }
  }
}
