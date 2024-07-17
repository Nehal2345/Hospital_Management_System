package hospital.management.system;

import com.mysql.cj.x.protobuf.MysqlxSession;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.spec.ECField;
import java.sql.ResultSet;

public class Search_room extends JFrame
{
    Choice choice ;
    JTable table;

    Search_room(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel search = new JLabel("Search For Room");
        search.setBounds(250,11,186,31);
        search.setForeground(Color.white);
        search.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(search);

        JLabel status = new JLabel("Status :");
        status.setBounds(70,0,80,20);
        status.setForeground(Color.white);
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(status);

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBackground(new Color(90,156,163));
        table.setBounds(0,187,700,210);
        table.setForeground(Color.white);
        panel.add(table);

        try {
            connection c =new connection();
            String q = "select * from room1";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));




        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel Roomno = new JLabel("Room Number");
        Roomno.setBounds(23,162,150,20);
        Roomno.setForeground(Color.white);
        Roomno.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(Roomno);

        JLabel available = new JLabel("Availability :");
        available.setBounds(175,162,150,20);
        available.setForeground(Color.white);
        available.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(available);

        JLabel price = new JLabel("Prize :");
        price.setBounds(458,162,150,20);
        price.setForeground(Color.white);
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(price);

        JLabel bed = new JLabel("Bed :");
        bed.setBounds(580,162,150,20);
        bed.setForeground(Color.white);
        bed.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(bed);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(200,420,120,25);
        searchBtn.setBackground(Color.BLACK);
        searchBtn.setForeground(Color.white);
        panel.add(searchBtn);

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(380,420,120,25);
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.white);
        panel.add(backBtn);
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from room where availability = '"+choice.getSelectedItem()+"'";
                try{
                    connection c = new connection();
                    ResultSet rs = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        setUndecorated(true);
        setLayout(null);
        setSize(700,500);
        setLocation(450,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Search_room();
    }
}
