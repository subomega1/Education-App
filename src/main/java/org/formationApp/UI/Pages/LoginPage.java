package org.formationApp.UI.Pages;

import org.formationApp.contexs.Contex;
import org.formationApp.UI.Theme_Resources.Design_Assets;
import org.formationApp.controllers.AuthController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage {
    //Contex contex;

    public LoginPage(Frame frame)  {


        // Note: This panel is used for layout and positioning purposes.
        // Main panel ( centred in  the Frame)
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));


        JPanel centrePanel = new JPanel();
        centrePanel.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        centrePanel.setPreferredSize(new Dimension(600, 800));
        centrePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // FlowLayout for vertical layout
        frame.add(centrePanel);

        //Note: This panel is used for layout and positioning purposes.
        //// Sub-panel for centrePanel (centred in centrePanel)
        JPanel subPanel = new JPanel();
        subPanel.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        subPanel.setPreferredSize(new Dimension(600, 800));
        subPanel.setLayout(new FlowLayout(FlowLayout.CENTER ,0,40)); // GridBagLayout for centering components
        centrePanel.add(subPanel);

        //Note: This panel is used for layout and positioning purposes.
        // loginFormContainer (centered in subPanel)
        JPanel loginFormContainer = new JPanel();
        loginFormContainer.setPreferredSize(new Dimension(500, 650)); // Adjust dimensions as needed
        loginFormContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
        loginFormContainer.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        subPanel.add(loginFormContainer); // loginFormContainer is automatically centered due to GridBagLayout in subPanel






        // Login title
        JLabel loginTitle = new JLabel();
        loginTitle.setText("Login");
        loginTitle.setFont(new Font("Monospaced", Font.BOLD, 60));
        loginTitle.setVerticalAlignment(JLabel.CENTER);
        loginTitle.setForeground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b));
        loginFormContainer.add(loginTitle);


        //Error msg
        JLabel errorMsg = new JLabel();
        errorMsg.setText("");
        errorMsg.setFont(new Font("Monospaced", Font.BOLD, 15));
        errorMsg.setForeground(Color.red);
        errorMsg.setPreferredSize(new Dimension(500,25));
        errorMsg.setHorizontalAlignment(JLabel.CENTER);
        loginFormContainer.add(errorMsg);

        // UsernameField
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(400, 40));
        usernameField.setBorder(Design_Assets.IndigoBorder.border);
        usernameField.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        usernameField.setForeground(Color.gray); // Set text color for better visibility
        usernameField.setCaretColor(Color.white);
        usernameField.setFont(new Font("Monospaced", Font.BOLD, 20));
        usernameField.setText("Username");
        usernameField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (usernameField.getText().equals("Username")) {
                    usernameField.setText("");
                    usernameField.setForeground(Color.white);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (usernameField.getText().isEmpty()) {
                    usernameField.setForeground(Color.gray);
                    usernameField.setText("Username");

                }
            }
        });
        loginFormContainer.add(usernameField);

        // PasswordField
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(400, 40));
        passwordField.setBorder(Design_Assets.IndigoBorder.border);
        passwordField.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        passwordField.setForeground(Color.gray);
        passwordField.setCaretColor(Color.white);
        passwordField.setFont(new Font("Monospaced", Font.BOLD, 20));
        passwordField.setEchoChar((char) 0); // Default character to hide text
        passwordField.setText("Password"); // Set initial placeholder text

        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(passwordField.getPassword()).equals("Password")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.WHITE);
                    passwordField.setEchoChar('*'); // Enable masking
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getPassword().length == 0) {
                    passwordField.setForeground(Color.GRAY);
                    passwordField.setText("Password");
                    passwordField.setEchoChar((char) 0); // Disable masking for placeholder
                }
            }
        });
        loginFormContainer.add(passwordField);

        JButton sumbitButton = new JButton("LOGIN");
        sumbitButton.setPreferredSize(new Dimension(400, 40));
        sumbitButton.setBorder(Design_Assets.IndigoBorder.border);
        sumbitButton.setBackground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b)); // Set a visible background color
        sumbitButton.setForeground(Color.WHITE); // Set a contrasting text color
        sumbitButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        loginFormContainer.add(sumbitButton);
        sumbitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                    try {
                        errorMsg.setText("");
                        errorMsg.repaint();

                if (usernameField.getForeground()  != Color.WHITE || passwordField.getForeground() != Color.WHITE){
                    throw  new Exception("please fill the username and password fields");
                }
                            String username = usernameField.getText();
                            char[] password = passwordField.getPassword();
                            String passwordString = new String(password); // Convert char[] to String if needed
                            System.out.println("Entered Username: " + username );
                            System.out.println("Entered Password: " + passwordString);
                            AuthController.login(username,passwordString );

                            if (Contex.accepted && Contex.userModel.getRole().equals("student") ) {
                               // if ()
                                frame.remove(centrePanel);
                                System.gc();
                                new StudentPage(frame);
                                frame.revalidate();
                                frame.repaint();
                            }
                        } catch (Exception Error) {

                            errorMsg.setText(Error.getMessage());
                            errorMsg.repaint();
                            System.out.println( Error.getMessage());

                        }

                }






        });



    }

}
