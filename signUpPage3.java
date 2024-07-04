package BMS;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class signUpPage3 extends JFrame implements ActionListener {

    long accountNumber, cardNumber;
    int formno;

    signUpPage3(int formno) {
        this.formno = formno;
        setLayout(null);

        JLabel successMessage = new JLabel("Details Submitted Successfully.");
        successMessage.setFont(new Font("Osward", Font.BOLD, 24));
        add(successMessage);
        successMessage.setBounds(200, 70, 600, 50);

        JLabel accountMessage = new JLabel("Account Created Successfully");
        accountMessage.setFont(new Font("Osward", Font.BOLD, 24));
        add(accountMessage);
        accountMessage.setBounds(200, 150, 600, 50);

        JLabel details = new JLabel("Account Details: ");
        details.setFont(new Font("Osward", Font.BOLD, 24));
        add(details);
        details.setBounds(200, 400, 600, 50);

        accountNumber = generateRandomNumber(11);
        cardNumber = generateRandomNumber(16);

        JLabel accNumberLabel = new JLabel("Account Number: " + accountNumber);
        accNumberLabel.setFont(new Font("Osward", Font.PLAIN, 24));
        add(accNumberLabel);
        accNumberLabel.setBounds(200, 450, 600, 50);

        JLabel cardNumberLabel = new JLabel("Card Number: " + cardNumber);
        cardNumberLabel.setFont(new Font("Osward", Font.PLAIN, 24));
        add(cardNumberLabel);
        cardNumberLabel.setBounds(200, 500, 600, 50);

        JLabel setPinLabel = new JLabel("Next Step: Setup Account PIN");
        setPinLabel.setFont(new Font("Osward", Font.PLAIN, 24));
        add(setPinLabel);
        setPinLabel.setBounds(200, 650, 600, 50);

        JButton nextPageButton = new JButton("Setup PIN");
        nextPageButton.setBounds(350, 700, 100, 40);
        add(nextPageButton);

        nextPageButton.addActionListener(this);

        setSize(750, 900);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static long generateRandomNumber(int numDigits) {
        Random random = new Random();
        long min = (long) Math.pow(10, numDigits - 1);
        long max = (long) Math.pow(10, numDigits) - 1;
        return min + ((long) (random.nextDouble() * (max - min)));
    }

    public void actionPerformed(ActionEvent ae) {
        new setupPin(formno, accountNumber, cardNumber);
        setVisible(false);
    }

    public static void main(String[] args) {
        new signUpPage3(100);
    }
}
