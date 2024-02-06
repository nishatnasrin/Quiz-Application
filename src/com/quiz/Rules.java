package com.quiz;

import javax.swing.*; // imported to use JFrame
import java.awt.*; // to import color class
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener { // to add click function, we implement ActionListener, AL has a method inside it which we will have to override

    // creating constructor + extends JFrame to create frame for rules
    String name; // globally declared string name
    JButton back, start;

    Rules(String name){ // parameterised constructor
        this.name = name;

        getContentPane().setBackground(Color.white);
        setLayout(null); // to create apna layout

        JLabel heading = new JLabel("Welcome " + name + " to INZOMNIART");
        heading.setBounds(100, 40, 600, 45);
        heading.setFont(new Font("Metropolis", Font.BOLD, 24));
        heading.setForeground(new Color(10, 90, 140));
        add(heading);

        JLabel intro = new JLabel("The rules of the quiz are as follows:");
        intro.setBounds(100, 100, 600, 45);
        intro.setFont(new Font("Metropolis", Font.BOLD, 16));
        intro.setForeground(new Color(10, 90, 140));
        add(intro);

        JLabel rules = new JLabel();
        rules.setBounds(100, 100, 600, 300);
        rules.setFont(new Font("Metropolis", Font.PLAIN, 14));
        rules.setForeground(new Color(60, 60, 60));
        rules.setText(
             "<html>" +
                     "01. All the questions are in mcq format." + "<br><br>" +
                     "02. A stable internet connection is needed to attempt this test." + "<br><br>" +
                     "03. You can select only one answer." + "<br><br>" +
                     "04. There is no time limit specified for the test." + "<br><br>" +
                     "05. There will be no negative marking for wrong answers" + "<br><br>" +
                     "06. The score will be shown at the end of the quiz." + "<br><br>" +
                     "07. Honesty and integrity is expected from you. :)" + "<br><br>" +
                     "<html>"
        ); // to set values of text dynamically
        add(rules);

        back = new JButton("Back");
        back.setBounds(250, 380, 120, 25);
        back.setBackground(new Color(10,90,140));
        back.setFont(new Font("Metropolis", Font.BOLD, 12));
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        start = new JButton("Start");
        start.setBounds(450, 380, 120, 25);
        start.setBackground(new Color(10,90,140));
        start.setFont(new Font("Metropolis", Font.BOLD, 12));
        start.setForeground(Color.white);
        start.addActionListener(this);
        add(start);

        setSize(800, 500);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == start){
            // korchi darao quiz build, tarpore redirect kore debo
            setVisible(false);
            new Quiz(name);
        }else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
         new Rules("User"); // calling constructor
    }
}
