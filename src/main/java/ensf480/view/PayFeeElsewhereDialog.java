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

public class PayFeeElsewhereDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PayFeeElsewhereDialog dialog = new PayFeeElsewhereDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // set default close operation 
			dialog.setVisible(true); // set as visible 
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // try and catch 

	/**
	 * Create the dialog.
	 */
	public PayFeeElsewhereDialog() {
		// set up JDialog
		setTitle("ATTENTION");
		setBounds(100, 100, 765, 458);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			// JLabel holding message viewed on JDialog
			JLabel warningLabel = new JLabel("Your property has been registered. Please go to the Pay Fees tab to set your property's status to active");
			warningLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			warningLabel.setBounds(47, 144, 666, 59);
			contentPanel.add(warningLabel);
		}
		{
			// JPanel used in order to hold JButton 
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				// JButton used inorder to close and dispose of JDialog when pressed 
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
