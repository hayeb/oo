package qtrees;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class QTree {
	QTNode root;

	/**
	 * Constructs a tree according to a string representation.
	 * 
	 * @param input
	 *            A Reader which contains the input string.
	 * @throws IOException
	 */
	public QTree(Reader input) throws IOException {
		root = readQTree(input);
	}

	/**
	 * Constructs a tree according to a bitmap.
	 * 
	 * @param bitmap
	 *            A bitmap representation of the tree.
	 */
	public QTree(Bitmap bitmap) {
		root = bitmap2QTree(0, 0, bitmap.getWidth(), bitmap);
	}

	/**
	 * Fills a bitmap according to tree represented in this class. Uses the node
	 * root for the root node.
	 * 
	 * @param bitmap
	 *            The bitmap representation will be stored in this bitmap.
	 */
	public void fillBitmap(Bitmap bitmap) {
		root.fillBitmap(0, 0, bitmap.getWidth(), bitmap);
	}

	/**
	 * Transforms a quad-tree representation of the image into a string
	 * representation.
	 * 
	 * @param sb
	 *            A writer in which the string representation will be stored.
	 */
	public void writeQTree(Writer sb) {
		root.writeNode(sb);
	}

	/**
	 * Transforms a binary string into a quad tree.
	 * 
	 * @param input
	 * @return
	 * @throws IOException
	 */
	private static QTNode readQTree(Reader input) throws IOException {
		int first = input.read();
		// Case 1: the integer is -1. Tree is completed
		if (first == -1) {
			return null;
		} // The next bit is 0.
		else if (first == 48) {
			// black leaf
			int next_bit = input.read();
			if (next_bit == 48) {
				return new BlackLeaf();
			} else if (next_bit == 49) {
				return new WhiteLeaf();
			}
		} // The net bit is 1
		else if (first == 49) {
			GreyNode temp = new GreyNode();
			for (int i = 0; i < 4; i++) {
				temp.addChild(i, readQTree(input));
			}
			return temp;
		} else {
			// There has been an error.
			System.err.println("There was an error in QTNode.readQTree");
			return null;
		}
		return null;
	}

	/**
	 * Constructs a quadtree from a bitmap.
	 * 
	 * @param x
	 *            X coordinate of the top left pixel
	 * @param y
	 *            y coordinate of the lop left pixel
	 * @param width
	 *            width of the bitmap
	 * @param bitmap
	 *            The bitmap
	 * @return
	 */
	public static QTNode bitmap2QTree(int x, int y, int width, Bitmap bitmap) {
		int color = bitmap.checkColor(x, y, width);
		if (color == 1) {
			return new BlackLeaf();
		} else if (color == 2) {
			return new WhiteLeaf();
		} else {
			GreyNode temp = new GreyNode();
			for (int i = 0; i < 4; i++) {
				switch (i) {
				case 0:
					temp.addChild(i, bitmap2QTree(x, y, width / 2, bitmap));
					break;
				case 1:
					temp.addChild(i,
							bitmap2QTree(x + width / 2, y, width / 2, bitmap));
					break;
				case 2:
					temp.addChild(
							i,
							bitmap2QTree(x + width / 2, y + width / 2,
									width / 2, bitmap));
					break;
				case 3:
					temp.addChild(i,
							bitmap2QTree(x, y + width / 2, width / 2, bitmap));
					break;
				}
			}
			return temp;

		}
	}

}
