import java.util.Scanner;

public class PriorityQueueApp{
	public static Scanner input;

	public static void main(String args[]) {
		Queue myQueue = new Queue(5);
		input = new Scanner(System.in);

		String ans = "";
		while (!ans.equals("quit") == true) {
			System.out
					.println("Do you want to insert, remove, getsize or quit?:");
			ans = input.next();
			if (ans.compareTo("insert") == 0) {
				System.out.println("Enter name to insert: ");
				String name = input.next();
				System.out.println("Enter priority 1-9: ");
				
				myQueue.insert(name, input.nextInt());
			} else if (ans.compareTo("remove") == 0) {
				System.out.println(myQueue.remove()
						+ " has been removed from the queue");
			} else if (ans.compareTo("getSize") == 0){
				System.out.println(myQueue.getSize()
						+ " is the size of the queue");
			}
		}
	}
}
