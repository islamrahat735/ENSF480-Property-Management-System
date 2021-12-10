package ensf480.view;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerSetFeeView extends JPanel {
	private JTextField newFeeText;
	private JTextField newDurationText;
	JDialog invalidFeeDialog = new InvalidFeeDialog();


	/**
	 * Create the panel.
	 */
	public ManagerSetFeeView() {
		setBounds(300, 200, 850, 600);
		setLayout(null);
		float currentFee = 0;
		int currentDuration = 0;
		//currentFee = getFee();
		//currentDuration = getDuration();
		
		JLabel currentFeeLabel = new JLabel("Current Fee");
		currentFeeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		currentFeeLabel.setBounds(176, 164, 218, 25);
		add(currentFeeLabel);
		
		JLabel currentFeeValue = new JLabel(String.valueOf(currentFee));
		currentFeeValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		currentFeeValue.setBounds(498, 164, 179, 25);
		add(currentFeeValue);
		
		JLabel newFeeLabel = new JLabel("New Fee");
		newFeeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newFeeLabel.setBounds(176, 254, 218, 25);
		add(newFeeLabel);
		
		newFeeText = new JTextField();
		newFeeText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newFeeText.setBounds(498, 255, 142, 22);
		add(newFeeText);
		newFeeText.setColumns(10);
		
		JButton setFeeButton = new JButton("Set Fee");
		setFeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String potentialNewFee = newFeeText.getText();
				boolean flag;
				
				try
			     {
			         Float.parseFloat(potentialNewFee);
			         if (Float.parseFloat(potentialNewFee) < 0) {
			        	 flag = false;
			         } else {
			        	 flag = true;
			         }
			     }
			     catch(NumberFormatException nfe)
			     {
			         flag = false;
			     }
				
				if (flag == false) {
					invalidFeeDialog.setVisible(true);
				} else {
					float newFee = Float.parseFloat(potentialNewFee);
					//Update newFee
					revalidate();
					repaint();
				}
			}
		});
		setFeeButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setFeeButton.setBounds(203, 495, 153, 38);
		add(setFeeButton);
		
		JLabel currentDurationLabel = new JLabel("Current Duration (Days)");
		currentDurationLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		currentDurationLabel.setBounds(176, 325, 218, 25);
		add(currentDurationLabel);
		
		JLabel newDurationLabel = new JLabel("New Duration (Days)");
		newDurationLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newDurationLabel.setBounds(176, 415, 218, 25);
		add(newDurationLabel);
		
		JLabel currentDurationValue = new JLabel(String.valueOf(currentDuration));
		currentDurationValue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		currentDurationValue.setBounds(498, 327, 179, 25);
		add(currentDurationValue);
		
		newDurationText = new JTextField();
		newDurationText.setFont(new Font("Tahoma", Font.PLAIN, 20));
		newDurationText.setColumns(10);
		newDurationText.setBounds(498, 418, 142, 22);
		add(newDurationText);
		
		JButton setDurationButton = new JButton("Set Duration");
		setDurationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String potentialNewDuration = newDurationText.getText();
				boolean flag;
				
				try
			     {
			         Integer.parseInt(potentialNewDuration);
			         if (Integer.parseInt(potentialNewDuration) < 1) {
			        	 flag = false;
			         } else {
			        	 flag = true;
			         }
			     }
			     catch(NumberFormatException nfe)
			     {
			         flag = false;
			     }
				
				if (flag == false) {
					invalidFeeDialog.setVisible(true);
				} else {
					int newDuration = Integer.parseInt(potentialNewDuration);
					//Update newDuration
					revalidate();
					repaint();
				}
			}
		});
		setDurationButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		setDurationButton.setBounds(459, 495, 153, 38);
		add(setDurationButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.getManagerView();
			}
		});
		backButton.setBounds(687, 11, 153, 38);
		add(backButton);
	}
}
