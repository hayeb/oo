package assignment4;

/**
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public class AsciiArt implements TekenLoipe {
	private InfoLoipe loipe;
	private String drawing[][];

	/**
	 * Constructs using a class which implements InfoLoipe. Alse initizalizes a
	 * list according to the width and height of the loipe.
	 * 
	 * @param s
	 */
	public AsciiArt(InfoLoipe s) {
		this.loipe = s;
		drawing = new String[loipe.getY()][loipe.getX()];
	}

	/**
	 * Draws a ASCII art representation according to the contents of the list of
	 * Fragments in loipe.
	 */
	@Override
	public void teken() {
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < loipe.getY(); i++) {
			for (int j = 0; j < loipe.getX(); j++) {
				Fragment f = loipe.getFragment(j, i);
				if (f == null) {
					output.append(" ");
				} else {
					switch (f) {
					case KR:
						drawing[i][j] = "+";
						output.append("+");
						break;
					case NO:
						drawing[i][j] = "`";
						output.append("`");
						break;
					case NW:
						drawing[i][j] = "'";
						output.append("'");
						break;
					case NZ:
						drawing[i][j] = "|";
						output.append("|");
						break;
					case OW:
						drawing[i][j] = "-";
						output.append("-");
						break;
					case ZO:
						drawing[i][j] = ",";
						output.append(",");
						break;
					case ZW:
						drawing[i][j] = ".";
						output.append(".");
						break;
					default:
						drawing[i][j] = " ";
						output.append(" ");
					}
				}
			}
			output.append("\n");
		}
		System.out.print(output.toString());
	}
	
	/**
	 * Draws a ASCII reprepresentation, with and asterisk representing the current step.
	 */
	@Override
	public void setPosition(Punt p) {
		for (int i = 0; i < drawing.length; i++) {
			for (int j = 0; j < drawing[0].length; j++) {
				if (p.getX() == j && p.getY() == i) {
					System.out.print("*");
				} else if (drawing[i][j] != null) {
					System.out.print(drawing[i][j]);
				} else {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}

}
