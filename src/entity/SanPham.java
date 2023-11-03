package entity;

public class SanPham {
	private String maSP;
	private String tenSP;
	private String tacGia;
	private String maNCC;
	private String loaiSanPham;
	private String moTa;
	private int soLuong;
	private double giaNhap;
	private double giaBan;
	private String maKM;
	private byte[] hinhAnh;

	public SanPham() {

	}

	public SanPham(String maSP, String tenSP, String tacGia, String maNCC, String loaiSanPham, String moTa, int soLuong,
			double giaNhap, double giaBan, String maKM, byte[] hinhAnh) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.tacGia = tacGia;
		this.maNCC = maNCC;
		this.loaiSanPham = loaiSanPham;
		this.moTa = moTa;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.maKM = maKM;
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

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(String loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
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

	public String getMaKM() {
		return maKM;
	}

	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}

	public byte[] getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

}