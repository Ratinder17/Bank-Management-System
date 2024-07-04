package BMS;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

class MiniStatement  extends JFrame implements ActionListener {

	MiniStatement(String pin){

		
		setTitle("Mini Statement");
		
		setLayout(null);
		
		JLabel text = new JLabel();
		add(text);
		
		JLabel bank = new JLabel("Bank of Arizona");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel mini = new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from signup3 where Account_Pin = '"+ pin + "'");
			while(rs.next()) {
				card.setText("Card Number: " + rs.getString("Card_Number"));
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		
		try {
			Conn conn = new Conn();
			int bal = 0;
			ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+ pin + "'");
			while(rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +  rs.getString("amount") + "<br><br><html>");
				if(rs.getString("type").equals("Deposit")) {
					bal += Integer.parseInt(rs.getString("amount"));
				}
				else {
					bal -= Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("Your current account Balance = $" + bal);
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.white);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args) {
		new MiniStatement("");
	}

}
