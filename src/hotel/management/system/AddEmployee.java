
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener{
    
    JTextField age, tfname, tfemail,tfphone, tfage , tfsalary;
    
    JRadioButton male , female;
    JComboBox cbjob;
           JButton submit;
    
   AddEmployee(){
       
       JLabel lblname = new JLabel("name");
       lblname.setBounds(60,30,120,30);
       lblname.setFont(new Font("Raleway", Font.PLAIN, 17));
       add(lblname);
       
       
       tfname = new JTextField();
       tfname.setBounds(200,30,150,30);
       add(tfname);
       
       
         JLabel age1 = new JLabel("age1");
       age1.setBounds(60,80,120,30);
       age1.setFont(new Font("Raleway", Font.PLAIN, 17));
       add(age1);
       
       
        age = new JTextField();
       age.setBounds(200,80,150,30);
       add(age);
       
       
          JLabel lblgender = new JLabel("gender");
       lblgender.setBounds(60,130,120,30);
       lblgender.setFont(new Font("Raleway", Font.PLAIN, 17));
       add(lblgender);
       
       
        male = new JRadioButton("Male");
       male.setBackground(Color.WHITE);
       male.setBounds(200,130,70,30);
       add(male);
       
        female = new JRadioButton("FEMale");
       female.setBackground(Color.WHITE);
       female.setBounds(280,130,70,30);
       add(female);
       
       
       
       JLabel lbljob = new JLabel("job");
       lbljob.setBounds(60,180,120,30);
       lbljob.setFont(new Font("Raleway", Font.PLAIN, 17));
       add(lbljob);
       
String valcbjob[] = { "cleark", "porter","housekeeping","room service", "chefs","waiter","manager","accountant"};
         cbjob = new JComboBox(valcbjob);
       cbjob.setBounds(200,180,150,30);
       add(cbjob);
       
        JLabel lblsalary = new JLabel("salary");
       lblsalary.setBounds(60,230,120,30);
       lblsalary.setFont(new Font("Raleway", Font.PLAIN, 17));
       add(lblsalary);
       
       
        tfsalary = new JTextField();
       tfsalary.setBounds(200,230,150,30);
       add(tfsalary);
       
       
        JLabel lblphone = new JLabel("phone");
       lblphone.setBounds(60,320,120,30);
       lblphone.setFont(new Font("Raleway", Font.PLAIN, 17));
       add(lblphone);
       
       
        tfphone = new JTextField();
       tfphone.setBounds(200,320,150,30);
       add(tfphone);
       
        submit = new JButton("SUbmit");
       
       submit.setBounds(200,430,160,30);
       submit.addActionListener(this);
       add(submit);
       
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
      Image i2 = i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
       image.setBounds(380,60,450,430);
               add(image);
       
       
       
       
       
       
       setLayout(null);
              getContentPane().setBackground(Color.WHITE);
       setBounds(350,200,850,540);
       
       
       
       
       setVisible(true);
       
   } 
   @Override
     public void actionPerformed(ActionEvent ae){
        String name = tfname.getName();
        String age = tfname.getText();
        String salary = tfsalary.getText();
        String phone = tfphone.getText();
       
        
        String gender = null;
        if(male.isSelected()){
            
            gender  = "Male";
            
        }else if(female.isSelected()){
            gender = "Female";
        
        
    }
        String job = (String)cbjob.getSelectedItem();
        
   
   try{
       
       Conn conn = new Conn();
       
 String query = "insert into employee values (  '"+name+"','"+age+"', '"+gender+"', '"+job+"',  '"+salary+"','"+phone+"')";
       
       conn.s.executeUpdate(query);
       
       JOptionPane.showMessageDialog(null, "Employee added successfylly");
       
       
   }catch(Exception e){
       e.printStackTrace();
   }
   
     }
    public static void main(String[] args) {
       new AddEmployee(); 
        
        
        
    }
  
    
    
}
