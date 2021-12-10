package ensf480.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InvalidAddressDialog extends JDialog {

	private final JPanel contentPanel = new JPanel(); // create new private JPanel

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InvalidAddressDialog dialog = new InvalidAddressDialog(); // create new InvalidAddressDialog
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // destroy JDialog and everything contained within on close
			dialog.setVisible(true); // set as visible
		} catch (Exception e) {
			e.printStackTrace();
		} // try and catch for error checking and handling
	}

	/**
	 * Create the dialog.
	 */
	public InvalidAddressDialog() {
		setTitle("WARNING"); // set title
		setBounds(100, 100, 450, 300); // set bounds
		getContentPane().setLayout(new BorderLayout()); // set layout as BorderLayout
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // set border as EmptyBorder  and sets insets
		getContentPane().add(contentPanel, BorderLayout.CENTER); // add contentPanel to ContentPane
		contentPanel.setLayout(null); // set layout to null, absolute positioning
		{
			JLabel warningLabel = new JLabel("Address is required"); // create new JLabel
			warningLabel.setFont(new Font("Tahoma", Font.PLAIN, 32)); // set font
			warningLabel.setBounds(78, 91, 348, 59); // set bounds
			contentPanel.add(warningLabel); // add to contentPanel
		}
		{
			JPanel buttonPane = new JPanel(); // create new JPanel
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT)); // set layout 
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
				getRootPane().setDefaultButton(okButton); // set okButton as default button
			}
		}
	}

}
