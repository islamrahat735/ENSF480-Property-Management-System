package ensf480.view;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ensf480.controller.LoginController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RenterLoginView extends JPanel {

	private JTextField loginEmailTextField;
	private JTextField loginPasswordField;
	JDialog loginFailedDialog = new LoginFailedDialog();
	
	/**
	 * Create the panel.
	 */
	public RenterLoginView() {
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
		JLabel loginEmailLabel = new JLabel("Renter Email");
		loginEmailLabel.setBounds(10, 9, 241, 13);
		add(loginEmailLabel);
		
		loginEmailTextField = new JTextField();
		loginEmailTextField.setBounds(10, 42, 241, 19);
		loginEmailTextField.setColumns(10);
		add(loginEmailTextField);
		
		JLabel loginPasswordLabel = new JLabel("Password");
		loginPasswordLabel.setBounds(10, 109, 241, 13);
		add(loginPasswordLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String loginEmail = loginEmailTextField.getText();
				String loginPassword = loginPasswordField.getText();
				LoginController loginController = new LoginController();
				int renterId = loginController.loginRenter(loginEmail, loginPassword);
				if(renterId != -1){
					MainFrame.getRenterView(renterId);
				}
				else{
					loginFailedDialog.setVisible(true);
				}
			}
		});
		loginButton.setBounds(10, 161, 104, 21);
		add(loginButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandingView();
			}
		});
		backButton.setBounds(751, 9, 89, 23);
		add(backButton);
		
		loginPasswordField = new JTextField();
		loginPasswordField.setBounds(10, 130, 241, 20);
		add(loginPasswordField);
		loginPasswordField.setColumns(10);
	}

}
