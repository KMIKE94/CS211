public class Stack {
	private int maxSize;
	private int top;
	private char[] stackArray;

	public Stack(int s) {
		maxSize = s;
		stackArray = new char[maxSize];
		top = -1;
	}

	public void push(char j) {
		System.out.println("push " + j);
		top++;
		stackArray[top] = j;
		display();
	}

	public char pop() {
		return stackArray[top--];
	}

	public char peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public void makeEmpty() {
		top = -1;
	}

	private void display() {
		int count = 0;
		for (int i = stackArray.length - 1; i >= 0; i--) {

			if (stackArray[i] >= 'a' || stackArray[i] <= 'z')
				System.out.println(i + "|_" + stackArray[i] + "_|");
			 else 
				System.out.println(i + "|_" + stackArray[i] + "_|");
			count++;

		}
	}
}
