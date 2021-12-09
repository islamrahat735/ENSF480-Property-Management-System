package ensf480.view;


import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerView extends JPanel {

	/**
	 * Create the panel.
	 */
	public ManagerView() {
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
		JButton changeFee = new JButton("Set/Change Fee");
		changeFee.setBounds(319, 36, 199, 52);
		add(changeFee);
		
		JButton viewRentersButton = new JButton("View Renters");
		viewRentersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		viewRentersButton.setBounds(319, 338, 199, 52);
		add(viewRentersButton);
		
		JButton viewLandlordsButton = new JButton("View Landlords");
		viewLandlordsButton.setBounds(319, 234, 199, 52);
		add(viewLandlordsButton);
		
		JButton viewPropertiesButton = new JButton("View Properties");
		viewPropertiesButton.setBounds(319, 133, 199, 52);
		add(viewPropertiesButton);
		
		JButton emailButton = new JButton("Access Email System");
		emailButton.setBounds(319, 524, 199, 50);
		add(emailButton);
		
		JButton generateReportButton = new JButton("Generate Report");
		generateReportButton.setBounds(319, 437, 199, 52);
		add(generateReportButton);
		

	}
}
