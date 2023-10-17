package entity;

public class NhaCungCap {
	private String maNCC;
	private String tenNCC;
	private String Sdt;
	private String email;
	private String diaChi;
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public String getSdt() {
		return Sdt;
	}
	public void setSdt(String sdt) {
		this.Sdt = sdt;
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
	public NhaCungCap(String maNCC, String tenNCC, String sdt, String email, String diaChi) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.Sdt = sdt;
		this.email = email;
		this.diaChi = diaChi;
	}
	public NhaCungCap() {
		super();
	}
	
	

}
