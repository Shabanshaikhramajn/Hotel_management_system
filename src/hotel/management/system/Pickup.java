/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;
/**
 *
 * @author ADMIN
 */
public class Pickup extends  JFrame implements ActionListener{
   
    JTable table;
    JButton back, submit;
    Choice  typeofcar;
    JCheckBox available;
    
    Pickup(){
            getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Pickup Service");
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel(" Type of Car");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
       typeofcar = new Choice();
       typeofcar.setBounds(150,100,200,25);
        add(typeofcar);
        try {
            Conn c = new Conn();
            ResultSet  rs = c.s.executeQuery("select  * from driver");
            while(rs.next()){
                typeofcar.add(rs.getString("brand"));
            }
            
            
        } catch (Exception e) {
        e.printStackTrace();
        }
        
      
        
         JLabel l1 = new JLabel ("Name");
        l1.setBounds(30,160,100,20);
        add(l1);
        
        JLabel l2 = new JLabel ("age");
        l2.setBounds(200,160,100,20);
        add(l2);
        
        JLabel l3 = new JLabel ("gender");
        l3.setBounds(330,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel ("company");
        l4.setBounds(460,160,100,20);
        add(l4);
        
        
          JLabel l5 = new JLabel ("Brand");
        l5.setBounds(630,160,100,20);
        add(l5);
        
        JLabel l6 = new JLabel ("Availability");
        l6.setBounds(740,160,100,20);
        add(l6);
        
        JLabel l7 = new JLabel ("Location");
        l7.setBounds(890,160,100,20);
        add(l7);
        
        table  = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        
        try {
            Conn c= new Conn();
            
      ResultSet rs =  c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
        
        e.printStackTrace();
        
        }
        
         submit = new JButton("submit");
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);
        
        
        
        back = new JButton("Back");
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);
        
        
        setBounds(100,100,1050,600);
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new Pickup();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

if(e.getSource()== submit)
        {
            try {
String query =  "select * from driver where brand = '"+typeofcar.getSelectedItem()+"'";
                
               Conn conn = new Conn();
                ResultSet rs;
               
                  rs = conn.s.executeQuery(query);
                   table.setModel(DbUtils.resultSetToTableModel(rs));
              
               
                
            } catch (Exception ee) {
                ee.printStackTrace();
            }
            
            
            
            
            
            
            
    }else {
    setVisible(false);
 new Reception();
    
}
    
}}
