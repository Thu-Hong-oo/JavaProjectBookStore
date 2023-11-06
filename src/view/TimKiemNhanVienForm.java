package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dao.NhanVien_DAO;
import entity.NhanVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class TimKiemNhanVienForm extends JPanel implements ActionListener, MouseListener, DocumentListener {
	private DefaultTableModel model;
	private JTable tbl;
	private JTextField txtMa, txtTen, txtSdt, txtDiaChi, txtEmail;
	private final ButtonGroup groupStatus = new ButtonGroup();
	private final ButtonGroup groupGioiTinh = new ButtonGroup();
	private final ButtonGroup groupTrinhDo = new ButtonGroup();
	private JRadioButton rdoDangLam, rdoDaNghi, rdoNam, rdoNu, rdoDH, rdoPT;
	private JYearChooser ycs;
	private JComboBox<String> cmbChucVu;
	private NhanVien_DAO NhanVien;
	private JButton btnLamMoi;

	/**
	 * Create the panel.
	 */
	public TimKiemNhanVienForm() {
		setBackground(SystemColor.controlHighlight);
		setSize(1100, 610);

		JLabel lbTieuDe = new JLabel("Tìm kiếm nhân viên");
		lbTieuDe.setFont(new Font("Tahoma", Font.PLAIN, 50));

		JScrollPane scrollPane_1 = new JScrollPane();
		String[] column = { "Mã NV", "Tên NV", "Ngày Sinh", "Giới Tính", "Số Điện Thoại", "Email", "Địa chỉ", "Chức vụ",
				"Trạng thái", "Trình độ" };
		model = new DefaultTableModel(column, 0);
		tbl = new JTable(model);
		tbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane_1.setViewportView(tbl);
		tbl.setRowSelectionAllowed(true);

		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSdt.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Tìm kiếm theo số điện thoại");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));

		JLabel lblNewLabel_5_1 = new JLabel("Tìm kiếm theo tên");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTen.setColumns(10);

		JLabel lblNewLabel_5_1_1 = new JLabel("Tìm kiếm theo chức vụ");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		cmbChucVu = new JComboBox();
		cmbChucVu.setModel(new DefaultComboBoxModel(new String[] { "","Nhân viên quản lý", "Nhân viên tư vấn",
				"Nhân viên bán hàng", "Nhân viên vệ sinh", "Bảo vệ" }));
		cmbChucVu.setSelectedItem(null);

		JLabel lblNewLabel_5_2 = new JLabel("Tìm kiếm theo mã:");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMa.setColumns(10);

		JLabel lblDiaChi = new JLabel("Tìm kiếm theo trạng thái làm việc");
		lblDiaChi.setFont(new Font("Tahoma", Font.BOLD, 12));

		rdoDangLam = new JRadioButton("Đang làm");
		rdoDangLam.setBackground(SystemColor.controlHighlight);
		groupStatus.add(rdoDangLam);
		rdoDangLam.setFont(new Font("Tahoma", Font.PLAIN, 12));

		rdoDaNghi = new JRadioButton("Đã nghỉ");
		rdoDaNghi.setBackground(SystemColor.controlHighlight);
		groupStatus.add(rdoDaNghi);
		rdoDaNghi.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblNewLabel = new JLabel("Tìm kiếm theo Năm Sinh");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));

		ycs = new JYearChooser();
		ycs.getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblNewLabel_1 = new JLabel("Tìm kiếm theo Địa chỉ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDiaChi.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Tìm kiếm theo Email:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Tìm kiếm theo giới tính");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));

		rdoNam = new JRadioButton("Nam");
		rdoNam.setBackground(SystemColor.controlHighlight);
		groupGioiTinh.add(rdoNam);
		rdoNam.setFont(new Font("Tahoma", Font.PLAIN, 12));

		rdoNu = new JRadioButton("Nữ");
		rdoNu.setBackground(SystemColor.controlHighlight);
		groupGioiTinh.add(rdoNu);
		rdoNu.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblTrinhDo = new JLabel("Tìm kiếm theo trình độ");
		lblTrinhDo.setFont(new Font("Tahoma", Font.BOLD, 12));

		rdoDH = new JRadioButton("Đại Học");
		rdoDH.setBackground(SystemColor.controlHighlight);
		groupTrinhDo.add(rdoDH);
		rdoDH.setFont(new Font("Tahoma", Font.PLAIN, 12));

		rdoPT = new JRadioButton("Phổ thông");
		rdoPT.setBackground(SystemColor.controlHighlight);
		groupTrinhDo.add(rdoPT);
		rdoPT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setFont(new Font("Tahoma", Font.BOLD, 13));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(277)
							.addComponent(lbTieuDe, GroupLayout.PREFERRED_SIZE, 597, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addComponent(lblNewLabel_5_2, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(txtMa, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(ycs, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addComponent(lblNewLabel_5_1_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(cmbChucVu, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addGap(16)
							.addComponent(rdoNam, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(rdoNu, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(rdoDangLam, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addComponent(rdoDaNghi, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(78)
							.addComponent(lblTrinhDo, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(rdoDH, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(1)
							.addComponent(rdoPT, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
									.addGap(62)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
									.addGap(33)
									.addComponent(txtEmail))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
									.addGap(60)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
									.addGap(24)
									.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 1227, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(512)
							.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lbTieuDe, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_5_2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(txtMa, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(7)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addComponent(ycs, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4)
									.addComponent(lblNewLabel_5_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(9)
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(1)
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtSdt, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(6)
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_5_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbChucVu, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(rdoNam, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(rdoNu, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDiaChi, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdoDangLam, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdoDaNghi, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblTrinhDo, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE))
						.addComponent(rdoDH, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdoPT, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLamMoi, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		tbl.addMouseListener(this);
		btnLamMoi.addActionListener(this);
		NhanVien = new NhanVien_DAO();
		// Đổ dữ liệu từ csdl vào table
		try {
			NhanVien = new NhanVien_DAO();
			for (NhanVien nv : NhanVien.getAllNhanVien()) {
				Object[] rowNV = { nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh(), nv.getGioiTinh(),
						nv.getSoDienThoai(), nv.getEmail(), nv.getDiaChi(), nv.getChucVu(), nv.getTrangThaiLamViec(),
						nv.getTrinhDo(), nv.getTenDangNhap(), nv.getMatKhau() };
				model.addRow(rowNV);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		// đăng ký sự kiện cho comboBox
		cmbChucVu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String chucVu = (String) cmbChucVu.getSelectedItem();
				RowFilter<DefaultTableModel, Object> filter = new RowFilter<DefaultTableModel, Object>() {
					public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
						Object value = entry.getValue(7);
						return value.toString().equalsIgnoreCase(chucVu);
					}
				};
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
				sorter.setRowFilter(filter);

				tbl.setRowSorter(sorter);
			}
		});
		// đăng ký sự kiện
		ycs.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				// TODO Auto-generated method stub
				if ("year".equals(evt.getPropertyName())) { // Kiểm tra nếu năm được chọn thay đổi
					int selectedYear = ycs.getYear(); // Lấy năm được chọn từ JYearChooser
					String formattedYear = String.valueOf(selectedYear); // Định dạng lại năm thành chuỗi

					DefaultTableModel model = (DefaultTableModel) tbl.getModel();
					TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

					// Tạo một bộ lọc để lấy các dòng có giá trị trong cột "Năm" trùng với năm được
					// chọn
					RowFilter<Object, Object> filter = RowFilter.regexFilter(formattedYear, 2);
					sorter.setRowFilter(filter);

					// Đặt sorter cho bảng
					tbl.setRowSorter(sorter);
				}

			}
		});
		// đăng ký sự tìm kiếm trên txt
		txtMa.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				findData();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				findData();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				findData();
			}

			private void findData() {
				String maNV = txtMa.getText().trim().toLowerCase(); // Chuyển text nhập vào thành chữ thường
				DefaultTableModel model = (DefaultTableModel) tbl.getModel();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

				RowFilter<DefaultTableModel, Object> filter = new RowFilter<DefaultTableModel, Object>() {
					public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
						String maNhanVien = entry.getStringValue(0).toLowerCase(); // Chuyển dữ liệu cột "Mã NV" thành
																					// chữ thường
						return maNhanVien.contains(maNV);
					}
				};

				sorter.setRowFilter(filter);
				tbl.setRowSorter(sorter);
			}
		});

		txtTen.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				findData();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				findData();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				findData();
			}

			private void findData() {
				String tenNV = txtTen.getText().trim().toLowerCase(); // Chuyển text nhập vào thành chữ thường
				DefaultTableModel model = (DefaultTableModel) tbl.getModel();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

				RowFilter<DefaultTableModel, Object> filter = new RowFilter<DefaultTableModel, Object>() {
					public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
						String tenNhanVien = entry.getStringValue(1).toLowerCase(); // Chuyển dữ liệu cột "Mã NV" thành
																					// chữ thường
						return tenNhanVien.contains(tenNV);
					}
				};

				sorter.setRowFilter(filter);
				tbl.setRowSorter(sorter);
			}
		});

		txtSdt.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				findData();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				findData();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				findData();
			}

			private void findData() {
				String sdt = txtSdt.getText().trim();
				DefaultTableModel model = (DefaultTableModel) tbl.getModel();
				RowFilter<Object, Object> filter = RowFilter.regexFilter(sdt, 4);
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
				sorter.setRowFilter(filter);
				tbl.setRowSorter(sorter);
			}
		});
		txtEmail.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				findData();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				findData();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				findData();
			}

			private void findData() {
				String email = txtEmail.getText().trim().toLowerCase(); // Chuyển text nhập vào thành chữ thường
				DefaultTableModel model = (DefaultTableModel) tbl.getModel();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

				RowFilter<DefaultTableModel, Object> filter = new RowFilter<DefaultTableModel, Object>() {
					public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
						String Email = entry.getStringValue(5).toLowerCase(); // Chuyển dữ liệu cột "Mã NV" thành chữ
																				// thường
						return Email.contains(email);
					}
				};

				sorter.setRowFilter(filter);
				tbl.setRowSorter(sorter);
			}
		});

		txtDiaChi.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void removeUpdate(DocumentEvent e) {
				findData();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				findData();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				findData();
			}

			private void findData() {
				String diaChi = txtDiaChi.getText().trim().toLowerCase(); // Chuyển text nhập vào thành chữ thường
				DefaultTableModel model = (DefaultTableModel) tbl.getModel();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

				RowFilter<DefaultTableModel, Object> filter = new RowFilter<DefaultTableModel, Object>() {
					public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
						String DiaChi = entry.getStringValue(6).toLowerCase(); // Chuyển dữ liệu cột "Mã NV" thành chữ
																				// thường
						return DiaChi.contains(diaChi);
					}
				};

				sorter.setRowFilter(filter);
				tbl.setRowSorter(sorter);
			}
		});

// đăng ký sự kiện cho radio
		rdoNam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Khi rdoNam được chọn
				applyGenderFilter();
			}
		});

		rdoNu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Khi rdoNu được chọn
				applyGenderFilter();
			}
		});

		rdoDangLam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				applyStatusFilter();
			}
		});

		rdoDaNghi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Khi rdoNu được chọn
				applyStatusFilter();
			}
		});
		rdoDH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Khi rdoNam được chọn
				applyLevelFilter();
			}
		});

		rdoPT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Khi rdoNu được chọn
				applyLevelFilter();
			}
		});
	}
//lọc giới tính
	private void applyGenderFilter() {
		// Tạo một RowFilter để lọc theo giới tính
		RowFilter<DefaultTableModel, Object> genderFilter = new RowFilter<DefaultTableModel, Object>() {
			public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
				Object value = entry.getValue(3); // 3 là chỉ số cột chứa giới tính

				// Nếu cả rdoNam và rdoNu đều không được chọn, hiển thị tất cả
				if (!rdoNam.isSelected() && !rdoNu.isSelected()) {
					return true;
				}

				// Nếu rdoNam được chọn và giới tính là "Nam", hiển thị dòng này
				if (rdoNam.isSelected() && value.toString().equalsIgnoreCase("Nam")) {
					return true;
				}

				// Nếu rdoNu được chọn và giới tính là "Nữ", hiển thị dòng này
				if (rdoNu.isSelected() && value.toString().equalsIgnoreCase("Nữ")) {
					return true;
				}

				return false;
			}
		};

		// Đặt bộ lọc cho TableRowSorter
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		sorter.setRowFilter(genderFilter);
		tbl.setRowSorter(sorter);
	}
	// lọc theo trạng thái làm việc
	private void applyStatusFilter() {
		// Tạo một RowFilter để lọc theo giới tính
		RowFilter<DefaultTableModel, Object> statusFilter = new RowFilter<DefaultTableModel, Object>() {
			public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
				Object value = entry.getValue(8); // 9 là chỉ số cột chứa Trạng thái tính từ 1

				// Nếu cả rdoNam và rdoNu đều không được chọn, hiển thị tất cả
				if (!rdoDangLam.isSelected() && !rdoDaNghi.isSelected()) {
					return true;
				}

				// Nếu rdoNam được chọn và giới tính là "Nam", hiển thị dòng này
				if (rdoDangLam.isSelected() && value.toString().equalsIgnoreCase("Đang làm")) {
					return true;
				}

				// Nếu rdoNu được chọn và giới tính là "Nữ", hiển thị dòng này
				if (rdoDaNghi.isSelected() && value.toString().equalsIgnoreCase("Đã nghỉ")) {
					return true;
				}

				return false;
			}
		};
		// Đặt bộ lọc cho TableRowSorter
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
		sorter.setRowFilter(statusFilter);
		tbl.setRowSorter(sorter);
	}
	private void applyLevelFilter() {
		// Tạo một RowFilter để lọc theo giới tính
		RowFilter<DefaultTableModel, Object> levelFilter = new RowFilter<DefaultTableModel, Object>() {
			public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
				Object value = entry.getValue(9); // 3 là chỉ số cột chứa giới tính

				// Nếu cả rdoNam và rdoNu đều không được chọn, hiển thị tất cả
				if (!rdoDH.isSelected() && !rdoPT.isSelected()) {
					return true;
				}

				// Nếu rdoNam được chọn và giới tính là "Nam", hiển thị dòng này
				if (rdoDH.isSelected() && value.toString().equalsIgnoreCase("Đại học")) {
					return true;
				}

				// Nếu rdoNu được chọn và giới tính là "Nữ", hiển thị dòng này
				if (rdoPT.isSelected() && value.toString().equalsIgnoreCase("Phổ thông")) {
					return true;
				}

				return false;
			}
		};
		// Đặt bộ lọc cho TableRowSorter
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
				sorter.setRowFilter(levelFilter);
				tbl.setRowSorter(sorter);
			}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		if (o.equals(tbl)) {
			int rowNV = tbl.getSelectedRow();
			int columnCount = tbl.getColumnCount();
			if (rowNV >= 0  && rowNV < tbl.getRowCount()) {
				txtMa.setText(tbl.getValueAt(rowNV, 0).toString());
				txtTen.setText(tbl.getValueAt(rowNV, 1).toString());
                    String ngaySinhStr = tbl.getValueAt(rowNV, 2).toString();
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date ngaySinh = dateFormat.parse(ngaySinhStr);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(ngaySinh);
                        int nam = calendar.get(Calendar.YEAR);
                        ycs.setYear(nam);
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                    }
				
                    if (columnCount > 3) {
                        if (model.getValueAt(rowNV, 3).toString().equalsIgnoreCase("Nam")) {
                            rdoNam.setSelected(true);
                            rdoNu.setSelected(false);
                        } else {
                            rdoNu.setSelected(true);
                            rdoNam.setSelected(false);
                        }
                    }
				txtSdt.setText(tbl.getValueAt(rowNV, 4).toString());
				txtEmail.setText(tbl.getValueAt(rowNV, 5).toString());
				txtDiaChi.setText(tbl.getValueAt(rowNV, 6).toString());
				//đẩy dữ liệu  lên comboBox
				cmbChucVu.setSelectedItem(tbl.getValueAt(rowNV, 7).toString());
				//đẩy dữ liệu lên button
				if (model.getValueAt(rowNV, 8).toString().equalsIgnoreCase("Đang làm việc")) {
					rdoDangLam.setSelected(true);
					rdoDaNghi.setSelected(false);
				} else {
					rdoDaNghi.setSelected(true);
					rdoDangLam.setSelected(false);
				}
				if (model.getValueAt(rowNV, 9).toString().equalsIgnoreCase("Đại học")) {
					rdoDH.setSelected(true);
					rdoPT.setSelected(false);
				} else {
					rdoDH.setSelected(true);
					rdoPT.setSelected(false);
				}
					
				
			}else {
				System.err.println("Chỉ mục không hợp lệ: " + rowNV);
			}
	}
	}
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnLamMoi))
			lamMoi();

	}

	private void lamMoi() {
		tbl.clearSelection();

	    // Đặt lại giá trị cho các thành phần trên giao diện
	    txtMa.setText("");
	    txtTen.setText("");
	    ycs.setYear(Year.now().getValue()); // Đặt lại năm hiện tại hoặc một giá trị mặc định khác
	    txtDiaChi.setText("");
	    txtSdt.setText("");
	    txtEmail.setText("");
	    txtDiaChi.setText("");
	    cmbChucVu.setSelectedItem(""); // Đặt lại giá trị của ComboBox

	    // Đặt lại trạng thái của RadioButton thông qua ButtonGroup
	    groupGioiTinh.clearSelection();
	    groupStatus.clearSelection();
	    groupTrinhDo.clearSelection();
		
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}
}
