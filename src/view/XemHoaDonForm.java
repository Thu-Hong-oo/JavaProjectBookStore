
package view;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import com.toedter.calendar.JDateChooser;

import entity.ChiTietHoaDon;
import entity.HoaDon;
import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.SanPham_DAO;

//import dao.ChiTietHoaDon_DAO;
//import dao.HoaDon_DAO;
//import dao.SanPham_DAO;
//import entity.ChiTietHoaDon;
//import entity.HoaDon;
//import entity.NhanVien;
//import entity.SanPham;

import javax.swing.UIManager;
import javax.swing.RowFilter.ComparisonType;
import javax.swing.RowFilter.Entry;

import java.awt.Canvas;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class XemHoaDonForm extends JPanel implements DocumentListener, ActionListener, MouseListener {
	private JTextField txtMaHD;
	private JTable table;
	private JButton btnLamMoi;
	private JTable tableHoaDon;
	private JTable tableChiTiet;
	private DefaultTableModel modelHoaDon;
	private DefaultTableModel modelChiTiet;
	private JDateChooser dateChooser;

	private HoaDon_DAO hoaDon;
	private JTextField txtMaKH;
	private JTextField txtMaNV;
	private ChiTietHoaDon_DAO ctHD;
	private SanPham_DAO sp;

	/**
	 * Create the panel.
	 */
	public XemHoaDonForm() {
		setLayout(null);
		setSize(1100, 610);
		setBackground(Color.WHITE);

		JLabel lblNewLabel = new JLabel("Lọc theo mã Hóa Đơn: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(48, 28, 160, 16);
		add(lblNewLabel);

		txtMaHD = new JTextField();
		txtMaHD.setBounds(231, 25, 223, 26);
		add(txtMaHD);
		txtMaHD.setColumns(10);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(XemHoaDonForm.class.getResource("/icon/refresh.png")));

		btnLamMoi.setBounds(955, 53, 135, 29);
		add(btnLamMoi);

		// tạo bảng hóa đơn
		String[] headerHoaDon = { "Mã Hoá Đơn", "Mã KH", "Mã NV", "Ngày lập HD", "Tổng tiền", "Ghi chú" };
		modelHoaDon = new DefaultTableModel(headerHoaDon, 0);
		tableHoaDon = new JTable(modelHoaDon);
		tableHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scpHoaDon = new JScrollPane(tableHoaDon, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scpHoaDon.setBounds(39, 171, 1051, 200);
		add(scpHoaDon);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.control);
		panel_5.setBorder(
				new TitledBorder(null, "Chi tiết hoá đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(39, 381, 1051, 269);
		add(panel_5);
		panel_5.setLayout(null);

		// tạo bảng chi tiết hóa đơn
		String[] headerChiTiet = { "Mã hoá đơn", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền" };
		modelChiTiet = new DefaultTableModel(headerChiTiet, 0);
		tableChiTiet = new JTable(modelChiTiet);
		tableChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tableChiTiet.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scpChiTiet = new JScrollPane(tableChiTiet, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scpChiTiet.setBounds(10, 24, 1031, 227);
		panel_5.add(scpChiTiet);

		JLabel lblNewLabel_1_4 = new JLabel("Lọc theo ngày tháng");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_4.setBounds(494, 29, 132, 16);
		add(lblNewLabel_1_4);
		dateChooser = new JDateChooser();
		dateChooser.setBounds(679, 25, 197, 27);
		add(dateChooser);

		JLabel lblNewLabel_1 = new JLabel("Lọc theo Mã Khách Hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(48, 100, 167, 13);
		add(lblNewLabel_1);

		txtMaKH = new JTextField();
		txtMaKH.setBounds(231, 98, 223, 26);
		add(txtMaKH);
		txtMaKH.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Lọc theo mã Nhân Viên:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(494, 103, 160, 13);
		add(lblNewLabel_2);

		txtMaNV = new JTextField();
		txtMaNV.setBounds(679, 98, 223, 26);
		add(txtMaNV);
		txtMaNV.setColumns(10);
		// Đăng ký sự kiện
		btnLamMoi.addActionListener(this);
		tableHoaDon.addMouseListener(this);
		// đổ dữ liệu từ csdl vào
		try {
			hoaDon = new HoaDon_DAO();
			for (HoaDon hd : hoaDon.getAllHoaDon()) {
				Object[] row = { hd.getMaHD(), hd.getMaKH(), hd.getMaNV(), hd.getNgayLapHD(), hd.getTongTien(),
						hd.getGhiChu() };
				modelHoaDon.addRow(row);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// Đổ dữ liệu từ csdl ChitietHoaDon vào bảng ChiTietHoaDon
		try {
			ctHD = new ChiTietHoaDon_DAO();
			sp = new SanPham_DAO();
			String tenSP;
			double donGia;
			for (ChiTietHoaDon cthd : ctHD.getAllChiTietHoaDon()) {
				tenSP = sp.getTenByMaSP(cthd.getMaSP());
				donGia = sp.getGiaBanByMaSP(cthd.getMaSP()); // Lấy giá trị giaBan từ cơ sở dữ liệu
				Object[] row = { cthd.getMaHD(), cthd.getMaSP(), tenSP, donGia, cthd.getSoLuong() };
				modelChiTiet.addRow(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Đăng ký sự kiện tìm kiếm
		txtMaHD.getDocument().addDocumentListener(new DocumentListener() {

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
				String maHD = txtMaHD.getText().trim().toLowerCase(); // Chuyển text nhập vào thành chữ thường
				DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

				RowFilter<DefaultTableModel, Object> filter = new RowFilter<DefaultTableModel, Object>() {
					public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
						String maHoaDon = entry.getStringValue(0).toLowerCase(); // Chuyển dữ liệu cột "Mã NV" thành
																					// chữ thường
						return maHoaDon.contains(maHD);
					}
				};
				sorter.setRowFilter(filter);
				tableHoaDon.setRowSorter(sorter);

			}
		});
		//
		// Đăng ký sự kiện tìm kiếm
		txtMaKH.getDocument().addDocumentListener(new DocumentListener() {

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
				String maKH = txtMaKH.getText().trim().toLowerCase(); // Chuyển text nhập vào thành chữ thường
				DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

				RowFilter<DefaultTableModel, Object> filter = new RowFilter<DefaultTableModel, Object>() {
					public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
						String maHoaDon = entry.getStringValue(1).toLowerCase(); // Chuyển dữ liệu cột "Mã NV" thành
																					// chữ thường
						return maHoaDon.contains(maKH);
					}
				};
				sorter.setRowFilter(filter);
				tableHoaDon.setRowSorter(sorter);

			}
		});
		// tìm kiếm theo nhân viên
		txtMaNV.getDocument().addDocumentListener(new DocumentListener() {

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
				String maNV = txtMaNV.getText().trim().toLowerCase(); // Chuyển text nhập vào thành chữ thường
				DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

				RowFilter<DefaultTableModel, Object> filter = new RowFilter<DefaultTableModel, Object>() {
					public boolean include(Entry<? extends DefaultTableModel, ? extends Object> entry) {
						String maHoaDon = entry.getStringValue(2).toLowerCase(); // Chuyển dữ liệu cột "Mã NV" thành
																					// chữ thường
						return maHoaDon.contains(maNV);
					}
				};
				sorter.setRowFilter(filter);
				tableHoaDon.setRowSorter(sorter);

			}
		});

		// đăng kí sự kiện tìm kiếm theo đúng ngày tháng
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("date".equals(evt.getPropertyName())) { // Kiểm tra nếu ngày được chọn thay đổi
					java.util.Date date = dateChooser.getDate();
					Date selectedDate = new Date((long) date.getTime()); // Lấy ngày được chọn trên JDateChooser
					String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate); // Định dạng lại
																									// ngày
					DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
					TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

					// Tạo một bộ lọc để lấy các dòng có giá trị ngày trùng với ngày được chọn trên
					// JDateChooser
					RowFilter<Object, Object> filter = RowFilter.regexFilter(formattedDate, 3);
					sorter.setRowFilter(filter);

					// Đặt sorter cho bảng
					tableHoaDon.setRowSorter(sorter);
				}
			}
		});
		// đăng ký sự kiện cho txtMaNhanVien
		txtMaNV.getDocument().addDocumentListener(new DocumentListener() {

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
				String locMaNV = txtMaNV.getText().trim();
				DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
				// Tạo một bộ lọc để lấy các dòng có giá trị maNV trùng với text
				RowFilter<Object, Object> filter = RowFilter.regexFilter(locMaNV, 2);

				// Tạo một sorter để sắp xếp lại các dòng
				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
				sorter.setRowFilter(filter);

				// Đặt sorter cho bảng
				tableHoaDon.setRowSorter(sorter);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnLamMoi)) {
			txtMaHD.setText("");
			txtMaKH.setText("");
			txtMaNV.setText("");
			Calendar currentDate = Calendar.getInstance();
			dateChooser.setDate(currentDate.getTime());

		}
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

// tim kiem theo ma hoa don
	private void filterCTHDByMaHD(String maHD) {
		DefaultTableModel model = (DefaultTableModel) tableChiTiet.getModel();
		model.setRowCount(0); // Xóa các dòng hiện tại trong bảng

		ArrayList<ChiTietHoaDon> dsCTHD = ctHD.getAllChiTietHoaDon();
		for (ChiTietHoaDon cthd : dsCTHD) {
			if (cthd.getMaHD().equals(maHD)) {
				String tenSP = sp.getTenByMaSP(cthd.getMaSP());
				double donGia = sp.getGiaBanByMaSP(cthd.getMaSP());
				Object[] row = { cthd.getMaHD(), cthd.getMaSP(), tenSP, donGia, cthd.getSoLuong() };
				model.addRow(row);
			}
		}

	}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	Object o = e.getSource();
	if (o.equals(tableHoaDon)) {
		int row = tableHoaDon.getSelectedRow();
		if (row >= 0) {
			String maHD = tableHoaDon.getValueAt(row, 0).toString();
			filterCTHDByMaHD(maHD);
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

}

