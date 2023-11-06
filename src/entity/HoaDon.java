package entity;

import java.sql.Date;

public class HoaDon {
    private String maHD;
    private String maKH;
    private String maNV;
    private Date ngayLapHD;
    private long tongTien;
    private String ghiChu;
	public HoaDon(String maHD, String maKH, String maNV, Date ngayLapHD, long tongTien, String ghiChu) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayLapHD = ngayLapHD;
		this.tongTien = tongTien;
		this.ghiChu = ghiChu;
	}
	public HoaDon() {
		super();
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
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
	public Date getNgayLapHD() {
		return ngayLapHD;
	}
	public void setNgayLapHD(Date ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public long getTongTien() {
		return tongTien;
	}
	public void setTongTien(long tongTien) {
		this.tongTien = tongTien;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
    
}
