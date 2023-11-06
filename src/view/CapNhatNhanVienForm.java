package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import entity.NhanVien;
import dao.NhanVien_DAO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class CapNhatNhanVienForm extends JPanel implements ActionListener, MouseListener {

	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTable tblNhanVien;
	private JTextField txtphone;
	private JDateChooser dcsDate;
	private JRadioButton rdoNam, rdoNu, rdoDangLam, rdoDaNghi, rdoDH, rdoPT;
	private JTabbedPane tabbedPane;
	private JComboBox<String> cmbChucVu;
	private JButton btnTaoMoi, btnCpNht, btnLamMoi;
	private NhanVien_DAO NhanVien;
	private DefaultTableModel modelNhanVien;
	private final ButtonGroup btngrpGioiTinh = new ButtonGroup();
	private final ButtonGroup btngrpTrangThai = new ButtonGroup();
	private final ButtonGroup btngrpTrinhDo  = new ButtonGroup();
	private JTextField txtTenDangNhap;
	private JTextField txtMatKhau;

	/**
	 * Create the panel.
	 */
	public CapNhatNhanVienForm() {
		setSize(1100, 650);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBorder(UIManager.getBorder("TitledBorder.border"));

		JLabel lblNewLabel_1 = new JLabel("Mã NV:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_1_1 = new JLabel("Họ Tên:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_1_3 = new JLabel("Điện thoại:");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_1_4 = new JLabel("Email:");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtMa.setColumns(10);

		txtTen = new JTextField();
		txtTen.setColumns(10);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDiaChi.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtEmail.setColumns(10);

		JLabel lblNewLabel_1_5 = new JLabel("Ngày sinh:");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_1_1_1 = new JLabel("Chức vụ:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(CapNhatNhanVienForm.class.getResource("/icon/refresh.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 11));

		txtphone = new JTextField();
		txtphone.setColumns(10);

		JLabel lblNewLabel_1_3_1 = new JLabel("Giới tính:");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		rdoNam = new JRadioButton("Nam");
		btngrpGioiTinh.add(rdoNam);
		rdoNam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdoNam.setBackground(SystemColor.controlHighlight);

		rdoNu = new JRadioButton("Nữ");
		btngrpGioiTinh.add(rdoNu);
		rdoNu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdoNu.setBackground(SystemColor.controlHighlight);


		dcsDate = new JDateChooser();

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Trạng thái:");
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		rdoDangLam = new JRadioButton("Đang làm");
		btngrpTrangThai.add(rdoDangLam);
		rdoDangLam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdoDangLam.setBackground(SystemColor.controlHighlight);

		rdoDaNghi = new JRadioButton("Đã nghỉ");
		btngrpTrangThai.add(rdoDaNghi);
		rdoDaNghi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdoDaNghi.setBackground(SystemColor.controlHighlight);

		btnTaoMoi = new JButton("Tạo mới");
		btnTaoMoi.setIcon(new ImageIcon(CapNhatNhanVienForm.class.getResource("/icon/add.png")));
		btnTaoMoi.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnCpNht = new JButton("Cập nhật");
		btnCpNht.setIcon(new ImageIcon(CapNhatNhanVienForm.class.getResource("/icon/edit.png")));
		btnCpNht.setFont(new Font("Tahoma", Font.BOLD, 11));

		cmbChucVu = new JComboBox();
		cmbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cmbChucVu.setModel(new DefaultComboBoxModel(new String[] {"","Nhân viên quản lý", "Nhân viên bán hàng", "Nhân viên tư vấn", "Bảo vệ", "Nhân viên vệ sinh"}));
		JLabel lblTrinhDo = new JLabel("Trình độ:");
		lblTrinhDo.setFont(new Font("Tahoma", Font.BOLD, 12));

		rdoDH = new JRadioButton("Đại học");
		btngrpTrinhDo.add(rdoDH);
		rdoDH.setBackground(SystemColor.controlHighlight);
		rdoDH.setFont(new Font("Tahoma", Font.PLAIN, 12));

		rdoPT = new JRadioButton("Phổ thông");
		btngrpTrinhDo.add(rdoPT);
		rdoPT.setBackground(SystemColor.controlHighlight);
		rdoPT.setFont(new Font("Tahoma", Font.PLAIN, 12));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(SystemColor.controlHighlight);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("DS Thông Tin", null, panel_3, null);
		
		String[] headerDangLamViec = { "Mã NV", "Họ tên", "Ngày sinh", "Giới tính", "SĐT", "Email", "Địa chỉ",
				"Chức Vụ", "Trạng thái làm việc", "Trình Độ", "Tên Đăng Nhập", "Mật khẩu" };
		modelNhanVien = new DefaultTableModel(headerDangLamViec, 0);
		tblNhanVien = new JTable(modelNhanVien);
		tblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblNhanVien.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scpThongTin = new JScrollPane(tblNhanVien, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(scpThongTin, GroupLayout.PREFERRED_SIZE, 1178, GroupLayout.PREFERRED_SIZE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(scpThongTin, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
		);
		panel_3.setLayout(gl_panel_3);

		JLabel lblThngTinNhn = new JLabel("Thông tin nhân viên");
		lblThngTinNhn.setFont(new Font("Tahoma", Font.BOLD, 15));
		

		// Đăng ký sự kiện

		// thiết lập dữ liệu cho table bảng
		try {
			NhanVien = new NhanVien_DAO();
			for (NhanVien nv : NhanVien.getAllNhanVien()) {
				Object[] rowNV = { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(), nv.getGioiTinh(),
						nv.getSoDienThoai(), nv.getEmail(), nv.getDiaChi(), nv.getChucVu(), nv.getTrangThaiLamViec(),
						nv.getTrinhDo(), nv.getTenDangNhap(), nv.getMatKhau() };
				modelNhanVien.addRow(rowNV);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		
		// đăng ký sự kiện
		tblNhanVien.addMouseListener(this);
		btnTaoMoi.addActionListener(this);
		btnCpNht.addActionListener(this);
		btnLamMoi.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("Tên Đăng Nhập:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtTenDangNhap.setColumns(10);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Mật Khẩu:");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtMatKhau = new JTextField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtMatKhau.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(lblThngTinNhn, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1157, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblThngTinNhn, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 341, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(82)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(txtMa, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addGap(175)
					.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(60)
					.addComponent(rdoNam, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addComponent(rdoNu, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(82)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addGap(175)
					.addComponent(lblNewLabel_1_3_1_1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(rdoDangLam, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addComponent(rdoDaNghi, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(82)
					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addGap(175)
					.addComponent(lblTrinhDo, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(60)
					.addComponent(rdoDH, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(rdoPT, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(82)
					.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(txtphone, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addGap(175)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(txtTenDangNhap, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(82)
					.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addGap(175)
					.addComponent(lblNewLabel_1_3_2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(txtMatKhau, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(82)
					.addComponent(lblNewLabel_1_5)
					.addGap(19)
					.addComponent(dcsDate, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(82)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(cmbChucVu, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(301)
					.addComponent(btnTaoMoi, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addGap(82)
					.addComponent(btnCpNht, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(62)
					.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtMa, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(rdoNam))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(rdoNu)))
					.addGap(4)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_1_3_1_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdoDangLam)
						.addComponent(rdoDaNghi))
					.addGap(4)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblTrinhDo, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdoDH, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdoPT, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(2)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(txtphone, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtTenDangNhap, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(5)
							.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNewLabel_1_3_2, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(4)
							.addComponent(txtMatKhau, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_5, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(dcsDate, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE))
						.addComponent(cmbChucVu, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCpNht, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnTaoMoi, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(1)
							.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
	}

	private void showMessage(String message, JTextField txt) {
		JOptionPane.showMessageDialog(null, message);
		txt.requestFocus();
	}
	private void showMessage1(String message, JDateChooser dcsDate2) {
		JOptionPane.showMessageDialog(null, message);
		dcsDate2.requestFocus();
	}
	private void showMessage2(String message, JRadioButton rdoNam2) {
		JOptionPane.showMessageDialog(null, message);
		rdoNam2.requestFocus();
	}
	private void showMessage3(String message, JComboBox<String> cmbChucVu2) {
		JOptionPane.showMessageDialog(null, message);
		cmbChucVu2.requestFocus();
	}
	private NhanVien revertNhanVienFromtxt() {
		NhanVien nv = null;
		String maNV = txtMa.getText();
		String hoTen = txtTen.getText();
		Date ngaySinh= dcsDate.getDate();
		String tenDangNhap =txtTenDangNhap.getText();
		String matKhau=txtMatKhau.getText();
		String gioiTinh = null;
		if (rdoNam.isSelected())
			gioiTinh = rdoNam.getText();
		else if (rdoNu.isSelected())
		gioiTinh = rdoNu.getText();
		String dienThoai = txtphone.getText();
		String email = txtEmail.getText();
		String diaChi = txtDiaChi.getText();
		String chucVu = (String) cmbChucVu.getSelectedItem();
		String trangThaiLamViec=null;
		if (rdoDangLam.isSelected())
			 trangThaiLamViec= rdoDangLam.getText();
		else if (rdoDaNghi.isSelected())
			trangThaiLamViec= rdoDaNghi.getText();
		String trinhDo= null;
		if(rdoDH.isSelected())
			trinhDo= rdoDH.getText();
		else if(rdoPT.isSelected())
			trinhDo= rdoPT.getText();
		nv = new NhanVien(maNV, hoTen,new java.sql.Date(ngaySinh.getTime()), gioiTinh,dienThoai, email, diaChi,chucVu,
				trangThaiLamViec,trinhDo,tenDangNhap, matKhau);
		return nv;
	}

	private boolean validDataNhanVien() {
		String maNV = txtMa.getText().trim();
		String hoTen = txtTen.getText().trim();
		Date ngaySinh = dcsDate.getDate();
		String dienThoai = txtphone.getText().trim();
		String email = txtEmail.getText().trim();
		String diaChi= txtDiaChi.getText().trim();
		String tenDangNhap= txtTenDangNhap.getText().trim();
		String matKhau= txtMatKhau.getText().trim();
		 boolean isMaleSelected = rdoNam.isSelected();
		 boolean isFemaleSelected = rdoNu.isSelected();
		 boolean isDangLam = rdoDangLam.isSelected();
		 boolean isDaNghi= rdoDaNghi.isSelected();
		 boolean isDH= rdoDH.isSelected();
		 boolean isPT= rdoPT.isSelected();
		 
			if (!(maNV.length() > 0)) {
			showMessage("Mã nhân viên không được rỗng", txtMa);
			return false;
		} else if (!maNV.matches("NV\\d{4}")) {
			showMessage("Mã nhân viên phải có dạng NV\\d{4}", txtMa);
			return false;
		}
		if (hoTen.length() <= 0 || !hoTen.matches("^[A-Z]\\p{L}+(\\s[A-Z]\\p{L}*)+")) {
			showMessage("Tên Nhân viên không hợp lệ ", txtTen);
			return false;
		}
		if (dienThoai.length() <= 0 || !dienThoai.matches("^0[1-9]{9}")) {
			showMessage("Số điện thoại không hợp lệ. Số điện thoại gồm 10 số ", txtphone);
			return false;
		}
		if (email.length() <= 0 || !email.matches("[a-z]\\w+@(gmail|yahoo|iuh|example)\\.com")) {
			showMessage(" Email không hợp lệ ", txtEmail);
			return false;
		}
		if (ngaySinh != null) {
	        Calendar currentDate = Calendar.getInstance();
	        Calendar birthDate = Calendar.getInstance();
	        birthDate.setTime(ngaySinh);

	        int age = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

	        if (age < 18) {
	            showMessage1("Người này chưa đủ 18 tuổi", dcsDate);
	            return false;
	        }
	    } else {
	        showMessage1("Ngày sinh không được để trống", dcsDate);
	        return false;
	    }
		if (diaChi.length() <= 0) {
			showMessage(" Địa chỉ không được rỗng", txtDiaChi);
			return false;
		}
		
		if (cmbChucVu.getSelectedItem() == "") {
	        showMessage3("Chức vụ không được rỗng", cmbChucVu);
	        return false;
	    }
		if (!isMaleSelected && !isFemaleSelected) {
	        showMessage2("Vui lòng chọn giới tính", rdoNam);
	        return false;
	    }
		if (!isDangLam && !isDaNghi) {
	        showMessage2("Vui lòng chọn Trạng thái làm việc", rdoDaNghi);
	        return false;
	    }
		if (!isDH && !isPT) {
	        showMessage2("Vui lòng chọn trình độ", rdoDH);
	        return false;
	    }
		if (tenDangNhap.length() <= 0) {
		    showMessage("Tên đăng nhập không được rỗng", txtTenDangNhap);
		    return false;
		}

		if (!tenDangNhap.matches("NV\\d{4}")) {
		    showMessage("Tên đăng nhập phải có dạng NV\\d{4}", txtTenDangNhap);
		    return false;
		}

		// Compare tenDangNhap with maNV
		if (!tenDangNhap.equals(maNV)) {
		    showMessage("Tên đăng nhập phải giống với Mã nhân viên", txtTenDangNhap);
		    return false;
		}


		if (matKhau.length() <= 0) {
			showMessage(" Mật khẩu không được rỗng", txtMatKhau);
			return false;
		}

	    return true;	
	}
	

	private boolean checkExist() {
		String maNV = txtMa.getText().trim();
		if (true) {
			DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
			boolean isMaNVTrung = false;
			for (int i = 0; i < model.getRowCount(); i++) {
				String maNVTable = model.getValueAt(i, 0).toString();
				if (maNVTable.equals(maNV)) {
					isMaNVTrung = true;
					break;
				}
			}
			if (isMaNVTrung) {
				showMessage("Mã nhân viên đã tồn tại trong danh sách", txtMa);
				return false;
			}
		}
		return true;
	}

	private void them() {
		if (validDataNhanVien() && checkExist()) {
			NhanVien nv = revertNhanVienFromtxt();
			Object[] rowNV = { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(), nv.getGioiTinh(),nv.getSoDienThoai() ,nv.getEmail(),
	nv.getDiaChi(), nv.getChucVu(), nv.getTrangThaiLamViec(), nv.getTrinhDo(), nv.getTenDangNhap(), nv.getMatKhau() };
			modelNhanVien.addRow(rowNV);
			NhanVien.themNhanVien(nv);
			JOptionPane.showMessageDialog(null, "Thêm thành công");
			}

		}

	private void sua() {
		int row = tblNhanVien.getSelectedRow();
		NhanVien nv = revertNhanVienFromtxt();
		String selectedmaNhanVien = tblNhanVien.getValueAt(row, 0).toString();
		if (!nv.getMaNhanVien().equals(selectedmaNhanVien)) {
			JOptionPane.showMessageDialog(null, "Không được thay đổi mã nhân viên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}

		else {			
			modelNhanVien.setValueAt(nv.getTenNhanVien(), row, 1);
			modelNhanVien.setValueAt(nv.getNgaySinh(), row, 2);
			modelNhanVien.setValueAt(nv.getGioiTinh(), row, 3);
			modelNhanVien.setValueAt(nv.getSoDienThoai(), row, 4);
			modelNhanVien.setValueAt(nv.getEmail(), row, 5);
			modelNhanVien.setValueAt(nv.getDiaChi(), row, 6);
			modelNhanVien.setValueAt(nv.getChucVu(), row, 7);
			modelNhanVien.setValueAt(nv.getTrangThaiLamViec(), row, 8);
			modelNhanVien.setValueAt(nv.getTrinhDo(), row, 9);
			modelNhanVien.setValueAt(nv.getTenDangNhap(), row, 10);
			modelNhanVien.setValueAt(nv.getMatKhau(), row, 11);
			modelNhanVien.fireTableRowsUpdated(row, row);
			NhanVien.suaNhanVien(nv);
			JOptionPane.showMessageDialog(null,
					"Thực hiện sửa đổi thành công thông tin nhân viên có mã: " + nv.getMaNhanVien());
		}

	}
	
	private void lamMoi() {
		tblNhanVien.clearSelection();
		txtMa.setText("");
		txtTen.setText("");
		dcsDate.setDate(null);
		txtDiaChi.setText("");
		txtphone.setText("");
		txtEmail.setText("");
		txtDiaChi.setText("");
		txtTenDangNhap.setText("");
		txtMatKhau.setText("");
		cmbChucVu.setSelectedItem("");
		btngrpGioiTinh.clearSelection();
		btngrpTrangThai.clearSelection();
		btngrpTrinhDo.clearSelection();
		


	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(tblNhanVien)) {
			int rowNV = tblNhanVien.getSelectedRow();
			if (rowNV >= 0) {
				txtMa.setText(tblNhanVien.getValueAt(rowNV, 0).toString());
				txtTen.setText(tblNhanVien.getValueAt(rowNV, 1).toString());
				txtTenDangNhap.setText(tblNhanVien.getValueAt(rowNV, 10).toString());
				txtMatKhau.setText(tblNhanVien.getValueAt(rowNV, 11).toString());
				//Lấy dữ liệu từ Jdatechooser
				// Lấy giá trị ngày tháng từ cột 2 của hàng có chỉ số rowNV
				String ngaySinhStr = tblNhanVien.getValueAt(rowNV, 2).toString();
				// Chuyển đổi giá trị ngày sinh từ kiểu chuỗi sang kiểu Date
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					java.util.Date ngaySinh = dateFormat.parse(ngaySinhStr);
					dcsDate.setDate(ngaySinh);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				//đẩy dữ liệu lên radio
				if (modelNhanVien.getValueAt(rowNV, 3).toString().equalsIgnoreCase("Nam")) {
					rdoNam.setSelected(true);
					rdoNu.setSelected(false);
				} else {
					rdoNu.setSelected(true);
					rdoNam.setSelected(false);
				}
				txtphone.setText(tblNhanVien.getValueAt(rowNV, 4).toString());
				txtEmail.setText(tblNhanVien.getValueAt(rowNV, 5).toString());
				txtDiaChi.setText(tblNhanVien.getValueAt(rowNV, 6).toString());
				//đẩy dữ liệu  lên comboBox
				cmbChucVu.setSelectedItem(tblNhanVien.getValueAt(rowNV, 7).toString());
				//đẩy dữ liệu lên button
				if (modelNhanVien.getValueAt(rowNV, 8).toString().equalsIgnoreCase("Đang làm việc")) {
					rdoDangLam.setSelected(true);
					rdoDaNghi.setSelected(false);
				} else {
					rdoDaNghi.setSelected(true);
					rdoDangLam.setSelected(false);
				}
				if (modelNhanVien.getValueAt(rowNV, 9).toString().equalsIgnoreCase("Đại học")) {
					rdoDH.setSelected(true);
					rdoPT.setSelected(false);
				} else {
					rdoDH.setSelected(true);
					rdoPT.setSelected(false);
				}
					
				
			}
	}
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTaoMoi))
			them();
		else if (o.equals(btnCpNht))
			sua();
		else if (o.equals(btnLamMoi))
			lamMoi();

	}
}
