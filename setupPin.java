package BMS;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class setupPin extends JFrame implements ActionListener{

    private JLabel statusLabel; // Reference to the label
    long account, card, formNumber;
    String pin;

    setupPin(int formno,long accountNumber, long cardNumber) {
        setLayout(null);
        formNumber = formno;
        account = accountNumber;
        card = cardNumber;

        JLabel newPinLabel = new JLabel("Enter New Pin:");
        newPinLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        add(newPinLabel);
        newPinLabel.setBounds(50, 50, 150, 50);

        JPasswordField newPinNumber = new JPasswordField();
        newPinNumber.setBounds(200, 60, 150, 30);
        add(newPinNumber);

        JLabel confirmPinLabel = new JLabel("Confirm Pin:");
        confirmPinLabel.setFont(new Font("Osward", Font.PLAIN, 20));
        add(confirmPinLabel);
        confirmPinLabel.setBounds(50, 100, 150, 50);

        JPasswordField confirmPinNumber = new JPasswordField();
        confirmPinNumber.setBounds(200, 110, 150, 30);
        add(confirmPinNumber);

        JButton nextPage = new JButton("Finish");
        nextPage.setBounds(150, 250, 100, 40);
        add(nextPage);

        nextPage.addActionListener(e -> {
            String newPin = new String(newPinNumber.getPassword());
            String confirmPin = new String(confirmPinNumber.getPassword());

            if (statusLabel != null) {
                remove(statusLabel); // Remove the previous label if it exists
            }

            if (newPin.equals(confirmPin)) {
            	pin = newPin;
                statusLabel = new JLabel("Pin Successfully created");
                statusLabel.setFont(new Font("Osward", Font.PLAIN, 16));
            } else {
                statusLabel = new JLabel("Pins do not match");
                statusLabel.setFont(new Font("Osward", Font.PLAIN, 16));
            }
            add(statusLabel);
            statusLabel.setBounds(125, 200, 200, 50);
            repaint(); // Repaint the frame to reflect the changes
        });

        JButton homePage = new JButton("Proceed");
        homePage.setBounds(150, 300, 100, 40);
        add(homePage);
        homePage.addActionListener(this);

  
        setSize(400, 400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new setupPin(0,0,0);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Conn c = new Conn();
			 String query = "insert into signup3 values('" + formNumber + "','" + account + "', '" + card + "',  '" + pin + "')";
			 c.s.executeUpdate(query);
			 setVisible(false);
			 new Deposit(pin).setVisible(true);;
	           
		}catch(Exception E) {
			 System.out.print(E);
		 }
	}
}
