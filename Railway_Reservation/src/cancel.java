
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class cancel extends JFrame implements ActionListener {
    JButton book,cancel,exit;
    String pwd;
    JLabel text,pnr;
    JTextField pnrtf;

    cancel(String pwd) {

        this.pwd=pwd;

        text = new JLabel("Want To Cancel Tickets?");
        text.setBounds(120, 60, 500, 35);
        text.setFont(new Font("Raleway", Font.BOLD, 30));
        text.setForeground(Color.BLACK);
        add(text);

        pnr = new JLabel("Enter Your PNR Number:");
        pnr.setBounds(20, 180, 500, 30);
        pnr.setFont(new Font("Raleway", Font.BOLD, 25));
        pnr.setForeground(Color.BLACK);
        add(pnr);
        pnrtf=new JTextField();
        pnrtf.setFont(new Font("Raleway", Font.BOLD, 15));
        pnrtf.setBounds(320, 180, 250, 35);
        add(pnrtf);


        exit=new JButton("Click");
        exit.setBounds(350,300,200,30);
        exit.addActionListener(this);
        add(exit);

        setLayout(null);
        setSize(600, 400);
        setLocation(400, 100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    public static void main(String[]args){
        new cancel("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pnr=pnrtf.getText();
        connection c=new connection();
        String query = "select * from ticket where  pwd='" + pwd + "' and PNR_no='"+pnr+"'";
        try {
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                String amount=rs.getString("amount");
                setVisible(false);
                JOptionPane.showMessageDialog(null, "Your tickets with PNR number "+pnr+" are cancelled and your money of "+amount+" will be refunded.");
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}


