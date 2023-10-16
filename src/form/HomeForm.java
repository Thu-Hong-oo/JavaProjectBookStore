package form;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import raven.chart.geo.utils.GeoData;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public class HomeForm extends javax.swing.JPanel {
	int x = 0;
	int y = 50;

	public HomeForm() {
		setBackground(Color.WHITE);
		setSize(1100, 610);
		setLayout(null);

		JTextField textField = new JTextField();
		textField.setBounds(894, 12, 185, 26);
		add(textField);
		textField.setColumns(10);

		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTmKim.setBounds(802, 11, 81, 26);
		add(lblTmKim);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(HomeForm.class.getResource("/form/z4746471591925_6ed4cbb486417c9b703318b415db3fbf.jpg")));
		lblNewLabel.setBounds(97, 93, 786, 346);
		add(lblNewLabel);
//		Timer timer = new Timer(50, new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				x += 10;
//				if (x > getWidth()) {
//					x = -800;
//				}
//				repaint();
//			}
//		});
//		timer.start();
	

	}// </editor-fold>//GEN-END:initComponents

//	public void paint(Graphics g) {
//		super.paint(g);
//		Graphics2D gd = (Graphics2D) g;
//		gd.setFont(new Font("UTM Atlas", Font.BOLD, 35));
//		gd.setColor(new Color(95, 158, 160));
//		gd.drawString("CỬA HÀNG LINH KIỆN ĐIỆN TỬ TECHZONE", x, y);
//	}

}
