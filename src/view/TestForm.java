package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TestForm extends JPanel {
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
	public TestForm() {
		
		JPanel pnDH = new JPanel();
		pnDH.setLayout(null);
		pnDH.setBorder(UIManager.getBorder("TitledBorder.border"));
		pnDH.setBackground(Color.WHITE);
		
		JLabel lbPhieuDatHang = new JLabel("Phiếu Đặt Hàng");
		lbPhieuDatHang.setForeground(Color.BLACK);
		lbPhieuDatHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbPhieuDatHang.setBounds(10, 0, 161, 30);
		pnDH.add(lbPhieuDatHang);
		
		JScrollPane scpDonHang = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scpDonHang.setBounds(10, 41, 633, 247);
		pnDH.add(scpDonHang);
		
		JPanel pnDH_1 = new JPanel();
		pnDH_1.setLayout(null);
		pnDH_1.setBorder(UIManager.getBorder("TitledBorder.border"));
		pnDH_1.setBackground(Color.WHITE);
		
		JLabel lbCTPhieuDatHang_1 = new JLabel("Chi tiết phiếu Đặt Hàng");
		lbCTPhieuDatHang_1.setForeground(Color.BLACK);
		lbCTPhieuDatHang_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbCTPhieuDatHang_1.setBounds(10, 0, 277, 30);
		pnDH_1.add(lbCTPhieuDatHang_1);
		
		JScrollPane scpDonHang_1 = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scpDonHang_1.setBounds(10, 41, 633, 189);
		pnDH_1.add(scpDonHang_1);
		
		JLabel lblTimKiem = new JLabel("Tìm Kiếm");
		lblTimKiem.setForeground(Color.BLACK);
		lblTimKiem.setFont(new Font("UTM Americana EB", Font.BOLD, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Chọn");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(Color.PINK);
		
		JLabel lblHan = new JLabel("Hóa Đơn");
		lblHan.setForeground(Color.BLACK);
		lblHan.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(UIManager.getBorder("TitledBorder.border"));
		panel.setBackground(Color.WHITE);
		
		JLabel lblTmKim_1 = new JLabel("Khách Hàng : ");
		lblTmKim_1.setForeground(Color.BLACK);
		lblTmKim_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTmKim_1.setBounds(34, 149, 108, 30);
		panel.add(lblTmKim_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(185, 156, 164, 20);
		panel.add(textField_1);
		
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
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNewButton_1.setBackground(Color.PINK);
		btnNewButton_1.setBounds(144, 462, 135, 46);
		panel.add(btnNewButton_1);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblTimKiem, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
							.addGap(287)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
							.addGap(84)
							.addComponent(lblHan, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(pnDH, GroupLayout.PREFERRED_SIZE, 674, GroupLayout.PREFERRED_SIZE)
								.addComponent(pnDH_1, GroupLayout.PREFERRED_SIZE, 674, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblTimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblHan, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(pnDH, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(pnDH_1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
