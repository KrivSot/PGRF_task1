import view.Raster;

import java.awt.image.BufferedImage;

public class Renderer {
    private BufferedImage img;
    private int color;

    public Renderer(BufferedImage img, int color) {
        this.img = img;
        this.color = color;
    }

    public void Draw(int xA, int yA, int xB, int yB) {

        // vypocet pro smernici
        double dx = xB - xA;
        double dy = yB - yA;

        if (Math.abs(yB - yA) <= Math.abs(xB - xA)) {

            // Pro jeden bod
            if ((xA == xB) && (yA == yB)) {
                img.setRGB(xA, yA, 0xffff0000);
            } else {

                // prohozeni vodicich os
                if (xB < xA) {
                    int pomoc = xB;
                    xB = xA;
                    xA = pomoc;

                    pomoc = yB;
                    yB = yA;
                    yA = pomoc;
                }

                // vypocet
                double k = (double) dy / dx;
                int int_y;
                double y = (double) yA;

                // tisk img
                for (int x = xA; x <= xB; x++) {
                    int_y = (int) Math.round(y);
                    img.setRGB(x, int_y, 0xffff0000);
                    y += k;
                }
            }
        } else {

            // prohozeni vodicich os
            if (yB < yA) {
                int pomoc = xB;
                xB = xA;
                xA = pomoc;

                pomoc = yB;
                yB = yA;
                yA = pomoc;
            }

            // vypocet
            double k = (double) dx / dy;
            int int_x;
            double x = (double) xA;

            // tisk img
            for (int y = yA; y <= yB; y++) {
                int_x = (int) Math.round(x);
                img.setRGB(int_x, y, 0xffff0000);
                x += k;
            }
        }
    }

}