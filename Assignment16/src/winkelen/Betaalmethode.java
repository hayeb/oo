
package winkelen;

/**
 * Interface for the payment methods.
 * @author Haye Bohm - s4290402
 * @author Ylja Remmits - s4373510
 *
 */
public interface Betaalmethode {

	public boolean betaal(double bedrag);

	void invoerGegevens();

}