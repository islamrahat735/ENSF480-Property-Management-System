package ensf480.view;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerViewLandlordsView extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ManagerViewLandlordsView() {
		setBounds(300, 200, 850, 600);
        setLayout(null);
        
        table = new JTable();
        Object columnNames[] = {"Landlord ID", "Username", "Password", "First Name", "Last Name"};
        
//        ManagerController managerController = new ManagerController();
//
//        ArrayList<Landlord> input = managerController.getAllLandlords();

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

//        for(int i=0; i< input.size(); i++) {
//            Object rowData[] = {input.get(i).getId(), input.get(i).getUsername(), 
//                                input.get(i).getPassword(), input.get(i).getFname(), input.get(i).getLname()
//            };
//            model.addRow(rowData);
//        }
        
        table.setModel(model);        
//        table.setBounds(44, 36, 751, 482);    
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        add(table);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setBounds(44, 44, 751, 482);
        add(scrollPane);
        
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		MainFrame.getManagerView();
        	}
        });
        backButton.setBounds(751, 11, 89, 23);
        add(backButton);
//        scrollPane.add(table);

	}

}
