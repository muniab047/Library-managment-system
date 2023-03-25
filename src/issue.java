import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class issue {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					issue window = new issue();
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
	PreparedStatement pst;
	ResultSet rs;

	
	
	public issue() {
		initialize();
		conn= javaconnect.getconnect();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 901, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBookDetail = new JLabel("Book ID");
		lblBookDetail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBookDetail.setBounds(79, 82, 68, 14);
		frame.getContentPane().add(lblBookDetail);
		
		JLabel lblBookName = new JLabel("Book  Name");
		lblBookName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBookName.setBounds(79, 118, 68, 14);
		frame.getContentPane().add(lblBookName);
		
		JLabel lblNewLabel = new JLabel("Edition");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(79, 157, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPublisher.setBounds(79, 196, 57, 14);
		frame.getContentPane().add(lblPublisher);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrice.setBounds(79, 232, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblPage = new JLabel("Page");
		lblPage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPage.setBounds(79, 265, 46, 14);
		frame.getContentPane().add(lblPage);
		
		textField = new JTextField();
		textField.setBounds(184, 80, 115, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(184, 116, 115, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(184, 155, 115, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(184, 196, 115, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(184, 230, 115, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(184, 263, 115, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String sql= "SELECT * FROM booklist WHERE book_id=?";
					pst=conn.prepareStatement(sql);
					pst.setString(1,textField.getText());
					rs=pst.executeQuery();
					
					if(rs.next()){
						String a= rs.getString("Name");
						textField_1.setText(a);
						String b= rs.getString("edition");
						textField_2.setText(b);
						String c= rs.getString("publisher");
						textField_3.setText(c);
						String d= rs.getString("price");
						textField_4.setText(d);
						String f= rs.getString("pages");
						textField_5.setText(f);
						 pst.close();
						 rs.close();
					}
					else{
						JOptionPane.showMessageDialog(null, "book id is not found");
					}
					
					
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
				finally{
					try {
						pst.close();
						rs.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				
				
				
			}
		});
		btnSearch.setBounds(325, 79, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 2), "BOOK DETAIL", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(52, 43, 376, 276);
		frame.getContentPane().add(panel);
		
		JLabel lblStudentId = new JLabel("Student ID");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStudentId.setBounds(484, 83, 77, 14);
		frame.getContentPane().add(lblStudentId);
		
		JLabel lblStuName = new JLabel("student name");
		lblStuName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStuName.setBounds(484, 118, 89, 14);
		frame.getContentPane().add(lblStuName);
		
		JLabel lblFatherName = new JLabel("Father name");
		lblFatherName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFatherName.setBounds(484, 158, 77, 14);
		frame.getContentPane().add(lblFatherName);
		
		JLabel lblCourse = new JLabel("course");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCourse.setBounds(484, 197, 46, 14);
		frame.getContentPane().add(lblCourse);
		
		JLabel lblBranch = new JLabel("Branch");
		lblBranch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBranch.setBounds(484, 236, 46, 14);
		frame.getContentPane().add(lblBranch);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSemester.setBounds(484, 304, 77, 14);
		frame.getContentPane().add(lblSemester);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYear.setBounds(484, 269, 46, 14);
		frame.getContentPane().add(lblYear);
		
		textField_6 = new JTextField();
		textField_6.setBounds(583, 80, 115, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(583, 116, 115, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(583, 155, 115, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(583, 194, 115, 20);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(583, 230, 115, 20);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(583, 263, 115, 20);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(583, 302, 115, 20);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnSearch_1 = new JButton("Search");
		btnSearch_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String sql= "SELECT * FROM student WHERE stu_id=?";
					pst=conn.prepareStatement(sql);
					pst.setString(1,textField_6.getText());
					rs=pst.executeQuery();
					
					if(rs.next()){
						String a= rs.getString("sname");
						textField_7.setText(a);
						String b= rs.getString("Fname");
						textField_8.setText(b);
						String c= rs.getString("course");
						textField_9.setText(c);
						String d= rs.getString("branch");
						textField_10.setText(d);
						String f= rs.getString("year");
						textField_11.setText(f);
						String g= rs.getString("semester");
						textField_12.setText(g);
						 pst.close();
						 rs.close();
					}
					else{
						JOptionPane.showMessageDialog(null, "book id is not found");
					}
					
					
					
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
				finally{
					try {
						pst.close();
						rs.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnSearch_1.setBounds(728, 82, 89, 23);
		frame.getContentPane().add(btnSearch_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 140, 0), 2, true), "Student Detail", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(458, 61, 376, 268);
		frame.getContentPane().add(panel_1);
		
		JLabel lblDateOfIssue = new JLabel("Date of Issue");
		lblDateOfIssue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfIssue.setBounds(528, 358, 77, 14);
		frame.getContentPane().add(lblDateOfIssue);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(615, 352, 122, 20);
		frame.getContentPane().add(dateChooser);
		
		JButton btnIssue = new JButton("Issue");
		btnIssue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql= "INSERT INTO issue (book_id,bname,edition,publisher,price,page,st_id,sname,fname,course,branch,year,semester) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
					pst= conn.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, textField_2.getText());
					pst.setString(4, textField_3.getText());
					pst.setString(5, textField_4.getText());
					pst.setString(6, textField_5.getText());
					pst.setString(7, textField_6.getText());
					pst.setString(8, textField_7.getText());
					pst.setString(9, textField_8.getText());
					pst.setString(10, textField_9.getText());
					pst.setString(11, textField_10.getText());
					pst.setString(12, textField_11.getText());
					pst.setString(13, textField_12.getText());
					//pst.setString(14, ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());
					pst.execute();
					JOptionPane.showMessageDialog(null, "issued successfully");
					pst.close();
					rs.close();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}finally{
					try {
						pst.close();
						rs.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		btnIssue.setBounds(536, 396, 89, 23);
		frame.getContentPane().add(btnIssue);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				home.main(null);
			}
		});
		btnBack.setBounds(683, 396, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
