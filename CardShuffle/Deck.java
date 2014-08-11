public class Deck {

	private Card[] deck;

	public Deck() {
		String[] suits = { "Diamonds", "Spades", "Hearts", "Clubs" };
		int count = 0;
		deck = new Card[52];
		for (int i = 0; i < suits.length; i++) {
			for (int j = 1; j <= 13; j++) {
				deck[count] = new Card(suits[i], j);
				count++;
			}
		}

	}

	public void shuffle() {
		for (int i = 0; i < deck.length; i++) {
			int index = (int) (Math.random() * 52);
			Card temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;

		}

	}

	public void drawCard(int num) {
		for (int i = 0; i < num; i++) {
			System.out.println(deck[i].toString());
		}
	}

}
