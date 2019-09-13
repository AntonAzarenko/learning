package com.azarenka;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class PaintDemo {

    JLabel jlab;
    PaintPanel pp;
    PaintDemo paintDemo;

    public PaintDemo() {
        JFrame frame = new JFrame("Paint Demo");
        frame.setSize(700, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pp = new PaintPanel();
        frame.add(pp);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PaintDemo();
            }
        });
    }
}

