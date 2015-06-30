import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Welcome extends JFrame {

	private JPanel contentPane;
	static JLabel lblWelcomeUser ;
	static JLabel lblNewLabel;
	static JButton btnNewButton;
	static Welcome frame ;
	static String name;

	/**
	 * Launch the application.
	 */
	public static void WelcomeTest(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Welcome();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public static void welcome( String c, int d)
	{    name = c;
		lblWelcomeUser.setText("Welcome " + c);
		// JOptionPane.showMessageDialog(null,d); 
		if(d!= 0) {
			lblNewLabel.setText("Please proceed to your test.Good Luck!!");
			
		
		}
		else { lblNewLabel.setText("You don't have any test scheduled.");
		btnNewButton.setEnabled(false);
		}
		
		
	}
		
		 
		 
			
		
		
		
		
	
	
	public Welcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 lblWelcomeUser = new JLabel("Welcome User !!");
		lblWelcomeUser.setForeground(new Color(0, 0, 128));
		lblWelcomeUser.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblWelcomeUser.setBounds(201, 45, 294, 34);
		contentPane.add(lblWelcomeUser);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(140, 115, 419, 41);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Proceed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				     dispose();
				     LoginWindow.frame.setVisible(false);
					TestWindow.window.frame.setVisible(true);
					TestWindow.window.frame.setResizable(false);
					TestWindow.window.frame.setLocation(600, 300);
					
					
				}	
				
				catch(Exception ex)
				{
					
					
					 JOptionPane.showMessageDialog(null, ex);
					 
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(121, 231, 138, 49);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try
				{
					dispose();
					LoginWindow lw = new LoginWindow();
					lw.frame.setVisible(true);
					lw.frame.setLocation(500, 300);
					
					
					
				}	
				
				catch(Exception ex)
				{
					
					
					 JOptionPane.showMessageDialog(null, ex);
					 
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(377, 231, 133, 49);
		contentPane.add(btnNewButton_1);
	}

}
