
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JComboBox;

import java.awt.SystemColor;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;


public class AdminWindow extends JFrame {
	JComboBox comboBox_3;
	private static JPanel contentPane;
	
	JPanel panel_1;
	JPanel panel_2;
	JPanel panel_3;
	String t;
	static AdminWindow frame = new AdminWindow();
	
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	
	JLabel lblNewLabel_6 = null;

	/**
	 * Launch the application.
	 */
	public static void Admin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					frame.setVisible(true);
					frame.setResizable(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	Connection connectQ = null;
	private JTable table;
	
	public AdminWindow() {
		
		//this.frame.setLocation(200, 200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		connection = Connectionclass.Connect();
		connectQ = ConnectToQuestion.ConnectToQues();
		setTitle("Admin ");
		setBounds(100, 100, 691, 385);
		contentPane = new JPanel();
		contentPane.setToolTipText("Admin ");
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		 final JPanel panel = new JPanel();
		panel.setToolTipText("");
		
		panel.setForeground(new Color(255, 102, 51));
		contentPane.add(panel, "name_189122423308984");
		panel.setLayout(null);
		
		JLabel lblHelloAdmin = new JLabel("Hello Admin!!");
		lblHelloAdmin.setForeground(new Color(255, 0, 51));
		lblHelloAdmin.setFont(new Font("Verdana", Font.BOLD, 25));
		lblHelloAdmin.setBounds(40, 23, 197, 23);
		panel.add(lblHelloAdmin);
		
		JLabel lblNewLabel = new JLabel("Please Select a task to perform.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(182, 114, 353, 39);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Question");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					
					
					panel.setVisible(false);
					panel_1.setVisible(true);
					
				}	
				
				catch(Exception ex)
				{
					
					
					 JOptionPane.showMessageDialog(null, ex);
					 
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(100, 190, 154, 52);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Account");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.setVisible(false);
				panel_2.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(100, 254, 154, 52);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add test");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(414, 189, 151, 52);
		panel.add(btnNewButton_2);
		
		JButton btnLogout = new JButton("Logout");
		Image img1 = new ImageIcon(this.getClass().getResource("/power1.png")).getImage();
		btnLogout.setIcon(new ImageIcon(img1));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				dispose();
				//LoginWindow.frame.setVisible(true);
				new LoginWindow();
				LoginWindow.frame.setVisible(true);
				LoginWindow.frame.setLocation(600, 350);
			}
		});
		btnLogout.setBounds(519, 22, 127, 52);
		panel.add(btnLogout);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/ad.gif")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(248, 13, 71, 52);
		panel.add(label);
		
		final JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, "name_1323328604689271");
		panel_4.setLayout(null);
		
		JButton btnReviewResult = new JButton("Review Result");
		btnReviewResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				 try {
					 panel.setVisible(false);
						panel_4.setVisible(true);
					 
					 String query = "SELECT * FROM Result";
					 PreparedStatement ps = connection.prepareStatement(query);
						ResultSet rs = ps.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnReviewResult.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReviewResult.setBounds(414, 255, 151, 51);
		panel.add(btnReviewResult);
		
		
		 panel_1 = new JPanel();
		contentPane.add(panel_1, "name_189128427781817");
		panel_1.setLayout(null);
		
		JFilePicker filePicker = new JFilePicker("Pick a file", "Browse...");
        filePicker.setMode(JFilePicker.MODE_SAVE);
        filePicker.addFileTypeFilter(".jpg", "JPEG Images");
        filePicker.addFileTypeFilter(".mp4", "MPEG-4 Videos");
         
        // access JFileChooser class directly
        JFileChooser fileChooser = filePicker.getFileChooser();
        fileChooser.setCurrentDirectory(new File("C:/"));
         
        // add the component to the frame
        filePicker.setBounds(55,130, 579, 70);
        panel_1.add(filePicker);
		
		JLabel lblPleaseProvideThe_1 = new JLabel("Please provide the path to the Question file");
		lblPleaseProvideThe_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPleaseProvideThe_1.setBounds(121, 67, 470, 25);
		panel_1.add(lblPleaseProvideThe_1);
		
		JButton btnAddToThe = new JButton("Add to the List");
		btnAddToThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedReader br = null;
				try
				{   String path = JFilePicker.textField.getText();
					String query = "INSERT INTO QA (Subject,Question,OptionA,OptionB ,OptionC,OptionD,Answer,SubID) VALUES (?,?,?,?,?,?,?,?)";
			        PreparedStatement ps = connectQ.prepareStatement(query);
			        String read=null;
			        BufferedReader in = new BufferedReader(new FileReader(path));
			        while ((read = in.readLine()) != null) {
			            String[] splited = read.split("\\|");
			            
			            ps.setString(1, splited[0]);
			            ps.setString(2, splited[1]);
			            ps.setString(3, splited[2]);
			            ps.setString(4, splited[3]);
			            ps.setString(5, splited[4]);
			            ps.setString(6, splited[5]);
			            ps.setString(7, splited[6]);
			            ps.setInt(8, Integer.parseInt(splited[7]));
			            
			            ps.execute();
			        }
			        
			        
			   //    ps.execute();
			        JOptionPane.showMessageDialog(null, "Questions Added");
			        in.close();
					ps.close();
					

				}	
				
				catch(Exception ex)
				{
					
					
					 JOptionPane.showMessageDialog(null, ex);
					 
				}
				
			}
		});
		btnAddToThe.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAddToThe.setBounds(251, 226, 164, 52);
		panel_1.add(btnAddToThe);
		
		JButton btnNewButton_6 = new JButton("Back");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					panel_1.setVisible(false);
					panel.setVisible(true);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		Image img4 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton_6.setIcon(new ImageIcon(img4));
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_6.setBounds(12, 18, 110, 36);
		panel_1.add(btnNewButton_6);
		
		 panel_2 = new JPanel();
		contentPane.add(panel_2, "name_189130971178791");
		panel_2.setLayout(null);
		
		String[] role = {"Admin","Attendee"};
		final JComboBox comboBox_4 = new JComboBox(role);
		comboBox_4.setEditable(true);
		comboBox_4.setBounds(123, 185, 137, 22);
		panel_2.add(comboBox_4);
		
		
		
		
		JLabel lblPleaseProvideThe = new JLabel("Please provide the details of the account to be added");
		lblPleaseProvideThe.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblPleaseProvideThe.setBounds(73, 70, 561, 31);
		panel_2.add(lblPleaseProvideThe);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(34, 128, 79, 31);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(345, 135, 79, 16);
		panel_2.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(125, 133, 176, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(492, 133, 120, 22);
		panel_2.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(343, 180, 135, 31);
		panel_2.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(490, 185, 120, 22);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					String s1 = passwordField.getText();
					String s2 = textField_1.getText();
					String s3 = comboBox_4.getSelectedItem().toString();
					
					
					if( !s1.equals(s2)) 
					{
						JOptionPane.showMessageDialog(null, "Password does not match.Confirm Password");
						
						textField_1.setBackground(Color.RED);
						passwordField.setBackground(Color.RED);
					}
					
					else{	
					String query = "INSERT INTO UserTable (Username,Password,Role) VALUES (?,?,?)";
			        PreparedStatement ps = connection.prepareStatement(query);
			        ps.setString(1, textField.getText());
			        ps.setString(2, passwordField.getText());
			        ps.setString(3, s3);
			        ps.execute();
			  
			        JOptionPane.showMessageDialog(null,"Account Created");
					ps.close();
					panel_2.setVisible(false);
					panel.setVisible(true);
					
					}
						
					comboBox_3.removeAllItems();
			        String q = "SELECT Username FROM UserTable";
					PreparedStatement ps = connection.prepareStatement(q);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) 
					{
						
			            comboBox_3.addItem(rs.getString(1));
			            
			           }	
				
				
				
				
				
				}
					
					
					
				
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex);
					
				}
			
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_3.setBounds(275, 258, 120, 46);
		panel_2.add(btnNewButton_3);
		
		JLabel lblNewLabel_7 = new JLabel("Role");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(34, 183, 56, 16);
		panel_2.add(lblNewLabel_7);
		
		JButton button = new JButton("Back");
		Image img2 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton_6.setIcon(new ImageIcon(img2));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					panel_2.setVisible(false);
					panel.setVisible(true);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBounds(17, 19, 110, 36);
		panel_2.add(button);
		
		
		
		 panel_3 = new JPanel();
		contentPane.add(panel_3, "name_626448314993969");
		panel_3.setLayout(null);
		
		JLabel lblPleaseProvideBelow = new JLabel("Please provide below details to prepare test.");
		lblPleaseProvideBelow.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPleaseProvideBelow.setBounds(133, 21, 461, 25);
		panel_3.add(lblPleaseProvideBelow);
		
		String[] array = {"1","2","3","4","5","6","7","8","9","10"};
		final JComboBox comboBox = new JComboBox(array);
		
		comboBox.setMaximumRowCount(10);
		comboBox.setEditable(true);
		comboBox.setBounds(148, 115, 42, 25);
	
		panel_3.add(comboBox);
		
		JLabel lblChooseNoOf = new JLabel("Choose no. of questions in category");
		lblChooseNoOf.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChooseNoOf.setBounds(70, 80, 363, 16);
		panel_3.add(lblChooseNoOf);
		
		JLabel lblNewLabel_3 = new JLabel("Java");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_3.setBounds(80, 118, 56, 16);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("SQL");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(264, 118, 56, 16);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Python");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(419, 118, 93, 16);
		panel_3.add(lblNewLabel_5);
		
		
		
		final JComboBox comboBox_1 = new JComboBox(array);
		comboBox_1.setMaximumRowCount(10);
		comboBox_1.setEditable(true);
		comboBox_1.setBounds(319, 115, 42, 24);
		
		
		panel_3.add(comboBox_1);
		final int DEFAULT_SIZE = 12;
		
		
		
	
		
		final JComboBox comboBox_2 = new JComboBox(array);
		comboBox_2.setMaximumRowCount(10);
		
          panel_3.add(comboBox_2);
		
		
		
          comboBox.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				
  				int i = Integer.parseInt(comboBox_1.getSelectedItem().toString()) + 
  						Integer.parseInt(comboBox_2.getSelectedItem().toString()) + 
  						Integer.parseInt(comboBox.getSelectedItem().toString());

  						 String s = Integer.toString(i);
  				        lblNewLabel_6.setText(s);
  			}
  		});	


          comboBox_1.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				
    				int i = Integer.parseInt(comboBox_1.getSelectedItem().toString()) + 
    						Integer.parseInt(comboBox_2.getSelectedItem().toString()) + 
    						Integer.parseInt(comboBox.getSelectedItem().toString());

    						 String s = Integer.toString(i);
    				        lblNewLabel_6.setText(s);
    			}
    		});
          
          
					 
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int i = Integer.parseInt(comboBox_1.getSelectedItem().toString()) + 
						Integer.parseInt(comboBox_2.getSelectedItem().toString()) + 
						Integer.parseInt(comboBox.getSelectedItem().toString());

					  final String s = Integer.toString(i);
			
				t=s;
				 
						 
				        lblNewLabel_6.setText(s);
				        
				
				
				
			}
		});
		comboBox_2.setEditable(true);
		comboBox_2.setBounds(510, 115, 42, 25);
		
		
		
		
	    lblNewLabel_6 = new JLabel("");
	    lblNewLabel_6.setBackground(SystemColor.textText);
	    lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(278, 178, 84, 16);
		
		panel_3.add(lblNewLabel_6);
		
		 comboBox_3 = new JComboBox();
		
		comboBox_3.setEditable(true);
		comboBox_3.setBounds(238, 231, 133, 22);
		panel_3.add(comboBox_3);
		
		try {
			comboBox_3.removeAllItems();
			String q = "SELECT Username FROM UserTable";
			PreparedStatement ps = connection.prepareStatement(q);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) 
			{
				
			    comboBox_3.addItem(rs.getString(1));
			    
			   }
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}	
		
		
		
		JLabel lblTotalQuestionsSelected = new JLabel("Total Questions Selected:");
		lblTotalQuestionsSelected.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalQuestionsSelected.setBounds(80, 178, 201, 16);
		panel_3.add(lblTotalQuestionsSelected);
		
		JLabel lblAttendeeName = new JLabel("Attendee Name");
		lblAttendeeName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAttendeeName.setBounds(80, 235, 143, 16);
		panel_3.add(lblAttendeeName);
		
		JButton btnNewButton_4 = new JButton("Save");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
					 String str = comboBox_3.getSelectedItem().toString();
				
					 String query = "insert into SelectQ (Subject,Question,OptionA,OptionB ,OptionC,OptionD,Answer,SubID,Attendee) select Subject,Question,OptionA,OptionB ,OptionC,OptionD,Answer,SubID,? from QA where `SubID` IN (1,2,3) limit ?";
					
					 
					
					 PreparedStatement ps = connectQ.prepareStatement(query);
					 ps.setString(1,str);
					 ps.setString(2,t);
					 ps.execute();
					
					
					 String query1= "update UserTable set isTest=1 where Username =?";
					 PreparedStatement ps1 = connection.prepareStatement(query1);
					 System.out.println(query1);
					 ps1.setString(1,str);
					 ps1.execute();
					 JOptionPane.showMessageDialog(null, "Test Added");
					 
					 
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
					
					 
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_4.setBounds(182, 278, 105, 38);
		panel_3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Cancel");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_5.setBounds(369, 277, 112, 38);
		panel_3.add(btnNewButton_5);
		
		JButton button_1 = new JButton("Back");
		Image img3 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		 button_1.setIcon(new ImageIcon(img3));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					panel_3.setVisible(false);
					panel.setVisible(true);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBounds(11, 17, 110, 36);
		panel_3.add(button_1);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 54, 639, 263);
		panel_4.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 17));
		scrollPane.setViewportView(table);
		
		JButton button_2 = new JButton("Back");
		Image img8 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		button_2.setIcon(new ImageIcon(img8));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					panel_4.setVisible(false);
					panel.setVisible(true);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBounds(12, 0, 110, 36);
		panel_4.add(button_2);
		
		
		
		
		
	}
}
