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
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
		//abc.setVisible(true);
		registerViewButton = new JButton("Renter Registration");
		registerViewButton.setBounds(331, 103, 159, 21);
		add(registerViewButton);
		
		registerViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getRenterRegisterView();
			}
		});
		
		
		JButton renterLoginViewButton = new JButton("Renter Login");
		renterLoginViewButton.setBounds(331, 185, 159, 21);
		add(renterLoginViewButton);
		
		renterLoginViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getRenterLoginView();
			}
		});
		
		managerLoginViewButton = new JButton("Manager Login");
		managerLoginViewButton.setBounds(331, 271, 159, 21);
		managerLoginViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getManagerLoginView();
			}
		});
		add(managerLoginViewButton);
		
		landlordLoginViewButton = new JButton("Landlord Login");
		landlordLoginViewButton.setBounds(331, 377, 159, 21);
		landlordLoginViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getLandlordLoginView();
			}
		});
		add(landlordLoginViewButton);
		
		uRenterViewButton = new JButton("Continue");
		uRenterViewButton.setBounds(331, 473, 159, 21);
		uRenterViewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getURenterView();
			}
		});
		add(uRenterViewButton);
	}

}
