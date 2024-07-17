package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class patient_dis extends JFrame
{
    patient_dis()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check-out");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma", Font.BOLD,20));
        label.setForeground(Color.BLACK);
        panel.add(label);

        JLabel label1 = new JLabel("Customer ID");
        label1.setBounds(30,80,150,20);
        label1.setFont(new Font("Tahoma", Font.BOLD,14));
        label1.setForeground(Color.BLACK);
        panel.add(label1);

        Choice choice = new Choice();
        choice.setBounds(200,80, 150 ,25);
        panel.add(choice);

        try {
            connection c = new connection();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info1");
            while (resultSet.next()){
                choice.add(resultSet.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label2 = new JLabel("Room Number");
        label2.setBounds(30,130,150,20);
        label2.setFont(new Font("Tahoma", Font.BOLD,14));
        label2.setForeground(Color.BLACK);
        panel.add(label2);

        JLabel RNo = new JLabel();
        RNo.setBounds(200,130,150,20);
        RNo.setFont(new Font("Tahoma", Font.BOLD,20));
        RNo.setForeground(Color.BLACK);
        panel.add(RNo);

        JLabel label3 = new JLabel("In Time");
        label3.setBounds(30,180,150,20);
        label3.setFont(new Font("Tahoma", Font.BOLD,14));
        label3.setForeground(Color.BLACK);
        panel.add(label3);

        JLabel INTime = new JLabel();
        INTime.setBounds(200,180,250,20);
        INTime.setFont(new Font("Tahoma", Font.BOLD,14));
        INTime.setForeground(Color.BLACK);
        panel.add(INTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font("Tahoma", Font.BOLD,14));
        label5.setForeground(Color.BLACK);
        panel.add(label5);

        Date date = new Date();

        JLabel OUTTime = new JLabel(""+date);
        OUTTime.setBounds(200,230,250,20);
        OUTTime.setFont(new Font("Tahoma", Font.BOLD,14));
        OUTTime.setForeground(Color.BLACK);
        panel.add(OUTTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(100,300,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.white);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection c = new connection();
                try {
                    c.statement.executeUpdate("delete from patient_info1 where number='"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update Room1 set Availability = 'Available' where room_no='"+ RNo.getText()+"'");
                    JOptionPane.showMessageDialog(null, "Done");
                    setVisible(false);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton button1 = new JButton("Check");
        button1.setBounds(250,300,120,30);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.white);
        panel.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection c = new connection();

                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from patient_info1 where number = '"+choice.getSelectedItem()+"'");
                    while (resultSet.next())
                    {
                        RNo.setText(resultSet.getString("room_no"));
                        INTime.setText(resultSet.getString("Time"));

                    }

                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });

        JButton button2 = new JButton("Back");
        button2.setBounds(400,300,120,30);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.white);
        panel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);

    }


    public static void main(String[] args) {
        new patient_dis();
    }
}
