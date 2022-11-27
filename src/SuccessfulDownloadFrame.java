

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.EmptyBorder;

public class SuccessfulDownloadFrame {
    public static void create() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 300, 150);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        frame.setVisible(true);
        contentPane.setLayout(null);

        JLabel lblDownSuccess = new JLabel("Downloaded Successfully!");
        lblDownSuccess.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblDownSuccess.setBounds(33, 22, 221, 31);
        contentPane.add(lblDownSuccess);

        JButton btnOK = new JButton("OK");
        btnOK.addActionListener((ActionListener) new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnOK.setBounds(165, 79, 89, 23);
        contentPane.add(btnOK);
    }

}
