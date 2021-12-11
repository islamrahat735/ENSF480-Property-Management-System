package ensf480.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import ensf480.controller.LandlordController;
import ensf480.model.*;

public class LandlordPayFeeView extends JPanel {
	JDialog feePaidDialog = new FeePaidDialog();

	/**
	 * Create the panel.
	 */
	public LandlordPayFeeView() {
	setBounds(300, 200, 850, 600); // set bounds 
	setLayout(null); // set layout as null, absolute positioning 
	
	JLabel currentFeeLabel = new JLabel("Current Fee:"); // create new JLabel 
	currentFeeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20)); // set font
	currentFeeLabel.setBounds(215, 173, 200, 25); // set bounds
	add(currentFeeLabel); // add to view
	
	JLabel currentDurationLabel = new JLabel("Duration:"); // create newJLabel 
	currentDurationLabel.setFont(new Font("Tahoma", Font.PLAIN, 20)); // set font 
	currentDurationLabel.setBounds(215, 249, 200, 25); // set bounds 
	add(currentDurationLabel); // add to view 
	
	
	 
	JButton backButton = new JButton("Back"); // create new JButton
	backButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MainFrame.getLandlordView(MainFrame.getLandlordID()); // change view to LandlordView for landlord with corresponding id 
		}
	}); // action listener in event that button is pressed 
	backButton.setBounds(740, 11, 100, 30); // set bounds 
	add(backButton); // add to view 
	
	//Populate with Suspended Properties
	//You can use MainFrame.getLandlordID() to get the landlord's id for the query
	final LandlordController lc = new LandlordController();
	ArrayList<Property> susProperties = lc.getSuspendedProperties(MainFrame.getLandlordID()); //suspended properties
	ArrayList<String> propertyStrings = new ArrayList<>();
	for(Property prop: susProperties) { //for each suspended property
		propertyStrings.add(String.valueOf(prop.getId() + ": " + prop.getAddress().getStreetAddress())); //grab their id and address as a string
	}
	//and convert to String[]
	String[] properties = propertyStrings.toArray(new String[propertyStrings.size()]);

	final JComboBox propertyComboBox = new JComboBox(properties); // create new JComboBox 
	propertyComboBox.setBounds(460, 329, 200, 22); // set bounds 
	add(propertyComboBox); // add to view 
	
	JLabel propertyLabel = new JLabel("Property:"); // create new JLabel 
	propertyLabel.setFont(new Font("Tahoma", Font.PLAIN, 20)); // set font 
	propertyLabel.setBounds(215, 324, 200, 25); // set bounds 
	add(propertyLabel); // add to view
	
	final Fee fee = lc.getFee(); //gets the fee from the db

	//displays the fee's cost
	float currentFee = fee.getCost(); 
	JLabel currentFeeValue = new JLabel(String.valueOf(currentFee)); // create new JLabel 
	currentFeeValue.setFont(new Font("Tahoma", Font.PLAIN, 20)); // set font
	currentFeeValue.setBounds(460, 173, 200, 25); // set bounds 
	add(currentFeeValue); // add to view 
	
	//displays the fee's duration
	int currentDuration = fee.getDurationDays();
	JLabel currentDurationValue = new JLabel(String.valueOf(currentDuration)); // create new JLabel 
	currentDurationValue.setFont(new Font("Tahoma", Font.PLAIN, 20)); // set font
	currentDurationValue.setBounds(460, 249, 200, 25); // set bounds 
	add(currentDurationValue); // add to view 

	JButton payFeeButton = new JButton("Pay Fee"); // create new JButton 
	payFeeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String propertyToChange = (String) propertyComboBox.getSelectedItem();
			int colonIndex = propertyToChange.indexOf(":");
			int propId = Integer.parseInt(propertyToChange.substring(0, colonIndex));
			lc.listProperty(lc.getProperty(propId)); //gets the property of the ID and then lists it, changing to ACTIVE
			feePaidDialog.setVisible(true);
		}
	}); // action listener in even that button is pressed 
	payFeeButton.setFont(new Font("Tahoma", Font.PLAIN, 15)); // set font 
	payFeeButton.setBounds(344, 487, 150, 50); // set bounds 
	add(payFeeButton);// add to view 

	}
}
