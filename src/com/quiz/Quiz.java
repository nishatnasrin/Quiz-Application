package com.quiz;

import javax.swing.*; // to import JFrame
import java.awt.*; // to import color class
import java.awt.event.*; // to import ActionListener interface --> needs to be overridden by actionPerformed

public class Quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];// to store questions and answers we need a 2d array, [row][column(not necessary)], 10 questions, 5 column = 1 question + 4 options
    String answers[][] = new String[10][2]; // 10 questions + 1 answer
    String user_answers[][] = new String[10][1]; // to track which answer the user has selected --> 10 questions, 1 selected answer
    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton lifeline, next, submit; //globally declared so that can be accessed from actionPerformed

    public static int timer = 15; // default time is set as 15 sec
    public static int ans_given = 0; // creating a flag to make that after time is over, the next question pops up automatically --> here to check whether any answer is selected or not
    public static int count = 0; // user answer ke to amra hardcode korte pari na, tai alada alada question er answer ke  dynamically store korar jonno
    public static int score = 0;

    String name;

    Quiz(String name){ // creating the constructor
        this.name = name;
        setBounds(100, 20, 1080, 650);// combination of setSize and setLocation, jodi emon kono component na thake je setBounds ke call korbe, tahole by default JFrame setBounds ke call kore, tai JFrame extend korate hobe
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1080,300);
        add(image);

        qno = new JLabel(); //hard code ille, dynamically jehetu next button e click korlei question no change hoye jabe, protyek ta q no to ar "1" define kore dite pari na amra tai JLabel er modhye
        qno.setBounds(100,350,100,40);
        qno.setFont(new Font("Metropolis", Font.BOLD, 17));
        qno.setForeground(new Color(10,90,140));
        add(qno);

        question = new JLabel(); //hard code ille, dynamically jehetu next button e click korlei question no change hoye jabe, protyek ta q no to ar "1" define kore dite pari na amra tai JLabel er modhye
        question.setBounds(130,350,900,40);
        question.setFont(new Font("Metropolis", Font.BOLD, 17));
        question.setForeground(new Color(10,90,140));
        add(question);

        // question set:

        questions[0][0] = "Which data structure is used to implement recursion in programming?";
        questions[0][1] = "Stack";
        questions[0][2] = "Queue";
        questions[0][3] = "Linked List";
        questions[0][4] = "Tree";

        questions[1][0] = "What does the acronym API stand for in programming?";
        questions[1][1] = "Application Programming Interface";
        questions[1][2] = "Advanced Programming Interface";
        questions[1][3] = "Application Process Integration";
        questions[1][4] = "Advanced Process Interface";

        questions[2][0] = "What is the purpose of the \"else\" statement in programming?";
        questions[2][1] = "To handle errors";
        questions[2][2] = "To provide an alternative code block if the condition is false";
        questions[2][3] = "To define a loop";
        questions[2][4] = "To declare variables";

        questions[3][0] = "What is the role of the \"constructor\" in object-oriented programming?";
        questions[3][1] = "To destroy an object";
        questions[3][2] = "To create an object and initialize its attributes";
        questions[3][3] = "To define the inheritance hierarchy";
        questions[3][4] = "To handle exceptions";

        questions[4][0] = "In the context of databases, what does SQL stand for?";
        questions[4][1] = "Simple Query Language";
        questions[4][2] = "Structured Question Language";
        questions[4][3] = "Standard Query Language";
        questions[4][4] = "Sequential Query Language";

        questions[5][0] = "Which of the following is a commonly used algorithm for searching a sorted array?";
        questions[5][1] = "Linear Search";
        questions[5][2] = "Binary Search";
        questions[5][3] = "Depth-First Search";
        questions[5][4] = "Breadth-First Search";

        questions[6][0] = "What is the purpose of the \"finally\" block in a try-catch-finally statement?";
        questions[6][1] = "To define a loop";
        questions[6][2] = "To execute code regardless of whether an exception is thrown or not";
        questions[6][3] = "To exit a loop prematurely";
        questions[6][4] = "To catch exceptions";

        questions[7][0] = "Which of the following is an example of a recursive algorithm?";
        questions[7][1] = "Quick Sort";
        questions[7][2] = "Bubble Sort";
        questions[7][3] = "Insertion Sort";
        questions[7][4] = "Selection Sort";

        questions[8][0] = "Which of the following is not a primitive data type in Java?";
        questions[8][1] = "int";
        questions[8][2] = "float";
        questions[8][3] = "char";
        questions[8][4] = "class";

        questions[9][0] = "Which sorting algorithm has a worst-case time complexity of O(n log n)?";
        questions[9][1] = "Bubble Sort";
        questions[9][2] = "Insertion Sort";
        questions[9][3] = "Merge Sort";
        questions[9][4] = "Selection Sort";

        // answers:

        answers[0][1] = "Stack";
        answers[1][1] = "Application Programming Interface";
        answers[2][1] = "To provide an alternative code block if the condition is false";
        answers[3][1] = "To create an object and initialize its attributes";
        answers[4][1] = "Standard Query Language";
        answers[5][1] = "Binary Search";
        answers[6][1] = "To execute code regardless of whether an exception is thrown or not";
        answers[7][1] = "Quick Sort";
        answers[8][1] = "class";
        answers[9][1] = "Merge Sort";

        opt1 = new JRadioButton(); //to create mcq type answers ie only one answer is right among many, empty function cuz they will be put dynamically later
        opt1.setBounds(140,390,700,30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Metropolis", Font.PLAIN, 14));
        add(opt1);

        opt2 = new JRadioButton(); //to create mcq type answers ie only one answer is right among many
        opt2.setBounds(140,420,700,30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Metropolis", Font.PLAIN, 14));
        add(opt2);

        opt3 = new JRadioButton(); //to create mcq type answers ie only one answer is right among many
        opt3.setBounds(140,450,700,30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Metropolis", Font.PLAIN, 14));
        add(opt3);

        opt4 = new JRadioButton(); //to create mcq type answers ie only one answer is right among many
        opt4.setBounds(140,480,700,30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Metropolis", Font.PLAIN, 14));
        add(opt4);

        groupoptions = new ButtonGroup(); // to make a group of all the button we need a new ButtonGroup class, so that only one option can be selected
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        lifeline = new JButton("LifeLine");
        lifeline.setBounds(300, 540, 120,25);
        lifeline.setFont(new Font("Metropolis", Font.PLAIN, 14));
        lifeline.setBackground(new Color(10,90,140));
        lifeline.setForeground(Color.white);
        lifeline.addActionListener(this);
        add(lifeline);

        next = new JButton("Next");
        next.setBounds(470, 540, 120,25);
        next.setFont(new Font("Metropolis", Font.PLAIN, 14));
        next.setBackground(new Color(10,90,140));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(640, 540, 120,25);
        submit.setFont(new Font("Metropolis", Font.PLAIN, 14));
        submit.setBackground(new Color(10,90,140));
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setEnabled(false); // to make it disabled till user gets to last questionA
        add(submit);

        // now let's create a function to insert values in place of questions and options
        start(count); // start er value count pass korte pari, initially count er value o to zero
        // since the start function is created outside the constructor, we need to declare all of them (the functions and labels that are declared inside this constructor scope only) globally so that start function can access them from outside :) abar khatni

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        // if next button in called
        if (ae.getSource() == next){
            repaint();
            // so that after clicking next, all the four options are freshly enabled:
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            ans_given = 1; // cuz next button e click kora hoyeche, ebar let us check ki adeo user answer select koreche kichu kina, to setar o same method to find out

            if (groupoptions.getSelection() == null){
                user_answers[count][0] = "";
            } else {
                user_answers[count][0] = groupoptions.getSelection().getActionCommand();
            }

            // 9th question(count = 8) er pore jokhon 10th question(count = 9) e jabe, tokhon next button disabled hoye jabe ar submit button enabled hoye jabe
            // same check time out er jaigateo ekbar lagate hobe to, lessgo
            if (count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }

            count++;
            start(count); // same as repaint kore next question e jawar method
        } else if (ae.getSource() == lifeline) {
            if (count == 0 || count == 1 || count == 2 || count == 3 || count == 5 || count == 6 || count == 7){
                opt3.setEnabled(false);
                opt4.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt2.setEnabled(false);
            }
            // kintu etodure je somossa ta is, next question e gele previous question er 50/50 wala disabled option gulor continuation hocche --> eta fix korar jonno paint function er timer<0 er okhane giye protyek ta option ke abar notun kore enable korte hobe

            // ekbar lifeline use hoye gele oi option ta disable kore dewar jonno
            lifeline.setEnabled(false);
        } else if (ae.getSource() == submit){
            ans_given = 1; // jodi answer diye dewa hoye jai
            if (groupoptions.getSelection() == null){
                user_answers[count][0] = "";
            }else{
                user_answers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            // to calculate score:
            for (int i = 0; i < user_answers.length; i++) {
                if (user_answers[i][0].equals(answers[i][1])){
                    score += 10; // for correct answer
                }else{
                    score += 0; // for incorrect answer
                }
            }
            setVisible(false);
            // next frame ie score frame er object
            new Score(name, score);
        }
    }

    public void paint(Graphics g){ //Graphics class to show timer, jate frame proti sec e change hoi ar ek sec kore komte thake --> repaint the screen/frame every second, Graphics class java.awt package er modhye thake // paint method apna apni call hoi, call/add korar dorkar nei
        super.paint(g);

        // to display timer, we are taking a string
        String time = "Time left: " + timer + " seconds"; //initially time left: 15 seconds; graphic shown on frame
        g.setColor(Color.RED);
        g.setFont(new Font("Metropolis", Font.BOLD, 17));

        if (timer > 0){
            g.drawString(time,850,370);
        }
        else {
            g.drawString("Time's Up!!", 900,370);
        }
        timer--; // paint method arekbar call korte hobe jate time left: 14 hoi

        // class er object bananor somoi paint method apna apni call hoi, kintu tarpore abar call korar jonno repaint method ke call korte hoi
        // kintu repaint method amra call korbo 1sec pore, tai code of execution ke amader 1 sec er jonno thamate hobe, jeta amra korbo thread class er help niye, multithreading er modhye thread class thake jar modhye ekta method thake sleep bole, seitar sahajje amra code execution ke atke rakhbo
        try{
            Thread.sleep(1000);
            repaint(); // 1000ms/1s pore pore timer-- korbe
        }
        catch (Exception e){
            e.printStackTrace(); //a method of Java’s throwable class which prints the throwable along with other details like the line number and class name where the exception occurred.
        }

        // user answer diyeche ki na sei basis e next kaj korbo amra. jodi answer diye dei, tahole next question e jawar jonno amra flag ie ans_giben ke zero korbo, ar timer ke abar notun kore 15s theke start korbo
        if (ans_given == 1){
            ans_given = 0;
            timer = 15;
        } else if (timer < 0) { //ar answer tokhono selected na, tahole we will go to next question ar timer abar shuru korbo shuru theke
            timer = 15;
            // jate 50/50 lifeline er pore next question e kono disabled option na jai
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);

            // 9th question er time out hoye gele 10th question er somoi next button ke disable korar jonno:
            if (count == 8){
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            // 10th question e dariye submit button e click korar agei time out hoye gele, auto submit hoye jabe
            if (count == 9){ // submit button
                // to know finally kon option ta select kora hoyeche ba adeo hoyeche kina
                if (groupoptions.getSelection() == null){
                    user_answers[count][0] = "";
                }else{
                    user_answers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                // to calculate score:
                for (int i = 0; i < user_answers.length; i++) {
                    if (user_answers[i][0].equals(answers[i][1])){ // jehetu user_answers zeroth position e store koriyechi while correct answer first position e stored ache
                        score += 10; // for correct answer
                    }else{
                        score += 0; // for incorrect answer
                    }
                }
                setVisible(false); // current frame close kore score er frame khule jabe
                // next frame ie score frame er object
                new Score(name, score);
            }else{ // next button

                // user adeo answer koreche kina setar jonno amra check korbo ButtonGroup class ke, ar seta ache locally declared, to we need it to declare globally at first
                if(groupoptions.getSelection() == null){
                    user_answers[count][0] = ""; // if the question is unanswered, empty string is stored == nothing
                } else{
                    user_answers[count][0] = groupoptions.getSelection().getActionCommand(); // if the question is answered then we will need to store the answer here under user_answers, getSelection() will fetch the selected option from groupoptions and getActionCommand() will get the value of it for you, and it will get stored inside user_answers
                    // getActionCommand korar jonno amader value ke setActionCommand o to korte hobe, let's go back to start() tai
                }
                count++; // 0 --> 1 => next question er jonno ready
                start(count); // to go to next question, start function need to be called
            }
        }
    }

    public void start(int count){
        qno.setText("" + (count + 1) + ". "); // qno is a label jar modhye int noi, khali string value pass kora jai. setText substitutes the characters sText for the text in the text field, works only with the first line of multi-line text fields. count initially was zero, after first iteration, it will be 1, --> ie. values are set dynamically // (count+1) should be wrapped to be iterated continuously in order, nahole 1+1 ke 11 print koriye debe screen e
        question.setText(questions[count][0]);

        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        // porer question e gele by default ager question er selected option tai jate marked na thake tai amader clearSelection() korte hobe
        groupoptions.clearSelection();
    }

    public static void main(String[] args) {
        new Quiz("User"); // let's call parameterised constructor, default nei ar, since it has a parameter inside it now
    }
}
