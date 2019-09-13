package com.azarenka;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Random;
import java.util.TreeMap;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class PaintPanel extends JPanel {
    Insets ins;
    Random rand;

    public PaintPanel() {
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rand = new Random();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x, y, x2, y2;
        int height = getHeight();
        int width = getWidth();
        ins = getInsets();

        for (int i = 0; i < 100; i++) {
            x = rand.nextInt(width - ins.left);
            y = rand.nextInt(height - ins.bottom);
            x2 = rand.nextInt(width - ins.left);
            y2 = rand.nextInt(height - ins.bottom);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            g.drawLine(x, y, x2, y2);
        }
    }
}
