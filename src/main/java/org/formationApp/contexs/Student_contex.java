package org.formationApp.contexs;

import org.formationApp.DB.models.Course_model;
import org.formationApp.controllers.GetCoursesController;

import java.util.HashSet;
import java.util.Set;

public class Student_contex {
   public static  Set<Course_model> coursesBought = new HashSet<Course_model>();
   public static Set<Course_model> allCourses = new HashSet<Course_model>();



   public  static void  allCoursesUpdate() throws Exception {
         allCourses.clear();
      GetCoursesController.allCourses();


   }
   public  static void  getCoursesUpdated() throws Exception {
      coursesBought.clear();
      GetCoursesController.getCourses();

   }
}
