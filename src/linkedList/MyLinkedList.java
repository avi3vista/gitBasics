package linkedList;

public class MyLinkedList {

	Node head;
	Node tail;

	public void addToEnd(int data) {
		Node node = new Node(data, null);

		if (tail == null) {
			head = node;
			tail = node;
		} else {
			tail.setNextNode(node);
			tail = node;
		}

	}

	public void addToHead(int data) {
		Node node = new Node(data, head);
		head = node;
	}

	public void addAfter(int data, int afterData) {
		Node node = new Node(data, null);
		if (head == null) {
			System.out.println("Cannot insert as the list is empty");
			return;
		}
		Node traversingNode = head;
		do {
			if (traversingNode.getData() == afterData) {
				break;
			}
			traversingNode = traversingNode.getNextNode();
		} while (traversingNode != null);

		if (traversingNode != null && traversingNode.getData() == afterData) {
			node.setNextNode(traversingNode.getNextNode());
			traversingNode.setNextNode(node);
		} else {
			System.out.println("Could not insert as the afterData was not found");
		}

	}
	
	public void removeFromEnd() {
		Node traversingNode = head;
		while (traversingNode!=null) {
			
			if(traversingNode.getNextNode() == tail) {
				traversingNode.setNextNode(null);
				tail = traversingNode;
			}
			traversingNode = traversingNode.getNextNode();
			
		}
	}

	public void printList() {
		Node node = head;
		if (node != null) {
			do {
				System.out.println(node.getData());
				node = node.getNextNode();
			} while (node != null);
		} else {
			System.out.println("List is empty");
		}
	}
	
	public Node findMiddleNode() {
		Node node = head;
		Node middleNode = head;
		
		if(node!=null) {
			while (node!=null && node.getNextNode()!=null) {
				node = node.getNextNode();
				middleNode = middleNode.getNextNode();
				if(node!=null) {
					node = node.getNextNode();
				}
				
			}
		}
		
		
		
		return middleNode;
	}

}
