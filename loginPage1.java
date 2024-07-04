package BMS;

import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class loginPage1 extends JFrame implements ActionListener {
    static int appNumber;
    JLabel title;
    JTextField nameField, fathernameField, dOB, e_mail, addresss, cityy, pin_code;
    JRadioButton male, female, other, marriedRadioButton, unmarriedRadioButton;
    ButtonGroup buttonGroup1, buttonGroup2;
    JButton nextPage;
    JComboBox<String> statee;

    loginPage1() {
        setLayout(null);
        appNumber = generateRandomFourDigitNumber();
        title = new JLabel("APPLICATION FORM NO. " + appNumber);
        title.setFont(new Font("Osward", Font.BOLD, 38));
        title.setBounds(100, 10, 600, 50);
        add(title);

        JLabel pageDescription = new JLabel("Page 1: Customer Details");
        pageDescription.setFont(new Font("Osward", Font.BOLD, 24));
        add(pageDescription);
        pageDescription.setBounds(250, 70, 600, 50);

        String[] states = {
                "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut",
                "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
                "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
                "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
                "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma",
                "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee",
                "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
        };

        buttonGroup1 = new ButtonGroup();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        buttonGroup1.add(male);
        buttonGroup1.add(female);
        buttonGroup1.add(other);

        buttonGroup2 = new ButtonGroup();
        marriedRadioButton = new JRadioButton("Married");
        unmarriedRadioButton = new JRadioButton("Unmarried");

        buttonGroup2.add(marriedRadioButton);
        buttonGroup2.add(unmarriedRadioButton);

        // Labels
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Osward", Font.BOLD, 18));
        name.setBounds(100, 150, 200, 50);
        add(name);

        JLabel fatherName = new JLabel("Father's name: ");
        fatherName.setFont(new Font("Osward", Font.BOLD, 18));
        fatherName.setBounds(100, 200, 200, 50);
        add(fatherName);

        JLabel dateOfBirth = new JLabel("Date of Birth: ");
        dateOfBirth.setFont(new Font("Osward", Font.BOLD, 18));
        dateOfBirth.setBounds(100, 250, 200, 50);
        add(dateOfBirth);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Osward", Font.BOLD, 18));
        gender.setBounds(100, 300, 200, 50);
        add(gender);

        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Osward", Font.BOLD, 18));
        email.setBounds(100, 350, 200, 50);
        add(email);

        JLabel maritalStatus = new JLabel("Marital Status: ");
        maritalStatus.setFont(new Font("Osward", Font.BOLD, 18));
        maritalStatus.setBounds(100, 400, 200, 50);
        add(maritalStatus);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Osward", Font.BOLD, 18));
        address.setBounds(100, 450, 200, 50);
        add(address);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Osward", Font.BOLD, 18));
        city.setBounds(100, 500, 200, 50);
        add(city);

        JLabel pincCode = new JLabel("Pin Code: ");
        pincCode.setFont(new Font("Osward", Font.BOLD, 18));
        pincCode.setBounds(100, 550, 200, 50);
        add(pincCode);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Osward", Font.BOLD, 18));
        state.setBounds(100, 600, 200, 50);
        add(state);

        // Text Fields
        nameField = new JTextField();
        nameField.setBounds(300, 160, 400, 30);
        add(nameField);

        fathernameField = new JTextField();
        fathernameField.setBounds(300, 210, 400, 30);
        add(fathernameField);

        dOB = new JTextField();
        dOB.setBounds(300, 260, 400, 30);
        add(dOB);

        male.setBounds(300, 310, 100, 30);
        female.setBounds(400, 310, 100, 30);
        other.setBounds(500, 310, 100, 30);
        add(male);
        add(female);
        add(other);

        e_mail = new JTextField();
        e_mail.setBounds(300, 360, 400, 30);
        add(e_mail);

        marriedRadioButton.setBounds(300, 410, 100, 30);
        unmarriedRadioButton.setBounds(400, 410, 100, 30);
        add(marriedRadioButton);
        add(unmarriedRadioButton);

        addresss = new JTextField();
        addresss.setBounds(300, 460, 400, 30);
        add(addresss);

        cityy = new JTextField();
        cityy.setBounds(300, 510, 400, 30);
        add(cityy);

        pin_code = new JTextField();
        pin_code.setBounds(300, 560, 400, 30);
        add(pin_code);

        statee = new JComboBox<>(states);
        statee.setBounds(300, 610, 400, 30);
        add(statee);

        // Button
        nextPage = new JButton("Next");
        nextPage.setBounds(600, 700, 100, 40);
        add(nextPage);

        nextPage.addActionListener(this);

        setSize(750, 900);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static int generateRandomFourDigitNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000;
        return randomNumber;
    }

    public void actionPerformed(ActionEvent ae) {
        String formNo = String.valueOf(appNumber);
        String name = nameField.getText();
        String fatherName = fathernameField.getText();
        String dateOfBirth = dOB.getText();
        String emaill = e_mail.getText();
        String add = addresss.getText();
        String cty = cityy.getText();
        String pCode = pin_code.getText();
        String gender = "";
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (other.isSelected()) {
            gender = "Other";
        }

        String married = "";
        if (marriedRadioButton.isSelected()) {
            married = "Married";
        } else if (unmarriedRadioButton.isSelected()) {
            married = "Unmarried";
        }

        try {
            if (name.equals("") || formNo.equals("") || fatherName.equals("") || dateOfBirth.equals("") || emaill.equals("") || add.equals("") || cty.equals("") || pCode.equals("") || gender.equals("") || married.equals("")) {
                JOptionPane.showMessageDialog(null, "One or more fields are empty");
            }
            else {
            	Conn c = new Conn();
            	String query = "insert into signup values('" + formNo + "', '" + name + "', '" +fatherName + "', '" + dateOfBirth + "' , '" + gender + "' , '" + emaill + "' , '" + married + "'  , '" + add + "'  , '" + cty + "' , '" + pCode + "')";       
            	c.s.executeUpdate(query);
            }
            new signUpPage2(appNumber);
            setVisible(false);
        } catch (Exception e) {
            System.out.println(e); // Print stack trace for debugging
        }
    }

    public static void main(String[] args) {
        new loginPage1();
    }
}
