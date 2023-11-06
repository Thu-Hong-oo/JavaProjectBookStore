package entity;

public class ThongKe {
	private long doanhThu;
	private int soHoaDon;
	private int tongKhach;
	private long doanhthu;
	public long getDoanhthu() {
		return doanhthu;
	}

	public void setDoanhthu(long doanhthu) {
		this.doanhthu = doanhthu;
	}

	public ThongKe(long doanhThu, int soHoaDon, int tongKhach, long doanhthu2, String tenSPMuaNhieu) {
		super();
		this.doanhThu = doanhThu;
		this.soHoaDon = soHoaDon;
		this.tongKhach = tongKhach;
		doanhthu = doanhthu2;
		this.tenSPMuaNhieu = tenSPMuaNhieu;
	}
	private String tenSPMuaNhieu;
	public ThongKe(long doanhThu, int soHoaDon, int tongKhach, String tenSPMuanNhieu) {
		super();
		this.doanhThu = doanhThu;
		this.soHoaDon = soHoaDon;
		this.tongKhach = tongKhach;
		this.tenSPMuaNhieu = tenSPMuanNhieu;
	}
	
	public ThongKe() {
		super();
	}

	public long getDoanhThu() {
		return doanhThu;
	}
	public void setDoanhThu(long doanhThu) {
		this.doanhThu = doanhThu;
	}
	public int getSoHoaDon() {
		return soHoaDon;
	}
	public void setSoHoaDon(int soHoaDon) {
		this.soHoaDon = soHoaDon;
	}
	public int getTongKhach() {
		return tongKhach;
	}
	public void setTongKhach(int tongKhach) {
		this.tongKhach = tongKhach;
	}
	public String getTenSPMuaNhieu() {
		return tenSPMuaNhieu;
	}
	public void setTenSPMuaNhieu(String tenSPMuaNhieu) {
		this.tenSPMuaNhieu = tenSPMuaNhieu;
	}
	
	
}
