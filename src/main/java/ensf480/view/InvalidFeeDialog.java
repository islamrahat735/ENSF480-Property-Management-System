package ensf480.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class InvalidFeeDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InvalidFeeDialog dialog = new InvalidFeeDialog(); // create new InvalidFeeDialog
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // destroy JDialog and everything contained within when closed
			dialog.setVisible(true); // set as visible
		} catch (Exception e) {
			e.printStackTrace();
		} // try and catch for error handling
	}

	/**
	 * Create the dialog.
	 */
	public InvalidFeeDialog() {
		setTitle("WARNING"); // set title
		setBounds(100, 100, 450, 300); // set bounds
		getContentPane().setLayout(new BorderLayout()); // set layout of ContentPane
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); //set border of contentPanel
		getContentPane().add(contentPanel, BorderLayout.CENTER); // add contentPanel to ContentPane
		contentPanel.setLayout(null); // set layout of contentPanel as null, absolute positioning
		{
			JLabel warningLabel = new JLabel("Fee cannot be less than 0"); // create new J:abel
			warningLabel.setFont(new Font("Tahoma", Font.PLAIN, 32)); // set font
			warningLabel.setBounds(78, 91, 348, 59); // set bounds
			contentPanel.add(warningLabel); // add to contentPanel
		}
		{
			JPanel buttonPane = new JPanel(); // create new JPanel
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT)); // set layout of JPanel
			getContentPane().add(buttonPane, BorderLayout.SOUTH); // add to ContentPane
			{
				JButton okButton = new JButton("OK"); // create new JButton
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose(); // destroy JDialog and everything contained inside
					}
				}); // action listener in event that button is pressed
				okButton.setActionCommand("OK"); // set action command
				buttonPane.add(okButton); // add to buttonPane
				getRootPane().setDefaultButton(okButton); // set default button to okButton
			}
		}
	}

}
