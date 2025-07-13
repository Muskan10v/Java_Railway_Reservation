import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class book extends JFrame implements ActionListener {
    JLabel head ,datel,seat;
    JTextField seattf;
    JDateChooser dateChooser;
    String pwd;
    String price;
    String date;
//    String Seats;

    book(String pwd,String price,String date) {
        this.pwd=pwd;
        this.price=price;
        this.date=date;
//        this.Seats=Seats;

        head = new JLabel("Give some more information!");
        head.setFont(new Font("Raleway", Font.BOLD, 25));
        head.setBounds(190,10,450,150);
        add(head);

        datel=new JLabel("Date of Journey:");
        datel.setFont(new Font("Raleway", Font.BOLD, 20));
        datel.setBounds(30,100,200,100);
        add(datel);
        dateChooser=new JDateChooser();
        dateChooser.setForeground(Color.WHITE);
        dateChooser.setBounds(190, 135, 100, 30);
        add(dateChooser);

        seat=new JLabel("Number of Berth/Seats:");
        seat.setFont(new Font("Raleway", Font.BOLD, 20));
        seat.setBounds(360,100,250,100);
        add(seat);
        seattf=new JTextField();
        seattf.setFont(new Font("Raleway", Font.BOLD, 20));
        seattf.setBounds(590,135,80,30);
        add(seattf);

        JButton submit =new JButton("Print Your Ticket");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(450,250,200,30);
        submit.addActionListener(this);
        add(submit);

        setLayout(null);
        setSize(730,400);
        setLocation(400,70);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String date=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String seat=seattf.getText();
        int amount;
        try{
            if(date.equals("")){
                JOptionPane.showMessageDialog(null,"All fields are required");
            }else{
                connection c=new connection();
                String query1="insert into book values('"+pwd+"','"+date+"','"+seat+"')";
                c.s.executeUpdate(query1);
                setVisible(false);
                new ticket(pwd,seat,price,date).setVisible(true);
            }
        }catch(Exception ex){
            System.out.println(ex);
        }

    }

    public static void main(String [] args){
        new book("","","");
    }
}







//        origin=new JLabel("Origin Station:");
//        origin.setFont(new Font("Raleway", Font.BOLD, 20));
//        origin.setBounds(30,130,200,100);
//        add(origin);
//        origintf=new JTextField();
//        origintf.setFont(new Font("Raleway", Font.BOLD, 20));
//        origintf.setBounds(180,170,150,30);
//        add(origintf);
//
//        destination=new JLabel("Destination Station:");
//        destination.setFont(new Font("Raleway", Font.BOLD, 20));
//        destination.setBounds(360,130,250,100);
//        add(destination);
//        destinationtf=new JTextField();
//        destinationtf.setFont(new Font("Raleway", Font.BOLD, 20));
//        destinationtf.setBounds(550,170,150,30);
//        add(destinationtf);

//        classes=new JLabel("Class:");
//        classes.setFont(new Font("Raleway", Font.BOLD, 20));
//        classes.setBounds(30,160,200,100);
//        add(classes);
//        sleeper = new JRadioButton("Sleeper");
//        sleeper.setFont(new Font("Raleway", Font.BOLD, 15));
//        sleeper.setBounds(100, 200, 100, 30);
//        sleeper.setBackground(Color.WHITE);
//        add(sleeper);
//        Ac= new JRadioButton("AC");
//        Ac.setFont(new Font("Raleway", Font.BOLD, 15));
//        Ac.setBounds(200, 200, 80, 30);
//        Ac.setBackground(Color.WHITE);
//        add(Ac);
//        twoac= new JRadioButton("Two Tier AC");
//        twoac.setFont(new Font("Raleway", Font.BOLD, 15));
//        twoac.setBounds(280, 200, 150, 30);
//        twoac.setBackground(Color.WHITE);
//        add(twoac);
//        ButtonGroup classGroup = new ButtonGroup();
//        classGroup.add(sleeper);
//        classGroup.add(Ac);
//        classGroup.add(twoac);