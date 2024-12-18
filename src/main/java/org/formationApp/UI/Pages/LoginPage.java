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
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(400, 40));
        emailField.setBorder(Design_Assets.IndigoBorder.border);
        emailField.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        emailField.setForeground(Color.gray); // Set text color for better visibility
        emailField.setCaretColor(Color.white);
        emailField.setFont(new Font("Monospaced", Font.BOLD, 20));
        emailField.setText("Email");
        emailField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (emailField.getText().equals("Email")) {
                    emailField.setText("");
                    emailField.setForeground(Color.white);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (emailField.getText().isEmpty()) {
                    emailField.setForeground(Color.gray);
                    emailField.setText("Email");

                }
            }
        });
        loginFormContainer.add(emailField);

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

        //sumbit Button Container
        JPanel sumbitButtonContainer = new JPanel();
        sumbitButtonContainer.setPreferredSize(new Dimension(400,180));
        sumbitButtonContainer.setLayout(new FlowLayout(FlowLayout.LEFT,0,30));
        sumbitButtonContainer.setBackground(new Color(Design_Assets.BlackColor.r,Design_Assets.BlackColor.g,Design_Assets.BlackColor.b));
        loginFormContainer.add(sumbitButtonContainer);


        //Sumbit Button
        JButton sumbitButton = new JButton("LOGIN");
        sumbitButton.setPreferredSize(new Dimension(400, 40));
        sumbitButton.setBorder(Design_Assets.IndigoBorder.border);
        sumbitButton.setBackground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b)); // Set a visible background color
        sumbitButton.setForeground(Color.WHITE); // Set a contrasting text color
        sumbitButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        sumbitButtonContainer.add(sumbitButton);
        sumbitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                    try {
                        errorMsg.setText("");
                        errorMsg.repaint();

                if (emailField.getForeground()  != Color.WHITE || passwordField.getForeground() != Color.WHITE){
                    throw  new Exception("please fill the email and password fields");
                }
                            String email = emailField.getText();
                            String passwordString = new String(passwordField.getPassword());
                            AuthController.login(email,passwordString );

                            if (Contex.accepted && Contex.userModel.getRole().equals("student") ) {
                                frame.remove(centrePanel);
                                System.gc();
                                new StudentPage(frame);

                            }
                            else if (Contex.accepted && Contex.userModel.getRole().equals("teacher")){
                                frame.remove(centrePanel);
                                System.gc();
                                new TeacherPage(frame);

                            }
                        } catch (Exception Error) {
                            errorMsg.setText(Error.getMessage());
                            errorMsg.repaint();

                        }finally {
                        frame.revalidate();
                        frame.repaint();
                    }

                }







        });
        //Redirect to Sign Up Page
        JButton redirectToSignUp = new JButton();
        redirectToSignUp.setPreferredSize(new Dimension(400,30));
        redirectToSignUp.setText("You have no account? Sign Up");
        redirectToSignUp.setFont(new Font("Monospaced", Font.BOLD, 21));
        redirectToSignUp.setForeground(new Color(Design_Assets.IndigoColor.r,Design_Assets.IndigoColor.g,Design_Assets.IndigoColor.b));
        redirectToSignUp.setBorderPainted(false);
        redirectToSignUp.setContentAreaFilled(false);
        redirectToSignUp.setFocusPainted(false);
        redirectToSignUp.setOpaque(false);
        sumbitButtonContainer.add(redirectToSignUp);
        redirectToSignUp.addActionListener(e -> {
            frame.remove(centrePanel);
            System.gc();
            new SignupPage(frame);
            frame.revalidate();
            frame.repaint();
        });


    }

}
