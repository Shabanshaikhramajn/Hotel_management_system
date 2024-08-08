
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends  JFrame implements ActionListener{
    JButton newcustomer, rooms,department,allEmployee, managerinfo, logout,checkout, update,roomsStatus
           , customerinfo,searchRoom,pickup;
    Reception(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
         newcustomer = new JButton("new customer form ");
        newcustomer.setBounds(10,30,200,30);
        newcustomer.addActionListener(this);
        add(newcustomer);
        
         rooms = new JButton("Rooms ");
        rooms.addActionListener(this);
        rooms.setBounds(10,70,200,30);
        add(rooms);
        
        
         department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.addActionListener(this);
        add(department);
        
          allEmployee = new JButton("All Employee ");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.addActionListener(this);
        add(allEmployee);
        
            customerinfo = new JButton("Customer Info");
        customerinfo.setBounds(10,190,200,30);
        customerinfo.addActionListener(this);
        add(customerinfo);
        
         managerinfo = new JButton("Manager Info");
        managerinfo.setBounds(10,230,200,30);
        managerinfo.addActionListener(this);
        add(managerinfo);
        
        
          checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.addActionListener(this);
        add(checkout);
        
        
          update = new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.addActionListener(this);
        add(update);
        
        
          roomsStatus = new JButton("Update Room Status");
        roomsStatus.setBounds(10,350,200,30);
        roomsStatus.addActionListener(this);
        add(roomsStatus);
        
         pickup = new JButton("pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.addActionListener(this);
        add(pickup);
        
          searchRoom = new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.addActionListener(this);
        add(searchRoom);
        
         logout = new JButton("LogOut");
        logout.setBounds(10,470,200,30);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);
        
        
        setBounds(100,100,800,570);
        setVisible(true);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== newcustomer){
            setVisible(false);
            new AddCustomer();
        
        
        }else if(ae.getSource()== rooms){
            setVisible(false);
            new Room();
        }else if (ae.getSource()== department){
            setVisible(false);
            new Department();
        }else if (ae.getSource()== allEmployee){
            setVisible(false);
            new EmployeeInfo();
        
        }else if (ae.getSource()== managerinfo){
            setVisible(false);
            new ManagerInfo();
        
        }else if (ae.getSource()== customerinfo){
            setVisible(false);
            new CustomerInfo();
        }else if(ae.getSource()== searchRoom){
            setVisible(false);
            new SearchRoom();
        
        }else if(ae.getSource()== update){
            setVisible(false);
            new UpdateCheck();
        
        }
        else if(ae.getSource()== roomsStatus){
            setVisible(false);
            new UpdateRoom();
        
        }else if(ae.getSource()== pickup){
            setVisible(false);
            new Pickup();
        
        }else if(ae.getSource()== checkout){
            setVisible(false);
            new Checkout();
        
        }else if(ae.getSource()== logout){
            setVisible(false);
           System.exit(0);
        
        }
    }
    
    
    public static void main(String[] args) {
        new Reception();
    }
    
    
}
