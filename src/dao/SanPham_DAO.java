package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.SanPham;

public class SanPham_DAO {
	
	ConnectDB con = ConnectDB.getInstance();

	public String getTenByMaSP(String maSP) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;

		String tenSP = "";
		String sqlGetSP = "SELECT tenSP from SanPham where maSP = ?";
		try {
			stmt = con.prepareStatement(sqlGetSP);
			stmt.setString(1, maSP);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				tenSP = rs.getString("tenSP");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tenSP;
	}
	
	public String getTenByDonGia(String maSP) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;

		String tenSP = "";
		String sqlGetSP = "SELECT tenSP from SanPham where maSP = ?";
		try {
			stmt = con.prepareStatement(sqlGetSP);
			stmt.setString(1, maSP);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				tenSP = rs.getString("tenSP");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tenSP;
	}
	public void close(PreparedStatement stmt) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public double getGiaBanByMaSP(String maSP) {
	    Connection con = ConnectDB.getInstance().getConnection();
	    PreparedStatement stmt = null;
	    double giaBan = 0.0; // Đặt giá trị mặc định cho giaBan là 0

	    String sqlGetSP = "SELECT giaBan FROM SanPham WHERE maSP = ?";
	    try {
	        stmt = con.prepareStatement(sqlGetSP);
	        stmt.setString(1, maSP);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            // Lấy giá trị từ cơ sở dữ liệu
	            giaBan = rs.getDouble("giaBan");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return giaBan;
	}
	public DefaultComboBoxModel<String> loadComBoBox(String tenCot, String tenBang) {
		ArrayList<String> data = new ArrayList<String>();
		try {
			con.connect();
			String sql = "SELECT " + tenCot + " FROM " + tenBang;
			Statement statement = con.getConnection().createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String item = rs.getString(tenCot);
				data.add(item);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new DefaultComboBoxModel<String>(data.toArray(new String[0]));

	}



}
