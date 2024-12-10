package org.formationApp.UI.components;

import org.formationApp.UI.Theme_Resources.Design_Assets;
import org.formationApp.controllers.AddCourseController;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class AddCourseComponent {
    public AddCourseComponent(){
        JFrame addCourseFrame = new JFrame("Add Course");
        addCourseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        courseTitle.setText("Course Title");
        courseTitle.setForeground(Color.GRAY);
        courseTitle.setCaretColor(Color.white);
        courseTitle.setBorder(Design_Assets.IndigoBorder.border);
        courseTitle.setFont(new Font("Monospaced", Font.BOLD, 22));
        courseTitle.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (courseTitle.getText().equals("Course Title")){
                    courseTitle.setForeground(Color.white);
                    courseTitle.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (courseTitle.getText().isEmpty()){
                    courseTitle.setText("Course Title");
                    courseTitle.setForeground(Color.GRAY);
                }
            }
        });

        courseTitleContainer.add(courseTitle);



        JPanel courseDescriptionContainer = new JPanel();
        courseDescriptionContainer.setPreferredSize(new Dimension(480,250));
        courseDescriptionContainer.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        courseDescriptionContainer.setLayout(new FlowLayout(FlowLayout.LEFT ,15,15));
        addCourseFrame.add(courseDescriptionContainer);

        JLabel courseDescriptionLabel = new JLabel("Course Description");
        courseDescriptionLabel.setFont( new Font("Monospaced", Font.BOLD, 22));
        courseDescriptionLabel.setPreferredSize(new Dimension(450,40));
        courseDescriptionContainer.add(courseDescriptionLabel);
        courseDescriptionLabel.setForeground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b));


        JTextArea courseDescription = new JTextArea();
        courseDescription.setCaretColor(Color.white);
        courseDescription.setForeground(Color.GRAY);
        courseDescription.setText("Course Description");
        courseDescription.setBorder(Design_Assets.IndigoBorder.border);
        courseDescription.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        courseDescription.setPreferredSize(new Dimension(450,180));
        courseDescription.setFont( new Font("Monospaced", Font.BOLD, 22));
        courseDescription.setLineWrap(true);
        courseDescription.setWrapStyleWord(true);
        courseDescriptionContainer.add(courseDescription);
        courseDescription.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (courseDescription.getText().equals("Course Description")){
                    courseDescription.setText("");
                    courseDescription.setForeground(Color.white);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (courseDescription.getText().isEmpty()){
                    courseDescription.setText("Course Description");
                    courseDescription.setForeground(Color.GRAY);
                }
            }
        });

        int maxDescriptionLines = 4;
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

            private void checkLines() {
                String text = courseDescription.getText();
                String[] lines = text.split("\n");
                int lineCount = 0;
                int textAreaWidth = courseDescription.getWidth();
                FontMetrics metrics = courseDescription.getFontMetrics(courseDescription.getFont());

                for (String line : lines) {
                    int lineWidth = metrics.stringWidth(line);
                    if (lineWidth > textAreaWidth) {
                        int wrappedLines = (int) Math.ceil((double) lineWidth / textAreaWidth);
                        lineCount += wrappedLines;
                    } else {
                        lineCount++;
                    }
                }

                // Add the number of lines from the split text
                lineCount += lines.length - 1; // Add the number of newline characters

                while (lineCount > maxDescriptionLines) {
                    courseDescription.setCaretPosition(courseDescription.getDocument().getLength());

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
              //addCourseFrame.setVisible(false);
                //System.out.println(courseTitle.getText());
                //System.out.println(courseDescription.getText());
                try {
                    if (courseTitle.getForeground() == Color.GRAY || courseDescription.getForeground() == Color.GRAY){
                        throw new Exception("please fill all fields");
                    }else {
                        AddCourseController.addCourseTeacher(courseTitle.getText(),courseDescription.getText());
                        if (AddCourseController.addedSucc){
                            addCourseFrame.dispose();
                        }
                    }

                } catch (Exception ex) {

                    JFrame frame = new JFrame("Error");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setSize(400, 200);
                    frame.setLocationRelativeTo(null); // Center the frame on the screen

                    // Create a custom panel for the message
                    JPanel panel = new JPanel();
                    panel.setBackground(new Color(Design_Assets.BlackColor.r, Design_Assets.BlackColor.g, Design_Assets.BlackColor.b));
                    panel.setLayout(new BorderLayout());

                    // Create a label for the error message
                    JLabel messageLabel = new JLabel(ex.getMessage(), SwingConstants.CENTER);
                    messageLabel.setFont(new Font("Monospaced", Font.BOLD, 22));
                    messageLabel.setForeground(Color.WHITE); // Set text color to white for better visibility
                    panel.add(messageLabel, BorderLayout.CENTER);

                    // Create a button to close the dialog
                    JButton closeButton = new JButton("Close");
                    closeButton.setForeground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b));
                    closeButton.setFont(new Font("Monospaced", Font.BOLD, 22));
                    closeButton.setBackground(new Color(Design_Assets.BlackColor.r, Design_Assets.BlackColor.g, Design_Assets.BlackColor.b));
                    closeButton.setPreferredSize(new Dimension(280,40));
                    closeButton.setBorder(Design_Assets.IndigoBorder.border);
                    closeButton.addActionListener(event -> frame.dispose());
                    panel.add(closeButton, BorderLayout.SOUTH);

                    // Add the panel to the frame
                    frame.setContentPane(panel);
                    frame.setVisible(true);
                }

            }
        });





























        addCourseFrame.setVisible(true);
    }
}
