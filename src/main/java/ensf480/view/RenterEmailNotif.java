package ensf480.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RenterEmailNotif extends JPanel {
private JTable table;
	/**
	 * Create the panel.
	 */
	public RenterEmailNotif() {
	setBounds(300, 200, 850, 600);
        setLayout(null);
        
        // new JTable in order to display email notifications for renters
        table = new JTable();
        Object columnNames[] = {"From", "Title", "Body"};
        
//      RegRenterController managerController = new ManagerController();
//
//        ArrayList<Property> input = managerController.getAllProperties();

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

//        for(int i=0; i< input.size(); i++) {
//            Object rowData[] = {input.get(i).getId(), input.get(i).getStatus(), 
//                                input.get(i).getType(), input.get(i).getAddress().getStreetAddress(), input.get(i).getAddress().getQuadrant(), 
//                                input.get(i).getNumBedrooms(), input.get(i).getNumBathrooms(), input.get(i).isFurnished(), input.get(i).getownerId(), input.get(i).getDateListed(), input.get(i).getDateRented()
//            };
//            //System.out.println(input.get(i).getPropertyType());
//            model.addRow(rowData);
//        }
        
        table.setModel(model);        
        // JScrollPane used inorder to scroll in order to view information in table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);	
        scrollPane.setBounds(45, 45, 751, 482);
        add(scrollPane);
        
        //JButton used inorder to go back and change view to GetRenterView 
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainFrame.getRenterView(MainFrame.getRenterID());
        	}
        });
        backButton.setBounds(751, 11, 89, 23);
        add(backButton);
	}

}
