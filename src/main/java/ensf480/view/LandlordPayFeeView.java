package ensf480.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LandlordPayFeeView extends JPanel {

	/**
	 * Create the panel.
	 */
	public LandlordPayFeeView(final int landlordID) {
	setBounds(300, 200, 850, 600); // set bounds
	setLayout(null); // set layout to null, absolute positioning
	
	JLabel lblNewLabel = new JLabel("Current Fee:"); // create new JLabel
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20)); // set font
	lblNewLabel.setBounds(215, 173, 200, 25); // set bounds
	add(lblNewLabel); // add view
	
	JLabel lblNewLabel_1 = new JLabel("Duration:"); // create new JLabel 
	lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20)); // set font 
	lblNewLabel_1.setBounds(215, 249, 200, 25); // set bounds
	add(lblNewLabel_1); //add to view
	
	JButton btnNewButton = new JButton("Pay Fee"); 
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			//Change status to active
		}
	});
	btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
	btnNewButton.setBounds(344, 528, 150, 50);
	add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("Back");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MainFrame.getLandlordView(landlordID);
		}
	});
	btnNewButton_1.setBounds(740, 11, 100, 30);
	add(btnNewButton_1);
	
	JComboBox comboBox = new JComboBox();
	comboBox.setBounds(460, 329, 200, 22);
	add(comboBox);
	
	JLabel lblNewLabel_1_1 = new JLabel("Property:");
	lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_1_1.setBounds(215, 324, 200, 25);
	add(lblNewLabel_1_1);
	
	float currentFee = 0;
	//get currentFee
	JLabel lblFeeHere = new JLabel(String.valueOf(currentFee));
	lblFeeHere.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblFeeHere.setBounds(460, 173, 200, 25);
	add(lblFeeHere);
	
	int currentDuration = 0;
	//get currentDuration
	JLabel lblNewLabel_1_2 = new JLabel(String.valueOf(currentDuration));
	lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblNewLabel_1_2.setBounds(460, 249, 200, 25);
	add(lblNewLabel_1_2);

	}
}
