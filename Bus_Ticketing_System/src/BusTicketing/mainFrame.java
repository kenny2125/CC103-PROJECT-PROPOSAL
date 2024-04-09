package BusTicketing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends JFrame implements ActionListener {

    JButton choice1;
    JButton choice2;
    JButton choice3;
    JButton choice4;
    JButton choice5;
    JPanel panel1;
    JLabel title1;
    JTextField myTitle;


    mainFrame() {
        myTitle = new JTextField("Welcome To Bus Ticketing System! !");
        this.setTitle(myTitle.getText());
        this.setVisible(true);
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setLayout(new GridBagLayout());
        panel1 = new JPanel();
        panel1.setSize(1280, 720);
        getContentPane().setBackground(new Color(23, 38, 105));
        panel1.setLayout(new GridLayout(6, 0, 10, 10));
        title1 = new JLabel("Please Pick Your Choice:");
        title1.setForeground(new Color(255, 255, 255));
        title1.setFont(new Font("Poppins", Font.BOLD, 34));
        title1.setBorder(new EmptyBorder(15, 10, 15, 10));
        title1.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel1.setBackground(new Color(23, 38, 105));


        choice1 = new JButton("Destination");
        choice2 = new JButton("Buy Tix");
        choice3 = new JButton("Transaction");
        choice4 = new JButton("Search Transaction");
        choice5 = new JButton("Exit");

        choice1.setAlignmentX(Component.CENTER_ALIGNMENT);
        choice2.setAlignmentX(Component.CENTER_ALIGNMENT);
        choice3.setAlignmentX(Component.CENTER_ALIGNMENT);
        choice4.setAlignmentX(Component.CENTER_ALIGNMENT);
        choice5.setAlignmentX(Component.CENTER_ALIGNMENT);

        choice1.setBorder(BorderFactory.createBevelBorder(1,new Color(33, 32, 43), new Color(33, 32, 43)));
        choice1.setBackground(new Color(32, 183, 217));
        choice1.setContentAreaFilled(true);
        choice1.setForeground(Color.white);

        choice2.setBorder(BorderFactory.createBevelBorder(1,new Color(33, 32, 43), new Color(33, 32, 43)));
        choice2.setBackground(new Color(32, 183, 217));
        choice2.setContentAreaFilled(true);
        choice2.setForeground(Color.white);

        choice3.setBorder(BorderFactory.createBevelBorder(1,new Color(33, 32, 43), new Color(33, 32, 43)));
        choice3.setBackground(new Color(32, 183, 217));
        choice3.setContentAreaFilled(true);
        choice3.setForeground(Color.white);

        choice4.setBorder(BorderFactory.createBevelBorder(1,new Color(33, 32, 43), new Color(33, 32, 43)));
        choice4.setBackground(new Color(32, 183, 217));
        choice4.setContentAreaFilled(true);
        choice4.setForeground(Color.white);

        choice5.setBorder(BorderFactory.createBevelBorder(1,new Color(33, 32, 43), new Color(33, 32, 43)));
        choice5.setBackground(new Color(32, 183, 217));
        choice5.setContentAreaFilled(true);
        choice5.setForeground(Color.white);

        choice1.setFont(new Font("Poppins", Font.BOLD, 24));
        choice2.setFont(new Font("Poppins", Font.BOLD, 24));
        choice3.setFont(new Font("Poppins", Font.BOLD, 24));
        choice4.setFont(new Font("Poppins", Font.BOLD, 24));
        choice5.setFont(new Font("Poppins", Font.BOLD, 24));

        panel1.add(title1);
        panel1.add(choice1);
        panel1.add(choice2);
        panel1.add(choice3);
        panel1.add(choice4);
        panel1.add(choice5);

        choice1.setFocusable(false);
        choice2.setFocusable(false);
        choice3.setFocusable(false);
        choice4.setFocusable(false);
        choice5.setFocusable(false);

        choice1.addActionListener(this);
        choice2.addActionListener(this);
        choice3.addActionListener(this);
        choice4.addActionListener(this);
        choice5.addActionListener(this);


        this.add(panel1, new GridBagConstraints());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==choice1) {
            dispose();
            destinationFrames destinationFrames = new destinationFrames();
        } else if (e.getSource()==choice5) {
            System.exit(0);
        }
    }
}
