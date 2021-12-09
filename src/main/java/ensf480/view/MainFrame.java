package ensf480.view;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	public static JPanel contentPane;
	static MainFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainFrame();
					frame.setVisible(true);
					frame.setTitle("Property Rental Management System");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		LandingView landingView = new LandingView();
		contentPane.add(landingView);

		
	}
	
	public static void getRenterLoginView() {
		RenterLoginView renterLoginView = new RenterLoginView();
		
		contentPane.removeAll();
		contentPane.add(renterLoginView);
		contentPane.revalidate();
		contentPane.repaint();
		frame.setTitle("Renter Login");
	}
	
	public static void getManagerLoginView() {
		ManagerLoginView managerLoginView = new ManagerLoginView();
		
		contentPane.removeAll();
		contentPane.add(managerLoginView);
		contentPane.revalidate();
		contentPane.repaint();
		frame.setTitle("Manager Login");
	}
	
	public static void getLandlordLoginView() {
		LandlordLoginView LandlordLoginView = new LandlordLoginView();
		
		contentPane.removeAll();
		contentPane.add(LandlordLoginView);
		contentPane.revalidate();
		contentPane.repaint();
		frame.setTitle("Landlord Login");
	}
	
	
	
	public static void getRegisterView() {
		RegisterView registerView = new RegisterView();
		
		contentPane.removeAll();
		contentPane.add(registerView);
		contentPane.revalidate();
		contentPane.repaint();
		frame.setTitle("Renter Registration");
	}
	
	public static void getURenterView() {
		URenterView uRenterView = new URenterView();
		
		contentPane.removeAll();
		contentPane.add(uRenterView);
		contentPane.revalidate();
		contentPane.repaint();
		frame.setTitle("Search For Properties");
	}

}
