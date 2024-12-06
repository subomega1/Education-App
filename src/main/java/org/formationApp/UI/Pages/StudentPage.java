package org.formationApp.UI.Pages;

import org.formationApp.UI.Theme_Resources.Design_Assets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentPage {


    public StudentPage(Frame frame){
        frame.setLayout(new BorderLayout());
        JPanel sidePanel = new JPanel();
        sidePanel.setPreferredSize(new Dimension(150,800));
        sidePanel.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        sidePanel.setLayout(new BorderLayout());
        sidePanel.setBorder(BorderFactory.createMatteBorder(0,0,0,4, new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b)));
        frame.add(sidePanel,BorderLayout.WEST);

        JPanel subSidePanel = new JPanel();
        subSidePanel.setPreferredSize(new Dimension(150,320));
        subSidePanel.setLayout(new FlowLayout(FlowLayout.CENTER ,10,10));
        subSidePanel.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));



        JPanel logoutContainer = new JPanel();
        logoutContainer.setPreferredSize(new Dimension(150,100));
        logoutContainer.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
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






        JPanel centrePanel = new JPanel();
        centrePanel.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        centrePanel.setLayout(new BorderLayout());
        frame.add(centrePanel,BorderLayout.CENTER);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        headerPanel.setPreferredSize(new Dimension(900,100));
        headerPanel.setBorder(BorderFactory.createMatteBorder(0,0,4,0, new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b)));
        centrePanel.add(headerPanel,BorderLayout.NORTH);


        JLabel jLabel = new JLabel("Welcome sfarahmed");
        jLabel.setForeground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b));
        jLabel.setFont( new Font("Monospaced", Font.BOLD, 50));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setVerticalAlignment(SwingConstants.CENTER);

        headerPanel.add(jLabel);

        JPanel courseContainer = new JPanel();
        courseContainer.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        courseContainer.setLayout(new FlowLayout(FlowLayout.LEFT,15,20));
        courseContainer.setPreferredSize(new Dimension(900,500));
        centrePanel.add(courseContainer,BorderLayout.CENTER);

        JPanel panel4 = new JPanel();
        panel4.setBackground(new Color(244,241,236));
        panel4.setPreferredSize(new Dimension(260,250));
        courseContainer.add(panel4);

        JPanel panel9 = new JPanel();
        panel9.setPreferredSize(new Dimension(new Dimension(260,190)));
        panel9.setBackground(Color.CYAN);
        panel4.add(panel9,BorderLayout.SOUTH);

        JPanel panel51 = new JPanel();
        panel51.setPreferredSize(new Dimension(260,80));
        panel51.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));
        panel9.add(panel51,BorderLayout.SOUTH);

        JLabel titre = new JLabel("SQL introduction\n aklkl ");
        titre.setPreferredSize(new Dimension(210,80));
        titre.setFont( new Font("Monospaced", Font.BOLD, 15));
        panel51.add(titre);

        JTextArea disc = new JTextArea("Discription:\nlearn the basic of sql and master it");
        disc.setPreferredSize(new Dimension(250,110));
        disc.setFont( new Font("Monospaced", Font.BOLD, 14));
        disc.setLineWrap(true);
        disc.setWrapStyleWord(true);
        panel9.add(disc);

        JPanel panel598 = new JPanel();
        panel598.setPreferredSize(new Dimension(280,70));
        panel598.setLayout(new FlowLayout(FlowLayout.RIGHT,20,10));
        panel4.add(panel598,BorderLayout.NORTH);

        JButton button6 = new JButton();
        button6.setPreferredSize(new Dimension(100,30));
        button6.setFont( new Font("Monospaced", Font.BOLD, 14));
        button6.setText("add");
        panel598.add(button6);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                courseContainer.remove(panel4);
                courseContainer.repaint();
            }
        });




        JPanel panel5 = new JPanel();
        panel5.setBackground(new Color(244,241,236));
        panel5.setPreferredSize(new Dimension(260,250));
        courseContainer.add(panel5);

        JPanel panel6 = new JPanel();
        panel6.setBackground(Color.magenta);
        panel6.setPreferredSize(new Dimension(260,250));
        courseContainer.add(panel6);

        JPanel panel7 = new JPanel();
        panel7.setBackground(new Color(131,124,128));
        panel7.setPreferredSize(new Dimension(260,250));
        panel7.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.BLACK));
        courseContainer.add(panel7);


        //JScrollPane scrollPane = new JScrollPane(panel3);

        JScrollPane scrollPane = new JScrollPane(courseContainer);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        // Add the JScrollPane to panel1
        centrePanel.add(scrollPane, BorderLayout.CENTER);

        JButton textButton1 = new JButton("My course");
        textButton1.setForeground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b));
        textButton1.setPreferredSize(new Dimension(150,50));
        textButton1.setFont(new Font("Monospaced", Font.BOLD, 20));
        textButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                courseContainer.removeAll();
                courseContainer.repaint();

            }
        });

        textButton1.setBorderPainted(false);
        textButton1.setContentAreaFilled(false);
        textButton1.setFocusPainted(false);
        textButton1.setOpaque(false);

        subSidePanel.add(textButton1);
        JButton HomeButton = new JButton("Home");

        HomeButton.setForeground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b));
        HomeButton.setPreferredSize(new Dimension(150,50));

        HomeButton.setFont(new Font("Monospaced", Font.BOLD, 20));

        HomeButton.setBorderPainted(false);
        HomeButton.setContentAreaFilled(false);
        HomeButton.setFocusPainted(false);
        HomeButton.setOpaque(false);

        sidePanel.add(subSidePanel,BorderLayout.NORTH);
        subSidePanel.add(HomeButton);
        System.out.println(subSidePanel.getBackground());








    }


}
