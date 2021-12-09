package ensf480.view;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

import ensf480.controller.*;
import ensf480.model.*;

public class ManagerViewPropertiesView extends JPanel {
    private JTable table;

    /**
     * Create the panel.
     */
    // public ManagerViewPropertiesView() {
    //     setBounds(300, 200, 850, 600);
    //     setLayout(null);

    //     ManagerController managerController = new ManagerController();

    //     ArrayList<Property> input = managerController.getAllProperties();
        
    //     table = new JTable();
    //     Object columnNames[] = { "Property ID", "Status", "Type", "Address", "Quadrant", "Bedrooms", "Bathrooms", "Furnished", "List Date", "Rent Date"};

    //     DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
    //     for(int i=0; i< input.size(); i++) {
    //         Object rowData[] = {input.get(i).getId(), input.get(i).getStatus(), 
    //                             input.get(i).getType(), input.get(i).getAddress().getStreetAddress(), input.get(i).getAddress().getQuadrant(), 
    //                             input.get(i).getNumBedrooms(), input.get(i).getNumBathrooms(), input.get(i).isFurnished(), input.get(i).getDateListed(), input.get(i).getDateRented()
    //         };
    //         //System.out.println(input.get(i).getPropertyType());
    //         model.addRow(rowData);
    //     }
    //     table.setModel(model);
    //     table.setBounds(44, 36, 751, 482);
    //     //add(table);
    //     JScrollPane scrollPane = new JScrollPane(table);
    //     //add(pane, BorderLayout.CENTER);
    //     scrollPane.setViewportView(table);
    //     //add(scrollPane, BorderLayout.CENTER);
    //     MainFrame.contentPane.add(scrollPane);

        
        

    // }

    public ManagerViewPropertiesView() {
        setBounds(300, 200, 850, 600);
        setLayout(null);
        
        table = new JTable();
        Object columnNames[] = {"Property ID", "Status", "Type", "Address", "Quadrant", "Bedrooms", "Bathrooms", "Furnished", "List Date", "Rent Date"};
        //Object columnNames[] = {"Property ID"};
        
        ManagerController managerController = new ManagerController();

        ArrayList<Property> input = managerController.getAllProperties();

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        //Object rowData[] = {"TEST"};
        //model.addRow(rowData);
        //populate model

        for(int i=0; i< input.size(); i++) {
            Object rowData[] = {input.get(i).getId(), input.get(i).getStatus(), 
                                input.get(i).getType(), input.get(i).getAddress().getStreetAddress(), input.get(i).getAddress().getQuadrant(), 
                                input.get(i).getNumBedrooms(), input.get(i).getNumBathrooms(), input.get(i).isFurnished(), input.get(i).getDateListed(), input.get(i).getDateRented()
            };
            //System.out.println(input.get(i).getPropertyType());
            model.addRow(rowData);
        }
        
        table.setModel(model);        
//        table.setBounds(44, 36, 751, 482);    
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        add(table);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        scrollPane.setBounds(44, 36, 751, 482);
        add(scrollPane);
//        scrollPane.add(table);

    }
}