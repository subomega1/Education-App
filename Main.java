import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("gui test");
        frame.setSize(1020,600);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(39,38,44));
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(150,600));
        panel.setBackground(Color.CYAN);
        panel.setLayout(new BorderLayout());
        frame.add(panel,BorderLayout.WEST);

        JPanel jPanel6 = new JPanel();
        jPanel6.setPreferredSize(new Dimension(150,320));
        jPanel6.setLayout(new FlowLayout(FlowLayout.CENTER ,10,10));

        JButton textButton = new JButton("Home");
        textButton.setPreferredSize(new Dimension(150,50));
        textButton.setForeground(Color.gray);
        textButton.setFont(new Font("Monospaced", Font.BOLD, 20));

        textButton.setBorderPainted(false);
        textButton.setContentAreaFilled(false);
        textButton.setFocusPainted(false);
        textButton.setOpaque(false);



        panel.add(jPanel6,BorderLayout.NORTH);
        System.out.println(jPanel6.getBackground());

        JPanel jPanel8 = new JPanel();
        jPanel8.setPreferredSize(new Dimension(150,100));
        JButton textButton2 = new JButton("logout");
        textButton2.setPreferredSize(new Dimension(150,110));
        textButton2.setForeground(Color.gray);
        textButton2.setFont(new Font("Monospaced", Font.BOLD, 20));

        textButton2.setBorderPainted(false);
        textButton2.setContentAreaFilled(false);
        textButton2.setFocusPainted(false);
        textButton2.setOpaque(false);

        jPanel8.add(textButton2,BorderLayout.SOUTH);

        panel.add(jPanel8,BorderLayout.SOUTH);






        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.GREEN);
        panel1.setLayout(new BorderLayout());
        frame.add(panel1,BorderLayout.CENTER);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.setPreferredSize(new Dimension(900,100));
        panel1.add(panel2,BorderLayout.NORTH);

        JLabel jLabel = new JLabel("Welcome sfarahmed");
        jLabel.setFont( new Font("Monospaced", Font.BOLD, 50));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel.setVerticalAlignment(SwingConstants.CENTER);
        jLabel.setForeground(Color.ORANGE);
        panel2.add(jLabel);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.BLACK);
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT,15,20));
        panel3.setPreferredSize(new Dimension(900,600));
        panel1.add(panel3,BorderLayout.CENTER);

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.magenta);
        panel4.setPreferredSize(new Dimension(260,250));
        panel3.add(panel4);

        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.magenta);
        panel5.setPreferredSize(new Dimension(260,250));
        panel3.add(panel5);

        JPanel panel6 = new JPanel();
        panel6.setBackground(Color.magenta);
        panel6.setPreferredSize(new Dimension(260,250));
        panel3.add(panel6);

        JPanel panel7 = new JPanel();
        panel7.setBackground(Color.magenta);
        panel7.setPreferredSize(new Dimension(260,250));
        panel3.add(panel7);

        //JScrollPane scrollPane = new JScrollPane(panel3);

        JScrollPane scrollPane = new JScrollPane(panel3);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Add the JScrollPane to panel1
        panel1.add(scrollPane, BorderLayout.CENTER);

        jPanel6.add(textButton);
        JButton textButton1 = new JButton("My course");
        textButton1.setPreferredSize(new Dimension(150,50));
        textButton1.setForeground(Color.gray);
        textButton1.setFont(new Font("Monospaced", Font.BOLD, 20));
        textButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                panel3.removeAll();
                panel3.repaint();

            }
        });

        textButton1.setBorderPainted(false);
        textButton1.setContentAreaFilled(false);
        textButton1.setFocusPainted(false);
        textButton1.setOpaque(false);

        jPanel6.add(textButton1);










        frame.setVisible(true);
    }
}