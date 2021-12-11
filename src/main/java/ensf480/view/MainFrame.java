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
	private static int landlordID = -1;
	private static int renterID = -1;
	
	

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // set default close operation 
		setBounds(300, 200, 850, 600); // set bounds 
		contentPane = new JPanel(); // new JPanel 
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // set border 
		contentPane.setLayout(new BorderLayout(0, 0)); // set layout 
		setContentPane(contentPane); // set content pane
		
		LandingView landingView = new LandingView(); // new LandingView 
		contentPane.add(landingView); // add to content pane 

		
	}
	
	public static void getRenterLoginView() {
		// set view to RenterLoginView 
		RenterLoginView renterLoginView = new RenterLoginView();
		
		contentPane.removeAll();
		contentPane.add(renterLoginView);
		contentPane.revalidate();
		contentPane.repaint();
		frame.setTitle("Renter Login");
	}
	
	public static void getManagerLoginView() {
		// set view to ManagerLoginView 
		ManagerLoginView managerLoginView = new ManagerLoginView();
		
		contentPane.removeAll();
		contentPane.add(managerLoginView);
		contentPane.revalidate();
		contentPane.repaint();
		frame.setTitle("Manager Login");
	}
	
	public static void getLandlordLoginView() {
		// set view to LandlordLoginView 
		LandlordLoginView LandlordLoginView = new LandlordLoginView();
		
		contentPane.removeAll();
		contentPane.add(LandlordLoginView);
		contentPane.revalidate();
		contentPane.repaint();
		frame.setTitle("Landlord Login");
	}
	
	
	
	public static void getRenterRegisterView() {
		// set view to RenterRegisterView 
		RenterRegisterView renterRegisterView = new RenterRegisterView();
		
		contentPane.removeAll();
		contentPane.add(renterRegisterView);
		contentPane.revalidate();
		contentPane.repaint();
		frame.setTitle("Renter Registration");
	}
	
	public static void getURenterView() {
		// set view to URenterView 
		URenterView uRenterView = new URenterView();
		
		contentPane.removeAll();
		contentPane.add(uRenterView);
		contentPane.revalidate();
		contentPane.repaint();
		frame.setTitle("Search For Properties");
	}

	public static void getRenterView(int id) {
		// set view to RenterView 
		renterID = id;
        RenterView renterView = new RenterView();
      
        contentPane.removeAll();
        contentPane.add(renterView);
        contentPane.revalidate();
        contentPane.repaint();
    }

		public static void getLandlordView(int id) {
			// set view to LandlordView 
		landlordID = id;
        LandlordView landlordView = new LandlordView();
        
        contentPane.removeAll();
        contentPane.add(landlordView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getManagerView() {
		// set view to ManagerView 
        ManagerView managerView = new ManagerView();
        
        contentPane.removeAll();
        contentPane.add(managerView);
        contentPane.revalidate();
        contentPane.repaint();
    }

	public static void getRenterSearchView(int id) {
		// set view to RenterSearchView 
		RenterSearchView renterSearchView = new RenterSearchView(renterID);
	      
        contentPane.removeAll();
        contentPane.add(renterSearchView);
        contentPane.revalidate();
        contentPane.repaint();
	}
	


	public static void getManagerViewPropertiesView() {
		// set view to ManagerViewPropertiesView 
        ManagerViewPropertiesView managerViewPropertiesView = new ManagerViewPropertiesView();
        
        contentPane.removeAll();
        contentPane.add(managerViewPropertiesView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getLandlordViewPropertiesView() {
		// set view to LandlordViewPropertiesView 
        LandlordViewPropertiesView landlordViewPropertiesView = new LandlordViewPropertiesView(landlordID);
        
        contentPane.removeAll();
        contentPane.add(landlordViewPropertiesView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getLandlordChangeStateView(){
		// set view to LandlordChangeStateView 
        LandlordChangeStateView landlordChangeStateView = new LandlordChangeStateView(landlordID);
        
        contentPane.removeAll();
        contentPane.add(landlordChangeStateView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getManagerGenerateReportView(String fromDate, String toDate){
		// set view to ManagerGenerateReportView 
		ManagerGenerateReportView landlordGenerateReportView = new ManagerGenerateReportView(fromDate, toDate);
        
        contentPane.removeAll();
        contentPane.add(landlordGenerateReportView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getLandlordRegisterPropertyView(){
		// set view to getLandlordRegisterPropertyView 
		LandlordRegisterPropertyView landlordRegisterPropertyView = new LandlordRegisterPropertyView(landlordID);
        
        contentPane.removeAll();
        contentPane.add(landlordRegisterPropertyView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getLandingView(){
		// set view to getLandingView 
		LandingView landingView = new LandingView();
        
        contentPane.removeAll();
        contentPane.add(landingView);
        contentPane.revalidate();
        contentPane.repaint();
    }
	
	public static void getManagerSetFeeView(){
		// set view to ManagerSetFeeView 
		ManagerSetFeeView managerSetFeeView = new ManagerSetFeeView();
		
		contentPane.removeAll();
        contentPane.add(managerSetFeeView);
        contentPane.revalidate();
        contentPane.repaint();
	}
	
	public static void getManagerViewLandlordsView(){
		// set view to ManagerViewLandlordsView 
		ManagerViewLandlordsView managerViewLandlordsView = new ManagerViewLandlordsView();
		
		contentPane.removeAll();
        contentPane.add(managerViewLandlordsView);
        contentPane.revalidate();
        contentPane.repaint();
	}
	
	public static void getManagerViewRentersView(){
		// set view to ManagerViewRentersView 
		ManagerViewRentersView managerViewRentersView = new ManagerViewRentersView();
		
		contentPane.removeAll();
        contentPane.add(managerViewRentersView);
        contentPane.revalidate();
        contentPane.repaint();
	}
	
	
	public static void getManagerChangeStateView(){
		// set view to ManagerChangeStateView 
		ManagerChangeStateView managerChangeStateView = new ManagerChangeStateView();
		
		contentPane.removeAll();
        contentPane.add(managerChangeStateView);
        contentPane.revalidate();
        contentPane.repaint();
	}
	
	public static void getAllRenterViewPropertiesView(String PT, int NBD, int NBA, int F, String CQ){
		// set view to AllRenterViewPropertiesView 
		AllRenterViewPropertiesView allRenterViewPropertiesView = new AllRenterViewPropertiesView(PT, NBD, NBA, F, CQ);
		contentPane.removeAll();
        contentPane.add(allRenterViewPropertiesView);
        contentPane.revalidate();
        contentPane.repaint();
	}
	
	public static void getLandlordEmailNotif(){
		// set view to LandlordEmailNotif
		LandlordEmailNotif landlordEmailNotif =new LandlordEmailNotif();
		contentPane.removeAll();
        contentPane.add(landlordEmailNotif);
        contentPane.revalidate();
        contentPane.repaint();
	}

	public static void getRenterSubscribeView(){
		// set view to RenterSubscribeView
		RenterSubscribeView renterSubscribeView = new RenterSubscribeView();
		contentPane.removeAll();
        contentPane.add(renterSubscribeView);
        contentPane.revalidate();
        contentPane.repaint();
	}

	public static void getRenterEmailNotif(){
		// set view to RenterEmailNotif
		RenterEmailNotif renterEmailNotif = new RenterEmailNotif();
		contentPane.removeAll();
        contentPane.add(renterEmailNotif);
        contentPane.revalidate();
        contentPane.repaint();

	}

	public static void getLandlordPayFeeView(){
		// set view to LandlordPayFeeView
		LandlordPayFeeView landlordPayFeeView = new LandlordPayFeeView();
		contentPane.removeAll();
        contentPane.add(landlordPayFeeView);
        contentPane.revalidate();
        contentPane.repaint();
	}
	
	public static int getLandlordID() {
		// landlord ID getter
		return landlordID; 
	}

	public static int getRenterID() {
		// renter id getter 
		return renterID;
	}

	public static void setRenterID(int Id){
		// renter id setter 
		renterID = Id;
	}

	public static void setLandlordID(int Id){
		// landlord id setter
		landlordID = Id;
	}
}
