import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class signup {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	
	
	/**
	 * Launch the application.
	 */
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup window = new signup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;
	
	public signup() {
		//super ();
		initialize();
		conn = javaconnect.getconnect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(78, 50, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblUserName = new JLabel("USER NAME");
		lblUserName.setBounds(67, 89, 57, 14);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(67, 125, 57, 25);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblSecurityQuestion = new JLabel("SECURITY QUESTION");
		lblSecurityQuestion.setBounds(20, 169, 104, 14);
		frame.getContentPane().add(lblSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("ANSWER");
		lblAnswer.setBounds(78, 201, 46, 14);
		frame.getContentPane().add(lblAnswer);
		
		textField = new JTextField();
		textField.setBounds(182, 47, 151, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(182, 86, 151, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(182, 127, 151, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is your mother's name?", "what is your nick name?", "how many sibling's do you have?", "your favorite food?"}));
		comboBox.setBounds(182, 166, 157, 20);
		frame.getContentPane().add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(182, 198, 157, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCreate = new JButton("CREATE");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String s = "INSERT INTO account (Name,Username,Password,Sec_q,Answer)  VALUE (?,?,?,?,?)";
					pst= conn.prepareStatement(s);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, (String)comboBox.getSelectedItem());
					pst.setString(5, textField_3.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "account has been created");
					pst.close();
					rs.close();
				
					
				}
				catch (Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnCreate.setBounds(85, 248, 89, 23);
		frame.getContentPane().add(btnCreate);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			login lg = new login();
			lg.main(null);
			//login.frame.setVisible(true);
			}
		});
		btnBack.setBounds(228, 248, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "SIGN UP PAGE", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 255)));
		panel.setBounds(20, 23, 366, 264);
		frame.getContentPane().add(panel);
	}
}
