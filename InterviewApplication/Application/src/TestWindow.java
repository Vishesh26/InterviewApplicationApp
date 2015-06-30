import java.awt.EventQueue;








import java.awt.Image;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.Timer;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingConstants;
import java.awt.SystemColor;




public class TestWindow {
	private Timer timer;
	private long startTime = -1;
	private long duration = 3000000;
	static ResultSet rs;
	static JButton btnNewButton;
	static ButtonGroup group ;
	JLabel lblDd;
	Connection connection = null;
	String answer = "";
	int sn = 1;
	int count = 0;
	static {

		try {

			PreparedStatement ps; 
			Connection connectQ = null;

			connectQ = ConnectToQuestion.ConnectToQues();
			String query = "SELECT * FROM SelectQ where Attendee = ?";
			ps = connectQ.prepareStatement(query);
			ps.setString(1, Welcome.name);
			rs = ps.executeQuery();


		} catch (SQLException ex) {

			JOptionPane.showMessageDialog(null, ex);
		}

	}

	static JFrame frame;
	static TestWindow window = new TestWindow();
	/**
	 * Launch the application.
	 */



	public static void Test(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					window.frame.setVisible(true);


				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	JLabel Question;
	JRadioButton optiona;
	JRadioButton optionb;
	JRadioButton optionc;
	JRadioButton optiond;
	private JLabel lblNewLabel;
	private JLabel lblWeWillGet;
	private JLabel lblFdvb;
	private JLabel lblA;
	private JLabel lblB;
	private JLabel lblC;
	private JLabel lblD;

	public void initialize() {










		frame = new JFrame();
		frame.setBounds(100, 100, 843, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		final JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(panel, "name_797306775897636");
		panel.setLayout(null);

		JLabel lblTestInstructions = new JLabel("Test Instructions");
		lblTestInstructions.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTestInstructions.setBounds(288, 13, 214, 16);
		panel.add(lblTestInstructions);




		JTextArea txtrYthy = new JTextArea();
		txtrYthy.setWrapStyleWord(true);
		txtrYthy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtrYthy.setText("1.This is a Multiple Choice Examination\n\n"+ 
				"2.Exam comprises of questions from Different Category.\n\n"+ 
				"3.Every Correct answer has 5 marks and for every incorrect answer \n\n"+ "there is negative marking of -5 \n\n"+ 
				"4.Exam has Timer & Candidate must complete exam within the time frame\n\n"+ 
				"5.Next button will take you to next question and Reset button clears\n\n"+ 
				"the selection\n\n"+ 
				"6.Mobile phones or any reference materials,in whatever format,aren't allowed\n"+ 
				"in examination premises\n\n");
		txtrYthy.setBounds(25, 53, 765, 364);
		panel.add(txtrYthy);

		final JButton btnStartTest = new JButton("Start Test");
		btnStartTest.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStartTest.setBounds(323, 430, 133, 43);
		panel.add(btnStartTest);

		final JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 240));
		panel_1.setBorder(new LineBorder(new Color(255, 160, 122), 7, true));
		panel_1.setForeground(new Color(255, 0, 0));
		frame.getContentPane().add(panel_1, "name_797309136604820");
		panel_1.setLayout(null);

		final JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(Color.ORANGE, 10, true));
		frame.getContentPane().add(panel_2, "name_731197191780280");
		panel_2.setLayout(null);

		lblNewLabel = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/thankuu.gif")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img3));
		lblNewLabel.setBounds(133, 26, 547, 369);
		panel_2.add(lblNewLabel);

		lblWeWillGet = new JLabel("We will get back to you!!!");
		lblWeWillGet.setForeground(new Color(220, 20, 60));
		lblWeWillGet.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblWeWillGet.setBounds(133, 391, 692, 54);
		panel_2.add(lblWeWillGet);

		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, "name_797313322378876");


		lblDd = new JLabel("sn");
		lblDd.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblDd.setBounds(64, 93, 33, 36);
		panel_1.add(lblDd);

		Question = new JLabel("question");
		Question.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Question.setBounds(106, 83, 707, 59);
		panel_1.add(Question);

		optiona = new JRadioButton("dwew");
		optiona.setBackground(new Color(255, 255, 240));
		optiona.setFont(new Font("Tahoma", Font.PLAIN, 17));
		optiona.setBounds(89, 188, 285, 44);
		panel_1.add(optiona);

		optionc = new JRadioButton("New radio button");
		optionc.setBackground(new Color(255, 255, 240));
		optionc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		optionc.setBounds(89, 244, 285, 44);
		panel_1.add(optionc);

		optionb = new JRadioButton("New radio button");
		optionb.setBackground(new Color(255, 255, 240));
		optionb.setFont(new Font("Tahoma", Font.PLAIN, 17));
		optionb.setBounds(451, 188, 293, 44);
		panel_1.add(optionb);

		optiond = new JRadioButton("New radio button");
		optiond.setBackground(new Color(255, 255, 240));
		optiond.setFont(new Font("Tahoma", Font.PLAIN, 17));
		optiond.setBounds(451, 244, 273, 44);
		panel_1.add(optiond);

		group = new ButtonGroup();
		group.add(optiona);
		group.add(optionb);
		group.add(optionc);
		group.add(optiond);



		btnNewButton = new JButton("Next");

		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {



					if("Submit".equals(btnNewButton.getText()))
					{
						connection = Connectionclass.Connect();
						String query1 = "INSERT INTO Result (Username,Marks) VALUES (?,?)";

						PreparedStatement ps1 = connection.prepareStatement(query1);
						ps1.setString(1, Welcome.name);
						ps1.setInt(2, count);
						ps1.execute();


						panel_1.setVisible(false);
						panel_2.setVisible(true);
					}



					else

					{	for (Enumeration<AbstractButton> buttons = group.getElements(); 
							buttons.hasMoreElements();
							) 
					{

						AbstractButton button = buttons.nextElement();

						if (button.isSelected()) {
							answer  =  button.getText();
						}
					}


					if(answer.equals(rs.getString("Answer")))
						count= count + 5;
					else count = count-5;

					}







					//	JOptionPane.showMessageDialog(null, count);

					//	if(rs.next())
					//{
					group.clearSelection();
					setdata();
					//}









				} catch (SQLException ex) {

					JOptionPane.showMessageDialog(null, ex);
				}


			}



		});
		btnNewButton.setBounds(189, 356, 144, 59);
		panel_1.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Reset");
		//btnNewButton_1.setSelectedIcon(new ImageIcon("C:\\Users\\choprv1\\Documents\\icons\\imageedit_8_6864178430.gif"));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		//	btnNewButton_1.setBackground(new Color(255, 255, 240));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {




					group.clearSelection();
				} 
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(471, 356, 144, 59);
		panel_1.add(btnNewButton_1);

		lblFdvb = new JLabel("",JLabel.CENTER);
		lblFdvb.setForeground(new Color(255, 0, 0));
		lblFdvb.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFdvb.setBounds(563, 29, 216, 36);
		panel_1.add(lblFdvb);

		JLabel lblTimeRemaining = new JLabel("Time remaining:");
		lblTimeRemaining.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTimeRemaining.setBounds(471, 29, 144, 36);
		panel_1.add(lblTimeRemaining);

		lblA = new JLabel("a)");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblA.setBounds(64, 202, 56, 16);
		panel_1.add(lblA);

		lblB = new JLabel("c)");
		lblB.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblB.setBounds(64, 260, 56, 16);
		panel_1.add(lblB);

		lblC = new JLabel("b)");
		lblC.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblC.setBounds(422, 204, 56, 16);
		panel_1.add(lblC);

		lblD = new JLabel("d)");
		lblD.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblD.setBounds(422, 260, 56, 16);
		panel_1.add(lblD);




		btnStartTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try
				{
					panel.setVisible(false);
					panel_1.setVisible(true);
					setdata();

					timer = new Timer(100, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (startTime < 0) {
								startTime = System.currentTimeMillis();
							}
							long now = System.currentTimeMillis();
							long clockTime = now - startTime;
							if (clockTime >= duration) {
								clockTime = duration;
								timer.stop();
							}
							SimpleDateFormat df = new SimpleDateFormat("mm:ss");
							lblFdvb.setText(df.format(duration-clockTime));
						}
					});
					timer.setInitialDelay(0);
					timer.start();

					//	 countdownTimer = new Timer(1000, new CountdownTimerListener());

					// countdownTimer.start();
				}	

				catch(Exception ex)
				{


					JOptionPane.showMessageDialog(null, ex);

				}
			}
		});



	}

	private void setdata() {

		try
		{   

			if(rs.next())
			{  lblDd.setText(Integer.toString(sn));
			Question.setText(rs.getString("Question"));
			optiona.setText(rs.getString("OptionA"));
			optionb.setText(rs.getString("OptionB"));
			optionc.setText(rs.getString("OptionC"));
			optiond.setText(rs.getString("OptionD"));
			sn = sn+1;}
			else { 
				//btnNewButton.setIcon(new ImageIcon("C:\\Users\\choprv1\\Documents\\icons\\imageedit_13_6702357660.gif"));
				btnNewButton.setText("Submit");
				optiona.setEnabled(false);
				optionb.setEnabled(false);
				optionc.setEnabled(false);
				optiond.setEnabled(false);}

			//if(group.isSelected(null))  btnNewButton.setEnabled(false);

		}	

		catch(Exception ex)
		{


			JOptionPane.showMessageDialog(null, ex);

		}


	}
}
