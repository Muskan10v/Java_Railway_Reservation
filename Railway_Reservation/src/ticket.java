
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;

public class ticket extends JFrame implements ActionListener {

    JButton b1;
    String pwd,price,seat,date;
    JLabel l2,l3,l4,l5,l6,l7;
//    String Seats;
   ticket(String pwd,String seat,String price,String date) {
        super("Ticket");
        this.seat=seat;
       this.price=price;
       this.pwd=pwd;
       this.date=date;
//       this.Seats=Seats;

         l2 = new JLabel("Thanks for visiting Indian Railways!");
        l2.setFont(new Font("Raleway", Font.BOLD, 20));
        l2.setBounds(150, 20, 400, 25);
        add(l2);

        l3 = new JLabel();
        l3.setBounds(120, 80, 500, 25);
       l3.setFont(new Font("Raleway", Font.BOLD, 20));
        add(l3);

        l4 = new JLabel();
        l4.setBounds(40, 120, 700, 25);
       l4.setFont(new Font("Raleway", Font.BOLD, 20));
        add(l4);

      l5 = new JLabel();
       l5.setBounds(120, 160, 500, 25);
       l5.setFont(new Font("Raleway", Font.BOLD, 20));
       add(l5);


       l6 = new JLabel();
       add(l6);
       l7 = new JLabel();
       add(l7);
       try {
           connection c = new connection();
           ResultSet rs = c.s.executeQuery("select *from book where pwd= '" + pwd + "' ");
           while (rs.next()) {
               l3.setText("Date Of Journey: "+ date);
               l3.setText("Date Of Journey:    " + rs.getString("date"));
           }
       }catch (Exception e) {
           e.printStackTrace();
       }

        Long PNR_no;
        Random random = new Random();
        PNR_no = random.nextLong(1000000000);
        l4.setText("Your ticket has been confirmed with PNR No." + PNR_no );
        l6.setText(String.valueOf(PNR_no));


        try {
            connection c = new connection();
            int amount = 0;
            ResultSet rs = c.s.executeQuery("select *from signup where pwd= '" + pwd + "' ");
            while (rs.next()) {
                amount = Integer.parseInt(seat) * Integer.parseInt(price);
                l5.setText("Total Price For Tickets is Rs " + amount);
                l7.setText(String.valueOf(amount));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }



        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(700, 400);
        setLocation(20, 20);

        b1 = new JButton("Exit");
        b1.addActionListener(this);
        b1.setBounds(300, 300, 100, 50);
        add(b1);
    }

    public void actionPerformed(ActionEvent ae) {
        try{
            String amount=l7.getText();
            String PNR_no=l6.getText();
            connection c = new connection();
            String query="insert into ticket values ('"+pwd+"','"+PNR_no+"','"+amount+"')";
            c.s.executeUpdate(query);
//            String query1="alter table train add PNR_no varchar";
//            c.s.executeUpdate(query1);
//            JOptionPane.showMessageDialog(null,"hello");

        }
        catch(Exception e){
            System.out.println(e);
        }
        setVisible(false);
    }

    public static void main(String[] args) {
        new ticket("","","","");
    }
}


