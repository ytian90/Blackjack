/**
 * An implementation of a player
 * @author yutian
 * @since 06/22/2015
 */
public class Player {

	private static final int MAX_CARDS_NUMBER = 20; 
	
	/**
	 * Name of player 
	 */
	private String name; 
	
	/**
	 * The cards in the player's hand. 
	 */
	private Card[] hand = new Card[MAX_CARDS_NUMBER]; 
	
	/**
	 * Number of cards in hand. 
	 */
	private int numCards; 
	
	/**
	 * Player constructor. 
	 * @param s the name of player 
	 */
	public Player(String s)
	{
		this.name = s;
		
		// set the player's hand to be empty 
		this.empty(); 
	}

	/**
	 * Empty the player's cards. 
	 */
	private void empty() {
		
		for(int i = 0; i < 10; i++)
		{
			this.hand[i] = null; 
		}
		this.numCards = 0; 
	}
	
	/**
	 * Add a card to the player's hand 
	 * @param c		the card to add
	 * @return 		whether the sum of the new hand is below or equal to 21
	 */
	public boolean addCard(Card c)
	{
		if (this.numCards == MAX_CARDS_NUMBER)
		{
			System.err.printf("%s already has maximum cards, can't have more", this.name); 
			System.exit(1);
		}
		
		// add new card 
		this.hand[this.numCards++] = c; 
		
		return (this.getSum() <= 21); 
		
	}

	/**
	 * Get the sum of the cards
	 * @return the 
	 */
	public int getSum() {
		// TODO Auto-generated method stub
		int sum = 0; 
		int cardNum; 
		int numAces = 0; 
		
		for (int i = 0; i < this.numCards; i++)
		{
			cardNum = this.hand[i].getNumber(); 
			
			if (cardNum == 1) {
				numAces++; 
				sum += 11; 
			} else if (cardNum > 10) {
				sum += 10; 
			} else {
				sum += cardNum; 
			}
		}
		
		// if we have aces and sum is > 21, reset aces values. 
		while (numAces > 0 && sum > 21) {
			sum += 10; 
			numAces--; 
		}
		
		return sum; 
	}
	
	/**
	 * Print the cards in the player's hand. 
	 * @param showFirst whether the first card is hidden or not. 
	 */
	public void printHand(boolean showFirst)
	{
		System.out.printf("%s's cards:\n", this.name); 
		for (int i = 0; i < this.numCards; i++) {
			if (i == 0 && !showFirst)
				System.out.println("  [Unknown]");
			else 
				System.out.printf("  %s\n", this.hand[i].toString()); 
				
		}
	}
	
}
