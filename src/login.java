import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

public class login {

	private JFrame frame;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
					UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
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
	private JTextField textField;
	
	
	public login() {
		initialize();
		conn= javaconnect.getconnect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(new Color(176, 224, 230));
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(200, 88, 133, 20);
		frame.getContentPane().add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 128, 133, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("USER NAME");
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel.setBounds(103, 88, 87, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.BOLD, 12));
		lblNewLabel_1.setBounds(103, 129, 109, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sql= "SELECT * FROM account where Username=? and Password=? " ;
				try{
					pst=conn.prepareStatement(sql);
					pst.setString(1,textField.getText() );
					pst.setString(2,passwordField.getText() );
					rs= pst.executeQuery();
					if(rs.next()){
						frame.setVisible(false);
						loading.main(null);
						pst.close();
						rs.close();
						
						frame.setVisible(false);
						loading ob= new loading();
						ob.setuploading();
						ob.run();
						//progressBar.setValue(5);
						loading.main(null);
						
					}
					else{
						JOptionPane.showMessageDialog(null, "incorrect user name and password");
						pst.close();
						rs.close();
					}
				}
				catch(Exception e){
					JOptionPane.showMessageDialog(null, e);
				}
				finally{
					try{
						pst.close();
						rs.close();
					}
					catch(Exception e){}
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\projects\\library managment system\\icons\\Login-icon.png"));
		btnNewButton.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		btnNewButton.setBounds(146, 183, 110, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIGNUP\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				signup.main(null);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("D:\\projects\\library managment system\\icons\\sign-up-icon.png"));
		btnNewButton_1.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		btnNewButton_1.setBounds(266, 183, 113, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\projects\\library managment system\\icons\\Register-icon.png"));
		lblNewLabel_3.setBounds(343, 111, 29, 55);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnForgotePassword = new JButton("forgot password");
		btnForgotePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				forgot.main(null);
				
			}
		});
		btnForgotePassword.setBounds(200, 242, 125, 23);
		frame.getContentPane().add(btnForgotePassword);
		
		JLabel lblAnyTrouble = new JLabel("any trouble ");
		lblAnyTrouble.setForeground(new Color(255, 0, 0));
		lblAnyTrouble.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		lblAnyTrouble.setBounds(120, 247, 98, 14);
		frame.getContentPane().add(lblAnyTrouble);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\projects\\library managment system\\icons\\office-women-pink-icon.png"));
		lblNewLabel_4.setBounds(343, 77, 36, 41);
		frame.getContentPane().add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 133, 63));
		panel.setToolTipText("");
		panel.setBounds(88, 77, 306, 154);
		frame.getContentPane().add(panel);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\projects\\library managment system\\icons\\books-1204029_960_720.jpg"));
		lblNewLabel_2.setBounds(-15, -11, 509, 322);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
