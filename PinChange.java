package BMS;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;


public class PinChange extends JFrame implements ActionListener {
	String pin;
	JButton back,confirm;
	JLabel text,ask1,ask2;
	JTextField pin1,pin2;
	PinChange(String a){
		pin = a;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(login.class.getResource("/icons1/atm1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900 , DO_NOTHING_ON_CLOSE);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
	    text = new JLabel("Change your PIN");
		text.setFont(new Font("System", Font.PLAIN,16));
		text.setBounds(275, 280, 500, 35);
		image.add(text);
		
		ask1 = new JLabel("Enter your new PIN: ");
		ask1.setFont(new Font("System", Font.PLAIN,16));
		ask1.setBounds(160, 390, 500, 35);
		image.add(ask1);
		
		pin1 = new JTextField();
		pin1.setBounds(310, 395, 75, 30);
		image.add(pin1);
		
		ask2 = new JLabel("Confirm your new PIN: ");
		ask2.setFont(new Font("System", Font.PLAIN,16));
		ask2.setBounds(160, 430, 500, 35);
		image.add(ask2);
		
		pin2 = new JTextField();
		pin2.setBounds(335, 430, 75, 30);
		image.add(pin2);
		
		confirm = new JButton("Confirm Pin");
		confirm.setBounds(425, 470, 150, 40);
		image.add(confirm);
		confirm.setFont(new Font("Osward", Font.PLAIN,14));
		confirm.addActionListener(this);
		
		back = new JButton("Back");
		back.setFont(new Font("Osward", Font.PLAIN,14));
		back.setBounds(425, 505, 150, 40);
		image.add(back); 
		back.addActionListener(this);
		
		setSize(900,900); 
		setLocation(300,0);
		setVisible(true);
	}
	

	

	public static void main(String args[]) {
		new PinChange("");
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == confirm) {
		try {
			String npin = pin1.getText();
			String rpin = pin2.getText();
			
			if(!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null, "Pins do not match");
				return;
			}
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "New Pin field cannot be empty");
				return;
			}
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Confrim Pin field cannot be empty");
				return;
			}
			
			Conn c = new Conn();
			String query1 = "update bank set pin = '"+rpin+"' where pin = '" +pin+"'";
			String query2 = "update signup3 set Account_Pin = '"+rpin+"' where Account_Pin = '" +pin+"'";
			
			c.s.executeUpdate(query1);
			c.s.executeUpdate(query2);
			JOptionPane.showMessageDialog(null, "Pin updated successfully");
			
			setVisible(false);
			new Transaction(rpin).setVisible(true);
		}catch (Exception e1) {
			System.out.println(e1);
		}
	 } else {
		 setVisible(false);
		 new Transaction(pin).setVisible(true);
	 }
		
	}

}
