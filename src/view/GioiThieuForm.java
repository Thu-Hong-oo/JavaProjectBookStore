package view;

import javax.swing.JPanel;

import component.ResizablePanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GioiThieuForm extends JPanel {

    private ResizablePanel resizablePanel = new ResizablePanel();

    /**
     * Create the panel.
     */
    public GioiThieuForm() {
        setLayout(null);

        // Khởi tạo và cấu hình resizablePanel
        resizablePanel.setLayout(null);
        resizablePanel.setBackground(Color.WHITE);
        resizablePanel.setBounds(0, 0, 600, 600);
        add(resizablePanel);

        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        panel.setBounds(450, 0, 150, 600);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.CYAN);
        panel_1.setBounds(0, 0, 450, 600);

        resizablePanel.add(panel);
        resizablePanel.add(panel_1);

        // Thêm lắng nghe sự kiện thay đổi kích thước của GioiThieuForm
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Kích thước mới của GioiThieuForm
                int newWidth = getWidth();
                int newHeight = getHeight();

                // Tính tỷ lệ mở rộng theo chiều ngang và dọc
                double scaleX = (double)newWidth / resizablePanel.getInitialWidth();
                double scaleY = (double)newHeight / resizablePanel.getInitialHeight();

                // Cập nhật kích thước của resizablePanel và các thành phần con
                resizablePanel.setPreferredSize(new Dimension(newWidth, newHeight));
                resizeComponents(resizablePanel, scaleX, scaleY);
            }
        });
    }

    private void resizeComponents(JPanel parent, double scaleX, double scaleY) {
        for (Component component : parent.getComponents()) {
            if (component instanceof JPanel) {
                // Cập nhật kích thước và vị trí của các thành phần con
                JPanel childPanel = (JPanel) component;
                Dimension newSize = new Dimension((int)(childPanel.getWidth() * scaleX), (int)(childPanel.getHeight() * scaleY));
                childPanel.setPreferredSize(newSize);
                childPanel.setBounds((int)(childPanel.getX() * scaleX), (int)(childPanel.getY() * scaleY), newSize.width, newSize.height);
                resizeComponents(childPanel, scaleX, scaleY);
            }
        }
    }
}
