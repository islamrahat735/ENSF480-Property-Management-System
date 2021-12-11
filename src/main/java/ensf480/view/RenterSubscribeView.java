package ensf480.view;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;

import ensf480.controller.RegRenterController;
import ensf480.model.PropertyType;
import ensf480.model.Quadrant;
import ensf480.model.SearchCriteria;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RenterSubscribeView extends JPanel {
	String PT;
	int NBD;
	int NBA;
	int F;
	String CQ;
    JDialog actionSuccessfulDialog = new ActionSuccessfulDialog();

	/**
	 * Create the panel.
	 */
	public RenterSubscribeView() {
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
		JLabel enterSearchCriteriaLabel = new JLabel("Enter Search Criteria");
		enterSearchCriteriaLabel.setBounds(361, 10, 126, 13);
		add(enterSearchCriteriaLabel);
		
		JLabel propertyTypeLabel = new JLabel("Property Type");
		propertyTypeLabel.setBounds(264, 65, 126, 13);
		add(propertyTypeLabel);
		
		final JComboBox propertyTypeComboBox = new JComboBox();
		propertyTypeComboBox.setModel(new DefaultComboBoxModel(new String[] {"Apartment", "Attached House", "Detached House", "Townhouse", "Commercial", "Other"}));
		propertyTypeComboBox.setBounds(444, 60, 161, 23);
		add(propertyTypeComboBox);
		
		JLabel numberOfBedroomsLabel = new JLabel("Number of bedrooms");
		numberOfBedroomsLabel.setBounds(264, 124, 126, 13);
		add(numberOfBedroomsLabel);
		
		JLabel numberOfBathroomsLabel = new JLabel("Number of bathrooms");
		numberOfBathroomsLabel.setBounds(264, 188, 126, 13);
		add(numberOfBathroomsLabel);
		
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
		
		final JCheckBox includeCheckBoxPT = new JCheckBox("Include");
		includeCheckBoxPT.setBounds(64, 60, 97, 23);
		add(includeCheckBoxPT);
		
		final JCheckBox includeCheckBoxNBD = new JCheckBox("Include");
		includeCheckBoxNBD.setBounds(64, 119, 97, 23);
		add(includeCheckBoxNBD);
		
		final JCheckBox includeCheckBoxNBA = new JCheckBox("Include");
		includeCheckBoxNBA.setBounds(64, 183, 97, 23);
		add(includeCheckBoxNBA);
		
		final JCheckBox includeCheckBoxF = new JCheckBox("Include");
		includeCheckBoxF.setBounds(64, 256, 97, 23);
		add(includeCheckBoxF);
		
		final JCheckBox includeCheckBoxCQ = new JCheckBox("Include");
		includeCheckBoxCQ.setBounds(64, 328, 97, 23);
		add(includeCheckBoxCQ);
		
		final JComboBox numberOfBedroomsComboBox = new JComboBox();
		numberOfBedroomsComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		numberOfBedroomsComboBox.setBounds(444, 120, 161, 20);
		add(numberOfBedroomsComboBox);
		
		final JComboBox numberOfBathroomsComboBox = new JComboBox();
		numberOfBathroomsComboBox.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		numberOfBathroomsComboBox.setBounds(444, 184, 161, 20);
		add(numberOfBathroomsComboBox);
		
		JButton subscribeButton = new JButton("Subscribe");
		subscribeButton.addActionListener(new ActionListener() { // add code to strore search criteria into db
			public void actionPerformed(ActionEvent e) {
                actionSuccessfulDialog.setVisible(true);
				SearchCriteria searchCriteria = new SearchCriteria(MainFrame.getRenterID());
				//Property Type
				if(includeCheckBoxPT.isSelected()) {
					PT = (String) propertyTypeComboBox.getSelectedItem();
					searchCriteria.setType(PropertyType.valueOf(PT.toUpperCase()));
				} else {
					PT = null;
				}
				
				// //Number of Bedrooms
				if(includeCheckBoxNBD.isSelected()) {
					NBD = Integer.parseInt((String) numberOfBedroomsComboBox.getSelectedItem());
					searchCriteria.setNumBedrooms(NBD);
				} else {
					NBD = -1;
				}
				
				// //Number of Bathrooms
				if(includeCheckBoxNBA.isSelected()) {
					NBA = Integer.parseInt((String) numberOfBathroomsComboBox.getSelectedItem());
					searchCriteria.setNumBathrooms(NBA);
				} else {
					NBA = -1;
				}
				
				// //Furnished
				if(includeCheckBoxF.isSelected()) {
					if (furnishedCheckBox.isSelected()) {
						F = 1;
					} else {
						F = 0;
					}
				} else {
					F = -1;
				}
				searchCriteria.setIsFurnished(F);
				
				// //City Quadrant
				if(includeCheckBoxCQ.isSelected()) {
					CQ = (String) cityQuadrantComboBox.getSelectedItem();
					searchCriteria.setQuadrant(Quadrant.valueOf(CQ.toUpperCase()));
				} else {
					CQ = null;
				}

				RegRenterController regRenterController = new RegRenterController();

				regRenterController.subscribe(MainFrame.getRenterID(), searchCriteria);

				actionSuccessfulDialog.setVisible(true);
				
				MainFrame.getRenterView(MainFrame.getRenterID());
			}
		});
		subscribeButton.setBounds(361, 428, 126, 21);
		add(subscribeButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getRenterView(MainFrame.getRenterID());
			}
		});
		backButton.setBounds(751, 10, 89, 23);
		add(backButton);
	}
}
