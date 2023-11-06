package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.NhanVien;
import entity.SanPham;
import entity.ThongKe;

public class HoaDon_DAO {
	ConnectDB con = ConnectDB.getInstance();

	public ArrayList<HoaDon> getAllHoaDon() {
		ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
		try {
			con.connect();
			String sql = "SELECT * FROM HoaDon";

			Statement statement = con.getConnection().createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dsHoaDon.add(new HoaDon(rs.getString("maHD"), rs.getString("maKH"), rs.getString("maNV"),rs.getDate("NgayLapHD"),
						rs.getLong("tongTien"), rs.getString("ghiChu")));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHoaDon;
	}


	public String getTenSPMuaNhieuNhatThang(int thang, int nam) {
	Connection con = ConnectDB.getInstance().getConnection();
	PreparedStatement stmt = null;
	String getTen = "";
	String sqlGetMa = "SELECT tenSP FROM SanPham WHERE maSP IN (SELECT TOP 1 maSP "
			+ " FROM ChiTietHoaDon WHERE maHD IN(SELECT maHD FROM HoaDon WHERE Month(NgayLapHD) = ? "
			+ " AND YEAR(NgayLapHD) = ?) "
			+ " GROUP BY maSP ORDER BY SUM(soLuong) DESC);";
	try {
		stmt = con.prepareStatement(sqlGetMa);
		stmt.setInt(1, thang);
		stmt.setInt(2, nam);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			getTen = rs.getString("tenSP");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(stmt);
	}
	return getTen;
}
	
	public ThongKe getThongKeByMonth(int thang, int nam) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		ThongKe tk = new ThongKe();
		String sqlGetDoanhThu = "SELECT SUM(tongTien) AS TongDoanhThuThang,  COUNT(DISTINCT HoaDon.maHD) AS TongHoaDon, COUNT(DISTINCT HoaDon.maKH) AS TongKhachHang "
				+ "from HoaDon  where Month(ngayLapHD) = ?  and Year(ngayLapHD) = ?";
		try {
			String tenSPMuaNhieu = getTenSPMuaNhieuNhatThang(thang,nam);
			stmt = con.prepareStatement(sqlGetDoanhThu);
			stmt.setInt(1, thang);
			stmt.setInt(2, nam);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				tk.setDoanhThu(rs.getLong("TongDoanhThuThang")) ;
				tk.setSoHoaDon(rs.getInt("TongHoaDon"));
				tk.setTongKhach(rs.getInt("TongKhachHang"));
			}
			tk.setTenSPMuaNhieu(tenSPMuaNhieu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tk;
	}
	
	public String getTenSPMuaNhieuNhatNam( int nam) {
	Connection con = ConnectDB.getInstance().getConnection();
	PreparedStatement stmt = null;
	String getTen = "";
	String sqlGetMa = "SELECT tenSP FROM SanPham WHERE maSP IN (SELECT TOP 1 maSP "
			+ " FROM ChiTietHoaDon WHERE maHD IN(SELECT maHD FROM HoaDon WHERE  "
			+ "  YEAR(NgayLapHD) = ?) "
			+ " GROUP BY MaSP ORDER BY SUM(soLuong) DESC);";
	try {
		stmt = con.prepareStatement(sqlGetMa);
		stmt.setInt(1, nam);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			getTen = rs.getString("tenSP");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(stmt);
	}
	return getTen;
}
	public ThongKe getThongKeByYear(int nam) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		ThongKe tk = new ThongKe();
		String sqlGetDoanhThu = "SELECT SUM(tongTien) AS TongDoanhThuThang,  COUNT(DISTINCT HoaDon.maHD) AS TongHoaDon, COUNT(DISTINCT HoaDon.maKH) AS TongKhachHang "
				+ "from HoaDon  where  Year(NgayLapHD) = ?";
		try {
			String tenSPMuaNhieu = getTenSPMuaNhieuNhatNam(nam);
			stmt = con.prepareStatement(sqlGetDoanhThu);
			stmt.setInt(1, nam);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				tk.setDoanhThu(rs.getLong("TongDoanhThuThang")) ;
				tk.setSoHoaDon(rs.getInt("TongHoaDon"));
				tk.setTongKhach(rs.getInt("TongKhachHang"));
			}
			tk.setTenSPMuaNhieu(tenSPMuaNhieu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tk;
	}
	
	public String getTenSPMuaNhieuNhat( ) {
	Connection con = ConnectDB.getInstance().getConnection();
	PreparedStatement stmt = null;
	String getTen = "";
	String sqlGetMa = "SELECT tenSP FROM SanPham WHERE maSP IN (SELECT TOP 1 maSP "
			+ " FROM ChiTietHoaDon "
			+ " GROUP BY maSP ORDER BY SUM(soLuong) DESC);";
	try {
		stmt = con.prepareStatement(sqlGetMa);
	//	stmt.setInt(1, nam);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			getTen = rs.getString("tenSP");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(stmt);
	}
	return getTen;
}
	
	public ThongKe getThongKe() {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		ThongKe tk = new ThongKe();
		String sqlGetDoanhThu = "SELECT SUM(tongTien) AS TongDoanhThuThang,  COUNT(DISTINCT HoaDon.maHD) AS TongHoaDon, COUNT(DISTINCT HoaDon.maKH) AS TongKhachHang "
				+ "from HoaDon ";
		try {
			String tenSPMuaNhieu = getTenSPMuaNhieuNhat();
			stmt = con.prepareStatement(sqlGetDoanhThu);
//			stmt.setInt(1, nam);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				tk.setDoanhThu(rs.getLong("TongDoanhThuThang")) ;
				tk.setSoHoaDon(rs.getInt("TongHoaDon"));
				tk.setTongKhach(rs.getInt("TongKhachHang"));
			}
			tk.setTenSPMuaNhieu(tenSPMuaNhieu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tk;
	}
	

	  
	public void close(PreparedStatement stmt) {
		if (stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
