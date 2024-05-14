package GUI;

import java.awt.*;

public class IconImages {

    private Image scaledImg;

    public Image getScaledImg() {
        return scaledImg;
    }

    public void setScaledImg(Image scaledImg) {
        this.scaledImg = scaledImg;
    }

    public IconImages() {

    }

    public Image resizeImage(Image ogImage, int width, int heigth) {
        scaledImg = ogImage.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);
        return scaledImg;
    }

}
