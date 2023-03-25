import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class returnp {

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
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnp window = new returnp();
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
	
	public returnp() {
		initialize();
		conn= javaconnect.getconnect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 13));
		frame.setBounds(100, 100, 851, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBookId = new JLabel("student id");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBookId.setBounds(67, 76, 67, 14);
		frame.getContentPane().add(lblBookId);
		
		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(67, 115, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblFatherName = new JLabel("father name");
		lblFatherName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFatherName.setBounds(67, 152, 78, 14);
		frame.getContentPane().add(lblFatherName);
		
		JLabel lblCourse = new JLabel("course");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCourse.setBounds(67, 193, 46, 14);
		frame.getContentPane().add(lblCourse);
		
		JLabel lblBranch = new JLabel("branch");
		lblBranch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBranch.setBounds(67, 240, 46, 14);
		frame.getContentPane().add(lblBranch);
		
		JLabel lblYear = new JLabel("year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblYear.setBounds(67, 280, 46, 14);
		frame.getContentPane().add(lblYear);
		
		JLabel lblSemester = new JLabel("semester");
		lblSemester.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSemester.setBounds(67, 319, 67, 14);
		frame.getContentPane().add(lblSemester);
		
		textField = new JTextField();
		textField.setBounds(163, 73, 123, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(163, 109, 123, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(163, 149, 123, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(163, 190, 123, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(163, 237, 123, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(163, 280, 46, 14);
		frame.getContentPane().add(label);
		
		textField_5 = new JTextField();
		textField_5.setBounds(163, 277, 123, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(163, 316, 123, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSearch = new JButton("search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					String sql= "SELECT * FROM issue WHERE st_id=?";
					pst=conn.prepareStatement(sql);
					pst.setString(1,textField.getText());
					rs=pst.executeQuery();
					
					if(rs.next()){
						String a= rs.getString("sname");
						textField_1.setText(a);
						String b= rs.getString("fname");
						textField_2.setText(b);
						String c= rs.getString("course");
						textField_3.setText(c);
						String d= rs.getString("branch");
						textField_4.setText(d);
						String f= rs.getString("year");
						textField_5.setText(f);
						String g= rs.getString("semester");
						textField_6.setText(g);
						String h= rs.getString("book_id");
						textField_7.setText(h);
						String i= rs.getString("bname");
						textField_8.setText(i);
						String j= rs.getString("edition");
						textField_9.setText(j);
						String k= rs.getString("publisher");
						textField_10.setText(k);
						String l= rs.getString("price");
						textField_11.setText(l);
						String m= rs.getString("page");
						textField_12.setText(m);
						//String n= rs.getString("date_of_issue");
						//textField_6.setText(n);
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
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSearch.setBounds(314, 72, 89, 23);
		frame.getContentPane().add(btnSearch);
		
		JLabel lblStudentId = new JLabel("book id");
		lblStudentId.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblStudentId.setBounds(466, 76, 78, 14);
		frame.getContentPane().add(lblStudentId);
		
		JLabel lblName_1 = new JLabel("name");
		lblName_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblName_1.setBounds(466, 115, 46, 14);
		frame.getContentPane().add(lblName_1);
		
		JLabel lblEditon = new JLabel("editon");
		lblEditon.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblEditon.setBounds(466, 152, 46, 14);
		frame.getContentPane().add(lblEditon);
		
		JLabel lblPublisher = new JLabel("publisher");
		lblPublisher.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPublisher.setBounds(466, 193, 78, 14);
		frame.getContentPane().add(lblPublisher);
		
		JLabel lblPrice = new JLabel("price");
		lblPrice.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPrice.setBounds(466, 240, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblPage = new JLabel("page");
		lblPage.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblPage.setBounds(466, 280, 46, 14);
		frame.getContentPane().add(lblPage);
		
		JLabel lblDateOfIssue = new JLabel("date of issue");
		lblDateOfIssue.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblDateOfIssue.setBounds(466, 319, 78, 14);
		frame.getContentPane().add(lblDateOfIssue);
		
		textField_7 = new JTextField();
		textField_7.setBounds(557, 73, 123, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(557, 112, 123, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(557, 149, 123, 20);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(557, 187, 123, 20);
		frame.getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(557, 237, 123, 20);
		frame.getContentPane().add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(557, 277, 123, 20);
		frame.getContentPane().add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(557, 316, 123, 20);
		frame.getContentPane().add(textField_13);
		textField_13.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 139, 139), 2), "Return page", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(39, 43, 699, 328);
		frame.getContentPane().add(panel);
		
		JLabel lblDateOfReturn = new JLabel("date of return");
		lblDateOfReturn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateOfReturn.setBounds(498, 382, 89, 14);
		frame.getContentPane().add(lblDateOfReturn);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(597, 376, 141, 20);
		frame.getContentPane().add(dateChooser);
		
		JButton btnReturns = new JButton("Returns");
		btnReturns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String sql= "DELETE from issue where st_id=?";
					pst=conn.prepareStatement(sql);
					pst.setString(1,textField.getText());
					pst.execute();
					pst.close();
					rs.close();
					
					JOptionPane.showMessageDialog(null, "book returned");
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnReturns.setBounds(557, 417, 89, 23);
		frame.getContentPane().add(btnReturns);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				home.main(null);
			}
		});
		btnBack.setBounds(682, 417, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
