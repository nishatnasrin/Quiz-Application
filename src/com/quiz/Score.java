package com.quiz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {

    Score(String name, int score){
        setBounds(100, 100, 1080, 500);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.jpg"));
        // to scale image, we need to create an object of the image class
//        Image i2 = i1.getImage().getScaledInstance(400,500, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,400,500);
        add(image);

        JLabel heading = new JLabel("Thank You " + name + " for playing INZOMNIART!");
        heading.setBounds(450,50, 600, 100);
        heading.setFont(new Font("Metropolis", Font.BOLD, 20));
        heading.setForeground(new Color(10,90,140));
        add(heading);

        JLabel score_display = new JLabel("Your score is: " + score + "!");
        score_display.setBounds(450,150, 600, 100);
        score_display.setFont(new Font("Metropolis", Font.BOLD, 60));
        score_display.setForeground(new Color(10,90,140));
        add(score_display);

        JButton close = new JButton("Close");
        close.setBounds(450,300,120,25);
        close.setFont(new Font("Metropolis", Font.BOLD, 12));
        close.setBackground(new Color(10,90,140));
        close.setForeground(Color.white);
        close.addActionListener(this);
        add(close);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

    public static void main(String[] args) {
        new Score("User", 0);
    }
}
