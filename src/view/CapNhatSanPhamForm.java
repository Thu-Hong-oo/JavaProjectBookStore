package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import dao.SanPham_DAO;
import entity.SanPham;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class CapNhatSanPhamForm extends JPanel {
	private DefaultTableModel modelSach;
	private JTable tblSach;
	private JTable tableVPP;
	private DefaultTableModel modelVPP;
	private SanPham_DAO sanPham;

	private JTextField txtTimKiemSach;
	private JTextField txtMaSach;
	private JTextField txtTheLoai;
	private JTextField txtSoLuongSach;
	private JTextField txtTacGia;
	private JTextField txtGiaBanSach;
	private JTextField txtTimKiemVPP;
	private JTextField txtMaSanPham;
	private JTextField txtLoai;
	private JTextField txSoLuongVPP;
	private JTextField txtGiaNhapSP;
	private JTextField txtGiaBanSP;

	private JTextField txtGiaNhapSach;
	private JLabel lblHinhAnh;

	/**
	 * Create the panel.
	 */
	public CapNhatSanPhamForm() {
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		defaults.put("Button.focusPainted", false); // Tắt viền focus
		setBackground(Color.WHITE);
		setSize(1130, 603);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1120, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		lblHinhAnh = new JLabel("");
		lblHinhAnh.setIcon(
				new ImageIcon(CapNhatSanPhamForm.class.getResource("/image/bai-tap-tieng-anh-lop-7-co-dap-an.jpg")));

		JLabel lblTenSP = new JLabel("Tên Sản Phẩm");
		lblTenSP.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnThemSP = new JButton("Thêm");
		btnThemSP.setIcon(new ImageIcon(CapNhatSanPhamForm.class.getResource("/icon/add.png")));

		JButton btnCapNhapSP = new JButton("Cập Nhật");
		btnCapNhapSP.setIcon(new ImageIcon(CapNhatSanPhamForm.class.getResource("/icon/edit.png")));

		JButton btnLamMoiSP = new JButton("Làm Mới");
		btnLamMoiSP.setIcon(new ImageIcon(CapNhatSanPhamForm.class.getResource("/icon/refresh.png")));

		JButton btnCapNhatAnh = new JButton("Cập Nhật Ảnh");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING,
								gl_panel.createSequentialGroup()
										.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 815,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
														.addComponent(lblHinhAnh, GroupLayout.PREFERRED_SIZE, 250,
																GroupLayout.PREFERRED_SIZE)
														.addContainerGap())
												.addGroup(Alignment.TRAILING,
														gl_panel.createSequentialGroup()
																.addComponent(lblTenSP, GroupLayout.PREFERRED_SIZE, 209,
																		GroupLayout.PREFERRED_SIZE)
																.addGap(65))
												.addGroup(Alignment.TRAILING,
														gl_panel.createSequentialGroup().addGroup(gl_panel
																.createParallelGroup(Alignment.TRAILING, false)
																.addComponent(btnLamMoiSP, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(btnCapNhapSP, Alignment.LEADING,
																		GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
																.addComponent(btnThemSP, GroupLayout.DEFAULT_SIZE,
																		GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
																.addGap(49))
												.addGroup(Alignment.TRAILING,
														gl_panel.createSequentialGroup()
																.addComponent(btnCapNhatAnh, GroupLayout.PREFERRED_SIZE,
																		123, GroupLayout.PREFERRED_SIZE)
																.addGap(98)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(35)
				.addComponent(lblHinhAnh, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(lblTenSP, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addComponent(btnCapNhatAnh, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
				.addComponent(btnThemSP, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnCapNhapSP, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(btnLamMoiSP, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE).addGap(31))
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE));

		JPanel panelSach = new JPanel();
		panelSach.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSach.setBackground(Color.WHITE);
		tabbedPane.addTab("Sách", null, panelSach, null);

		JLabel lblTimKiemSach = new JLabel("Tìm Kiếm");

		txtTimKiemSach = new JTextField();
		txtTimKiemSach.setColumns(10);

		JScrollPane scrSach = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		JLabel lblNewLabel_2 = new JLabel("Tên Sách");

		JLabel lbTenSach_1 = new JLabel("");

		JLabel lblMaSach = new JLabel("Mã Sách");

		JLabel lblSoLuong = new JLabel("Số Lượng");

		JLabel lblNCCSach = new JLabel("Nhà Cung Cấp");

		txtMaSach = new JTextField();
		txtMaSach.setColumns(10);

		txtTheLoai = new JTextField();
		txtTheLoai.setColumns(10);

		txtSoLuongSach = new JTextField();
		txtSoLuongSach.setColumns(10);

		JComboBox cmbNCCSach = new JComboBox();

		JLabel lblGiaNhapSach = new JLabel("Giá Nhập");

		txtGiaNhapSach = new JTextField();
		txtGiaNhapSach.setColumns(10);

		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);

		JLabel lblGiaBanSach = new JLabel("Giá Bán");

		txtGiaBanSach = new JTextField();
		txtGiaBanSach.setColumns(10);

		JLabel lblMoTa = new JLabel("Mô Tả");

		JTextArea txaMoTaSach = new JTextArea();

		JLabel lblTheLoai = new JLabel("Thể Loại");
		GroupLayout gl_panelSach = new GroupLayout(panelSach);
		gl_panelSach.setHorizontalGroup(gl_panelSach.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelSach.createSequentialGroup().addGap(12)
						.addComponent(lblTimKiemSach, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(txtTimKiemSach, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelSach.createSequentialGroup().addGap(12)
						.addComponent(scrSach, GroupLayout.PREFERRED_SIZE, 761, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lbTenSach_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelSach.createSequentialGroup().addContainerGap()
						.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNCCSach, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTheLoai, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSoLuong, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMaSach, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGap(68)
						.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelSach.createSequentialGroup().addGap(1).addComponent(txtMaSach,
										GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelSach.createSequentialGroup().addGap(1).addComponent(txtTheLoai,
										GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtSoLuongSach, GroupLayout.PREFERRED_SIZE, 174,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbNCCSach, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGap(70)
						.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelSach.createSequentialGroup()
										.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_panelSach.createSequentialGroup().addGap(1)
														.addComponent(lblGiaNhapSach, GroupLayout.PREFERRED_SIZE, 87,
																GroupLayout.PREFERRED_SIZE)
														.addGap(17).addComponent(txtGiaNhapSach,
																GroupLayout.PREFERRED_SIZE, 174,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_panelSach.createSequentialGroup()
														.addComponent(lblMoTa, GroupLayout.PREFERRED_SIZE, 87,
																GroupLayout.PREFERRED_SIZE)
														.addGap(14)
														.addComponent(txaMoTaSach, GroupLayout.PREFERRED_SIZE, 177,
																GroupLayout.PREFERRED_SIZE)))
										.addGap(175).addComponent(txtTacGia, GroupLayout.PREFERRED_SIZE, 174,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelSach.createSequentialGroup().addGap(1)
										.addComponent(lblGiaBanSach, GroupLayout.PREFERRED_SIZE, 87,
												GroupLayout.PREFERRED_SIZE)
										.addGap(17).addComponent(txtGiaBanSach, GroupLayout.PREFERRED_SIZE, 174,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap()));
		gl_panelSach.setVerticalGroup(gl_panelSach.createParallelGroup(Alignment.LEADING).addGroup(gl_panelSach
				.createSequentialGroup().addGap(11)
				.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTimKiemSach, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimKiemSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING).addGroup(gl_panelSach
						.createSequentialGroup().addGap(303)
						.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_2)
								.addComponent(lbTenSach_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelSach.createSequentialGroup().addGap(30).addComponent(scrSach,
								GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSach.createSequentialGroup().addGap(8).addComponent(txtTacGia,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSach.createSequentialGroup().addGap(18)
								.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelSach.createSequentialGroup()
												.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
														.addComponent(lblGiaNhapSach, GroupLayout.PREFERRED_SIZE, 20,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtGiaNhapSach, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(23)
												.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
														.addComponent(lblGiaBanSach, GroupLayout.PREFERRED_SIZE, 20,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtGiaBanSach, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
												.addGap(28)
												.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_panelSach.createSequentialGroup().addGap(3)
																.addComponent(lblMoTa, GroupLayout.PREFERRED_SIZE, 20,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_panelSach.createSequentialGroup().addGap(1)
																.addComponent(txaMoTaSach, GroupLayout.PREFERRED_SIZE,
																		81, GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_panelSach.createSequentialGroup()
												.addGroup(gl_panelSach.createParallelGroup(Alignment.BASELINE)
														.addComponent(txtMaSach, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblMaSach, GroupLayout.PREFERRED_SIZE, 20,
																GroupLayout.PREFERRED_SIZE))
												.addGap(23)
												.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
														.addComponent(txtTheLoai, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblTheLoai, GroupLayout.PREFERRED_SIZE, 20,
																GroupLayout.PREFERRED_SIZE))
												.addGap(31)
												.addGroup(gl_panelSach.createParallelGroup(Alignment.BASELINE)
														.addComponent(txtSoLuongSach, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblSoLuong, GroupLayout.PREFERRED_SIZE, 20,
																GroupLayout.PREFERRED_SIZE))
												.addGap(31)
												.addGroup(gl_panelSach.createParallelGroup(Alignment.BASELINE)
														.addComponent(cmbNCCSach, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblNCCSach, GroupLayout.PREFERRED_SIZE, 20,
																GroupLayout.PREFERRED_SIZE))))))));
		panelSach.setLayout(gl_panelSach);
		tblSach = new JTable(modelSach);
		scrSach.setViewportView(tblSach);
		tblSach.setRowSelectionAllowed(true);

		JPanel panelVPP = new JPanel();
		panelVPP.setBorder(UIManager.getBorder("TitledBorder.border"));
		panelVPP.setBackground(Color.WHITE);
		tabbedPane.addTab("VPP & QLN", null, panelVPP, null);

		JLabel lblTimKiemVPP = new JLabel("Tìm Kiếm");
		lblTimKiemVPP.setFont(new Font("Tahoma", Font.BOLD, 11));

		txtTimKiemVPP = new JTextField();
		txtTimKiemVPP.setColumns(10);

		JLabel lblNewLabel_3_1 = new JLabel("");

		JLabel lblMaSP = new JLabel("Mã Sản Phẩm");

		JLabel lblLoai = new JLabel("Loại");

		JLabel lblSoLuongVPP = new JLabel("Số Lượng");

		JLabel lblNCCVPP = new JLabel("Nhà Cung Cấp");

		txtMaSanPham = new JTextField();
		txtMaSanPham.setColumns(10);

		txtLoai = new JTextField();
		txtLoai.setColumns(10);

		txSoLuongVPP = new JTextField();
		txSoLuongVPP.setColumns(10);

		JComboBox cmbNCCVPP = new JComboBox();

		JLabel lblMoTaSP = new JLabel("Mô Tả");

		JTextArea txaMoTaSP = new JTextArea();

		JLabel lblGiaNhapSP = new JLabel("Giá Nhập");

		txtGiaNhapSP = new JTextField();
		txtGiaNhapSP.setColumns(10);

		JLabel lblGiaBanSP = new JLabel("Giá Bán");

		txtGiaBanSP = new JTextField();
		txtGiaBanSP.setColumns(10);

		String[] headerSach = { "Mã Sách", "Tên Sách", "Tác Giả", " Nhà Cung Cấp", "Thể Loại", "Mô Tả", "Số Lượng",
				"Giá Nhập", "Giá Bán" };
		modelSach = new DefaultTableModel(headerSach, 0);
		tblSach = new JTable(modelSach);
		scrSach.setViewportView(tblSach);

		String[] headerVPP = { "Mã Sản Phẩm", "Tên Sản Phẩm", " Nhà Cung Cấp", "Loại", "Mô Tả", "Số Lượng", "Giá Nhập",
				"Giá Bán" };
		modelVPP = new DefaultTableModel(headerVPP, 0);
		tableVPP = new JTable(modelVPP);
		JScrollPane scrVPP = new JScrollPane(tableVPP, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		tableVPP.setRowSelectionAllowed(true);
		GroupLayout gl_panelVPP = new GroupLayout(panelVPP);
		gl_panelVPP.setHorizontalGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVPP.createSequentialGroup().addGap(10)
						.addComponent(lblTimKiemVPP, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
						.addGap(10)
						.addComponent(txtTimKiemVPP, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelVPP.createSequentialGroup().addContainerGap()
						.addComponent(scrVPP, GroupLayout.PREFERRED_SIZE, 777, GroupLayout.PREFERRED_SIZE).addGap(99)
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelVPP.createSequentialGroup().addGap(33)
						.addComponent(lblMaSP, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE).addGap(40)
						.addComponent(txtMaSanPham, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addGap(76)
						.addComponent(lblGiaNhapSP, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addGap(17)
						.addComponent(txtGiaNhapSP, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelVPP.createSequentialGroup().addGap(33)
						.addComponent(lblLoai, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE).addGap(40)
						.addComponent(txtLoai, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE).addGap(76)
						.addComponent(lblGiaBanSP, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addGap(17)
						.addComponent(txtGiaBanSP, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelVPP.createSequentialGroup().addGap(33)
						.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSoLuongVPP, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNCCVPP, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addComponent(txSoLuongVPP, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbNCCVPP, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGap(76).addComponent(lblMoTaSP, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addGap(14)
						.addComponent(txaMoTaSP, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)));
		gl_panelVPP.setVerticalGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVPP.createSequentialGroup().addGap(11)
						.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTimKiemVPP, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(
										txtTimKiemVPP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelVPP.createSequentialGroup().addGap(306).addComponent(lblNewLabel_3_1,
										GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelVPP.createSequentialGroup().addGap(23).addComponent(scrVPP,
										GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)))
						.addGap(11)
						.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMaSP, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMaSanPham, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGiaNhapSP, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtGiaNhapSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(23)
						.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLoai, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtLoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGiaBanSP, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(
										txtGiaBanSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(29)
						.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelVPP.createSequentialGroup().addGap(2)
										.addComponent(lblSoLuongVPP, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)
										.addGap(34).addComponent(lblNCCVPP, GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelVPP.createSequentialGroup().addGap(2)
										.addComponent(txSoLuongVPP, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(33).addComponent(cmbNCCVPP, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelVPP.createSequentialGroup().addGap(2).addComponent(lblMoTaSP,
										GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addComponent(txaMoTaSP, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))));
		panelVPP.setLayout(gl_panelVPP);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		// thiết lập dữ liệu cho table Sách
		try {
			sanPham = new SanPham_DAO();
			for (SanPham sp : sanPham.getAllSach()) {
				Object[] row = { sp.getMaSP(), sp.getTenSP(), sp.getTacGia(), sp.getMaNCC(), sp.getLoaiSanPham(),
						sp.getMoTa(), sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan() };
				modelSach.addRow(row);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// thiết lập dữ liệu cho table VPP &QLL
		try {
			sanPham = new SanPham_DAO();
			for (SanPham sp : sanPham.getAllVanPhongPham()) {
				Object[] row = { sp.getMaSP(), sp.getTenSP(), sp.getMaNCC(), sp.getLoaiSanPham(), sp.getMoTa(),
						sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan() };
				modelVPP.addRow(row);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//Sư kiện chọn ảnh
	
	}

//	public SanPham createSanPhamFromInput() {
//	    SanPham sanPham = null;
//	    String maSanPham, tenSanPham;
//	    String tacGia;
//	    double giaNhap, giaBan;
//	    int soLuong;
//	    String moTa;
//	    byte[] hinhAnh; // Thêm biến để lưu trữ hình ảnh
//
//	    // Lấy dữ liệu từ trường nhập liệu hoặc các thành phần giao diện người dùng
//	    maSanPham = txtMaSach.getText();
//	    tenSanPham = lbTenSach.getText();
//	    tacGia = txtTacGia.getText();
//	    giaNhap = Double.parseDouble(txtGiaNhap.getText());
//	    giaBan = Double.parseDouble(txtGiaBan.getText());
//	    soLuong = Inter(txtGiaBan.getText());
//	    moTa = textAreaMoTa.getText();
//	    soLuong = Integer.parseInt(txtSoLuong.getText());
//	    // Hình ảnh sẽ được lưu dưới dạng byte array
//	    hinhAnh = getHinhAnhFromSource(); // Hãy thay thế hàm này bằng cách lấy hình ảnh thực tế
//
//	    // Tạo đối tượng SanPham
//	    sanPham = new SanPham(maSanPham, tenSanPham, tacGia, nhaCungCap, loai, moTa, hinhAnh, giaNhap, giaBan, soLuong);
//	    
//	    return sanPham;
//	}

	// Hàm để lấy hình ảnh từ nguồn dữ liệu, ví dụ: từ một tệp ảnh

	public ImageIcon ResizeImage(String imagePath, byte[] pic) {
		ImageIcon ig = null;
		if (imagePath != null) {
			ig = new ImageIcon(imagePath);
		} else {
			ig = new ImageIcon(pic);
		}
		Image img = ig.getImage();
		Image img2 = img.getScaledInstance(lblHinhAnh.getWidth(), lblHinhAnh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img2);
		return image;
	}
}
