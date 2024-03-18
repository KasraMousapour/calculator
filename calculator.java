//package com.kasra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons= new JButton[10];
    JButton[] functionButtons=new JButton[13];
    JButton addButton,subButton,mulButton,divButton,negButton,powButton,sqrButton,modButton,hypotButton;
    JButton decButton,equButton,delButton,clrButton;
    JPanel panel;
    JLabel produce;
    Font font=new Font("Time",Font.BOLD,30);
    Color lightBlu=new Color(0x4DD0E1),subBlue=new Color(0x26C6DA),mainBlue=new Color(0x00BCD4);
    double num1=0,num2=0,result=0;
    char operator;

    calculator(){
        frame=new JFrame("Calculator");
        frame.setIconImage(new ImageIcon("calculator.png").getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,625);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(0x263238));
        frame.setLayout(null);

        textField=new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(font);
        textField.setBackground(new Color(0x90A4AE));
        textField.setEditable(false);

        addButton=new JButton("+");
        addButton.setBackground(subBlue);
        subButton=new JButton("-");
        subButton.setBackground(subBlue);
        mulButton=new JButton("*");
        mulButton.setBackground(subBlue);
        divButton=new JButton("÷");
        divButton.setBackground(subBlue);
        decButton=new JButton(".");
        decButton.setBackground(lightBlu);
        equButton=new JButton("=");
        equButton.setBackground(new Color(0x4CAF50));
        delButton=new JButton("Del");
        delButton.setBackground(Color.red);
        clrButton=new JButton("Clr");
        clrButton.setBackground(new Color(0x607D8B));
        negButton=new JButton("+/-");
        negButton.setBackground(subBlue);
        powButton=new JButton("^");
        powButton.setBackground(mainBlue);
        sqrButton=new JButton("s");
        sqrButton.setBackground(mainBlue);
        modButton=new JButton("%");
        modButton.setBackground(mainBlue);
        hypotButton=new JButton("h");
        hypotButton.setBackground(mainBlue);



        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = powButton;
        functionButtons[10] = sqrButton;
        functionButtons[11] = modButton;
        functionButtons[12] = hypotButton;

        for (int i = 0; i < 13; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }
        for (int j = 0; j < 10; j++) {
            numberButtons[j] = new JButton(String.valueOf(j));
            numberButtons[j].addActionListener(this);
            numberButtons[j].setFont(font);
            numberButtons[j].setFocusable(false);
            numberButtons[j].setBackground(lightBlu);
        }

        negButton.setBounds(50,505,82,50);
        delButton.setBounds(159,505,82,50);
        clrButton.setBounds(268,505,82,50);

        panel=new JPanel();
        panel.setBounds(50,100,300,375);
        panel.setLayout(new GridLayout(5,4,10,10));
        panel.setBackground(new Color(0x263238));

        panel.add(hypotButton);
        panel.add(modButton);
        panel.add(powButton);
        panel.add(sqrButton);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == powButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '^';
            textField.setText("");
        }
        if (e.getSource() == sqrButton){
            num1 = Double.parseDouble(textField.getText());
            double d=Math.sqrt(num1);
            textField.setText(String.valueOf(d));
        }
        if (e.getSource() == modButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
        }
        if (e.getSource() == hypotButton){
            num1 = Double.parseDouble(textField.getText());
            operator = 'h';
            textField.setText("");
        }
        if (e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
                case '^':
                    result=Math.pow(num1,num2);
                    break;
                case 'h':
                    result=Math.hypot(num1,num2);
                    break;
                case '%':
                    result=num1%num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
            if(e.getSource() == clrButton){
                textField.setText("");
            }
            if(e.getSource() == delButton){
                String s = textField.getText();
                textField.setText("");
                for (int i = 0; i < s.length() - 1; i++) {
                    textField.setText(textField.getText() + s.charAt((i)));
                }
            }
            if(e.getSource() == negButton){
                double temp = Double.parseDouble(textField.getText());
                temp *= -1;
                textField.setText(String.valueOf(temp));

            }
        }

    }

