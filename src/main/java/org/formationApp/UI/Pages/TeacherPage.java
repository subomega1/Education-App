package org.formationApp.UI.Pages;

import org.formationApp.UI.Theme_Resources.Design_Assets;
import org.formationApp.UI.components.AddCourseComponent;
import org.formationApp.UI.components.CourseGotCardComponent;
import org.formationApp.contexs.Contex;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherPage {
    public TeacherPage(Frame frame){

        frame.setLayout(new BorderLayout());

        //side panel
        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(150,800));
        sidePanel.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        sidePanel.setLayout(new BorderLayout());
        sidePanel.setBorder(BorderFactory.createMatteBorder(0,0,0,4, new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b)));
        frame.add(sidePanel,BorderLayout.WEST);

        // sub panel to contain Home and My course buttons
        JPanel subSidePanel = new JPanel();
        subSidePanel.setPreferredSize(new Dimension(150,320));
        subSidePanel.setLayout(new FlowLayout(FlowLayout.CENTER ,10,20));
        subSidePanel.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        sidePanel.add(subSidePanel);

        //logout container
        JPanel logoutContainer = new JPanel();
        logoutContainer.setPreferredSize(new Dimension(150,100));
        logoutContainer.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));

        //  panel for  position purpose
        JPanel centrePanel = new JPanel();
        centrePanel.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        centrePanel.setLayout(new BorderLayout());
        frame.add(centrePanel,BorderLayout.CENTER);

        //header container
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        headerPanel.setPreferredSize(new Dimension(900,100));
        headerPanel.setBorder(BorderFactory.createMatteBorder(0,0,4,0, new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b)));
        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        centrePanel.add(headerPanel,BorderLayout.NORTH);

        // title 1 color white
        JLabel title1 = new JLabel("Welcome ");
        title1.setForeground(new Color(238,238,238));
        title1.setFont( new Font("Monospaced", Font.BOLD, 50));
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        title1.setVerticalAlignment(SwingConstants.CENTER);
        headerPanel.add(title1);

        //title2 color indigo
        JLabel title2 = new JLabel(Contex.userModel.getUsername());
        title2.setFont( new Font("Monospaced", Font.BOLD, 50));
        title2.setForeground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b));
        headerPanel.add(title2);

        //Course pane
        JPanel courseContainer = new JPanel();
        courseContainer.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        courseContainer.setLayout(new FlowLayout(FlowLayout.LEFT,40,20));
        Dimension  courseContainerDimension = new Dimension(900,500);
        courseContainer.setPreferredSize(courseContainerDimension);
        centrePanel.add(courseContainer,BorderLayout.CENTER);
        //load content
        try {
            new CourseGotCardComponent(courseContainer,courseContainerDimension);

        } catch (Exception e) {
            courseContainer.removeAll();
            JLabel videMsg = new JLabel(e.getMessage());
            videMsg.setFont( new Font("Monospaced", Font.BOLD, 50));
            videMsg.setForeground(Color.white);
            courseContainer.add(videMsg);

        }finally {

           courseContainer.revalidate();
           courseContainer.repaint();
       }

        //dynamic scroll for more than 6 courses
        JScrollPane scrollPane = new JScrollPane(courseContainer);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        centrePanel.add(scrollPane, BorderLayout.CENTER);

        //side pane button
        JButton textButton1 = new JButton("Add Course");
        textButton1.setForeground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b));
        textButton1.setPreferredSize(new Dimension(150,50));
        textButton1.setFont(new Font("Monospaced", Font.BOLD, 19));
        textButton1.setBorderPainted(false);
        textButton1.setContentAreaFilled(false);
        textButton1.setFocusPainted(false);
        textButton1.setOpaque(false);
        subSidePanel.add(textButton1);
        textButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new AddCourseComponent();
            }
        });


        //to refresh content
        JButton refrecshButton = new JButton("Refresh");
        refrecshButton.setForeground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b));
        refrecshButton.setPreferredSize(new Dimension(150,50));
        refrecshButton.setFont(new Font("Monospaced", Font.BOLD, 19));
        refrecshButton.setBorderPainted(false);
        refrecshButton.setContentAreaFilled(false);
        refrecshButton.setFocusPainted(false);
        refrecshButton.setOpaque(false);
        subSidePanel.add(refrecshButton);
        refrecshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    courseContainer.removeAll();
                    new CourseGotCardComponent(courseContainer,courseContainerDimension);

                } catch (Exception error) {
                    courseContainer.removeAll();
                    JLabel videMsg = new JLabel(error.getMessage());
                    videMsg.setFont( new Font("Monospaced", Font.BOLD, 50));
                    videMsg.setForeground(Color.white);
                    courseContainer.add(videMsg);

                }finally {
                    courseContainer.revalidate();
                    courseContainer.repaint();
                }
            }
        });

        //logout
        JButton logoutButton = new JButton("logout");
        logoutButton.setForeground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b));
        logoutButton.setPreferredSize(new Dimension(150,110));
        logoutButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setFocusPainted(false);
        logoutButton.setOpaque(false);
        logoutContainer.add(logoutButton,BorderLayout.SOUTH);
        sidePanel.add(logoutContainer,BorderLayout.SOUTH);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Contex.accepted= false;
                frame.remove(centrePanel);
                frame.remove(sidePanel);
                System.gc();
                new LoginPage(frame);
                frame.revalidate();
                frame.repaint();

            }
        });
    }
}
