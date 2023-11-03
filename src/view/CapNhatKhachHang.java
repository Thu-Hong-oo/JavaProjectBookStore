package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;



import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.border.EtchedBorder;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

import dao.KhachHang_DAO;
import dao.NhanVien_DAO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import entity.KhachHang;
import entity.NhanVien;

public class CapNhatKhachHang extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTable table;
	private DefaultTableModel model;
	private JButton btnThem, btnSua, btnLamMoi, btnXoa;
	private JRadioButton rdoNam, rdoNu;
	private JTextArea txtDiaChi;
	private JDateChooser dcsDate;
	private KhachHang_DAO khachHang;

			public CapNhatKhachHang() {
				setSize(1100, 610);
				JPanel panel = new JPanel();
				panel.setBackground(SystemColor.controlHighlight);
				panel.setBorder(new TitledBorder(
						new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
						"Thiết lập thông tin khách hàng", TitledBorder.LEFT, TitledBorder.TOP, null,
						new Color(0, 0, 0)));
				panel.setLayout(null);
				JLabel lblNewLabel = new JLabel("Mã khách hàng:");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel.setBounds(10, 51, 139, 33);
				panel.add(lblNewLabel);

				txtMaKH = new JTextField();
				txtMaKH.setBounds(140, 60, 212, 25);
				panel.add(txtMaKH);
				txtMaKH.setColumns(10);

				JLabel lblNewLabel_1 = new JLabel("Tên khách hàng:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_1.setBounds(10, 98, 139, 33);
				panel.add(lblNewLabel_1);

				txtTenKH = new JTextField();
				txtTenKH.setColumns(10);
				txtTenKH.setBounds(140, 107, 212, 25);
				panel.add(txtTenKH);

				JLabel lblNewLabel_2 = new JLabel("Số điện thoại:");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_2.setBounds(394, 51, 139, 33);
				panel.add(lblNewLabel_2);

				txtSDT = new JTextField();
				txtSDT.setColumns(10);
				txtSDT.setBounds(517, 56, 272, 25);
				panel.add(txtSDT);

				JLabel lblNewLabel_3 = new JLabel("Giới tính:");
				lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_3.setBounds(10, 145, 139, 33);
				panel.add(lblNewLabel_3);

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

				JLabel lblNewLabel_4 = new JLabel("Email:");
				lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_4.setBounds(444, 98, 139, 33);
				panel.add(lblNewLabel_4);

				txtEmail = new JTextField();
				txtEmail.setColumns(10);
				txtEmail.setBounds(517, 103, 272, 25);
				panel.add(txtEmail);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(517, 167, 272, 89);
				panel.add(scrollPane);
				
								txtDiaChi = new JTextArea();
								txtDiaChi.setLineWrap(true);
								txtDiaChi.setWrapStyleWord(true);
								scrollPane.setViewportView(txtDiaChi);
								

				JPanel panel_1 = new JPanel();
				panel_1.setBackground(SystemColor.controlHighlight);
				panel_1.setBounds(879, 21, 139, 237);
				panel.add(panel_1);
				panel_1.setLayout(null);

				btnThem = new JButton("Thêm");
				btnThem.setIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/icon/add.png")));
	
				
				btnThem.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnThem.setBounds(10, 11, 120, 40);
				panel_1.add(btnThem);

				btnSua = new JButton("Sửa");
				btnSua.setIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/icon/edit.png")));
	
		
				btnSua.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnSua.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnSua.setBounds(10, 62, 120, 40);
				panel_1.add(btnSua);

				btnLamMoi = new JButton("Làm mới");
				btnLamMoi.setIcon(new ImageIcon(CapNhatKhachHang.class.getResource("/icon/refresh.png")));
				
				btnLamMoi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 11));
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
				
				JLabel lblNewLabel_5 = new JLabel("Ngày sinh:");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblNewLabel_5.setBounds(10, 202, 71, 25);
				panel.add(lblNewLabel_5);
				
				dcsDate = new JDateChooser();
				dcsDate.setBounds(737, 20, 191, 26);
				panel_1.add(dcsDate);
				
				JDateChooser dcsDate = new JDateChooser();
				dcsDate.setBounds(140, 202, 212, 25);
				panel.add(dcsDate);
				
								JLabel lblNewLabel_4_1 = new JLabel("Địa chỉ:");
								lblNewLabel_4_1.setBounds(432, 163, 270, 15);
								panel.add(lblNewLabel_4_1);
								lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));

				JPanel panel_2 = new JPanel();
				panel_2.setBorder(UIManager.getBorder("TitledBorder.border"));
				panel_2.setBackground(SystemColor.controlHighlight);
				panel_2.setLayout(null);
				
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(21, 35, 1039, 244);
				panel_2.add(scrollPane_1);

				String[] column = { "Mã KH", "Tên KH","Ngày Sinh" ,"Giới tính", "SDT","Email","Địa chỉ" };
				model = new DefaultTableModel(column, 0);
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
			
		}

		
		

