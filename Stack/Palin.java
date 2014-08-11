import java.util.Scanner;

public class Palin {
	public static Scanner input;
	private static int count = 0, num = 0;
	public static void main(String args[]){
		input = new Scanner(System.in);
		System.out.println("Please enter word to check: ");
		String word = input.next();
		Stack myArray = new Stack(word.length());
		for(int i = 0; i < word.length(); i++){
			myArray.push(word.charAt(i));
		}
		
		while(!myArray.isEmpty()){
			if(myArray.pop() == word.charAt(count))
				num++;
			
			count++;
		}
		
		if(num == word.length())
			System.out.println("palin");
		else
			System.out.println("not palin");
	}
}
