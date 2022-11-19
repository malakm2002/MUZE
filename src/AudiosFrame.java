import java.awt.Color;
import java.awt.Font;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AudiosFrame {
    
    public static void create(){
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
		
		JLabel lblDownload = new JLabel("File Download");
		lblDownload.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblDownload.setBounds(530, 20, 250, 20);
        lblDownload.setForeground(new Color(168, 207, 69, 255));
		contentPane.add(lblDownload);
        
        File dir = new File("C:\\Users\\Malak\\Desktop\\AUB\\FALL 2022\\CMPS 242\\project\\srcCode\\MUZE\\src\\audios");
        if(dir.isDirectory()){
            File[] files = dir.listFiles();
            int height = 30;
            for(File file: files){
                String fileName = file.getName();
                if(fileName.endsWith(".mp3")){
                    String fileNameNoExt = getFileNameWithoutExtension(fileName);
                    String[] audioFile = fileNameNoExt.split("-"); 

                    JLabel lblFileName1 = new JLabel(audioFile[1]);
                    lblFileName1.setFont(new Font("Tahoma", Font.PLAIN, 16));
                    lblFileName1.setForeground(new Color(168, 207, 69, 255));
                    lblFileName1.setBounds(10, 20+height, 250, 20);
                    contentPane.add(lblFileName1);

                    JLabel lblFileUploader1 = new JLabel(audioFile[0]);
                    lblFileUploader1.setForeground(new Color(168, 207, 69, 255));
                    lblFileUploader1.setFont(new Font("Tahoma", Font.PLAIN, 16));
                    lblFileUploader1.setBounds(270, 20+height, 250, 20);
                    contentPane.add(lblFileUploader1);
                    
                    JButton btnDownload1 = new JButton("Download");
                    btnDownload1.setBackground(new Color(168,207,69,255));
                    btnDownload1.setBounds(540, 20+height, 95, 23);
                    contentPane.add(btnDownload1);

                    height+=30;
                    
                }
            }
        }
       
    }
    private static String getFileNameWithoutExtension(String filename){
        String fileName = "";
        for(int i = 0;i<filename.length();i++){
            if(filename.charAt(i) == '.') {break;}
                fileName+=filename.charAt(i);
            }
        return fileName;
    }
    
}
