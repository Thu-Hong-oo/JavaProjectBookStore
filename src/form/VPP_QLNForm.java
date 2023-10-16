package form;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;

public class VPP_QLNForm extends JPanel {
	private JTextField textField;
	private JTable tableSach;
	private DefaultTableModel modelSach;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;

	public VPP_QLNForm() {
		setLayout(null);
		setSize(1100, 610);
		setBackground(Color.WHITE);

		textField = new JTextField();
		textField.setBounds(77, 11, 185, 26);
		add(textField);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 48, 1080, 270);
		add(panel);
		panel.setLayout(null);

		String[] headerSach = { "Mã sản phẩm", "Tên sản phẩm ", "Loại", "NCC", "Số lượng", "Giá nhập", "Giá bán","Mô tả" };
		modelSach = new DefaultTableModel(headerSach, 0);
		tableSach = new JTable(modelSach);
		JScrollPane scpSach = new JScrollPane(tableSach, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		scpSach.setBounds(10, 11, 1060, 248);
		panel.add(scpSach);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 341, 1080, 258);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblTnSch = new JLabel("Tên sản phẩm");
		lblTnSch.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnSch.setBounds(10, 62, 106, 26);
		panel_1.add(lblTnSch);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(165, 62, 211, 26);
		panel_1.add(textField_2);

		JLabel lblNewLabel = new JLabel("Mã sản phẩm");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 24, 119, 26);
		panel_1.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 24, 211, 26);
		panel_1.add(textField_1);

		JLabel lblNewLabel_1 = new JLabel("Loại");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(10, 99, 81, 26);
		panel_1.add(lblNewLabel_1);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(165, 99, 211, 26);
		panel_1.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(165, 137, 211, 26);
		panel_1.add(textField_4);

		JLabel lblTnSch_1 = new JLabel("Số lượng");
		lblTnSch_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnSch_1.setBounds(10, 137, 81, 26);
		panel_1.add(lblTnSch_1);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(608, 63, 211, 26);
		panel_1.add(textField_6);

		JLabel lblNewLabel_1_1 = new JLabel("Giá nhập");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(502, 62, 81, 26);
		panel_1.add(lblNewLabel_1_1);

		JLabel lblTnSch_1_2 = new JLabel("Giá bán");
		lblTnSch_1_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnSch_1_2.setBounds(502, 100, 81, 26);
		panel_1.add(lblTnSch_1_2);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(608, 101, 211, 26);
		panel_1.add(textField_7);

		JButton btnNewButton = new JButton("Cập nhật");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(250, 128, 114));
		btnNewButton.setBounds(914, 89, 114, 36);
		panel_1.add(btnNewButton);

		JButton btnToMi = new JButton("Tạo mới");
		btnToMi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnToMi.setBackground(new Color(250, 128, 114));
		btnToMi.setBounds(914, 27, 114, 36);
		panel_1.add(btnToMi);

		JButton btnLmMi = new JButton("Làm mới");
		btnLmMi.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLmMi.setBackground(new Color(250, 128, 114));
		btnLmMi.setBounds(914, 152, 114, 36);
		panel_1.add(btnLmMi);

		JLabel lblTnSch_1_2_1 = new JLabel("Mô tả");
		lblTnSch_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTnSch_1_2_1.setBounds(502, 138, 81, 26);
		panel_1.add(lblTnSch_1_2_1);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(606, 140, 213, 88);
		panel_1.add(textArea);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("NCC");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(502, 24, 81, 26);
		panel_1.add(lblNewLabel_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(608, 24, 211, 26);
		panel_1.add(comboBox);

		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTmKim.setBounds(10, 11, 81, 26);
		add(lblTmKim);
	}
}
