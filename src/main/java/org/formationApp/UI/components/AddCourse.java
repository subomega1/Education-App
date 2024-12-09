package org.formationApp.UI.components;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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

        JTextArea courseTitle = new JTextArea();
        courseTitle.setPreferredSize(new Dimension(440,30));
        int maxTitleLine = 1;
        courseTitle.setFont(new Font("Monospaced", Font.BOLD, 22));
        courseTitle.setLineWrap(true); // enable line wrapping
        courseTitle.setWrapStyleWord(true);
        courseTitleContainer.add(courseTitle);
        courseTitle.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkLines();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkLines();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkLines();

            }
            private void checkLines(){
                int lines = courseTitle.getLineCount();
                if (lines>maxTitleLine){
                    courseTitle.setCaretPosition(courseTitle.getDocument().getLength());
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });


        JPanel courseDescriptionContainer = new JPanel();
        courseDescriptionContainer.setPreferredSize(new Dimension(480,250));
        courseDescriptionContainer.setBackground(Color.magenta);
        courseDescriptionContainer.setLayout(new FlowLayout(FlowLayout.LEFT ,15,15));
        addCourseFrame.add(courseDescriptionContainer);

        JLabel courseDescriptionLabel = new JLabel("Course Description");
        courseDescriptionLabel.setFont( new Font("Monospaced", Font.BOLD, 22));
        courseDescriptionLabel.setPreferredSize(new Dimension(430,20));
        courseDescriptionContainer.add(courseDescriptionLabel);


        JTextArea courseDescription = new JTextArea();
        courseDescription.setCaretColor(Color.black);
        courseDescription.setPreferredSize(new Dimension(430,180));
        courseDescription.setFont( new Font("Monospaced", Font.BOLD, 22));
        courseDescription.setLineWrap(true);
        courseDescription.setWrapStyleWord(true);
        courseDescriptionContainer.add(courseDescription);
        int maxDescriptionLines = 6;
        courseDescription.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkLines();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                    checkLines();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkLines();
            }
            private void checkLines(){
                int lines = courseDescription.getLineCount();
                if (lines>maxDescriptionLines){
                    courseDescription.setCaretPosition(courseDescription.getDocument().getLength());
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });




























        addCourseFrame.setVisible(true);
    }
}
