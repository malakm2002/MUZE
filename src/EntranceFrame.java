import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;


public class EntranceFrame {
	public static void main(String[] args){
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
	private JPanel contentPane;
	private JTextField textFieldUserName;
	private JPasswordField passwordField;
	JFrame frame;

	public EntranceFrame(){

		 frame = new JFrame("Welcome to MUZE!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   frame.setBounds(100, 100, 800, 500);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0,24,34,255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		   frame. setContentPane(contentPane);
		contentPane.setLayout(null);
	
		JLabel lblLogo = new JLabel();
			lblLogo.setIcon(new ImageIcon("C:\\Users\\Malak\\Downloads\\muze.png"));
			lblLogo.setBounds(10, 0, 480, 463);
			contentPane.add(lblLogo);
	
		JLabel lblUserName = new JLabel("UserName");
			lblUserName.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblUserName.setForeground(new Color(168,207,69,255));
			lblUserName.setBounds(532, 111, 117, 14);
			contentPane.add(lblUserName);
	
		JLabel lblPassword = new JLabel("Password");
			lblPassword.setForeground(new Color(168,207,69,255));
			lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblPassword.setBounds(532, 185, 117, 14);
			contentPane.add(lblPassword);
	
		textFieldUserName = new JTextField();
			textFieldUserName.setBounds(532, 136, 134, 20);
			contentPane.add(textFieldUserName);
			textFieldUserName.setColumns(10);
	
		passwordField = new JPasswordField();
			passwordField.setBounds(532, 210, 134, 20);
			contentPane.add(passwordField);
	
		JButton btnSignUp = new JButton("Sign Up");
			btnSignUp.setBounds(560, 399, 89, 23);
			btnSignUp.setForeground(new Color(0,24,34,255));
			btnSignUp.setBackground(new Color(168,207,69,255));
			contentPane.add(btnSignUp);
	
		JButton btnSignIn = new JButton("Sign In");
			btnSignIn.setForeground(new Color(0,24,34,255));
			btnSignIn.setBackground(new Color(168,207,69,255));
			btnSignIn.setBounds(560, 264, 89, 23);
			contentPane.add(btnSignIn);
	
		JLabel lblSignUp = new JLabel("Don't have an account, create one!");
			lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblSignUp.setForeground(new Color(168,207,69,255));
			lblSignUp.setBounds(510, 379, 220, 14);
			contentPane.add(lblSignUp);
	}
}
