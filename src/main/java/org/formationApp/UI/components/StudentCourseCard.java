package org.formationApp.UI.components;

import org.formationApp.DB.models.Course_model;
import org.formationApp.contexs.Student_contex;

import javax.swing.*;
import java.awt.*;

public class StudentCourseCard {
    public StudentCourseCard(JPanel courseContainer, String title, String description) {
        //card Component it 's a frontend design
        JPanel courseCard = new JPanel();
        courseCard.setBackground(new Color(131,124,128));
        courseCard.setPreferredSize(new Dimension(260, 250));
        courseCard.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
        courseContainer.add(courseCard);

        // subPanelCourseTitle for layout reason
        JPanel subPanelCourseTitle = new JPanel();
        subPanelCourseTitle.setPreferredSize(new Dimension(new Dimension(260, 190)));
        subPanelCourseTitle.setBackground(new Color(131, 124, 128));
        subPanelCourseTitle.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 3, Color.BLACK));
        courseCard.add(subPanelCourseTitle, BorderLayout.SOUTH);

        //courseTitleContainer
        JPanel courseTitleContainer = new JPanel();
        courseTitleContainer.setPreferredSize(new Dimension(260, 80));
        courseTitleContainer.setBackground(new Color(131, 124, 128));
        courseTitleContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        courseTitleContainer.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 3, Color.BLACK));
        subPanelCourseTitle.add(courseTitleContainer, BorderLayout.SOUTH);

        // courseTitle
        JLabel courseTitle = new JLabel(title);
        courseTitle.setPreferredSize(new Dimension(210, 80));
        courseTitle.setFont(new Font("Monospaced", Font.BOLD, 15));
        courseTitleContainer.add(courseTitle);

        // courseDescription
        JTextArea courseDescription = new JTextArea("Discription:\n" + description);
        courseDescription.setPreferredSize(new Dimension(250, 160));
        courseDescription.setFont(new Font("Monospaced", Font.BOLD, 14));
        courseDescription.setBackground(new Color(131, 124, 128));
        courseDescription.setLineWrap(true);
        courseDescription.setEditable(false);
        courseDescription.setWrapStyleWord(true);
        subPanelCourseTitle.add(courseDescription);

    }

    public StudentCourseCard(JPanel courseContainer, Dimension dimension) throws Exception {
        Student_contex.getCoursesUpdated();
        if (Student_contex.coursesBought.size() > 6) {
            int nbRows = (int) Math.ceil((double) Student_contex.coursesBought.size() / 3);
            System.out.println(nbRows);
            dimension.setSize(dimension.width, nbRows * 280);
            courseContainer.setPreferredSize(dimension);
        }
        for (Course_model courseModel : Student_contex.coursesBought) {
          new StudentCourseCard(courseContainer, courseModel.getTitle(), courseModel.getDescription());
            //courseContainer.repaint();
        }

    }
}



