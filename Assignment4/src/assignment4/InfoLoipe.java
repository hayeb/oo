package assignment4;

/**
 * 
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 */
public interface InfoLoipe {
	public int getX();
	public int getY() ;
	
	public Fragment getFragment(int x, int y) ;
	
	public Punt start(); // Het startpunt op de kaart
	public Punt stap(); // het volgende punt op de route
}
