package menu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Menu extends JComponent   {

	private Color defaultBackgroundColor = new Color(105, 131, 150);
	private Color selectedBackgroundColor = new Color(224, 224, 224);

	public MenuEvent getEvent() {
		return event;
	}

	public void setEvent(MenuEvent event) {
		this.event = event;
	}

	private MenuEvent event;
	private MigLayout layout;
	private String[][] menuItems = new String[][] {

			{ "Hệ Thống", "Trang Chủ", "Giới Thiệu", "Đăng xuất", "Thoát" },
			{ "Nhân Viên", "Cập Nhật", "Tìm Kiếm", "Bán Hàng", "Đặt Hàng", "Thống Kê" },
			{ "Khách hàng", "Cập Nhật", "Tìm Kiếm" },
			{ "Sản Phẩm", "Cập Nhật", "Tìm Kiếm", "Nhà Cung Cấp", "Khuyến Mãi" },
			{ "Hóa Đơn", "Xem Hóa Đơn", "Tìm Kiếm" },

	};

	public Menu() {
		init();
		
	}

	private void init() {
		layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill");
		setLayout(layout);
		setOpaque(true);
	    setBackground(defaultBackgroundColor);
	  	// Init MenuItem
			for (int i = 0; i < menuItems.length; i++) {
				addMenu(menuItems[i][0], i);
			}
	}


	

	private Icon getIcon(int index) {
		URL url = getClass().getResource("/icon/" + index + ".png");
		if (url != null) {
			return new ImageIcon(url);
		} else {
			return null;
		}
	}

	private void addMenu(String menuName, int index) {
		int length = menuItems[index].length;
		MenuItem item = new MenuItem(menuName, index, length > 1);
		   // Tạo MouseAdapter cho MenuItem
  
		Icon icon = getIcon(index);
		if (icon != null) {
			item.setIcon(icon);
		}

		item.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (length > 1) {
					if (!item.isSelected()) {
						item.setSelected(true);
						addSubMenu(item, index, length, getComponentZOrder(item));
					} else {
						// Ẩn menu
						hideMenu(item, index);
						item.setSelected(false);
					}
				} else {
					if (event != null) {
						event.selected(index, 0);
					}
				}
			}
		});
	

		add(item);
		revalidate();
		repaint();
	}

	private void addSubMenu(MenuItem item, int index, int length, int indexZorder) {
		JPanel panel = new JPanel(new MigLayout("wrap 1, fillx, inset 0, gapy 0", "fill"));
		panel.setName(index + "");
		panel.setBackground(new Color(18, 99, 63));
		for (int i = 1; i < length; i++) {
			MenuItem subItem = new MenuItem(menuItems[index][i], i, false);

			// Tạo biểu tượng cho submenu
			Icon subItemIcon = getIcon(index, i);
			if (subItemIcon != null) {
				subItem.setIcon(subItemIcon);
			}

			subItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					if (event != null) {
						event.selected(index, subItem.getIndex());
					}
				}
			});
			subItem.initSubMenu(i, length);
			panel.add(subItem);
		}
		add(panel, "h 0!", indexZorder + 1);
		revalidate();
		repaint();
		MenuAnimation.showMenu(panel, item, layout, true);
	}

	private Icon getIcon(int menuIndex, int subMenuIndex) {
		URL url = getClass().getResource("/icon/" + menuIndex + "." + subMenuIndex + ".png");
		if (url != null) {
			return new ImageIcon(url);
		} else {
			return null;
		}
	}

	private void hideMenu(MenuItem item, int index) {
		for (Component com : getComponents()) {
			if (com instanceof JPanel && com.getName() != null && com.getName().equals(index + "")) {
				com.setName(null);
				MenuAnimation.showMenu(com, item, layout, false);
				break;
			}
		}
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs.create();
		g2.setColor(new Color(105, 131, 150));
		g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
		super.paintComponent(grphcs);
	}

	//public void showSubMenu(MenuItem menuItem) {
		// TODO Auto-generated method stub
	}




