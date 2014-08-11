import java.util.Scanner;

public class MainMethod {

	public static void main(String[] args) {
		Deck mydeck = new Deck();
		mydeck.shuffle();
		Scanner in = new Scanner(System.in);
		System.out.println("How many cards do you want?");
		int num = in.nextInt();
		mydeck.drawCard(num);
	}

}
