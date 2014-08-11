public class BinaryTree {
	public Node root;

	public int insert(int key) {
		Node newNode = new Node(key);

		if (root == null)
			root = newNode;

		else {
			Node focus = root;

			Node parent;
			while (true) {
				parent = focus;

				if (key < focus.data) {
					focus = focus.leftHand;

					if (focus == null){
						parent.leftHand = newNode;
						return parent.toInteger();
					}
				}

				else if (key > focus.data) {
					focus = focus.rightHand;

					if (focus == null){
						parent.rightHand = newNode;
						return parent.toInteger();
					}
				}
			}
		}
		return root.toInteger();
	}
	
	public void inOrder(Node focus){
		if(focus != null){
			inOrder(focus.leftHand);
			System.out.println(focus.toInteger() + " ");
			inOrder(focus.rightHand);
		}
		System.out.println("**Done**");
	}
	
	public void preOrder(Node focus){
		if(focus != null){
			System.out.println(focus.toInteger() + " ");
			
			preOrder(focus.leftHand);
			preOrder(focus.rightHand);
		}
		System.out.println("**Done**");
	}
	
	public void postOrder(Node focus){
		if(focus != null){
			postOrder(focus.leftHand);
			postOrder(focus.rightHand);
			
			System.out.println(focus.toInteger() + " ");
			
		}
		System.out.println("**Done**");
	}
	
	public int findNode(int key){
		Node focus = root;
		
		while(focus.toInteger() != key){
			if(key < focus.data){
				focus = focus.leftHand;
				
			}
			else
				focus = focus.rightHand;
			
			if(focus == null)
				return (Integer) null;
		}
		return focus.toInteger();
	}
}

class Node {
	public int data;

	Node leftHand;
	Node rightHand;

	public Node(int num) {
		this.data = num;
	}

	public int toInteger() {
		return data;
	}

}
