package ensf480.view;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import ensf480.controller.*;

public class ManagerLoginView extends JPanel {

    private JTextField loginEmailField;
    private JTextField loginPasswordField;
    
    /**
     * Create the panel.
     * @return 
     */
    public ManagerLoginView() {
        setBounds(300, 200, 850, 600);
        setLayout(null);
        
        JLabel loginEmailLabel = new JLabel("Manager Email");
        loginEmailLabel.setBounds(10, 9, 241, 13);
        add(loginEmailLabel);
        
        loginEmailField = new JTextField();
        loginEmailField.setBounds(10, 42, 241, 19);
        loginEmailField.setColumns(10);
        add(loginEmailField);
        
        JLabel loginPasswordLabel = new JLabel("Password");
        loginPasswordLabel.setBounds(10, 109, 241, 13);
        add(loginPasswordLabel);
        
        loginPasswordField = new JPasswordField();
        loginPasswordField.setBounds(10, 132, 241, 19);
        add(loginPasswordField);
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String loginEmail = loginEmailField.getText();
                String loginPassword = loginPasswordField.getText();
                LoginController loginController = new LoginController();
				if(loginController.loginManager(loginEmail, loginPassword))
                	MainFrame.getManagerView();
            }
        });
        loginButton.setBounds(10, 161, 104, 21);
        add(loginButton);
    }

}



