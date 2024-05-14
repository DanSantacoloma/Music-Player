package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class ProgressBar extends JProgressBar {

    public ProgressBar() {

    }

    public JProgressBar applyStyle(JProgressBar pBar, int min, int max, int width, int heigth) {
        pBar.setForeground(Color.BLACK);
        pBar.setStringPainted(true);
        pBar.setUI(new BasicProgressBarUI());
        pBar.setPreferredSize(new Dimension(width, heigth));
        pBar.setString("");
        setMinimum(min);
        setMaximum(max);
        pBar.setValue(25);
        return pBar;
    }

}
