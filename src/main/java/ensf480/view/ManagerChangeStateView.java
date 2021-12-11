package ensf480.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ManagerChangeStateView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ManagerChangeStateView() {
		setBounds(300, 200, 850, 600); // set bounds 
		setLayout(null); // set layout 
	
//      ManagerController managerController = new ManagerController();
//      String[] addresses = managerController.getAddresses();
		
//		JComboBox propertyComboBox = new JComboBox(addresses);
//		propertyComboBox.setBounds(378, 138, 358, 20);
//		add(propertyComboBox);
//		
		JLabel propertyLabel = new JLabel("Property"); // new JLabel
		propertyLabel.setBounds(203, 141, 60, 14); // set bounds 
		add(propertyLabel); // add to view 
		
		JLabel lblState = new JLabel("State"); // new JLabel
		lblState.setBounds(203, 241, 60, 14); // set bounds 
		add(lblState); // add to view 
		
		JComboBox stateComboBox = new JComboBox(); // new JComboBox 
		stateComboBox.setModel(new DefaultComboBoxModel(new String[] {"Active", "Rented", "Cancelled", "Suspended"})); // set data model 
		stateComboBox.setBounds(378, 238, 358, 20); // set bounds 
		add(stateComboBox); // add to view 
		
		JButton confirmButton = new JButton("Confirm"); // new JButton
		confirmButton.setBounds(378, 382, 89, 23); // set bounds 
		add(confirmButton); // add to view 
		
		JButton backButton = new JButton("Back"); // new JButton 
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getManagerView(); // set view to ManagerView 
			}
		}); // action listener for when button is pressed 
	}

}
