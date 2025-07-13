import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel Login_Id,Password,head;
    JTextField login_tf,password_tf;
    JButton SignIn,SignUp;
    String date;

    Login( String date) {

        this.date=date;

        head = new JLabel("Welcome To Indian Railways !");
        head.setFont(new Font("Raleway", Font.BOLD, 25));
        head.setBounds(120,10,400,150);
        add(head);

        Login_Id = new JLabel("Enter the Login ID:");
        Login_Id.setFont(new Font("Raleway", Font.BOLD, 25));
        Login_Id.setBounds(50,100,250,150);
        add(Login_Id);
        login_tf=new JTextField();
        login_tf.setFont(new Font("Raleway", Font.BOLD, 15));
        login_tf.setBounds(300, 150, 250, 50);
        add(login_tf);

        Password = new JLabel("Enter the Password:");
        Password.setFont(new Font("Raleway", Font.BOLD, 25));
        Password.setBounds(50,200,250,150);
        add(Password);
        password_tf=new JTextField();
        password_tf.setFont(new Font("Raleway", Font.BOLD, 15));
        password_tf.setBounds(300, 250, 250, 50);
        add(password_tf);

        SignIn=new JButton("SIGN IN");
        SignIn.setBackground(Color.BLACK);
        SignIn.setForeground(Color.WHITE);
        SignIn.setBounds(130,350,150,50);
        SignIn.addActionListener(this);
        add(SignIn);

        SignUp=new JButton("SIGN UP");
        SignUp.setBackground(Color.BLACK);
        SignUp.setForeground(Color.WHITE);
        SignUp.setBounds(330,350,150,50);
        SignUp.addActionListener(this);
        add(SignUp);


        setLayout(null);
        setSize(600,550);
        setLocation(400,70);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==SignIn){
            connection c=new connection();
            String usern=login_tf.getText();
            String pwd=password_tf.getText();
            String query="select * from signup where usern='"+usern+"'and pwd='"+pwd+"'";
            try{
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new select(pwd,date).setVisible(true);
                    //JOptionPane.showMessageDialog(null, "You are successully signed in.");
                }

            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        else if(e.getSource()==SignUp){
            setVisible(false);
            new signup().setVisible(true);
        }
    }
    public static void main(String[] args){
        new Login("");
    }
}


