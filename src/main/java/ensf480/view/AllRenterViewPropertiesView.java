package ensf480.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;

import ensf480.model.*;
import java.util.ArrayList;
import ensf480.controller.SearchCriteriaController;
import ensf480.controller.RenterEmailLandlordController;

public class AllRenterViewPropertiesView extends JPanel {
    private JTable table; // declare private JTable
    private JTextField messageBodyField; // declare private JTextField
    private JTextField fromField;
    private JTextField titleField;
    private JDialog messageSentDialog = new MessageSentDialog(); // instantiate new JDialog

    /**
     * Create the panel.
     */
    // PT = Property Type, NBD = Number of Bedrooms, NBA = Number of Bathrooms, F =
    // Furnished, CQ = City Quadrant
    public AllRenterViewPropertiesView(String PT, int NBD, int NBA, int F, String CQ) {
        setBounds(300, 200, 850, 600); // set bounds of view
        setLayout(null); // set layout as null, absolute positioning

        table = new JTable(); // instantiate table
        Object columnNames[] = { "Property ID", "Type", "Address", "Quadrant", "Bedrooms", "Bathrooms", "Furnished",
                "List Date" }; // instantiate array and populate

        SearchCriteria searchCriteria = new SearchCriteria(-1); // create new object of type SearchCriteria
        if (PT != null) {
            searchCriteria.setType(PropertyType.valueOf(PT.toUpperCase())); // set property type if string PT is not
                                                                            // null
        }
        if (CQ != null) {
            searchCriteria.setQuadrant(Quadrant.valueOf(CQ.toUpperCase())); // set city quadrant if string CQ is not
                                                                            // null
        }
        searchCriteria.setNumBedrooms(NBD); // set number of bedrooms
        searchCriteria.setNumBathrooms(NBA); // set number of bathrooms
        searchCriteria.setIsFurnished(F); // set status of furnishment

        SearchCriteriaController scc = new SearchCriteriaController(); // create new SearchCriteriaController
        ArrayList<Property> input = scc.searchProperties(searchCriteria); // create arraylist of all properties that
                                                                          // match search criteria

        DefaultTableModel model = new DefaultTableModel(columnNames, 0); // create new DefaultTableModel

        for (int i = 0; i < input.size(); i++) {
            Object rowData[] = { input.get(i).getId(),
                    input.get(i).getType(), input.get(i).getAddress().getStreetAddress(),
                    input.get(i).getAddress().getQuadrant(),
                    input.get(i).getNumBedrooms(), input.get(i).getNumBathrooms(), input.get(i).isFurnished(),
                    input.get(i).getDateListed()
            };// populate row with array that gets data from arraylist input
              // System.out.println(input.get(i).getPropertyType());
            model.addRow(rowData); // add created row to model
        }

        table.setModel(model); // set data model
        JScrollPane scrollPane = new JScrollPane(); // create new JScrollPane
        scrollPane.setViewportView(table);// set scrollPane to have table be scrollable
        scrollPane.setBounds(45, 45, 751, 306); // set bounds of scrollPane
        add(scrollPane); // add scrollPane to view

        JButton backButton = new JButton("Back"); // create new JButton
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (MainFrame.getRenterID() == -1) {
                    MainFrame.getLandingView(); // if renter id returns -1, program goes to default landing view
                } else {
                    MainFrame.getRenterView(MainFrame.getRenterID()); // else goes to the registered renters initial view
                }

            }
        }); // action listener for when button is pressed
        backButton.setBounds(740, 11, 89, 23); // set bounds of backButton
        add(backButton); // add to view

        messageBodyField = new JTextField(); // create new JTextField
        messageBodyField.setBounds(279, 430, 418, 145); // set bounds of JTextField
        add(messageBodyField);// add to view
        messageBodyField.setColumns(10); 

        JLabel lblBody = new JLabel("Body"); // create new JLabel
        lblBody.setBounds(472, 405, 89, 14); // set bounds of JLabel
        add(lblBody); // add to view

        JLabel lblPropertyId = new JLabel("Property ID"); // create new JLabel
        lblPropertyId.setBounds(120, 430, 89, 14); // set bounds
        add(lblPropertyId); // add to view

        ArrayList<String> propertyIDs = new ArrayList<>(); // create new arraylist
        for (Property property : input) { // iterate through input
            propertyIDs.add(String.valueOf(property.getId())); // populate arraylist with property ids from arraylist
                                                               // input
        }

        final JComboBox propertyIDComboBox = new JComboBox(); // create new JComboBox
        propertyIDComboBox.setModel(new DefaultComboBoxModel(propertyIDs.toArray())); // set model
        propertyIDComboBox.setBounds(45, 462, 224, 20); // set bounds
        add(propertyIDComboBox); // add to view

        JSeparator separator = new JSeparator(); // create new JSeperator
        separator.setBounds(10, 367, 830, 2); // set bounds
        add(separator); // add to view

        JLabel messagingSystemLabel = new JLabel("Messaging System");// create new JLabel
        messagingSystemLabel.setBounds(382, 380, 116, 14); // set bounds
        add(messagingSystemLabel); // add to view

        JLabel lblNewLabel = new JLabel("Title"); // create new JLabel
        lblNewLabel.setBounds(138, 495, 49, 14); // set bounds
        add(lblNewLabel); // add to view

        titleField = new JTextField(); // create new JTextField
        titleField.setBounds(45, 521, 224, 20); // set bounds
        add(titleField); // add to view
        titleField.setColumns(10); 

        JLabel fromLabel = new JLabel("From"); // create new JLabel
        fromLabel.setBounds(138, 380, 89, 14); //set bounds
        add(fromLabel); //add to JPanel
        
        fromField = new JTextField(); // create new JTextField
        fromField.setColumns(10);
        fromField.setBounds(45, 402, 224, 20); //set bounds
        add(fromField); //add to JPanel

        JButton sendMessageButton = new JButton("Send"); // create new JButton
        sendMessageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    //the results from the user selection/message
                    int propertyID = Integer.parseInt((String) propertyIDComboBox.getSelectedItem());
                    String from = fromField.getText();
                    String title = titleField.getText();
                    String message = messageBodyField.getText();

                    //creates controller
                    RenterEmailLandlordController relc = new RenterEmailLandlordController();
            
                    int landlordID = relc.getLandlordOf(propertyID); //grabs the landlordID from the property
                    relc.emailRenter(landlordID, from, title, message); //and sends an email to that landlord


                    messageSentDialog.setVisible(true); // set JDialog as visible showing message has been sent
            }
        }); // set action listener for when button is pressed
        sendMessageButton.setBounds(707, 491, 89, 23); // set bounds for sendMessageButton
        add(sendMessageButton); // add to view
    }
}
