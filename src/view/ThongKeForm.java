package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.SanPham_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.ThongKe;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JLayeredPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

//implements ActionListener, ItemListener, PropertyChangeListener
public class ThongKeForm extends JPanel implements ActionListener, MouseListener, PropertyChangeListener, ItemListener {
	private JTextField txtSLMua;
	private DefaultTableModel modelHoaDon;
	private JTable tableHoaDon;
	private HoaDon_DAO hoaDon;
	private SanPham_DAO sanPham;
	private ChiTietHoaDon_DAO ctHD;
	private JComboBox<String> cmbSP;
	private JLabel lbTienDoanhThu;
	private JLabel lbTongKhach;
	private JLabel lbSanPhamMuaNhieu;
	private JLabel lbSoHD;
	private JRadioButton rdoDenNay, rdoTheoThang, rdoTheoNam;
	private JPanel pnlChart;
	private JYearChooser yearChooser;
	private JMonthChooser monthChooser;
	private JYearChooser monthYearChooser;
	private ThongKe tk = new ThongKe();

	/**
	 * Create the panel.
	 */
	public ThongKeForm() {
		setSize(960, 660);
		setBackground(Color.WHITE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);

		JPanel panelDoanhThu = new JPanel();
		panelDoanhThu.setBackground(new Color(57, 73, 98));
		panelDoanhThu.setBounds(20, 11, 199, 107);
		panel.add(panelDoanhThu);
		panelDoanhThu.setLayout(null);

		JLabel lbttDoanhThu = new JLabel(" Doanh thu");
		lbttDoanhThu.setBounds(25, 11, 159, 42);
		panelDoanhThu.add(lbttDoanhThu);
		lbttDoanhThu.setBackground(new Color(105, 131, 150));
		lbttDoanhThu.setVerticalAlignment(SwingConstants.CENTER);
//		lbttDoanhThu.setIcon(new ImageIcon(ThongKeForm.class.getResource("/Images/banHang.png")));
		lbttDoanhThu.setFont(new Font("Dialog", Font.BOLD, 20));

		lbTienDoanhThu = new JLabel("");
		lbTienDoanhThu.setHorizontalAlignment(SwingConstants.CENTER);
		lbTienDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbTienDoanhThu.setBounds(10, 64, 147, 34);
		panelDoanhThu.add(lbTienDoanhThu);

		JLabel lblNewLabel_2 = new JLabel("VND");
		lblNewLabel_2.setBounds(157, 71, 46, 24);
		panelDoanhThu.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(57, 73, 98));
//		lblNewLabel.setIcon(new ImageIcon(
//				ThongKeForm.class.getResource("/Images/z4316830837594_f40f64e091a1b9436501806c37383c11.jpg")));
		lblNewLabel.setBounds(0, 0, 199, 107);
		panelDoanhThu.add(lblNewLabel);

		JPanel panelDoanhThu_1 = new JPanel();
		panelDoanhThu_1.setLayout(null);
		panelDoanhThu_1.setBackground(new Color(57, 73, 98));
		panelDoanhThu_1.setBounds(239, 11, 199, 107);
		panel.add(panelDoanhThu_1);

		JLabel lblSHan = new JLabel("Số hóa đơn");
//		lblSHan.setIcon(new ImageIcon(ThongKeForm.class.getResource("/Images/hoaDon.png")));
		lblSHan.setVerticalAlignment(SwingConstants.CENTER);
		lblSHan.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSHan.setBackground(new Color(57, 73, 98));
		lblSHan.setBounds(25, 11, 159, 42);
		panelDoanhThu_1.add(lblSHan);

		lbSoHD = new JLabel("");
		lbSoHD.setHorizontalAlignment(SwingConstants.CENTER);
		lbSoHD.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbSoHD.setBounds(35, 64, 149, 34);
		panelDoanhThu_1.add(lbSoHD);

		JLabel lblNewLabel_1 = new JLabel("");
//		lblNewLabel_1.setIcon(new ImageIcon(
//				ThongKeForm.class.getResource("/Images/z4316830837594_f40f64e091a1b9436501806c37383c11.jpg")));
		lblNewLabel_1.setBounds(0, 0, 199, 107);
		panelDoanhThu_1.add(lblNewLabel_1);

		JPanel panelDoanhThu_3 = new JPanel();
		panelDoanhThu_3.setLayout(null);
		panelDoanhThu_3.setBackground(new Color(57, 73, 98));
		panelDoanhThu_3.setBounds(453, 11, 213, 107);
		panel.add(panelDoanhThu_3);

		JLabel lblTngKhch = new JLabel("Tổng khách");
//		lblTngKhch.setIcon(new ImageIcon(ThongKeForm.class.getResource("/Images/nhanVien.png")));
		lblTngKhch.setVerticalAlignment(SwingConstants.CENTER);
		lblTngKhch.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTngKhch.setBackground(new Color(57, 73, 98));
		lblTngKhch.setBounds(25, 11, 159, 42);
		panelDoanhThu_3.add(lblTngKhch);

		lbTongKhach = new JLabel("");
		lbTongKhach.setHorizontalAlignment(SwingConstants.CENTER);
		lbTongKhach.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbTongKhach.setBounds(35, 62, 143, 34);
		panelDoanhThu_3.add(lbTongKhach);

		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setBounds(0, 0, 199, 107);
		panelDoanhThu_3.add(lblNewLabel_1_1_1);
//		lblNewLabel_1_1_1.setIcon(new ImageIcon(
//				ThongKeForm.class.getResource("/Images/z4316830837594_f40f64e091a1b9436501806c37383c11.jpg")));

		rdoDenNay = new JRadioButton("Đến nay");
		rdoDenNay.setBackground(Color.WHITE);
		rdoDenNay.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdoDenNay.setBounds(67, 194, 81, 23);
		panel.add(rdoDenNay);

		rdoTheoThang = new JRadioButton("Theo tháng");
		rdoTheoThang.setBackground(Color.WHITE);
		rdoTheoThang.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdoTheoThang.setBounds(67, 231, 98, 23);
		panel.add(rdoTheoThang);

		rdoTheoNam = new JRadioButton("Theo năm");
		rdoTheoNam.setBackground(Color.WHITE);
		rdoTheoNam.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdoTheoNam.setBounds(67, 269, 98, 23);
		panel.add(rdoTheoNam);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoTheoNam);
		buttonGroup.add(rdoDenNay);
		buttonGroup.add(rdoTheoThang);

		monthChooser = new JMonthChooser();
		monthChooser.setBounds(177, 234, 100, 26);
		panel.add(monthChooser);

		yearChooser = new JYearChooser();
		yearChooser.setBounds(177, 272, 99, 25);
		panel.add(yearChooser);

		JPanel panelDoanhThu_3_1 = new JPanel();
		panelDoanhThu_3_1.setLayout(null);
		panelDoanhThu_3_1.setBackground(new Color(57, 73, 98));
		panelDoanhThu_3_1.setBounds(676, 11, 322, 107);
		panel.add(panelDoanhThu_3_1);

		JLabel lblTngKhch_1 = new JLabel("Sản phẩm bán chạy nhất");
//		lblTngKhch_1.setIcon(new ImageIcon(ThongKeForm.class.getResource("/Images/sanPham.png")));
		lblTngKhch_1.setVerticalAlignment(SwingConstants.CENTER);
		lblTngKhch_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTngKhch_1.setBackground(new Color(64, 128, 128));
		lblTngKhch_1.setBounds(10, 10, 253, 42);
		panelDoanhThu_3_1.add(lblTngKhch_1);

		lbSanPhamMuaNhieu = new JLabel("");
		lbSanPhamMuaNhieu.setHorizontalAlignment(SwingConstants.CENTER);
		lbSanPhamMuaNhieu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbSanPhamMuaNhieu.setBounds(10, 62, 302, 34);
		panelDoanhThu_3_1.add(lbSanPhamMuaNhieu);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("");
		lblNewLabel_1_1_1_2.setBounds(0, 0, 224, 107);
		panelDoanhThu_3_1.add(lblNewLabel_1_1_1_2);
//		lblNewLabel_1_1_1_2.setIcon(new ImageIcon(
//				ThongKeForm.class.getResource("/Images/z4316830837594_f40f64e091a1b9436501806c37383c11.jpg")));

		cmbSP = new JComboBox();
		cmbSP.setBounds(623, 231, 192, 29);
		panel.add(cmbSP);

		JLabel lblNewLabel_3 = new JLabel("Số lượng sản phẩm đã bán:  ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(429, 231, 184, 23);
		panel.add(lblNewLabel_3);

		txtSLMua = new JTextField();
		txtSLMua.setForeground(new Color(255, 0, 0));
		txtSLMua.setEditable(false);
		txtSLMua.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtSLMua.setBounds(842, 230, 86, 29);
		panel.add(txtSLMua);
		txtSLMua.setColumns(10);

		try {
			hoaDon = new HoaDon_DAO();
			sanPham = new SanPham_DAO();
			ctHD = new ChiTietHoaDon_DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}

		cmbSP.setModel(sanPham.loadComBoBox("tenSP", "SanPham"));
		cmbSP.setSelectedItem(null);

		monthYearChooser = new JYearChooser();
		monthYearChooser.setBounds(272, 234, 84, 26);
		panel.add(monthYearChooser);

		// biểu đồ
// Lấy dữ liệu từ bảng hóa đơn của bạn và tính tổng số hóa đơn cho từng tháng
		Map<String, Integer> tongSoHDTheoThang = new HashMap<>();// lưu trữ tổng số hóa đơn theo tháng
		for (HoaDon hd : hoaDon.getAllHoaDon()) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
			String thang = dateFormat.format(hd.getNgayLapHD());// lấy tháng từ ngày lập hóa đơn
			int tongSoHD = tongSoHDTheoThang.getOrDefault(thang, 0);
			tongSoHDTheoThang.put(thang, tongSoHD + 1);
		}
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();// tạo dataset chứa dữ liệu cho biểu đồ
		for (Map.Entry<String, Integer> entry : tongSoHDTheoThang.entrySet()) {
			String thang = entry.getKey();
			int tongSoHD = entry.getValue();
			dataset.addValue(tongSoHD, "Hóa đơn", thang);
		}

		JFreeChart chart = ChartFactory.createBarChart("Biểu đồ số lượng hóa đơn theo tháng", // Tiêu đề biểu đồ
				"Tháng", // Nhãn trục x
				"Số lượng", // Nhãn trục y
				dataset, // Dataset chứa dữ liệu
				PlotOrientation.VERTICAL, // Hướng của biểu đồ
				false, // Hiển thị legend
				true, // Hiển thị tooltip
				false // Hiển thị URLs
		);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setSeriesPaint(0, new Color(95, 158, 160)); // Thay đổi màu sắc của cột
		
		

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel,
				GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addGap(1).addComponent(panel, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)));
		
				ChartPanel chartPanel = new ChartPanel(chart);
				chartPanel.setBounds(110, 313, 775, 336);
				panel.add(chartPanel);
				chartPanel.setPreferredSize(new Dimension(500, 300));
				
						JPanel panelTree = new JPanel();
						chartPanel.add(panelTree);
						panelTree.setBorder(UIManager.getBorder("TitledBorder.border"));
						panelTree.setLayout(null);
		setLayout(groupLayout);
		
	
		rdoDenNay.addItemListener(this);
		rdoTheoThang.addItemListener(this);
		rdoTheoNam.addItemListener(this);
		cmbSP.addActionListener(this);
		monthChooser.addPropertyChangeListener(this);
		monthYearChooser.addPropertyChangeListener(this);
		yearChooser.addPropertyChangeListener(this);
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
		if (o.equals(cmbSP)) {
			hienThiSL();
		}

	}

	private void hienThiSL() {
		String selectedProduct = cmbSP.getSelectedItem().toString();
		int soLuongMua = ctHD.getSoLuongMua(selectedProduct);
		txtSLMua.setText(Integer.toString(soLuongMua));

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();

		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (o.equals(rdoTheoThang)) {
				int thang = monthChooser.getMonth() + 1;
				int nam = monthYearChooser.getYear();
				tk = hoaDon.getThongKeByMonth(thang, nam);
				//
				lbTienDoanhThu.setText(Long.toString(tk.getDoanhThu()));
				lbSoHD.setText(Long.toString(tk.getSoHoaDon()));
				lbTongKhach.setText(Long.toString(tk.getTongKhach()));
				lbSanPhamMuaNhieu.setText(tk.getTenSPMuaNhieu());
				monthChooser.addPropertyChangeListener(new PropertyChangeListener() {

//							@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if ("month".equals(evt.getPropertyName())) {
							int thang = monthChooser.getMonth() + 1;
							int nam = monthYearChooser.getYear();
							tk = hoaDon.getThongKeByMonth(thang, nam);
							//
							lbTienDoanhThu.setText(Long.toString(tk.getDoanhThu()));
							lbSoHD.setText(Long.toString(tk.getSoHoaDon()));
							lbTongKhach.setText(Long.toString(tk.getTongKhach()));
							lbSanPhamMuaNhieu.setText(tk.getTenSPMuaNhieu());
						}
					}
				});
				monthYearChooser.addPropertyChangeListener(new PropertyChangeListener() {

//							@Override
					public void propertyChange(PropertyChangeEvent evt) {
						if ("month".equals(evt.getPropertyName())) {
							int thang = monthChooser.getMonth() + 1;
							int nam = monthYearChooser.getYear();
							tk = hoaDon.getThongKeByMonth(thang, nam);
							//
							lbTienDoanhThu.setText(Long.toString(tk.getDoanhThu()));
							lbSoHD.setText(Long.toString(tk.getSoHoaDon()));
							lbTongKhach.setText(Long.toString(tk.getTongKhach()));
							lbSanPhamMuaNhieu.setText(tk.getTenSPMuaNhieu());
						}
					}
				});
			} else if (o.equals(rdoTheoNam)) {
				int nam = yearChooser.getYear();
				tk = hoaDon.getThongKeByYear(nam);
				//
				lbTienDoanhThu.setText(Long.toString(tk.getDoanhThu()));
				lbSoHD.setText(Long.toString(tk.getSoHoaDon()));
				lbTongKhach.setText(Long.toString(tk.getTongKhach()));
				lbSanPhamMuaNhieu.setText(tk.getTenSPMuaNhieu());
				yearChooser.addPropertyChangeListener(new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						// TODO Auto-generated method stub
						if ("year".equals(evt.getPropertyName())) {
							int nam = yearChooser.getYear();
							tk = hoaDon.getThongKeByYear(nam);
							lbTienDoanhThu.setText(Long.toString(tk.getDoanhThu()));
							lbSoHD.setText(Long.toString(tk.getSoHoaDon()));
							lbTongKhach.setText(Long.toString(tk.getTongKhach()));
							lbSanPhamMuaNhieu.setText(tk.getTenSPMuaNhieu());

						}
					}
				});

			} else if (o.equals(rdoDenNay)) {
				tk = hoaDon.getThongKe();
				lbTienDoanhThu.setText(Long.toString(tk.getDoanhThu()));
				lbSoHD.setText(Long.toString(tk.getSoHoaDon()));
				lbTongKhach.setText(Long.toString(tk.getTongKhach()));
				lbSanPhamMuaNhieu.setText(tk.getTenSPMuaNhieu());
			}
		}
	}
}
