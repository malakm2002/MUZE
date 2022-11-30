import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class FirstUpload {
    private static File file = null;

    public static void createFrame(){


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(100, 100, 539, 362);
            JPanel contentPane = new JPanel();
            frame.setContentPane(contentPane);
            contentPane.setLayout(null);
            
            JLabel lblWelcome = new JLabel("WELCOME TO MUZE!"
                    + "\nKindly upload one mp3 file.");
            lblWelcome.setFont(new Font("Traditional Arabic", Font.BOLD | Font.ITALIC, 20));
            lblWelcome.setBounds(0, 11, 525, 172);
            contentPane.add(lblWelcome);
            
            JButton btnUpload = new JButton("Upload");
            btnUpload.addActionListener(new ActionListener() {
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
                             frame.dispose();
                             HomeFrame.create();
                         } catch (Exception e1) {
                             // TODO Auto-generated catch block
                             e1.printStackTrace();
                         }
                   
                 }
             }
                }
            });
            btnUpload.setBounds(196, 182, 89, 23);
            contentPane.add(btnUpload);
    }
    
}
