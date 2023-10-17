package entity;

public class ChiTietPhieuDatHang {
  private String maPhieuDatHang;
  private String maSP;
  private int soLuong;
  private double donGia;
public ChiTietPhieuDatHang(String maPhieuDatHang, String maSP, int soLuong, double donGia) {
	super();
	this.maPhieuDatHang = maPhieuDatHang;
	this.maSP = maSP;
	this.soLuong = soLuong;
	this.donGia = donGia;
}
public ChiTietPhieuDatHang() {
	super();
}
public String getMaPhieuDatHang() {
	return maPhieuDatHang;
}
public void setMaPhieuDatHang(String maPhieuDatHang) {
	this.maPhieuDatHang = maPhieuDatHang;
}
public String getMaSP() {
	return maSP;
}
public void setMaSP(String maSP) {
	this.maSP = maSP;
}
public int getSoLuong() {
	return soLuong;
}
public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}
public double getDonGia() {
	return donGia;
}
public void setDonGia(double donGia) {
	this.donGia = donGia;
}
  
}
