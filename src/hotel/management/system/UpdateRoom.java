
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;



public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JTextField tfroom, tfcheckin, tfpending, tfname, tfpaid,tfavailable,tfstatus;
    JButton check,update, back;
    
UpdateRoom(){
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    
    JLabel text = new JLabel("Update Room status");
    text.setBounds(30,20,250,30);
  add(text);
  
   JLabel lblid = new JLabel("Customer Id");
    lblid.setBounds(30,80,100,20);
  add(lblid);
    
  ccustomer = new Choice();
  ccustomer.setBounds(200,80,150,25);
  add(ccustomer);
  
    try {
        Conn c = new Conn();
        ResultSet  rs = c.s.executeQuery("select * from customer");
        
        
        while(rs.next()){
            ccustomer.add(rs.getString("number"));
        }
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    
    JLabel lblroom = new JLabel("Room Number");
    lblroom.setBounds(30,120,100,20);
  add(lblroom);
  
  tfroom = new JTextField();
  tfroom.setBounds(200,120,150,25);
  add(tfroom);
  
  
  JLabel lblname = new JLabel("Availablity");
    lblname.setBounds(30,160,100,20);
  add(lblname);
  
  tfavailable = new JTextField();
  tfavailable.setBounds(200,160,150,25);
  add(tfavailable);
  
  
  JLabel lblcheckin = new JLabel("Cleaning status");
    lblcheckin.setBounds(30,200,130,20);
  add(lblcheckin);
  
  tfstatus = new JTextField();
  tfstatus.setBounds(200,200,180,25);
  add(tfstatus);
  
  
  
  
  
    check = new JButton("Check");
check.setBounds(30,300,100,30);
check.addActionListener(this);
  add(check);
  
  
  
    update = new JButton("Update");
update.setBounds(150,300,100,30);
update.addActionListener(this);
  add(update);
  
  back = new JButton("Back");
back.setBounds(270,300,100,30);
back.addActionListener(this);
  add(back);
  
  ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
 Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);

 ImageIcon i3 = new ImageIcon(i2);
 JLabel image = new JLabel(i3);
  image.setBounds(400,50,500,300);
  add(image);
  
  
  
   setBounds(100,100,980,450);
   setVisible(true);
   
   
   
   
   
}
public void actionPerformed(ActionEvent ae){
    if(ae.getSource()== check){
        String id = ccustomer.getSelectedItem();
        String query = "select * from customer where number ='"+id+"'";
        try {
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                tfroom.setText(rs.getString("room"));
               
               
            }
            
 ResultSet rs2 = c.s.executeQuery("select * from room where roomnuber = '"+tfroom.getText()+"'");
    while(rs2.next()){
      tfavailable.setText(rs2.getString("availablity"));
       tfstatus.setText(rs2.getString("cleanin_status"));
    }
 
 
 
        } catch (Exception e) {
        
        e.printStackTrace();
        }
        
    }else if (ae.getSource() == update){
    String number = ccustomer.getSelectedItem();
    String room = tfroom.getText();
    String available = tfavailable.getText();
    String status = tfstatus.getText();
   
        try {
            
            Conn c = new Conn();
c.s.executeUpdate("update room set availablity = '"+available+"', cleanin_status = '"+status+"' where roomnuber = '"+room+"'");
          
JOptionPane.showMessageDialog(null, "data updated Successfully");
         
            setVisible(false);
             new Reception();
            
            
            
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
}else if(ae.getSource()== back){
        setVisible(false);
        new Reception();

}
}





   public static void main(String[] args) {
        new UpdateRoom();
    }
}
