package form;

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
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1130, 670);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 1110, 648);
		add(tabbedPane);
		
		JPanel panelSach = new JPanel();
		panelSach.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Sách", null, panelSach, null);
		panelSach.setLayout(null);
		
		String[] headerDH = { "Mã Sách", "Tên Sách", "Tác Giả"," Nhà Cung Cấp",  "Thể Loại",  "Mô Tả","Số Lượng", "Giá Nhập", "Giá Bán" };
		modelSach = new DefaultTableModel(headerDH, 0);
		tableSach = new JTable(modelSach);
		JScrollPane scpSach = new JScrollPane(tableSach, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scpSach.setBounds(12, 54, 678, 287);
		panelSach.add(scpSach);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(85, 11, 156, 20);
		panelSach.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tìm Kiếm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(12, 11, 63, 20);
		panelSach.add(lblNewLabel);
		
	lbHinhAnh = new JLabel("hình ảnh");
		lbHinhAnh.setIcon(new ImageIcon(CapNhatSanPhamForm.class.getResource("/icon/Thesis-pana.png")));
		lbHinhAnh.setBounds(770, 37, 250, 245);
		panelSach.add(lbHinhAnh);
		
		JLabel lblNewLabel_2 = new JLabel("Tên Sách");
		lblNewLabel_2.setBounds(751, 340, 68, 14);
		panelSach.add(lblNewLabel_2);
		
		JLabel lbTenSach = new JLabel("");
		lbTenSach.setBounds(846, 340, 144, 14);
		panelSach.add(lbTenSach);
		
		JLabel lblNewLabel_4 = new JLabel("Mã Sách");
		lblNewLabel_4.setBounds(35, 362, 87, 20);
		panelSach.add(lblNewLabel_4);
		
		txtMaSach = new JTextField();
		txtMaSach.setBounds(139, 362, 174, 20);
		panelSach.add(txtMaSach);
		txtMaSach.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setBounds(35, 405, 87, 20);
		panelSach.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Tác Giả");
		lblNewLabel_4_2_1.setBounds(756, 362, 87, 20);
		panelSach.add(lblNewLabel_4_2_1);
		
		txtTacGia = new JTextField();
		txtTacGia.setColumns(10);
		txtTacGia.setBounds(846, 362, 174, 20);
		panelSach.add(txtTacGia);
		
		JLabel lblNewLabel_4_2 = new JLabel("Thể Loại");
		lblNewLabel_4_2.setBounds(35, 405, 87, 20);
		panelSach.add(lblNewLabel_4_2);
		
		txtTheLoai = new JTextField();
		txtTheLoai.setColumns(10);
		txtTheLoai.setBounds(139, 405, 174, 20);
		panelSach.add(txtTheLoai);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Số Lượng");
		lblNewLabel_4_1_1.setBounds(35, 456, 87, 20);
		panelSach.add(lblNewLabel_4_1_1);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(139, 456, 174, 20);
		panelSach.add(txtSoLuong);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Nhà Cung Cấp");
		lblNewLabel_4_1_1_1.setBounds(35, 510, 87, 20);
		panelSach.add(lblNewLabel_4_1_1_1);
		
		JComboBox cbbNhaCungCap = new JComboBox();
		cbbNhaCungCap.setBounds(139, 509, 174, 22);
		panelSach.add(cbbNhaCungCap);
		
		txtGiaNhap = new JTextField();
		txtGiaNhap.setColumns(10);
		txtGiaNhap.setBounds(516, 362, 174, 20);
		panelSach.add(txtGiaNhap);
		
		JLabel lblNewLabel_4_3 = new JLabel("Giá Nhập");
		lblNewLabel_4_3.setBounds(412, 362, 87, 20);
		panelSach.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_3_1 = new JLabel("Giá Bán");
		lblNewLabel_4_3_1.setBounds(412, 405, 87, 20);
		panelSach.add(lblNewLabel_4_3_1);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(516, 405, 174, 20);
		panelSach.add(txtGiaBan);
		
		JLabel lblNewLabel_4_3_1_1 = new JLabel("Mô Tả");
		lblNewLabel_4_3_1_1.setBounds(412, 456, 87, 20);
		panelSach.add(lblNewLabel_4_3_1_1);
		
	 textAreaMoTa = new JTextArea();
	 textAreaMoTa.setBounds(513, 454, 177, 81);
		panelSach.add(textAreaMoTa);
		
		JButton btTaoMoi = new JButton("Tạo Mới");
		btTaoMoi.setBounds(732, 433, 87, 29);
		panelSach.add(btTaoMoi);
		
		JButton btCapNhat = new JButton("Cập Nhật");
		btCapNhat.setBounds(846, 433, 87, 29);
		panelSach.add(btCapNhat);
		
		JButton btLamMoi = new JButton("Làm Mới");
		btLamMoi.setBounds(956, 433, 87, 29);
		panelSach.add(btLamMoi);
		
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
		btThemAnh.setBounds(856, 293, 98, 29);
		panelSach.add(btThemAnh);
		
		JPanel panelVPP = new JPanel();
		panelVPP.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Văn phòng phẩm & Quà lưu niệm", null, panelVPP, null);
		panelVPP.setLayout(null);
		
		JScrollPane scpSach_1 = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scpSach_1.setBounds(10, 54, 678, 287);
		panelVPP.add(scpSach_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(83, 11, 156, 20);
		panelVPP.add(textField_6);
		
		JLabel lblNewLabel_5 = new JLabel("Tìm Kiếm");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setBounds(10, 11, 63, 20);
		panelVPP.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("hình ảnh");
		lblNewLabel_1_1.setIcon(new ImageIcon(CapNhatSanPhamForm.class.getResource("/icon/Thesis-pana.png")));
		lblNewLabel_1_1.setBounds(768, 37, 250, 256);
		panelVPP.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên Sản Phẩm");
		lblNewLabel_2_1.setBounds(753, 337, 93, 14);
		panelVPP.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setBounds(886, 337, 144, 14);
		panelVPP.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_4 = new JLabel("Mã Sản Phẩm");
		lblNewLabel_4_4.setBounds(33, 362, 87, 20);
		panelVPP.add(lblNewLabel_4_4);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(137, 362, 174, 20);
		panelVPP.add(textField_7);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("");
		lblNewLabel_4_1_2.setBounds(33, 405, 87, 20);
		panelVPP.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_4_2_2 = new JLabel("Thể Loại");
		lblNewLabel_4_2_2.setBounds(33, 405, 87, 20);
		panelVPP.add(lblNewLabel_4_2_2);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(137, 405, 174, 20);
		panelVPP.add(textField_9);
		
		JLabel lblNewLabel_4_1_1_2 = new JLabel("Số Lượng");
		lblNewLabel_4_1_1_2.setBounds(33, 456, 87, 20);
		panelVPP.add(lblNewLabel_4_1_1_2);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(137, 456, 174, 20);
		panelVPP.add(textField_10);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Nhà Cung Cấp");
		lblNewLabel_4_1_1_1_1.setBounds(33, 510, 87, 20);
		panelVPP.add(lblNewLabel_4_1_1_1_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(137, 509, 174, 22);
		panelVPP.add(comboBox_1);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(514, 362, 174, 20);
		panelVPP.add(textField_11);
		
		JLabel lblNewLabel_4_3_2 = new JLabel("Giá Nhập");
		lblNewLabel_4_3_2.setBounds(410, 362, 87, 20);
		panelVPP.add(lblNewLabel_4_3_2);
		
		JLabel lblNewLabel_4_3_1_2 = new JLabel("Giá Bán");
		lblNewLabel_4_3_1_2.setBounds(410, 405, 87, 20);
		panelVPP.add(lblNewLabel_4_3_1_2);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(514, 405, 174, 20);
		panelVPP.add(textField_12);
		
		JLabel lblNewLabel_4_3_1_1_1 = new JLabel("Mô Tả");
		lblNewLabel_4_3_1_1_1.setBounds(410, 456, 87, 20);
		panelVPP.add(lblNewLabel_4_3_1_1_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(511, 454, 177, 81);
		panelVPP.add(textArea_1);
		
		JButton btnNewButton_1 = new JButton("Tạo Mới");
		btnNewButton_1.setBounds(730, 433, 87, 29);
		panelVPP.add(btnNewButton_1);
		
		JButton btnCpNht_1 = new JButton("Cập Nhật");
		btnCpNht_1.setBounds(844, 433, 87, 29);
		panelVPP.add(btnCpNht_1);
		
		JButton btnLmMi_1 = new JButton("Làm Mới");
		btnLmMi_1.setBounds(954, 433, 87, 29);
		panelVPP.add(btnLmMi_1);
		
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





	   



