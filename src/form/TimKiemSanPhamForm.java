package form;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.KhachHang_DAO;
import entity.KhachHang;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class TimKiemSanPhamForm extends JPanel {
	private DefaultTableModel model;
	private JTable table;
	private JTextField textField;
	private JTextField textField_2;
	/**
	 * Create the panel.
	 */
	public TimKiemSanPhamForm() {
		setSize(1100, 610);
		setLayout(null);
		
		JLabel lbTieuDe = new JLabel("Tìm kiếm sản phẩm");
		lbTieuDe.setBounds(210, 11, 597, 78);
		lbTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 60));
		add(lbTieuDe);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(93, 270, 900, 288);
		this.add(scrollPane_1);
		String[] column = { "Mã SP", "Tên SP","Mô tả", "Giá nhập", "Giá bán","Số lượng"};
		model = new DefaultTableModel(column, 0);
		table = new JTable(model);
		scrollPane_1.setViewportView(table);
		table.setRowSelectionAllowed(true);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(295, 165, 556, 25);
		add(textField);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tìm kiếm theo tên");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_1.setBounds(78, 166, 190, 21);
		add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Tìm kiếm theo mã:");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_2.setBounds(78, 119, 190, 21);
		add(lblNewLabel_5_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(295, 118, 556, 25);
		add(textField_2);
	}
}
