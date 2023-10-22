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
	private JTable tableVPP;
	private DefaultTableModel modelVPP;
	private SanPham_DAO sanPham;
	private JLabel lbTenSach;
	private JTextField txtTimKiemSach;
	private JTextField txtMaSach;
	private JTextField txtTheLoai;
	private JTextField txtSoLuongSach;
	private JTextField txtGiaNhapSach;
	private JTextField txtTacGia;
	private JTextField txtGiaBanSach;
	private JTextField txtTimKiemVPP;
	private JTextField txtMaSanPham;
	private JTextField txtLoai;
	private JTextField txSoLuongVPP;
	private JTextField txtGiaNhapSP;
	private JTextField txtGiaBanSP;
	private JLabel lblHinhAnhSach;
	private JTable tblSach;

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
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1120, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
		);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 1111, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
		);

		JPanel panelSach = new JPanel();
		panelSach.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelSach.setBackground(Color.WHITE);
		tabbedPane.addTab("Sách", null, panelSach, null);

		JLabel lblTimKiemSach = new JLabel("Tìm Kiếm");

		txtTimKiemSach = new JTextField();
		txtTimKiemSach.setColumns(10);

		JScrollPane scrSach = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		lblHinhAnhSach = new JLabel("hình ảnh");
		lblHinhAnhSach.setIcon(
				new ImageIcon(CapNhatSanPhamForm.class.getResource("/image/bai-tap-tieng-anh-lop-7-co-dap-an.jpg")));

		JButton btnThemAnhSach = new JButton("Thêm Ảnh");

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

		JLabel lblTacGia = new JLabel("Tác Giả");

		JLabel lblGiaBanSach = new JLabel("Giá Bán");

		txtGiaBanSach = new JTextField();
		txtGiaBanSach.setColumns(10);

		JLabel lblMoTa = new JLabel("Mô Tả");

		JTextArea txaMoTaSach = new JTextArea();

		JButton btnThemSach = new JButton("Thêm");
		btnThemSach.setIcon(new ImageIcon(CapNhatSanPhamForm.class.getResource("/icon/add.png")));

		JButton btnCapNhatSach = new JButton("Cập Nhật");
		btnCapNhatSach.setIcon(new ImageIcon(CapNhatSanPhamForm.class.getResource("/icon/edit.png")));

		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setIcon(new ImageIcon(CapNhatSanPhamForm.class.getResource("/icon/refresh.png")));

		JLabel lblTheLoai = new JLabel("Thể Loại");
		GroupLayout gl_panelSach = new GroupLayout(panelSach);
		gl_panelSach.setHorizontalGroup(
			gl_panelSach.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSach.createSequentialGroup()
					.addGap(12)
					.addComponent(lblTimKiemSach, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(txtTimKiemSach, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelSach.createSequentialGroup()
					.addGap(12)
					.addComponent(scrSach, GroupLayout.PREFERRED_SIZE, 729, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelSach.createSequentialGroup()
									.addGap(17)
									.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTacGia, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panelSach.createSequentialGroup()
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lbTenSach_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panelSach.createSequentialGroup()
									.addGap(150)
									.addComponent(btnThemAnhSach, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.TRAILING, gl_panelSach.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
							.addComponent(lblHinhAnhSach, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)
							.addGap(69))))
				.addGroup(gl_panelSach.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNCCSach, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTheLoai, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSoLuong, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaSach, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addGap(68)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGap(1)
							.addComponent(txtMaSach, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGap(1)
							.addComponent(txtTheLoai, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtSoLuongSach, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbNCCSach, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
					.addGap(70)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelSach.createSequentialGroup()
									.addGap(1)
									.addComponent(lblGiaNhapSach, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(17)
									.addComponent(txtGiaNhapSach, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelSach.createSequentialGroup()
									.addComponent(lblMoTa, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addComponent(txaMoTaSach, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelSach.createSequentialGroup()
									.addGap(175)
									.addComponent(txtTacGia, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelSach.createSequentialGroup()
									.addGap(18)
									.addComponent(btnThemSach, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnCapNhatSach, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGap(1)
							.addComponent(lblGiaBanSach, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(txtGiaBanSach, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelSach.setVerticalGroup(
			gl_panelSach.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSach.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTimKiemSach, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimKiemSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGap(30)
							.addComponent(scrSach, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSach.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHinhAnhSach, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnThemAnhSach, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lbTenSach_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_panelSach.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtTacGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTacGia, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(72)
							.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
								.addComponent(btnThemSach, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelSach.createSequentialGroup()
									.addGap(1)
									.addGroup(gl_panelSach.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnCapNhatSach, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelSach.createSequentialGroup()
									.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
										.addComponent(lblGiaNhapSach, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtGiaNhapSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(23)
									.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
										.addComponent(lblGiaBanSach, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtGiaBanSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(28)
									.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelSach.createSequentialGroup()
											.addGap(3)
											.addComponent(lblMoTa, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelSach.createSequentialGroup()
											.addGap(1)
											.addComponent(txaMoTaSach, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panelSach.createSequentialGroup()
									.addGroup(gl_panelSach.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtMaSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblMaSach, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addGap(23)
									.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
										.addComponent(txtTheLoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblTheLoai, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addGap(31)
									.addGroup(gl_panelSach.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtSoLuongSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSoLuong, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addGap(31)
									.addGroup(gl_panelSach.createParallelGroup(Alignment.BASELINE)
										.addComponent(cmbNCCSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNCCSach, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))))))
		);
		panelSach.setLayout(gl_panelSach);

		JPanel panelVPP = new JPanel();
		panelVPP.setBorder(UIManager.getBorder("TitledBorder.border"));
		panelVPP.setBackground(Color.WHITE);
		tabbedPane.addTab("VPP & QLN", null, panelVPP, null);

		JLabel lblTimKiemVPP = new JLabel("Tìm Kiếm");
		lblTimKiemVPP.setFont(new Font("Tahoma", Font.BOLD, 11));

		txtTimKiemVPP = new JTextField();
		txtTimKiemVPP.setColumns(10);

		JScrollPane scrVPP = new JScrollPane(tableVPP, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	

		JLabel lblHinhAnhSP = new JLabel("hình ảnh");
		lblHinhAnhSP.setIcon(new ImageIcon(CapNhatSanPhamForm.class.getResource("/icon/Thesis-pana.png")));

		JLabel lblTenSP = new JLabel("Tên Sản Phẩm");

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

		JButton btnThemSP = new JButton("Thêm");
		btnThemSP.setIcon(new ImageIcon(CapNhatSanPhamForm.class.getResource("/icon/add.png")));

		JButton btnCapNhapSP = new JButton("Cập Nhật");
		btnCapNhapSP.setIcon(new ImageIcon(CapNhatSanPhamForm.class.getResource("/icon/edit.png")));

		JButton btnLamMoiSP = new JButton("Làm Mới");
		btnLamMoiSP.setIcon(new ImageIcon(CapNhatSanPhamForm.class.getResource("/icon/refresh.png")));

		JLabel lblGiaNhapSP = new JLabel("Giá Nhập");

		txtGiaNhapSP = new JTextField();
		txtGiaNhapSP.setColumns(10);

		JLabel lblGiaBanSP = new JLabel("Giá Bán");

		txtGiaBanSP = new JTextField();
		txtGiaBanSP.setColumns(10);
		GroupLayout gl_panelVPP = new GroupLayout(panelVPP);
		gl_panelVPP.setHorizontalGroup(
			gl_panelVPP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVPP.createSequentialGroup()
					.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addGap(10)
							.addComponent(lblTimKiemVPP, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtTimKiemVPP, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addGap(10)
							.addComponent(scrVPP, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE)
							.addGap(65)
							.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelVPP.createSequentialGroup()
									.addGap(15)
									.addComponent(lblHinhAnhSP, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panelVPP.createSequentialGroup()
									.addComponent(lblTenSP, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addGap(40)
									.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMaSP, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblLoai, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSoLuongVPP, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNCCVPP, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addComponent(txtMaSanPham, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtLoai, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addComponent(txSoLuongVPP, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbNCCVPP, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
							.addGap(76)
							.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelVPP.createSequentialGroup()
									.addComponent(lblMoTaSP, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
									.addGap(14)
									.addComponent(txaMoTaSP, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnThemSP, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnCapNhapSP, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
									.addGap(14)
									.addComponent(btnLamMoiSP, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addGap(12))
								.addGroup(gl_panelVPP.createSequentialGroup()
									.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelVPP.createSequentialGroup()
											.addComponent(lblGiaNhapSP, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
											.addGap(17)
											.addComponent(txtGiaNhapSP, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelVPP.createSequentialGroup()
											.addComponent(lblGiaBanSP, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
											.addGap(17)
											.addComponent(txtGiaBanSP, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED, 402, Short.MAX_VALUE)))))
					.addContainerGap())
		);
		gl_panelVPP.setVerticalGroup(
			gl_panelVPP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVPP.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTimKiemVPP, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimKiemVPP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addGap(17)
							.addComponent(scrVPP, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addComponent(lblHinhAnhSP, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTenSP)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
					.addGap(11)
					.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMaSP, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGiaNhapSP, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtGiaNhapSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(23)
							.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addComponent(lblLoai, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblGiaBanSP, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtGiaBanSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelVPP.createSequentialGroup()
									.addGap(8)
									.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelVPP.createSequentialGroup()
											.addGap(23)
											.addComponent(lblSoLuongVPP, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
											.addGap(34)
											.addComponent(lblNCCVPP, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelVPP.createSequentialGroup()
											.addGap(23)
											.addComponent(lblMoTaSP, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelVPP.createSequentialGroup()
											.addGap(21)
											.addComponent(txaMoTaSP, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panelVPP.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panelVPP.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnThemSP, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnLamMoiSP, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnCapNhapSP, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addComponent(txtMaSanPham, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(txtLoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(txSoLuongVPP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(cmbNCCVPP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);

		String[] headerSach = { "Mã Sách", "Tên Sách", "Tác Giả", " Nhà Cung Cấp", "Thể Loại", "Mô Tả", "Số Lượng",
				"Giá Nhập", "Giá Bán" };
		modelSach = new DefaultTableModel(headerSach, 0);
		tblSach = new JTable(modelSach);
		scrSach.setViewportView(tblSach);
		tblSach.setRowSelectionAllowed(true);
		
		String[] headerVPP = { "Mã Sản Phẩm", "Tên Sản Phẩm"," Nhà Cung Cấp", "Loại", "Mô Tả", "Số Lượng",
				"Giá Nhập", "Giá Bán" };
		modelVPP = new DefaultTableModel(headerVPP, 0);
		tableVPP = new JTable(modelVPP);
		scrVPP.setViewportView(tableVPP);
		tableVPP.setRowSelectionAllowed(true);
		
		panelVPP.setLayout(gl_panelVPP);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

		// thiết lập dữ liệu cho table
		try {
			sanPham = new SanPham_DAO();
			for (SanPham sp : sanPham.getAllSanPham()) {
				Object[] row = { sp.getMaSanPham(), sp.getTenSanPham(), sp.getTacGia(), sp.getNhaCungCap(),
						sp.getLoai(), sp.getMoTa(), sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan() };
				modelSach.addRow(row);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
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
		Image img2 = img.getScaledInstance(lblHinhAnhSach.getWidth(), lblHinhAnhSach.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(img2);
		return image;
	}
}
