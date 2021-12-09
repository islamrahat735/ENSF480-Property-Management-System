package ensf480.view;


import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class URenterView extends JPanel {
	private JTextField numberofBedroomsText;
	private JTextField numberOfBathroomsText;

	/**
	 * Create the panel.
	 */
	public URenterView() {
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
		JLabel enterSearchCriteriaLabel = new JLabel("Enter Search Criteria");
		enterSearchCriteriaLabel.setBounds(361, 10, 126, 13);
		add(enterSearchCriteriaLabel);
		
		JLabel proeprtyTypeLabel = new JLabel("Property Type");
		proeprtyTypeLabel.setBounds(264, 65, 126, 13);
		add(proeprtyTypeLabel);
		
		JComboBox propertyTypeComboBox = new JComboBox();
		propertyTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Apartment", "Attached House", "Detached House", "Townhouse"}));
		propertyTypeComboBox.setBounds(444, 60, 161, 23);
		add(propertyTypeComboBox);
		
		JLabel numberOfBedroomsLabel = new JLabel("Number of bedrooms");
		numberOfBedroomsLabel.setBounds(264, 124, 126, 13);
		add(numberOfBedroomsLabel);
		
		numberofBedroomsText = new JTextField();
		numberofBedroomsText.setBounds(444, 121, 161, 19);
		add(numberofBedroomsText);
		numberofBedroomsText.setColumns(10);
		
		JLabel numberOfBathroomsLabel = new JLabel("Number of bathrooms");
		numberOfBathroomsLabel.setBounds(264, 188, 126, 13);
		add(numberOfBathroomsLabel);
		
		numberOfBathroomsText = new JTextField();
		numberOfBathroomsText.setColumns(10);
		numberOfBathroomsText.setBounds(444, 185, 161, 19);
		add(numberOfBathroomsText);
		
		JLabel furnishedLabel = new JLabel("Furnished");
		furnishedLabel.setBounds(264, 261, 126, 13);
		add(furnishedLabel);
		
		JCheckBox furnishedCheckBox = new JCheckBox("");
		furnishedCheckBox.setBounds(512, 261, 93, 21);
		add(furnishedCheckBox);
		
		JLabel cityQuadrantLabel = new JLabel("City Quadrant");
		cityQuadrantLabel.setBounds(264, 333, 126, 13);
		add(cityQuadrantLabel);
		
		JComboBox cityQuadrantComboBox = new JComboBox();
		cityQuadrantComboBox.setModel(new DefaultComboBoxModel(new String[] {"SW", "NW", "NE", "SE"}));
		cityQuadrantComboBox.setBounds(444, 323, 161, 23);
		add(cityQuadrantComboBox);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(361, 428, 126, 21);
		add(searchButton);
	}
}
