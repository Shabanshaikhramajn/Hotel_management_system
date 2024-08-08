
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;






public class AddDriver extends  JFrame implements ActionListener{
JButton add,cancel;
JTextField tfmodel, tfcompany,tfname,tfage, tflocation;
    JComboBox  agecombo,gendercombo,availablecombo;
    
    AddDriver(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150,20,200,20);
       add(heading);
        
           
        JLabel lblroomno = new JLabel("name");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblroomno.setBounds(60,80,120,30);
       add(lblroomno);
        
        tfname = new JTextField();
       tfname.setBounds(200,80,150,30);
        add(tfname);
        
         JLabel lblavailable = new JLabel("age");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblavailable.setBounds(60,130,120,30);
       add(lblavailable);
        
        tfage = new JTextField();
       tfage.setBounds(200,130,150,30);
        add(tfage);
        
        
        JLabel lblclean = new JLabel("gender");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblclean.setBounds(60,180,120,30);
       add(lblclean);
        
        String cleanoptions[] = {"MAle", "Female"};
        
         gendercombo = new JComboBox(cleanoptions);
        
        gendercombo.setBounds(200,180,150,30);
        add(gendercombo);
        
        JLabel lblprice = new JLabel("car company");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblprice.setBounds(60,230,120,30);
       add(lblprice);
        
        tfcompany = new JTextField();
       tfcompany.setBounds(200,230,150,30);
        add(tfcompany);
        
        JLabel lbltype = new JLabel("car model");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbltype.setBounds(60,280,120,30);
       add(lbltype);
        
        tfmodel = new JTextField();
       tfmodel.setBounds(200,280,150,30);
        add(tfmodel);
        
        
         JLabel lblavailable1 = new JLabel("available");
        lblavailable1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblavailable1.setBounds(60,330,120,30);
       add(lblavailable1);
       
       String driveroptions[] = {"available", "busy"};
        
         availablecombo = new JComboBox(driveroptions);
        
        availablecombo.setBounds(200,330,150,30);
        add(availablecombo);
       
        
        
         JLabel lbllocation = new JLabel("available location");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbllocation.setBounds(60,380,120,30);
       add(lbllocation);
        
        tflocation = new JTextField();
       tflocation.setBounds(200,380,150,30);
        add(tflocation);
       
        
         add = new JButton ("add driver");
        add.setBounds(60,430,130,30);
        add.addActionListener(this);
        add(add);
        
          cancel = new JButton ("cancel");
        cancel.setBounds(220,430,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
         
        JLabel image = new JLabel (i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        setBounds(300,100,980,550);
        setVisible(true);
        
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== add){
            
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String brand =  tfmodel.getText();
            String available = (String) availablecombo.getSelectedItem();
            String location = tflocation.getText();
            
            
            
            
            try{
                
                Conn conn = new Conn();
 String str = "insert into driver values('"+name+"', '"+age+"','"+gender+"', '"+company+"', '"+brand+"', '"+available+"', '"+location+"'  )";
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "new driver added succesfully");
                
                
                setVisible(false);
                
            }catch(Exception ee){
                ee.printStackTrace();
            }
            
            
        }else{
            setVisible(false);
        }
        


    }
    
    
    public static void main(String[] args) {
        new AddDriver();
    

    
}

    
    
    
}
