package ensf480.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ensf480.controller.LandlordController;
import java.util.ArrayList;
import ensf480.model.*;

public class LandlordEmailNotifView extends JPanel {
	private JTable table;
	/**
	 * Create the panel.
	 */
	public LandlordEmailNotifView() {
		 	setBounds(300, 200, 850, 600); // set bounds
	        setLayout(null); // set layout to null, absolute positioning
	        
	        table = new JTable(); // create new JTable
	        Object columnNames[] = {"From", "Title", "Body"}; // initalize new array of objects
	        
	        LandlordController lc = new LandlordController();

	        ArrayList<Email> input = lc.getInbox(MainFrame.getLandlordID());

	        DefaultTableModel model = new DefaultTableModel(columnNames, 0); // create new DefaultTableModel

	        for (int i = 0; i < input.size(); i++) {
            Object rowData[] = { input.get(i).getFrom(), input.get(i).getTitle(), input.get(i).getMessage()
            };
            // System.out.println(input.get(i).getPropertyType());
            model.addRow(rowData);
        }
	        
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


