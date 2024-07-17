package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame{
    Ambulance(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(98,156,163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,50,900,450);
        table.setBackground(new Color(98,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        table.setForeground(Color.BLACK);
        table.setLayout(null);
        panel.add(table);

        try {
            connection c = new connection();
            String q = "select * from ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label = new JLabel("Name");
        label.setBounds(31,11,100,14);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label);

        JLabel label1 = new JLabel("Gender");
        label1.setBounds(200,11,100,14);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Car Name");
        label2.setBounds(366,11,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Availability");
        label3.setBounds(540,11,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label5 = new JLabel("Location");
        label5.setBounds(750,11,100,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);


        JButton button = new JButton("Back");
        button.setBounds(370,510,120,30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.white);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300,220);
        setVisible(true);


    }

    public static void main(String[] args) {
        new Ambulance();
    }
}
