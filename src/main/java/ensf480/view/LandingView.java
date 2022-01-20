package ensf480.view;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LandingView extends JPanel {

	public JButton registerViewButton;
	public JButton uRenterViewButton;
	private JButton managerLoginViewButton;
	private JButton landlordLoginViewButton;
	//private InvalidAddressDialog abc = new InvalidAddressDialog();
	/**
	 * Create the panel.
	 */
	public LandingView() {
		setBounds(300, 200, 850, 600); // set bounds
		setLayout(null); // set layout as null, absolute positioning
		
		//abc.setVisible(true);
		registerViewButton = new JButton("Renter Registration"); // create new JButton
		registerViewButton.setBounds(331, 103, 159, 21); // set bounds
		add(registerViewButton); // add to view
		
		registerViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getRenterRegisterView(); // view is changed to RenterRegisterView
			}
		}); // action listener in event that button is pressed
		
		
		JButton renterLoginViewButton = new JButton("Renter Login"); // create mew JButton
		renterLoginViewButton.setBounds(331, 185, 159, 21); // set bounds
		add(renterLoginViewButton); // add to view
		
		renterLoginViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getRenterLoginView(); // view is changed to RenterLoginView
			}
		}); // action listener in event that button is pressed
		
		managerLoginViewButton = new JButton("Manager Login"); // create new JButton
		managerLoginViewButton.setBounds(331, 271, 159, 21); // set bounds
		managerLoginViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getManagerLoginView(); // view is changed to ManagerLoginView
			}
		});// action listener in event that button is pressed
		add(managerLoginViewButton); // add to view
		
		landlordLoginViewButton = new JButton("Landlord Login"); // create new JButton
		landlordLoginViewButton.setBounds(331, 377, 159, 21); // set bounds
		landlordLoginViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandlordLoginView(); // view is changed to LandlordLoginView
			}
		});// action listener in event that button is pressed
		add(landlordLoginViewButton); // add to view
		
		uRenterViewButton = new JButton("Search as Unregistered Renter"); // create new JButton
		uRenterViewButton.setBounds(272, 473, 288, 21); // set bounds
		uRenterViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getURenterView(); // view is changed to URenterView
			}
		});// action listener in event that button is pressed
		add(uRenterViewButton); // add to view
	}

}
