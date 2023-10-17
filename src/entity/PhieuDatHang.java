package entity;

import java.sql.Date;

public class PhieuDatHang {
	private String maPhieuDatHang;
	private String maKH;
	private String maNV;
	private Date NgayLap;
	private String GhiChu;
	public PhieuDatHang(String maPhieuDatHang, String maKH, String maNV, Date ngayLap, String ghiChu) {
		super();
		this.maPhieuDatHang = maPhieuDatHang;
		this.maKH = maKH;
		this.maNV = maNV;
		NgayLap = ngayLap;
		GhiChu = ghiChu;
	}
	public PhieuDatHang() {
		super();
	}
	public String getMaPhieuDatHang() {
		return maPhieuDatHang;
	}
	public void setMaPhieuDatHang(String maPhieuDatHang) {
		this.maPhieuDatHang = maPhieuDatHang;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public Date getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(Date ngayLap) {
		NgayLap = ngayLap;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	
	

}
