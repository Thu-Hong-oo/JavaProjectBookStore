package view;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.SanPham_DAO;
//import dao.TaiKhoan_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;
//import entity.TaiKhoan;
//import main.MainAdmin;
//import main.MainNhanVien;

import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class BanHangForm extends JPanel {
	private DefaultTableModel modelGioHang;
	private DefaultTableModel modelDanhSach;
	private DefaultTableModel modelPhieuDatHang;
	private DefaultTableModel modelCTPhieuDatHang;
	
	private SanPham_DAO sanPham;
	private KhachHang_DAO khachHang;
	private SanPham selectedSanPham;
	private HoaDon_DAO hoaDon = new HoaDon_DAO();
	private ChiTietHoaDon_DAO ctHD = new ChiTietHoaDon_DAO();
	private ArrayList<SanPham> dsSP = new ArrayList<SanPham>();

	private DefaultTableModel modelKH;
	private JTable tableKH;
	private int soLuongNhap;

	private JTextField txtTenKHThem;
	private JTextField txtMaKHThem;
	private JTextField txtEmail;
	private JTextField txtSoDienThoai;
	private JTextArea txtDiaChi;
	private JButton btThem;
	private JButton btChon;
	private JRadioButton rbNam;
	private JRadioButton rbNu;
	private DefaultTableModel modelVPP;
	private JTable tblGioHang;
	private JTable tblSach;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable tblVPP;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable tblPhieuDatHang;

	/**
	 * Create the panel.
	 */
	public BanHangForm() {
		setSize(960, 660);

		

	
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		// tạo bảng danh sách
		String[] headerDanhSach = { "Mã sách", "Tên sách ", "Tác Giả", "Thể Loại", "Đơn Giá" };
		modelDanhSach = new DefaultTableModel(headerDanhSach, 0);
		
		// tạo bảng VPP
		String[] headerVPP = { "Mã sản phẩm", "Tên Sản Phẩm", "Loại", "Nhà Cung Cấp", "Đơn Giá" };
		modelVPP = new DefaultTableModel(headerVPP, 0);
		
		// tạo bảng giỏ hàng
				String[] headergioHang = { "Mã sản phẩm", "Tên Sản Phẩm", "Đơn giá", "Số lượng", "Thành tiền" };
				modelGioHang = new DefaultTableModel(headergioHang, 0);
		
		JPanel pnlHDNhanh = new JPanel();
		tabbedPane.addTab("Lập Hoá Đơn Nhanh", null, pnlHDNhanh, null);
		
		JPanel pnlLapHoaDonNhanh = new JPanel();
		pnlLapHoaDonNhanh.setBackground(Color.WHITE);
		
		JPanel panelDS = new JPanel();
		panelDS.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 1, true),
		
						new LineBorder(new Color(192, 192, 192), 2, true)));
		panelDS.setBackground(Color.WHITE);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBackground(Color.WHITE);
		GroupLayout gl_panelDS = new GroupLayout(panelDS);
		gl_panelDS.setHorizontalGroup(
			gl_panelDS.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane_1, GroupLayout.PREFERRED_SIZE, 559, Short.MAX_VALUE)
		);
		gl_panelDS.setVerticalGroup(
			gl_panelDS.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDS.createSequentialGroup()
					.addComponent(tabbedPane_1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JPanel pnlDSSach = new JPanel();
		pnlDSSach.setBackground(Color.WHITE);
		tabbedPane_1.addTab("Sách", null, pnlDSSach, null);
		
		JScrollPane scpSach = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tblSach = new JTable(modelDanhSach);
		scpSach.setViewportView(tblSach);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblTmKim = new JLabel("Tìm kiếm ");
		lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox cbbDanhMuc = new JComboBox();
		
		JLabel lblDanhMc = new JLabel("Danh mục");
		lblDanhMc.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_pnlDSSach = new GroupLayout(pnlDSSach);
		gl_pnlDSSach.setHorizontalGroup(
			gl_pnlDSSach.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDSSach.createSequentialGroup()
					.addContainerGap(153, Short.MAX_VALUE)
					.addComponent(lblTmKim, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addGap(73)
					.addComponent(lblDanhMc, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cbbDanhMuc, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
				.addGroup(gl_pnlDSSach.createSequentialGroup()
					.addContainerGap()
					.addComponent(scpSach, GroupLayout.PREFERRED_SIZE, 532, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_pnlDSSach.setVerticalGroup(
			gl_pnlDSSach.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlDSSach.createSequentialGroup()
					.addGap(0)
					.addGroup(gl_pnlDSSach.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTmKim, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbbDanhMuc, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDanhMc, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scpSach, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
					.addContainerGap())
		);
		pnlDSSach.setLayout(gl_pnlDSSach);
		
		JPanel pnlDSVPP = new JPanel();
		tabbedPane_1.addTab("Văn Phòng Phẩm & Quà Lưu Niệm", null, pnlDSVPP, null);
		
		JLabel lblTmKim_1 = new JLabel("Tìm kiếm ");
		lblTmKim_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		tblVPP = new JTable(modelVPP);
		JScrollPane scpVPP = new JScrollPane(tblVPP, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JComboBox cbbDanhMuc_1 = new JComboBox();
		
		JLabel lblDanhMc_1 = new JLabel("Danh mục");
		lblDanhMc_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_pnlDSVPP = new GroupLayout(pnlDSVPP);
		gl_pnlDSVPP.setHorizontalGroup(
			gl_pnlDSVPP.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlDSVPP.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlDSVPP.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlDSVPP.createSequentialGroup()
							.addComponent(scpVPP, GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_pnlDSVPP.createSequentialGroup()
							.addComponent(lblTmKim_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addGap(73)
							.addComponent(lblDanhMc_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(cbbDanhMuc_1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addGap(26))))
		);
		gl_pnlDSVPP.setVerticalGroup(
			gl_pnlDSVPP.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlDSVPP.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnlDSVPP.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTmKim_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlDSVPP.createSequentialGroup()
							.addGap(2)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDanhMc_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlDSVPP.createSequentialGroup()
							.addGap(2)
							.addComponent(cbbDanhMuc_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(scpVPP, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addGap(26))
		);
		
	
		scpVPP.setViewportView(tblVPP);
		pnlDSVPP.setLayout(gl_pnlDSVPP);
		panelDS.setLayout(gl_panelDS);
		
		JPanel panelGioHang = new JPanel();
		panelGioHang.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 1, true),
						new LineBorder(new Color(192, 192, 192), 2, true)));
		panelGioHang.setBackground(Color.WHITE);
		tblGioHang = new JTable(modelGioHang);
		
		JScrollPane scpGioHang = new JScrollPane(tblGioHang, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JButton btnTaoHoaDon = new JButton("Tạo hóa đơn");
		
		JButton btnLamMoiGioHang = new JButton("Làm Mới ");
		
		JButton btnXoaSanPham = new JButton("Xóa");
		GroupLayout gl_panelGioHang = new GroupLayout(panelGioHang);
		gl_panelGioHang.setHorizontalGroup(
			gl_panelGioHang.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 574, Short.MAX_VALUE)
				.addGroup(gl_panelGioHang.createSequentialGroup()
					.addGap(11)
					.addComponent(scpGioHang, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
					.addGap(30)
					.addGroup(gl_panelGioHang.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnTaoHoaDon, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
						.addComponent(btnLamMoiGioHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnXoaSanPham, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelGioHang.setVerticalGroup(
			gl_panelGioHang.createParallelGroup(Alignment.LEADING)
				.addGap(0, 191, Short.MAX_VALUE)
				.addGroup(gl_panelGioHang.createSequentialGroup()
					.addGap(24)
					.addComponent(btnXoaSanPham, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLamMoiGioHang, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(btnTaoHoaDon, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addGap(39))
				.addGroup(gl_panelGioHang.createSequentialGroup()
					.addGap(8)
					.addComponent(scpGioHang, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
					.addContainerGap())
		);
		
	
		scpGioHang.setViewportView(tblGioHang);
		panelGioHang.setLayout(gl_panelGioHang);
		
		JLabel lbCenterGioHang = new JLabel("Giỏ hàng");
		lbCenterGioHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblDanhSchSn = new JLabel("Danh sách sản phẩm");
		lblDanhSchSn.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JButton btnThemSP = new JButton("Thêm sản phẩm");
		GroupLayout gl_pnlHDNhanh = new GroupLayout(pnlHDNhanh);
		gl_pnlHDNhanh.setHorizontalGroup(
			gl_pnlHDNhanh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlHDNhanh.createSequentialGroup()
					.addComponent(pnlLapHoaDonNhanh, GroupLayout.PREFERRED_SIZE, 606, Short.MAX_VALUE)
					.addGap(1))
		);
		gl_pnlHDNhanh.setVerticalGroup(
			gl_pnlHDNhanh.createParallelGroup(Alignment.TRAILING)
				.addComponent(pnlLapHoaDonNhanh, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 621, Short.MAX_VALUE)
		);
		GroupLayout gl_pnlLapHoaDonNhanh = new GroupLayout(pnlLapHoaDonNhanh);
		gl_pnlLapHoaDonNhanh.setHorizontalGroup(
			gl_pnlLapHoaDonNhanh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLapHoaDonNhanh.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_pnlLapHoaDonNhanh.createParallelGroup(Alignment.LEADING)
						.addComponent(lbCenterGioHang, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlLapHoaDonNhanh.createSequentialGroup()
							.addComponent(lblDanhSchSn, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addGap(90)
							.addComponent(btnThemSP))
						.addComponent(panelGioHang, GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
						.addComponent(panelDS, 0, 0, Short.MAX_VALUE))
					.addGap(31))
		);
		gl_pnlLapHoaDonNhanh.setVerticalGroup(
			gl_pnlLapHoaDonNhanh.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLapHoaDonNhanh.createSequentialGroup()
					.addGap(6)
					.addComponent(lbCenterGioHang, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelGioHang, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlLapHoaDonNhanh.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDanhSchSn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnThemSP, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelDS, GroupLayout.PREFERRED_SIZE, 338, GroupLayout.PREFERRED_SIZE)
					.addGap(15))
		);
		pnlLapHoaDonNhanh.setLayout(gl_pnlLapHoaDonNhanh);
		pnlHDNhanh.setLayout(gl_pnlHDNhanh);
		
		JPanel pnlLapHoaDonTuPhieuDat = new JPanel();
		tabbedPane.addTab("Lập Hóa Đơn Từ Phiếu Đặt Hàng", null, pnlLapHoaDonTuPhieuDat, null);
		
		String[] headerPhieuDatHang = { "Mã Phiếu Đặt", "Mã Khánh Hàng ","Mã Nhân Viên ", "SDT", "Địa Chỉ", "Ngày Lập" };
		modelPhieuDatHang = new DefaultTableModel(headerPhieuDatHang,0);
		tblPhieuDatHang = new JTable(modelPhieuDatHang);
		JScrollPane scrPhieuDatHang = new JScrollPane();
		scrPhieuDatHang.setViewportView(tblPhieuDatHang);
		
		JLabel lblPhieuDatHang = new JLabel("Phiếu Đặt Hàng");
		lblPhieuDatHang.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblPhieuDatHang_1 = new JLabel("Chi Tiết Phiếu Đặt Hàng");
		lblPhieuDatHang_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		GroupLayout gl_pnlLapHoaDonTuPhieuDat = new GroupLayout(pnlLapHoaDonTuPhieuDat);
		gl_pnlLapHoaDonTuPhieuDat.setHorizontalGroup(
			gl_pnlLapHoaDonTuPhieuDat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLapHoaDonTuPhieuDat.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlLapHoaDonTuPhieuDat.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPhieuDatHang, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrPhieuDatHang, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPhieuDatHang_1, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_pnlLapHoaDonTuPhieuDat.setVerticalGroup(
			gl_pnlLapHoaDonTuPhieuDat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlLapHoaDonTuPhieuDat.createSequentialGroup()
					.addGap(5)
					.addComponent(lblPhieuDatHang, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrPhieuDatHang, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addComponent(lblPhieuDatHang_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(267, Short.MAX_VALUE))
		);
		
	
		pnlLapHoaDonTuPhieuDat.setLayout(gl_pnlLapHoaDonTuPhieuDat);
		
		JLabel lbDonHang = new JLabel("Hóa đơn");
		lbDonHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JPanel panelDonHang = new JPanel();
		panelDonHang.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 1, true),
								new LineBorder(new Color(192, 192, 192), 2, true)));
		panelDonHang.setBackground(Color.WHITE);
		
		JLabel lblTinKhcha = new JLabel("Tiền khách đưa:");
		lblTinKhcha.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		
		JLabel lbVND_3 = new JLabel("VND");
		lbVND_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		JLabel lblTinTha = new JLabel("Tiền thừa:");
		lblTinTha.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lbThanhToan_1 = new JLabel("");
		
		JLabel lblTienThua = new JLabel("");
		
		JLabel lbVND_5 = new JLabel("VND");
		lbVND_5.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		JComboBox cmbHinhThucThanhToan = new JComboBox();
		
		JLabel lblHnhThcThanh = new JLabel("Hình thức thanh toán:");
		lblHnhThcThanh.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnXuatHoaDon = new JButton("Xuất Hóa Đơn");
		btnXuatHoaDon.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		JButton btLamMoiHD = new JButton("Làm mới");
		btLamMoiHD.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		JPanel panelDonHang_1 = new JPanel();
		panelDonHang_1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 1, true),
								new LineBorder(new Color(192, 192, 192), 2, true)));
		panelDonHang_1.setBackground(Color.WHITE);
		
		JLabel lbMaKH = new JLabel("Mã KH:");
		lbMaKH.setBounds(6, 6, 50, 25);
		lbMaKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lbTenKH = new JLabel("Tên KH:");
		lbTenKH.setBounds(6, 43, 50, 25);
		lbTenKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_1 = new JTextField("");
		textField_1.setBounds(56, 4, 169, 28);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField("");
		textField_2.setBounds(56, 41, 169, 28);
		textField_2.setColumns(10);
		
		JLabel lblNgyTo = new JLabel("Ngày tạo:");
		lblNgyTo.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JDateChooser dateChooserNgaytao = new JDateChooser();
		
		JLabel lbma = new JLabel("Mã hóa đơn:");
		lbma.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblHienThiMaHD = new JLabel("");
		
		JLabel lbtogtin = new JLabel("Tổng tiền:");
		lbtogtin.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblTongTien = new JLabel("");
		
		JLabel lbVND = new JLabel("VND");
		lbVND.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		JLabel lblGhiCh = new JLabel("Ghi chú");
		lblGhiCh.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JTextArea textAreaGhiChu = new JTextArea();
		textAreaGhiChu.setLineWrap(true);
		textAreaGhiChu.setBackground(Color.WHITE);
		
		JButton btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.setFont(new Font("SansSerif", Font.BOLD, 20));
		GroupLayout gl_panelDonHang = new GroupLayout(panelDonHang);
		gl_panelDonHang.setHorizontalGroup(
			gl_panelDonHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDonHang.createSequentialGroup()
					.addGroup(gl_panelDonHang.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panelDonHang.createSequentialGroup()
							.addGap(1)
							.addGap(12)
							.addComponent(lblTinKhcha)
							.addGap(10)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addGap(14)
							.addComponent(lbVND_3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
							.addGap(20))
						.addGroup(Alignment.LEADING, gl_panelDonHang.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_panelDonHang.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelDonHang.createSequentialGroup()
									.addComponent(lblTinTha, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(20)
									.addComponent(lbThanhToan_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelDonHang.createSequentialGroup()
									.addGap(107)
									.addComponent(lblTienThua, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelDonHang.createSequentialGroup()
									.addGap(255)
									.addComponent(lbVND_5, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblHnhThcThanh, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelDonHang.createSequentialGroup()
									.addGap(151)
									.addGroup(gl_panelDonHang.createParallelGroup(Alignment.TRAILING)
										.addComponent(btLamMoiHD, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
										.addComponent(cmbHinhThucThanhToan, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))))
							.addGap(7))
						.addGroup(Alignment.LEADING, gl_panelDonHang.createSequentialGroup()
							.addGap(22)
							.addComponent(btnXuatHoaDon, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDonHang.createSequentialGroup()
							.addGap(3)
							.addComponent(panelDonHang_1, GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
						.addGroup(gl_panelDonHang.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_panelDonHang.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panelDonHang.createSequentialGroup()
									.addComponent(lblNgyTo, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
									.addComponent(dateChooserNgaytao, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelDonHang.createSequentialGroup()
									.addGroup(gl_panelDonHang.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelDonHang.createSequentialGroup()
											.addComponent(lbma, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblHienThiMaHD, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelDonHang.createSequentialGroup()
											.addComponent(lbtogtin, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
											.addGap(10)
											.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
											.addGap(14)
											.addComponent(lbVND, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)))
									.addGap(18)))))
					.addGap(1))
				.addGroup(gl_panelDonHang.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGhiCh, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textAreaGhiChu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
				.addGroup(gl_panelDonHang.createSequentialGroup()
					.addGap(70)
					.addComponent(btnThanhToan, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		gl_panelDonHang.setVerticalGroup(
			gl_panelDonHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDonHang.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelDonHang_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelDonHang.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooserNgaytao, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNgyTo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelDonHang.createParallelGroup(Alignment.LEADING)
						.addComponent(lbma, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHienThiMaHD, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelDonHang.createParallelGroup(Alignment.LEADING)
						.addComponent(lbtogtin, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbVND))
					.addGap(5)
					.addGroup(gl_panelDonHang.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTinKhcha, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbVND_3))
					.addGap(5)
					.addGroup(gl_panelDonHang.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTinTha, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelDonHang.createSequentialGroup()
							.addGap(24)
							.addComponent(lbThanhToan_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTienThua, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbVND_5)
						.addGroup(gl_panelDonHang.createSequentialGroup()
							.addGap(30)
							.addComponent(cmbHinhThucThanhToan, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDonHang.createSequentialGroup()
							.addGap(30)
							.addComponent(lblHnhThcThanh, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_panelDonHang.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGhiCh, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textAreaGhiChu, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelDonHang.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnXuatHoaDon, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
						.addComponent(btLamMoiHD, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addComponent(btnThanhToan)
					.addGap(128))
		);
		panelDonHang_1.setLayout(null);
		panelDonHang_1.add(lbMaKH);
		panelDonHang_1.add(lbTenKH);
		panelDonHang_1.add(textField_2);
		panelDonHang_1.add(textField_1);
		
		JButton btThayDoi = new JButton("Thay đổi");
		btThayDoi.setBounds(235, 25, 115, 28);
		panelDonHang_1.add(btThayDoi);
		panelDonHang.setLayout(gl_panelDonHang);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 580, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addComponent(lbDonHang, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panelDonHang, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lbDonHang, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panelDonHang, GroupLayout.PREFERRED_SIZE, 613, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 649, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		setLayout(groupLayout);
	}

	private void initComponent() {

	}
}
//		btXoaTatCa.addActionListener(this);
//		btXoaSanPham.addActionListener(this);
//		btTao.addActionListener(this);
//		btHuyDonHang.addActionListener(this);
//		btLamMoi.addActionListener(this);
//		btThanhToan.addActionListener(this);
//		cbbDanhMuc.addActionListener(this);
//		cbbHinhThucGiaoHang.addActionListener(this);
//		tableDanhSach.addMouseListener(this);
//		txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
//
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				findData();
//
//			}
//
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				findData();
//
//			}
//
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				findData();
//
//			}
//
//			private void findData() {
//				//loadDataTable();
//				
//				String text = txtTimKiem.getText().trim();
//
//				DefaultTableModel model = (DefaultTableModel) tableDanhSach.getModel();
//
//				// Tạo một bộ lọc để lấy các dòng có giá trị maNV trùng với text
//				RowFilter<Object, Object> filter = RowFilter.regexFilter(text, 0);
//
//				// Tạo một sorter để sắp xếp lại các dòng
//				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
//				sorter.setRowFilter(filter);
//
//				// Đặt sorter cho bảng
//				tableDanhSach.setRowSorter(sorter);
//			}
//		});
//		txtTimKiem.addFocusListener(new FocusListener() {
//		    @Override
//		    public void focusGained(FocusEvent e) {
//		        // Xử lý khi TextField nhận focus
//		        cbbDanhMuc.setSelectedIndex(-1); // Đặt ComboBox về trạng thái null
//		        loadDataTable();
//		    }
//
//		    @Override
//		    public void focusLost(FocusEvent e) {
//		        // Xử lý khi TextField mất focus (không nhận focus nữa)
//		    }
//		});
//		lbTienThua.addPropertyChangeListener(new PropertyChangeListener() {
//			@Override
//			public void propertyChange(PropertyChangeEvent evt) {
//				if (evt.getPropertyName().equals("text")) {
//					// Lấy giá trị của lbTienThua
//					String tienThuaText = lbTienThua.getText();
//					if (!tienThuaText.isEmpty()) {
//						long tienThua = Long.parseLong(tienThuaText);
//
//						// Kiểm tra nếu giá trị của lbTienThua âm thì khóa button thanh toán
//						if (tienThua < 0) {
//							btThanhToan.setEnabled(false);
//						} else {
//							btThanhToan.setEnabled(true);
//						}
//					}
//
//				}
//			}
//		});
//
//	}
//
//	private void loadDataTable() {
//		try {
//
//			for (SanPham sp : sanPham.getAllSanPham()) {
//				Object[] row = { sp.getMaSanPham(), sp.getTenSanPham(), sp.getDanhMuc(), sp.getGiaBan(),
//						sp.getSoLuong() };
//				modelDanhSach.addRow(row);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Object o = e.getSource();
//		if (o.equals(btTao))
//			taoHoaDon();
//		else if (o.equals(btXoaSanPham))
//			xoaSanPham();
//		else if (o.equals(btXoaTatCa))
//			xoaTatCa();
//		else if (o.equals(btThanhToan))
//			thanhToan();
//		else if (o.equals(btLamMoi))
//			lamMoi();
//		else if (o.equals(btHuyDonHang))
//			huyDonHang();
//		else if (o.equals(cbbDanhMuc)) {
//			String tenDM = (String) cbbDanhMuc.getSelectedItem();
//
//			filterSanPhamByDanhMuc(tenDM);
//		} else if (o.equals(cbbHinhThucGiaoHang)) {
//			String giaoHang = (String) cbbHinhThucGiaoHang.getSelectedItem();
//			tinhPhiShip(giaoHang);
//		}
//
//	}
//
//	private void xoaSanPham() {
//		int i = tableGioHang.getSelectedRow();
//		if (i != -1) {
//			modelGioHang.removeRow(i);
//		}
//	}
//
//	private void xoaTatCa() {
//		modelGioHang.setRowCount(0);
//	}
//
//	private void updateTable(ArrayList<SanPham> dsSanPhamLoc) {
//		DefaultTableModel model = (DefaultTableModel) tableDanhSach.getModel();
//		model.setRowCount(0); // Xóa các dòng hiện tại trong bảng
//
//		for (SanPham sp : dsSanPhamLoc) {
//			Object[] row = { sp.getMaSanPham(), sp.getTenSanPham(), sp.getDanhMuc(), sp.getGiaBan(), sp.getSoLuong() };
//			model.addRow(row);
//		}
//	}
//
//	private void filterSanPhamByDanhMuc(String danhMuc) {
//		ArrayList<SanPham> dsSP = sanPham.getAllSanPham();
//		ArrayList<SanPham> dsSPLoc = new ArrayList<>();
//
//		for (SanPham sp : dsSP) {
//			if (sp.getDanhMuc().equals(danhMuc)) {
////				System.out.println(sp.getDanhMuc());
//				dsSPLoc.add(sp);
//			}
//		}
//
//		updateTable(dsSPLoc);
//		lamMoi();
//	}

//	private void lamMoi() {
//		lbHienThiMaHD.setText("");
//		lbTongTien.setText("");
//		lbTongTien.setText("");
//		txtTienKhachDua.setText("");
//		lbTienThua.setText("");
//		cbbHinhThucGiaoHang.setSelectedItem(null);
//		cbbHinhThucThanhToan.setSelectedItem(null);
//		dateChooserNgaytao.setDate(null);
//		textAreaGhiChu.setText("");
//		modelGioHang.setRowCount(0);
//
//	}
//
//	private void taoHoaDon() {
//		// Thiết lập ngày giờ hiện tại cho dateChooserNgaytao
//		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		Date currentDate = new Date();
//		String formattedDate = format.format(currentDate);
//		dateChooserNgaytao.setDate(currentDate);
//
//		hoaDon = new HoaDon_DAO();
//		lbHienThiMaHD.setText(hoaDon.taoMaHoaDon());
//		long tongTien = 0;
//		for (int i = 0; i < tableGioHang.getRowCount(); i++) {
//			int soLuongNhap = (int) tableGioHang.getValueAt(i, 2);
//			long donGia = (long) tableGioHang.getValueAt(i, 1);
//			tongTien += soLuongNhap * donGia;
//		}
//		// Đặt giá trị của tongTien vào ô lbTongTien
//		lbTongTien.setText(Long.toString(tongTien));
//
//		String tienKhachDuaText = txtTienKhachDua.getText();
//		// Thêm sự kiện focus lost cho txtTienKhachDua
//		txtTienKhachDua.addFocusListener(new FocusAdapter() {
//			@Override
//			public void focusLost(FocusEvent e) {
//				// Tính toán tiền thừa và hiển thị lên lbTienThua
//				try {
//
//					long tienKhachDua = Long.parseLong(txtTienKhachDua.getText());
//					long tongTien = Long.parseLong(lbTongTien.getText());
//					long tienThua = tienKhachDua - tongTien;
//					lbTienThua.setText(Long.toString(tienThua));
//				} catch (NumberFormatException ex) {
//					// Nếu nhập không đúng định dạng số, không làm gì cả
//				}
//			}
//		});
//
//		if (!tienKhachDuaText.isEmpty()) {
//			// Kiểm tra nếu tiền thừa âm thì hiển thị thông báo và không cho phép thanh toán
//			if (Long.parseLong(lbTienThua.getText()) < 0) {
//				JOptionPane.showMessageDialog(null, "Tiền khách đưa không đủ.");
//				btThanhToan.setEnabled(false);
//				return;
//			}
//		}
//	}
//
//	private void taoDSChiTietHD() {
//		String maHD = lbHienThiMaHD.getText();
//		for (int i = 0; i < tableGioHang.getRowCount(); i++) {
//			String maSP = tableGioHang.getValueAt(i, 0).toString();
//			String donGia = tableGioHang.getValueAt(i, 1).toString();
//			String soLuong = tableGioHang.getValueAt(i, 2).toString();
//			String thanhTien = tableGioHang.getValueAt(i, 3).toString();
//			ChiTietHoaDon cthd = new ChiTietHoaDon(maHD, maSP, Long.parseLong(donGia), Integer.parseInt(soLuong),
//					Long.parseLong(thanhTien));
//			ctHD.themChiTietHD(cthd);
//
//		}
//	}
//
//	private HoaDon revertHoaDonFromTXT() {
//		HoaDon hd = null;
//		String maHD = lbHienThiMaHD.getText();
//		String maKH = txtMaKH.getText();
//		MainNhanVien mainNhanVien = new MainNhanVien();
//		String maNV = mainNhanVien.getMaNV();
//		Long tongTien = Long.parseLong(lbTongTien.getText());
//		Long tienDua = Long.parseLong(txtTienKhachDua.getText());
//		Long tienThua = Long.parseLong(lbTienThua.getText());
//		String hTTT = cbbHinhThucThanhToan.getSelectedItem().toString();
//		String hTGH = cbbHinhThucGiaoHang.getSelectedItem().toString();
//		Date ngayLap = dateChooserNgaytao.getDate();
//		String ghiChu = textAreaGhiChu.getText();
//		hd = new HoaDon(maHD, maKH, maNV, tongTien, tienDua, tienThua, hTTT, hTGH, new java.sql.Date(ngayLap.getTime()),
//				ghiChu);
//		return hd;
//
//	}
//
//	private void thanhToan() {
//
//		if (lbHienThiMaHD.getText().equals("") || txtTienKhachDua.getText().equals("")) {
//			JOptionPane.showMessageDialog(null, "Tạo hóa đơn trước khi thanh toán");
//			return;
//		} else {
//			HoaDon hd = revertHoaDonFromTXT();
//			sanPham.capNhatSoLuong('-', soLuongNhap, selectedSanPham.getMaSanPham());
//			loadDataTable();
//			hoaDon.themHoaDon(hd);
//			taoDSChiTietHD();
//			JOptionPane.showMessageDialog(null, "Đã tạo một hóa đơn mới thành công");
//		}
//	}
//
//	private void tinhPhiShip(String giaoHang) {
//		String tongTienText = lbTongTien.getText();
//		String tienKhachDuaText = txtTienKhachDua.getText();
//		if (tongTienText.isEmpty() || tienKhachDuaText.isEmpty())
//			return;
//		else {
//			long tongTien = Long.parseLong(tongTienText);
//			long tienKhachDua = Long.parseLong(tienKhachDuaText);
//			long tienThua = 0;
//			String ghiChu = "";
//			long phiShip = 0;
//			if (giaoHang.equals("Giao hàng tận nơi")) {
//				if (tongTien < 300000) {
//					phiShip = 30000;
//					ghiChu = "Ship 30k";
//					tienThua = tienKhachDua - (tongTien + phiShip);
//				} else if (tongTien < 500000) {
//					phiShip = 20000;
//					ghiChu = "Ship 20k";
//					tienThua = tienKhachDua - (tongTien + phiShip);
//				} else if (tongTien < 1000000) {
//					phiShip = 10000;
//					ghiChu = "Ship 10k";
//					tienThua = tienKhachDua - (tongTien + phiShip);
//				} else {
//					ghiChu = "Miễn phí ship";
//					tienThua = tienKhachDua - tongTien;
//				}
//				if (tongTien >= 2000000) {
//					ghiChu += ", Tặng mã giảm 50k";
//					tienThua += 50000;
//				}
//
//			}
//
//			else if (giaoHang.equals("Lấy tại cửa hàng")) {
//				ghiChu = "";
//				tienThua = tienKhachDua - tongTien;
//			}
//			lbTienThua.setText(Long.toString(tienThua));
//			textAreaGhiChu.setText(ghiChu);
//
//		}
//
//	}
//
//	private void huyDonHang() {
//		if (lbHienThiMaHD.getText().equals(""))
//			JOptionPane.showMessageDialog(null, "Chỉ hủy đơn hàng vừa được tạo", "ERROR", JOptionPane.ERROR_MESSAGE);
//		else {
//			hoaDon.xoaHoaDon(lbHienThiMaHD.getText());
//			lamMoi();
//		}
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		Object o = e.getSource();
//		if(o.equals(txtTimKiem))
//			cbbDanhMuc.setSelectedItem(null);
//
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void propertyChange(PropertyChangeEvent evt) {
//		// TODO Auto-generated method stub
//
//	}
//
//	private void showMess(String mess, JTextField txt) {
//		txt.requestFocus();
//		JOptionPane.showMessageDialog(null, mess);
//
//	}
//
//	private boolean kiemTra() {
//		String maKH = txtMaKHThem.getText().trim();
//		String tenKH = txtTenKHThem.getText().trim();
//		String soDienThoai = txtSoDienThoai.getText().trim();
//		String email = txtEmail.getText().trim();
//		String diaChi = txtDiaChi.getText().trim();
//
//		if (maKH.length() < 0 || !maKH.matches("^KH\\d{3}")) {
//			showMess("Cú pháp mã KH phải là KH\\d{3} ", txtMaKHThem);
//			return false;
//		}
//		if (tenKH.length() < 0 || !tenKH.matches("^[A-Z]\\p{L}+(\\s[A-Z]\\p{L}*)+")) {
//			showMess("Tên khách hàng không hợp lệ ", txtTenKHThem);
//			return false;
//		}
//		if (soDienThoai.length() < 0 || !soDienThoai.matches("^0\\d{9,10}")) {
//			showMess("Số điện thoại không hợp lệ ", txtSoDienThoai);
//			return false;
//		}
//		if (email.length() < 0 || !email.matches("[a-z]\\w+@(gmail|yahoo|iuh)\\.com")) {
//			showMess(" Email không hợp lệ ", txtEmail);
//			return false;
//		}
//		if (diaChi.isEmpty()) {
//			JOptionPane.showMessageDialog(txtDiaChi, "Chưa nhập địa chỉ");
//			return false;
//		}
//		return true;
//	}
//	private boolean checkExist() {
//		String maKH = txtMaKHThem.getText().trim();
//		if (true) {
//			DefaultTableModel model = (DefaultTableModel) tableKH.getModel();
//			boolean isMaKHTrung = false;
//			for (int i = 0; i < model.getRowCount(); i++) {
//				String maKHTable = model.getValueAt(i, 0).toString();
//				if (maKHTable.equals(maKH)) {
//					isMaKHTrung = true;
//					break;
//				}
//			}
//			if (isMaKHTrung) {
//				showMess("Mã khách hàng đã tồn tại trong danh sách", txtMaKHThem);
//				return false;
//			}
//		}
//		return true;
//	}
//
//	private boolean themKH() {
//		KhachHang k = layKH();
//		if ( checkExist() && kiemTra()) {
//			String[] row = { k.getMaKH(), k.getTenKH(), k.getGioiTinh(), k.getDiaChi(), k.getSDT(), k.getEmail() };
//			modelKH.addRow(row);
//			khachHang.themKH(k);
//			JOptionPane.showMessageDialog(null, "Thêm thành công");
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	private KhachHang layKH() {
//		String maKH = txtMaKHThem.getText().trim();
//		String tenKH = txtTenKHThem.getText();
//		String gioiTinh = "";
//		if (rbNam.isSelected()) {
//			gioiTinh = "Nam";
//		} else {
//			gioiTinh = "Nữ";
//		}
//		String soDienThoai = txtSoDienThoai.getText().trim();
//		String email = txtEmail.getText().trim();
//		String diaChi = txtDiaChi.getText();
//
//		KhachHang k = new KhachHang(maKH, tenKH, gioiTinh, diaChi, soDienThoai, email);
//		return k;
//	}
//}
