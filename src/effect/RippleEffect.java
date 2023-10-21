package effect;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

/**
 * Lớp RippleEffect được sử dụng để tạo hiệu ứng sóng khi người dùng nhấn vào
 * một thành phần trên giao diện, chẳng hạn như một nút
 * 
 * @author Nguyen Thi Thu Hong
 *
 */
public class RippleEffect {

	private final Component component;// là thành phần trên giao diện (chẳng hạn một JButton)
	private Color rippleColor = new Color(63, 94, 119);// là màu sắc của hiệu ứng sóng.
	private List<Effect> effects;// là danh sách chứa các hiệu ứng sóng đã được tạo.

	public RippleEffect(Component component) {
		this.component = component;
		init();
	}

	private void init() {
		effects = new ArrayList<>();
		component.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					addEffect(e.getPoint());
				}
			}
		});
	}

	/**
	 * dùng để thêm hiệu ứng sóng mới vào danh sách tại vị trí được xác định bởi
	 * location
	 * 
	 * @param location
	 */
	public void addEffect(Point location) {
		effects.add(new Effect(component, location));
	}

	public void reder(Graphics g, Shape contain) {
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		for (int i = 0; i < effects.size(); i++) {
			Effect effect = effects.get(i);
			if (effect != null) {
				effect.render(g2, contain);
			}
		}
		g2.dispose();
	}

	public class Effect {

		private final Component component;
		private final Point location;
		private Animator animator;
		private float animate;

		public Effect(Component component, Point location) {
			this.component = component;
			this.location = location;
			init();
		}

		private void init() {
			// Trong Effect, animator được sử dụng để tạo hiệu ứng sóng với thời gian 500ms
			animator = new Animator(500, new TimingTargetAdapter() {
				@Override
				public void timingEvent(float fraction) {
					animate = fraction;
					component.repaint();
				}

				@Override
				public void end() {
					// Đừng xóa hiệu ứng khi kết thúc
				}
			});
			animator.setResolution(5);
			animator.setDeceleration(.5f);
			animator.setAcceleration(.5f);
			animator.start();
		}

		public void render(Graphics2D g2, Shape contain) {
			Area area = new Area(contain);
			area.intersect(new Area(getShape(getSize(contain.getBounds2D()))));
			g2.setColor(rippleColor);
			float alpha = 0.3f;
			if (animate >= 0.7f) {
				double t = animate - 0.7f;
				alpha = (float) (alpha - (alpha * (t / 0.3f)));
			}
			g2.setColor(rippleColor);
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
			g2.fill(area);
		}

		private Shape getShape(double size) {
			double s = size * animate;
			double x = location.getX();
			double y = location.getY();
			Shape shape = new Ellipse2D.Double(x - s, y - s, s * 2, s * 2);
			return shape;
		}

		private double getSize(Rectangle2D rec) {
			double size;
			if (rec.getWidth() > rec.getHeight()) {
				if (location.getX() < rec.getWidth() / 2) {
					size = rec.getWidth() - location.getX();
				} else {
					size = location.getX();
				}
			} else {
				if (location.getY() < rec.getHeight() / 2) {
					size = rec.getHeight() - location.getY();
				} else {
					size = location.getY();
				}
			}
			return size + (size * 0.1f);
		}

		public Object getAnimator() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	public void setRippleColor(Color rippleColor) {
		this.rippleColor = rippleColor;
	}

	public Color getRippleColor() {
		return rippleColor;
	}
}
