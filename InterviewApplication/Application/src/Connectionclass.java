import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

import javax.swing.*;


public class Connectionclass {
	
	public static Connection Connect()
	{
		//Connection con = null;
		try
		{
			Properties prop = new Properties();
			FileInputStream output = new FileInputStream(new File("C:\\Users\\choprv1\\Desktop\\config.properties"));
			prop.load(output);
			String classname=(String) prop.get("drivername");
			String connectionstring=(String) prop.get("connectionstring1");
			 Class.forName(classname);
			// String db = "jdbc:odbc:C:\\Users\\choprv1\\Documents\\Admin-Normal_User1";
			 Connection con = DriverManager.getConnection(connectionstring);
			//	st = con.createStatement();										
			// JOptionPane.showMessageDialog(null,"Connection established");     
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
