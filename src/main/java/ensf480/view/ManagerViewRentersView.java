package ensf480.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import ensf480.controller.RegRenterController;
import ensf480.model.*;
import java.util.ArrayList;

public class ManagerViewRentersView extends JPanel {
    private JTable table;

    /**
     * Create the panel.
     */
    public ManagerViewRentersView() {
        setBounds(300, 200, 850, 600);
        setLayout(null);

        // JTable used to hold Renters information
        table = new JTable();
        Object columnNames[] = { "Renter ID", "Email", "Password", "First Name", "Last Name" };

        RegRenterController regRenController = new RegRenterController();
        //
        ArrayList<RegisteredRenter> input = regRenController.getAllRenters();

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (int i = 0; i < input.size(); i++) {
            Object rowData[] = { input.get(i).getId(), input.get(i).getUsername(),
                    input.get(i).getPassword(), input.get(i).getFname(), input.get(i).getLname()
            };
            model.addRow(rowData);
        }

        table.setModel(model);

        // JScrollPane used inorder to scroll in order to view information in table
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setBounds(44, 36, 751, 482);
        add(scrollPane);

        // JButton used inorder to go back and change view to ManagerView
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
