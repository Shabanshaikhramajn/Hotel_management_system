
package hotel.management.system;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;


public class Checkout extends  JFrame implements  ActionListener{
    
    Choice ccustomer;
    JLabel roomnumber,lblroomnumber,lblcheckouttime,lblcheckin;
    JButton checkout, back;
    Checkout()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(100,20,100,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);
        
        
        
        JLabel lblid = new JLabel("Customer Id");
        lblid.setBounds(30,80,100,30);
        add(lblid);
        
        ccustomer = new Choice();
  ccustomer.setBounds(150,80,150,25);
  add(ccustomer);
  
    
        
        ImageIcon i1 =  new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick = new JLabel (i3);
        tick.setBounds(310,80,20,20);
    add(tick);
    
    
    JLabel lblroom = new JLabel("Room number");
    lblroom.setBounds(30,130,100,30);
    add(lblroom);
    
     lblroomnumber = new JLabel();
    lblroomnumber.setBounds(150,130,100,30);
    add(lblroomnumber);
    
    
    JLabel lblcheckin = new JLabel("Checkin time");
    lblcheckin.setBounds(30,180,100,30);
    add(lblcheckin);
    
     lblcheckin = new JLabel();
    lblcheckin.setBounds(150,180,100,30);
    add(lblcheckin);
    
    
    JLabel lblcheckout = new JLabel("Checkout time");
    lblcheckout.setBounds(30,230,100,30);
    add(lblcheckout);
    
    
    
    Date date = new Date();
     lblcheckouttime = new JLabel(""+ date);
    lblcheckouttime.setBounds(150,230,150,30);
    add(lblcheckouttime);
    
    checkout  = new JButton("Checkout");
    checkout.setBounds(30,280,120,30);
    checkout.addActionListener(this);
    add(checkout);
    
    
    back  = new JButton("Back");
    back.setBounds(170,280,120,30);
    back.addActionListener(this);
    add(back);
    
    
    try {
        Conn c = new Conn();
        ResultSet  rs = c.s.executeQuery("select * from customer");
        
        
        while(rs.next()){
            ccustomer.add(rs.getString("number"));
            lblroomnumber.setText(rs.getString("room"));
            lblcheckin.setText(rs.getString("chekckingtime"));
        }
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    ImageIcon i4 =  new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel (i6);
        image.setBounds(350,50,400,250);
    add(image);
    
        setBounds(300,200,800,400);
        setVisible(true);
    
    }
    
    public static void main(String[] args) {
        new Checkout();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
if(e.getSource()== checkout){
    String query1 = "delete from customer where number = '"+ccustomer.getSelectedItem()+"'    ";
    String query2 = "update room set availablity = 'Available' where roomnuber = '"+lblroomnumber.getText()+"'  ";
    
    try {
        
        Conn c = new Conn();
        c.s.executeUpdate(query1);
        c.s.executeUpdate(query2);
        
        JOptionPane.showMessageDialog(null, "checkout done");
        setVisible(false);
        new Reception();
        
        
        
        
        
    } catch (Exception ee) {
    ee.printStackTrace();}
    
}else{
    setVisible(false);
    new Reception();

}



    }
            
            }
