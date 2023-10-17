package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Header extends javax.swing.JPanel {
	private JLabel lblName;// The label displays the name of the employee logged into the system
    public Header() {
        initComponents();
    }

    private void initComponents() {
    	setSize(1350, 100);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setBackground((new Color(105,131,150)));


        add(panel, BorderLayout.NORTH);
        
        lblName = new JLabel("Nguyễn Văn A");
        lblName.setIcon(new ImageIcon(Header.class.getResource("/icon/male-user-26.png")));
        lblName.setFont(new Font("Tahoma", Font.BOLD, 13));
        
        JLabel lblLogo = new JLabel("");
        lblLogo.setHorizontalAlignment(SwingConstants.TRAILING);
        lblLogo.setIcon(new ImageIcon(Header.class.getResource("/icon/books-removebg-preview.png")));
        
        JLabel lblExit = new JLabel("X");
        lblExit.setFont(new Font("Tahoma", Font.BOLD, 18));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
        			.addGap(937)
        			.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblExit, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblExit, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
        				.addComponent(lblLogo, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(37, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);

        //MouseListener exit
        lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
    }
}
