package org.formationApp.UI.components;

import org.formationApp.UI.Theme_Resources.Design_Assets;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCourse {
    public AddCourse(){
        JFrame addCourseFrame = new JFrame("Add Course");
        addCourseFrame.setSize(500,500);
        addCourseFrame.setLocationRelativeTo(null);
        addCourseFrame.getContentPane().setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        addCourseFrame.setResizable(false);
        addCourseFrame.setLayout(new FlowLayout(FlowLayout.CENTER,0,18));


        JPanel courseTitleContainer = new JPanel();
        courseTitleContainer.setPreferredSize(new Dimension(480,100));
        courseTitleContainer.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        courseTitleContainer.setLayout(new FlowLayout(FlowLayout.LEFT ,15,15));
        addCourseFrame.add(courseTitleContainer);



        JLabel courseTitleLabel = new JLabel("Course Title");
        courseTitleLabel.setFont( new Font("Monospaced", Font.BOLD, 22));
        courseTitleLabel.setForeground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b));
        courseTitleLabel.setPreferredSize(new Dimension(430,20));
        courseTitleContainer.add(courseTitleLabel);

        JTextField courseTitle = new JTextField();
        courseTitle.setPreferredSize(new Dimension(440,50));
        courseTitle.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        courseTitle.setForeground(Color.white);
        courseTitle.setCaretColor(Color.white);
        courseTitle.setBorder(Design_Assets.IndigoBorder.border);
        courseTitle.setFont(new Font("Monospaced", Font.BOLD, 22));

        courseTitleContainer.add(courseTitle);



        JPanel courseDescriptionContainer = new JPanel();
        courseDescriptionContainer.setPreferredSize(new Dimension(480,250));
        courseDescriptionContainer.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        courseDescriptionContainer.setLayout(new FlowLayout(FlowLayout.LEFT ,15,15));
        addCourseFrame.add(courseDescriptionContainer);

        JLabel courseDescriptionLabel = new JLabel("Course Description");
        courseDescriptionLabel.setFont( new Font("Monospaced", Font.BOLD, 22));
        courseDescriptionLabel.setPreferredSize(new Dimension(430,40));
        courseDescriptionContainer.add(courseDescriptionLabel);
        courseDescriptionLabel.setForeground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b));


        JTextArea courseDescription = new JTextArea();
        courseDescription.setCaretColor(Color.white);
        courseDescription.setBorder(Design_Assets.IndigoBorder.border);
        courseDescription.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        courseDescription.setPreferredSize(new Dimension(430,180));
        courseDescription.setFont( new Font("Monospaced", Font.BOLD, 22));
        courseDescription.setLineWrap(true);
        courseDescription.setWrapStyleWord(true);
        courseDescription.setForeground(Color.white);
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

        JButton courseAddButton = new JButton();
        courseAddButton.setPreferredSize(new Dimension(450 ,40));
        courseAddButton.setFont( new Font("Monospaced", Font.BOLD, 22));
        courseAddButton.setText("Add course");
        courseAddButton.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        courseAddButton.setForeground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b));
        courseAddButton.setBorder(Design_Assets.IndigoBorder.border);


        addCourseFrame.add(courseAddButton);
        courseAddButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              addCourseFrame.setVisible(false);
            }
        });





























        addCourseFrame.setVisible(true);
    }
}
