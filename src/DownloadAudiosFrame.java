

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.sql.*;

;

public class DownloadAudiosFrame {
    public static final File audios = new File("C:\\Users\\Malak\\Desktop\\AUB\\FALL 2022\\CMPS 242\\project\\srcCode\\MUZE\\src\\audios");
    public static final File  downloads = new File("C:\\Users\\Malak\\Desktop\\AUB\\FALL 2022\\CMPS 242\\project\\srcCode\\MUZE\\src\\downloads");
   

    public static void create() {
        JFrame frame = new JFrame("Songs");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 800, 500);
        frame.setResizable(false);
        JPanel contentPane = new JPanel();
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0, 24, 35, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);
        frame.setVisible(true);

        JLabel lblFileName = new JLabel("File Name");
        lblFileName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        lblFileName.setForeground(new Color(168, 207, 69, 255));
        lblFileName.setBounds(10, 20, 250, 20);
        contentPane.add(lblFileName);

        JLabel lblFileUploader = new JLabel("File Uploader");
        lblFileUploader.setForeground(new Color(168, 207, 69, 255));
        lblFileUploader.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        lblFileUploader.setBounds(270, 20, 250, 20);
        contentPane.add(lblFileUploader);

       File[] files = audios.listFiles();
            int height = 30;
            for (File file : files) {
                String fileName = file.getName();
                if (fileName.endsWith(".mp3")) {
                    String fileNameNoExt = getFileNameWithoutExtension(fileName);
                    String[] audioFile = fileNameNoExt.split("-");

                    JLabel lblFileName1 = new JLabel(audioFile[1]);
                    lblFileName1.setFont(new Font("Tahoma", Font.PLAIN, 16));
                    lblFileName1.setForeground(new Color(168, 207, 69, 255));
                    lblFileName1.setBounds(10, 20 + height, 250, 20);
                    contentPane.add(lblFileName1);

                    JLabel lblFileUploader1 = new JLabel(audioFile[0]);
                    lblFileUploader1.setForeground(new Color(168, 207, 69, 255));
                    lblFileUploader1.setFont(new Font("Tahoma", Font.PLAIN, 16));
                    lblFileUploader1.setBounds(270, 20 + height, 250, 20);
                    contentPane.add(lblFileUploader1);

                    JButton btnDownload1 = new JButton("Download");
                    btnDownload1.setBackground(new Color(168, 207, 69, 255));
                    btnDownload1.setBounds(540, 20 + height, 95, 23);
                    btnDownload1.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e){
                            // String url = "jdbc:mysql://localhost:3306/muzedb";
            	            // String user = "root";
            	            // String password = "Benzema-09";
				            // try (Connection connection = DriverManager.getConnection(url, user, password);
					        //     Statement statement = connection.createStatement()) {
					        //     statement.executeUpdate("SELECT FROM audio (Audioname, Artist, Uploader) values (?, ?, ?)");
				            // }
				            // catch (SQLException ex) {
			  	            //     throw new RuntimeException("Error executing sql:\n" + "SELECT FROM audio (Audioname, Artist, Uploader) values (?, ?, ?)", ex);
				            // }

                            Connection con = null;
                            Statement stmt = null;
                            ResultSet rs = null;

                            con = MuzeJDBC.getConnection();
                            try {
                                stmt = con.createStatement();
                            } catch (SQLException e2) {
                                e2.printStackTrace();
                            }
                            
                            try {
                                rs = stmt.executeQuery("SELECT FROM audio (Audioname, Artist, Uploader) values (?, ?, ?)");
                            } catch (SQLException e1) {
                                e1.printStackTrace();
                            }
		  	            }
                    });
                    contentPane.add(btnDownload1);

                    height += 30;                
            }
        }

    }

    public static String getFileNameWithoutExtension(String filename) {
        String fileName = "";
        for (int i = 0; i < filename.length(); i++) {
            if (filename.charAt(i) == '.') {
                break;
            }
            fileName += filename.charAt(i);
        }
        return fileName;
    }

    public static boolean indirectory(File audiosFile, File fileName) {
        if (audiosFile.isDirectory()) {
            File[] files = audiosFile.listFiles();
            for (File file : files) {
                if (file.getName().equals(fileName.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

}
