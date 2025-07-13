

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class select extends JFrame implements ActionListener {
    JButton book,cancel,exit;

    String pwd;
    String date;

    select(String pwd, String date ) {

        this.pwd=pwd;
        this.date=date;

        JLabel text = new JLabel("Select Your Choice");
        text.setBounds(160, 60, 500, 35);
        text.setFont(new Font("Raleway", Font.BOLD, 30));
        text.setForeground(Color.BLACK);
        add(text);

        book = new JButton("Book Ticket");
        book.setBounds(100, 150, 400, 50);
        book.addActionListener(this);
        add(book);

        cancel = new JButton("Cancel Ticket");
        cancel.setBounds(100, 250, 400, 50);
        cancel.addActionListener(this);
        add(cancel);

        exit=new JButton("Exit");
        exit.setBounds(350,350,200,30);
        exit.addActionListener(this);
        add(exit);


        setLayout(null);
        setSize(600, 500);
        setLocation(400, 100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exit) {
            System.exit(0);
        } else if (e.getSource() == book) {
            setVisible(false);
            new Train(pwd,date).setVisible(true);
        } else if (e.getSource() == cancel) {
            setVisible(false);
            new cancel(pwd).setVisible(true);
        }
    }
        public static void main(String[]args){
            new select("","");
        }
}

