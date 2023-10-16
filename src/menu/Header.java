package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class Header extends javax.swing.JPanel {
    public Header() {
        initComponents();
    }

    private void initComponents() {
    	setSize(1350, 100);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setBackground((new Color(105,131,150)));
        panel.setLayout(null); 
        panel.setPreferredSize(new java.awt.Dimension(1400, 80));

        JLabel lbExit = new JLabel("X");
        lbExit.setFont(new Font("Tahoma", Font.BOLD, 18));
        lbExit.setBounds(1316, 0, 32, 24);
        panel.add(lbExit);
        lbExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});


        add(panel, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("Nguyễn Văn A");
        lblNewLabel.setIcon(new ImageIcon(Header.class.getResource("/icon/male-user-26.png")));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(1173, 2, 143, 24);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(Header.class.getResource("/icon/books-removebg-preview.png")));
        lblNewLabel_1.setBounds(-41, 0, 258, 72);
        panel.add(lblNewLabel_1);

    }
}
