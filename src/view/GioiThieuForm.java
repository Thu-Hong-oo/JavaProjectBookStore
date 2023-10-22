package view;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;

public class GioiThieuForm extends JPanel {

//    private ResizablePanel resizablePanel = new ResizablePanel();

    /**
     * Create the panel.
     */
    public GioiThieuForm() {
    	GroupLayout groupLayout = new GroupLayout(this);
    	groupLayout.setHorizontalGroup(
    		groupLayout.createParallelGroup(Alignment.LEADING)
    			.addGap(0, 450, Short.MAX_VALUE)
    	);
    	groupLayout.setVerticalGroup(
    		groupLayout.createParallelGroup(Alignment.LEADING)
    			.addGap(0, 300, Short.MAX_VALUE)
    	);
    	setLayout(groupLayout);

  }
}
