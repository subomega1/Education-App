package org.formationApp.contexs;

import org.formationApp.DB.models.Course_model;
import org.formationApp.controllers.GetCourses;

import java.util.ArrayList;

public class Student_contex {
   public static  ArrayList<Course_model> coursesBought;
   public static  ArrayList<Course_model> allCourses = new ArrayList<Course_model>();

   public  static void  allCoursesUpdate() throws Exception {
      GetCourses.allCourses();

   }
}
