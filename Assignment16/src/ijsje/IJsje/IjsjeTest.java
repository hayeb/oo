package ijsje.IJsje;

import java.util.LinkedList;
import java.util.List;

/**
 * Tests the ijsje class and its sub classes.
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class IjsjeTest {
	
	public static void main(String[] args) {
		new IjsjeTest();
	}

	private IjsjeTest() {
		System.out.println("Starting ijsje test");
		List<Ijsje> lijst = new LinkedList<Ijsje>();
		lijst.add( new VanilleIjs());
		lijst.add(new Spikkels(new Slagroom(new VanilleIjs())));
		lijst.add(new Chocodip(new Slagroom(new Spikkels(new VanilleIjs()))));
		
		for (Ijsje i : lijst) {
			System.out.println(i.geefBeschrijving() + ", EUR " + i.prijs());
		}
		
	}

}
