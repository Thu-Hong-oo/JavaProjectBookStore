package form;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIDefaults;

import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class DatHangForm extends JPanel {
	private JTable tableGioHang;
	private DefaultTableModel modelGioHang;
	private JTable tableSanPham;
	private DefaultTableModel modelSanPham;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public DatHangForm() {
		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1100, 610);
		
	       // Tuỳ chỉnh màu nền header của JTable
     
        
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(169, 169, 169), new Color(105, 105, 105), new Color(220, 220, 220), new Color(220, 220, 220)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 654, 214);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Giỏ Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 0, 79, 29);
		panel.add(lblNewLabel);
		
		String[] headergioHang = { "Mã sản phẩm", "Đơn giá", "Số lượng", "Thành tiền" };
		modelGioHang = new DefaultTableModel(headergioHang, 0);
		tableGioHang = new JTable(modelGioHang);
		tableGioHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scpGioHang = new JScrollPane(tableGioHang, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        
		scpGioHang.setBounds(10, 29, 634, 169);
		panel.add(scpGioHang);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 236, 654, 363);
		add(panel_1);
		
		JLabel lblDanhSchSn = new JLabel("Danh Sách Sản Phẩm");
		lblDanhSchSn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDanhSchSn.setBounds(236, 11, 174, 29);
		panel_1.add(lblDanhSchSn);
		
		JScrollPane scpGioHang_1 = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scpGioHang_1.setBounds(10, 87, 634, 264);
		panel_1.add(scpGioHang_1);
		
		JLabel lblTmKim = new JLabel("Tìm Kiếm");
		lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTmKim.setBounds(10, 32, 69, 16);
		panel_1.add(lblTmKim);
		
		textField = new JTextField();
		textField.setBounds(10, 56, 162, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblDanhMc = new JLabel("Danh Mục");
		lblDanhMc.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDanhMc.setBounds(563, 32, 69, 16);
		panel_1.add(lblDanhMc);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(476, 54, 157, 22);
		panel_1.add(comboBox);
		
		JButton btnNewButton = new JButton("Thêm sản phẩm");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(246, 53, 149, 23);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(695, 11, 395, 588);
		add(panel_2);
		
		JLabel lblPhiutHng = new JLabel("PHIẾU ĐẶT HÀNG");
		lblPhiutHng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhiutHng.setBounds(10, 0, 139, 29);
		panel_2.add(lblPhiutHng);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_3.setBounds(10, 40, 375, 115);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblMKhchHng = new JLabel("Mã KH:");
		lblMKhchHng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMKhchHng.setBounds(10, 23, 104, 29);
		panel_3.add(lblMKhchHng);
		
		textField_1 = new JTextField();
		textField_1.setBounds(70, 28, 162, 20);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(70, 68, 162, 20);
		panel_3.add(textField_2);
		
		JLabel lblTnKhchHng = new JLabel("Tên  KH:");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnKhchHng.setBounds(10, 63, 117, 29);
		panel_3.add(lblTnKhchHng);
		
		JButton btnNewButton_1 = new JButton("Thay đổi");
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.setBounds(253, 49, 112, 29);
		panel_3.add(btnNewButton_1);
		
		JLabel lblMPhiu = new JLabel("Mã phiếu đặt hàng:");
		lblMPhiu.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMPhiu.setBounds(34, 186, 125, 29);
		panel_2.add(lblMPhiu);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(180, 191, 162, 20);
		panel_2.add(textField_3);
		
		JLabel lblNgyt = new JLabel("Ngày đặt:");
		lblNgyt.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNgyt.setBounds(34, 238, 125, 29);
		panel_2.add(lblNgyt);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(180, 243, 162, 20);
		panel_2.add(textField_4);
		
		
		modelGioHang = new DefaultTableModel(headergioHang, 0);
		tableGioHang = new JTable(modelGioHang);
		tableGioHang.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scrollPane = new JScrollPane(tableGioHang, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 329, 375, 210);
		panel_2.add(scrollPane);
		
		JLabel lblDanhScht = new JLabel("Danh sách đặt hàng:");
		lblDanhScht.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDanhScht.setBounds(34, 289, 146, 29);
		panel_2.add(lblDanhScht);
		
		JButton btnNewButton_2 = new JButton("Thanh Toán Ngay");
		btnNewButton_2.setBackground(Color.PINK);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(223, 550, 162, 27);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Tạo Phiếu Đặt");
		btnNewButton_2_1.setBackground(Color.PINK);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2_1.setBounds(10, 550, 170, 29);
		panel_2.add(btnNewButton_2_1);
		
		

	}
}
