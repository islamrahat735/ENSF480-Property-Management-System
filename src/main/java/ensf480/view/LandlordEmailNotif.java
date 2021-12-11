package ensf480.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class LandlordEmailNotif extends JPanel {
private JTable table;
	/**
	 * Create the panel.
	 */
	public LandlordEmailNotif() {
		 	setBounds(300, 200, 850, 600); // set bounds
	        setLayout(null); // set layout to null, absolute positioning
	        
	        table = new JTable(); // create new JTable
	        Object columnNames[] = {"From", "Title", "Body"}; // initalize new array of objects
	        
//	        LandlordController lc = new LandlordController();
//
//	        ArrayList<Email> input = managerController.getAllProperties();

	        DefaultTableModel model = new DefaultTableModel(columnNames, 0); // create new DefaultTableModel

//	        for(int i=0; i< input.size(); i++) {
//	            Object rowData[] = {input.get(i).getId(), input.get(i).getStatus(), 
//	                                input.get(i).getType(), input.get(i).getAddress().getStreetAddress(), input.get(i).getAddress().getQuadrant(), 
//	                                input.get(i).getNumBedrooms(), input.get(i).getNumBathrooms(), input.get(i).isFurnished(), input.get(i).getownerId(), input.get(i).getDateListed(), input.get(i).getDateRented()
//	            };
//	            //System.out.println(input.get(i).getPropertyType());
//	            model.addRow(rowData);
//	        }
	        
	        table.setModel(model);  // set model of table      
	        JScrollPane scrollPane = new JScrollPane(); // create new JScrollPane
	        scrollPane.setViewportView(table); // set scrollPane so it has control over table
	        scrollPane.setBounds(45, 45, 751, 482); // set bounds
	        add(scrollPane); // add to View
	        
	        JButton backButton = new JButton("Back"); // create new JButton
	        backButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		MainFrame.getLandlordView(MainFrame.getLandlordID()); // go back to LandlordView of currently logged in landlord
	        	}
	        });
	        backButton.setBounds(751, 11, 89, 23); // set bounds
	        add(backButton); // add to view

	 }
}


