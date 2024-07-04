package BMS;
import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class signUpPage2 extends JFrame implements ActionListener{
	int formno;
	JTextField ssnNumber, itinNumber, beneficiaryAddress, beneficiaryContact ,beneficiaryName;
	JSlider incomeSlider;
    JLabel incomeLabel;
	JComboBox<String> eTypes, aTypes;
	ButtonGroup buttonGroup1;
	 JRadioButton yes, no, accept, accept1;
	signUpPage2(int appNumber){
		setLayout(null); 
		
		formno = appNumber;
		String[] employementTypes = {
                "Full-time Employment", "Part-time Employment", "Contract Employment", 
                "Temporary Employment", "Internship/Apprenticeship", "Freelance/Self-Employment",
                "Student" 
            };
		String[] accountTypes = {
				 "Checking Account", "Savings Account", "Money Market Account", 
	                "Certificate of Deposit (CD)", "Individual Retirement Account (IRA)", "Health Savings Account (HSA)",
	                "Brokerage Account", "Credit Card Account", "Loan Account (e.g., Mortgage, Auto Loan)",
	                "Investment Account"
		};
		//******************************************************************
		
		
		JLabel pageDescription = new JLabel("Page 2: Additional Details");
        pageDescription.setFont(new Font("Osward", Font.BOLD,24));
        add(pageDescription); 
        pageDescription.setBounds(250, 70, 600, 50);
        
        
		JLabel ssn = new JLabel("Social Security Number:");
		ssn.setFont(new Font("Osward", Font.BOLD,18));
		ssn.setBounds(100, 150, 300, 50);
        add(ssn); 
        
        JLabel itin = new JLabel("Individual Taxpayer Identification Number:");
        itin.setFont(new Font("Osward", Font.BOLD,18));
        itin.setBounds(100, 200, 410, 50);
        add(itin); 
        
        JLabel eStatus = new JLabel("Employment status:");
        eStatus.setFont(new Font("Osward", Font.BOLD,18));
        eStatus.setBounds(100, 250, 200, 50);
        add(eStatus); 
        
        JLabel income = new JLabel("Annual income:");
        income.setFont(new Font("Osward", Font.BOLD,18));
        income.setBounds(100, 300, 200, 50);
        add(income);
        
        JLabel account = new JLabel("Account type:");
        account.setFont(new Font("Osward", Font.BOLD,18));
        account.setBounds(100, 350, 200, 50);
        add(account); 
        
        JLabel maritalStatus = new JLabel("Designate beneficiary:");
        maritalStatus.setFont(new Font("Osward", Font.BOLD,18));
        maritalStatus.setBounds(100, 400, 250, 50);
        add(maritalStatus);
        
        JLabel address = new JLabel("Would you like to receive marketing materials, newsletters, or promotional offers from the bank");
        address.setFont(new Font("Osward", Font.BOLD,10));
        address.setBounds(100, 600, 500, 50);
        add(address); 
        
        JLabel city = new JLabel("Acknowledge your agreement to the bank's terms and conditions for account opening and usage");
        city.setFont(new Font("Osward", Font.BOLD,10));
        city.setBounds(100, 650, 510, 50);
        add(city);
        
        JLabel beneficiaryLabel = new JLabel("Beneficiary Name:");
        beneficiaryLabel.setFont(new Font("Osward", Font.BOLD, 18));
        beneficiaryLabel.setBounds(100, 450, 200, 30);
        add(beneficiaryLabel);
        beneficiaryLabel.setVisible(false);
        
        JLabel beneficiaryAddressLabel = new JLabel("Address:");
        beneficiaryAddressLabel.setFont(new Font("Osward", Font.BOLD, 20));
        beneficiaryAddressLabel.setBounds(100, 500, 200, 30);
        add(beneficiaryAddressLabel);
        beneficiaryAddressLabel.setVisible(false); 
        
        JLabel beneficiaryContactLabel = new JLabel("Contact Number:");
        beneficiaryContactLabel.setFont(new Font("Osward", Font.BOLD, 20));
        beneficiaryContactLabel.setBounds(100, 550, 200, 30);
        add(beneficiaryContactLabel);
        beneficiaryContactLabel.setVisible(false); 

       
        //******************************************************************
		
        ssnNumber = new JTextField();
        ssnNumber.setBounds(350, 160, 200, 30);
    	add(ssnNumber);
    	
    	itinNumber = new JTextField();
    	itinNumber.setBounds(500, 210, 200, 30);
    	add(itinNumber);
    	
        eTypes = new JComboBox<>(employementTypes);
    	eTypes.setBounds(300, 260, 400, 30);
    	add(eTypes );
    	
    	
        
        incomeSlider = new JSlider(JSlider.HORIZONTAL, 0, 1000000, 50000); // Minimum, maximum, initial value, and slider step
        incomeSlider.setBounds(300, 310, 400, 30);
        incomeSlider.setPaintTicks(true);
        incomeSlider.setPaintLabels(true);
        add(incomeSlider);
        
        incomeLabel = new JLabel("Annual income: $" + incomeSlider.getValue());
        incomeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        incomeLabel.setBounds(310, 320, 200, 30);
        add(incomeLabel);
        
        incomeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int value = incomeSlider.getValue();
                if (value == incomeSlider.getMaximum()) {
                    incomeLabel.setText("Annual income: $1000000+");
                } else {
                    incomeLabel.setText("Annual income: $" + value);
                }
            }
        });
        aTypes = new JComboBox<>(accountTypes);
    	aTypes.setBounds(300, 360, 400, 30);
    	add(aTypes );
    	
    	
        buttonGroup1 = new ButtonGroup();
         yes = new JRadioButton("Yes");
         no = new JRadioButton("No");
        
        buttonGroup1.add(yes);
        buttonGroup1.add(no);
        
        yes.setBounds(310, 410, 200, 30);
        no.setBounds(500, 410, 200, 30);
    	add(yes);
        add(no);
    	
        beneficiaryName = new JTextField();
        beneficiaryName.setBounds(300, 450, 400, 30);
        add(beneficiaryName);
        beneficiaryName.setVisible(false); 
        
        beneficiaryAddress = new JTextField();
        beneficiaryAddress.setBounds(300, 500, 400, 30);
        add(beneficiaryAddress);
        beneficiaryAddress.setVisible(false);
        
        beneficiaryContact = new JTextField();
        beneficiaryContact.setBounds(300, 550, 400, 30);
        add(beneficiaryContact);
        beneficiaryContact.setVisible(false);
        
        yes.addActionListener(e -> {
            if (yes.isSelected()) {
                beneficiaryLabel.setVisible(true);
                beneficiaryName.setVisible(true);
                beneficiaryAddressLabel.setVisible(true);
                beneficiaryAddress.setVisible(true);
                beneficiaryContactLabel.setVisible(true); 
                beneficiaryContact.setVisible(true);
            } 
        });
        
        no.addActionListener(e -> {
            if (no.isSelected()) {
                beneficiaryLabel.setVisible(false);
                beneficiaryName.setVisible(false);
                beneficiaryAddressLabel.setVisible(false);
                beneficiaryAddress.setVisible(false);
                beneficiaryContactLabel.setVisible(false); 
                beneficiaryContact.setVisible(false);
            }
        });

        accept = new JRadioButton("Accept");
        accept.setBounds(100, 630, 250, 30);
        add(accept);
        
        accept1 = new JRadioButton("Accept");
        accept1.setBounds(100, 680, 250, 30);
        add(accept1);
        
        JButton nextPage = new JButton("Submit Form");
        nextPage.setBounds(600, 700, 100,40);
    	add(nextPage);
    	
        nextPage.addActionListener(this);

		setSize(750,900);
        setVisible(true);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}
	
	
	 public void actionPerformed(ActionEvent ae) {
		 String ssn = ssnNumber.getText();
		 String itin = itinNumber.getText();
		 String employement = (String)eTypes.getSelectedItem();
		 String income = "" + incomeSlider.getValue();
		 String account = (String)aTypes.getSelectedItem();
		 String benificary, bAddress, bContact, bName;
		 if(yes.isSelected()) {
			 benificary = "Yes";
			 bName = beneficiaryName.getText();
			 bContact = beneficiaryContact.getText();
			 bAddress = beneficiaryAddress.getText();
			  
		 }
		 else {
			 benificary = "No";
			 bName = "-";
			 bContact ="-";
			 bAddress = "-";
		 }
	
		 try {
			 if (ssn.equals("") || itin.equals("") || employement.equals("") || income.equals("") || account.equals("")) {
	                JOptionPane.showMessageDialog(null, "One or more fields are empty");
	            }
			 else {
				 Conn c = new Conn();
				 String query = "insert into signup2 values('" + formno + "', '" + ssn + "', '" +itin + "', '" + employement + "' , '" + income + "' , '" + account + "' , '" + benificary + "'  , '" + bName + "'  , '" + bContact + "' , '" + bAddress + "')";
				 c.s.executeUpdate(query);
			 }
			    new signUpPage3(formno);
	            setVisible(false);
		 } catch(Exception E) {
			 System.out.print(E);
		 }
	 }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new signUpPage2(100);

	}

}
