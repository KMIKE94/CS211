public class Queue {
	private int front, rear, nItems, count;
	private static int maxSize;
	private String[] qArray;
	private int[] pri;
	public Person[] person;

	public Queue(int sizeIn) {
		maxSize = sizeIn;
		person = new Person[maxSize];
		pri = new int[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
		count = 0;
	}

	public boolean insert(String name, int priority) {
		if (rear == maxSize - 1 && count == maxSize - 1)
			rear = -1;

		rear++;
		if (nItems == 0)
			person[rear] = new Person(name, priority);
		else {
			Person newPerson = new Person(name, priority);
			int x = nItems;
			int count = 1;
			while (x > 0 ) {
				if(person[x-count].getCondition() < priority && x > 0){
					person[x] = person[x-count];
					person[x-count] = newPerson;
					count++;
				}
				else
					person[x] = newPerson; 
				x--;
			}
		}
		nItems++;
		return true;
	}

	public String remove() {
		if (isEmpty())
			return null;
		Person temp = person[front];
		front++;
		if (front == maxSize)
			front = 0;
		nItems--;
		return temp.toString();
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public int getSize() {
		return nItems;

	}
}
