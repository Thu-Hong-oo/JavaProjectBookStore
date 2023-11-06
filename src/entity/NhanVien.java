package entity;

import java.sql.Date;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien;
	private Date ngaySinh;
	private String gioiTinh;
	private String soDienThoai;
	private String email;
	private String diaChi;
	private String chucVu;
	private String trangThaiLamViec;
	private String trinhDo;
	private String TenDangNhap;
	private String matKhau;
	public NhanVien() {
		super();
	}

	public NhanVien(String maNhanVien, String tenNhanVien, Date ngaySinh, String gioiTinh, String soDienThoai,
			String email, String diaChi, String chucVu, String trangThaiLamViec, String trinhDo, String tenDangNhap,
			String matKhau) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
		this.trangThaiLamViec = trangThaiLamViec;
		this.trinhDo = trinhDo;
		this.TenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	

	public String getMaNhanVien() {
		return maNhanVien;
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
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
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getTrangThaiLamViec() {
		return trangThaiLamViec;
	}
	public void setTrangThaiLamViec(String trangThaiLamViec) {
		this.trangThaiLamViec = trangThaiLamViec;
	}
	public String getTrinhDo() {
		return trinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	
}