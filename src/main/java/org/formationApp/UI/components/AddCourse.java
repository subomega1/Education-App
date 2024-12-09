package org.formationApp.UI.components;

import javax.swing.*;
import java.awt.*;

public class AddCourse {
    public AddCourse(){
        JFrame addCourseFrame = new JFrame("Add Course");
        addCourseFrame.setSize(500,500);
        addCourseFrame.setLocationRelativeTo(null);
        addCourseFrame.getContentPane().setBackground(Color.CYAN);
        addCourseFrame.setResizable(false);
        addCourseFrame.setLayout(new FlowLayout(FlowLayout.CENTER,0,25));


        JPanel courseTitleContainer = new JPanel();
        courseTitleContainer.setPreferredSize(new Dimension(480,100));
        courseTitleContainer.setBackground(Color.magenta);
        courseTitleContainer.setLayout(new FlowLayout(FlowLayout.LEFT ,15,15));
        addCourseFrame.add(courseTitleContainer);



        JLabel courseTitleLabel = new JLabel("Course Title");
        courseTitleLabel.setFont( new Font("Monospaced", Font.BOLD, 22));
        courseTitleLabel.setPreferredSize(new Dimension(430,20));
        courseTitleContainer.add(courseTitleLabel);


        JTextField courseTitle = new JTextField();
        courseTitle.setPreferredSize(new Dimension(430,40));
        courseTitle.setFont( new Font("Monospaced", Font.BOLD, 22));
        courseTitleContainer.add(courseTitle);



























        addCourseFrame.setVisible(true);
    }
}
