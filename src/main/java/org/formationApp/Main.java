package org.formationApp;

import org.formationApp.DB.ConnectToDB;
import org.formationApp.UI.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
        MainFrame mainFrame = new MainFrame();
        mainFrame.createFrame();

    }
}