package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame
{

    update_patient_details(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,11,250,25);
        label1.setFont(new Font("Tahoma", Font.BOLD,20));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(24,88,80,14);
        label2.setFont(new Font("Tahoma", Font.PLAIN,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,140,25);
        panel.add(choice);

        try {
            connection c = new connection();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info1");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }


        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number :");
        label3.setBounds(25,129,150,14);
        label3.setFont(new Font("Tahoma", Font.PLAIN,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textField = new JTextField();
        textField.setBounds(248,129,140,20);
        panel.add(textField);

        JLabel label4 = new JLabel("IN-Time :");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma", Font.PLAIN,14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textField1 = new JTextField();
        textField1.setBounds(248,174,140,20);
        panel.add(textField1);

        JLabel label5 = new JLabel("Amount Paid :");
        label5.setBounds(25,216,150,14);
        label5.setFont(new Font("Tahoma", Font.PLAIN,14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textField2 = new JTextField();
        textField2.setBounds(248,216,140,20);
        panel.add(textField2);

        JLabel label6 = new JLabel("Pending Amount :");
        label6.setBounds(25,264,150,14);
        label6.setFont(new Font("Tahoma", Font.PLAIN,14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textField3 = new JTextField();
        textField3.setBounds(248,261, 140,20);
        panel.add(textField3);

        JButton button = new JButton("Check");
        button.setBounds(281,378,89,23);
        button.setForeground(Color.white);
        button.setBackground(Color.BLACK);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info1 where Name='"+id+"'";


                try{
                    connection c = new connection();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while(resultSet.next()){
                        textField.setText(resultSet.getString("room_no"));
                        textField1.setText(resultSet.getString("Time"));
                        textField2.setText(resultSet.getString("Deposit"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room1 where room_no='"+textField.getText()+"'");
                    while (resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textField2.getText());
                        textField3.setText(""+amountPaid);

                    }
                } catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton button1 = new JButton("Update");
        button1.setBounds(56,378,89,23);
        button1.setForeground(Color.white);
        button1.setBackground(Color.BLACK);
        panel.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    connection c = new connection();
                    String q = choice.getSelectedItem();
                    String room =textField.getText();
                    String time = textField1.getText();
                    String amount = textField2.getText();
                    c.statement.executeUpdate("update patient_info1 set room_no='"+room+"',Time='"+time+"',Deposit='"+amount+"' where Name= '"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }catch (Exception e1){

                }
            }
        });

        JButton button2 = new JButton("Back");
        button2.setBounds(168,378,89,23);
        button2.setForeground(Color.white);
        button2.setBackground(Color.BLACK);
        panel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setLayout(null);
        setUndecorated(true);
        setSize(950,500);
        setLocation(400,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new update_patient_details();
    }

}
