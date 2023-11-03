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
	private DefaultTableModel modelTaiKhoan;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public CapNhatNhanVienForm() {
		setSize(1100, 650);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1577, 640);
		panel.setBackground(Color.WHITE);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 41, 1557, 274);
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBorder(UIManager.getBorder("TitledBorder.border"));

		JLabel lblNewLabel_1 = new JLabel("Mã NV:");
		lblNewLabel_1.setBounds(84, 32, 46, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_1_1 = new JLabel("Họ Tên:");
		lblNewLabel_1_1.setBounds(84, 61, 46, 14);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_1_2 = new JLabel("Địa chỉ:");
		lblNewLabel_1_2.setBounds(84, 90, 63, 14);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_1_3 = new JLabel("Điện thoại:");
		lblNewLabel_1_3.setBounds(84, 120, 77, 14);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_1_4 = new JLabel("Email:");
		lblNewLabel_1_4.setBounds(84, 151, 46, 14);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtMa = new JTextField();
		txtMa.setBounds(166, 27, 296, 26);
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtMa.setColumns(10);

		txtTen = new JTextField();
		txtTen.setBounds(166, 57, 296, 26);
		txtTen.setColumns(10);

		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(166, 87, 296, 26);
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtDiaChi.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(166, 147, 296, 26);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		txtEmail.setColumns(10);

		JLabel lblNewLabel_1_5 = new JLabel("Ngày sinh:");
		lblNewLabel_1_5.setBounds(651, 32, 63, 14);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_1_1_1 = new JLabel("Chức vụ:");
		lblNewLabel_1_1_1.setBounds(651, 90, 63, 14);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setBounds(678, 216, 119, 39);
		btnLamMoi.setIcon(new ImageIcon(CapNhatNhanVienForm.class.getResource("/icon/refresh.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 11));

		txtphone = new JTextField();
		txtphone.setBounds(166, 116, 296, 26);
		txtphone.setColumns(10);

		JLabel lblNewLabel_1_3_1 = new JLabel("Giới tính:");
		lblNewLabel_1_3_1.setBounds(651, 61, 63, 14);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		rdoNam = new JRadioButton("Nam");
		rdoNam.setBounds(734, 56, 77, 23);
		buttonGroup_1.add(rdoNam);
		rdoNam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdoNam.setBackground(SystemColor.controlHighlight);

		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBounds(851, 56, 77, 23);
		buttonGroup_1.add(rdoNu);
		rdoNu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdoNu.setBackground(SystemColor.controlHighlight);

		ButtonGroup buttonGroup = new ButtonGroup();

		dcsDate = new JDateChooser();
		dcsDate.setBounds(737, 20, 191, 26);

		JLabel lblNewLabel_1_3_1_1 = new JLabel("Trạng thái:");
		lblNewLabel_1_3_1_1.setBounds(651, 120, 77, 14);
		lblNewLabel_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		rdoDangLam = new JRadioButton("Đang làm");
		rdoDangLam.setBounds(734, 120, 77, 23);
		buttonGroup_2.add(rdoDangLam);
		rdoDangLam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdoDangLam.setBackground(SystemColor.controlHighlight);

		rdoDaNghi = new JRadioButton("Đã nghỉ");
		rdoDaNghi.setBounds(851, 120, 77, 23);
		buttonGroup_2.add(rdoDaNghi);
		rdoDaNghi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdoDaNghi.setBackground(SystemColor.controlHighlight);

		btnTaoMoi = new JButton("Tạo mới");
		btnTaoMoi.setBounds(316, 215, 114, 41);
		btnTaoMoi.setIcon(new ImageIcon(CapNhatNhanVienForm.class.getResource("/icon/add.png")));
		btnTaoMoi.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnCpNht = new JButton("Cập nhật");
		btnCpNht.setBounds(490, 215, 131, 41);
		btnCpNht.setIcon(new ImageIcon(CapNhatNhanVienForm.class.getResource("/icon/edit.png")));
		btnCpNht.setFont(new Font("Tahoma", Font.BOLD, 11));

		cmbChucVu = new JComboBox();
		cmbChucVu.setBounds(737, 87, 156, 26);
		cmbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		cmbChucVu.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên quản lý", "Nhân viên bán hàng", "Nhân viên tư vấn", "Bảo vệ", "Nhân viên vệ sinh"}));

		JLabel lblTrinhDo = new JLabel("Trình độ:");
		lblTrinhDo.setBounds(651, 158, 63, 14);
		lblTrinhDo.setFont(new Font("Tahoma", Font.BOLD, 12));

		rdoDH = new JRadioButton("Đại học");
		rdoDH.setBounds(734, 156, 103, 21);
		buttonGroup.add(rdoDH);
		rdoDH.setBackground(SystemColor.controlHighlight);
		rdoDH.setFont(new Font("Tahoma", Font.PLAIN, 12));

		rdoPT = new JRadioButton("Phổ thông");
		rdoPT.setBounds(851, 156, 103, 21);
		buttonGroup.add(rdoPT);
		rdoPT.setBackground(SystemColor.controlHighlight);
		rdoPT.setFont(new Font("Tahoma", Font.PLAIN, 12));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 333, 1567, 255);
		tabbedPane.setBackground(SystemColor.controlHighlight);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("DS Thông Tin", null, panel_3, null);
		
		String[] headerDangLamViec = { "Mã NV", "Họ tên", "Ngày sinh", "Giới tính", "SĐT", "Email", "Địa chỉ",
				"Chức Vụ", "Trạng thái làm việc", "Trình Độ" };
		modelNhanVien = new DefaultTableModel(headerDangLamViec, 0);
		panel_3.setLayout(null);
		tblNhanVien = new JTable(modelNhanVien);
		tblNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tblNhanVien.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scpThongTin = new JScrollPane(tblNhanVien, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scpThongTin.setBounds(0, 0, 1067, 228);
		panel_3.add(scpThongTin);

		JLabel lblThngTinNhn = new JLabel("Thông tin nhân viên");
		lblThngTinNhn.setBounds(20, 11, 159, 24);
		lblThngTinNhn.setFont(new Font("Tahoma", Font.BOLD, 15));
		

		// Đăng ký sự kiện

		// thiết lập dữ liệu cho table bảng
		try {
			NhanVien = new NhanVien_DAO();
			for (NhanVien nv : NhanVien.getAllNhanVien()) {
				Object[] rowNV = { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(), nv.getGioiTinh(),
						nv.getSoDienThoai(), nv.getEmail(), nv.getDiaChi(), nv.getChucVu(), nv.getTrangThaiLamViec(),
						nv.getTrinhDo() };
				modelNhanVien.addRow(rowNV);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		
		tblNhanVien.addMouseListener(this);
		btnTaoMoi.addActionListener(this);
		btnCpNht.addActionListener(this);
		btnLamMoi.addActionListener(this);
		setLayout(null);
		add(panel);
		panel.setLayout(null);
		panel.add(tabbedPane);
		panel.add(lblThngTinNhn);
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel_1);
		panel_1.add(txtMa);
		panel_1.add(lblNewLabel_1_5);
		panel_1.add(dcsDate);
		panel_1.add(lblNewLabel_1_1);
		panel_1.add(txtTen);
		panel_1.add(lblNewLabel_1_3_1);
		panel_1.add(rdoNam);
		panel_1.add(rdoNu);
		panel_1.add(lblNewLabel_1_2);
		panel_1.add(txtDiaChi);
		panel_1.add(lblNewLabel_1_1_1);
		panel_1.add(cmbChucVu);
		panel_1.add(lblNewLabel_1_3);
		panel_1.add(txtphone);
		panel_1.add(lblNewLabel_1_3_1_1);
		panel_1.add(rdoDangLam);
		panel_1.add(rdoDaNghi);
		panel_1.add(lblNewLabel_1_4);
		panel_1.add(txtEmail);
		panel_1.add(lblTrinhDo);
		panel_1.add(rdoDH);
		panel_1.add(rdoPT);
		panel_1.add(btnTaoMoi);
		panel_1.add(btnCpNht);
		panel_1.add(btnLamMoi);
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
	private NhanVien revertNhanVienFromtxt() {
		NhanVien nv = null;
		String maNV = txtMa.getText();
		String hoTen = txtTen.getText();
		Date ngaySinh= dcsDate.getDate();
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
				trangThaiLamViec,trinhDo);
		return nv;
	}

	private boolean validDataNhanVien() {
		String maNV = txtMa.getText().trim();
		String hoTen = txtTen.getText().trim();
		Date ngaySinh = dcsDate.getDate();
		String dienThoai = txtphone.getText().trim();
		String email = txtEmail.getText().trim();
		String diaChi= txtDiaChi.getText().trim();
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
		if (diaChi.length() <= 0) {
			showMessage(" Địa chỉ không hợp lệ", txtDiaChi);
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
	nv.getDiaChi(), nv.getChucVu(), nv.getTrangThaiLamViec(), nv.getTrinhDo() };
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

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(tblNhanVien)) {
			int rowNV = tblNhanVien.getSelectedRow();
			if (rowNV >= 0) {
				txtMa.setText(tblNhanVien.getValueAt(rowNV, 0).toString());
				txtTen.setText(tblNhanVien.getValueAt(rowNV, 1).toString());
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
