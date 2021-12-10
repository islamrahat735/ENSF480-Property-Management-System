package ensf480.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
// imports

public class ActionSuccessfulDialog extends JDialog {

	private final JPanel contentPanel = new JPanel(); // create new private JPanel 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ActionSuccessfulDialog dialog = new ActionSuccessfulDialog(); // initialize variable of type ActionSuccessfulDialog
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); //set default close operation
			dialog.setVisible(true); // set as visible
		} catch (Exception e) {
			e.printStackTrace();
		} // try and catch for error checking and handling
	}

	/**
	 * Create the dialog.
	 */
	public ActionSuccessfulDialog() {
		setTitle("WARNING"); // set title
		setBounds(100, 100, 450, 300); // set bounds
		getContentPane().setLayout(new BorderLayout()); // set layout of ContentPane
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // set border and specify insets
		getContentPane().add(contentPanel, BorderLayout.CENTER);// add content panel to center of bo
		contentPanel.setLayout(null); // set layout to null, absolute positioning
		{
			JLabel lblNewLabel = new JLabel("Action Successful"); // create new JLabel, set text to "Action Successful"
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32)); // set font of lblNewLabel
			lblNewLabel.setBounds(93, 94, 300, 50); // set bounds of lblNewLabel
			contentPanel.add(lblNewLabel); // add lblNewLable to contentPanel
		}
		{
			JPanel buttonPane = new JPanel(); // create new JPanel
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT)); // set layout of buttonPane to FlowLayout
			getContentPane().add(buttonPane, BorderLayout.SOUTH); // add buttonPane to ContentPane
			{
				JButton okButton = new JButton("OK"); // create new JButton 
                okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose(); // destroy JDialog and everything contained within it
					}
				}); // action listener in event button is pressed
				okButton.setActionCommand("OK"); // set action command
				buttonPane.add(okButton); // add okButton to buttonPane
				getRootPane().setDefaultButton(okButton); // set okButton as the default button 
			}
		}
	}

}
