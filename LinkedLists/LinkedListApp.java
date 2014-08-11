import java.util.Scanner;

public class LinkedListApp {

	private static LinkedList list;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		list = new LinkedList();
		String option = "";
		String word;

		while (!option.equalsIgnoreCase("quit")) {
			System.out
					.println("1 (insert), 2 (deleteFirst), 3 (insert), 4 (Empty?), 5 (printList)");
			String reply = input.nextLine();
			switch (reply) {
			case "1":
				System.out.println("Enter the word you want to insertFirst: ");
				word = input.nextLine();
				list.InsertFirst(word);
				break;
			case "2":
				list.DeleteFirst();
				break;
			case "3":
				System.out.println("Enter the word you want to insert: ");
				word = input.nextLine();
				list.insert(word);
				break;
			case "4":
				if (list.isEmpty())
					System.out.println("LinkedList is empty");
				else
					System.out.println("LinkedList is not empty");
				break;
			case "5":
				list.PrintLinkedList();
				break;
			default:
				System.out.println("Invalid number");
			}

		}
	}
}
