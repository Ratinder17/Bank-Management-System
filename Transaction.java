package BMS;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Transaction extends JFrame implements ActionListener {
	
	JButton withdraw, depositCash, fastCash, exit, balanceEnquiry, bankStatement, changePin;
	String pin;
	Transaction(String a){
		pin = a;
		setLayout(null);
		
    	ImageIcon i1 = new ImageIcon(login.class.getResource("/icons1/atm1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900 , DO_NOTHING_ON_CLOSE);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Please select an option below:");
		text.setBounds(215, 270, 700, 35);
		image.add(text);
		text.setFont(new Font("Osward", Font.PLAIN,20));
		
		
	    withdraw = new JButton("Withdraw");
		withdraw.setBounds(155, 390, 150, 40);
		image.add(withdraw);
		withdraw.setFont(new Font("Osward", Font.PLAIN,14));
		withdraw.addActionListener(this);
		
		
	    depositCash = new JButton("Deposit Cash");
		depositCash.setBounds(155, 430, 150, 40);
		image.add(depositCash);
		depositCash.setFont(new Font("Osward", Font.PLAIN,14));
		depositCash.addActionListener(this);

		
		fastCash = new JButton("Fast Cash");
		fastCash.setBounds(155, 470, 150, 40);
		image.add(fastCash);
		fastCash.setFont(new Font("Osward", Font.PLAIN,14));
		fastCash.addActionListener(this);
		
		exit = new JButton("Exit");
		exit.setBounds(155, 510, 150, 38);
		image.add(exit);
		exit.setFont(new Font("Osward", Font.PLAIN,14));
		exit.addActionListener(this);
		
		balanceEnquiry = new JButton("Balance Enquiry");
		balanceEnquiry.setBounds(425, 390, 150, 40);
		image.add(balanceEnquiry);
		balanceEnquiry.setFont(new Font("Osward", Font.PLAIN,14));
		balanceEnquiry.addActionListener(this);
		
		bankStatement = new JButton("Bank Statement");
		bankStatement.setBounds(425, 430, 150, 40);
		image.add(bankStatement);
		bankStatement.setFont(new Font("Osward", Font.PLAIN,14));
		bankStatement.addActionListener(this);
		
		changePin = new JButton("Change Pin");
		changePin.setBounds(425, 470, 150, 40);
		image.add(changePin);
		changePin.setFont(new Font("Osward", Font.PLAIN,14));
		changePin.addActionListener(this);

		setVisible(true);
		setSize(900,900);
		setLocation(300,0);
		
	}

	public static void main(String[] args) {
      new Transaction("");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit) {
			System.exit(0);
		}
		else if(e.getSource() == depositCash) {
			setVisible(false);
			new Deposit(pin).setVisible(true);
		}
		else if(e.getSource() == withdraw) {
			setVisible(false);
			new Withdraw(pin).setVisible(true);
		}
		else if(e.getSource() == fastCash) {
			setVisible(false);
			new fastCash(pin).setVisible(true);
		}
		else if(e.getSource() == changePin) {
			setVisible(false);
			new PinChange(pin).setVisible(true);
		}
		else if(e.getSource() == balanceEnquiry) {
			setVisible(false);
			new BalanceEnquiry(pin).setVisible(true);
		}
		else if(e.getSource() == bankStatement) {
			new MiniStatement(pin).setVisible(true);
		}
	}

}
