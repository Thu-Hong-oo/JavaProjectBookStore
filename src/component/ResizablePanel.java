package component;

import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;

import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

public class ResizablePanel extends JPanel {
    private List<Component> resizableComponents = new ArrayList<>();
    private int initialWidth;
    private int initialHeight;

    public ResizablePanel() {
        setLayout(null); // Layout null cho panel để có thể tự quản lý vị trí và kích thước của các thành phần con
        setOpaque(false); // Đặt thành phần này là trong suốt để không che phủ các thành phần con
    }

    public void addResizableComponent(Component component) {
        resizableComponents.add(component);
    }

    public void setInitialSize(int width, int height) {
        initialWidth = width;
        initialHeight = height;
    }

    public int getInitialWidth() {
        return initialWidth;
    }

    public int getInitialHeight() {
        return initialHeight;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(initialWidth, initialHeight);
    }

    public void updateComponentsSize(double scaleX, double scaleY) {
        for (Component component : resizableComponents) {
            Dimension newSize = new Dimension((int) (component.getWidth() * scaleX), (int) (component.getHeight() * scaleY));
            component.setPreferredSize(newSize);
            component.setBounds((int) (component.getX() * scaleX), (int) (component.getY() * scaleY), newSize.width, newSize.height);
        }
    }
}


