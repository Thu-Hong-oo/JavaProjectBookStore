package form;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class LapHoaDonForm extends JPanel {
	private JTable tableDonHang;
	private DefaultTableModel modelDonHang;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Create the panel.
	 */
	public LapHoaDonForm() {

		setLayout(null);
		setSize(1100, 610);
		setBackground(Color.WHITE);
		
		JPanel pnDH = new JPanel();
		pnDH.setBorder(UIManager.getBorder("TitledBorder.border"));
		pnDH.setBounds(0, 48, 674, 299);
		pnDH.setBackground(Color.WHITE);
		pnDH.setLayout(null);
		add(pnDH);
		
		JLabel lbPhieuDatHang = new JLabel("Phiếu Đặt Hàng");
		lbPhieuDatHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbPhieuDatHang.setForeground(Color.BLACK);
		lbPhieuDatHang.setBounds(10, 0, 161, 30);
		pnDH.add(lbPhieuDatHang);
		
		
		String[] headerDH = { "Mã phiếu đặt hàng", "Mã khách hàng ", "Mã nhân viên", "Ngày lập" };
		modelDonHang = new DefaultTableModel(headerDH, 0);
		tableDonHang = new JTable(modelDonHang);
		JScrollPane scpDonHang = new JScrollPane(tableDonHang, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scpDonHang.setBounds(10, 41, 633, 247);
		pnDH.add(scpDonHang);
		
		JPanel pnDH_1 = new JPanel();
		pnDH_1.setLayout(null);
		pnDH_1.setBorder(UIManager.getBorder("TitledBorder.border"));
		pnDH_1.setBackground(Color.WHITE);
		pnDH_1.setBounds(0, 358, 674, 241);
		add(pnDH_1);
		
		JLabel lbCTPhieuDatHang_1 = new JLabel("Chi tiết phiếu Đặt Hàng");
		lbCTPhieuDatHang_1.setForeground(Color.BLACK);
		lbCTPhieuDatHang_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbCTPhieuDatHang_1.setBounds(10, 0, 277, 30);
		pnDH_1.add(lbCTPhieuDatHang_1);
		
		String[] headerCT = { "Mã phiếu đặt hàng", "Mã Sản Phẩm ", "Tên", "Số Lượng","Giá Tiền","Thành Tiền" };
		modelDonHang = new DefaultTableModel(headerCT, 0);
		tableDonHang = new JTable(modelDonHang);
		JScrollPane scpDonHang_1 = new JScrollPane(tableDonHang, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scpDonHang_1.setBounds(10, 41, 633, 189);
		pnDH_1.add(scpDonHang_1);
		
		JLabel lblTmKim = new JLabel("Tìm Kiếm");
		lblTmKim.setForeground(Color.BLACK);
		lblTmKim.setFont(new Font("UTM Americana EB", Font.BOLD, 14));
		lblTmKim.setBounds(0, 11, 85, 30);
		add(lblTmKim);
		
		textField = new JTextField();
		textField.setBounds(92, 16, 165, 24);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Chọn");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(544, 13, 85, 30);
		add(btnNewButton);
		
		JLabel lblHan = new JLabel("Hóa Đơn");
		lblHan.setForeground(Color.BLACK);
		lblHan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHan.setBounds(713, 10, 120, 30);
		add(lblHan);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel.setBounds(713, 48, 377, 551);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTmKim_1 = new JLabel("Khách Hàng : ");
		lblTmKim_1.setForeground(Color.BLACK);
		lblTmKim_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTmKim_1.setBounds(34, 149, 108, 30);
		panel.add(lblTmKim_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(185, 156, 164, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTmKim_1_1 = new JLabel("Nhân Viên : ");
		lblTmKim_1_1.setForeground(Color.BLACK);
		lblTmKim_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTmKim_1_1.setBounds(34, 201, 108, 30);
		panel.add(lblTmKim_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(185, 208, 164, 20);
		panel.add(textField_2);
		
		JLabel lblTmKim_1_1_1 = new JLabel("Ngày Lập : ");
		lblTmKim_1_1_1.setForeground(Color.BLACK);
		lblTmKim_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTmKim_1_1_1.setBounds(34, 93, 108, 30);
		panel.add(lblTmKim_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(185, 100, 164, 20);
		panel.add(textField_3);
		
		JLabel lblTmKim_1_2 = new JLabel("Mã Hóa Đơn: ");
		lblTmKim_1_2.setForeground(Color.BLACK);
		lblTmKim_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTmKim_1_2.setBounds(34, 41, 108, 30);
		panel.add(lblTmKim_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(185, 48, 164, 20);
		panel.add(textField_4);
		
		JLabel lblTmKim_1_1_2 = new JLabel("Tiền Thừa : ");
		lblTmKim_1_1_2.setForeground(Color.BLACK);
		lblTmKim_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTmKim_1_1_2.setBounds(34, 360, 108, 30);
		panel.add(lblTmKim_1_1_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(185, 367, 164, 20);
		panel.add(textField_5);
		
		JLabel lblTmKim_1_3 = new JLabel("Tiền Khách Đưa : ");
		lblTmKim_1_3.setForeground(Color.BLACK);
		lblTmKim_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTmKim_1_3.setBounds(34, 308, 141, 30);
		panel.add(lblTmKim_1_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(185, 315, 164, 20);
		panel.add(textField_6);
		
		JLabel lblTmKim_1_1_1_1 = new JLabel("Tổng Tiền : ");
		lblTmKim_1_1_1_1.setForeground(Color.BLACK);
		lblTmKim_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTmKim_1_1_1_1.setBounds(34, 252, 108, 30);
		panel.add(lblTmKim_1_1_1_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(185, 259, 164, 20);
		panel.add(textField_7);
		
		JButton btnNewButton_1 = new JButton("THANH TOÁN");
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNewButton_1.setBounds(144, 462, 135, 46);
		panel.add(btnNewButton_1);
		
	
		JTableHeader header = tableDonHang.getTableHeader();
		header.setBackground(Color.CYAN);
		
	
		

	
	}
}
