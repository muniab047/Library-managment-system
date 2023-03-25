import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class newbook {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newbook window = new newbook();
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
	public newbook() {
		initialize();
		conn=javaconnect.getconnect();
		Random(); 
	}
	
	public void Random(){
		Random rd= new Random();
		textField.setText(""+rd.nextInt(1000));
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 385, 401);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBookId = new JLabel("Book ID");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBookId.setBounds(61, 55, 46, 14);
		frame.getContentPane().add(lblBookId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(61, 95, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEdition.setBounds(61, 132, 46, 14);
		frame.getContentPane().add(lblEdition);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPublisher.setBounds(61, 170, 66, 14);
		frame.getContentPane().add(lblPublisher);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrice.setBounds(61, 207, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblPages = new JLabel("Pages");
		lblPages.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPages.setBounds(61, 247, 46, 14);
		frame.getContentPane().add(lblPages);
		
		textField = new JTextField();
		textField.setBounds(143, 53, 160, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(143, 93, 160, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7"}));
		comboBox.setBounds(143, 130, 160, 20);
		frame.getContentPane().add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(143, 168, 160, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(143, 205, 160, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(143, 245, 160, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql= "INSERT INTO booklist(book_id, name,edition,publisher,price,pages) VALUE(?,?,?,?,?,?)";
					pst=conn.prepareStatement(sql);
					pst.setString(1,textField.getText());
					pst.setString(2,textField_1.getText());
					pst.setString(3,(String)comboBox.getSelectedItem());
					pst.setString(4,textField_2.getText());
					pst.setString(5,textField_3.getText());
					pst.setString(6,textField_4.getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "added successfully");
					
					pst.close();
					rs.close();
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
				
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(95, 303, 89, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				home.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBack.setBounds(214, 303, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 139, 139), 2));
		panel.setBounds(39, 40, 297, 300);
		frame.getContentPane().add(panel);
	}
}
