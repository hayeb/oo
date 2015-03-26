package qtrees;

import java.io.IOException;
import java.io.Writer;

public class BlackLeaf extends QTNode {

	/**
	 * Fills a bitmap of size width*width and with the top left corner at (x, y)
	 * as black.
	 */
	@Override
	public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
		if (width > 1) {
			fillArea(x, y, width, bitmap, false);
		} else {
			bitmap.setBit(x, y, false);
		}

	}

	/**
	 * Writes two characters to the writer out, representing the color of this
	 * node.
	 */
	@Override
	public void writeNode(Writer out) {
		try {
			out.append((char) 48);
			out.append((char) 48);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean sameLeaf(QTNode other_node) {
		return false;
	}

}
