
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import net.proteanit.sql.*;

public class EmployeeInfo  extends  JFrame implements ActionListener{
    EmployeeInfo(){
        JTable table;
        JButton back;
        
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
       
        
        
        JLabel l1 = new JLabel ("Name");
        l1.setBounds(40,10,100,20);
        add(l1);
        
        
        JLabel l2 = new JLabel ("Age");
        l2.setBounds(220,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel ("Gender");
        l3.setBounds(370,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel ("Job");
        l4.setBounds(560,10,100,20);
        add(l4);
        
        
          JLabel l5 = new JLabel ("Salary");
        l5.setBounds(700,10,100,20);
        add(l5);
        
         JLabel l6 = new JLabel ("Phone number");
        l6.setBounds(870,10,100,20);
        add(l6);
        
        table  = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
        
        
        try {
            Conn c= new Conn();
            
      ResultSet rs =  c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
        
        e.printStackTrace();
        
        }
        back = new JButton("Back");
        back.addActionListener(this);
        back.setBounds(420,500,120,30);
        add(back);
        
        
        setBounds(300,200,1050,600);
        setVisible(true);
        
        
        
    }
    
  @Override
    public void actionPerformed(ActionEvent ae ){
        setVisible(false);
        new Reception();
    }
    
    
    public static void main(String[] args) {
        
        new EmployeeInfo();
    }

    
    
    
}
