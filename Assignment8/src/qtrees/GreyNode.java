package qtrees;

import java.io.IOException;
import java.io.Writer;

public class GreyNode extends QTNode {

	private QTNode[] children;

	/**
	 * Initialize a grey node with an empty children list of length 4.
	 */
	public GreyNode() {
		children = new QTNode[4];
	}

	/**
	 * Adds a child to the children list.
	 * 
	 * @param index
	 * @param node
	 */
	public void addChild(int index, QTNode node) {
		children[index] = node;
	}

	/**
	 * Fills a bitmap according to the children of this node.
	 */
	@Override
	public void fillBitmap(int x, int y, int width, Bitmap bitmap) {
		for (int i = 0; i < 4; i++) {
			QTNode child = children[i];
			switch (i) {
			case 0:
				child.fillBitmap(x, y, width / 2, bitmap);
				break;
			case 1:
				child.fillBitmap(x + width / 2, y, width / 2, bitmap);
				break;

			case 2:
				child.fillBitmap(x + width / 2, y + width / 2, width / 2,
						bitmap);
				break;

			case 3:
				child.fillBitmap(x, y + width / 2, width / 2, bitmap);
				break;
			}
		}
	}

	/**
	 * Writes a character to the writer out and does the same for each child of
	 * this node.
	 */
	@Override
	public void writeNode(Writer out) {
		try {
			out.append((char) 49);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (QTNode node : children) {
			node.writeNode(out);
		}
	}

	@Override
	public boolean sameLeaf(QTNode other_node) {
		return false;
	}

}
