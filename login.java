package BMS;


import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class login extends JFrame {
	JTextField cardnumber, pinnumber;
	String pinNumber;
	String cardNum;
    
    login(){
    	
    	
    	
    	setTitle("ATM Machine");
    	setLayout(null);
    	ImageIcon i1 = new ImageIcon(login.class.getResource("/icons1/bank.png"));
    	Image i2 = i1.getImage().getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE);
    	ImageIcon i3 = new ImageIcon(i2);
    	JLabel label = new JLabel(i3);
    	label.setBounds(70, 10, 100, 100);
    	add(label);
    	
    	Label text = new Label("Welcome to ATM");
    	text.setFont(new Font("Osward", Font.BOLD,38));
    	text.setBounds(200, 40, 400,40);
    	add(text);
    	
    	
    	Label cardno = new Label("Card number: ");
    	cardno.setFont(new Font("Osward", Font.BOLD,20));
    	cardno.setBounds(200, 250, 200,40);
    	add(cardno);
    	
        cardnumber = new JTextField();
    	cardnumber.setBounds(400, 305, 250,30);
    	add(cardnumber);
    	
    	
    	Label pin = new Label("Enter the pin: ");
    	pin.setFont(new Font("Osward", Font.BOLD,20));
    	pin.setBounds(200, 300, 400,40);
    	add(pin);
    	
        pinnumber = new JTextField();
    	pinnumber.setBounds(400, 255, 250,30);
    	add(pinnumber);
    	
    	JButton signIn = new JButton("Sign in");
    	signIn.setBounds(200, 550, 200,40);
    	add(signIn);
    	signIn.addActionListener(e -> {
    		Conn c = new Conn();
    		cardNum = cardnumber.getText();
    		String pinNum = pinnumber.getText();
    		System.out.println("Entered Card Number: " + cardNum);
    	    System.out.println("Entered PIN: " + pinNum);
    	    
    		String query = "select * from signup3 where Card_Number = '" + pinNum + "' and Account_Pin = '" + cardNum+ "' ";
    		try {
    			ResultSet a = c.s.executeQuery(query);
    			System.out.print(a);
    			if(a.next()) {
    				System.out.print("a");
    				setVisible(false);
    				new Transaction(cardNum).setVisible(true);
    			}else {
    				 JOptionPane.showMessageDialog(null, "Incorrect credentials");
    			}
    		}catch(Exception E) {
    			System.out.println(E);
    		}
        });
    	
    	
    	JButton signUp = new JButton("Sign up");
    	signUp.setBounds(200, 600, 400,40);
    	add(signUp);
    	signUp.addActionListener(e -> {
    		new loginPage1();
    		setVisible(false);
        });
    	
    	JButton clearFields = new JButton("Clear");
    	clearFields.setBounds(400, 550, 200,40);
    	add(clearFields);
    	clearFields.addActionListener(e -> {
    		cardnumber.setText(null);
    		pinnumber.setText(null);
        });
    	
    	getContentPane().setBackground(Color.LIGHT_GRAY);
    	
        setSize(750,900);
        setVisible(true);
        setLocation(350,200);
    }
    

    public static void main(String[] args) {
        new login();
    }
}