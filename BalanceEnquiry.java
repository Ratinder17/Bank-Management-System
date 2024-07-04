package BMS;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BalanceEnquiry  extends JFrame implements ActionListener {
	
	String pin;
	JButton back;

	public BalanceEnquiry(String a) {
		
		pin = a;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(login.class.getResource("/icons1/atm1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900 , DO_NOTHING_ON_CLOSE);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		back = new JButton("Back");
		back.setBounds(425, 505, 150, 40);
		image.add(back);
		back.setFont(new Font("Osward", Font.PLAIN,14));
		back.addActionListener(this);
		
		Conn c = new Conn();
		int balance = 0;
        try {
			ResultSet rs = c.s.executeQuery(" select * from bank where pin = '" + pin + "'");
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch (Exception e1) {
				System.out.println(e1);
			}
        
        JLabel text = new JLabel("Current Balance is $" + balance);
        text.setBounds(255, 270, 700, 35);
		image.add(text);
		text.setFont(new Font("Osward", Font.PLAIN,20));
        
		
		setSize(900,900); 
		setLocation(300,0);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BalanceEnquiry("");

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			setVisible(false);
			new Transaction(pin).setVisible(true);
		}
	}

}
