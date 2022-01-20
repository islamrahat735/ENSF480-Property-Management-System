package ensf480.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LandlordView extends JPanel {

	/**
	 * Create the panel.
	 */
	public LandlordView() {
		setBounds(300, 200, 850, 600); // set bounds
		setLayout(null); // set layout 
		
		JButton registerPropertyButton = new JButton("Register Property"); // new JButton
		registerPropertyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandlordRegisterPropertyView(); // View is switched to LandlordRegisterPropertyView
			}
		}); // action listener for when button is pressed 
		registerPropertyButton.setBounds(337, 56, 148, 45); // set bounds
		add(registerPropertyButton); // add to view
		
		JButton viewProperties = new JButton("View Properties"); // new JButton 
		viewProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandlordViewPropertiesView(); // view is switched to LandlordViewPropertiesView
			}
		}); // action listener for when button is pressed 
		viewProperties.setBounds(337, 183, 148, 45); // set bounds
		add(viewProperties); // add to view 
		
		JButton changeStateButton = new JButton("Change State");// new JButton 
		changeStateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandlordChangeStateView(); // view is switched to LandlordChangeStateView 
			}
		}); // action listener for when button is pressed 
		changeStateButton.setBounds(337, 383, 148, 45); // set bounds
		add(changeStateButton); // add to view
		
		JButton inboxButton = new JButton("Inbox");// new JButton 
		inboxButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandlordEmailNotif(); // view is switched to getLandlordEmailNotif
			}
		}); // action listener for when button is pressed 
		inboxButton.setBounds(337, 476, 148, 45); // set bounds
		add(inboxButton); // add to view

		JButton logoutButton = new JButton("Logout");// new JButton 
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandingView(); // view is changed to getLandingView
				MainFrame.setLandlordID(-1); // set landlord id to -1		
				}
		});
		logoutButton.setBounds(751, 11, 89, 23);  // set bounds
		add(logoutButton); // add to view
		
		JButton payFeeButton = new JButton("Pay Fee");// new JButton 
		payFeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandlordPayFeeView(); // view is changed to getLandlordPayFeeView
			}
		}); // action listener for when button is pressed 
		payFeeButton.setBounds(337, 289, 148, 45); // set bounds
		add(payFeeButton); // add to view

	}
}
