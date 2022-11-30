import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
// import org.apache.commons.io.FileUtils;
// import org.apache.commons.io.FileUtils;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.sql.*;


public class HomeFrame {
    public static File file = null;
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
        lblLogo.setIcon(EntranceFrame.logo);
        contentPane.add(lblLogo);

        Border emptyBorder = BorderFactory.createEmptyBorder();
        JButton btnUploadLogo = new JButton();
        btnUploadLogo.setIcon(EntranceFrame.upload);
        btnUploadLogo.setBorder(emptyBorder);
        btnUploadLogo.setBackground(new Color(0, 24, 34, 255));
        btnUploadLogo.setBounds(25, 21, 120, 109);

        btnUploadLogo.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JFileChooser fileChooser = new JFileChooser();
               fileChooser.setDialogTitle("Select an audio file to upload");
               int userSelection = fileChooser.showOpenDialog(frame);
               if(userSelection==JFileChooser.APPROVE_OPTION){
                file =  fileChooser.getSelectedFile();
                if(file.getName().endsWith(".mp3")){
                    try {
                        client.sendFiletoServer(file, "uploader");
                        SuccessFrame.create("Uploadded sucessfully to the server.");
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
               if(userSelection==JFileChooser.APPROVE_OPTION) {
                    file =  fileChooser.getSelectedFile();
                    if(file.getName().endsWith(".mp3")){
				    }
                }
            }
        }}});
        contentPane.add(btnUploadLogo);

        JButton btnDownloadLogo = new JButton();
        btnDownloadLogo.setBorder(emptyBorder);
        btnDownloadLogo.setBackground(new Color(0, 24, 34, 255));
        btnDownloadLogo.setIcon(EntranceFrame.download);
        btnDownloadLogo.setBounds(35, 160, 102, 101);
        btnDownloadLogo.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DownloadAudiosFrame.create();
            }
        });
        contentPane.add(btnDownloadLogo);

        JButton btnListen = new JButton();
        btnListen.setBorder(emptyBorder);
		btnListen.setBounds(251, 37, 108, 93);
		btnListen.setIcon(EntranceFrame.listen);
        btnListen.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ListenAudiosFrame.create();
            }
        });
		contentPane.add(btnListen);

        JButton btnAudios = new JButton();
        btnAudios.setBorder(emptyBorder);
		btnAudios.setIcon(EntranceFrame.songs);
		btnAudios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                DownloadAudiosFrame.create();
			}
		});
		btnAudios.setBounds(266, 166, 96, 75);
		contentPane.add(btnAudios);

    }
}
