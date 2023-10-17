package entity;

import java.sql.Date;

public class KhuyenMai {
	private String maKH;
	private String maSP;
	private int chietKhau;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	public KhuyenMai(String maKH, String maSP, int chietKhau, Date ngayBatDau, Date ngayKetThuc) {
		super();
		this.maKH = maKH;
		this.maSP = maSP;
		this.chietKhau = chietKhau;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}
	public KhuyenMai() {
		super();
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public int getChietKhau() {
		return chietKhau;
	}
	public void setChietKhau(int chietKhau) {
		this.chietKhau = chietKhau;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	
	

}
