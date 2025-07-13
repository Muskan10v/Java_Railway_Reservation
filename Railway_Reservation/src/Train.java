import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Train extends JFrame implements ActionListener {
    JTable table;
    JButton next;

    String pwd;
    String date;

    Train(String pwd, String date) {
        this.pwd = pwd;
        this.date = date;
        setTitle("Welcome to Indian Railways Booking!");
        String[][] train = {
                {"132015", "Rajdhani Express", "11:40", "Rajpura", "Katra", "30"},
                {"192545", "Duranto Express", "1:05", "Gorakpur", "Delhi", "10"},
                {"152085", "Shatabi Express", "23:40", "Kashmir ", " Kanyakumari", "54"},
                {"134915", "Garib Rath Express", "21:00", "Kerela ", "Bengal", "66"},
                {"130015", "Vande Bharat Express", "12:00", "Mumbai ", " Gorakhpur", "39"},

        };
        String[] header = {"Train No", "Train Name", "Time", "Origin", "Destination", "Seats"};
        DefaultTableModel tableModel = new DefaultTableModel(train, header);
        table = new JTable(tableModel);
        table.setBounds(50, 100, 400, 300);

        next = new JButton("Next");
        next.setSize(70, 20);
        next.addActionListener(this);

        JScrollPane sp = new JScrollPane(table);
        add(sp, BorderLayout.CENTER);
        JToolBar toolBar = new JToolBar();
        toolBar.add(next);
        add(toolBar, BorderLayout.SOUTH);


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
        } else {
            String TrainNo, TrainName, Time, Origin, Destination, Seats;
            int selectedRow = table.getSelectedRow();
            try {
                TrainNo = tableModel.getValueAt(selectedRow, 0).toString();
                TrainName = tableModel.getValueAt(selectedRow, 1).toString();
                Time = tableModel.getValueAt(selectedRow, 2).toString();
                Origin = tableModel.getValueAt(selectedRow, 3).toString();
                Destination = tableModel.getValueAt(selectedRow, 4).toString();
                Seats = tableModel.getValueAt(selectedRow, 5).toString();

                connection c = new connection();
                String query = "insert into train( pwd,TrainNo,TrainName,Time,Origin,Destination,Seats) values(?,?,?,?,?,?,?)";
                PreparedStatement prep = c.c.prepareStatement(query);
                prep.setString(1, pwd);
                prep.setString(2, TrainNo);
                prep.setString(3, TrainName);
                prep.setString(4, Time);
                prep.setString(5, Origin);
                prep.setString(6, Destination);
                prep.setString(7, Seats);
                prep.execute();

                int seat1 = (Integer.parseInt(Seats) - 1);
                String query2 = "Update train set Seats='" + seat1 + "' where TrainNo='" + TrainNo + "' ";
                c.s.executeUpdate(query2);



//               // Update the database with the reservation (assuming a method for this)
//                boolean reservationSuccess = reserveSeat(selectedRow);
//
//                if (reservationSuccess) {
//                    // Update the JTable model
//                    tableModel = (DefaultTableModel) table.getModel();
//
//                    // Find the row index of the selected train (optional but recommended)
//                    int selectedRowIndex = -1;
//                    for (int i = 0; i < tableModel.getRowCount(); i++) {
//                        Train train = (train) tableModel.getValueAt(i, 0); // Assuming Train object is at column 0
//                        if (train.getTrainNo() == selectedRow.getTrainNo()) {
//                            selectedRowIndex = i;
//                            break;
//                        }
//                    }
//
//                    // Update the specific row if found, otherwise update the entire table
//                    if (selectedRowIndex != -1) {
//                        // Update existing row with new data (assuming seats are reduced by 1)
//                        selectedTrain.setSeats(selectedTrain.getSeats() - 1);
//                        tableModel.setValueAt(selectedTrain, selectedRowIndex, 0); // Update column 0 with updated Train object
//                    } else {
//                        // Update entire table (less efficient, use only if row index not found)
//                        tableModel.setRowCount(0); // Clear existing data
//                        // Add new data to the table model (including updated selectedTrain)
//                    }
//
//                    // Inform the table about changes
//                    tableModel.fireTableDataChanged();
//                } else {
//                    // Show error message if reservation failed
//                    JOptionPane.showMessageDialog(null, "Reservation failed!", "Error", JOptionPane.ERROR_MESSAGE);
//                }

                setVisible(false);


            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        }
    }

    public static void main(String[]args){
            new Train("", "");
        }
    }

