package ensf480.view;
import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;

public class MainFrame extends JFrame {

	public static JPanel contentPane;
	static MainFrame frame;
	private JScrollPane scrollPane;
	private static int landlordID;
	private static int renterID;
	
	

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
	
	
	
	public static void getRenterRegisterView() {
		RenterRegisterView renterRegisterView = new RenterRegisterView();
		
		contentPane.removeAll();
		contentPane.add(renterRegisterView);
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

	public static void getManagerView() {
        ManagerView managerView = new ManagerView();
        
        contentPane.removeAll();
        contentPane.add(managerView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getRenterView(int id) {
		renterID = id;
        RenterView renterView = new RenterView(renterID);
      
        contentPane.removeAll();
        contentPane.add(renterView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getRenterSearchView(int id) {
		RenterSearchView renterSearchView = new RenterSearchView(renterID);
	      
        contentPane.removeAll();
        contentPane.add(renterSearchView);
        contentPane.revalidate();
        contentPane.repaint();
	}
	
	public static void getLandlordView(int id) {
		landlordID = id;
        LandlordView landlordView = new LandlordView(landlordID);
        
        contentPane.removeAll();
        contentPane.add(landlordView);
        contentPane.revalidate();
        contentPane.repaint();
    }

	public static void getManagerViewPropertiesView() {
        ManagerViewPropertiesView managerViewPropertiesView = new ManagerViewPropertiesView();
        
        contentPane.removeAll();
        contentPane.add(managerViewPropertiesView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getLandlordViewPropertiesView() {
        LandlordViewPropertiesView landlordViewPropertiesView = new LandlordViewPropertiesView(landlordID);
        
        contentPane.removeAll();
        contentPane.add(landlordViewPropertiesView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getLandlordChangeStateView(){
        LandlordChangeStateView landlordChangeStateView = new LandlordChangeStateView(landlordID);
        
        contentPane.removeAll();
        contentPane.add(landlordChangeStateView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getManagerGenerateReportView(String fromDate, String toDate){
		ManagerGenerateReportView landlordGenerateReportView = new ManagerGenerateReportView(fromDate, toDate);
        
        contentPane.removeAll();
        contentPane.add(landlordGenerateReportView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getLandlordRegisterPropertyView(){
		LandlordRegisterPropertyView landlordRegisterPropertyView = new LandlordRegisterPropertyView(landlordID);
        
        contentPane.removeAll();
        contentPane.add(landlordRegisterPropertyView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getLandingView(){
		LandingView landingView = new LandingView();
        
        contentPane.removeAll();
        contentPane.add(landingView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getManagerSetFeeView(){
		ManagerSetFeeView managerSetFeeView = new ManagerSetFeeView();
		
		contentPane.removeAll();
        contentPane.add(managerSetFeeView);
        contentPane.revalidate();
        contentPane.repaint();
	}
	
	public static void getManagerViewLandlordsView(){
		ManagerViewLandlordsView managerViewLandlordsView = new ManagerViewLandlordsView();
		
		contentPane.removeAll();
        contentPane.add(managerViewLandlordsView);
        contentPane.revalidate();
        contentPane.repaint();
	}
	
	public static void getManagerViewRentersView(){
		ManagerViewRentersView managerViewRentersView = new ManagerViewRentersView();
		
		contentPane.removeAll();
        contentPane.add(managerViewRentersView);
        contentPane.revalidate();
        contentPane.repaint();
	}
	
	
	public static void getManagerChangeStateView(){
		ManagerChangeStateView managerChangeStateView = new ManagerChangeStateView();
		
		contentPane.removeAll();
        contentPane.add(managerChangeStateView);
        contentPane.revalidate();
        contentPane.repaint();
	}
	
	public static void getAllRenterViewPropertiesView(String PT, int NBD, int NBA, int F, String CQ){
		AllRenterViewPropertiesView allRenterViewPropertiesView = new AllRenterViewPropertiesView(PT, NBD, NBA, F, CQ);
		contentPane.removeAll();
        contentPane.add(allRenterViewPropertiesView);
        contentPane.revalidate();
        contentPane.repaint();
	}
	
	public static void getLandLordEmailNotif(){
		LandlordEmailNotif landlordEmailNotif =new LandlordEmailNotif(landlordID);
		contentPane.removeAll();
        contentPane.add(landlordEmailNotif);
        contentPane.revalidate();
        contentPane.repaint();
	}

	// public static void getRenterSubscribeView(){
	// 	RenterSubscribeView 
	// }
	
	public static int getLandlordID() {
		return landlordID;
	}

}
