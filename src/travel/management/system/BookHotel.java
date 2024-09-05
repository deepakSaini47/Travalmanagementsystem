package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {

    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpackage, back;

    BookHotel(String username) {
        this.username = username;
        setBounds(250, 100, 900, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("BOOK Hotel");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahuma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahuma", Font.PLAIN, 16));
        lblusername.setBounds(30, 50, 150, 20);
        add(lblusername);

        labelusername = new JLabel("");
        labelusername.setFont(new Font("Tahhuma", Font.PLAIN, 16));
        labelusername.setBounds(200, 50, 200, 20);
        add(labelusername);

        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahuma", Font.PLAIN, 16));
        lblpackage.setBounds(30, 90, 150, 20);
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(200, 90, 200, 20);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setFont(new Font("Tahuma", Font.PLAIN, 16));
        lblpersons.setBounds(30, 130, 200, 20);
        add(lblpersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(200, 130, 200, 25);
        add(tfpersons);

        JLabel lbldays = new JLabel("No. of days");
        lbldays.setFont(new Font("Tahuma", Font.PLAIN, 16));
        lbldays.setBounds(30, 170, 150, 20);
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(200, 170, 200, 25);
        add(tfdays);

        JLabel lblac = new JLabel("Ac/ Non-Ac");
        lblac.setFont(new Font("Tahuma", Font.PLAIN, 16));
        lblac.setBounds(30, 210, 150, 20);
        add(lblac);

        cac = new Choice();
        cac.add("Ac");
        cac.add("Non-Ac");
        cac.setBounds(200, 210, 200, 20);
        add(cac);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahuma", Font.PLAIN, 16));
        lblfood.setBounds(30, 250, 150, 20);
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(200, 250, 200, 20);
        add(cfood);

        JLabel lblid = new JLabel("Id");
        lblid.setFont(new Font("Tahuma", Font.PLAIN, 16));
        lblid.setBounds(30, 290, 150, 20);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(200, 290, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahuma", Font.PLAIN, 16));
        lblnumber.setBounds(30, 330, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(200, 330, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahuma", Font.PLAIN, 16));
        lblphone.setBounds(30, 370, 150, 20);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(200, 370, 150, 25);
        add(labelphone);

        JLabel lbltotal = new JLabel("Total Price");
        lbltotal.setFont(new Font("Tahuma", Font.PLAIN, 16));
        lbltotal.setBounds(30, 410, 150, 25);
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setBounds(200, 410, 150, 25);
        add(labelprice);

        try {
            Conn conn = new Conn();
            String query = "select * from customer where username = '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 440, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 440, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 440, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(450, 50, 400, 250);
        add(l12);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '" + chotel.getSelectedItem() + "'");
                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    
                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    
                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    
                    if(persons * days > 0){
                        int total = 0;
                        total += acselected.equals("Ac") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total += total * persons * days;
                        labelprice.setText("Rs "+total);
                    } else{
                        JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
                    }
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('" + labelusername.getText() + "', '" + chotel.getSelectedItem() + "', '" + tfpersons.getText() + "', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labelprice.getText() + "')");

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("");
    }
}
