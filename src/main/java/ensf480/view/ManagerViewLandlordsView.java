package ensf480.view;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ensf480.controller.LandlordController;
import ensf480.controller.ManagerController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import ensf480.model.*;

public class ManagerViewLandlordsView extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ManagerViewLandlordsView() {
        setBounds(300, 200, 850, 600); //Set Bounds of JPanel
        setLayout(null); //Set Layout
        
        //JTable used in order to store and view
        table = new JTable(); //Create JTable object
        Object columnNames[] = {"Landlord ID", "Email", "Password", "First Name", "Last Name"}; //Column Names
        
        ManagerController managerController = new ManagerController(); //Create ManagerController object

        ArrayList<Landlord> input = managerController.getAllLandlords(); //Create ArrayList with all data required for Table
        
        DefaultTableModel model = new DefaultTableModel(columnNames, 0); //Set Column Names

        //Populate Table Model
        for(int i=0; i< input.size(); i++) {
            Object rowData[] = {input.get(i).getId(), input.get(i).getUsername(), 
                                input.get(i).getPassword(), input.get(i).getFname(), input.get(i).getLname()
            };
            model.addRow(rowData);
        }
        
        //Set Table Model to table
        table.setModel(model); 

        //Create Scroll Pane and add table to it
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setBounds(44, 44, 751, 482);
        add(scrollPane);
        
        //Back Button used to go back to Manager View
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainFrame.getManagerView();
        	}
        });
        backButton.setBounds(751, 11, 89, 23);
        add(backButton);
	}
}
