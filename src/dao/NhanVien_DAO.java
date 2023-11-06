package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhanVien;

public class NhanVien_DAO {

	public ArrayList<NhanVien> getAllNhanVien() {
		ConnectDB con = ConnectDB.getInstance();
		ArrayList<NhanVien> dsNhanVien = new ArrayList<NhanVien>();
		try {
			con.connect();
			String sql = "SELECT *FROM NhanVien";

			Statement statement = con.getConnection().createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				dsNhanVien.add(
						new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"), rs.getDate("ngaySinh"),
								rs.getString("gioiTinh"), rs.getString("soDienThoai"), rs.getString("email"),
								rs.getString("diaChi"), rs.getString("chucVu"), rs.getString("trangThaiLamViec"),
								rs.getString("trinhDo"), rs.getString("TenDangNhap"), rs.getString("matKhau")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}

	public void themNhanVien(NhanVien nv) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		String sql = "INSERT INTO NhanVien(maNhanVien,tenNhanVien, ngaySinh, gioiTinh, soDienThoai,email, diaChi, chucVu, trangThaiLamViec,trinhDo,TenDangNhap,matKhau)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, nv.getMaNhanVien());
			stmt.setString(2, nv.getTenNhanVien());
			stmt.setDate(3, nv.getNgaySinh());
			stmt.setString(4, nv.getGioiTinh());
			stmt.setString(5, nv.getSoDienThoai());
			stmt.setString(6, nv.getEmail());
			stmt.setString(7, nv.getDiaChi());
			stmt.setString(8, nv.getChucVu());
			stmt.setString(9, nv.getTrangThaiLamViec());
			stmt.setString(10, nv.getTrinhDo());
			stmt.setString(11, nv.getTenDangNhap());
			stmt.setString(12, nv.getMatKhau());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
	}

	public void suaNhanVien(NhanVien nv) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		String sql = "UPDATE NhanVien " + " set tenNhanVien = ?, " + " ngaySinh = ?, " + " gioiTinh = ?, "
				+ " soDienThoai = ?, " + " email = ?, " + " diaChi = ?, " + " chucVu = ?, " + "trangThaiLamViec = ? ,"
				+ " trinhDo=?," + " TenDangNhap=?, " + " matKhau=? where maNhanVien = ?;";
		try {
			stmt = con.prepareStatement(sql);
			// stmt.setString(1, nv.getMaNhanVien());
			stmt.setString(1, nv.getTenNhanVien());
			stmt.setDate(2, nv.getNgaySinh());
			stmt.setString(3, nv.getGioiTinh());
			stmt.setString(4, nv.getSoDienThoai());
			stmt.setString(5, nv.getEmail());
			stmt.setString(6, nv.getDiaChi());
			stmt.setString(7, nv.getChucVu());
			stmt.setString(8, nv.getTrangThaiLamViec());
			stmt.setString(9, nv.getTrinhDo());
			stmt.setString(10, nv.getTenDangNhap());
			stmt.setString(11, nv.getMatKhau());
			stmt.setString(12, nv.getMaNhanVien());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
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
