import java.util.Scanner;

public class binarySearch {
	static Scanner input;
	static String first, second;
	static int guess = 0;
	static int min = 0, max, check;
	static int[] array;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.println("Enter the range: ");
		int range = input.nextInt();
		array = new int[range];
		max = range;

		System.out.println("OK, pick a random number between 1 and 1000. Are you ready? ");
		
		String ready = input.next();

		for (int i = 1; i < array.length; i++)
			array[i] = i;
		
		check = max;
		while (ready.equalsIgnoreCase("yes")) {
			if(guess < 1){
				check = check/2;
				System.out.println("I guess " + array[check]);
				first = input.next();
				guess++;
				if(first.equalsIgnoreCase("yes")){
					System.out.println("It took " + guess + " guess to get your number");
				break;
				}
			}
			switch (first){
			case "lower":
				max = check;
				check = (min + max)/2;
				System.out.println("I guess " + array[check]);
				first = input.next();
				guess++;
				break;
			case "higher":
				min = check;
				check = (min + max)/2;
				System.out.println("I guess " + array[check]);
				first = input.next();
				guess++;
				break;			
			
			case "yes":
				System.out.println("It took " + guess + " guesses to guess your number");
				ready = "no";
				break;
			default:
				System.out.println("You have used the wrong word");
				System.out.println("use the words higher , lower or yes");
				first = input.next();
				break;		
			}		
		}
	}
}
