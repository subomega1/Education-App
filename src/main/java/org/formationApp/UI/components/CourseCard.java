package org.formationApp.UI.components;

import org.formationApp.DB.models.Course_model;
import org.formationApp.contexs.Contex;
import org.formationApp.contexs.Student_contex;
import org.formationApp.controllers.BuyCourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseCard {

     public CourseCard( JPanel courseContainer , String title ,String description  ,Dimension dimension){

        //card Component it 's a frontend design
         JPanel courseCard = new JPanel();
         courseCard.setBackground(new Color(131,124,128));
         courseCard.setPreferredSize(new Dimension(260,250));
         courseCard.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.BLACK));
         courseContainer.add(courseCard);

         // subPanelCourseTitle for layout reason
         JPanel subPanelCourseTitle = new JPanel();
         subPanelCourseTitle.setPreferredSize(new Dimension(new Dimension(260,190)));
         subPanelCourseTitle.setBackground(new Color(131,124,128));
         subPanelCourseTitle.setBorder(BorderFactory.createMatteBorder(0,3,0,3,Color.BLACK));
         courseCard.add(subPanelCourseTitle,BorderLayout.SOUTH);

         //courseTitleContainer
         JPanel courseTitleContainer = new JPanel();
         courseTitleContainer.setPreferredSize(new Dimension(260,80));
         courseTitleContainer.setBackground(new Color(131,124,128));
         courseTitleContainer.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
         courseTitleContainer.setBorder(BorderFactory.createMatteBorder(0,3,0,3,Color.BLACK));
         subPanelCourseTitle.add(courseTitleContainer,BorderLayout.SOUTH);

         // courseTitle
         JLabel courseTitle = new JLabel(title);
         courseTitle.setPreferredSize(new Dimension(210,80));
         courseTitle.setFont( new Font("Monospaced", Font.BOLD, 15));
         courseTitleContainer.add(courseTitle);

         // courseDescription
         JTextArea courseDescription = new JTextArea("Discription:\n" + description);
         courseDescription.setPreferredSize(new Dimension(250,110));
         courseDescription.setFont( new Font("Monospaced", Font.BOLD, 14));
         courseDescription.setBackground(new Color(131,124,128));
         courseDescription.setLineWrap(true);
         courseDescription.setWrapStyleWord(true);
         courseDescription.setEditable(false);
         subPanelCourseTitle.add(courseDescription);

         // addCoursePanel
         JPanel addCoursePanel = new JPanel();
         addCoursePanel.setPreferredSize(new Dimension(260,40));
         addCoursePanel.setLayout(new FlowLayout(FlowLayout.RIGHT,20,10));
         addCoursePanel.setBackground(new Color(131,124,128));
         addCoursePanel.setBorder(BorderFactory.createMatteBorder(0,3,0,3,Color.BLACK));
         courseCard.add(addCoursePanel,BorderLayout.NORTH);

         // addCourseButton
        JButton addCourseButton = new JButton();
         addCourseButton.setPreferredSize(new Dimension(100,30));
         addCourseButton.setFont( new Font("Monospaced", Font.BOLD, 14));
         addCourseButton.setText("add");
         addCourseButton.setBackground(new Color(131,124,128));
         addCoursePanel.add(addCourseButton);
         addCourseButton.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.BLACK));
         addCourseButton.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 courseContainer.removeAll();
                 try {
                     BuyCourse.addStudentCourse(Contex.userModel.getEmail(),title);
                     if (BuyCourse.affected){
                     new CourseCard(courseContainer,dimension);
                     }

                 } catch (Exception error) {
                     courseContainer.removeAll();
                     JLabel videMsg = new JLabel(error.getMessage());
                     videMsg.setFont( new Font("Monospaced", Font.BOLD, 50));
                     videMsg.setForeground(Color.RED);
                     courseContainer.add(videMsg);



                 }finally {
                     courseContainer.revalidate();
                     courseContainer.repaint();
                 }

             }
         });

     }



     public CourseCard(JPanel courseContainer , Dimension dimension ) throws Exception {
        Student_contex.allCoursesUpdate();
        courseContainer.removeAll();
        courseContainer.repaint();
         if (Student_contex.allCourses.size() >6) {
            int nbRows = (int) Math.ceil((double) Student_contex.allCourses.size() / 3);
            // System.out.println(nbRows);
            dimension.setSize(dimension.width, nbRows * 280);
            courseContainer.setPreferredSize(dimension);
        }
         for (Course_model courseModel : Student_contex.allCourses){
             new CourseCard(courseContainer , courseModel.getTitle() , courseModel.getDescription(), dimension);
             //courseContainer.repaint();
         }

     }


}
