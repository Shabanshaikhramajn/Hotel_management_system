
package hotel.management.system;


import javax.swing.*;

import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;  
  

public class Dashboard  extends JFrame implements ActionListener{
    Dashboard(){
        setBounds(0,0,1150,1000);
            
        
         JLabel text = new JLabel("The taj group welcomes you");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN, 47));
            text.setForeground(Color.BLACK);
        add(text);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1150, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,10005);
        add(image);
        
       
        
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1550,30);
        
        image.add(mb);
        
        JMenu hotel = new JMenu("HOtel management");
        hotel.setForeground(Color.RED);
        mb.add(hotel);
        
        JMenuItem reception = new JMenuItem("Reception");
        reception.addActionListener(this);
        hotel.add(reception);
        
        
        
        
        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.RED);
       mb.add(admin);
        
       
       JMenuItem addemploye = new JMenuItem("ADD employee");
       addemploye.addActionListener(this);
       admin.add(addemploye);
       
       JMenuItem addrooms = new JMenuItem("Add Rooms");
       addrooms.addActionListener(this);
       admin.add(addrooms);
       
       JMenuItem adddriver = new JMenuItem("ADD Driver");
       adddriver.addActionListener(this);
       admin.add(adddriver);
       
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getActionCommand().equals("ADD employee"))
        {
            new AddEmployee();
        }else if( ae.getActionCommand().equals("Add Rooms"))
        {
            new Addrooms();
        }else if (ae.getActionCommand().equals("ADD Driver")){
            new AddDriver();
        }else if(ae.getActionCommand().equals("Reception")){
            new Reception();
        }
    }
    
    
    public static void main(String[] args) {
        new Dashboard();
    }
}
