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

public class CapNhatSanPhamForm extends JPanel {
	private JTable tableSach;
	private DefaultTableModel modelSach;
	private JTable tableVPP;
	private DefaultTableModel modelVPP;
	private SanPham_DAO sanPham;
	private JTextField txtTimKiem;
	private JTextField txtMaSach;
	private JLabel lbHinhAnh;
	private JLabel lbTenSach;
	private JTextArea textAreaMoTa;
	private JTextField txtTacGia;
	private JTextField txtTheLoai;
	private JTextField txtSoLuong;
	private JTextField txtGiaNhap;
	private JTextField txtGiaBan;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	/**
	 * Create the panel.
	 */
	public CapNhatSanPhamForm() {
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		defaults.put("Button.focusPainted", false); // Tắt viền focus
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1130, 670);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1110, 648);
		add(tabbedPane);
		
		JPanel panelSach = new JPanel();
		panelSach.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Sách", null, panelSach, null);
		
		String[] headerDH = { "Mã Sách", "Tên Sách", "Tác Giả"," Nhà Cung Cấp",  "Thể Loại",  "Mô Tả","Số Lượng", "Giá Nhập", "Giá Bán" };
		modelSach = new DefaultTableModel(headerDH, 0);
		tableSach = new JTable(modelSach);
		JScrollPane scpSach = new JScrollPane(tableSach, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tìm Kiếm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
	lbHinhAnh = new JLabel("hình ảnh");
		lbHinhAnh.setIcon(new ImageIcon(CapNhatSanPhamForm.class.getResource("/icon/Thesis-pana.png")));
		
		JLabel lblNewLabel_2 = new JLabel("Tên Sách");
		
		JLabel lbTenSach = new JLabel("");
		
		JLabel lblNewLabel_4 = new JLabel("Mã Sách");
		
		txtMaSach = new JTextField();
		txtMaSach.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Tác Giả");
		
		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		
		JLabel lblNewLabel_4_2 = new JLabel("Thể Loại");
		
		txtTheLoai = new JTextField();
		txtTheLoai.setColumns(10);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Số Lượng");
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Nhà Cung Cấp");
		
		JComboBox cbbNhaCungCap = new JComboBox();
		
		txtGiaNhap = new JTextField();
		txtGiaNhap.setColumns(10);
		
		JLabel lblNewLabel_4_3 = new JLabel("Giá Nhập");
		
		JLabel lblNewLabel_4_3_1 = new JLabel("Giá Bán");
		
		txtGiaBan = new JTextField();
		txtGiaBan.setColumns(10);
		
		JLabel lblNewLabel_4_3_1_1 = new JLabel("Mô Tả");
		
	 textAreaMoTa = new JTextArea();
		
		JButton btnTaoMoi = new JButton("Tạo Mới");
		
		JButton btCapNhat = new JButton("Cập Nhật");
		
		JButton btLamMoi = new JButton("Làm Mới");
		
		JButton btThemAnh = new JButton("Thêm Ảnh");
		btThemAnh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser file = new JFileChooser();
				file.setCurrentDirectory(new File(System.getProperty("user.home")));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.image","jpg","png");
				file.addChoosableFileFilter(filter);
				int result = file.showSaveDialog(null);
				if(result == JFileChooser.APPROVE_OPTION) {
					File selectFile = file.getSelectedFile();
					String path = selectFile.getAbsolutePath();
					lbHinhAnh.setIcon(ResizeImage(path, null));
					
				}
				else {
					System.out.println("No File Select");
				}
				
			}
		});
		GroupLayout gl_panelSach = new GroupLayout(panelSach);
		gl_panelSach.setHorizontalGroup(
			gl_panelSach.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSach.createSequentialGroup()
					.addGap(12)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelSach.createSequentialGroup()
					.addGap(12)
					.addComponent(scpSach, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE)
					.addGap(61)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGap(19)
							.addComponent(lbHinhAnh, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGap(105)
							.addComponent(btThemAnh, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSach.createSequentialGroup()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lbTenSach, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))))
				.addGroup(gl_panelSach.createSequentialGroup()
					.addGap(35)
					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(txtMaSach, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(99)
					.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(txtGiaNhap, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(66)
					.addComponent(lblNewLabel_4_2_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(3)
					.addComponent(txtTacGia, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelSach.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4_2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addComponent(txtTheLoai, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(99)
					.addComponent(lblNewLabel_4_3_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(txtGiaBan, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelSach.createSequentialGroup()
					.addGap(35)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4_1_1_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbbNhaCungCap, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
					.addGap(99)
					.addComponent(lblNewLabel_4_3_1_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(textAreaMoTa, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(btnTaoMoi, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btCapNhat, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(btLamMoi, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelSach.setVerticalGroup(
			gl_panelSach.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSach.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTimKiem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGap(17)
							.addComponent(scpSach, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSach.createSequentialGroup()
							.addComponent(lbHinhAnh, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(btThemAnh, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2)
								.addComponent(lbTenSach, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
					.addGap(8)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMaSach, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtGiaNhap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4_2_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTacGia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTheLoai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4_3_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtGiaBan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panelSach.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGap(23)
							.addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(lblNewLabel_4_1_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGap(23)
							.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(cbbNhaCungCap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGap(23)
							.addComponent(lblNewLabel_4_3_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelSach.createSequentialGroup()
							.addGap(21)
							.addComponent(textAreaMoTa, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnTaoMoi, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btCapNhat, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btLamMoi, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
		);
		panelSach.setLayout(gl_panelSach);
		
		JPanel panelVPP = new JPanel();
		panelVPP.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Văn phòng phẩm & Quà lưu niệm", null, panelVPP, null);
		
		JScrollPane scpSach_1 = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Tìm Kiếm");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_1_1 = new JLabel("hình ảnh");
		lblNewLabel_1_1.setIcon(new ImageIcon(CapNhatSanPhamForm.class.getResource("/icon/Thesis-pana.png")));
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên Sản Phẩm");
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		
		JLabel lblNewLabel_4_4 = new JLabel("Mã Sản Phẩm");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("");
		
		JLabel lblNewLabel_4_2_2 = new JLabel("Thể Loại");
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("Số Lượng");
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Nhà Cung Cấp");
		
		JComboBox comboBox_1 = new JComboBox();
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_4_3_2 = new JLabel("Giá Nhập");
		
		JLabel lblNewLabel_4_3_1_2 = new JLabel("Giá Bán");
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		
		JLabel lblNewLabel_4_3_1_1_1 = new JLabel("Mô Tả");
		
		JTextArea textArea_1 = new JTextArea();
		
		JButton btnNewButton_1 = new JButton("Tạo Mới");
		
		JButton btnCpNht_1 = new JButton("Cập Nhật");
		
		JButton btnLmMi_1 = new JButton("Làm Mới");
		GroupLayout gl_panelVPP = new GroupLayout(panelVPP);
		gl_panelVPP.setHorizontalGroup(
			gl_panelVPP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVPP.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelVPP.createSequentialGroup()
					.addGap(10)
					.addComponent(scpSach_1, GroupLayout.PREFERRED_SIZE, 678, GroupLayout.PREFERRED_SIZE)
					.addGap(65)
					.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addGap(15)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))))
				.addGroup(gl_panelVPP.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewLabel_4_4, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(99)
					.addComponent(lblNewLabel_4_3_2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelVPP.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4_2_2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4_1_2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addGap(99)
					.addComponent(lblNewLabel_4_3_1_2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panelVPP.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4_1_1_2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4_1_1_1_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
					.addGap(99)
					.addComponent(lblNewLabel_4_3_1_1_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(42)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(btnCpNht_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(btnLmMi_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
		);
		gl_panelVPP.setVerticalGroup(
			gl_panelVPP.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelVPP.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addGap(17)
							.addComponent(scpSach_1, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2_1)
								.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))))
					.addGap(11)
					.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4_3_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4_2_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4_1_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4_3_1_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panelVPP.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addGap(23)
							.addComponent(lblNewLabel_4_1_1_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(lblNewLabel_4_1_1_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addGap(23)
							.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addGap(23)
							.addComponent(lblNewLabel_4_3_1_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelVPP.createSequentialGroup()
							.addGap(21)
							.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCpNht_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLmMi_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
		);
		panelVPP.setLayout(gl_panelVPP);
		
		// thiết lập dữ liệu cho table
		try {
			sanPham = new SanPham_DAO();
			for (SanPham sp : sanPham.getAllSanPham()) {
				Object[] row = { sp.getMaSanPham(), sp.getTenSanPham(), sp.getTacGia(), sp.getNhaCungCap(), sp.getLoai(),
						 sp.getMoTa(), sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan() };
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
		if(imagePath != null ) {
			ig = new ImageIcon(imagePath);
		}else {
			ig = new ImageIcon(pic);
		}
		Image img = ig.getImage();
		Image img2 = img.getScaledInstance(lbHinhAnh.getWidth(), lbHinhAnh.getHeight(), Image.SCALE_SMOOTH );
		ImageIcon image = new ImageIcon(img2);
		return image;
	}
}





	   



