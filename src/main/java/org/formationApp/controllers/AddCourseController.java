package org.formationApp.controllers;

import org.formationApp.DB.ConnectToDB;
import org.formationApp.contexs.Contex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddCourseController {
     public static boolean addedSucc = false;
    public static void addCourseTeacher ( String title , String description) throws Exception {
        addedSucc = false;
        if (title.isEmpty() || description.isEmpty()){
            throw new Exception("please fill all fields");
        }else {
            if (!Contex.userModel.getRole().equals("teacher") || !Contex.accepted){
                throw new Exception("you are not allowed to be here ");
            }else {
                Connection connection = ConnectToDB.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement("select * from teacher_course where title=?");
                preparedStatement.setString(1,title);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){

                    resultSet.close();
                    preparedStatement.close();
                    connection.close();
                    throw new Exception("this Course already exists");

                }else {
                    PreparedStatement preparedStatement1 = connection.prepareStatement("insert into teacher_course  value(?,?,?)");
                    preparedStatement1.setString(1,title);
                    preparedStatement1.setString(2,description);
                    preparedStatement1.setString(3,Contex.userModel.getEmail());
                    int rows = preparedStatement1.executeUpdate();
                    if (rows>0){
                        resultSet.close();
                        preparedStatement1.close();
                        connection.close();
                        addedSucc = true;

                    }else {
                        resultSet.close();
                        preparedStatement1.close();
                        connection.close();
                        throw new Exception("Failed to insert Data");
                    }
                }
            }
        }

    }
}
