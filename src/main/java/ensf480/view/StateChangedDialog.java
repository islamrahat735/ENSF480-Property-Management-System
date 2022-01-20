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

public class StateChangedDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StateChangedDialog dialog = new StateChangedDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // set default close operation 
			dialog.setVisible(true); // set as visible
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // try and catch for error handling

	/**
	 * Create the dialog.
	 */
	public StateChangedDialog() {
		// set up JDialog
		setBounds(100, 100, 547, 346);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{	
			// JLabel holding message that JDialog displays
			JLabel messageLabel = new JLabel("Property State Changed");
			messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
			messageLabel.setBounds(137, 101, 322, 74);
			contentPanel.add(messageLabel);
		}
		{
			// JPanel that holds okButton
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				// JButton used inorder to close and dispose of JDialog
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
