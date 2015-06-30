import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.Properties;

import javax.swing.*;

public class ConnectToQuestion {
	

	public static Connection ConnectToQues()
	{
		
		try
		{
			Properties prop = new Properties();
			FileInputStream output = new FileInputStream(new File("C:\\Users\\choprv1\\Desktop\\config.properties"));
			prop.load(output);
			String classname=(String) prop.get("drivername");
			String connectionstring=(String) prop.get("connectionstring");
				
			 //Class.forName("org.sqlite.JDBC");
			Class.forName(classname);
			// String db = "jdbc:odbc:C:\\Users\\choprv1\\Documents\\Admin-Normal_User1";
			 //Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\choprv1\\Documents\\Questions.sqlite");
			Connection con = DriverManager.getConnection(connectionstring);
		    return con;
		}	
		
		catch(Exception ex)
		{
			
			 System.out.println(ex);
			 JOptionPane.showMessageDialog(null, ex);
			 return null;
		}
		
		
		
		
	}

}
