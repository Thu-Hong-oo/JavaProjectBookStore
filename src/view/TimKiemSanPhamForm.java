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
import javax.swing.JComboBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		
		JLabel lbTieuDe = new JLabel("Tìm kiếm sản phẩm");
		lbTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 60));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		String[] column = { "Mã SP", "Tên SP","Mô tả", "Giá nhập", "Giá bán","Số lượng"};
		model = new DefaultTableModel(column, 0);
		table = new JTable(model);
		scrollPane_1.setViewportView(table);
		table.setRowSelectionAllowed(true);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tìm kiếm theo tên");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_5_2 = new JLabel("Tìm kiếm theo mã:");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(210)
					.addComponent(lbTieuDe, GroupLayout.PREFERRED_SIZE, 597, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(78)
					.addComponent(lblNewLabel_5_2, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(78)
					.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(93)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(lbTieuDe, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_5_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(80)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
		);
		setLayout(groupLayout);
	}
}
