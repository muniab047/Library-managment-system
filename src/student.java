import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.event.ActionEvent;

public class student {

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
					student window = new student();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public student() {
		initialize();
		conn=javaconnect.getconnect();
		rand();
	}
	
	public void rand(){
		Random rd= new Random();
		textField.setText(""+rd.nextInt(10000));
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 364, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentId = new JLabel("Student id");
		lblStudentId.setBounds(45, 41, 86, 14);
		frame.getContentPane().add(lblStudentId);
		
		JLabel lblStudentName = new JLabel("student name");
		lblStudentName.setBounds(45, 76, 78, 14);
		frame.getContentPane().add(lblStudentName);
		
		JLabel lblFatherName = new JLabel("father name");
		lblFatherName.setBounds(45, 117, 65, 14);
		frame.getContentPane().add(lblFatherName);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setBounds(45, 156, 51, 14);
		frame.getContentPane().add(lblCourse);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setBounds(45, 193, 46, 14);
		frame.getContentPane().add(lblBranch);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(45, 231, 46, 14);
		frame.getContentPane().add(lblYear);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setBounds(45, 265, 46, 14);
		frame.getContentPane().add(lblSemester);
		
		textField = new JTextField();
		textField.setBounds(149, 38, 121, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(149, 73, 121, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(149, 114, 121, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"UGR", "MCS", "PHD"}));
		comboBox.setBounds(149, 153, 121, 20);
		frame.getContentPane().add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(149, 190, 121, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox_1.setBounds(149, 228, 121, 20);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		comboBox_2.setBounds(149, 262, 121, 17);
		frame.getContentPane().add(comboBox_2);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String sql = "INSERT INTO student (stu_id,sname,fname,course,branch,year,semester) VALUE (?,?,?,?,?,?,?)";
					pst=conn.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4,(String)comboBox.getSelectedItem());
					pst.setString(5, textField_3.getText());
					pst.setString(6,(String)comboBox_1.getSelectedItem());
					pst.setString(7,(String)comboBox_2.getSelectedItem());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Regiterede successfully");
					
					pst.close();
					rs.close();
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnNewButton.setBounds(54, 314, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				home.main(null);
			}
			
		});
		btnNewButton_1.setBounds(180, 314, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 38, 0, 0);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 139, 139)));
		panel_1.setBounds(25, 22, 276, 325);
		frame.getContentPane().add(panel_1);
	}
}
