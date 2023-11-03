package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.SanPham_DAO;
import entity.ChiTietHoaDon;
import entity.KhachHang;
import entity.NhanVien;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TimKiemNhanVienForm extends JPanel implements ActionListener, MouseListener{
	private DefaultTableModel model;
	private JTable tbl;
	private JTextField txtMa,txtTen,txtSdt, txtDiaChi,txtEmail;
	private final ButtonGroup groupStatus = new ButtonGroup();
	private final ButtonGroup groupGioiTinh = new ButtonGroup();
	private final ButtonGroup groupTrinhDo = new ButtonGroup();
	private JRadioButton rdoDangLam, rdoDaNghi, rdoNam, rdoNu,rdoDH, rdoPT;
	private JYearChooser ycs;
	private JComboBox<String> cmbChucVu;
	private NhanVien_DAO NhanVien;
	/**
	 * Create the panel.
	 */
	public TimKiemNhanVienForm() {
		setBackground(SystemColor.controlHighlight);
		setSize(1100, 610);
		setLayout(null);
		
		JLabel lbTieuDe = new JLabel("Tìm kiếm nhân viên");
		lbTieuDe.setBounds(277, 10, 597, 78);
		lbTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 50));
		add(lbTieuDe);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(36, 311, 1054, 301);
		this.add(scrollPane_1);
		String[] column = { "Mã NV", "Tên NV","Ngày Sinh", "Giới Tính", "Số Điện Thoại","Email","Địa chỉ","Chức vụ","Trạng thái","Trình độ"};
		model = new DefaultTableModel(column, 0);
		tbl = new JTable(model);
		scrollPane_1.setViewportView(tbl);
		tbl.setRowSelectionAllowed(true);
		
		txtSdt = new JTextField();
		txtSdt.setColumns(10);
		txtSdt.setBounds(295, 184, 278, 25);
		add(txtSdt);
		
		JLabel lblNewLabel_5 = new JLabel("Tìm kiếm theo số điện thoại");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(78, 185, 190, 21);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tìm kiếm theo tên");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_1.setBounds(78, 143, 190, 21);
		add(lblNewLabel_5_1);
		
		txtTen = new JTextField();
		txtTen.setColumns(10);
		txtTen.setBounds(295, 139, 278, 25);
		add(txtTen);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Tìm kiếm theo chức vụ");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_1_1.setBounds(78, 228, 190, 21);
		add(lblNewLabel_5_1_1);
		
		cmbChucVu = new JComboBox();
		cmbChucVu.setBounds(295, 228, 278, 25);
		cmbChucVu.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên quản lý" , "Nhân viên tư vấn", "Nhân viên bán hàng","Nhân viên vệ sinh","Bảo vệ" }));
		cmbChucVu.setSelectedItem(null);
		add(cmbChucVu);
		
		JLabel lblNewLabel_5_2 = new JLabel("Tìm kiếm theo mã:");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_2.setBounds(78, 98, 190, 21);
		add(lblNewLabel_5_2);
		
		txtMa = new JTextField();
		txtMa.setColumns(10);
		txtMa.setBounds(295, 98, 278, 25);
		add(txtMa);
		
		JLabel lblDiaChi = new JLabel("Tìm kiếm theo trạng thái làm việc");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiaChi.setBounds(78, 272, 214, 13);
		add(lblDiaChi);
		
		 rdoDangLam = new JRadioButton("Đang làm");
		 rdoDangLam.setBackground(SystemColor.controlHighlight);
		groupStatus.add(rdoDangLam);
		rdoDangLam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdoDangLam.setBounds(298, 269, 103, 21);
		add(rdoDangLam);
		
		rdoDaNghi = new JRadioButton("Đã nghỉ");
		rdoDaNghi.setBackground(SystemColor.controlHighlight);
		groupStatus.add(rdoDaNghi);
		rdoDaNghi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdoDaNghi.setBounds(452, 269, 103, 21);
		add(rdoDaNghi);
		
		JLabel lblNewLabel = new JLabel("Tìm kiếm theo Năm Sinh");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(633, 102, 163, 13);
		add(lblNewLabel);
		
		ycs = new JYearChooser();
		ycs.setBounds(806, 95, 100, 25);
		add(ycs);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm theo Địa chỉ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(633, 148, 149, 13);
		add(lblNewLabel_1);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(806, 142, 284, 25);
		add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tìm kiếm theo Email:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(635, 190, 138, 13);
		add(lblNewLabel_2);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(806, 187, 284, 25);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm theo giới tính");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(633, 232, 154, 13);
		add(lblNewLabel_3);
		
		rdoNam = new JRadioButton("Nam");
		rdoNam.setBackground(SystemColor.controlHighlight);
		groupGioiTinh.add(rdoNam);
		rdoNam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdoNam.setBounds(803, 229, 103, 21);
		add(rdoNam);
		
		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBackground(SystemColor.controlHighlight);
		groupGioiTinh.add(rdoNu);
		rdoNu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdoNu.setBounds(907, 229, 103, 21);
		add(rdoNu);
		
		JLabel lblTrinhDo = new JLabel("Tìm kiếm theo trình độ");
		lblTrinhDo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTrinhDo.setBounds(633, 273, 149, 13);
		add(lblTrinhDo);
		
		rdoDH = new JRadioButton("Đại Học");
		rdoDH.setBackground(SystemColor.controlHighlight);
		groupTrinhDo.add(rdoDH);
		rdoDH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdoDH.setBounds(803, 269, 103, 21);
		add(rdoDH);
		
		rdoPT = new JRadioButton("Phổ thông");
		rdoPT.setBackground(SystemColor.controlHighlight);
		groupTrinhDo.add(rdoPT);
		rdoPT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdoPT.setBounds(907, 269, 103, 21);
		add(rdoPT);
		// thiết lập dữ liệu cho table bảng
				try {
					NhanVien = new NhanVien_DAO();
					for (NhanVien nv : NhanVien.getAllNhanVien()) {
						Object[] rowNV = { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(), nv.getGioiTinh(),
								nv.getSoDienThoai(), nv.getEmail(), nv.getDiaChi(), nv.getChucVu(), nv.getTrangThaiLamViec(),
								nv.getTrinhDo() };
						model.addRow(rowNV);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();

				}
			// đăn ký sự kiện cho comboBox
				
		
	
		
	}
	// hiển thị danh sách nhân viên lên bảng
	private void updateTable(ArrayList<NhanVien> dsNVLoc) {
		DefaultTableModel model = (DefaultTableModel) tbl.getModel();
		model.setRowCount(0); // Xóa các dòng hiện tại trong bảng

		for (NhanVien nv : dsNVLoc) {
			Object[] rowNV = { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(), nv.getGioiTinh(),
					nv.getSoDienThoai(), nv.getEmail(), nv.getDiaChi(), nv.getChucVu(), nv.getTrangThaiLamViec(),
					nv.getTrinhDo() };
			model.addRow(rowNV);
		}
	}
	
	private void timKiemNhanVienTheoChucVu(String dieuKien) {
		ArrayList<NhanVien> dsNV = NhanVien.getAllNhanVien();
		ArrayList<NhanVien> dsNVLoc = new ArrayList<>();
		if (dieuKien.equals("Tất cả")) {
			dsNVLoc.addAll(dsNV);
		} else {
			for (NhanVien nv : dsNV) {
				if (nv.getGioiTinh().equals(dieuKien)) {
					dsNVLoc.add(nv);
				}
			}
		}
		updateTable(dsNVLoc);
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(cmbChucVu)) {
			String chucVu = (String)cmbChucVu.getSelectedItem();
			timKiemNhanVienTheoChucVu(chucVu);
		
		}
	
}
}
