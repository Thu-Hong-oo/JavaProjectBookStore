package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ButtonGroup;
import java.awt.SystemColor;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;
<<<<<<< HEAD

import dao.KhachHang_DAO;
import dao.NhanVien_DAO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import entity.KhachHang;
import entity.NhanVien;
=======
>>>>>>> a8b28fd5b52401684a91b5b3b90e1f83d7d1bcfe

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import entity.KhachHang;
import javax.swing.ImageIcon;
public class CapNhatKhachHang extends JPanel implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtEmail;
<<<<<<< HEAD
	private JTable table;
	private DefaultTableModel model;
	private JButton btnThem, btnSua, btnLamMoi, btnXoa;
	private JRadioButton rdoNam, rdoNu;
	private JTextArea txtDiaChi;
	private JDateChooser dcsDate;
	private KhachHang_DAO khachHang;

=======
	private JTable tblKH;
	private DefaultTableModel model;
	private JRadioButton radNam, radNu;
	private JTextArea txaDiaChi;
	private KhachHang_DAO khachHang;
	private JButton btnThem,btnLamMoi,btnSua;
	private JDateChooser dateChooserNgaySinh;
	private JButton btnXoa;
	private JButton btnTao;
>>>>>>> a8b28fd5b52401684a91b5b3b90e1f83d7d1bcfe
			public CapNhatKhachHang() {
				setLayout(null);
				setSize(1100, 610);
				JPanel pnl = new JPanel();
				
				//ket noi db
				try {
					ConnectDB.getInstance().connect();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				pnl.setBackground(SystemColor.controlHighlight);
				pnl.setBorder(new TitledBorder(
						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
						"Thiết lập thông tin khách hàng", TitledBorder.LEFT, TitledBorder.TOP, null,
						new Color(0, 0, 0)));
				pnl.setBounds(20, 22, 1070, 279);
				add(pnl);
				pnl.setLayout(null);
				JLabel lblMaKH = new JLabel("Mã khách hàng:");
				lblMaKH.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblMaKH.setBounds(10, 51, 139, 33);
				pnl.add(lblMaKH);

				txtMaKH = new JTextField();
				txtMaKH.setBounds(140, 60, 126, 25);
				pnl.add(txtMaKH);
				txtMaKH.setColumns(10);

				JLabel lblTenKH = new JLabel("Tên khách hàng:");
				lblTenKH.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblTenKH.setBounds(10, 98, 139, 33);
				pnl.add(lblTenKH);

				txtTenKH = new JTextField();
				txtTenKH.setColumns(10);
				txtTenKH.setBounds(140, 107, 212, 25);
				pnl.add(txtTenKH);

				JLabel lblSoDienThoai = new JLabel("Số điện thoại:");
				lblSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblSoDienThoai.setBounds(394, 51, 139, 33);
				pnl.add(lblSoDienThoai);

				txtSDT = new JTextField();
				txtSDT.setColumns(10);
				txtSDT.setBounds(517, 56, 272, 25);
				pnl.add(txtSDT);

				JLabel lblGioiTinh = new JLabel("Giới tính:");
				lblGioiTinh.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblGioiTinh.setBounds(10, 145, 139, 33);
				pnl.add(lblGioiTinh);

<<<<<<< HEAD
				rdoNam = new JRadioButton("Nam", false);
				rdoNam.setBackground(SystemColor.controlHighlight);
				rdoNam.setFont(new Font("Tahoma", Font.BOLD, 12));
				rdoNam.setBounds(140, 147, 140, 30);
				panel.add(rdoNam);

				rdoNu = new JRadioButton("Nữ");
				rdoNu.setBackground(SystemColor.controlHighlight);
				rdoNu.setFont(new Font("Tahoma", Font.BOLD, 12));
				rdoNu.setBounds(282, 148, 140, 30);
				panel.add(rdoNu);

				ButtonGroup btg = new ButtonGroup();
				btg.add(rdoNu);
				btg.add(rdoNam);
=======
				radNam = new JRadioButton("Nam", false);
				radNam.setBackground(SystemColor.controlHighlight);
				radNam.setFont(new Font("Tahoma", Font.BOLD, 12));
				radNam.setBounds(140, 147, 140, 30);
				pnl.add(radNam);

				radNu = new JRadioButton("Nữ");
				radNu.setBackground(SystemColor.controlHighlight);
				radNu.setFont(new Font("Tahoma", Font.BOLD, 12));
				radNu.setBounds(282, 148, 140, 30);
				pnl.add(radNu);

				ButtonGroup btg = new ButtonGroup();
				btg.add(radNu);
				btg.add(radNam);
>>>>>>> a8b28fd5b52401684a91b5b3b90e1f83d7d1bcfe

				JLabel lblEmail = new JLabel("Email:");
				lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblEmail.setBounds(444, 98, 139, 33);
				pnl.add(lblEmail);

				txtEmail = new JTextField();
				txtEmail.setColumns(10);
				txtEmail.setBounds(517, 103, 272, 25);
				pnl.add(txtEmail);

				JScrollPane scr = new JScrollPane();
				scr.setBounds(517, 167, 272, 89);
				pnl.add(scr);
				
<<<<<<< HEAD
								txtDiaChi = new JTextArea();
								txtDiaChi.setLineWrap(true);
								txtDiaChi.setWrapStyleWord(true);
								scrollPane.setViewportView(txtDiaChi);
								
=======
								txaDiaChi = new JTextArea();
								scr.setViewportView(txaDiaChi);
>>>>>>> a8b28fd5b52401684a91b5b3b90e1f83d7d1bcfe

				JPanel pnl_1 = new JPanel();
				pnl_1.setBackground(SystemColor.controlHighlight);
				pnl_1.setBounds(879, 21, 139, 237);
				pnl.add(pnl_1);
				pnl_1.setLayout(null);

				btnThem = new JButton("Thêm");
<<<<<<< HEAD
				btnThem.setIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/icon/add.png")));
	
				
				btnThem.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnThem.setBounds(10, 11, 120, 40);
				panel_1.add(btnThem);

				btnSua = new JButton("Sửa");
				btnSua.setIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/icon/edit.png")));
	
		
=======
				btnThem.setBackground(new Color(95, 158, 160));
				btnThem.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnThem.setBounds(10, 11, 120, 40);
				pnl_1.add(btnThem);

				btnSua = new JButton("Sửa");
				btnSua.setBackground(new Color(95, 158, 160));
>>>>>>> a8b28fd5b52401684a91b5b3b90e1f83d7d1bcfe
				btnSua.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnSua.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnSua.setBounds(10, 62, 120, 40);
<<<<<<< HEAD
				panel_1.add(btnSua);

				btnLamMoi = new JButton("Làm mới");
				btnLamMoi.setIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/icon/refresh.png")));
				
=======
				pnl_1.add(btnSua);
				
				btnLamMoi = new JButton("Làm mới");
				btnLamMoi.setBackground(new Color(95, 158, 160));
>>>>>>> a8b28fd5b52401684a91b5b3b90e1f83d7d1bcfe
				btnLamMoi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 11));
<<<<<<< HEAD
				btnLamMoi.setBounds(10, 171, 120, 40);
				panel_1.add(btnLamMoi);

				btnXoa = new JButton("Xóa");
				btnXoa.setIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/icon/delete.png")));
				btnXoa.setFont(new Font("Tahoma", Font.BOLD, 11));
	
				btnXoa.setBounds(10, 120, 120, 40);
				panel_1.add(btnXoa);

				JLabel lblNewLabel_7 = new JLabel("");
				lblNewLabel_7.setForeground(Color.RED);
				lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNewLabel_7.setBounds(191, 243, 363, 14);
				panel.add(lblNewLabel_7);
=======
				btnLamMoi.setBounds(10, 186, 120, 40);
				pnl_1.add(btnLamMoi);
>>>>>>> a8b28fd5b52401684a91b5b3b90e1f83d7d1bcfe
				
				btnXoa = new JButton("Xóa");
				btnXoa.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnXoa.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnXoa.setBackground(new Color(95, 158, 160));
				btnXoa.setBounds(10, 124, 120, 40);
				pnl_1.add(btnXoa);
				
				JLabel lblNgaySinh = new JLabel("Ngày sinh:");
				lblNgaySinh.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNgaySinh.setBounds(10, 202, 71, 25);
				pnl.add(lblNgaySinh);
				
<<<<<<< HEAD
				dcsDate = new JDateChooser();
				dcsDate.setBounds(737, 20, 191, 26);
				panel_1.add(dcsDate);
				
				JDateChooser dcsDate = new JDateChooser();
				dcsDate.setBounds(140, 202, 212, 25);
				panel.add(dcsDate);
=======
				dateChooserNgaySinh = new JDateChooser();
				dateChooserNgaySinh.setBounds(140, 202, 212, 25);
				pnl.add(dateChooserNgaySinh);
				
				JLabel lblDiaChi = new JLabel("Địa chỉ:");
				lblDiaChi.setBounds(432, 163, 270, 15);
				pnl.add(lblDiaChi);
				lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
>>>>>>> a8b28fd5b52401684a91b5b3b90e1f83d7d1bcfe
				
				btnTao = new JButton("Tạo");
				btnTao.setSelectedIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/icon/taoMa.png")));
				btnTao.setFont(new Font("SansSerif", Font.BOLD, 12));
				btnTao.setBackground(new Color(95, 158, 160));
				btnTao.setBounds(276, 60, 83, 24);
				pnl.add(btnTao);

				JPanel pnl_2 = new JPanel();
				pnl_2.setBorder(UIManager.getBorder("TitledBorder.border"));
				pnl_2.setBackground(SystemColor.controlHighlight);
				pnl_2.setBounds(20, 313, 1070, 320);
				add(pnl_2);
				pnl_2.setLayout(null);
				
				JScrollPane scr_1 = new JScrollPane();
				scr_1.setBounds(21, 35, 1039, 244);
				pnl_2.add(scr_1);

				String[] column = { "Mã KH", "Tên KH","Ngày Sinh" ,"Giới tính", "SDT","Email","Địa chỉ" };
				model = new DefaultTableModel(column, 0);
<<<<<<< HEAD
				table = new JTable(model);
				scrollPane_1.setViewportView(table);
				table.setRowSelectionAllowed(true);
				GroupLayout groupLayout = new GroupLayout(this);
				groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(20)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1070, Short.MAX_VALUE)
								.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
							.addContainerGap())
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
							.addContainerGap())
				);
				setLayout(groupLayout);
			
			
			// lấy dl từ database
			try {
				khachHang = new KhachHang_DAO();
				for (KhachHang kh : khachHang.getAllKhachHang()) {
					Object[] rowKh = {kh.getmaKhachHang(),kh.gettenKhachHang(),kh.getNgaySinh(),kh.getGioiTinh(),kh.getSoDienThoai(),
							kh.getEmail(), kh.getDiaChi()};
					model.addRow(rowKh);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();

			}
			
}
			
=======
				tblKH = new JTable(model);
				scr_1.setViewportView(tblKH);
				tblKH.setRowSelectionAllowed(true);
				
				khachHang = new KhachHang_DAO();
				//tai db
				for (KhachHang k : khachHang.getAllKhachHang()) {
					Object[] rowData = { k.getMaKH(), k.getTenKH(), k.getNgaySinh(),k.getGioiTinh(),k.getSDT(),k.getEmail(),k.getDiaChi(),k.getDiaChi()};
					model.addRow(rowData);
				}
				
				btnThem.addActionListener(this);
				btnSua.addActionListener(this);
				btnLamMoi.addActionListener(this);
				btnXoa.addActionListener(this);
				btnTao.addActionListener(this);
				tblKH.addMouseListener(this);

			}
			private void lamMoi() {
				tblKH.clearSelection();
				txtMaKH.setText("");
				txtTenKH.setText("");
				txtSDT.setText("");
				txtEmail.setText("");
				txaDiaChi.setText("");
				radNam.setSelected(true);
				radNu.setSelected(false);
				dateChooserNgaySinh.setDate(null);

			}
			private void showMessage(String message, JTextField txt) {
				JOptionPane.showMessageDialog(null, message);
				txt.requestFocus();
			}
			private boolean validDataKhachHang() {
				String maKH = txtMaKH.getText().trim();
				String tenKH = txtTenKH.getText().trim();
				String diaChi = txaDiaChi.getText().trim();
				String dienThoai = txtSDT.getText().trim();
				String email = txtEmail.getText().trim();
				
				if (!(maKH.length() > 0)) {
					showMessage("Mã KH không được để rỗng", txtMaKH);
					return false;
				} else if (!maKH.matches("KH\\d{3}")) {
					showMessage("Gồm 5 ký tự,  2 ký tự đầu là KH,  với 3 ký tự sau là số", txtMaKH);
					return false;
				}
				if (tenKH.length() < 0 || !tenKH.matches("^[A-Z]\\p{L}+(\\s[A-Z]\\p{L}*)+")) {
					showMessage("Tên không hợp lệ ", txtTenKH);
					return false;
				}
				if (dienThoai.length() < 0 || !dienThoai.matches("^0[1-9][0-9]{8}")) {
					showMessage("Số điện thoại không hợp lệ ", txtSDT);
					return false;
				}
				if (email.length() < 0 || !email.matches("[a-z]\\w+@(gmail|yahoo|iuh|example)\\.com")) {
					showMessage(" Email không hợp lệ ", txtEmail);
					return false;
				}
				return true;
				
			}
			private KhachHang revertFromtxt() {
				KhachHang kh = null;
				String ma = txtMaKH.getText();
				String hoTen = txtTenKH.getText();
				String diaChi = txaDiaChi.getText();
				String dienThoai = txtSDT.getText();
				String email = txtEmail.getText();
				java.util.Date ngaySinh = dateChooserNgaySinh.getDate();
				String gioiTinh = null;
				if (radNam.isSelected())
					gioiTinh = radNam.getText();
				else if (radNu.isSelected())
					gioiTinh = radNu.getText();
				kh=new KhachHang(ma, hoTen, gioiTinh, diaChi, dienThoai, email, new java.sql.Date(ngaySinh.getTime()).toString());
				return kh;
			}
			private void them() {
				if (validDataKhachHang()) {
					int tb = JOptionPane.showConfirmDialog(null, "Ban co chac chan muon them", "THEM",
							JOptionPane.YES_NO_OPTION);
					if (tb == JOptionPane.YES_OPTION) {
						KhachHang kh = revertFromtxt();
						if(khachHang.themKH(kh)){//dao
							Object[] row = { kh.getMaKH(), kh.getTenKH(),kh.getNgaySinh(),kh.getGioiTinh(),kh.getSDT(), kh.getEmail(),kh.getDiaChi() };
							model.addRow(row);
							JOptionPane.showMessageDialog(null, "Thêm thành công");
						
						}else {
							showMessage("Mã bị trùng", txtMaKH);
						}
					}
					
						
				}
			}
			private void sua() {
				int row = tblKH.getSelectedRow();
				if(row!=-1) {
					KhachHang kh=revertFromtxt();
					String selectedMa = tblKH.getValueAt(row, 0).toString();
					if (!kh.getMaKH().equals(selectedMa)) {
						JOptionPane.showMessageDialog(null, "Không được thay đổi mã !", "Lỗi", JOptionPane.ERROR_MESSAGE);
						txtMaKH.setText(tblKH.getValueAt(row, 0).toString());
					}

					else {
						if(validDataKhachHang()) {
							int tb = JOptionPane.showConfirmDialog(null, "Ban co chac chan muon sua", "Sua",
									JOptionPane.YES_NO_OPTION);
							if (tb == JOptionPane.YES_OPTION) {
								model.setValueAt(kh.getTenKH(), row, 1);
								model.setValueAt(kh.getNgaySinh(), row, 2);
								model.setValueAt(kh.getGioiTinh(), row, 3);
								model.setValueAt(kh.getSDT(), row, 4);
								model.setValueAt(kh.getEmail(), row, 5);
								model.setValueAt(kh.getDiaChi(), row, 6);
								model.fireTableRowsUpdated(row, row);
								khachHang.suaKH(kh);
								lamMoi();
								JOptionPane.showMessageDialog(null,
										"Thực hiện sửa đổi thành công thông tin nhân viên có mã: " + kh.getMaKH());
							}	
						}
					}
				
				}else {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa");
				}
				
					

			}
			private void xoa() {
				int i = tblKH.getSelectedRow();
				String ma = txtMaKH.getText();
				if (i != -1) {
					int tb = JOptionPane.showConfirmDialog(null, "Ban co chac chan muon xoa", "DELETE",
							JOptionPane.YES_NO_OPTION);
					if (tb == JOptionPane.YES_OPTION) {
						if(khachHang.xoaKH(ma)) {
							model.removeRow(i);
							JOptionPane.showMessageDialog(null, "Đã xóa thành công");
							lamMoi();
						}else {
							JOptionPane.showMessageDialog(null, "Không thể xóa- Đây là khách hàng đã có hóa đơn hoặc đơn hàng");
						}
						
					}
				} else
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn dòng cần xóa");
			}
			private void taoMa() {
				txtMaKH.setText(khachHang.taoMa());
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnLamMoi))
					lamMoi();
				else if (o.equals(btnThem))
					them();
				else if (o.equals(btnSua))
					sua();
				else if (o.equals(btnXoa))
					xoa();
				else if (o.equals(btnTao))
					taoMa();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tblKH.getSelectedRow();
				txtMaKH.setText(tblKH.getValueAt(row, 0).toString());
				txtTenKH.setText(tblKH.getValueAt(row, 1).toString());
				
				// Lấy giá trị ngày tháng từ cột 5 của hàng có chỉ số rowNV
				String ngaySinhStr = tblKH.getValueAt(row, 2).toString();
				// Chuyển đổi giá trị ngày sinh từ kiểu chuỗi sang kiểu Date
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					java.util.Date ngaySinh = dateFormat.parse(ngaySinhStr);
					dateChooserNgaySinh.setDate(ngaySinh);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				if (model.getValueAt(row, 3).toString().equalsIgnoreCase("Nam")) {
					radNam.setSelected(true);
					radNu.setSelected(false);
				} else {
					radNu.setSelected(true);
					radNam.setSelected(false);
				}
				txtSDT.setText(tblKH.getValueAt(row, 4).toString());
				txtEmail.setText(tblKH.getValueAt(row, 5).toString());
				txaDiaChi.setText(tblKH.getValueAt(row, 6).toString());
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
>>>>>>> a8b28fd5b52401684a91b5b3b90e1f83d7d1bcfe
		}

		
		

