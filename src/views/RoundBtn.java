package views;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;

public class RoundBtn implements Border {
    private int round;

    public RoundBtn(int rounder) {
        this.round = rounder;
    }

    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, round, round);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.round + 1, this.round + 1, this.round + 2, this.round);
    }
}