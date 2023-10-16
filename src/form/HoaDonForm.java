
package form;

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

//import dao.ChiTietHoaDon_DAO;
//import dao.HoaDon_DAO;
//import dao.SanPham_DAO;
//import entity.ChiTietHoaDon;
//import entity.HoaDon;
//import entity.NhanVien;
//import entity.SanPham;

import javax.swing.UIManager;
import javax.swing.RowFilter.ComparisonType;

import java.awt.Canvas;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;

public class HoaDonForm extends JPanel  {
	private JTextField txtMaHD;
	private JTable table;
	private JButton btnXoaRong;
	private JTable tableHoaDon;
	private JTable tableChiTiet;
	private DefaultTableModel modelHoaDon;
	private DefaultTableModel modelChiTiet;
	private JDateChooser dateChooser;
	
//	private HoaDon_DAO hoaDon;
//	private ChiTietHoaDon_DAO ctHD;
//	private SanPham_DAO sp;

	/**
	 * Create the panel.
	 */
	public HoaDonForm() {
		setLayout(null);
		setSize(1100, 610);
		setBackground(Color.WHITE);

		JLabel lblNewLabel = new JLabel("Lọc theo mã HD/ tên KH/NV:");
		lblNewLabel.setBounds(61, 30, 160, 16);
		add(lblNewLabel);

		txtMaHD = new JTextField();
		txtMaHD.setBounds(231, 25, 223, 26);
		add(txtMaHD);
		txtMaHD.setColumns(10);


		btnXoaRong = new JButton("Làm mới");
		btnXoaRong.setBackground(new Color(250, 128, 114));
		btnXoaRong.setBounds(908, 24, 100, 29);
		add(btnXoaRong);
		

		// tạo bảng hóa đơn
		String[] headerHoaDon = { "Mã HD", "Mã KH", "Mã NV", "Tổng tiền", "Tiền đưa", "Tiền trả", 
				"Ngày lập HD", "Ghi chú" };
		modelHoaDon = new DefaultTableModel(headerHoaDon, 0);
		tableHoaDon = new JTable(modelHoaDon);
		tableHoaDon.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scpHoaDon = new JScrollPane(tableHoaDon, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scpHoaDon.setBounds(39, 103, 1004, 200);
		add(scpHoaDon);
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.control);
		panel_5.setBorder(new TitledBorder(null, "Chi tiết hoá đơn", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_5.setBounds(39, 330, 1004, 269);
		add(panel_5);
		panel_5.setLayout(null);
		
		//tạo bảng chi tiết hóa đơn
		String[] headerChiTiet = { "Mã hoá đơn", "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Thành tiền" };
		modelChiTiet = new DefaultTableModel(headerChiTiet, 0);
		tableChiTiet = new JTable(modelChiTiet);
		tableChiTiet.setBorder(new LineBorder(new Color(0, 0, 0)));
		JScrollPane scpChiTiet = new JScrollPane(tableChiTiet,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED ,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scpChiTiet.setBounds(10, 24, 984, 227);
		panel_5.add(scpChiTiet);
		
		
				
				JLabel lblNewLabel_1_4 = new JLabel("Lọc theo ngày tháng");
				lblNewLabel_1_4.setBounds(527, 30, 132, 16);
				add(lblNewLabel_1_4);
				dateChooser = new JDateChooser();
				dateChooser.setBounds(651, 25, 197, 27);
				add(dateChooser);
		
	}}
//		btnXoaRong.addActionListener(this);
//		
//		try {
//			hoaDon = new HoaDon_DAO();
//			for (entity.HoaDon hd : hoaDon.getAllHoaDon()) {
//				Object[] row = { hd.getMaHD(), hd.getMaKH(), hd.getMaNV(), hd.getTongTien(), hd.getTienDua(),
//						hd.getTienTra(), hd.gethTTT(), hd.gethTGH(), hd.getNgayLap(), hd.getGhiChu() };
//				modelHoaDon.addRow(row);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}

//		try {
//			ctHD = new ChiTietHoaDon_DAO();
//			sp = new SanPham_DAO();
//			String tenSP;
//			for (ChiTietHoaDon cthd : ctHD.getAllChiTietHoaDon()) {
//				tenSP = sp.getTenByMaSP(cthd.getMaSP());
//				Object[] row = { cthd.getMaHD(), cthd.getMaSP(), tenSP, cthd.getDonGia(), cthd.getSoLuong(),
//						cthd.getThanhTien() };
//				modelChiTiet.addRow(row);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//
//		}
//		tableHoaDon.addMouseListener(this);
//		txtMaHD.getDocument().addDocumentListener(new DocumentListener() {
//
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				findData();
//
//			}
//
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				findData();
//
//			}
//
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				findData();
//
//			}
//
//			private void findData() {
//				String locMaHD = txtMaHD.getText().trim();
//				DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
//				// Tạo một bộ lọc để lấy các dòng có giá trị maNV trùng với text
//				RowFilter<Object, Object> filter = RowFilter.regexFilter(locMaHD, 0);
//
//				// Tạo một sorter để sắp xếp lại các dòng
//				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
//				sorter.setRowFilter(filter);
//
//				// Đặt sorter cho bảng
//				tableHoaDon.setRowSorter(sorter);
//			}
//		});
//		txtMaKH.getDocument().addDocumentListener(new DocumentListener() {
//
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				findData();
//
//			}
//
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				findData();
//
//			}
//
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				findData();
//
//			}
//
//			private void findData() {
//				String maKH = txtMaKH.getText().trim();
//				DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
//				// Tạo một bộ lọc để lấy các dòng có giá trị maNV trùng với text
//				RowFilter<Object, Object> filter = RowFilter.regexFilter(maKH, 1);
//
//				// Tạo một sorter để sắp xếp lại các dòng
//				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
//				sorter.setRowFilter(filter);
//
//				// Đặt sorter cho bảng
//				tableHoaDon.setRowSorter(sorter);
//			}
//		});
//		
//		txtMaNV.getDocument().addDocumentListener(new DocumentListener() {
//
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				findData();
//
//			}
//
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				findData();
//
//			}
//
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				findData();
//
//			}
//
//			private void findData() {
//				String maNV = txtMaNV.getText().trim();
//				DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
//				// Tạo một bộ lọc để lấy các dòng có giá trị maNV trùng với text
//				RowFilter<Object, Object> filter = RowFilter.regexFilter(maNV, 2);
//
//				// Tạo một sorter để sắp xếp lại các dòng
//				TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
//				sorter.setRowFilter(filter);
//
//				// Đặt sorter cho bảng
//				tableHoaDon.setRowSorter(sorter);
//			}
//		});
//		
//		// Xử lý cbb HTGH:	
//		cbbHTGH.setSelectedIndex(0);
//		cbbHTGH.addActionListener(new ActionListener() {
//			   public void actionPerformed(ActionEvent e) {
//			      String hTTT = (String) cbbHTGH.getSelectedItem();
//			      // Xử lý giá trị được chọn
//			      DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
//					// Tạo một bộ lọc để lấy các dòng có giá trị maNV trùng với text
//					RowFilter<Object, Object> filter = RowFilter.regexFilter(hTTT, 7);
//
//					// Tạo một sorter để sắp xếp lại các dòng
//					TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
//					sorter.setRowFilter(filter);
//
//					// Đặt sorter cho bảng
//					tableHoaDon.setRowSorter(sorter);
//			      
//			   }
//			});
//		
//		// Xử lý cbb HTTT:	
//		cbbHTTT.setSelectedIndex(0);
//		cbbHTTT.addActionListener(new ActionListener() {
//			   public void actionPerformed(ActionEvent e) {
//			      String hTTT = (String) cbbHTTT.getSelectedItem();
//			      // Xử lý giá trị được chọn
//			      DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
//					// Tạo một bộ lọc để lấy các dòng có giá trị maNV trùng với text
//					RowFilter<Object, Object> filter = RowFilter.regexFilter(hTTT, 6);
//
//					// Tạo một sorter để sắp xếp lại các dòng
//					TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
//					sorter.setRowFilter(filter);
//
//					// Đặt sorter cho bảng
//					tableHoaDon.setRowSorter(sorter);
//			      
//			   }
//			});
//		
//		// Xử lý cbb Tổng tiền:	
//		cbbTT.setSelectedIndex(0);
//		cbbTT.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String tongTien = (String) cbbTT.getSelectedItem();
//				if(!cbbTT.getSelectedItem().equals("")) {
//					String[] range = tongTien.split("-");
//					long min = Long.parseLong(range[0].trim().replace(".", ""));
//					long max = Long.parseLong(range[1].trim().replace(".", ""));
//
//					DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
//					TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
//
//					ArrayList<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>(2);
//					//So sánh khoảng giá trị ở item đã chọn với các giá trị ở cột Tổng tiền trong table Hoá đơn
//					filters.add( RowFilter.numberFilter(ComparisonType.AFTER, min, 3) );
//					filters.add( RowFilter.numberFilter(ComparisonType.BEFORE, max, 3) );
//
//					RowFilter<Object, Object> rf = RowFilter.andFilter(filters);
//					sorter.setRowFilter(rf);
//
//					// Đặt bộ lọc cho sorter
//					tableHoaDon.setRowSorter(sorter);
//				}
//			}
//		});
//
//
//			
//		// Xử lý lọc bằng ngày tháng:
//		
//		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
//		    @Override
//		    public void propertyChange(PropertyChangeEvent evt) {
//		        if ("date".equals(evt.getPropertyName())) { // Kiểm tra nếu ngày được chọn thay đổi
//		        	java.util.Date date = dateChooser.getDate();
//		        	Date selectedDate = new Date((long) date.getTime()); // Lấy ngày được chọn trên JDateChooser
//		            String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(selectedDate); // Định dạng lại ngày
//		            DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
//		            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
//
//		            // Tạo một bộ lọc để lấy các dòng có giá trị ngày trùng với ngày được chọn trên JDateChooser
//		            RowFilter<Object, Object> filter = RowFilter.regexFilter(formattedDate, 8);
//		            sorter.setRowFilter(filter);
//
//		            // Đặt sorter cho bảng
//		            tableHoaDon.setRowSorter(sorter);
//		        }
//		    }
//		});
//
//	}
//	private void filterCTHDByMaHD(String maHD) {
//		DefaultTableModel model = (DefaultTableModel) tableChiTiet.getModel();
//		model.setRowCount(0); // Xóa các dòng hiện tại trong bảng
//
//		ArrayList<ChiTietHoaDon> dsCTHD = ctHD.getAllChiTietHoaDon();
//		for (ChiTietHoaDon cthd : dsCTHD) {
//			if (cthd.getMaHD().equals(maHD)) {
//				String tenSP = sp.getTenByMaSP(cthd.getMaSP());
//				Object[] row = { cthd.getMaHD(), cthd.getMaSP(), tenSP, cthd.getDonGia(), cthd.getSoLuong(),
//						cthd.getThanhTien() };
//				model.addRow(row);
//			}
//		}
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		Object o = e.getSource();
//		if(o.equals(btnXoaRong)) {
//			txtMaHD.setText("");
//			txtMaKH.setText("");
//			txtMaNV.setText("");
//			cbbHTGH.setSelectedItem("");
//			cbbHTTT.setSelectedItem("");
//			cbbTT.setSelectedItem("");
//		}
//	}
//
//	@Override
//	public void mouseClicked(MouseEvent e) {
//		Object o = e.getSource();
//		if (o.equals(tableHoaDon)) {
//			int row = tableHoaDon.getSelectedRow();
//			if (row >= 0) {
//				String maHD = tableHoaDon.getValueAt(row, 0).toString();
////				System.out.println(maHD);
//				filterCTHDByMaHD(maHD);
//			}
//		}
//
//	}
//
//	@Override
//	public void mousePressed(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseReleased(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseEntered(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void mouseExited(MouseEvent e) {
//		// TODO Auto-generated method stub
//
//	}
//}
