package BMS;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.*;

public class fastCash extends JFrame implements ActionListener {
	
	JButton five, ten, twenty, fifty, hundred, fiveh, thousand,back;
	String pin;
	fastCash(String a){
		pin = a;
		setLayout(null);
		
    	ImageIcon i1 = new ImageIcon(login.class.getResource("/icons1/atm1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900 , DO_NOTHING_ON_CLOSE);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Please select a withdrawl amount:");
		text.setBounds(215, 270, 700, 35);
		image.add(text);
		text.setFont(new Font("Osward", Font.PLAIN,20));
		
		
	    five = new JButton("$5");
	    five.setBounds(155, 390, 150, 40);
		image.add(five);
		five.setFont(new Font("Osward", Font.PLAIN,14));
		five.addActionListener(this);
		
		
		ten = new JButton("$10");
		ten.setBounds(155, 430, 150, 40);
		image.add(ten);
		ten.setFont(new Font("Osward", Font.PLAIN,14));
		ten.addActionListener(this);

		
		twenty = new JButton("$20");
		twenty.setBounds(155, 470, 150, 40);
		image.add(twenty);
		twenty.setFont(new Font("Osward", Font.PLAIN,14));
		twenty.addActionListener(this);
		
		fifty = new JButton("$50");
		fifty.setBounds(155, 510, 150, 38);
		image.add(fifty);
		fifty.setFont(new Font("Osward", Font.PLAIN,14));
		fifty.addActionListener(this);
		
		hundred = new JButton("$100");
		hundred.setBounds(425, 390, 150, 40);
		image.add(hundred);
		hundred.setFont(new Font("Osward", Font.PLAIN,14));
		hundred.addActionListener(this);
		
		fiveh = new JButton("$500");
		fiveh.setBounds(425, 430, 150, 40);
		image.add(fiveh);
		fiveh.setFont(new Font("Osward", Font.PLAIN,14));
		fiveh.addActionListener(this);
		
		thousand = new JButton("$1000");
		thousand.setBounds(425, 470, 150, 40);
		image.add(thousand);
		thousand.setFont(new Font("Osward", Font.PLAIN,14));
		thousand.addActionListener(this);
		
		back = new JButton("Back");
		back.setBounds(425, 505, 150, 40);
		image.add(back);
		back.setFont(new Font("Osward", Font.PLAIN,14));
		back.addActionListener(this);

		setVisible(true);
		setSize(900,900);
		setLocation(300,0);
		
	}

	public static void main(String[] args) {
      new fastCash("");
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back) {
			setVisible(false);
			new Transaction(pin).setVisible(true);
		}
		else {
			String amount = ((JButton)e.getSource()).getText().substring(1);
			Conn c = new Conn();
			try {
				ResultSet rs = c.s.executeQuery(" select * from bank where pin = '" + pin + "'");
				int balance = 0;
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}
					else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				if(e.getSource() != back && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufficent Balance");
					return;
				}
				else {
					Date date = new Date();
					String query = "insert into bank values('" + pin + "', '" + date + "', '" + "Withdrawl" + "', '" + amount + "')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Withdrawl Successful");
					
					setVisible(false);
					new Transaction(pin).setVisible(true);
				}
			}catch (Exception e1) {
				System.out.println(e1);
			}
			
		}
	}

}