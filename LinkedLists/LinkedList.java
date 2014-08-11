public class LinkedList {

	private Link first;
	private Link last;

	public LinkedList() {
		first = null;
		last = null;
	}
	
	public void insert(String dd) {
	    Link newLink = new Link(dd);

	    if (isEmpty()){
	        first = newLink;
		last = newLink;
		}

	    else{
	     	last.next = newLink;
		
		}
	    last = newLink;
	  }
	
	public void InsertFirst(String value) {
		Link newLink = new Link(value);
		if(first == null || first.next == null){
			newLink.next = first;
			first = newLink;
			last = newLink.next;
		}else{
			newLink.next = first;
			first = newLink;
		}
	}
	
	public void DeleteFirst() {
		if (!isEmpty()) {
			Link temp = first;
			first = first.next;
			System.out.println(temp.toString() + " was deleted from LinkedList");
		}
	}
	
	public void PrintLinkedList(){
		Link current = first;
		if(isEmpty())
			System.out.println("Linked List is empty");
		else{
			while(current != null){
				System.out.println(current.toString());
				current = current.next;
			}
			System.out.println("***Done***");
		}
	}

	public boolean isEmpty() {
		return (first == null);
	}
}
