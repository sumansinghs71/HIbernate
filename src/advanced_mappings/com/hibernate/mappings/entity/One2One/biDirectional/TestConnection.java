package advanced_mappings.com.hibernate.mappings.entity.One2One.biDirectional;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?allowPublicKeyRetrieval=true&useSSL=false";
		String user="hbstudent";
		String password="hbstudent";
		try {
			System.out.println("Connecting to DB"+url);
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Successful");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
