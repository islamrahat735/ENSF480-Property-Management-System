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

public class InvalidInputDialog extends JDialog {

	private final JPanel contentPanel = new JPanel(); // create new private contentPanel

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InvalidInputDialog dialog = new InvalidInputDialog(); // create new InvalidInputDialog
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // destroy JDialog on close
			dialog.setVisible(true); // set as visible
		} catch (Exception e) {
			e.printStackTrace();
		} // try and catch for error handling
	}

	/**
	 * Create the dialog.
	 */
	public InvalidInputDialog() {
		setTitle("WARNING"); // set title
		setBounds(100, 100, 450, 300); // set bounds
		getContentPane().setLayout(new BorderLayout()); // set layout of ContentPane
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // setBOrder of JPanel contentPanel
		getContentPane().add(contentPanel, BorderLayout.CENTER); // add contentPanel to ContentPane
		contentPanel.setLayout(null); // set layout as null, absolute positioning
		{
			JLabel warningLabel = new JLabel("Invalid Input"); // create new JLabel
			warningLabel.setFont(new Font("Tahoma", Font.PLAIN, 32)); // set font
			warningLabel.setBounds(107, 90, 229, 59); // set bounds
			contentPanel.add(warningLabel); // add to contentPanel
		}
		{
			JPanel buttonPane = new JPanel(); // new JPanel
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT)); // set layout of JPanel
			getContentPane().add(buttonPane, BorderLayout.SOUTH); // add to ContentPane
			{
				JButton okButton = new JButton("OK"); // create new JBUtton
				okButton.addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent e) {
						dispose(); // destroy JDialog
					}
				}); // action listener in event that button is pressed.
				okButton.setActionCommand("OK"); // set action command
				buttonPane.add(okButton); //add to buttonPane
				getRootPane().setDefaultButton(okButton); //set okBUtton as default button
			}
		}
	}

}
