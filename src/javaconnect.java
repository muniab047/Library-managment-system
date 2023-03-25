import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class javaconnect {
Connection conn;

public static Connection getconnect(){
try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "Hasina@00");
	return conn;
}
catch( Exception e){
	JOptionPane.showMessageDialog(null, e);
	return null;	
}

	
}}
