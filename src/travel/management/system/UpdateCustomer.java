package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class UpdateCustomer extends JFrame implements ActionListener {

    JLabel labelusername, labelname;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone, tfid, tfgender;
    JButton add, back;
    String username;

    public UpdateCustomer(String username) {
        
        this.username = username;
        setBounds(350, 150, 700, 450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(60, 0, 300, 25);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(25, 40, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 40, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("Id");
        lblid.setBounds(25, 70, 150, 25);
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(220, 70, 150, 25);
        add(tfid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(25, 100, 150, 25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 100, 150, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(25, 130, 150, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220, 130, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(25, 160, 150, 25);
        add(lblgender);

        tfgender = new JTextField();
        tfgender.setBounds(220, 160, 150, 25);
        add(tfgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(25, 190, 150, 25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 190, 150, 25);
        add(tfcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(25, 220, 150, 25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 220, 150, 25);
        add(tfaddress);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(25, 250, 150, 25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 250, 150, 25);
        add(tfphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(25, 280, 150, 25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220, 280, 150, 25);
        add(tfemail);

        add = new JButton("Update");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 330, 100, 25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 330, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(150, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 300, 300);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();

            try {
                Conn c = new Conn();
                String query = "update customer set username='" + username + "', id = '" + id + "', number = '" + number + "', name = '" + name + "', gender = '" + gender + "', country = '" + country + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "'";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Deatails Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("");
    }
}
