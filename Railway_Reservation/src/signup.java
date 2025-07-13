

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.String;


public class signup extends JFrame implements ActionListener {
    long random;
    JTextField nametf, Fnametf, emtf, statetf, pintf,untf,pwrdtf,phonetf;
    JRadioButton male, female ;


    signup() {

        JLabel pd = new JLabel("PERSONAL DETAILS: ");
        pd.setFont(new Font("Raleway", Font.BOLD, 25));
        pd.setBounds(180, 50, 400, 30);
        add(pd);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(60, 120, 300, 30);
        add(name);
        nametf = new JTextField();
        nametf.setFont(new Font("Raleway", Font.BOLD, 15));
        nametf.setBounds(250, 120, 300, 30);
        add(nametf);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(60, 160, 300, 30);
        add(fname);
        Fnametf = new JTextField();
        Fnametf.setFont(new Font("Raleway", Font.BOLD, 15));
        Fnametf.setBounds(250, 160, 300, 30);
        add(Fnametf);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(60, 200, 300, 30);
        add(gender);
        male = new JRadioButton("Male");
        male.setBounds(250, 200, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);
        female = new JRadioButton("Female");
        female.setBounds(350, 200, 80, 30);
        female.setBackground(Color.WHITE);
        add(female);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(60, 240, 300, 30);
        add(email);
        emtf = new JTextField();
        emtf.setFont(new Font("Raleway", Font.BOLD, 15));
        emtf.setBounds(250, 240, 300, 30);
        add(emtf);

        JLabel phone= new JLabel("Phone Number:");
        phone.setFont(new Font("Raleway", Font.BOLD, 20));
        phone.setBounds(60, 280, 300, 30);
        add(phone);
        phonetf = new JTextField();
        phonetf.setFont(new Font("Raleway", Font.BOLD, 15));
        phonetf.setBounds(250, 280, 300, 30);
        add(phonetf);

        JLabel state = new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(60, 320, 300, 30);
        add(state);
        statetf = new JTextField();
        statetf.setFont(new Font("Raleway", Font.BOLD, 15));
        statetf.setBounds(250, 320, 300, 30);
        add(statetf);

        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(60, 360, 300, 30);
        add(pincode);
        pintf = new JTextField();
        pintf.setFont(new Font("Raleway", Font.BOLD, 15));
        pintf.setBounds(250, 360, 300, 30);
        add(pintf);

        JLabel username = new JLabel("Write Your User Name:");
        username.setFont(new Font("Raleway", Font.BOLD, 18));
        username.setBounds(60, 400, 300, 30);
        add(username);
        untf = new JTextField();
        untf.setFont(new Font("Raleway", Font.BOLD, 15));
        untf.setBounds(300, 400, 250, 30);
        add(untf);

        JLabel pwwd = new JLabel("Write Your Password:");
        pwwd.setFont(new Font("Raleway", Font.BOLD, 18));
        pwwd.setBounds(60, 440, 300, 30);
        add(pwwd);
        pwrdtf = new JTextField();
        pwrdtf.setFont(new Font("Raleway", Font.BOLD, 15));
        pwrdtf.setBounds(300, 440, 250, 30);
        add(pwrdtf);

        JButton submit =new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(220,500,200,30);
        submit.addActionListener(this);
        add(submit);

        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(620, 600);
        setLocation(400,70);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        String namee=nametf.getText();
        String fname=Fnametf.getText();

        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        String email=emtf.getText();
        String phone=phonetf.getText();
        String state=statetf.getText();
        String pin=pintf.getText();
        String usern=untf.getText();
        String pwd=pwrdtf.getText();

        try{
            if(pwd.equals("")){
                JOptionPane.showMessageDialog(null,"All fields are required");
            }else{
                connection c=new connection();
                String query="insert into signup values('"+namee+"','"+fname+"','"+gender+"','"+email+"','"+phone+"','"+state+"','"+pin+"','"+usern+"','"+pwd+"')";
                c.s.executeUpdate(query);
                setVisible(false);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new signup();
    }
}


