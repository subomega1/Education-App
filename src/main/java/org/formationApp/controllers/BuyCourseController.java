package org.formationApp.controllers;

import org.formationApp.DB.ConnectToDB;
import org.formationApp.contexs.Contex;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BuyCourseController {

        public static boolean affected = false;
        public  static  void addStudentCourse( String studentId,String courseId) throws  Exception{
            affected = false;
            if (!Contex.accepted){
                throw new Exception("access denied");
            }

            Connection connection = ConnectToDB.getConnection();
            PreparedStatement statement = connection.prepareStatement("insert into student_course values (?,?) ");
            statement.setString(1,studentId);
            statement.setString(2,courseId);

            int rows =  statement.executeUpdate();

            if (rows>0){
                affected=true;
            }else {
                throw new Exception("Could not insert data");
            }


        }
}
