package ensf480.view;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ensf480.controller.PeriodicReportController;
import ensf480.model.PeriodicReport;
import ensf480.model.Property;

import javax.swing.JLabel;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerGenerateReportView extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ManagerGenerateReportView(String fromDate, String toDate) {
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
        //Number of Houses Listed JLabel
		JLabel noHousesListedLabel = new JLabel("Total Houses Listed");
		noHousesListedLabel.setBounds(31, 11, 198, 14);
		add(noHousesListedLabel);
		
        //Number of Houses Rented JLabel
		JLabel noHousesRentedLabel = new JLabel("Total Houses Rented");
		noHousesRentedLabel.setBounds(31, 36, 198, 14);
		add(noHousesRentedLabel);
		
        //Number of Active Listings JLabel
		JLabel noHousesActiveListingsLabel = new JLabel("Total Active Listings");
		noHousesActiveListingsLabel.setBounds(31, 61, 198, 14);
		add(noHousesActiveListingsLabel);
        
        // Construct new JTable;
        table = new JTable();
        Object columnNames[] = {"Landlord", "Property ID", "Address"}; //List of table columns
        
        PeriodicReportController periodicReportController = new PeriodicReportController(); //Create Periodic Report Controller object

        PeriodicReport report = periodicReportController.createPeriodicReport(fromDate, toDate); //Generate Periodic Report

        ArrayList<Property> input = report.getRentedHouses();

        DefaultTableModel model = new DefaultTableModel(columnNames, 0); //Set table columns

        //Populate Table data
       for(int i=0; i< input.size(); i++) {
           Object rowData[] = {input.get(i).getOwnerId(), input.get(i).getId(), input.get(i).getAddress().getStreetAddress()};
           model.addRow(rowData);
       }
        
        //Add table to Scroll Pane
        table.setModel(model);        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setBounds(31, 107, 794, 482);
        add(scrollPane);
        
        //Get Number of Houses Listed in Period
        String noHousesListed = String.valueOf(report.getNumHousesListed());
        //Set noHousesListed to value
        JLabel noHousesListedValue = new JLabel(noHousesListed);
        noHousesListedValue.setBounds(260, 11, 119, 14);
        add(noHousesListedValue);
        
        //Get Number of Houses Rented in Period
        String noHousesRented = String.valueOf(report.getNumHousesRented());
        //Set noHousesRented to value
        JLabel noHousesRentedValue = new JLabel(noHousesRented);
        noHousesRentedValue.setBounds(260, 36, 119, 14);
        add(noHousesRentedValue);
        
        //Get Number of Active Listings 
        String noHousesActiveListings = String.valueOf(report.getNumActiveListings());
        //Set noHousesActiveListings to value
        JLabel noHousesActiveListingsValue = new JLabel(noHousesActiveListings);
        noHousesActiveListingsValue.setBounds(260, 61, 119, 14);
        add(noHousesActiveListingsValue);
        
        //Back Button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainFrame.getManagerView();
        	}
        });
        backButton.setBounds(736, 11, 89, 23);
        add(backButton);

        //Period JLabel
        JLabel periodLabel = new JLabel("Period");
        periodLabel.setBounds(472, 11, 46, 14);
        add(periodLabel);
        
        // Show the period
        String periodConcat = fromDate + " to " + toDate;
        JLabel periodValue = new JLabel(periodConcat);
        periodValue.setBounds(544, 11, 165, 14);
        add(periodValue);
		
	}
}
