import java.awt.Color;

import javax.swing.JFrame;
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
    }
    
}
