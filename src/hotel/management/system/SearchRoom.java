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
public class SearchRoom extends  JFrame implements ActionListener{
   
    JTable table;
    JButton back, submit;
    JComboBox bedtype;
    JCheckBox available;
    
    SearchRoom(){
            getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Search for room");
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel lblbed = new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);
        
       
        
        
        bedtype = new JComboBox(new String[] {"singlebed", "doublebed"});
        bedtype.setBounds(150,100,150,25);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);
        
        available = new JCheckBox("Only display available");
        available.setBounds(650,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        
         JLabel l1 = new JLabel ("room numbers");
        l1.setBounds(50,160,100,20);
        add(l1);
        
        JLabel l2 = new JLabel ("availablity");
        l2.setBounds(270,160,100,20);
        add(l2);
        
        JLabel l3 = new JLabel ("Status");
        l3.setBounds(450,160,100,20);
        add(l3);
        
        JLabel l4 = new JLabel ("price");
        l4.setBounds(670,160,100,20);
        add(l4);
        
        
          JLabel l5 = new JLabel ("bed type");
        l5.setBounds(870,160,100,20);
        add(l5);
        
        table  = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
        
        
        try {
            Conn c= new Conn();
            
      ResultSet rs =  c.s.executeQuery("select * from room");
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
        new SearchRoom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

if(e.getSource()== submit)
        {
            try {
String query1 =  "select * from room where bedtype = '"+bedtype.getSelectedItem()+"'";
String query2 = "select * from room where availablity ='Available' AND  bedtype = '"+bedtype.getSelectedItem()+"' " ;         
                
               Conn conn = new Conn();
                ResultSet rs;
               if(available.isSelected()){
                  rs = conn.s.executeQuery(query2);
                   
               }else{
                   rs = conn.s.executeQuery(query1);
               }
                
               table.setModel(DbUtils.resultSetToTableModel(rs));
               
               
                
            } catch (Exception ee) {
                ee.printStackTrace();
            }
            
            
            
            
            
            
            
    }else {
    setVisible(false);

    new Reception();
}
    
}}
