package entity;

import java.sql.Date;

public class KhachHang {
	private String maKhachHang;
	private String tenKhachHang;
	private Date ngaySinh;
	private String gioiTinh;
	private String soDienThoai;
	private String email;
	private String diaChi;
	public KhachHang() {
	private String ngaySinh;
	public KhachHang(String maKH, String tenKH, String gioiTinh, String diaChi, String sDT, String email,
			String ngaySinh) {
		super();
	}
	public KhachHang(String maKhachHang, String tenKhachHang, Date ngaySinh, String gioiTinh, String soDienThoai, String email,
			String diaChi) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
	}
	public String getmaKhachHang() {
		return maKhachHang;
	}
	public void setmaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String gettenKhachHang() {
		return tenKhachHang;

		SDT = sDT;
		this.email = email;
		this.ngaySinh = ngaySinh;
	}
	public String getMaKH() {
		return maKH;
	}
	public void settenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	
	
	
}
