package ensf480.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ensf480.controller.LoginController;
import ensf480.controller.ManagerController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerLoginView extends JPanel {

	private JTextField loginEmailField;
	private JTextField loginPasswordField;
	JDialog loginFailedDialog = new LoginFailedDialog();
	
	/**
	 * Create the panel.
	 * @return 
	 */
	public ManagerLoginView() {	
		setBounds(300, 200, 850, 600); // set bounds
		setLayout(null);
		
		JLabel loginEmailLabel = new JLabel("Manager Email"); // JLabel 
		loginEmailLabel.setBounds(10, 9, 241, 13); // set bounds
		add(loginEmailLabel);
		
		//JTextField used to input Email
		loginEmailField = new JTextField();
		loginEmailField.setBounds(10, 42, 241, 19);
		loginEmailField.setColumns(10);
		add(loginEmailField);
		
		JLabel loginPasswordLabel = new JLabel("Password");
		loginPasswordLabel.setBounds(10, 109, 241, 13);
		add(loginPasswordLabel);
		
		//	
		loginPasswordField = new JPasswordField();
		loginPasswordField.setBounds(10, 132, 241, 19);
		add(loginPasswordField);
		
		//JButton used to Login and validate if the login info is invalid
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loginEmail = loginEmailField.getText();
				String loginPassword = loginPasswordField.getText();
				LoginController loginController = new LoginController();
				if(loginController.loginManager(loginEmail, loginPassword)){
					MainFrame.getManagerView(); //If valid then login
				}
				else{
					//If invalid then display loginFailedDialog
					loginFailedDialog.setVisible(true);
				}
				
			}
		});
		loginButton.setBounds(10, 161, 104, 21);
		add(loginButton);

		//Back button used to get back to the Home/Landing Page
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.getLandingView();
			}
		});
		backButton.setBounds(751, 9, 89, 23);
		add(backButton);
	}

}



