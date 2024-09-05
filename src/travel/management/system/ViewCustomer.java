
package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewCustomer extends JFrame implements ActionListener{
    
    JButton back;
    String username;
    
    ViewCustomer(String username){
        this.username = username;
        setBounds(400, 150, 750, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(25, 40, 150, 25);
        add(lblusername);
        
        JLabel labelusername = new JLabel("");
        labelusername.setBounds(220, 40, 150, 25);
        add(labelusername);
        
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(25, 80, 150, 25);
        add(lblid);
        
        JLabel labelid = new JLabel("");
        labelid.setBounds(220, 80, 150, 25);
        add(labelid);
        
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(25, 120, 150, 25);
        add(lblnumber);
        
        JLabel labelnumber = new JLabel("");
        labelnumber.setBounds(220, 120, 150, 25);
        add(labelnumber);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(25, 160, 150, 25);
        add(lblname);
        
        JLabel labelname = new JLabel("");
        labelname.setBounds(220, 160, 150, 25);
        add(labelname);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(25, 200, 150, 25);
        add(lblgender);
        
        JLabel labelgender = new JLabel("");
        labelgender.setBounds(220, 200, 150, 25);
        add(labelgender);
        
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(395, 40, 150, 25);
        add(lblcountry);
        
        JLabel labelcountry = new JLabel("");
        labelcountry.setBounds(600, 40, 150, 25);
        add(labelcountry);
        
         JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(395, 80, 150, 25);
        add(lbladdress);
        
        JLabel labeladdress = new JLabel("");
        labeladdress.setBounds(600, 80, 150, 25);
        add(labeladdress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(395, 120, 150, 25);
        add(lblphone);
        
        JLabel labelphone = new JLabel("");
        labelphone.setBounds(600, 120, 150, 25);
        add(labelphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(395, 160, 150, 25);
        add(lblemail);
        
        JLabel labelemail = new JLabel("");
        labelemail.setBounds(600, 160, 150, 25);
        add(labelemail);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 240, 100, 25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(460, 180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(10, 320, 460, 180);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(460, 180, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(460, 320, 460, 180);
        add(image2);
        
        try{
            Conn conn = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
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
        new ViewCustomer("");
    }
}
