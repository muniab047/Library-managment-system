import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class forgot {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forgot window = new forgot();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection conn;
	ResultSet rs;
	PreparedStatement pst;

	/**
	 * Create the application.
	 */
	public forgot() {
		initialize();
		conn= javaconnect.getconnect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.setBounds(100, 100, 450, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER NAME\r\n");
		lblNewLabel.setBounds(93, 56, 57, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(119, 87, 57, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblYourSecurityQuestion = new JLabel("YOUR SECURITY QUESTION");
		lblYourSecurityQuestion.setBounds(10, 125, 140, 14);
		frame.getContentPane().add(lblYourSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("ANSWER");
		lblAnswer.setBounds(104, 158, 46, 14);
		frame.getContentPane().add(lblAnswer);
		
		JLabel lblYourPassword = new JLabel("YOUR PASSWORD");
		lblYourPassword.setBounds(54, 222, 96, 14);
		frame.getContentPane().add(lblYourPassword);
		
		textField = new JTextField();
		textField.setBounds(209, 53, 112, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(209, 84, 112, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(209, 122, 112, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(209, 155, 112, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(209, 216, 112, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Search\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a1= textField.getText();
				String sql= "SELECT * FROM account WHERE Username= '"+a1+"'";
				try{
					pst=conn.prepareStatement(sql);
					rs=pst.executeQuery();
					
					if(rs.next()){
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(4));
						rs.close();
						pst.close();
						
					}
					else{
						JOptionPane.showMessageDialog(null, "incorrect username");
						
					}
				}
				catch(Exception e1 ){
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setBounds(331, 52, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retrive\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   String a1= textField.getText();
			   String a2= textField_3.getText();
			   String sql= "select * from account WHERE Answer = '"+a2+"'";
			   try{
				   pst=conn.prepareStatement(sql);
				   rs= pst.executeQuery();
				   if(rs.next()){
					   textField_4.setText(rs.getString(3));
					   rs.close();
					   pst.close();
					   
				   }
				   else{
					   JOptionPane.showMessageDialog(null, "incorrect answer");
				   }
				    }
			   catch(Exception e1){
				   JOptionPane.showMessageDialog(null, e1);
			   }
			}
		});
		btnNewButton_1.setBounds(331, 154, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				login.main(null);
			}
		});
		btnBack.setBounds(331, 218, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2, true), "FORGOT PAGE", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 255, 255)));
		panel.setBackground(new Color(205, 133, 63));
		panel.setBounds(10, 27, 414, 239);
		frame.getContentPane().add(panel);
	}
}
