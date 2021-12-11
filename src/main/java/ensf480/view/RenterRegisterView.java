package ensf480.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ensf480.controller.LoginController;

public class RenterRegisterView extends JPanel {

	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JPasswordField passwordField;
	private JDialog actionSuccessfulDialog = new ActionSuccessfulDialog();
	private JDialog invalidInputDialog = new InvalidInputDialog();
	/**
	 * Create the panel.
	 */
	public RenterRegisterView() {
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
		// JLabel prompting user for First Name
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(224, 62, 104, 13);
		add(firstNameLabel);
		
		//JTextField used to store user input
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(376, 59, 220, 19);
		add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		// JLabel prompting user for Last Name
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(224, 177, 104, 13);
		add(lastNameLabel);
		
		//JTextField used to store user input
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(376, 174, 220, 19);
		add(lastNameTextField);
		
		// JLabel used to prompt user for email
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(224, 290, 104, 13);
		add(emailLabel);
		
		//JTextField used to store user input
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(376, 287, 220, 19);
		add(emailTextField);
		
		// JLabel used to prompt user for password
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(224, 402, 104, 13);
		add(passwordLabel);
		
		//JTextField used to store user input
		passwordField = new JPasswordField();
		passwordField.setBounds(376, 399, 220, 19);
		add(passwordField);
		
		//JButton used inorder to register user 
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginController lc = new LoginController();

				String username = emailTextField.getText();
				boolean valid_username = username.matches(".+\\@.+\\.{1}.+");
				String password = passwordField.getText();
				String fname = firstNameTextField.getText();
				String lname = lastNameTextField.getText();

				if (valid_username == false){
					invalidInputDialog.setVisible(true);
				} else {
					lc.registerRenter(username, password, fname, lname);
					//need exception handling here
					//if no exception is thrown
					actionSuccessfulDialog.setVisible(true);
				}

				
			}
		});
		registerButton.setBounds(376, 509, 104, 21);
		add(registerButton);
		
		// JButton used to go back and change view to LandingView
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandingView();
			}
		});
		backButton.setBounds(738, 11, 89, 23);
		add(backButton);
	}

}
