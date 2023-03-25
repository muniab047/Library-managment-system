import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home window = new home();
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
	public home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 916, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				newbook.main(null);
			}
		});
		button.setIcon(new ImageIcon("D:\\projects\\library managment system\\icons\\book_blue_add.png"));
		button.setBounds(189, 124, 149, 102);
		frame.getContentPane().add(button);
	
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				statstics.main(null);

			}
		});
		button_1.setIcon(new ImageIcon("D:\\projects\\library managment system\\icons\\static.png"));
		button_1.setBounds(415, 124, 149, 101);
		frame.getContentPane().add(button_1);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				student.main(null);
			}
		});
		btnNewButton.setIcon(new ImageIcon("D:\\projects\\library managment system\\icons\\icons8-student-registration-100.png"));
		btnNewButton.setBounds(640, 124, 149, 102);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewBook = new JLabel("New Book");
		lblNewBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewBook.setBounds(236, 237, 78, 17);
		frame.getContentPane().add(lblNewBook);
		
		JLabel lblStatistiics = new JLabel("Statistiics");
		lblStatistiics.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatistiics.setBounds(473, 236, 78, 14);
		frame.getContentPane().add(lblStatistiics);
		
		JLabel lblNewSrudent = new JLabel("New Srudent");
		lblNewSrudent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewSrudent.setBounds(678, 240, 84, 14);
		frame.getContentPane().add(lblNewSrudent);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 139, 139), 2));
		panel.setBounds(152, 110, 663, 171);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\projects\\library managment system\\icons\\Library-management-Software.jpg"));
		lblNewLabel.setBounds(8, 11, 556, 84);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSmartLibrary = new JLabel("#Smart Library");
		lblSmartLibrary.setForeground(new Color(0, 139, 139));
		lblSmartLibrary.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblSmartLibrary.setBounds(690, 55, 174, 36);
		frame.getContentPane().add(lblSmartLibrary);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("D:\\projects\\library managment system\\icons\\book (9).png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				issue.main(null);
			}
		});
		btnNewButton_1.setBounds(189, 363, 149, 95);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("D:\\projects\\library managment system\\icons\\book (8).png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnp.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(415, 363, 149, 95);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				about.main(null);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("D:\\projects\\library managment system\\icons\\info.png"));
		btnNewButton_3.setBounds(640, 363, 149, 95);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblIssueBook = new JLabel("Issue Book");
		lblIssueBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIssueBook.setBounds(236, 469, 73, 14);
		frame.getContentPane().add(lblIssueBook);
		
		JLabel lblReturnBook = new JLabel("Return Book");
		lblReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblReturnBook.setBounds(451, 469, 78, 14);
		frame.getContentPane().add(lblReturnBook);
		
		JLabel lblAbout = new JLabel("About");
		lblAbout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAbout.setBounds(702, 471, 46, 14);
		frame.getContentPane().add(lblAbout);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 140, 0), 2), "ACTION", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(152, 325, 663, 193);
		frame.getContentPane().add(panel_1);
		
		JLabel lblWelcomTo = new JLabel("Welcome to");
		lblWelcomTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWelcomTo.setForeground(new Color(255, 127, 80));
		lblWelcomTo.setBounds(640, 42, 119, 14);
		frame.getContentPane().add(lblWelcomTo);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
