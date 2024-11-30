package org.formationApp;

import org.formationApp.UI.MainFrame;
import org.formationApp.UI.Pages.Login;

public class Main {
    public static void main(String[] args) {

        MainFrame mainFrame = new MainFrame();
        new Login(mainFrame);






        mainFrame.setVisible(true);
    }
}