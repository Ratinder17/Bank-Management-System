package BMS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Balance extends JFrame implements ActionListener {
	public static int balance = 0 ;
	
	int Balance(int sum, int signal){
		if(signal == 0) {
			balance += sum;
		}
		else {
			balance -= sum;
		}
		return balance;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
