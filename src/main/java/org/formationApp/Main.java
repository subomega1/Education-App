package org.formationApp;

import org.formationApp.UI.MainFrame;
import org.formationApp.UI.Pages.LoginPage;
import org.formationApp.UI.Pages.SignupPage;
import org.formationApp.UI.Pages.StudentPage;
import org.formationApp.UI.Pages.TeacherPage;

public class Main {
    public static void main(String[] args) throws Exception {

        MainFrame mainFrame = new MainFrame();
        new LoginPage(mainFrame);
        //new StudentPage(mainFrame);
        //new TeacherPage(mainFrame);
        //new SignupPage(mainFrame);





        mainFrame.setVisible(true);
    }
}