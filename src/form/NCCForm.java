package form;

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
		setLayout(null);
		setSize(1130, 670);
		setBackground(Color.WHITE);
		
		JPanel pnltieuDe = new JPanel();
		pnltieuDe.setBackground(SystemColor.controlHighlight);
		pnltieuDe.setBounds(10, 10, 1090, 67);
		add(pnltieuDe);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Danh Mục Đơn Vị Cung Cấp");
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 45));
		pnltieuDe.add(lblNewLabel);
		
		JScrollPane scrBang = new JScrollPane();
		scrBang.setBounds(10, 87, 1070, 197);
		add(scrBang);
		String[] column = { "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Số Điện Thoại","Email","Địa chỉ" };
		TableModel model = new DefaultTableModel(column, 0);
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.BOLD, 18));
		scrBang.setViewportView(table);
		table.setRowSelectionAllowed(true);
		
		JPanel pnlControl = new JPanel();
		pnlControl.setForeground(new Color(0, 0, 0));
		pnlControl.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Thi\u1EBFt L\u1EADp Th\u00F4ng Tin Nh\u00E0 Cung C\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlControl.setBounds(10, 305, 1070, 211);
		add(pnlControl);
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
		btnThem.setBounds(120, 526, 148, 51);
		btnThem.setBackground(new Color(95, 158, 160));
		add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSua.setBounds(359, 526, 148, 51);
		btnSua.setBackground(new Color(95, 158, 160));
		add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(new Color(95, 158, 160));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXoa.setBounds(595, 526, 148, 51);
		add(btnXoa);
		
		JButton btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLamMoi.setBounds(840, 526, 148, 51);
		btnLamMoi.setBackground(new Color(95, 158, 160));
		add(btnLamMoi);
		
		
	}
}
