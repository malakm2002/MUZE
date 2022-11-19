import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

public class HomeFrame {
    public static void create() {
        JFrame frame = new JFrame("MUZE - Home");
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 800, 500);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 24, 34, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogo = new JLabel();
        lblLogo.setBounds(412, 24, 364, 400);
        lblLogo.setIcon(new ImageIcon("C:\\Users\\Malak\\Downloads\\muze.png"));
        contentPane.add(lblLogo);

        // JLabel lblUploadLogo = new JLabel();
        // lblUploadLogo.setBounds(33, 24, 154, 135);
        // lblUploadLogo.setIcon(new
        // ImageIcon("C:\\Users\\Malak\\Downloads\\upload.jpg"));
        // contentPane.add(lblUploadLogo);

        // JLabel lblDownloadLogo = new JLabel();
        // lblDownloadLogo.setBounds(204, 0, 190, 200);
        // lblDownloadLogo.setIcon(new
        // ImageIcon("C:\\Users\\Malak\\Downloads\\download.jpg"));
        // contentPane.add(lblDownloadLogo);

        Border emptyBorder = BorderFactory.createEmptyBorder();
        JButton btnUploadLogo = new JButton();
        btnUploadLogo.setIcon(new ImageIcon("C:\\Users\\Malak\\Downloads\\upload.jpg"));
        btnUploadLogo.setBorder(emptyBorder);
        btnUploadLogo.setBackground(new Color(0, 24, 34, 255));
        btnUploadLogo.setBounds(25, 21, 120, 109);
        btnUploadLogo.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpFrame.create();
            }
        });
        contentPane.add(btnUploadLogo);

        JButton btnDownloadLogo = new JButton();
        btnDownloadLogo.setBorder(emptyBorder);
        btnDownloadLogo.setBackground(new Color(0, 24, 34, 255));
        btnDownloadLogo.setIcon(new ImageIcon("C:\\Users\\Malak\\Downloads\\download.jpg"));
        btnDownloadLogo.setBounds(35, 160, 102, 101);
        btnDownloadLogo.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpFrame.create();
            }
        });
        contentPane.add(btnDownloadLogo);

        JButton btnListen = new JButton();
        btnListen.setBorder(emptyBorder);
		btnListen.setBounds(251, 37, 108, 93);
		btnListen.setIcon(new ImageIcon("C:\\Users\\Malak\\Downloads\\listen.jpg"));
        btnListen.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpFrame.create();
            }
        });
		contentPane.add(btnListen);

        JButton btnAudios = new JButton();
        btnAudios.setBorder(emptyBorder);
		btnAudios.setIcon(new ImageIcon("C:\\Users\\Malak\\Downloads\\songs.jpg"));
		btnAudios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                AudiosFrame.create();
			}
		});
		btnAudios.setBounds(266, 166, 96, 75);
		contentPane.add(btnAudios);

    }
}
