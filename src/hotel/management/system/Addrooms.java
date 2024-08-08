
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;




public class Addrooms extends  JFrame implements ActionListener{
JButton add,cancel;
JTextField tfroom, tfprice;
    JComboBox  typecombo, availablecombo, cleancombo;
    
    Addrooms(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("add rooms");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150,20,200,20);
       add(heading);
        
           
        JLabel lblroomno = new JLabel("Room no");
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblroomno.setBounds(60,80,120,30);
       add(lblroomno);
        
        tfroom = new JTextField();
       tfroom.setBounds(200,80,150,30);
        add(tfroom);
        
         JLabel lblavailable = new JLabel("available room");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblavailable.setBounds(60,130,120,30);
       add(lblavailable);
        
        String availableoptions[] = {"Available", "Occupied"};
        
         availablecombo = new JComboBox(availableoptions);
        
        availablecombo.setBounds(200,130,150,30);
        add(availablecombo);
        
        
        JLabel lblclean = new JLabel("cleaning status room");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblclean.setBounds(60,180,120,30);
       add(lblclean);
        
        String cleanoptions[] = {"cleaned", "dirty"};
        
         cleancombo = new JComboBox(cleanoptions);
        
        cleancombo.setBounds(200,180,150,30);
        add(cleancombo);
        
        JLabel lblprice = new JLabel("Room price");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblprice.setBounds(60,230,120,30);
       add(lblprice);
        
        tfprice = new JTextField();
       tfprice.setBounds(200,230,150,30);
        add(tfprice);
        
        JLabel lbltype = new JLabel("bed type");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbltype.setBounds(60,280,120,30);
       add(lbltype);
        
        String bedoptions[] = {"singlebed", "doublebed"};
        
         typecombo = new JComboBox(bedoptions);
        
        typecombo.setBounds(200,280,150,30);
        add(typecombo);
        
         add = new JButton ("add room");
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
          cancel = new JButton ("cancel");
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel (i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        
        setBounds(330,200,940,470);
        setVisible(true);
        
        
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== add){
            
            String roomnumber = tfroom.getText();
            String availability = (String)availablecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) typecombo.getSelectedItem();
            
            
            try{
                
                Conn conn = new Conn();
                String str = "insert into room values('"+roomnumber+"', '"+availability+"','"+status+"', '"+price+"', '"+type+"'    )";
                conn.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "new room added succesfully");
                
                
                setVisible(false);
                
            }catch(Exception ee){
                ee.printStackTrace();
            }
            
            
        }else{
            setVisible(false);
        }
        


    }
    
    
    public static void main(String[] args) {
        new Addrooms();
    }

    
}
