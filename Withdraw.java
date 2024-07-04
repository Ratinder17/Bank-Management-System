package BMS;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.*;


public class Withdraw extends JFrame implements ActionListener{
	JTextField amount;
	JButton withdraw, back;
	String pin;
	Withdraw(String a){
		pin = a;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(login.class.getResource("/icons1/atm1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900 , DO_NOTHING_ON_CLOSE);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		
		JLabel text = new JLabel("Enter the amount(in dollars) you want to deposit:");
		text.setFont(new Font("System", Font.PLAIN,16));
		text.setBounds(180, 300, 400, 20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.PLAIN,16));
		amount.setBounds(200, 350, 320, 25);
		image.add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setFont(new Font("Osward", Font.PLAIN,14));
		withdraw.setBounds(425, 470, 150, 40);
		image.add(withdraw); 
		withdraw.addActionListener(this);
		
		back = new JButton("Back");
		back.setFont(new Font("Osward", Font.PLAIN,14));
		back.setBounds(425, 505, 150, 40);
		image.add(back); 
		back.addActionListener(this);

		setSize(900,900); 
		setLocation(300,0);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Deposit("");
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == withdraw) {
			String sum = amount.getText();
			Date date = new Date();
			if(sum.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
			}else {
				try {
					Conn c = new Conn();
					String query = "insert into bank values('" + pin + "', '" + date + "', '" + "Withdrawl" + "', '" + sum + "')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "$" + sum + " withdrawn successfully");
					setVisible(false);
					new Transaction(pin).setVisible(true);
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		}
		if(e.getSource() == back) {
			setVisible(false);
			new Transaction(pin).setVisible(true);
		}
	}

}
