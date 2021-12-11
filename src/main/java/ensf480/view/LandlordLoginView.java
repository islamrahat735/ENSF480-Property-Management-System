package ensf480.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ensf480.controller.LoginController;

public class LandlordLoginView extends JPanel {

	private JTextField loginEmailField; // create new private JTextField
	private JPasswordField loginPasswordField; // create new private JTextField
	JDialog loginFailedDialog = new LoginFailedDialog(); // create new JDialog
	
	
	/**
	 * Create the panel.
	 * @return 
	 */
	public LandlordLoginView() {
		setBounds(300, 200, 850, 600); // set bounds
		setLayout(null); // set layout to null, absolute positioning
		
		JLabel loginEmailLabel = new JLabel("Landlord Email"); // create new JLabel
		loginEmailLabel.setBounds(10, 9, 241, 13); // set bounds
		add(loginEmailLabel); // add to view
		
		loginEmailField = new JTextField(); // create new JTextField
		loginEmailField.setBounds(10, 42, 241, 19); // set bounds
		loginEmailField.setColumns(10); // set amount o columns for loginEmailField
		add(loginEmailField); // add to view
		
		JLabel loginPasswordLabel = new JLabel("Password"); // create new JLabel
		loginPasswordLabel.setBounds(10, 109, 241, 13); // set bounds
		add(loginPasswordLabel); // add to view
		
		loginPasswordField = new JPasswordField(); // create new JPasswordField
		loginPasswordField.setBounds(10, 132, 241, 19); // set bounds
		add(loginPasswordField); // add to view
		
		JButton loginButton = new JButton("Login");  // create new JButton
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loginEmail = loginEmailField.getText(); // get text from JTextField and initialize string with value
				String loginPassword = loginPasswordField.getText(); // get text from JTextField and initialize string with value
				LoginController loginController = new LoginController(); // create new LoginController();
				int landlordID = loginController.loginLandlord(loginEmail, loginPassword); // get landlord ID 
				if(landlordID != -1) {
					MainFrame.getLandlordView(landlordID); // view is changed to LandlordView of landlord with corresponding ID 
				}else{
					loginFailedDialog.setVisible(true); // if Landlord ID is -1, dialog showing that login failed is visible
				}
			}
		}); // action listener in event that button is pressed.
		loginButton.setBounds(10, 161, 104, 21); // set bounds
		add(loginButton); // add to view

		JButton backButton = new JButton("Back"); // create new JButton 
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.getLandingView(); // Change view to LandingView 
			}
		}); // action listener created in event that button is pressed 
		backButton.setBounds(751, 9, 89, 23); // set bounds
		add(backButton); // add to view  
	}

}



