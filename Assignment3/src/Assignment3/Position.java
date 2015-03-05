package Assignment3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - 4373510 
 */
public class Position {

	private int x;
	private int y ;
	private int numsuccessors ;
	
	private static Position jumps[] = {
		
	};
	
	public Position() {
		
	}
	
	public Position(int x, int y) {
		this.x = x ;
		this.y = y ;
	}
	
	public void setPosition(int x, int y) {
		this.x = x ;
		this.y = y ;
	}
	
	public int getPositionX() {
		return x ;
	}
	
	public int getPositionY() {
		return y ;
	}
	
	public String toString() {
		return "Position at " + x + "," + y + " successors: " + numsuccessors + "\n" ;
	}
	
	public List<Position> getSuccessors(int max) {
		// for each jump in jumps
		//	if positie.move(jump).isValid:
		//		successors.add(positie.move(jump)
		
		ArrayList<Position> successors = new ArrayList<Position>();
		int x = p.getPositionX();
		int y = p.getPositionY();
		successors.add(new Position(x + 1, y + 2));
		successors.add(new Position(x + 1, y - 2));
		successors.add(new Position(x + 2, y + 1));
		successors.add(new Position(x + 2, y - 1));
		successors.add(new Position(x - 1, y + 2));
		successors.add(new Position(x - 1, y - 2));
		successors.add(new Position(x - 2, y + 1));
		successors.add(new Position(x - 2, y - 1));

		for (int i = 0; i < successors.size(); i++) {
			if (successors.get(i).getPositionX() < 0
					|| successors.get(i).getPositionX() >= this.size
					|| successors.get(i).getPositionY() < 0
					|| successors.get(i).getPositionY() >= this.size
					|| visited.contains(successors.get(i))) {
				successors.remove(i);
				i--;
			}
		}
		return successors;
	}
	
	public void setSuccessors(int numsuccessors) {
		this.numsuccessors = numsuccessors ;
	}
	
	public int getSuccessors() {
		return numsuccessors ;
	}
	
	@Override
	public boolean equals(Object object)
	{
	    boolean isEqual= false;

	    if (object != null && object instanceof Position)
	    {
	        isEqual = (this.x == ((Position) object).x) && (this.y == ((Position) object).y);
	    }

	    return isEqual;
	}
}
