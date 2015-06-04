/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mandelbrot;

/**
 *
 * @author Sjaak
 */
public class ColorChooser {
    private int maxIndex;
    private int currentIndex;
    
    public ColorChooser () {
        maxIndex = 0;
    }
    
    public void setMaxIndex (int max_index) {
        maxIndex = max_index;
    }
    
    public void setCurrentIndex(int index) {
    	this.currentIndex = index;
    }
    
    public int getCurrentIndex() {
    	return currentIndex;
    }
    
    public int getMaxIndex() {
    	return maxIndex;
    }
    
    public int getColorIndex (double x0, double y0, int depth) {
        double x = x0, y = y0;
        int color_index = 0;
        while (x * x + y * y < 4.0) {
            double nx = x * x - y * y + x0;
            y = 2 * x * y + y0;
            x = nx;
            color_index++;
            if (color_index == depth) {
                return -1;
            }
        }
        return color_index;
    }
}
