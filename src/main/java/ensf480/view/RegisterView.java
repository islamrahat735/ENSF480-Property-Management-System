package ensf480.view;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterView extends JPanel {
	
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public RegisterView() {
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(224, 43, 104, 13);
		add(firstNameLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(376, 40, 220, 19);
		add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(224, 158, 104, 13);
		add(lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(376, 155, 220, 19);
		add(lastNameTextField);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(224, 271, 104, 13);
		add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(376, 268, 220, 19);
		add(emailTextField);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(224, 383, 104, 13);
		add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(376, 380, 220, 19);
		add(passwordField);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(376, 490, 104, 21);
		add(registerButton);
	}

}
