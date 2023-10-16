package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.SanPham;

public class SanPham_DAO {
	ConnectDB con = ConnectDB.getInstance();


    // Thêm sản phẩm vào cơ sở dữ liệu
    public boolean themSanPham(SanPham sanPham) {
    	Connection con = ConnectDB.getInstance().getConnection();
    	PreparedStatement statement = null;
    	String sql = "INSERT INTO SanPham (maSanPham, tenSanPham, tacGia, nhaCungCap, loai, moTa, hinhAnh, giaNhap, giaBan, soLuong) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            statement.setString(1, sanPham.getMaSanPham());
            statement.setString(2, sanPham.getTenSanPham());
            statement.setString(3, sanPham.getTacGia());
            statement.setString(4, sanPham.getNhaCungCap());
            statement.setString(5, sanPham.getLoai());
            statement.setString(6, sanPham.getMoTa());
            statement.setBytes(7, sanPham.getHinhAnh());
            statement.setDouble(8, sanPham.getGiaNhap());
            statement.setDouble(9, sanPham.getGiaBan());
            statement.setInt(10, sanPham.getSoLuong());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật thông tin sản phẩm
    public boolean capNhatSanPham(SanPham sanPham) {
        String sql = "UPDATE SanPham SET tenSanPham = ?, tacGia = ?, nhaCungCap = ?, loai = ?, moTa = ?, hinhAnh = ?, giaNhap = ?, giaBan = ?, soLuong = ? WHERE maSanPham = ?";
        Connection con = ConnectDB.getInstance().getConnection();
    	PreparedStatement statement = null;
        try {
            statement.setString(1, sanPham.getTenSanPham());
            statement.setString(2, sanPham.getTacGia());
            statement.setString(3, sanPham.getNhaCungCap());
            statement.setString(4, sanPham.getLoai());
            statement.setString(5, sanPham.getMoTa());
            statement.setBytes(6, sanPham.getHinhAnh());
            statement.setDouble(7, sanPham.getGiaNhap());
            statement.setDouble(8, sanPham.getGiaBan());
            statement.setInt(9, sanPham.getSoLuong());
            statement.setString(10, sanPham.getMaSanPham());

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Xóa sản phẩm dựa trên mã sản phẩm
    public boolean xoaSanPham(String maSanPham) {
        String sql = "DELETE FROM SanPham WHERE maSanPham = ?";
        Connection con = ConnectDB.getInstance().getConnection();
    	PreparedStatement statement = null;
        try  {
            statement.setString(1, maSanPham);

            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<SanPham> getAllSanPham() {
        List<SanPham> danhSachSanPham = new ArrayList<SanPham>();
        try {
            con.connect();
            String sql = "SELECT * FROM SanPham";
            Statement statement = con.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                danhSachSanPham.add(new SanPham(rs.getString("maSanPham"), rs.getString("tenSanPham"),
                        rs.getString("tacGia"), rs.getString("nhaCungCap"),
                        rs.getString("loai"), rs.getString("moTa"), rs.getBytes("hinhAnh"), rs.getDouble("giaNhap"), rs.getDouble("giaBan"), rs.getInt("SoLuong")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachSanPham;
    }

}
