package scroll.win;

import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.List;

public class PolygonCorner {

	public GeneralPath getRoundedGeneralPathFromPoints(List<Point2D> l, float arcSize) {
		l.add(l.get(0));
		l.add(l.get(1));
		GeneralPath p = new GeneralPath();
		Point2D startPoint = calculatePoint(l.get(l.size() - 1), l.get(l.size() - 2), arcSize);
		p.moveTo(startPoint.getX(), startPoint.getY());
		for (int pointIndex = 1; pointIndex < l.size() - 1; pointIndex++) {
			Point2D p1 = l.get(pointIndex - 1);
			Point2D p2 = l.get(pointIndex);
			Point2D p3 = l.get(pointIndex + 1);
			Point2D mPoint = calculatePoint(p1, p2, arcSize);
			p.lineTo(mPoint.getX(), mPoint.getY());
			mPoint = calculatePoint(p3, p2, arcSize);
			p.curveTo(p2.getX(), p2.getY(), p2.getX(), p2.getY(), mPoint.getX(), mPoint.getY());
		}
		return p;
		/*
		 * getRoundedGeneralPathFromPoints: Phương thức này nhận vào một danh sách
		 * List<Point2D> chứa các điểm của đa giác và một giá trị arcSize (kích thước
		 * cung) để làm tròn các góc. Phương thức này trả về một đối tượng GeneralPath
		 * biểu diễn đa giác đã được làm tròn các góc.
		 */
	}

	private Point2D calculatePoint(Point2D p1, Point2D p2, float arcSize) {
		double d1 = Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2f) + Math.pow(p1.getY() - p2.getY(), 2f));
		double per = arcSize / d1;
		double d_x = (p1.getX() - p2.getX()) * per;
		double d_y = (p1.getY() - p2.getY()) * per;
		double xx = p2.getX() + d_x;
		double yy = p2.getY() + d_y;
		return new Point.Double(xx, yy);
		/*
		 * calculatePoint: Phương thức này tính toán một điểm trên đoạn thẳng giữa hai
		 * điểm Point2D p1 và p2 sao cho khoảng cách giữa điểm mới và p2 được xác định
		 * bởi arcSize. Nó sử dụng tính toán vector để di chuyển arcSize từ p2 theo
		 * đường thẳng nối giữa p1 và p2 và trả về điểm mới có tọa độ (xx, yy).
		 */
	}
}
