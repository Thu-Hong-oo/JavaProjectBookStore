package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import connectDB.ConnectDB;
import entity.KhachHang;


public class KhachHang_DAO {
	ConnectDB con = ConnectDB.getInstance();

	public ArrayList<KhachHang> getAllKhachHang() {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			con.connect();
			String sql = "Select *FROM KhachHang";
			Statement statement = con.getConnection().createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dsKhachHang.add(new KhachHang(rs.getString("maKhachHang"),rs.getString("tenKhachHang"),
<<<<<<< HEAD
						rs.getDate("ngaySinh"),rs.getString("gioiTinh"), rs.getString("soDienThoai"),
						rs.getString("email"),rs.getString("diaChi")));
=======
						rs.getString("gioiTinh"), rs.getString("diaChi"),
						rs.getString("soDienThoai"),rs.getString("email"),rs.getString("ngaySinh")));
>>>>>>> a8b28fd5b52401684a91b5b3b90e1f83d7d1bcfe
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}
	
	private void close(PreparedStatement stmt) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	private void close(ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
<<<<<<< HEAD
//	public boolean themKH(KhachHang k) {
//		Connection con = ConnectDB.getInstance().getConnection();
//		PreparedStatement stmt = null;
//		String sql = "Insert into KhachHang (MaKH,TenKH,GioiTinh,DiaChi,DienThoai,Email) VALUES (?,?,?,?,?,?)";
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, k.getMaKH());
//			stmt.setString(2, k.getTenKH());
//			stmt.setString(3, k.getGioiTinh());
//			stmt.setString(4, k.getDiaChi());
//			stmt.setString(5, k.getSDT());
//			stmt.setString(6, k.getEmail());
//			stmt.executeUpdate();
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Mã khách hàng bị trùng");
//			return false;
//		} finally {
//			close(stmt);
//		}
//		return true;
//	}
//	public void xoaLopHoc(String maKH) {
//		Connection con = ConnectDB.getInstance().getConnection();
//		PreparedStatement stmt = null;
//		String sql = "Delete from KhachHang where MaKH = ?";
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, maKH);
//			stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(stmt);
//		}
//	}
//	public void suaKH(KhachHang k) {
//		Connection con = ConnectDB.getInstance().getConnection();
//		PreparedStatement stmt = null;
//		String sql = "update KhachHang " + " set TenKH = ?, " + "GioiTinh = ?, "+"DiaChi = ?, "+"DienThoai = ?, "+"Email = ? "+ "where MaKH = ?";
//		try {
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, k.getTenKH());
//			stmt.setString(2, k.getGioiTinh());
//			stmt.setString(3, k.getDiaChi());
//			stmt.setString(4, k.getSDT());
//			stmt.setString(5, k.getEmail());
//			stmt.setString(6, k.getMaKH());
//			stmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(stmt);
//		}
//	}
=======
	public boolean themKH(KhachHang k) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO KhachHang (maKhachHang, tenKhachHang, ngaySinh, gioiTinh, soDienThoai, email, diaChi) VALUES (?,?,?,?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, k.getMaKH());
			stmt.setString(2, k.getTenKH());
			stmt.setString(3, k.getNgaySinh());
			stmt.setString(4, k.getGioiTinh());
			stmt.setString(5, k.getSDT());
			stmt.setString(6, k.getEmail());
			stmt.setString(7, k.getDiaChi());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			close(stmt);
		}
		return true;
	}
	public boolean xoaKH(String maKH) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		

		String sql = "DELETE FROM KhachHang"
				+ "		WHERE maKhachHang = ?"
				+ "		AND maKhachHang NOT IN (SELECT maKH FROM HoaDon)"
				+ "		AND maKhachHang NOT IN (SELECT maKH FROM PhieuDatHang)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maKH);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			close(stmt);
		}
		return true;
	}
	public void suaKH(KhachHang k) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		String sql = "update KhachHang " + " set tenKhachHang = ?, " + "ngaySinh = ?, "+"gioiTinh = ?, "+"soDienThoai = ?, "+"email = ?, "+"diaChi = ? "+ "where maKhachHang = ?";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, k.getTenKH());
			stmt.setString(2, k.getNgaySinh());
			stmt.setString(3, k.getGioiTinh());
			stmt.setString(4, k.getSDT());
			stmt.setString(5, k.getEmail());
			stmt.setString(6, k.getDiaChi());
			stmt.setString(7, k.getMaKH());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
	}
	public String taoMa() {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		String ma;
		boolean isDuplicate;
		do {
			// Tạo mã hóa đơn ngẫu nhiên
			Random rand = new Random();
			ma = "KH" + rand.nextInt(1000);
			// Kiểm tra xem mã hóa đơn có bị trùng không
			isDuplicate = false;
			String sql = "SELECT * FROM KhachHang WHERE maKhachHang = ?";
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, ma);
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					isDuplicate = true;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} while (isDuplicate);
		return ma;
	}
>>>>>>> a8b28fd5b52401684a91b5b3b90e1f83d7d1bcfe
//	public int timKiemKH(String maKH) {
//	    Connection con = ConnectDB.getInstance().getConnection();
//	    PreparedStatement stmt = null;
//	    ResultSet rs = null;
//	    String sql = "SELECT * FROM KhachHang WHERE MaKH = ?";
//	    int rowNum = -1; // Số thứ tự dòng, khởi tạo là -1 để đánh dấu không tìm thấy
//	    
//	    try {
//	        stmt = con.prepareStatement(sql);
//	        stmt.setString(1, maKH);
//	        rs = stmt.executeQuery();
//
//	        if (rs.next()) {
//	            rowNum = rs.getRow(); // Lấy số thứ tự dòng
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    } finally {
//	        close(rs);
//	        close(stmt);
//	    }
//	    
//	    return rowNum;
//	}

}
