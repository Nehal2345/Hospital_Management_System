package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame
{
    JButton button;

    Employee_info(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,980,450);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);

        try {
            connection c = new connection();
            String q = "select * from Emp";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label = new JLabel("Name");
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        label.setBounds(41,9,70,20);
        panel.add(label);

        JLabel label1 = new JLabel("Age");
        label1.setBounds(180,9,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(350,9,200,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Salary");
        label3.setBounds(520,9,70,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Email");
        label4.setBounds(680,9,70,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 = new JLabel("Aadhar Number");
        label5.setBounds(850,9,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JButton b1 = new JButton("Back");
        b1.setBounds(350,500,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(1000,600);
        setLocation(320,210);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Employee_info();
    }
}
