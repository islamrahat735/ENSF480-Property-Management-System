package ensf480.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RenterView extends JPanel {
	JDialog actionSuccessfulDialog= new ActionSuccessfulDialog();
	/**
	 * Create the panel.
	 */
	public RenterView(final int renterID) {
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
		JButton btnNewButton = new JButton("Search Properties");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getRenterSearchView(renterID);
			}
		});
		btnNewButton.setBounds(120, 188, 200, 50);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Subscribe");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame
			}
		});
		btnNewButton_1.setBounds(507, 188, 200, 50);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Notifications");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(120, 366, 200, 50);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Unsubscribe"); // Need to delete search criteria from DB 
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionSuccessfulDialog.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(507, 366, 200, 50);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(720, 0, 120, 50);
		add(btnNewButton_4);

	}

}
