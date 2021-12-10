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
	public LandlordEmailNotif(final int landlordID) {
		 	setBounds(300, 200, 850, 600);
	        setLayout(null);
	        
	        table = new JTable();
	        Object columnNames[] = {"From", "Title", "Body"};
	        
//	        ManagerController managerController = new ManagerController();
	//
//	        ArrayList<Property> input = managerController.getAllProperties();

	        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

//	        for(int i=0; i< input.size(); i++) {
//	            Object rowData[] = {input.get(i).getId(), input.get(i).getStatus(), 
//	                                input.get(i).getType(), input.get(i).getAddress().getStreetAddress(), input.get(i).getAddress().getQuadrant(), 
//	                                input.get(i).getNumBedrooms(), input.get(i).getNumBathrooms(), input.get(i).isFurnished(), input.get(i).getownerId(), input.get(i).getDateListed(), input.get(i).getDateRented()
//	            };
//	            //System.out.println(input.get(i).getPropertyType());
//	            model.addRow(rowData);
//	        }
	        
	        table.setModel(model);        
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setViewportView(table);	
	        scrollPane.setBounds(45, 45, 751, 482);
	        add(scrollPane);
	        
	        JButton backButton = new JButton("Back");
	        backButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		MainFrame.getLandlordView(landlordID);
	        	}
	        });
	        backButton.setBounds(751, 11, 89, 23);
	        add(backButton);

	 }
}


