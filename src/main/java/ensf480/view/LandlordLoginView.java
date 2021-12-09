package ensf480.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LandlordLoginView extends JPanel {

	private JTextField loginEmailTextField;
	private JPasswordField loginPasswordField;
	
	/**
	 * Create the panel.
	 * @return 
	 */
	public LandlordLoginView() {
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
		JLabel loginEmailLabel = new JLabel("Landlord Email");
		loginEmailLabel.setBounds(10, 9, 241, 13);
		add(loginEmailLabel);
		
		loginEmailTextField = new JTextField();
		loginEmailTextField.setBounds(10, 42, 241, 19);
		loginEmailTextField.setColumns(10);
		add(loginEmailTextField);
		
		JLabel loginPasswordLabel = new JLabel("Password");
		loginPasswordLabel.setBounds(10, 109, 241, 13);
		add(loginPasswordLabel);
		
		loginPasswordField = new JPasswordField();
		loginPasswordField.setBounds(10, 132, 241, 19);
		add(loginPasswordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(10, 161, 104, 21);
		add(loginButton);
	}

}



