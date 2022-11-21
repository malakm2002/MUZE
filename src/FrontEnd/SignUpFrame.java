import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SignUpFrame {
    
    public static void create(){
        JFrame frame = new JFrame("Sign Up to MUZE!");
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 900, 500);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0,24,34,255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		   frame. setContentPane(contentPane);
		contentPane.setLayout(null);
        frame.setVisible(true);
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon("C:\\Users\\Malak\\Downloads\\muze.png"));
		lblLogo.setBounds(0, 0, 480, 463);
		contentPane.add(lblLogo);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFirstName.setForeground(new Color(168,207,69,255));
		lblFirstName.setBounds(500, 80, 95, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(new Color(168,207,69,255));
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLastName.setBounds(500, 120, 95, 14);
		contentPane.add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(168,207,69,255));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(500, 160, 95, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(168,207,69,255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(500, 200, 95, 14);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(new Color(168,207,69,255));
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConfirmPassword.setBounds(500, 240, 157, 14);
		contentPane.add(lblConfirmPassword);
		
		JTextField txtFldFirstName = new JTextField();
		txtFldFirstName.setBounds(660, 80, 137, 20);
		contentPane.add(txtFldFirstName);
		txtFldFirstName.setColumns(10);
		
		JTextField txtFldLastName = new JTextField();
		txtFldLastName.setColumns(10);
		txtFldLastName.setBounds(660, 120, 137, 20);
		contentPane.add(txtFldLastName);
		
		JTextField txtFldEmail = new JTextField();
		txtFldEmail.setColumns(10);
		txtFldEmail.setBounds(660, 160, 137, 20);
		contentPane.add(txtFldEmail);
		
		JTextField txtFldPassword = new JTextField();
		txtFldPassword.setColumns(10);
		txtFldPassword.setBounds(660, 200, 137, 20);
		contentPane.add(txtFldPassword);
		
		JTextField txtFldConfPassword = new JTextField();
		txtFldConfPassword.setColumns(10);
		txtFldConfPassword.setBounds(660, 240, 137, 20);
		contentPane.add(txtFldConfPassword);
		
		JButton btnCreateAccount = new JButton("Create");
		btnCreateAccount.setBackground(new Color(168,207,69,255));
		btnCreateAccount.setBounds(540, 302, 89, 23);
		contentPane.add(btnCreateAccount);
    }
}
