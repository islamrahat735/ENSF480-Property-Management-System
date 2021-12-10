package ensf480.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LandlordRegisterPropertyView extends JPanel {
	private JTextField numberOfBedroomsText;
	private JTextField addressText;
	private JTextField numberOfBathroomsText;
	JDialog invalidAddressDialog = new InvalidAddressDialog();
	private boolean isNumeric = true;
	JDialog invalidInputDialog = new InvalidInputDialog();

	/**
	 * Create the panel.
	 */
	public LandlordRegisterPropertyView(int landLordID) {
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
		
		numberOfBedroomsText = new JTextField();
		numberOfBedroomsText.setBounds(444, 121, 161, 19);
		add(numberOfBedroomsText);
		numberOfBedroomsText.setColumns(10);
		
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
		
		JButton searchButton = new JButton("Add");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int check = Integer.parseInt(numberOfBedroomsText.getText());
					int check2 = Integer.parseInt(numberOfBathroomsText.getText());
				} catch(NumberFormatException err){
					isNumeric = false;
				}
				if (addressText.getText().length() == 0) {
					invalidAddressDialog.setVisible(true);
				}
				else if(isNumeric == false){
					invalidInputDialog.setVisible(true);
				} else {
					String address = addressText.getText();
					String status = "suspended";
					String type = (String) propertyTypeComboBox.getSelectedItem();
					String quadrant = (String) cityQuadrantComboBox.getSelectedItem();
					int bedrooms = Integer.parseInt(numberOfBedroomsText.getText());
					int bathrooms = Integer.parseInt(numberOfBathroomsText.getText());
					boolean isFurnished = furnishedCheckBox.isSelected();
					int ownerID = MainFrame.getLandlordID();
				}
			}
		});
		searchButton.setBounds(361, 459, 126, 21);
		add(searchButton);
		
		JLabel addressLabel = new JLabel("Address");
		addressLabel.setBounds(215, 401, 46, 14);
		add(addressLabel);
		
		numberOfBathroomsText = new JTextField();
		numberOfBathroomsText.setBounds(444, 184, 161, 20);
		add(numberOfBathroomsText);
		numberOfBathroomsText.setColumns(10);
	}
}
