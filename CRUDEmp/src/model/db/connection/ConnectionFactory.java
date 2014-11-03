package model.db.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/crudpet";
			String user = "root";
			String pass = "root";
			Connection con = DriverManager.getConnection(url, user, pass);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
