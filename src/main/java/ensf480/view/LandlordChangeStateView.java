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
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
//      LandlordController landlordController = new LandlordController();
//      String[] addresses = landlordController.getAddresses();
		
//		JComboBox propertyComboBox = new JComboBox(addresses);
//		propertyComboBox.setBounds(378, 138, 358, 20);
//		add(propertyComboBox);
		
		JLabel propertyLabel = new JLabel("Property");
		propertyLabel.setBounds(203, 141, 60, 14);
		add(propertyLabel);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(203, 241, 60, 14);
		add(lblState);
		
		JComboBox stateComboBox = new JComboBox();
		stateComboBox.setModel(new DefaultComboBoxModel(new String[] {"Active", "Rented", "Cancelled", "Suspended"}));
		stateComboBox.setBounds(378, 238, 358, 20);
		add(stateComboBox);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.setBounds(378, 382, 89, 23);
		add(confirmButton);
	}
}
