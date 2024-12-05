package org.formationApp.controllers;

import org.formationApp.DB.ConnectToDB;
import org.formationApp.DB.models.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthController {
  public static boolean logSucc =false;

  public   static <spine> void login(String username , String password )  {

            try {
                if (username.isEmpty() || password.isEmpty()){
                    throw new Exception("please fill the username and password fields");}
                else {

                    Connection connection = ConnectToDB.getConnection();
                    PreparedStatement statement = connection.prepareStatement("select * from student_table where username = ? and password = ? ");
                    statement.setString(1, username);
                    statement.setString(2, password);
                    ResultSet resultSet = statement.executeQuery();
                    if (!resultSet.next()) {
                        throw new Exception("Invalid username or password.");
                    } else {
                        Student student = new Student();

                        student.setEmail(resultSet.getString("email"));
                        student.setUsername(resultSet.getString("username"));
                        System.out.println("username is " + student.getUsername() + " and the email is " + student.getEmail());
                        logSucc = true;
                    }
                }
            } catch (Exception e) {
                System.out.println("Internal server error " + e.getMessage() );

            }
  }
}
