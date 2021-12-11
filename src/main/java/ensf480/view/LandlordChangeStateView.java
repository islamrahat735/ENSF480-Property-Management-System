package ensf480.view;

import javax.swing.JPanel;

import ensf480.controller.LandlordController;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import ensf480.model.*;

public class LandlordChangeStateView extends JPanel {
	private JDialog stateChangedDialog = new StateChangedDialog();
	

	/**
	 * Create the panel.
	 */
	public LandlordChangeStateView(int landlordID){
		setBounds(300, 200, 850, 600); // set bounds
		setLayout(null); // set layout to null, absolute positioning
		
      final LandlordController landlordController = new LandlordController();

	  ArrayList<Property> activeLandlordProperties = landlordController.getActiveProperties(landlordID);

	  ArrayList<String> propertyStrings = new ArrayList<>();
	for(Property prop: activeLandlordProperties) { //for each active property
		propertyStrings.add(String.valueOf(prop.getId() + ": " + prop.getAddress().getStreetAddress())); //grab their id and address as a string
	}
	//and convert to String[]
	String[] properties = propertyStrings.toArray(new String[propertyStrings.size()]);

//      String[] addresses = landlordController.getActiveAddresses();
		
		final JComboBox propertyComboBox = new JComboBox(properties);
		propertyComboBox.setBounds(378, 138, 358, 20);
		add(propertyComboBox);
		
		JLabel propertyLabel = new JLabel("Property"); // create new JLabel
		propertyLabel.setBounds(203, 141, 60, 14); // set bounds
		add(propertyLabel); // add to view
		
		JLabel lblState = new JLabel("State"); // create new JLabel
		lblState.setBounds(203, 241, 60, 14); // set bounds
		add(lblState); // add to view
		
		final JComboBox stateComboBox = new JComboBox(); // create new JComboBox
		stateComboBox.setModel(new DefaultComboBoxModel(new String[] {"Rented", "Cancelled", "Suspended"})); // set model with DefaultComboBoxModel initialied with array of strings
		stateComboBox.setBounds(378, 238, 358, 20); // set bounds
		add(stateComboBox); // add to view
		
		//JButton used to Confirm the state change
		JButton confirmButton = new JButton("Confirm"); // new JButton
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String propertyToChange = (String) propertyComboBox.getSelectedItem();
				int colonIndex = propertyToChange.indexOf(":");
				int propId = Integer.parseInt(propertyToChange.substring(0, colonIndex));
				Property selectedProperty = landlordController.getProperty(propId);
				String statusToChange = (String) stateComboBox.getSelectedItem();
				if(statusToChange.equals("Rented")){
					selectedProperty.setDateRented(LocalDate.now().toString());
				}
				selectedProperty.setStatus(statusToChange);
				landlordController.updateProperty(selectedProperty);
				stateChangedDialog.setVisible(true);
			}
		});
		confirmButton.setBounds(378, 382, 89, 23); // set bounds
		add(confirmButton); // add to view
		
		// JButton used for going back, changes view to RenterView
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.getLandlordView(MainFrame.getLandlordID());
			}
		});
		backButton.setBounds(751, 11, 89, 23);
		add(backButton);
	}
}
