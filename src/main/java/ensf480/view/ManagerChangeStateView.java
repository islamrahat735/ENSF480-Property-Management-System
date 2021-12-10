package ensf480.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ManagerChangeStateView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ManagerChangeStateView() {
		setBounds(300, 200, 850, 600);
		setLayout(null);
	
//      ManagerController managerController = new ManagerController();
//      String[] addresses = managerController.getAddresses();
		
//		JComboBox propertyComboBox = new JComboBox(addresses);
//		propertyComboBox.setBounds(378, 138, 358, 20);
//		add(propertyComboBox);
//		
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
