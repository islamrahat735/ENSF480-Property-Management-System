package ensf480.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RenterRegisterView extends JPanel {

	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JPasswordField passwordField;
	
	/**
	 * Create the panel.
	 */
	public RenterRegisterView() {
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
		JLabel firstNameLabel = new JLabel("First Name");
		firstNameLabel.setBounds(224, 62, 104, 13);
		add(firstNameLabel);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(376, 59, 220, 19);
		add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last Name");
		lastNameLabel.setBounds(224, 177, 104, 13);
		add(lastNameLabel);
		
		lastNameTextField = new JTextField();
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(376, 174, 220, 19);
		add(lastNameTextField);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(224, 290, 104, 13);
		add(emailLabel);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(376, 287, 220, 19);
		add(emailTextField);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(224, 402, 104, 13);
		add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(376, 399, 220, 19);
		add(passwordField);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		registerButton.setBounds(376, 509, 104, 21);
		add(registerButton);
		
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
