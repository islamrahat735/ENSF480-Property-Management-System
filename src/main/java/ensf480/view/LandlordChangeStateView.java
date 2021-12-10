package ensf480.view;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class LandlordChangeStateView extends JPanel {

	/**
	 * Create the panel.
	 */
	public LandlordChangeStateView(int landlordID){
		setBounds(300, 200, 850, 600); // set bounds
		setLayout(null); // set layout to null, absolute positioning
		
//      LandlordController landlordController = new LandlordController();
//      String[] addresses = landlordController.getAddresses();
		
//		JComboBox propertyComboBox = new JComboBox(addresses);
//		propertyComboBox.setBounds(378, 138, 358, 20);
//		add(propertyComboBox);
		
		JLabel propertyLabel = new JLabel("Property"); // create new JLabel
		propertyLabel.setBounds(203, 141, 60, 14); // set bounds
		add(propertyLabel); // add to view
		
		JLabel lblState = new JLabel("State"); // create new JLabel
		lblState.setBounds(203, 241, 60, 14); // set bounds
		add(lblState); // add to view
		
		JComboBox stateComboBox = new JComboBox(); // create new JComboBoc
		stateComboBox.setModel(new DefaultComboBoxModel(new String[] {"Active", "Rented", "Cancelled", "Suspended"})); // set model with DefaultComboBoxModel initialied with array of strings
		stateComboBox.setBounds(378, 238, 358, 20); // set bounds
		add(stateComboBox); // add to view
		
		JButton confirmButton = new JButton("Confirm"); // new JButton
		confirmButton.setBounds(378, 382, 89, 23); // set bounds
		add(confirmButton); // add to view
	}
}
