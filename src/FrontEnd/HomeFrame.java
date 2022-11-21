import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
// import org.apache.commons.io.FileUtils;
// import org.apache.commons.io.FileUtils;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
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

        Border emptyBorder = BorderFactory.createEmptyBorder();
        JButton btnUploadLogo = new JButton();
        btnUploadLogo.setIcon(new ImageIcon("C:\\Users\\Malak\\Downloads\\upload.jpg"));
        btnUploadLogo.setBorder(emptyBorder);
        btnUploadLogo.setBackground(new Color(0, 24, 34, 255));
        btnUploadLogo.setBounds(25, 21, 120, 109);

        btnUploadLogo.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JFileChooser fileChooser = new JFileChooser("C:\\Users\\Malak\\Desktop\\AUB\\FALL 2022\\CMPS 242");
               fileChooser.setDialogTitle("Select an audio file to upload");
               int userSelection = fileChooser.showOpenDialog(frame);
               if(userSelection==JFileChooser.APPROVE_OPTION){
                File file =  fileChooser.getSelectedFile();
                if(file.getName().endsWith(".mp3")){
                    System.out.println(file.getName());
                }
               }
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
                ListenAudiosFrame.create();
            }
        });
		contentPane.add(btnListen);

        JButton btnAudios = new JButton();
        btnAudios.setBorder(emptyBorder);
		btnAudios.setIcon(new ImageIcon("C:\\Users\\Malak\\Downloads\\songs.jpg"));
		btnAudios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                DownloadAudiosFrame.create();
			}
		});
		btnAudios.setBounds(266, 166, 96, 75);
		contentPane.add(btnAudios);

    }
}
