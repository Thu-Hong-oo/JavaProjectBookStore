package entity;

public class SanPham {
	private String maSP;
	private String tenSP;
	private String tacGia;
	private String tenNCC;
	private String tenDM;
	private String moTa;
	private int soLuong;
	private double giaNhap;
	private double giaBan;
	private String tenKM;
	private byte[] hinhAnh;

	public SanPham() {

	}

	public SanPham(String maSP, String tenSP, String tacGia, String tenNCC, String tenDM, String moTa, int soLuong,
			double giaNhap, double giaBan, String tenKM, byte[] hinhAnh) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.tacGia = tacGia;
		this.tenNCC = tenNCC;
		this.tenDM = tenDM;
		this.moTa = moTa;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.tenKM = tenKM;
		this.hinhAnh = hinhAnh;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String gettenNCC() {
		return tenNCC;
	}

	public void settenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getTenDM() {
		return tenDM;
	}

	public void setTenDM(String tenDM) {
		this.tenDM = tenDM;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public String getTenKM() {
		return tenKM;
	}

	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}

	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

}