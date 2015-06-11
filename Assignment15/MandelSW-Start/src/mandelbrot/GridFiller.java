/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrot;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;

/**
 *
 * @author Sjaak
 */
public class GridFiller {

    private Area area;
    private Grid grid;
    public static final int MAX_ITERATIONS = 400;
    private static final RGBColors rgbColors = new RGBColors(MAX_ITERATIONS);
    private static final ColorChooser colorChooser = new ColorChooser();

    public GridFiller(Grid grid, Area area) {
        this.grid = grid;
        this.area = area;
        colorChooser.setMaxIndex(MAX_ITERATIONS);
    }

    public Area getArea() {
        return area;
    }

    public void fill() {
        int grid_w = grid.getWidth(), grid_h = grid.getHeight();
        double area_w = area.getWidth(), area_h = area.getHeight();
        double dx = area_w / grid_w, dy = area_h / grid_h;

        double x = area.getX();
        for (int i = 0; i < grid_w; i++) {
            double y = area.getY();
            for (int j = 0; j < grid_h; j++) {
                int color = colorChooser.getColorIndex(x, y);
                grid.setPixel(i, j,
                        color == -1 ? RGBColors.BLACK : rgbColors.getColor(color));

                y -= dy;
            }
            try {
                Thread.sleep( 2 );
            } catch (InterruptedException e) {
                System.out.println("Sleeping thread interrupted");
            }
            x += dx;
        }
    }
}
