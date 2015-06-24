/**
 * An class of card type
 * @author yutian
 * @since 06/22/2015
 */
public class Card {

	/**
	 * One of four suits
	 */
	private Suit suit; 
	
	/**
	 * Ace: 1, Jack-King: 11 - 13
	 */
	private int number; 
	
	/**
	 * Constructor
	 * @param suit
	 * @param number
	 */
	public Card(Suit suit, int number)
	{
		this.suit = suit; 
		this.number = number;
	}
	
	/**
	 * Return the number of the card
	 * @return number
	 */
	public int getNumber()
	{
		return number; 
	}
	
	/**
	 * Print out the card 
	 */
	public String toString() 
	{
		String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" }; 
		return faces[number-1] + " of " + suit.toString(); 
	}

}
