package Assignment3;
/**
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - 4373510 
 */
public class Position {

	private int x;
	private int y ;
	private int numsuccessors ;
	
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
