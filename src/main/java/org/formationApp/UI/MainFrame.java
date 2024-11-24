package org.formationApp.UI;

import javax.swing.*;
import java.awt.*;

public class MainFrame {
    final String  title="Education.io";
    final int width =1200 ;
    final  int height=800;
    static class  BlackColor{
       final static int  r= 39,g=38,b=44;
    }

    public void  createFrame(){
        JFrame frame = new JFrame(title);
        frame.setSize(width,height);
        frame.getContentPane().setBackground(new Color(BlackColor.r,BlackColor.g,BlackColor.b));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
