package ensf480.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFailedDialog extends JDialog {

	private final JPanel contentPanel = new JPanel(); // new JPanel

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginFailedDialog dialog = new LoginFailedDialog(); // new LoginFailedDialog
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // set default close operation
			dialog.setVisible(true); // set as visible 
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // try catch for error handling 

	/**
	 * Create the dialog.
	 */
	public LoginFailedDialog() {
		setTitle("WARNING"); // set title 
		setBounds(100, 100, 450, 300); // set bounds 
		getContentPane().setLayout(new BorderLayout()); // set layout of content pane 
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // set border of JPanel
		getContentPane().add(contentPanel, BorderLayout.CENTER); // add to content pane
		contentPanel.setLayout(null); // set layout to null
		{
			JLabel lblNewLabel = new JLabel("Login Failed"); // new JLabel
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32)); // set font 
			lblNewLabel.setBounds(122, 95, 200, 50); // set bounds 
			contentPanel.add(lblNewLabel); // add to contentPanel
		}
		{
			JPanel buttonPane = new JPanel(); // new JPanel 
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT)); // set layout 
			getContentPane().add(buttonPane, BorderLayout.SOUTH); // add to content pane
			{
				JButton okButton = new JButton("OK"); // create new JBUtton
				okButton.addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent e) {
						dispose(); // destroy JDialog
					}
				}); // action listener in event that button is pressed.
				okButton.setActionCommand("OK"); // set action command
				buttonPane.add(okButton); // add to button pane 
				getRootPane().setDefaultButton(okButton); // set as default button 
			}
		}
	}

}
