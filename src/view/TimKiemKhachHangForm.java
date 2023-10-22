package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.KhachHang_DAO;
import entity.KhachHang;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class TimKiemKhachHangForm extends JPanel {
	private DefaultTableModel model;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Create the panel.
	 */
	public TimKiemKhachHangForm() {
		setSize(1100, 610);
		setLayout(null);
		
		JLabel lbTieuDe = new JLabel("TÌM KIẾM KHÁCh ");
		lbTieuDe.setBounds(210, 11, 597, 78);
		lbTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 60));
		add(lbTieuDe);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(36, 311, 900, 288);
		this.add(scrollPane_1);
		String[] column = { "Mã KH", "Tên KH","Địa chỉ", "SDT", "Email" };
		model = new DefaultTableModel(column, 0);
		table = new JTable(model);
		scrollPane_1.setViewportView(table);
		table.setRowSelectionAllowed(true);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(300, 149, 556, 25);
		add(textField);
		
		JLabel lblNewLabel_5 = new JLabel("Tìm kiếm theo số điện thoại");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(83, 150, 190, 21);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tìm kiếm theo tên khách hàng");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5_1.setBounds(83, 201, 190, 21);
		add(lblNewLabel_5_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(300, 200, 556, 25);
		add(textField_1);
	}
}
