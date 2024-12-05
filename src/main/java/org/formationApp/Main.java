package org.formationApp;

import org.formationApp.UI.MainFrame;
import org.formationApp.UI.Pages.LoginPage;

public class Main {
    public static void main(String[] args) throws Exception {

        MainFrame mainFrame = new MainFrame();
        new LoginPage(mainFrame);






        mainFrame.setVisible(true);
    }
}