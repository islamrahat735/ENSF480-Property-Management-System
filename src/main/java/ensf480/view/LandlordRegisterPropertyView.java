package ensf480.view;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ensf480.controller.LandlordController;
import ensf480.model.Address;
import ensf480.model.Property;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LandlordRegisterPropertyView extends JPanel {
	private JTextField addressText; // create new JTextField 
	JDialog invalidAddressDialog = new InvalidAddressDialog(); // create new JDialog
	JDialog payFeeElseWhereDialog = new PayFeeElsewhereDialog(); // create new JDialog

	/**
	 * Create the panel.
	 */
	public LandlordRegisterPropertyView(final int landlordID) {
		setBounds(300, 200, 850, 600); // set bounds 
		setLayout(null); // set layout to null, absolute positioning 
		
		JLabel enterSearchCriteriaLabel = new JLabel("Enter Property Details"); // create new JLabel 
		enterSearchCriteriaLabel.setBounds(361, 10, 126, 13); // set bounds 
		add(enterSearchCriteriaLabel); // add to view 
		
		JLabel proeprtyTypeLabel = new JLabel("Property Type"); // create new JLabel
		proeprtyTypeLabel.setBounds(264, 65, 126, 13); // set bounds 
		add(proeprtyTypeLabel); // add to view 
		
		final JComboBox propertyTypeComboBox = new JComboBox(); // create new JComboBox
		propertyTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Apartment", "Attached_House", "Detached_House", "Townhouse", "Commercial", "Other"})); // set data model to DefaultComboBox initialized with array of strings 
		propertyTypeComboBox.setBounds(444, 60, 161, 23); // set bounds
		add(propertyTypeComboBox); // add to view 
		
		JLabel numberOfBedroomsLabel = new JLabel("Number of bedrooms"); // create new JLabel 
		numberOfBedroomsLabel.setBounds(264, 124, 126, 13); // set bounds 
		add(numberOfBedroomsLabel); // add to view 
		
		JLabel numberOfBathroomsLabel = new JLabel("Number of bathrooms"); // create new JLabel 
		numberOfBathroomsLabel.setBounds(264, 188, 126, 13); // set bounds 
		add(numberOfBathroomsLabel); // add to view 
		
		addressText = new JTextField(); // create new JTextField 
		addressText.setColumns(10); // set amount of columns
		addressText.setBounds(444, 398, 261, 19); // set bounds 
		add(addressText); // add to view 
		
		JLabel furnishedLabel = new JLabel("Furnished"); // create new JLabel
		furnishedLabel.setBounds(264, 261, 126, 13); // set bounds 
		add(furnishedLabel); // add to view 
		
		final JCheckBox furnishedCheckBox = new JCheckBox(""); // create new JCheckBox
		furnishedCheckBox.setBounds(512, 261, 93, 21); // set bounds 
		add(furnishedCheckBox); // add to view
		
		JLabel cityQuadrantLabel = new JLabel("City Quadrant"); // create new JLabel
		cityQuadrantLabel.setBounds(264, 333, 126, 13); // set bounds
		add(cityQuadrantLabel); // add to view 
		
		final JComboBox cityQuadrantComboBox = new JComboBox(); // create new JComboBox
		cityQuadrantComboBox.setModel(new DefaultComboBoxModel(new String[] {"SW", "NW", "NE", "SE"})); // set data model to DefaultComboBox initialized with array of strings
		cityQuadrantComboBox.setBounds(444, 323, 161, 23); // set bounds
		add(cityQuadrantComboBox); // add to view 
		
		JLabel addressLabel = new JLabel("Address"); // create new JLabel
		addressLabel.setBounds(215, 401, 46, 14); // set bounds 
		add(addressLabel); // add to view 
		
		final JComboBox numberOfBedroomsCombo = new JComboBox();// create new JComboBox
		numberOfBedroomsCombo.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"})); // set data model to DefaultComboBox initialized with array of strings
		numberOfBedroomsCombo.setBounds(444, 120, 161, 20);// set bounds 
		add(numberOfBedroomsCombo);// add to view 
		
		final JComboBox numberOfBathroomsCombo = new JComboBox();
		numberOfBathroomsCombo.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"})); // set data model to DefaultComboBox initialized with array of strings
		numberOfBathroomsCombo.setBounds(444, 181, 161, 20);// set bounds 
		add(numberOfBathroomsCombo);// add to view 
		
		JButton searchButton = new JButton("Add"); // create new JButton 
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addressText.getText().length() == 0) {
					invalidAddressDialog.setVisible(true); // set invalidAddressDialog to visible if addressText is empty
				} else {
					String address = addressText.getText(); // get text from JTextField and initialize string 
					String type = (String) propertyTypeComboBox.getSelectedItem(); // use getter and type cast received object to string, intialize string variable with value 
					String quadrant = (String) cityQuadrantComboBox.getSelectedItem();// use getter and type cast received object to string, intialize string variable with value 
					int bedrooms = Integer.parseInt((String) numberOfBedroomsCombo.getSelectedItem());// use getter and type cast received object to int, intialize string variable with value 
					int bathrooms = Integer.parseInt((String) numberOfBathroomsCombo.getSelectedItem());// use getter and type cast received object to int, intialize string variable with value 
					boolean isFurnished = furnishedCheckBox.isSelected(); // check if JCheckBox is checked off or not, and set boolean to either true or false depending on results 
					int ownerID = MainFrame.getLandlordID(); // get Landlord ID, init int
					//Put your code here to register property
					Address temp = new Address(address, quadrant.toUpperCase()); // create new Address
					Property property = new Property(type, temp, bedrooms, bathrooms, isFurnished, ownerID); // create new Property
					LandlordController landlordController = new LandlordController(); // create new LandlordController
					landlordController.registerProperty(property); // register property
					payFeeElseWhereDialog.setVisible(true); // show dialog
				}
			}
		});
		searchButton.setBounds(361, 459, 126, 21); // set bounds 
		add(searchButton); // add to view
		
		JButton backButton = new JButton("Back"); // new JButton
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandlordView(MainFrame.getLandlordID()); // get landlord id
			}
		}); // action listener for when button is pressed 
		backButton.setBounds(751, 11, 89, 23); // set bounds 
		add(backButton); // add to view 
	}
}
