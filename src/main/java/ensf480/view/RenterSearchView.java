package ensf480.view;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RenterSearchView extends JPanel {

	String PT;
	int NBD;
	int NBA;
	int F;
	String CQ;

	/**
	 * Create the panel.
	 */
	public RenterSearchView() {
		setBounds(300, 200, 850, 600); //Set Bounds of JPanel
		setLayout(null); //Set JPanel Layout
		
		// JLabel prompting user to enter search criteria
		JLabel enterSearchCriteriaLabel = new JLabel("Enter Search Criteria");
		enterSearchCriteriaLabel.setBounds(361, 10, 126, 13);
		add(enterSearchCriteriaLabel);
		
		// JLabel prompting user to enter Property Type
		JLabel propertyTypeLabel = new JLabel("Property Type");
		propertyTypeLabel.setBounds(264, 65, 126, 13);
		add(propertyTypeLabel);
		
		// JComboBox that holds property types
		final JComboBox propertyTypeComboBox = new JComboBox();
		propertyTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Apartment", "Attached House", "Detached House", "Townhouse", "Commercial", "Other"}));
		propertyTypeComboBox.setBounds(444, 60, 161, 23);
		add(propertyTypeComboBox);
		
		// JLabel prompting user to enter number of bedrooms
		JLabel numberOfBedroomsLabel = new JLabel("Number of bedrooms");
		numberOfBedroomsLabel.setBounds(264, 124, 126, 13);
		add(numberOfBedroomsLabel);
		
		// JLabel prompting user to enter number of bathrooms
		JLabel numberOfBathroomsLabel = new JLabel("Number of bathrooms");
		numberOfBathroomsLabel.setBounds(264, 188, 126, 13);
		add(numberOfBathroomsLabel);
		
		// JLabel prompting user to check whether they are searching for furnished or unfurnished
		JLabel furnishedLabel = new JLabel("Furnished");
		furnishedLabel.setBounds(264, 261, 126, 13);
		add(furnishedLabel);
		
		// JCheckBox to check for Furnishment
		final JCheckBox furnishedCheckBox = new JCheckBox("");
		furnishedCheckBox.setBounds(512, 261, 93, 21);
		add(furnishedCheckBox);
		

		// JLabel prompting user to enter city quadrant
		JLabel cityQuadrantLabel = new JLabel("City Quadrant");
		cityQuadrantLabel.setBounds(264, 333, 126, 13);
		add(cityQuadrantLabel);
		

		// JComboBox that holds city quadrants
		final JComboBox cityQuadrantComboBox = new JComboBox();
		cityQuadrantComboBox.setModel(new DefaultComboBoxModel(new String[] {"SW", "NW", "NE", "SE"}));
		cityQuadrantComboBox.setBounds(444, 323, 161, 23);
		add(cityQuadrantComboBox);
		
		// JCheckBox for if user wants to include search criteria
		final JCheckBox includeCheckBoxPT = new JCheckBox("Include");
		includeCheckBoxPT.setBounds(64, 60, 97, 23);
		add(includeCheckBoxPT);
		
		// JCheckBox for if user wants to include search criteria
		final JCheckBox includeCheckBoxNBD = new JCheckBox("Include");
		includeCheckBoxNBD.setBounds(64, 119, 97, 23);
		add(includeCheckBoxNBD);
		
		// JCheckBox for if user wants to include search criteria
		final JCheckBox includeCheckBoxNBA = new JCheckBox("Include");
		includeCheckBoxNBA.setBounds(64, 183, 97, 23);
		add(includeCheckBoxNBA);
		
		// JCheckBox for if user wants to include search criteria
		final JCheckBox includeCheckBoxF = new JCheckBox("Include");
		includeCheckBoxF.setBounds(64, 256, 97, 23);
		add(includeCheckBoxF);
		
		// JCheckBox for if user wants to include search criteria
		final JCheckBox includeCheckBoxCQ = new JCheckBox("Include");
		includeCheckBoxCQ.setBounds(64, 328, 97, 23);
		add(includeCheckBoxCQ);
		
		// JComboBox holding minimum amount of bedrooms to maximum
		final JComboBox numberOfBedroomsComboBox = new JComboBox();
		numberOfBedroomsComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		numberOfBedroomsComboBox.setBounds(444, 120, 161, 20);
		add(numberOfBedroomsComboBox);
		
		// JComboBox holding minimum amount of bathrooms to maximum
		final JComboBox numberOfBathroomsComboBox = new JComboBox();
		numberOfBathroomsComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		numberOfBathroomsComboBox.setBounds(444, 184, 161, 20);
		add(numberOfBathroomsComboBox);
		
		//Back Button to go to RenterView
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getRenterView(MainFrame.getRenterID());
			}
		});
		btnNewButton.setBounds(761, 5, 89, 23);
		add(btnNewButton);
		
		//Button to initiate the search in the Database
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Property Type
				if(includeCheckBoxPT.isSelected()) {
					PT = (String) propertyTypeComboBox.getSelectedItem();
				} else {
					PT = null;
				}
				
				//Number of Bedrooms
				if(includeCheckBoxNBD.isSelected()) {
					NBD = Integer.parseInt((String)numberOfBedroomsComboBox.getSelectedItem());
				} else {
					NBD = -1;
				}
				
				//Number of Bathrooms
				if(includeCheckBoxNBA.isSelected()) {
					NBA = Integer.parseInt((String)numberOfBathroomsComboBox.getSelectedItem());
				} else {
					NBA = -1;
				}
				
				//Furnished
				if(includeCheckBoxF.isSelected()) {
					if (furnishedCheckBox.isSelected()) {
						F = 1;
					} else {
						F = 0;
					}
				} else {
					F = -1;
				}
				
				//City Quadrant
				if(includeCheckBoxCQ.isSelected()) {
					CQ = (String) cityQuadrantComboBox.getSelectedItem();
				} else {
					CQ = null;
				}
				
				MainFrame.getAllRenterViewPropertiesView(PT, NBD, NBA, F, CQ);
				
				
			}
		});
		searchButton.setBounds(361, 454, 126, 21);
		add(searchButton);
		
	}
}

