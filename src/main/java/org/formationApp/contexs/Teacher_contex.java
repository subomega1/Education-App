package org.formationApp.contexs;

import org.formationApp.DB.models.Course_model;
import org.formationApp.controllers.GetCourses;

import java.util.HashSet;
import java.util.Set;

public class Teacher_contex {
    public static Set<Course_model> TeacherCourses = new HashSet<Course_model>();
    public static void TeacherCoursesUpdate() throws Exception {
        TeacherCourses.clear();
        GetCourses.getTeacherCourse();
    }
}
