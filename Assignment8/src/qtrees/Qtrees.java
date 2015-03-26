package qtrees;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 *
 * @author Sjaak
 */
public class Qtrees {

	/**
	 * @param args
	 *            the command line arguments
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * Vragen: Exception handling in de QTree klasse (zie de readQTree
		 * klasse). Moeten we hiervoor een try/catch gebruiken ipv Throws? Zijn
		 * de switches zo goed/efficient?
		 */
		String test_tekst = "10011010001010010001010101100011000101000000";
		StringReader input = new StringReader(test_tekst);
		QTree qt = new QTree(input);
		StringWriter writer = new StringWriter();
		qt.writeQTree(writer);
		System.out.print("The binary string representation of the quad tree:\n"
				+ writer.toString() + "\n\n");
		Bitmap bitmap = new Bitmap(8, 8);
		qt.fillBitmap(bitmap);
		System.out.println("The character representation of the bitmap: \n"
				+ bitmap);
		QTree qt2 = new QTree(bitmap);
		System.out.print(qt2);
	}

}
