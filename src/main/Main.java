package main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.Border;

import menu.Header;
import menu.Menu;
import menu.MenuEvent;
import view.BanHangForm;
import view.BanHangForm;
import view.CapNhatKhachHang;
import view.CapNhatNVForm;
import view.CapNhatSanPhamForm;
import view.DatHangForm;
import view.GioiThieuForm;
import view.HomeForm;
import view.KhuyenMaiForm;
import view.NhaCungCapForm;
import view.ThongKeForm;
import view.TimKiemHoaDonForm;
import view.TimKiemKhachHangForm;
import view.TimKiemNhanVienForm;
import view.TimKiemSanPhamForm;
import view.XemHoaDonForm;

public class Main extends javax.swing.JFrame {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel body;
	private menu.Header header1;
	private javax.swing.JPanel jPanel1;
	private menu.Menu menu1;
	private scroll.win.ScrollPaneWin11 scrollPaneWin111;
	// End of variables declaration//GEN-END:variables

	public Main() {
		initDefaults(); // Đặt tùy chỉnh UI Defaults
		initComponents();
		showForm(new HomeForm());
		menu1.setEvent(new MenuEvent() {
			@Override
			public void selected(int index, int subIndex) {
				switch (index) {

				case 0:
					if (subIndex == 1)
						showForm(new HomeForm());
					else if (subIndex == 2)
						showForm(new GioiThieuForm());
					else if (subIndex == 3) {
						dispose();
						LoginForm login = new LoginForm();
						login.setVisible(true);
					} else if (subIndex == 4)
						System.exit(0);
					break;

				case 1:
					if (subIndex == 1)
						showForm(new CapNhatNVForm());
					else if (subIndex == 2)
						showForm(new TimKiemNhanVienForm());
					else if (subIndex == 3)
						showForm(new BanHangForm());
					else if (subIndex == 4)
						showForm(new DatHangForm());
					else if (subIndex == 5)
						showForm(new ThongKeForm());
					break;
				case 2:
					if (subIndex == 1)
						showForm(new CapNhatKhachHang());
					else if (subIndex == 2)
						showForm(new TimKiemKhachHangForm());

					break;
				case 3:
					if (subIndex == 1)
						showForm(new CapNhatSanPhamForm());
					else if (subIndex == 2)
						showForm(new TimKiemSanPhamForm());
					else if (subIndex == 3)
						showForm(new NhaCungCapForm());
					else if (subIndex == 4)
						showForm(new KhuyenMaiForm());
					break;

				case 4:
					if (subIndex == 1)
						showForm(new XemHoaDonForm());
					else if (subIndex == 2)
						showForm(new TimKiemHoaDonForm());

					break;

				default:

				}
			}
		});
	}

	private void showForm(Component com) {
		if (com != null) {
			// Xóa tất cả các thành phần hiện tại trong body
			body.removeAll();
			removeButtonFocusBorder(com);
			// Thêm mới thành phần vào body
			body.add(com);
			// Vẽ lại và cập nhật body
			body.repaint();
			body.revalidate();
		}
	}

	private void removeButtonFocusBorder(Component component) {
		if (component instanceof javax.swing.JButton) {
			javax.swing.JButton button = (javax.swing.JButton) component;
			button.setFocusPainted(false);
		}

		if (component instanceof java.awt.Container) {
			java.awt.Container container = (java.awt.Container) component;
			for (Component child : container.getComponents()) {
				removeButtonFocusBorder(child);
			}
		}
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		scrollPaneWin111 = new scroll.win.ScrollPaneWin11();
		menu1 = new Menu();
		menu1.setBackground(new Color(255, 218, 185));
		header1 = new Header();
		body = new javax.swing.JPanel();

		jPanel1.setBackground(Color.WHITE);
		jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(163, 163, 163)));

		scrollPaneWin111.setBorder(null);
		scrollPaneWin111.setViewportView(menu1);

		body.setBackground(Color.WHITE);
		body.setLayout(new java.awt.BorderLayout());

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addComponent(scrollPaneWin111, javax.swing.GroupLayout.PREFERRED_SIZE, 225,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addContainerGap())
				.addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
								.addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(scrollPaneWin111, javax.swing.GroupLayout.DEFAULT_SIZE, 565,
												Short.MAX_VALUE)
										.addGroup(jPanel1Layout.createSequentialGroup().addGap(6, 6, 6)
												.addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addContainerGap()))));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE));
		getContentPane().setLayout(layout);

	}

	private void initDefaults() {

		try {
			// here you can put the selected theme class name in JTattoo
			// UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
			for (javax.swing.UIManager.LookAndFeelInfo infor : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows Classic".equals(infor.getName())) {
					javax.swing.UIManager.setLookAndFeel(infor.getClassName());
					break;
				}
			}

		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// Đặt các tùy chỉnh UI Defaults ở đây
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		// set background
		defaults.put("TableHeader.background", new Color(57, 73, 98)); // Đặt màu nền header của bảng
		defaults.put("Table.background", Color.WHITE); // Đặt màu nền của bảng
		defaults.put("Viewport.background", Color.WHITE); // Đặt màu nền cho JViewport của JScrollPane
		defaults.put("Button.background", new Color(57, 73, 98));
		// set font all component
		defaults.put("Button.font", new Font("Tahoma", Font.BOLD, 13));
		defaults.put("Label.font", new Font("Tahoma", Font.BOLD, 13));
		defaults.put("TableHeader.font", new Font("Tahoma", Font.BOLD, 12));
		// set color content
		defaults.put("TableHeader.foreground", Color.WHITE); // Đặt màu chữ header của bảng
		defaults.put("Button.foreground", Color.WHITE);
		defaults.put("TabbedPane.font", new Font("Tahoma", Font.BOLD, 15));
		defaults.put("TabbedPane.foreground", Color.black);
		defaults.put("TabbedPane.FocusPainted", false);
		defaults.put("Button.select", new Color(54, 40, 69));

	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main frame = new Main();
				frame.setUndecorated(true);
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
