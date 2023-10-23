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
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtTienKhachDua;
	private JTextField txtTimKiemSach;
	private JComboBox<String> cmbHinhThucThanhToan;
	private JTextArea textAreaGhiChu;
	private JTable tableGioHang;
	private DefaultTableModel modelGioHang;
	private DefaultTableModel modelDanhSach;
	private SanPham_DAO sanPham;
	private KhachHang_DAO khachHang;
	private SanPham selectedSanPham;
	private JComboBox cbbDanhMuc;
	private HoaDon_DAO hoaDon = new HoaDon_DAO();
	private ChiTietHoaDon_DAO ctHD = new ChiTietHoaDon_DAO();
	private ArrayList<SanPham> dsSP = new ArrayList<SanPham>();

	private DefaultTableModel modelKH;
	private JTable tableKH;
	private JButton btnXoaSanPham, btnTaoHoaDon, btnXuatHoaDon, btLamMoiHD, btnThanhToan;
	private JDateChooser dateChooserNgaytao;
	private JLabel lblHienThiMaHD, lblTongTien, lblTienThua;
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
	private JTable tblSach;

	private JButton btThayDoi;
	private JButton btnLamMoiGioHang;
	private JButton btnThemSP;
	private JTextField textField;
	private JTable tblVPP;
	private DefaultTableModel modelVPP;

	/**
	 * Create the panel.
	 */
	public BanHangForm() {
		setSize(960, 660);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);

		JLabel lbCenterGioHang = new JLabel("Giỏ hàng");
		lbCenterGioHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		JPanel panelGioHang = new JPanel();
		panelGioHang.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 1, true),
				new LineBorder(new Color(192, 192, 192), 2, true)));
		panelGioHang.setBackground(Color.WHITE);

		// Buttton in panel Giỏ Hàng
		btnXoaSanPham = new JButton("Xóa");
		btnXoaSanPham.setIcon(new ImageIcon(BanHangForm.class.getResource("/icon/delete.png")));

		btnTaoHoaDon = new JButton("Tạo hóa đơn");
		btnTaoHoaDon.setIcon(new ImageIcon(BanHangForm.class.getResource("/icon/add.png")));

		btnLamMoiGioHang = new JButton("Làm Mới ");
		btnLamMoiGioHang.setIcon(new ImageIcon(BanHangForm.class.getResource("/icon/refresh.png")));

		// Hóa đơn
		JLabel lbDonHang = new JLabel("Hóa đơn");
		lbDonHang.setFont(new Font("Tahoma", Font.BOLD, 15));
		JPanel panelDonHang = new JPanel();
		panelDonHang.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 1, true),
				new LineBorder(new Color(192, 192, 192), 2, true)));
		panelDonHang.setBackground(Color.WHITE);
		JPanel panelDonHang_1 = new JPanel();
		panelDonHang_1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 1, true),
				new LineBorder(new Color(192, 192, 192), 2, true)));
		panelDonHang_1.setBackground(Color.WHITE);
		JLabel lbMaKH = new JLabel("Mã KH:");
		lbMaKH.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel lbTenKH = new JLabel("Tên KH:");
		lbTenKH.setFont(new Font("Tahoma", Font.BOLD, 12));

		btThayDoi = new JButton("Thay đổi");
		btThayDoi.setIcon(new ImageIcon(BanHangForm.class.getResource("/icon/edit.png")));
		txtMaKH = new JTextField("KH000");
		txtMaKH.setColumns(10);
		txtTenKH = new JTextField("Khách bán lẻ");
		txtTenKH.setColumns(10);

		JLabel lbma = new JLabel("Mã hóa đơn:");
		lbma.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHienThiMaHD = new JLabel("");
		JLabel lbtogtin = new JLabel("Tổng tiền:");
		lbtogtin.setFont(new Font("Tahoma", Font.BOLD, 12));
		JLabel lbVND = new JLabel("VND");
		lbVND.setFont(new Font("SansSerif", Font.BOLD, 12));
		JLabel lblTinKhcha = new JLabel("Tiền khách đưa:");
		lblTinKhcha.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lbVND_3 = new JLabel("VND");
		lbVND_3.setFont(new Font("SansSerif", Font.BOLD, 12));

		JLabel lblTinTha = new JLabel("Tiền thừa:");
		lblTinTha.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblHnhThcThanh = new JLabel("Hình thức thanh toán:");
		lblHnhThcThanh.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblGhiCh = new JLabel("Ghi chú");
		lblGhiCh.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lbVND_5 = new JLabel("VND");
		lbVND_5.setFont(new Font("SansSerif", Font.BOLD, 12));

		txtTienKhachDua = new JTextField();
		txtTienKhachDua.setHorizontalAlignment(SwingConstants.LEFT);
		txtTienKhachDua.setColumns(10);

		lblTongTien = new JLabel("");

		lblTienThua = new JLabel("");

		cmbHinhThucThanhToan = new JComboBox();
		cmbHinhThucThanhToan
				.setModel(new DefaultComboBoxModel<>(new String[] { "Thẻ", "Ví điện tử", "Chuyển khoản", "Tiền mặt" }));
		cmbHinhThucThanhToan.setSelectedItem(null);

		textAreaGhiChu = new JTextArea();
		textAreaGhiChu.setLineWrap(true);
		textAreaGhiChu.setBackground(SystemColor.window);

		btnXuatHoaDon = new JButton("Xuất Hóa Đơn");

		btnXuatHoaDon.setFont(new Font("SansSerif", Font.BOLD, 12));

		btLamMoiHD = new JButton("Làm mới");
		btLamMoiHD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btLamMoiHD.setFont(new Font("SansSerif", Font.BOLD, 12));

		btnThanhToan = new JButton("THANH TOÁN");
		btnThanhToan.setIcon(new ImageIcon(BanHangForm.class.getResource("/icon/5.1.png")));

		btnThanhToan.setFont(new Font("SansSerif", Font.BOLD, 20));

		JLabel lblNgyTo = new JLabel("Ngày tạo:");
		lblNgyTo.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lbThanhToan_1 = new JLabel("");

		dateChooserNgaytao = new JDateChooser();
		dateChooserNgaytao.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
//		MainNhanVien mainnv = new MainNhanVien();
//

		// panel Danh Sách
		JPanel panelDS = new JPanel();
		panelDS.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 1, true),

				new LineBorder(new Color(192, 192, 192), 2, true)));
		panelDS.setBackground(Color.WHITE);

		JLabel lblDanhSchSn = new JLabel("Danh sách sản phẩm");
		lblDanhSchSn.setFont(new Font("Tahoma", Font.BOLD, 15));

		// tạo bảng giỏ hàng
		String[] headergioHang = { "Mã sản phẩm", "Tên Sản Phẩm", "Đơn giá", "Số lượng", "Thành tiền" };
		modelGioHang = new DefaultTableModel(headergioHang, 0);
		tableGioHang = new JTable(modelGioHang);
		tableGioHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scpGioHang = new JScrollPane(tableGioHang, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// tạo bảng danh sách
		String[] headerDanhSach = { "Mã sách", "Tên sách ", "Tác Giả", "Thể Loại", "Đơn Giá" };
		modelDanhSach = new DefaultTableModel(headerDanhSach, 0);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.PREFERRED_SIZE, 960, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE).addContainerGap()));
		
				btnThemSP = new JButton("Thêm sản phẩm");
				btnThemSP.setIcon(new ImageIcon(BanHangForm.class.getResource("/icon/add.png")));
				
				btnThemSP.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (selectedSanPham == null) {
							JOptionPane.showMessageDialog(null, "Vui lòng chọn một sản phẩm từ danh sách để thêm vào giỏ hàng");
							return;
						}
						boolean soLuongNhapHopLe = false;
						soLuongNhap = 0;
						while (!soLuongNhapHopLe) {
							String inputsoLuongNhap = JOptionPane.showInputDialog(null, "Nhập số lượng sản phẩm cần thêm:");
							if (inputsoLuongNhap == null) {
								// Người dùng bấm Cancel
								return;
							}

							try {
								soLuongNhap = Integer.parseInt(inputsoLuongNhap);
								if (soLuongNhap > 0 && soLuongNhap <= selectedSanPham.getSoLuong()) {
									soLuongNhapHopLe = true;
								} else if (soLuongNhap <= 0) {
									JOptionPane.showMessageDialog(null, "Số lượng sản phẩm phải lớn hơn 0.");
								} else {
									JOptionPane.showMessageDialog(null, "Số lượng sản phẩm trong kho không đủ.");
								}
							} catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Số lượng sản phẩm phải là một số nguyên dương.");
							}
						}

						// Thêm sản phẩm vào giỏ hàng
						Object[] row = { selectedSanPham.getMaSanPham(), selectedSanPham.getGiaBan(), soLuongNhap,
								soLuongNhap * selectedSanPham.getGiaBan() };
						modelGioHang.addRow(row);
					}
				});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(panelDS, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
						.addComponent(panelGioHang, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
						.addComponent(lbCenterGioHang, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDanhSchSn, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
							.addGap(90)
							.addComponent(btnThemSP)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(9)
							.addComponent(lbDonHang, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelDonHang, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbDonHang, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbCenterGioHang, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(panelGioHang, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDanhSchSn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnThemSP, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelDS, GroupLayout.PREFERRED_SIZE, 383, GroupLayout.PREFERRED_SIZE))
						.addComponent(panelDonHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		GroupLayout gl_panelDonHang = new GroupLayout(panelDonHang);
		gl_panelDonHang.setHorizontalGroup(gl_panelDonHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDonHang.createSequentialGroup().addGroup(gl_panelDonHang
						.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDonHang.createSequentialGroup().addGap(13)
								.addComponent(lblNgyTo, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(9).addComponent(dateChooserNgaytao, GroupLayout.PREFERRED_SIZE, 167,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDonHang.createSequentialGroup().addGap(12).addComponent(lblTinKhcha)
								.addGap(10)
								.addComponent(txtTienKhachDua, GroupLayout.PREFERRED_SIZE, 134,
										GroupLayout.PREFERRED_SIZE)
								.addGap(14)
								.addComponent(lbVND_3, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
								.addGap(20))
						.addGroup(gl_panelDonHang.createSequentialGroup().addGap(12).addGroup(gl_panelDonHang
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelDonHang.createSequentialGroup()
										.addComponent(lblTinTha, GroupLayout.PREFERRED_SIZE, 97,
												GroupLayout.PREFERRED_SIZE)
										.addGap(20).addComponent(lbThanhToan_1, GroupLayout.PREFERRED_SIZE, 97,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelDonHang.createSequentialGroup().addGap(107).addComponent(lblTienThua,
										GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelDonHang.createSequentialGroup().addGap(255).addComponent(lbVND_5,
										GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelDonHang.createSequentialGroup().addGap(151).addComponent(
										cmbHinhThucThanhToan, GroupLayout.PREFERRED_SIZE, 173,
										GroupLayout.PREFERRED_SIZE))
								.addComponent(lblHnhThcThanh, GroupLayout.PREFERRED_SIZE, 152,
										GroupLayout.PREFERRED_SIZE))
								.addGap(7))
						.addGroup(Alignment.TRAILING, gl_panelDonHang.createSequentialGroup().addGap(32)
								.addComponent(btnXuatHoaDon, GroupLayout.PREFERRED_SIZE, 145,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
								.addComponent(btLamMoiHD, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDonHang.createSequentialGroup().addGap(3).addComponent(panelDonHang_1,
								GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
						.addGroup(gl_panelDonHang.createSequentialGroup().addGap(12).addGroup(gl_panelDonHang
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelDonHang.createSequentialGroup()
										.addComponent(lbma, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblHienThiMaHD,
												GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelDonHang.createSequentialGroup()
										.addComponent(lbtogtin, GroupLayout.PREFERRED_SIZE, 97,
												GroupLayout.PREFERRED_SIZE)
										.addGap(10)
										.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 134,
												GroupLayout.PREFERRED_SIZE)
										.addGap(14).addComponent(lbVND, GroupLayout.PREFERRED_SIZE, 55,
												GroupLayout.PREFERRED_SIZE)))
								.addGap(18)))
						.addContainerGap())
				.addGroup(gl_panelDonHang.createSequentialGroup().addContainerGap()
						.addComponent(lblGhiCh, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textAreaGhiChu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addGap(18))
				.addGroup(gl_panelDonHang.createSequentialGroup().addGap(70)
						.addComponent(btnThanhToan, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(59, Short.MAX_VALUE)));
		gl_panelDonHang.setVerticalGroup(gl_panelDonHang.createParallelGroup(Alignment.LEADING).addGroup(gl_panelDonHang
				.createSequentialGroup().addContainerGap()
				.addComponent(panelDonHang_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panelDonHang.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNgyTo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(dateChooserNgaytao, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(gl_panelDonHang.createParallelGroup(Alignment.LEADING)
						.addComponent(lbma, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHienThiMaHD, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panelDonHang.createParallelGroup(Alignment.LEADING)
						.addComponent(lbtogtin, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTongTien, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbVND))
				.addGap(5)
				.addGroup(
						gl_panelDonHang.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTinKhcha, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTienKhachDua, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbVND_3))
				.addGap(5)
				.addGroup(gl_panelDonHang.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTinTha, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelDonHang.createSequentialGroup().addGap(24).addComponent(lbThanhToan_1,
								GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTienThua, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbVND_5)
						.addGroup(gl_panelDonHang.createSequentialGroup().addGap(30).addComponent(cmbHinhThucThanhToan,
								GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDonHang.createSequentialGroup().addGap(30).addComponent(lblHnhThcThanh,
								GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
				.addGap(18)
				.addGroup(gl_panelDonHang.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblGhiCh, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textAreaGhiChu, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panelDonHang.createParallelGroup(Alignment.BASELINE)
						.addComponent(btLamMoiHD, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXuatHoaDon, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
				.addGap(42).addComponent(btnThanhToan).addGap(128)));
		GroupLayout gl_panelDonHang_1 = new GroupLayout(panelDonHang_1);
		gl_panelDonHang_1.setHorizontalGroup(
			gl_panelDonHang_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDonHang_1.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_panelDonHang_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lbMaKH, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbTenKH, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panelDonHang_1.createParallelGroup(Alignment.LEADING)
						.addComponent(txtMaKH, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btThayDoi, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
					.addGap(5))
		);
		gl_panelDonHang_1.setVerticalGroup(
			gl_panelDonHang_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDonHang_1.createSequentialGroup()
					.addGroup(gl_panelDonHang_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDonHang_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lbMaKH, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lbTenKH, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDonHang_1.createSequentialGroup()
							.addGap(1)
							.addComponent(txtMaKH, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDonHang_1.createSequentialGroup()
							.addGap(22)
							.addComponent(btThayDoi, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(7, Short.MAX_VALUE))
		);
		panelDonHang_1.setLayout(gl_panelDonHang_1);
		panelDonHang.setLayout(gl_panelDonHang);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBackground(Color.WHITE);
		JScrollPane scrSach = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tblSach = new JTable(modelDanhSach);
		scrSach.setViewportView(tblSach);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane_1.addTab("Sách", null, panel_1, null);

		txtTimKiemSach = new JTextField();
		txtTimKiemSach.setColumns(10);

		JLabel lbTimKiemSanPham = new JLabel("Tìm kiếm");
		lbTimKiemSanPham.setFont(new Font("Tahoma", Font.BOLD, 12));

		cbbDanhMuc = new JComboBox();
		cbbDanhMuc.setSelectedItem(null);

		JLabel lblDanhMc = new JLabel("Danh mục");
		lblDanhMc.setFont(new Font("Tahoma", Font.BOLD, 12));

		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrSach, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lbTimKiemSanPham, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtTimKiemSach, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
							.addComponent(lblDanhMc, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbbDanhMuc, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtTimKiemSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbTimKiemSanPham, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbbDanhMuc, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDanhMc, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addComponent(scrSach, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
					.addContainerGap())
		);

		panel_1.setLayout(gl_panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane_1.addTab("Văn phòng phẩm & Quà lưu niệm", null, panel_2, null);
		
		JLabel lbTimKiemSanPham_1 = new JLabel("Tìm kiếm");
		lbTimKiemSanPham_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblDanhMc_1 = new JLabel("Danh mục");
		lblDanhMc_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JComboBox cbbDanhMuc_1 = new JComboBox();
		

		
		// tạo bảng giỏ hàng
		String[] headerVPP = { "Mã sản phẩm", "Tên Sản Phẩm", "Loại", "Nhà Cung Cấp", "Đơn Giá" };
		modelVPP = new DefaultTableModel(headergioHang, 0);
		tblVPP = new JTable(modelVPP);
		tblVPP.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scrVPP = new JScrollPane(tblVPP, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		scrVPP.setViewportView(tblVPP);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrVPP, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lbTimKiemSanPham_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
							.addComponent(lblDanhMc_1, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cbbDanhMuc_1, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(cbbDanhMuc_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDanhMc_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbTimKiemSanPham_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrVPP, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panelDS = new GroupLayout(panelDS);
		gl_panelDS.setHorizontalGroup(
			gl_panelDS.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDS.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panelDS.setVerticalGroup(
			gl_panelDS.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelDS.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelDS.setLayout(gl_panelDS);

		GroupLayout gl_panelGioHang = new GroupLayout(panelGioHang);
		gl_panelGioHang.setHorizontalGroup(gl_panelGioHang.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelGioHang.createSequentialGroup().addGap(11)
						.addComponent(scpGioHang, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE).addGap(30)
						.addGroup(gl_panelGioHang.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnTaoHoaDon, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
								.addComponent(btnLamMoiGioHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnXoaSanPham, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap()));
		gl_panelGioHang.setVerticalGroup(gl_panelGioHang.createParallelGroup(Alignment.LEADING).addGroup(gl_panelGioHang
				.createSequentialGroup().addGap(24)
				.addComponent(btnXoaSanPham, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnLamMoiGioHang, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE).addGap(20)
				.addComponent(btnTaoHoaDon, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE).addGap(39))
				.addGroup(gl_panelGioHang.createSequentialGroup().addGap(8)
						.addComponent(scpGioHang, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE).addContainerGap()));
		panelGioHang.setLayout(gl_panelGioHang);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		// xử lý sự kiện thya đổi khách hàng
		btThayDoi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame fr = new JFrame();
				fr.setVisible(true);
				// fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				fr.setSize(600, 400);
				fr.setLocationRelativeTo(null);

				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				tabbedPane.setBounds(10, 11, 564, 339);
				fr.getContentPane().add(tabbedPane);

				JPanel panelDS = new JPanel();
				tabbedPane.addTab("Danh sách khách hàng", null, panelDS, null);
				panelDS.setLayout(null);

				JPanel panelThemKH = new JPanel();
				tabbedPane.addTab("Thêm khách hàng", null, panelThemKH, null);
				panelThemKH.setLayout(null);

				JLabel lblNewLabel = new JLabel("Mã khách hàng:");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel.setBounds(27, 11, 139, 33);
				panelThemKH.add(lblNewLabel);

				JLabel lblNewLabel_1 = new JLabel("Tên khách hàng:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1.setBounds(27, 58, 139, 33);
				panelThemKH.add(lblNewLabel_1);

				JLabel lblNewLabel_3 = new JLabel("Giới tính:");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_3.setBounds(27, 105, 139, 33);
				panelThemKH.add(lblNewLabel_3);

				rbNam = new JRadioButton("Nam", false);
				rbNam.setFont(new Font("Tahoma", Font.BOLD, 12));
				rbNam.setBackground(new Color(240, 240, 240));
				rbNam.setBounds(157, 107, 57, 30);
				panelThemKH.add(rbNam);

				rbNu = new JRadioButton("Nữ");
				rbNu.setFont(new Font("Tahoma", Font.BOLD, 12));
				rbNu.setBackground(new Color(240, 240, 240));
				rbNu.setBounds(224, 106, 57, 30);
				panelThemKH.add(rbNu);
				ButtonGroup group = new ButtonGroup();
				group.add(rbNu);
				group.add(rbNam);

				txtTenKHThem = new JTextField();
				txtTenKHThem.setColumns(10);
				txtTenKHThem.setBounds(157, 67, 212, 25);
				panelThemKH.add(txtTenKHThem);

				txtMaKHThem = new JTextField();
				txtMaKHThem.setColumns(10);
				txtMaKHThem.setBounds(157, 20, 212, 25);
				panelThemKH.add(txtMaKHThem);

				JLabel lblNewLabel_4_2 = new JLabel("Email:");
				lblNewLabel_4_2.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_4_2.setBounds(27, 144, 139, 33);
				panelThemKH.add(lblNewLabel_4_2);

				txtEmail = new JTextField();
				txtEmail.setColumns(10);
				txtEmail.setBounds(157, 149, 212, 25);
				panelThemKH.add(txtEmail);

				JLabel lblNewLabel_4_1 = new JLabel("Địa chỉ:");
				lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_4_1.setBounds(27, 188, 139, 33);
				panelThemKH.add(lblNewLabel_4_1);

				txtDiaChi = new JTextArea();
				txtDiaChi.setBounds(159, 188, 210, 65);
				panelThemKH.add(txtDiaChi);

				JLabel lblNewLabel_2 = new JLabel("Số điện thoại:");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_2.setBounds(307, 105, 99, 33);
				panelThemKH.add(lblNewLabel_2);

				txtSoDienThoai = new JTextField();
				txtSoDienThoai.setColumns(10);
				txtSoDienThoai.setBounds(395, 110, 154, 25);
				panelThemKH.add(txtSoDienThoai);

				btThem = new JButton("Thêm");
				btThem.setFont(new Font("Tahoma", Font.BOLD, 11));
				btThem.setBounds(227, 277, 89, 23);
				panelThemKH.add(btThem);

				String[] headerKH = { "Mã KH", "Tên KH", "Giới tính", "Địa chỉ", "SDT", "Email" };
				modelKH = new DefaultTableModel(headerKH, 0);
				tableKH = new JTable(modelKH);
				tableKH.setBorder(new LineBorder(new Color(0, 0, 0)));
				JScrollPane scpKH = new JScrollPane(tableKH, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
						JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scpKH.setBounds(10, 11, 539, 259);
				panelDS.add(scpKH);

				btChon = new JButton("Chọn");
				btChon.setFont(new Font("Tahoma", Font.BOLD, 11));
				btChon.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btChon.setBounds(234, 277, 89, 23);
				panelDS.add(btChon);
// thiết lập dữ liệu cho Jframe Khach hàng
				try {
					khachHang = new KhachHang_DAO();
					for (KhachHang kh : khachHang.getAllKhachHang()) {
						Object[] rowData = { kh.getMaKH(), kh.getTenKH(), kh.getGioiTinh(), kh.getDiaChi(), kh.getSDT(),
								kh.getEmail() };
						modelKH.addRow(rowData);
					}
				} catch (Exception eKH) {
					// TODO: handle exception
					eKH.printStackTrace();
				}
				btThem.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
//						themKH();

					}

				});
				btChon.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						int selectedRowKH = tableKH.getSelectedRow();
						if (selectedRowKH >= 0) {
							txtMaKH.setText(tableKH.getValueAt(selectedRowKH, 0).toString());
							txtTenKH.setText(tableKH.getValueAt(selectedRowKH, 1).toString());

						}

					}
				});

			}
		});
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
