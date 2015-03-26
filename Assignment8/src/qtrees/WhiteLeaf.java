package qtrees;

import java.io.IOException;
import java.io.Writer;

public class WhiteLeaf extends QTNode {

	public WhiteLeaf() {
		
	}

	@Override
	public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
		if (width > 1) {
			fillArea(x, y, width, bitmap, true);
		} else {
			bitmap.setBit(x, y, true);
		}
	}

	@Override
	public void writeNode(Writer out) {
		try {
			out.append((char) 48);
			out.append((char) 49);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean sameLeaf(QTNode other_node) {
		return false;
	}

}
