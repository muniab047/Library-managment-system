import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class loading  implements Runnable {

	private JFrame frame;
	
	
	Connection conn;
	int s=0;
	Thread th;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loading window = new loading();
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
	public loading() {
		initialize();
		th= new Thread((Runnable)this);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void setuploading() {
		frame.setVisible(false);
		th.start();
		
	}
	JProgressBar progressBar = new JProgressBar();
	public void run(){
		try{
			for(int i=0; i<=100; i++){
				s=s+1;
				
				int m= progressBar.getMaximum();
				int v= progressBar.getValue();
				
				if(v<m){
					progressBar.setValue(progressBar.getValue()+1);
					
				}
				else{
					i=201;
					frame.setVisible(false);
					home.main(null);
				}Thread.sleep(50);
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			
		}}
		
		
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\projects\\library managment system\\icons\\389193805stack-of-books-animation-1.gif"));
		label.setBounds(126, 243, 169, 159);
		frame.getContentPane().add(label);
		
		JLabel lblSmartLibrary = new JLabel("#Smart Library 1.1");
		lblSmartLibrary.setForeground(new Color(0, 206, 209));
		lblSmartLibrary.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblSmartLibrary.setBounds(59, 68, 321, 46);
		frame.getContentPane().add(lblSmartLibrary);
		
		
		progressBar.setStringPainted(true);
		progressBar.setBounds(135, 195, 146, 14);
		frame.getContentPane().add(progressBar);
		
		JLabel lblPleaseWait = new JLabel("please wait...");
		lblPleaseWait.setBounds(177, 230, 87, 14);
		frame.getContentPane().add(lblPleaseWait);
		
		JPanel panel = new JPanel();
		panel.setBounds(34, 47, 371, 355);
		frame.getContentPane().add(panel);
		
		
	}
	
	
}
