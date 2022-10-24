package src.window;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFrame implements ActionListener {
    public NewFrame(String text, int x, int y) {
        JFrame MyFrame = new JFrame(text);
        MyFrame.setBounds(x, y, 950, 320);
        MyFrame.setDefaultCloseOperation(3);
        MyFrame.setResizable(false);
        MyFrame.setVisible(true);

    }

    public void actionPerformed(ActionEvent AEobj) {
        System.exit(0);
    }
}
