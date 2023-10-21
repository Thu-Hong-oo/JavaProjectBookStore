package menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import effect.RippleEffect;

/**
 * @author Nguyen Thi Thu Hong 
 * lớp được kế thừa từ JButton, và nó được sử dụng
 *         để tạo các mục trong menu của ứng dụng
 */
public class MenuItem extends JButton implements ActionListener {
	 private Color defaultBackgroundColor = new Color(105, 131, 150);
	    private Color selectedBackgroundColor = new Color(63,94,119);
	    private static MenuItem selectedMenuItem;

	public float getAnimate() {
		return animate;
	}

	public void setAnimate(float animate) {
		this.animate = animate;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isSubMenuAble() {
		return subMenuAble;
	}

	public void setSubMenuAble(boolean subMenuAble) {
		this.subMenuAble = subMenuAble;
	}

	public int getSubMenuIndex() {
		return subMenuIndex;
	}

	public void setSubMenuIndex(int subMenuIndex) {
		this.subMenuIndex = subMenuIndex;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	private RippleEffect rippleEffect;// : Một đối tượng của lớp RippleEffect, được sử dụng để tạo hiệu ứng sóng khi
										// nút được nhấn.
	private BufferedImage shadow;// Một hình ảnh dùng để tạo bóng cho mục menu (menu item).
	private int shadowSize = 10;// Kích thước của bóng.
	private int index;// Chỉ mục của mục menu trong danh sách menu. Được sử dụng để xác định vị trí
						// của mục trong danh sách menu.
	private boolean subMenuAble;// Một cờ biểu thị liệu mục menu có submenu hay không.
	private float animate;// Một giá trị dùng để kiểm soát hiệu ứng hoạt hình khi mở submenu.
	// Submenu
	private int subMenuIndex;// Chỉ mục của mục con trong submenu (nếu có).
	private int length;// Độ dài của submenu (số lượng mục con) của mục menu hiện tại.

	private MenuEvent menuEvent;
	public MenuItem(String name, int index, boolean subMenuAble) {

		super(name);
		this.index = index;
		this.subMenuAble = subMenuAble;

		setFont(new Font("Roboto", Font.BOLD, 18));
		setContentAreaFilled(false);
		// set color name menuitem
		setForeground(Color.WHITE);
		setHorizontalAlignment(SwingConstants.LEFT);
		setBorder(new EmptyBorder(9, 10, 9, 10));
		setIconTextGap(10);
		setBorderPainted(false);
		rippleEffect = new RippleEffect(this);
		rippleEffect.setRippleColor(new Color(220, 220, 220));
		setBackground(new Color(105, 131, 150));
		setForeground(Color.WHITE);
		setFocusPainted(false);// bỏ đường vièn button
		// Thêm MouseListener để xử lý sự kiện chuột
		addMouseListener(new MouseAdapter() {
          
            @Override
            public void mouseClicked(MouseEvent e) {
                toggleSelection();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (selectedMenuItem != MenuItem.this) {
                    setBackground(selectedBackgroundColor);
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (selectedMenuItem != MenuItem.this){
                    setBackground(defaultBackgroundColor);
                }
            }
            
            
        });
    }

	   private void toggleSelection() {
	        if (selectedMenuItem != null) {
	            selectedMenuItem.deselect();
	        }
	        select();
	    }

	    private void select() {
	        selectedMenuItem = this;
	        setBackground(selectedBackgroundColor);
	        repaint();
	    }

	    private void deselect() {
	        selectedMenuItem = null;
	        setBackground(defaultBackgroundColor);
	        repaint();
	    }

	

	/**
	 * @param subMenuIndex
	 * @param length
	 */
	public void initSubMenu(int subMenuIndex, int length) {
		this.subMenuIndex = subMenuIndex;
		this.length = length;
		setBorder(new EmptyBorder(9, 33, 9, 10));
		setBorderPainted(false);
		// background item hover
		setBackground(new Color(105, 131, 150));
		setOpaque(true);

	}

	/**
	 * Đây là phương thức dùng để vẽ nội dung của mục menu lên màn hình. Mọi nội
	 * dung trên mục menu, bao gồm các dòng chữ, biểu tượng, và các hiệu ứng đều
	 * được vẽ trong phương thức này.
	 */
	@Override
	protected void paintComponent(Graphics grphcs) {
	    super.paintComponent(grphcs);
		Graphics2D g2 = (Graphics2D) grphcs.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Đoạn mã này đặt các thuộc tính vẽ, ví dụ, "antialiasing" để đảm bảo rằng vẽ
		// được thực hiện mượt mà và chất lượng.
		if (length != 0) {
			g2.setColor(Color.white);
			if (subMenuIndex == 1) {
				g2.drawImage(shadow, -shadowSize, -20, null);
			} else if (subMenuIndex == length - 1) {
				g2.drawImage(shadow, -shadowSize, getHeight() - 6, null);
			}
		} else if (subMenuAble) {
			g2.setColor(getForeground());
			int arrowWidth = 8;
			int arrowHeight = 4;
			Path2D p = new Path2D.Double();
			p.moveTo(0, arrowHeight * animate);
			p.lineTo(arrowWidth / 2, (1f - animate) * arrowHeight);
			p.lineTo(arrowWidth, arrowHeight * animate);
			g2.translate(getWidth() - arrowWidth - 15, (getHeight() - arrowHeight) / 2);
			g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
			g2.draw(p);
		}
		g2.dispose();// Đoạn mã này giải phóng tài nguyên đồ họa sau khi vẽ hoàn thành.
		rippleEffect.reder(grphcs, new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
	}

	@Override
	public void setBounds(int i, int i1, int i2, int i3) {
		super.setBounds(i, i1, i2, i3);

	}

	   @Override
	    public void actionPerformed(ActionEvent e) {
	        if (selectedMenuItem != this) {
	            toggleSelection();
	        }
	    }

    public void setMenuEvent(MenuEvent menuEvent) {
        this.menuEvent = menuEvent;
    }

    

}
    

 