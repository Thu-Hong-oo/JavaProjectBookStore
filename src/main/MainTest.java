package main;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import form.BanHangForm;
import form.CapNhatKhachHang;
import form.CapNhatNVForm;

import form.CapNhatSanPhamForm;
//import component.DefaultForm;
import form.DatHangForm;
import form.DoanhThuForm;
import form.GioiThieuForm;
import form.HoaDonForm;
import form.HomeForm;

import form.LapHoaDonForm;
import form.NCCForm;
import form.NXBForm;
import form.NhaCungCapForm;
import form.NhanVienForm;

import form.TKDoanhThuForm;
import form.TKKhachHangForm;
import form.TKSachForm;
import form.TaoKhuyenMaiForm;
import form.ThongKeKhachHang;
import form.ThongKeSanPhamForm;
import form.TimKiemNhanVienForm;
import form.TimKiemSanPhamForm;
import form.TroGiupForm;
import form.VPP_QLNForm;
import form.XemDanhSachKM;
import form.XemHoaDonForm;
import menu.MenuEvent;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout.Alignment;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import java.awt.CardLayout;
import java.awt.Color;

public class MainTest extends JFrame {
    private menu.Menu menu1;
    private menu.Header header1;
    private javax.swing.JPanel body;

    public MainTest() {
        initDefaults(); // Đặt tùy chỉnh UI Defaults
        initComponents();
        setUndecorated(true);
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
					}
					else if (subIndex == 4)
						System.exit(0);
					break;
					
				case 1:
					if (subIndex == 1)
						showForm(new CapNhatNVForm());
					else if (subIndex == 2)
						showForm(new TimKiemNhanVienForm());
					else if (subIndex == 3)
						showForm(new BanHangForm());
					break;
				case 2:
					if (subIndex == 1)
						showForm(new CapNhatKhachHang());
					else if (subIndex == 2)
						showForm(new TKKhachHangForm());
					else if (subIndex == 3)
						showForm(new ThongKeKhachHang());
				
					break;
				case 3:
					if (subIndex == 1)
						showForm(new CapNhatSanPhamForm());
					else if (subIndex == 2)
						showForm(new TimKiemSanPhamForm());
					else if (subIndex == 3)
						showForm(new NhaCungCapForm());
					else if (subIndex == 4)
						showForm(new ThongKeSanPhamForm());
					break;
				case 4:
					if (subIndex == 1)
						showForm(new TaoKhuyenMaiForm());
					else if (subIndex == 2)
						showForm(new XemDanhSachKM());
					break;
				
				case 5:
					if (subIndex == 1)
						showForm(new XemHoaDonForm());
					else if (subIndex == 2)
						showForm(new DoanhThuForm());
				
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
            // Thêm mới thành phần vào body
            body.add(com);
            // Vẽ lại và cập nhật body
            body.repaint();
            body.revalidate();
        } 
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.WHITE);

        menu1 = new menu.Menu();
        menu1.setBackground(new Color(255, 218, 185));

        header1 = new menu.Header();

        body = new javax.swing.JPanel();
        body.setLayout(new java.awt.BorderLayout());

        getContentPane().add(header1, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(menu1, java.awt.BorderLayout.LINE_START);
        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        // Đặt lại kích thước của JFrame
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
    }

    private void initDefaults() {
        // Đặt các tùy chỉnh UI Defaults ở đây
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("TableHeader.background", new Color(105, 131, 150)); // Đặt màu nền header của bảng
        defaults.put("TableHeader.foreground", Color.WHITE); // Đặt màu chữ header của bảng
        defaults.put("TableHeader.font", new Font("Tahoma", Font.BOLD, 13));
        defaults.put("Table.background", Color.WHITE); // Đặt màu nền của bảng
        defaults.put("Viewport.background", Color.WHITE); // Đặt màu nền cho JViewport của JScrollPane
        defaults.put("Button.background", new Color(105, 131, 150));
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainTest frame = new MainTest();

                frame.setVisible(true);
            }
        });
    }
}
