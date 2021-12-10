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
	private JTextField addressText;
	JDialog invalidAddressDialog = new InvalidAddressDialog();
	JDialog payFeeElseWhereDialog = new PayFeeElsewhereDialog();

	/**
	 * Create the panel.
	 */
	public LandlordRegisterPropertyView(final int landlordID) {
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
		JLabel enterSearchCriteriaLabel = new JLabel("Enter Property Details");
		enterSearchCriteriaLabel.setBounds(361, 10, 126, 13);
		add(enterSearchCriteriaLabel);
		
		JLabel proeprtyTypeLabel = new JLabel("Property Type");
		proeprtyTypeLabel.setBounds(264, 65, 126, 13);
		add(proeprtyTypeLabel);
		
		final JComboBox propertyTypeComboBox = new JComboBox();
		propertyTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Apartment", "Attached House", "Detached House", "Townhouse"}));
		propertyTypeComboBox.setBounds(444, 60, 161, 23);
		add(propertyTypeComboBox);
		
		JLabel numberOfBedroomsLabel = new JLabel("Number of bedrooms");
		numberOfBedroomsLabel.setBounds(264, 124, 126, 13);
		add(numberOfBedroomsLabel);
		
		JLabel numberOfBathroomsLabel = new JLabel("Number of bathrooms");
		numberOfBathroomsLabel.setBounds(264, 188, 126, 13);
		add(numberOfBathroomsLabel);
		
		addressText = new JTextField();
		addressText.setColumns(10);
		addressText.setBounds(444, 398, 261, 19);
		add(addressText);
		
		JLabel furnishedLabel = new JLabel("Furnished");
		furnishedLabel.setBounds(264, 261, 126, 13);
		add(furnishedLabel);
		
		final JCheckBox furnishedCheckBox = new JCheckBox("");
		furnishedCheckBox.setBounds(512, 261, 93, 21);
		add(furnishedCheckBox);
		
		JLabel cityQuadrantLabel = new JLabel("City Quadrant");
		cityQuadrantLabel.setBounds(264, 333, 126, 13);
		add(cityQuadrantLabel);
		
		final JComboBox cityQuadrantComboBox = new JComboBox();
		cityQuadrantComboBox.setModel(new DefaultComboBoxModel(new String[] {"SW", "NW", "NE", "SE"}));
		cityQuadrantComboBox.setBounds(444, 323, 161, 23);
		add(cityQuadrantComboBox);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(215, 401, 46, 14);
		add(addressLabel);
		
		final JComboBox numberOfBedroomsCombo = new JComboBox();
		numberOfBedroomsCombo.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		numberOfBedroomsCombo.setBounds(444, 120, 161, 20);
		add(numberOfBedroomsCombo);
		
		final JComboBox numberOfBathroomsCombo = new JComboBox();
		numberOfBathroomsCombo.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		numberOfBathroomsCombo.setBounds(444, 181, 161, 20);
		add(numberOfBathroomsCombo);
		
		JButton searchButton = new JButton("Add");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addressText.getText().length() == 0) {
					invalidAddressDialog.setVisible(true);
				} else {
					String address = addressText.getText();
					String status = "suspended";
					String type = (String) propertyTypeComboBox.getSelectedItem();
					String quadrant = (String) cityQuadrantComboBox.getSelectedItem();
					int bedrooms = Integer.parseInt((String) numberOfBedroomsCombo.getSelectedItem());
					int bathrooms = Integer.parseInt((String) numberOfBathroomsCombo.getSelectedItem());
					boolean isFurnished = furnishedCheckBox.isSelected();
					int ownerID = MainFrame.getLandlordID();
					//Put your code here to register property
					Address temp = new Address(address, quadrant.toUpperCase());
					Property property = new Property(type, temp, bedrooms, bathrooms, isFurnished, ownerID);
					LandlordController landlordController = new LandlordController();
					landlordController.registerProperty(property);
					payFeeElseWhereDialog.setVisible(true);
				}
			}
		});
		searchButton.setBounds(361, 459, 126, 21);
		add(searchButton);
		
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
