package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class NCCForm extends JPanel {

	
	private JTable table;
	private JTextField txtMaNCC;
	private JTextField txtTenNCC;
	private JTextField txtDiaChi;
	private JTextField txtsdt;
	private JTextField txtEmail;

	/**
	 * Create the panel.
	 */
	public NCCForm() {
		setBackground(SystemColor.controlHighlight);
		setSize(1130, 670);
		setBackground(Color.WHITE);
		
		JPanel pnltieuDe = new JPanel();
		pnltieuDe.setBackground(SystemColor.controlHighlight);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Danh Mục Đơn Vị Cung Cấp");
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		pnltieuDe.add(lblNewLabel);
		
		JScrollPane scrBang = new JScrollPane();
		String[] column = { "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Số Điện Thoại","Email","Địa chỉ" };
		TableModel model = new DefaultTableModel(column, 0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.BOLD, 18));
		scrBang.setViewportView(table);
		table.setRowSelectionAllowed(true);
		
		JPanel pnlControl = new JPanel();
		pnlControl.setForeground(new Color(0, 0, 0));
		pnlControl.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thi\u1EBFt L\u1EADp Th\u00F4ng Tin Nh\u00E0 Cung C\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlControl.setLayout(null);
		
		JLabel lblMaNCC = new JLabel("Mã Đơn Vị Cung Cấp:");
		lblMaNCC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMaNCC.setBounds(10, 31, 148, 37);
		pnlControl.add(lblMaNCC);
		
		JLabel lblTenNCC = new JLabel("Tên Nhà Cung Cấp:");
		lblTenNCC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTenNCC.setBounds(10, 84, 134, 27);
		pnlControl.add(lblTenNCC);
		
		txtMaNCC = new JTextField();
		txtMaNCC.setBounds(155, 35, 415, 31);
		pnlControl.add(txtMaNCC);
		txtMaNCC.setColumns(10);
		
		txtTenNCC = new JTextField();
		txtTenNCC.setBounds(155, 85, 415, 31);
		pnlControl.add(txtTenNCC);
		txtTenNCC.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiaChi.setBounds(10, 132, 120, 27);
		pnlControl.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(155, 137, 877, 31);
		pnlControl.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblSoDienThoai = new JLabel("Số Điện Thoại:");
		lblSoDienThoai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSoDienThoai.setBounds(618, 31, 148, 37);
		pnlControl.add(lblSoDienThoai);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(618, 79, 148, 37);
		pnlControl.add(lblEmail);
		
		txtsdt = new JTextField();
		txtsdt.setBounds(727, 41, 305, 31);
		pnlControl.add(txtsdt);
		txtsdt.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(727, 85, 305, 31);
		pnlControl.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThem.setBackground(new Color(95, 158, 160));
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSua.setBackground(new Color(95, 158, 160));
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(95, 158, 160));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLamMoi.setBackground(new Color(95, 158, 160));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(pnltieuDe, GroupLayout.PREFERRED_SIZE, 1090, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(scrBang, GroupLayout.PREFERRED_SIZE, 1070, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(120)
							.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(91)
							.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(88)
							.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addGap(97)
							.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(pnlControl, GroupLayout.PREFERRED_SIZE, 1081, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(pnltieuDe, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(scrBang, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSua, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(107)
					.addComponent(pnlControl, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		
	}
}
