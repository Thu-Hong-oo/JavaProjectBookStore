package connectDB;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import java.awt.Image;
import java.sql.Connection;

public class ConnectDB {
	public static Connection con =null;//biến để lưu trữ kết nối đến cơ sở dữ liệu
	//con = null nhằm giúp xác định đã kết nối tới csdl hay chưa
	private static ConnectDB instance = new ConnectDB();
	public static ConnectDB getInstance() {
		return instance;
	}
	public void connect() throws SQLException{
		String url = "jdbc:sqlserver://localhost:1433;databaseName=BTL_qlnstn";
		String user = "sa";
		String password = "sapassword";
		con= DriverManager.getConnection(url, user, password);
		//getConection là phương thức static, DriverManager là class có sẵn trong thư viện
	}
	public void disconnect() {
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static Connection getConnection() {
		return con;
	}

	
}
