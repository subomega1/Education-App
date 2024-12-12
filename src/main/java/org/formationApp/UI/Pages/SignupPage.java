package org.formationApp.UI.Pages;

import org.formationApp.contexs.Contex;
import org.formationApp.UI.Theme_Resources.Design_Assets;
import org.formationApp.controllers.AuthController;
import org.formationApp.utils.HashFunction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupPage {

    public SignupPage(Frame frame) {

        // Main panel (centered in the Frame)
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        JPanel centrePanel = new JPanel();
        centrePanel.setBackground(new Color(Design_Assets.BlackColor.r, Design_Assets.BlackColor.g, Design_Assets.BlackColor.b));
        centrePanel.setPreferredSize(new Dimension(600, 1200));
        centrePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        frame.add(centrePanel);

        // Sub-panel for centrePanel (centered in centrePanel)
        JPanel subPanel = new JPanel();
        subPanel.setBackground(new Color(Design_Assets.BlackColor.r, Design_Assets.BlackColor.g, Design_Assets.BlackColor.b));
        subPanel.setPreferredSize(new Dimension(600, 1200));
        subPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        centrePanel.add(subPanel);

        // Signup form container (centered in subPanel)
        JPanel signupFormContainer = new JPanel();
        signupFormContainer.setPreferredSize(new Dimension(500, 1200));
        signupFormContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
        signupFormContainer.setBackground(new Color(Design_Assets.BlackColor.r, Design_Assets.BlackColor.g, Design_Assets.BlackColor.b));
        subPanel.add(signupFormContainer);

        // Signup title
        JLabel signupTitle = new JLabel("Sign Up");
        signupTitle.setFont(new Font("Monospaced", Font.BOLD, 60));
        signupTitle.setForeground(new Color(Design_Assets.IndigoColor.r, Design_Assets.IndigoColor.g, Design_Assets.IndigoColor.b));
        signupFormContainer.add(signupTitle);

        // Error message
        JLabel errorMsg = new JLabel();
        errorMsg.setText("");
        errorMsg.setFont(new Font("Monospaced", Font.BOLD, 19));
        errorMsg.setForeground(Color.red);
        errorMsg.setPreferredSize(new Dimension(500, 30));
        errorMsg.setHorizontalAlignment(JLabel.CENTER);
        signupFormContainer.add(errorMsg);

        // Username field
        JTextField usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(400, 40));
        usernameField.setBorder(Design_Assets.IndigoBorder.border);
        usernameField.setBackground(new Color(Design_Assets.BlackColor.r, Design_Assets.BlackColor.g, Design_Assets.BlackColor.b));
        usernameField.setForeground(Color.gray);
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
        signupFormContainer.add(usernameField);

        // Email field
        JTextField emailField = new JTextField();
        emailField.setPreferredSize(new Dimension(400, 40));
        emailField.setBorder(Design_Assets.IndigoBorder.border);
        emailField.setBackground(new Color(Design_Assets.BlackColor.r, Design_Assets.BlackColor.g, Design_Assets.BlackColor.b));
        emailField.setForeground(Color.gray);
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
        signupFormContainer.add(emailField);

        // Password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(400, 40));
        passwordField.setBorder(Design_Assets.IndigoBorder.border);
        passwordField.setBackground(new Color(Design_Assets.BlackColor.r, Design_Assets.BlackColor.g, Design_Assets.BlackColor.b));
        passwordField.setForeground(Color.gray);
        passwordField.setCaretColor(Color.white);
        passwordField.setFont(new Font("Monospaced", Font.BOLD, 20));
        passwordField.setEchoChar((char) 0);
        passwordField.setText("Password");
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(passwordField.getPassword()).equals("Password")) {
                    passwordField.setText("");
                    passwordField.setForeground(Color.WHITE);
                    passwordField.setEchoChar('*');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (passwordField.getPassword().length == 0) {
                    passwordField.setForeground(Color.GRAY);
                    passwordField.setText("Password");
                    passwordField.setEchoChar((char) 0);
                }
            }
        });
        signupFormContainer.add(passwordField);

        // confirm Password field
        JPasswordField confirmPassword = new JPasswordField();
        confirmPassword.setPreferredSize(new Dimension(400, 40));
        confirmPassword.setBorder(Design_Assets.IndigoBorder.border);
        confirmPassword.setBackground(new Color(Design_Assets.BlackColor.r, Design_Assets.BlackColor.g, Design_Assets.BlackColor.b));
        confirmPassword.setForeground(Color.gray);
        confirmPassword.setCaretColor(Color.white);
        confirmPassword.setFont(new Font("Monospaced", Font.BOLD, 20));
        confirmPassword.setEchoChar((char) 0);
        confirmPassword.setText("Confirm Password");
        confirmPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(confirmPassword.getPassword()).equals("Confirm Password")) {
                    confirmPassword.setText("");
                    confirmPassword.setForeground(Color.WHITE);
                    confirmPassword.setEchoChar('*');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (confirmPassword.getPassword().length == 0) {
                    confirmPassword.setForeground(Color.GRAY);
                    confirmPassword.setText("Confirm Password");
                    confirmPassword.setEchoChar((char) 0);
                }
            }
        });
        signupFormContainer.add(confirmPassword);
        // Role chooser
        String[] roles = {"Pick role", "student", "teacher"};
        JComboBox<String> rolesOption = new JComboBox<>(roles);
        rolesOption.setPreferredSize(new Dimension(400, 40));
        rolesOption.setBackground(new Color(Design_Assets.BlackColor.r, Design_Assets.BlackColor.g, Design_Assets.BlackColor.b));
        rolesOption.setFont(new Font("Monospaced", Font.BOLD, 20));
        rolesOption.setForeground(Color.WHITE);
        rolesOption.setBorder(null);




        signupFormContainer.add(rolesOption);


        // Submit button container
        JPanel submitButtonContainer = new JPanel();
        submitButtonContainer.setPreferredSize(new Dimension(400, 180));
        submitButtonContainer.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 20));
        submitButtonContainer.setBackground(new Color(Design_Assets.BlackColor.r, Design_Assets.BlackColor.g, Design_Assets.BlackColor.b));
        signupFormContainer.add(submitButtonContainer);

        //Sumbit Button
        JButton submitButton = new JButton("SIGN UP");
        submitButton.setPreferredSize(new Dimension(400, 40));
        submitButton.setBorder(Design_Assets.IndigoBorder.border);
        submitButton.setBackground(new Color(Design_Assets.IndigoColor.r, Design_Assets.IndigoColor.g, Design_Assets.IndigoColor.b));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Monospaced", Font.BOLD, 20));
        submitButtonContainer.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    errorMsg.setText("");
                    errorMsg.repaint();

                    if (usernameField.getForeground() != Color.WHITE ||
                            emailField.getForeground() != Color.WHITE ||
                            confirmPassword.getForeground() != Color.WHITE) {
                        throw new Exception("Please fill in all fields.");
                    }if (rolesOption.getSelectedItem().equals("Pick role")){
                        throw new Exception("please select a role");
                    }
                    String passwordEntred = new String(passwordField.getPassword());
                    String confirmedPassword = new String(confirmPassword.getPassword()) ;

                    if (!passwordEntred.equals(confirmedPassword)){
                        throw new Exception("the Password do not match");
                    }

                    String username = usernameField.getText();
                    String email = emailField.getText();
                    String role = rolesOption.getSelectedItem().toString();



                    AuthController.signUp(email,username , passwordEntred,confirmedPassword,role );
                    if (AuthController.createdSucc){
                        //this frame to display error msg
                        JFrame frame = new JFrame("Error");
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        frame.setSize(400, 200);
                        frame.setLocationRelativeTo(null); // Center the frame on the screen
                        frame.setIconImage(new ImageIcon("src/main/java/org/formationApp/UI/Theme_Resources/unitedPic.png").getImage());

                        // Create a custom panel for the message
                        JPanel panel = new JPanel();
                        panel.setBackground(new Color(Design_Assets.BlackColor.r, Design_Assets.BlackColor.g, Design_Assets.BlackColor.b));
                        panel.setLayout(new BorderLayout());

                        // Create a label for the error message
                        JLabel messageLabel = new JLabel("Account created", SwingConstants.CENTER);
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

                        AuthController.createdSucc=false;
                    }

                   frame.remove(centrePanel);
                    System.gc();
                    new LoginPage(frame);

                } catch (Exception error) {
                    errorMsg.setText(error.getMessage());
                    errorMsg.repaint();

                }finally {
                    frame.revalidate();
                    frame.repaint();
                }
            }
        });

        JButton redirectToLogin = new JButton("Already have an account? Log In");
        redirectToLogin.setPreferredSize(new Dimension(400, 30));
        redirectToLogin.setFont(new Font("Monospaced", Font.BOLD, 19));
        redirectToLogin.setForeground(new Color(Design_Assets.IndigoColor.r, Design_Assets.IndigoColor.g, Design_Assets.IndigoColor.b));
        redirectToLogin.setBorderPainted(false);
        redirectToLogin.setContentAreaFilled(false);
        redirectToLogin.setFocusPainted(false);
        redirectToLogin.setOpaque(false);
        submitButtonContainer.add(redirectToLogin);

        redirectToLogin.addActionListener(e -> {
            frame.remove(centrePanel);
            System.gc();
            new LoginPage(frame);
            frame.revalidate();
            frame.repaint();
        });
    }
}
