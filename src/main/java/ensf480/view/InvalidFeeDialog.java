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
		setTitle("WARNING");
		setBounds(100, 100, 552, 361);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel warningLabel = new JLabel("Invalid Fee");
			warningLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
			warningLabel.setBounds(78, 91, 448, 59);
			contentPanel.add(warningLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
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
