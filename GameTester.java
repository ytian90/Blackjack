
import java.util.Scanner; 

/**
 * An implementation to test the BlackJack Program. 
 * @author yutian
 * @since 06/22/2015
 */
public class GameTester {

	public static void main(String[] args) {
		
		// init
		Scanner sc = new Scanner(System.in); 
		Deck deck = new Deck(1, true); 
		
		// the first player
		Player me = new Player("Louis"); 
		// the second player
		Player dealer = new Player("Dealer"); 
		
		// round one 
		me.addCard(deck.dealCard()); 
		dealer.addCard(deck.dealCard()); 
		
		// round two 
		me.addCard(deck.dealCard()); 
		dealer.addCard(deck.dealCard()); 
		
		// print initial hands
		System.out.println("Cards are dealt: \n"); 
		me.printHand(true);
		dealer.printHand(false);
		System.out.println("\n");
		
		// flags to show the game is done or not. 
		boolean meFollow = true; 
		boolean dealerFollow = true; 
		String ans; 
		
		while (meFollow || dealerFollow) {
			
			// player
			if (meFollow)
			{
				System.out.print("Hits or Stay? (Enter H or S): "); 
				ans = sc.next(); 
				System.out.println(); 
				
				// if the player hits
				if (ans.compareToIgnoreCase("H") == 0) {
					
					// add next card in the deck and store whether busted 
					meFollow = me.addCard(deck.dealCard()); 
					me.printHand(true);
				}
				else 
				{
					meFollow = false; 
				}
			}
			
			// dealer
			if (dealerFollow)
			{
				if (dealer.getSum() < 17) {
					System.out.println("The Dealer hits\n"); 
					dealerFollow = dealer.addCard(deck.dealCard()); 
					dealer.printHand(false);
				}
				else 
				{
					System.out.println("The dealer stays\n"); 
					dealerFollow = false; 
				}
			}
			
			System.out.println(); 
			
		}
		
		sc.close();
		
		// print final results 
		me.printHand(true);
		dealer.printHand(true);
		
		int meSum = me.getSum(); 
		int dealerSum = dealer.getSum(); 
		
		if ((meSum > dealerSum && meSum <= 21) || dealerSum > 21)
			System.out.println("You wins"); 
		else 
			System.out.println("Dealer wins"); 
		
	}

}
