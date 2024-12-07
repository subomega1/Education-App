package org.formationApp.controllers;

import org.formationApp.DB.ConnectToDB;
import org.formationApp.DB.models.Course_model;
import org.formationApp.contexs.Contex;
import org.formationApp.contexs.Student_contex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetCourses {

    public static  void allCourses() throws Exception {
        if (!Contex.accepted){
            throw new Exception("you are not allowed");
        }
        else {
            Connection connection = ConnectToDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT title,description FROM teacher_course WHERE title not IN ( SELECT course_id FROM student_course WHERE student_course.student_id = ?)");
            statement.setString(1,Contex.userModel.getEmail());
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()){
                System.out.println("no course here");
            }else while (resultSet.next()){

                Course_model courseModel= new Course_model(resultSet.getString("title"),resultSet.getString("description"));
                Student_contex.allCourses.add( courseModel);
                System.out.println( courseModel.getTitle() +" " + courseModel.getDescription());
            }

        }
    }

}
