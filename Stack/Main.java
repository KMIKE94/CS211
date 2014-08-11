import java.util.Scanner;

public class Main {
	public static Scanner input;

	public static void main(String args[]) {
		input = new Scanner(System.in);
		System.out.println("What word do you want to reverse?: ");
		String word = input.next();
		Stack myStack = new Stack(word.length());
		
		
		for (int i = 0; i < word.length(); i++) {
			myStack.push(word.charAt(i));
		}
		
		while (!myStack.isEmpty()){
			System.out.print(myStack.pop());
			
		}
		
		
	}
}
