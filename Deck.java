
import java.security.SecureRandom;

/**
 * An implementation of a deck of cards
 * @author yutian
 * @since 06/22/2015
 */
public class Deck {
	
	/**
	 * Array of Card Objects
	 */
	private Card[] deck; 
	
	/**
	 * Number of cards in the deck
	 */
	private int numberCards; 
	
	/**
	 * index the card which will be dealt, first card of undealt part. 
	 */
	private int currentCard = 0; 
	
	/**
	 * Random number generator 
	 */
	private static final SecureRandom randomNumbers = new SecureRandom(); 
	
	/**
	 * Default constructor, one deck, non-shuffle
	 */
	public Deck()
	{
		// call the constructor below
		this(1, false); 
	}
	
	/**
	 * Constructor that creates the number of decks and whether the deck should be shuffled. 
	 * @param numDeck
	 * @param shuffle
	 */
	public Deck(int numDeck, boolean shuffle)
	{
		this.numberCards = numDeck * 52; 
		this.deck = new Card[this.numberCards]; 
		
		// card index 
		int index = 0; 
		
		// for each deck 
		for (int i = 0; i < numDeck; i++)
		{
			// for each suit 
			for (int j = 0; j < 4; j++)
			{
				// for each number
				for (int k = 1; k <= 13; k++)
				{
					deck[index++] = new Card(Suit.values()[j], k); 
				}
			}
		}
		
		// shuffle the deck 
		if (shuffle) {
			this.shuffle(); 
		}
	}

	/**
	 * An implementation to shuffle the deck
	 */
	private void shuffle() 
	{
		// for each Card, pick another random Card and swap them 
		for (int i = 0; i < numberCards; i++)
		{
			// randomly select another card 
			int j = randomNumbers.nextInt(numberCards); 
			
			// swap current card and randomly selected card 
			Card temp = deck[i]; 
			deck[i] = deck[j]; 
			deck[j] = temp; 
			
		}
	}
	
	/**
	 * Return the next card which will be dealt. 
	 * @return current dealt position
	 */
	public Card dealCard() 
	{
		// determine whether Cards remain to be dealt
		if (currentCard < deck.length)
			return deck[currentCard++]; 
		else 
			return null; 
		
	}
	
	/**
	 * Print the top cards in the deck. 
	 * @param number	the number of cards from top of the deck to print out. 
	 */
	public void printDeck(int num)
	{
		for (int i = currentCard; i < currentCard + num; i++)
		{
			System.out.printf("%3d/%d %s\n", (i - currentCard + 1), numberCards - i, deck[i].toString()); 
		}
		System.out.printf("\t\t[%d left]\n", numberCards - currentCard - num); 
	}
	
}
