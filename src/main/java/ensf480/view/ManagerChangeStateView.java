package ensf480.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ensf480.controller.ManagerController;
import ensf480.model.Property;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.event.ActionEvent;


public class ManagerChangeStateView extends JPanel {
	private JDialog stateChangedDialog = new StateChangedDialog();
	/** 
	 * Create the panel.
	 */
	public ManagerChangeStateView() {
		setBounds(300, 200, 850, 600); // set bounds 
		setLayout(null); // set layout 
	
      final ManagerController managerController = new ManagerController();
      ArrayList<Property> activeProps = managerController.getAllActiveProperties();

	  ArrayList<String> propertyStrings = new ArrayList<>();
	for(Property prop: activeProps) { //for each suspended property
		propertyStrings.add(String.valueOf(prop.getId() + ": " + prop.getAddress().getStreetAddress())); //grab their id and address as a string
	}
	//and convert to String[]
	String[] properties = propertyStrings.toArray(new String[propertyStrings.size()]);
		
		final JComboBox propertyComboBox = new JComboBox(properties);
		propertyComboBox.setBounds(378, 138, 358, 20);
		add(propertyComboBox);
//		
		JLabel propertyLabel = new JLabel("Property"); // new JLabel
		propertyLabel.setBounds(203, 141, 60, 14); // set bounds 
		add(propertyLabel); // add to view 
		
		JLabel lblState = new JLabel("State"); // new JLabel
		lblState.setBounds(203, 241, 60, 14); // set bounds 
		add(lblState); // add to view 
		
		final JComboBox stateComboBox = new JComboBox(); // new JComboBox 
		stateComboBox.setModel(new DefaultComboBoxModel(new String[] {"Rented", "Cancelled", "Suspended"})); // set data model 
		stateComboBox.setBounds(378, 238, 358, 20); // set bounds 
		add(stateComboBox); // add to view 
		
		//JButton used to Confirm the state change
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String propertyToChange = (String) propertyComboBox.getSelectedItem();
				int colonIndex = propertyToChange.indexOf(":");
				int propId = Integer.parseInt(propertyToChange.substring(0, colonIndex));
				Property selectedProperty = managerController.getProperty(propId);
				String statusToChange = (String) stateComboBox.getSelectedItem();
				if(statusToChange.equals("Rented")){
					selectedProperty.setDateRented(LocalDate.now().toString());
				}
				selectedProperty.setStatus(statusToChange);
				managerController.updateProperty(selectedProperty);
				stateChangedDialog.setVisible(true);
				
			}
		}); // action listener in even that button is pressed  // new JButton
		confirmButton.setBounds(378, 382, 89, 23); // set bounds 
		add(confirmButton); // add to view 
		
		JButton backButton = new JButton("Back"); // new JButton 
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getManagerView(); // set view to ManagerView 
			}
		}); // action listener for when button is pressed 
		backButton.setBounds(751, 11, 89, 23);
		add(backButton);
		
	}

}
