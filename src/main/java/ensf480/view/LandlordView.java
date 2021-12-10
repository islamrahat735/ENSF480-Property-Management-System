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
	public LandlordView(int landlordID) {
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
		JButton registerPropertyButton = new JButton("Register Property");
		registerPropertyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandlordRegisterPropertyView();
			}
		});
		registerPropertyButton.setBounds(337, 56, 148, 45);
		add(registerPropertyButton);
		
		JButton viewProperties = new JButton("View Properties");
		viewProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandlordViewPropertiesView();
			}
		});
		viewProperties.setBounds(337, 183, 148, 45);
		add(viewProperties);
		
		JButton changeStateButton = new JButton("Change State");
		changeStateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandlordChangeStateView();
			}
		});
		changeStateButton.setBounds(337, 312, 148, 45);
		add(changeStateButton);
		
		JButton inboxButton = new JButton("Inbox");
		inboxButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandlordEmailNotif();
			}
		});
		inboxButton.setBounds(337, 438, 148, 45);
		add(inboxButton);

		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandingView();
				MainFrame.setLandlordID(-1);			}
		});
		logoutButton.setBounds(751, 11, 89, 23);
		add(logoutButton);

	}
}
