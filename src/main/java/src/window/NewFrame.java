package src.window;

import src.instruments.Bass;
import src.instruments.Hat;
import src.instruments.Kick;
import src.instruments.Piano;
import src.instruments.Snare;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewFrame implements ActionListener {
    public NewFrame(String text, int x, int y) {
        JFrame MyFrame = new JFrame(text);
        MyFrame.setBounds(x, y, 950, 320);
        MyFrame.setDefaultCloseOperation(3);
        MyFrame.setResizable(false);
        JLabel lbl = new JLabel("Piano:                                     Guitar:                                       Bass:");
        JLabel lbl1 = new JLabel("Pad:                                         Drums:");

        lbl.setBounds(10, 10, 250, 250);
        lbl1.setBounds(713, 200, 250, 20);

        JButton btn = new JButton("Закрыть");
        final JSlider scrb1 = new JSlider(1, 0, 100, 60);
        scrb1.setMajorTickSpacing(20);
        scrb1.setMinorTickSpacing(5);
        scrb1.setPaintTicks(true);
        scrb1.setSnapToTicks(true);
        scrb1.setPaintLabels(true);
        JSlider scrb2 = new JSlider(1, 0, 100, 60);
        scrb2.setMajorTickSpacing(20);
        scrb2.setMinorTickSpacing(5);
        scrb2.setPaintTicks(true);
        scrb2.setSnapToTicks(true);
        scrb2.setPaintLabels(true);
        JSlider scrb3 = new JSlider(1, 0, 100, 80);
        scrb3.setMajorTickSpacing(20);
        scrb3.setMinorTickSpacing(5);
        scrb3.setPaintTicks(true);
        scrb3.setSnapToTicks(true);
        scrb3.setPaintLabels(true);
        JSlider scrb4 = new JSlider(1, 0, 100, 60);
        scrb4.setMajorTickSpacing(20);
        scrb4.setMinorTickSpacing(5);
        scrb4.setPaintTicks(true);
        scrb4.setSnapToTicks(true);
        scrb4.setPaintLabels(true);
        JSlider scrb5 = new JSlider(1, 0, 100, 70);
        scrb5.setMajorTickSpacing(20);
        scrb5.setMinorTickSpacing(5);
        scrb5.setPaintTicks(true);
        scrb5.setSnapToTicks(true);
        scrb5.setPaintLabels(true);
        btn.setBounds(10, 240, 180, 30);
        scrb1.setBounds(200, 50, 170, 150);
        scrb2.setBounds(350, 50, 170, 150);
        scrb3.setBounds(500, 50, 170, 150);
        scrb4.setBounds(650, 50, 170, 150);
        scrb5.setBounds(800, 50, 170, 150);
        lbl.setBounds(265, 135, 400, 150);
        btn.addActionListener(this);
        MyFrame.setLayout(null);
        MyFrame.setVisible(true);
        MyFrame.add(lbl);
        MyFrame.add(lbl1);
        MyFrame.add(btn);
        MyFrame.add(scrb1);
        MyFrame.add(scrb2);
        MyFrame.add(scrb3);
        MyFrame.add(scrb4);
        MyFrame.add(scrb5);

        MyFrame.setVisible(true);

        scrb1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                Piano.volume = source.getValue();
            }
        });
        scrb2.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                Piano.volume = source.getValue();
            }
        });
        scrb3.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                Bass.volume = source.getValue();
            }
        });
        scrb5.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                Kick.volume = source.getValue();
                Hat.volume = source.getValue();
                Snare.volume = source.getValue();
            }
        });

    }

    public void actionPerformed(ActionEvent AEobj) {
        System.exit(0);
    }
}
