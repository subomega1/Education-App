package org.formationApp.controllers;

import org.formationApp.DB.models.Teacher_model;
import org.formationApp.contexs.Contex;
import org.formationApp.DB.ConnectToDB;
import org.formationApp.DB.models.Student_model;
import org.formationApp.utils.HashFunction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthController {
  public static boolean createdSucc =false;

  public   static  void login(String email , String password  ) throws Exception  {

                if (email.isEmpty() || password.isEmpty()){
                    throw new Exception("please fill the email and password fields");}
                else {

                    Connection connection = ConnectToDB.getConnection();
                    PreparedStatement statement = connection.prepareStatement("select * from user_table where email = ? and password = ? ");
                    statement.setString(1, email);
                    String passwordHashed = HashFunction.hashPassword(3,password);
                    statement.setString(2, passwordHashed);
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
  public static void signUp(String email,String username,String password,String confirmedPassword,String role) throws Exception {
     createdSucc=false;
      if (email.isEmpty() || username.isEmpty() || password.isEmpty() || role.isEmpty()) {
          throw new Exception("Please fill all fields");
      }
      if (role.equals("Pick role")) {
          throw new Exception("Please pick a role");

      }if (!confirmedPassword.equals(password)){
          throw new Exception("password do not match");
      }
      Connection connection = ConnectToDB.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement("select * from user_table where email=?");
      preparedStatement.setString(1,email);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()){
          throw new Exception("this User already exists");
      }else {
          PreparedStatement preparedStatement1 = connection.prepareStatement("insert into  user_table value(?,?,?,?)");
          preparedStatement1.setString(1,email);
          preparedStatement1.setString(2,username);
          String passwordHashed = HashFunction.hashPassword(3,password);
          preparedStatement1.setString(3,passwordHashed);
          preparedStatement1.setString(4,role);
          int rows = preparedStatement1.executeUpdate();
          if (rows>0){
             createdSucc  = true;
          }else {
              throw new Exception("Failed to insert Data");
          }
      }
  }

  }

