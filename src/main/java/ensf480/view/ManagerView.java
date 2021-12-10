package ensf480.view;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JDialog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManagerView extends JPanel {
	private JTextField fromText;
	private JTextField toText;
	JDialog invalidInputDialog = new InvalidInputDialog();

	/**
	 * Create the panel.
	 */
	public ManagerView() {
		setBounds(300, 200, 850, 600);
		setLayout(null);
		
		JButton changeFee = new JButton("Set/Change Fee");
		changeFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getManagerSetFeeView();
			}
		});
		changeFee.setBounds(51, 32, 199, 52);
		add(changeFee);
		
		JButton viewRentersButton = new JButton("View Renters");
		viewRentersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getManagerViewRentersView();
			}
		});
		viewRentersButton.setBounds(51, 135, 199, 52);
		add(viewRentersButton);
		
		JButton viewLandlordsButton = new JButton("View Landlords");
		viewLandlordsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getManagerViewLandlordsView();
				
			}
		});
		viewLandlordsButton.setBounds(579, 32, 199, 52);
		add(viewLandlordsButton);
		
		JButton viewPropertiesButton = new JButton("View Properties");
		viewPropertiesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.getManagerViewPropertiesView();
			}
		});
		viewPropertiesButton.setBounds(319, 32, 199, 52);
		add(viewPropertiesButton);
		
		JButton generateReportButton = new JButton("Generate Report");
		generateReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fromDate = fromText.getText();
				String toDate = toText.getText();
				//regex that makes sure the date FORMAT is valid
				boolean check1 = fromDate.matches("^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");
				boolean check2 = toDate.matches("^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");
				if(!check1 || !check2){
					invalidInputDialog.setVisible(true);
				}
				else{
				MainFrame.getManagerGenerateReportView(fromDate, toDate);
				}
			}
		});
		generateReportButton.setBounds(319, 420, 199, 52);
		add(generateReportButton);
		
		JButton changeStateButton = new JButton("Change State");
		changeStateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getManagerChangeStateView();
			}
		});
		changeStateButton.setBounds(579, 135, 199, 52);
		add(changeStateButton);
		
		JLabel fromLabel = new JLabel("From (YYYY-MM-DD)");
		fromLabel.setBounds(51, 310, 144, 13);
		add(fromLabel);
		
		fromText = new JTextField();
		fromText.setBounds(222, 306, 144, 19);
		add(fromText);
		fromText.setColumns(10);
		
		JLabel toLabel = new JLabel("To (YYYY-MM-DD)");
		toLabel.setBounds(465, 310, 132, 13);
		add(toLabel);
		
		toText = new JTextField();
		toText.setColumns(10);
		toText.setBounds(607, 306, 199, 19);
		add(toText);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.getLandingView();
			}
		});
		logoutButton.setBounds(712, 510, 89, 23);
		add(logoutButton);
	}
}
