public class Card {

	private String suit;
	private int value;

	public Card(String suit, int value) {
		this.suit = suit;
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}

	public String toString() {
		String card = "The ";
		if (value > 1 && value < 11) {
			card += value;
		} else if (value == 1) {
			card += "Ace";
		} else if (value == 11) {
			card += "Jack";
		} else if (value == 12) {
			card += "Queen";
		} else {
			card += "King";
		}
		card += " of " + suit;
		return card;
	}
}
