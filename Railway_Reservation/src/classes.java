import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class classes extends JFrame implements ActionListener {
    JTable table;
    JButton next;
    String pwd;
    String date;
// String Seats;
  classes(String pwd,String date) {

      this.pwd=pwd;
        this.date=date;
//        this.Seats=Seats;
        String[][] classes = {
                {"Sleeper", "100"},
                {"First Class", "115"},
                {"One AC", "2000"},
                {"Two Tier AC", "1500"},
                {"Three Tier AC", "1000"},
        };
        String[] header = {"Class", "Price"};
        DefaultTableModel tableModel = new DefaultTableModel(classes, header);
        table = new JTable(tableModel);
        table.setBounds(50, 100, 400, 300);

        next = new JButton("Next");
        next.setSize(70, 20);
        next.addActionListener(this);

        JScrollPane sp = new JScrollPane(table);
        add(sp,BorderLayout.CENTER);
        JToolBar toolBar=new JToolBar();
        toolBar.add(next);
        add(toolBar,BorderLayout.SOUTH);


        setSize(700, 200);
        setLocation(400, 200);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        if (tableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Table is empty");
        }
        else {
            String classes,price;
            int selectedRow = table.getSelectedRow();
            try {
                classes= tableModel.getValueAt(selectedRow, 0).toString();
                price = tableModel.getValueAt(selectedRow, 1).toString();

                connection c = new connection();
                String query = "insert into classes( pwd,class,price) values(?,?,?)";
                PreparedStatement prep = c.c.prepareStatement(query);
                prep.setString(1, pwd);
                prep.setString(2, classes);
                prep.setString(3, price);
                prep.execute();
                setVisible(false);
                new book(pwd,price,date).setVisible(true);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void main(String [] args){
        new classes("","");
    }
}

