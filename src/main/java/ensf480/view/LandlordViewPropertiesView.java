package ensf480.view;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ensf480.controller.LandlordController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import ensf480.model.*;

public class LandlordViewPropertiesView extends JPanel {
	private JTable table; // create JTable

	/**
	 * Create the panel.
	 */
	public LandlordViewPropertiesView(final int landlordID) {
        setBounds(300, 200, 850, 600); // set bounds
        setLayout(null); // set layout to null
        
        table = new JTable(); // initialize table 
        Object columnNames[] = {"Property ID", "Status", "Type", "Address", "Quadrant", "Bedrooms", "Bathrooms", "Furnished", "List Date", "Rent Date"}; // create object array of strings
        
        LandlordController landlordController = new LandlordController(); // new LandlordController

        ArrayList<Property> input = landlordController.getAllProperties(landlordID); // create new arraylist, and populate 

        DefaultTableModel model = new DefaultTableModel(columnNames, 0); // create new DefaultTableModel

        for(int i=0; i< input.size(); i++) {
            Object rowData[] = {input.get(i).getId(), input.get(i).getStatus(), 
                                input.get(i).getType(), input.get(i).getAddress().getStreetAddress(), input.get(i).getAddress().getQuadrant(), 
                                input.get(i).getNumBedrooms(), input.get(i).getNumBathrooms(), input.get(i).isFurnished(), input.get(i).getDateListed(), input.get(i).getDateRented()
            };
            //System.out.println(input.get(i).getPropertyType());
            model.addRow(rowData);
        } // populate row in model 
        
        table.setModel(model); // set data model     
        JScrollPane scrollPane = new JScrollPane(); // new JScrollPane
        scrollPane.setViewportView(table); // set ScrolllPane to have control over table 
        scrollPane.setBounds(44, 36, 751, 482); // set bounds 
        add(scrollPane); // add to view 

        JButton backButton = new JButton("Back"); // create new JButton 
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainFrame.getLandlordView(landlordID); // view is changed to LandlordView
        	}
        }); // action listener for when button is pressed 
        backButton.setBounds(751, 11, 89, 23); // set bounds 
        add(backButton); // add to view 

    }
}
