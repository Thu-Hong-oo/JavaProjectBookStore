package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

//import connectDB.ConnectDB;
//import dao.TaiKhoan_DAO;
//import entity.TaiKhoan;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import connectDB.ConnectDB;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.TitledBorder;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenDangNhap;
	private JPasswordField txtMatKhau;
	private JButton btLogin;
//	private TaiKhoan_DAO taiKhoan;
	private static String tenNV;
	private static LoginForm instance = new LoginForm();

	public static LoginForm getInstance() {
		return instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			// Set look and feel
			String str = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
			UIManager.setLookAndFeel(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
//					 window.setUndecorated(true);
					window.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		setSize(1000,600);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setBackground(new Color(137,174,178));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(255, 255, 255, 110));
		panelLogin.setBounds(535, 111, 397, 386);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);

		JLabel lbExit = new JLabel("X");
		lbExit.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbExit.setBounds(960, 0, 32, 24);
		getContentPane().add(lbExit);
		lbExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

//		try {
//			JLabel lbLogo = new JLabel("");
//			lbLogo.setIcon(new ImageIcon(
//					LoginForm.class.getResource("/Images/b43d1d6971e34c11ae869c661baeb7b8-removebg-preview.png")));
//			lbLogo.setBounds(83, 19, 208, 80);
//			panelLogin.add(lbLogo);
//		} catch (Exception e) {
//			e.getMessage();
//		}

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginForm.class.getResource("/icon/male-user-26.png")));
		lblNewLabel_1.setBounds(40, 118, 26, 50);
		panelLogin.add(lblNewLabel_1);

		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setForeground(Color.BLACK);
		txtTenDangNhap.setText("Tên đăng nhập");
		txtTenDangNhap.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtTenDangNhap.getText().equals("Tên đăng nhập"))
					txtTenDangNhap.setText("");
				else
					txtTenDangNhap.selectAll();
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTenDangNhap.getText().equals(""))
					txtTenDangNhap.setText("Tên đăng nhập");
			}
		});

		txtTenDangNhap.setColumns(10);
		txtTenDangNhap.setBounds(100, 129, 226, 30);
		panelLogin.add(txtTenDangNhap);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LoginForm.class.getResource("/icon/icons8-lock-26.png")));
		lblNewLabel_2.setBounds(40, 179, 26, 47);
		panelLogin.add(lblNewLabel_2);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setForeground(Color.BLACK);
		txtMatKhau.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtMatKhau.getText().equals("Mật khẩu")) {
					txtMatKhau.setEchoChar('•');
					txtMatKhau.setText("");
				} else {
					txtMatKhau.selectAll();
				}

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtMatKhau.getText().equals("")) {
					txtMatKhau.setText("Mật khẩu");
					txtMatKhau.setEchoChar((char) 0);
				}

			}
		});
		txtMatKhau.setEchoChar((char) 0);
		txtMatKhau.setText("Mật khẩu");
		txtMatKhau.setBounds(100, 187, 226, 30);
		panelLogin.add(txtMatKhau);

		JSeparator separator = new JSeparator();
		separator.setBounds(100, 170, 236, 2);
		panelLogin.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(100, 227, 236, 2);
		panelLogin.add(separator_1);

		btLogin = new JButton("LOG IN");
		btLogin.setBorder(null);
		btLogin.setForeground(Color.black);
		btLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btLogin.setBackground(new Color(45,95,115));
		btLogin.setBounds(157, 262, 112, 30);
		panelLogin.add(btLogin);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255, 0));
		panel.setBounds(951, 6, 43, 41);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

//		lblNewLabel_4.setIcon(new ImageIcon(LoginForm.class.getResource("/Images/icons8-close-window-30.png")));
//		lblNewLabel_4.setBounds(0, 6, 30, 30);
//		panel.add(lblNewLabel_4);

		JLabel lblNewLabel = new JLabel("BOOK STORE");
		lblNewLabel.setFont(new Font("UVF Kewl Script", Font.BOLD, 25));
		lblNewLabel.setBounds(6, 7, 320, 63);
		contentPane.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(6, 67, 201, 3);
		contentPane.add(panel_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(LoginForm.class.getResource("/icon/Thesis-pana.png")));
		lblNewLabel_3.setBounds(77, 162, 335, 276);
		contentPane.add(lblNewLabel_3);
//
//		JLabel lblNewLabel_3 = new JLabel("");
//		lblNewLabel_3.setBackground(Color.PINK);
//		lblNewLabel_3.setIcon(new ImageIcon(LoginForm.class.getResource("/Images/pexels-pok-rie-1432669.jpg")));
//		lblNewLabel_3.setBounds(6, 6, 1027, 600);
//		contentPane.add(lblNewLabel_3);

		setLocationRelativeTo(null);
		setUndecorated(true);
//		btLogin.addMouseListener(this);
	}
}
