package com.quiz;

import javax.swing.*; // java er extended package tai javax
import java.awt.*;
import java.awt.event.*; // ActionListener ei package e thake

//class er object create hotei constructor call kora hobe
//frame er modhyer sob coding constructor er modhye thakbe
public class Login extends JFrame implements ActionListener { //inheritance method; JFrame swing package e thake + ActionListener which is an unimplemented abstract class/ method in interface, is added to implement click functionalities on buttons, so we need to override it

    // if you implement any interface in a class, then you have to override every unimplemented/ abstract methods that are present inside the interface, so we will need to override this abstract ActionListner method


    // to access button class globally ie from the ae class, we need to declare them globally instead of declaring them locally

    JButton rules, close;
    JTextField tfname; // globally declared so that it can be accessed from rules class also

    Login(){
        getContentPane().setBackground(Color.white); //frame er background er colour change + color class awt package er modhye thake
        setLayout(null); // null - i will create my own layout, not your precoded ones


        //image icon class under jframe class to load image from source
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg")); //src folder e thakbe sob chobi
        JLabel image = new JLabel(i1); //jlabel class er object cuz direct component add kora jai na
        image.setBounds(0, 0, 600, 500);
        add(image); //add function to place component on frame

        JLabel heading = new JLabel("inzomniart");
        heading.setBounds(780, 60, 300, 45);
        heading.setFont(new Font("Samarkan", Font.BOLD, 48));
        heading.setForeground(new Color(10, 90,140)); //Color.Blue o korte pari, kintu rgb te color pass korte hole ekta new color object create korte hobe
        add(heading);

        JLabel name = new JLabel("Enter your name: ");
        name.setBounds(830, 150, 300, 20);
        name.setFont(new Font("Metropolis", Font.BOLD, 15));
        name.setForeground(new Color(10, 90,140));
        add(name);

        //using JTextFields we can make text fields in which user can give inputs
        // JTextField tfname = new JTextField(); // locally declared chilo age
        tfname = new JTextField();
        tfname.setBounds(750, 200, 300, 25);
        tfname.setFont(new Font("Metropolis", Font.BOLD, 15));
        add(tfname);

        //to create buttons we use JButton class
//        JButton rules = new JButton("Rules");
        rules = new JButton("Rules"); //since we have already declared them globally, no need to declare it again locally
        rules.setBounds(750, 260, 120,25);
        rules.setBackground(new Color(10,90,140));
        rules.setForeground(new Color(255,255,255));
        rules.setFont(new Font("Metropolis", Font.BOLD, 12));
        rules.addActionListener(this); // tells us that some click/actions are performed here
        add(rules);

        //another button to add back function
//        JButton close = new JButton("Close");
        close = new JButton("Close");
        close.setBounds(927, 260, 120,25);
        close.setBackground(new Color(10,90,140));
        close.setForeground(new Color(255,255,255));
        close.setFont(new Font("Metropolis", Font.BOLD, 12));
        close.addActionListener(this);
        add(close);

        setSize(1200, 500); //frame er size set koro
        setLocation(40, 100); //screen e frame er location; nijer laptop er screen er upor base kore
        setVisible(true); //jate frame dekha jai; left upper corner e by default dekha jai

    }

    public void actionPerformed(ActionEvent ae){ // overriding the abstract method over here,so the error is now gone
        // to differentiate which this wala actionlistener function will perform which action, we have to define them in this ae class
        if (ae.getSource() == rules){
            // rules page kholar jonno seta banate hobe to naki, wait please, ektu darao, kori ami ota totokkhon

            String name = tfname.getText(); // to get text from previous frame given by user manually
            setVisible(false); // to make the current frame invisible
            new Rules(name); // to open the newly created rules frame
            // passing the user input name to rules class, globally declared as String
        } else if (ae.getSource() == close) {
            setVisible(false); // frame will be closed
        }

    }

    public static void main(String[] args) {
        Login l = new Login(); // creating new object of class
    }
}