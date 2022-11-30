import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;

public class EntranceFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntranceFrame window = new EntranceFrame();
					window.frame.setVisible(true);
				} catch (Exception error) {
					error.printStackTrace();
				}
			}
		});
	}

	private JTextField textFieldEmail;
	private JTextField passwordField;
	JFrame frame;
	//public static final ImageIcon logo = new ImageIcon("C:\\Users\\Malak\\Desktop\\AUB\\FALL 2022\\CMPS 242\\project\\srcCode\\MUZE\\src\\images\\muze.png");
	//public static final ImageIcon download = new ImageIcon("C:\\Users\\Malak\\Desktop\\AUB\\FALL 2022\\CMPS 242\\project\\srcCode\\MUZE\\src\\images\\download.jpg");
	//public static final ImageIcon listen = new ImageIcon("C:\\Users\\Malak\\Desktop\\AUB\\FALL 2022\\CMPS 242\\project\\srcCode\\MUZE\\src\\images\\listen.jpg");
	//public static final ImageIcon songs = new ImageIcon("C:\\Users\\Malak\\Desktop\\AUB\\FALL 2022\\CMPS 242\\project\\srcCode\\MUZE\\src\\images\\songs.jpg");
	//public static final ImageIcon upload = new ImageIcon("C:\\Users\\Malak\\Desktop\\AUB\\FALL 2022\\CMPS 242\\project\\srcCode\\MUZE\\src\\images\\upload.jpg");

	public static final ImageIcon logo = new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Cmps 242\\Project\\Muze.jpeg");
	public static final ImageIcon download = new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Cmps 242\\Project\\Download.jpeg");
	public static final ImageIcon listen = new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Cmps 242\\Project\\Download.jpeg\\Listen.jpeg");
	public static final ImageIcon songs = new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Cmps 242\\Project\\Songs.jpeg");
	public static final ImageIcon upload = new ImageIcon("C:\\Users\\Lenovo\\Desktop\\Cmps 242\\Project\\Upload.jpeg");




	public EntranceFrame() {

		frame = new JFrame("Welcome to MUZE!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 500);
		frame.setResizable(false);
		JPanel contentPane = new JPanel();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 24, 35, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(logo);
		lblLogo.setBounds(100, 20, 340, 453);
		contentPane.add(lblLogo);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setForeground(new Color(168, 207, 69, 255));
		lblEmail.setBounds(532, 111, 117, 14);
		contentPane.add(lblEmail);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(168, 207, 69, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(532, 185, 117, 14);
		contentPane.add(lblPassword);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(532, 136, 134, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		passwordField = new JTextField();
		passwordField.setBounds(532, 210, 134, 20);
		contentPane.add(passwordField);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBounds(560, 399, 89, 23);
		btnSignUp.setForeground(new Color(0, 24, 34, 255));
		btnSignUp.setBackground(new Color(168, 207, 69, 255));
		contentPane.add(btnSignUp);

		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SignUpFrame.create();	
			}
		});

		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setForeground(new Color(0, 24, 34, 255));
		btnSignIn.setBackground(new Color(168, 207, 69, 255));
		btnSignIn.setBounds(560, 264, 89, 23);
		btnSignIn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try {
					// Statement stmt = SignUpFrame.con.createStatement();
					// ResultSet res = stmt.executeQuery("SELECT * FROM user WHERE email = \"" + textFieldEmail.getText() + "\"" + " AND password = \"" + passwordField.getText() + "\"");
					// if(res.next()){
					// 	frame.dispose();
					// 	HomeFrame.create();
					// }
					// else{
					// 	System.out.println("Invalid email or password");
					// }
					HomeFrame.create();
				} catch (Exception e1) {
					throw new RuntimeException("SQL Exception:", e1);
				}
				
			}
		});
		contentPane.add(btnSignIn);

		JLabel lblSignUp = new JLabel("Don't have an account, create one!");
		lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSignUp.setForeground(new Color(168, 207, 69, 255));
		lblSignUp.setBounds(510, 379, 220, 14);
		contentPane.add(lblSignUp);

	}
}
