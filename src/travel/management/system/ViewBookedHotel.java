
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class ViewBookedHotel extends JFrame implements ActionListener {
    
    JButton back;
    
    ViewBookedHotel(String username){
        setBounds(320, 150, 800, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahuma", Font.BOLD, 20));
        text.setBounds(60, 0, 400, 30);
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(25, 40, 150, 25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 40, 150, 25);
        add(labelusername);
        
        JLabel lblid = new JLabel("Hotel Name");
        lblid.setBounds(25, 80, 150, 25);
        add(lblid);
        
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220, 80, 150, 25);
        add(labelpackage);
        
        JLabel lblnumber = new JLabel("Total Persons");
        lblnumber.setBounds(25, 120, 150, 25);
        add(lblnumber);
        
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220, 120, 150, 25);
        add(labelpersons);
        
        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(25, 160, 150, 25);
        add(lbldays);
        
        JLabel labeldays = new JLabel();
        labeldays.setBounds(220, 160, 150, 25);
        add(labeldays);
        
        JLabel lblac = new JLabel("Ac/Non-Ac");
        lblac.setBounds(25, 200, 150, 25);
        add(lblac);
        
        JLabel labelac = new JLabel();
        labelac.setBounds(220, 200, 150, 25);
        add(labelac);
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(25, 240, 150, 25);
        add(lblfood);
        
        JLabel labelfood = new JLabel();
        labelfood.setBounds(220, 240, 150, 25);
        add(labelfood);
        
        JLabel lblname = new JLabel("Id");
        lblname.setBounds(25, 280, 150, 25);
        add(lblname);
        
        JLabel labelid = new JLabel("");
        labelid.setBounds(220, 280, 150, 25);
        add(labelid);
        
        JLabel lblgender = new JLabel("Number");
        lblgender.setBounds(25, 320, 150, 25);
        add(lblgender);
        
        JLabel labelnumber = new JLabel("");
        labelnumber.setBounds(220, 320, 150, 25);
        add(labelnumber);
        
        JLabel lblcountry = new JLabel("Phone");
        lblcountry.setBounds(25, 360, 150, 25);
        add(lblcountry);
        
        JLabel labelphone = new JLabel("");
        labelphone.setBounds(220, 360, 150, 25);
        add(labelphone);
        
         JLabel lbladdress = new JLabel("Total Cost");
        lbladdress.setBounds(25, 400, 150, 25);
        add(lbladdress);
        
        JLabel labelprice = new JLabel("");
        labelprice.setBounds(220, 400, 150, 25);
        add(labelprice);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(110, 430, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 15, 350, 350);
        add(image);

        try{
            Conn conn = new Conn();
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("name"));
                labelprice.setText(rs.getString("price"));
                labelphone.setText(rs.getString("phone"));
                labelpersons.setText(rs.getString("persons"));
                labelfood.setText(rs.getString("food"));
                labelac.setText(rs.getString("ac"));
                labeldays.setText(rs.getString("days"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args){
        new ViewBookedHotel("red");
    }
}
