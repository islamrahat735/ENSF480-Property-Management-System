package ensf480.view;

import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ensf480.controller.ManagerController;
import ensf480.model.Property;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ManagerViewPropertiesView extends JPanel {
    private JTable table;

    /**
     * Create the panel.
     */
    public ManagerViewPropertiesView() {
        setBounds(300, 200, 850, 600);
        setLayout(null);

        // JTable used in order to store and view
        table = new JTable();//Create JTable object
        Object columnNames[] = { "Property ID", "Status", "Type", "Address", "Quadrant", "Bedrooms", "Bathrooms",
                "Furnished", "Owner ID", "List Date", "Rent Date" };

        ManagerController managerController = new ManagerController(); //Create ManagerController object

        ArrayList<Property> input = managerController.getAllProperties(); //Create ArrayList with all data required for Table

        DefaultTableModel model = new DefaultTableModel(columnNames, 0); //Set Column Names

        //Populate Table Model
        for (int i = 0; i < input.size(); i++) {
            Object rowData[] = { input.get(i).getId(), input.get(i).getStatus(),
                    input.get(i).getType(), input.get(i).getAddress().getStreetAddress(),
                    input.get(i).getAddress().getQuadrant(),
                    input.get(i).getNumBedrooms(), input.get(i).getNumBathrooms(), input.get(i).isFurnished(),
                    input.get(i).getOwnerId(), input.get(i).getDateListed(), input.get(i).getDateRented()
            };
            model.addRow(rowData);
        }

        //Set Table Model to table
        table.setModel(model);

        //Create Scroll Pane and add table to it
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setBounds(45, 45, 751, 482);
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
