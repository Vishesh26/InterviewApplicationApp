import java.awt.EventQueue;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.UIManager.*;

public class LoginWindow {

	static JFrame frame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				//	JFrame.setDefaultLookAndFeelDecorated(true);
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
					frame.setResizable(false);
					frame.getRootPane().setDefaultButton(btnLogin);
					window.frame.setLocation(600,350);
					
					try {
					    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					        if ("Nimbus".equals(info.getName())) {
					            UIManager.setLookAndFeel(info.getClassName());
					            break;
					        }
					    }
					} catch (Exception e) {
					    // If Nimbus is not available, you can set the GUI to another look and feel.
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	private JTextField UsernametextField;
	private JPasswordField passwordField;
	private static JButton btnLogin;
	private JButton btnNewButton;
	private JLabel label;
	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
		
		connection = Connectionclass.Connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 683, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.setTitle("Login Page");
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(273, 60, 106, 39);
		frame.getContentPane().add(lblUsername);
		
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(273, 141, 106, 29);
		frame.getContentPane().add(lblPassword);
		
		UsernametextField = new JTextField();
		UsernametextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UsernametextField.setBackground(Color.WHITE);
		UsernametextField.setForeground(Color.BLACK);
		UsernametextField.setBounds(406, 70, 207, 29);
		frame.getContentPane().add(UsernametextField);
		UsernametextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(406, 146, 207, 29);
		frame.getContentPane().add(passwordField);
		
		btnLogin = new JButton("Login");
		Image img1 = new ImageIcon(this.getClass().getResource("/new.gif")).getImage();
		btnLogin.setIcon(new ImageIcon(img1));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try
				{
					
					String a = "Admin";
					String b = "Attendee";
					String c = UsernametextField.getText();
					
					
					
					String query = "SELECT * FROM UserTable WHERE Username = ? AND Password = ?";
			        PreparedStatement ps = connection.prepareStatement(query);
			        ps.setString(1, UsernametextField.getText());
			        ps.setString(2, passwordField.getText());
			        ps.executeQuery();
			        ResultSet rs = ps.executeQuery();
			        String n = rs.getString("Role");
			        String p = rs.getString("Password");
			        int d =  Integer.parseInt(rs.getString("isTest"));
			        
					int count =0;
					
					while(rs.next())
					{
						count++;
						
					}
					if(count==1 ) {
						if(a.equals(n) )
						{JOptionPane.showMessageDialog(null, "Username and Password is correct");
						frame.dispose();
						AdminWindow ad = new AdminWindow();
						ad.setResizable(false);
						ad.setVisible(true);
						ad.setLocation(500, 300);}
						
						
						else if(b.equals(n)) {
							JOptionPane.showMessageDialog(null, "Username and Password is correct");
							frame.dispose();
							Welcome wl = new Welcome();
							wl.welcome(c,d);
							wl.setVisible(true);
							wl.setResizable(false);
							wl.setLocation(500, 300);
							
						}
					}
					
					
					else{ 
						
						
						if(count>1) 
						
						{
						
						JOptionPane.showMessageDialog(null, "Duplicate Username or Password.Try Again.");
						UsernametextField.setBackground(Color.RED);
						passwordField.setBackground(Color.RED);
					}
					
					
					else if(count==0) {
						
						JOptionPane.showMessageDialog(null, "Username or Password is incorrect.Try Again.");
					UsernametextField.setBackground(Color.RED);
					passwordField.setBackground(Color.RED);
					}
					}	
				
				//	rs.close();
					ps.close();
					
					}	
				
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
					
				}
				finally{
					try
					{
					
						 
					}	
					
					catch(Exception ex)
					{
						
						
						 JOptionPane.showMessageDialog(null, ex);
						
					}
				
				}
				}
		});
		btnLogin.setBounds(147, 259, 149, 50);
		frame.getContentPane().add(btnLogin);
		
		btnNewButton = new JButton("Cancel");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
			}
		});
		btnNewButton.setBounds(395, 259, 149, 50);
		frame.getContentPane().add(btnNewButton);
		
		label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login5.gif")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(12, 13, 284, 244);
		frame.getContentPane().add(label);
	}
}
