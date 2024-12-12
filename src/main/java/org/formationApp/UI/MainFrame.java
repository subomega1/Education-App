package org.formationApp.UI;

import org.formationApp.UI.Theme_Resources.Design_Assets;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends  JFrame{
    final String  title="United.io";
    final int width =1100 ;
    final  int height=800;

        public MainFrame(){
            this.setTitle(title);
            this.setSize(width,height);
            this.setLocationRelativeTo(null);
            this.getContentPane().setBackground(new Color(Design_Assets.BlackColor.r, Design_Assets.BlackColor.g, Design_Assets.BlackColor.b));
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setIconImage(new ImageIcon("src/main/java/org/formationApp/UI/Theme_Resources/unitedPic.png").getImage());


        }




}
