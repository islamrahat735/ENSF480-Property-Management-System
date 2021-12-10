package ensf480.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ManagerViewRentersView extends JPanel {
	private JTable table;
	/**
	 * Create the panel.
	 */
	public ManagerViewRentersView() {
		setBounds(300, 200, 850, 600);
        setLayout(null);
        
        table = new JTable();
        Object columnNames[] = {"Landlord ID", "Username", "Password", "First Name", "Last Name"};
        
//        ManagerController managerController = new ManagerController();
//
//        ArrayList<Renter> input = managerController.getAllRenters();

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

//        for(int i=0; i< input.size(); i++) {
//            Object rowData[] = {input.get(i).getId(), input.get(i).getUsername(), 
//                                input.get(i).getPassword(), input.get(i).getFname(), input.get(i).getLname()
//            };
//            model.addRow(rowData);
//        }
        
        table.setModel(model);        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setBounds(44, 36, 751, 482);
        add(scrollPane);

	}

}
