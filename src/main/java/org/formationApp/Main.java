package org.formationApp;

import org.formationApp.UI.MainFrame;
import org.formationApp.UI.Pages.LoginPage;
import org.formationApp.UI.Pages.StudentPage;

public class Main {
    public static void main(String[] args) throws Exception {

        MainFrame mainFrame = new MainFrame();
        LoginPage loginPage =new LoginPage(mainFrame);
        //new StudentPage(mainFrame);





        mainFrame.setVisible(true);
    }
}