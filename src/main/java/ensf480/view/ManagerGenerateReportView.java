package ensf480.view;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ensf480.controller.PeriodicReportController;

import javax.swing.JLabel;
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
		
		JLabel noHousesListedLabel = new JLabel("Total Houses Listed in Period");
		noHousesListedLabel.setBounds(31, 11, 198, 14);
		add(noHousesListedLabel);
		
		JLabel noHousesRentedLabel = new JLabel("Total Houses Rented in Period");
		noHousesRentedLabel.setBounds(31, 36, 198, 14);
		add(noHousesRentedLabel);
		
		JLabel noHousesActiveListingsLabel = new JLabel("Total Active Listings in Period");
		noHousesActiveListingsLabel.setBounds(31, 61, 198, 14);
		add(noHousesActiveListingsLabel);
        
        table = new JTable();
        Object columnNames[] = {"Landlord", "Property ID", "Address"};
        
        PeriodicReportController periodicReController = new PeriodicReportController();
//
//        ArrayList<Landlord> input = managerController.getAllHousesRented();

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

//        for(int i=0; i< input.size(); i++) {
//            Object rowData[] = {input.get(i).getLandlordID(), input.get(i).propertyID(), input.get(i).getAddress()};
//            model.addRow(rowData);
//        }
        
        table.setModel(model);        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setBounds(31, 107, 794, 482);
        add(scrollPane);
        
        String noHousesListed = "";
        //Set noHousesListed to value
        JLabel noHousesListedValue = new JLabel(noHousesListed);
        noHousesListedValue.setBounds(260, 11, 119, 14);
        add(noHousesListedValue);
        
        String noHousesRented = "";
        //Set noHousesRented to value
        JLabel noHousesRentedValue = new JLabel(noHousesRented);
        noHousesRentedValue.setBounds(260, 36, 119, 14);
        add(noHousesRentedValue);
        
        String noHousesActiveListings = "";
        //Set noHousesActiveListings to value
        JLabel noHousesActiveListingsValue = new JLabel(noHousesActiveListings);
        noHousesActiveListingsValue.setBounds(260, 61, 119, 14);
        add(noHousesActiveListingsValue);
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainFrame.getManagerView();
        	}
        });
        backButton.setBounds(736, 11, 89, 23);
        add(backButton);
        
        JLabel periodLabel = new JLabel("Period");
        periodLabel.setBounds(472, 11, 46, 14);
        add(periodLabel);
        
        String periodConcat = fromDate + " to " + toDate;
        JLabel periodValue = new JLabel(periodConcat);
        periodValue.setBounds(544, 11, 165, 14);
        add(periodValue);
		
	}
}
