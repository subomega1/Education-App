package org.formationApp.controllers;

import org.formationApp.DB.ConnectToDB;
import org.formationApp.DB.models.Course_model;
import org.formationApp.contexs.Contex;
import org.formationApp.contexs.Student_contex;
import org.formationApp.contexs.Teacher_contex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetCourses {

    public static  boolean courseExist(String s, ArrayList<Course_model> arrayList ){
        if (arrayList.isEmpty()){
            return  true;
        }
        int i =0;
        while (i<arrayList.size()){
            if (s.equals(arrayList.get(i).getTitle())){
                return false;
            }
        }
        return true;
    }


    public static  void allCourses() throws Exception {
        if (!Contex.accepted || !Contex.userModel.getRole().equals("student")){
            throw new Exception("you are not allowed");
        }
        else {
            Connection connection = ConnectToDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT title,description FROM teacher_course WHERE title not IN ( SELECT course_id FROM student_course WHERE student_course.student_id = ?)");
            statement.setString(1,Contex.userModel.getEmail());
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()){
                throw new Exception("new Courses will come soon ");
            }else {
                Student_contex.allCourses.clear();
                while (resultSet.next()) {

                    Course_model courseModel = new Course_model(resultSet.getString("title"), resultSet.getString("description"));
                    Student_contex.allCourses.add(courseModel);
                    System.out.println(courseModel.getTitle() + " " + courseModel.getDescription());
                }
            }
        }
    }

    public static  void getCourses() throws Exception {
        if (!Contex.accepted || !Contex.userModel.getRole().equals("student")){
            throw new Exception("you are not allowed");
        }
        else {
            Connection connection = ConnectToDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT title,description FROM teacher_course WHERE title  IN ( SELECT course_id FROM student_course WHERE student_course.student_id = ?)");
            statement.setString(1,Contex.userModel.getEmail());
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.isBeforeFirst()){
                throw new Exception(" check home and buy some courses ");
            }else{
                Student_contex.coursesBought.clear();
                while (resultSet.next()){

                Course_model courseModel= new Course_model(resultSet.getString("title"),resultSet.getString("description"));
                    Student_contex.coursesBought.add(courseModel);


                }
            }
        }

        }
        public static void getTeacherCourse() throws Exception {
            if(!Contex.accepted || !Contex.userModel.getRole().equals("teacher")){
                throw new Exception("you are not allowed here");
            }else {
                Connection connection = ConnectToDB.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT title,description FROM teacher_course WHERE teacher_id=? ");
                statement.setString(1,Contex.userModel.getEmail());
                ResultSet resultSet = statement.executeQuery();
                if (!resultSet.isBeforeFirst()){
                    throw new Exception(" Add some courses ");
                }else{
                    Student_contex.coursesBought.clear();
                    while (resultSet.next()){

                        Course_model courseModel= new Course_model(resultSet.getString("title"),resultSet.getString("description"));
                        Teacher_contex.TeacherCourses.add(courseModel);


                    }
                }

            }
        }

}
