package ensf480.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

import ensf480.model.*;
import java.util.ArrayList;
import ensf480.controller.SearchCriteriaController;

public class AllRenterViewPropertiesView extends JPanel {
	private JTable table;
	private JTextField messageBodyField;
        JDialog messageSentDialog = new MessageSentDialog();

	/**
	 * Create the panel.
	 */
     //PT = Property Type, NBD = Number of Bedrooms, NBA = Number of Bathrooms, F = Furnished, CQ = City Quadrant
	public AllRenterViewPropertiesView(String PT, int NBD, int NBA, int F, String CQ) {
		setBounds(300, 200, 850, 600);
        setLayout(null);
        
        table = new JTable();
        Object columnNames[] = {"Property ID", "Type", "Address", "Quadrant", "Bedrooms", "Bathrooms", "Furnished", "List Date"};
        
        SearchCriteria searchCriteria = new SearchCriteria(-1);
        if(PT != null){
                searchCriteria.setType(PropertyType.valueOf(PT.toUpperCase()));
        }
        if(CQ != null) {
                searchCriteria.setQuadrant(Quadrant.valueOf(CQ.toUpperCase()));
        }
        searchCriteria.setNumBedrooms(NBD);
        searchCriteria.setNumBathrooms(NBA);
        searchCriteria.setIsFurnished(F);

        SearchCriteriaController scc = new SearchCriteriaController();
        ArrayList<Property> input = scc.searchProperties(searchCriteria);

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for(int i=0; i< input.size(); i++) {
            Object rowData[] = {input.get(i).getId(),  
                                input.get(i).getType(), input.get(i).getAddress().getStreetAddress(), input.get(i).getAddress().getQuadrant(), 
                                input.get(i).getNumBedrooms(), input.get(i).getNumBathrooms(), input.get(i).isFurnished(), input.get(i).getDateListed()
            };
            //System.out.println(input.get(i).getPropertyType());
            model.addRow(rowData);
        }
        
        table.setModel(model);        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);	
        scrollPane.setBounds(45, 45, 751, 306);
        add(scrollPane);
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainFrame.getURenterView();
        	}
        });
        backButton.setBounds(740, 11, 89, 23);
        add(backButton);
        
        JButton sendMessageButton = new JButton("Send");
        sendMessageButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		messageSentDialog.setVisible(true);
        	}
        });
        sendMessageButton.setBounds(707, 491, 89, 23);
        add(sendMessageButton);
        
        messageBodyField = new JTextField();
        messageBodyField.setBounds(279, 430, 418, 145);
        add(messageBodyField);
        messageBodyField.setColumns(10);
        
        JLabel lblBody = new JLabel("Body");
        lblBody.setBounds(472, 405, 89, 14);
        add(lblBody);
        
        JLabel lblPropertyId = new JLabel("Property ID");
        lblPropertyId.setBounds(117, 477, 89, 14);
        add(lblPropertyId);
        
        ArrayList<String> propertyIDs = new ArrayList<>();
        for(Property property : input) {
            propertyIDs.add(String.valueOf(property.getId()));
        }

        JComboBox propertyIDComboBox = new JComboBox();
        propertyIDComboBox.setModel(new DefaultComboBoxModel(propertyIDs.toArray()));
        propertyIDComboBox.setBounds(45, 492, 224, 20);
        add(propertyIDComboBox);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(10, 367, 830, 2);
        add(separator);
        
        JLabel messaginSystemLabel = new JLabel("Messaging System");
        messaginSystemLabel.setBounds(382, 380, 116, 14);
        add(messaginSystemLabel);

        JLabel lblNewLabel = new JLabel("Title");
        lblNewLabel.setBounds(126, 495, 49, 14);
        add(lblNewLabel);

         JTextField textField_1 = new JTextField();
        textField_1.setBounds(65, 520, 150, 20);
        add(textField_1);
        textField_1.setColumns(10);
	}
}
