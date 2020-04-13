package mcdowell;

class Node{
	int val;
	Node next;
	
	Node(int val){
		super();
		this.val=val;
	}
	
	void add(int val) {
		Node newNode = new Node(val);
		if(this.next!=null) {
			newNode.next = this.next;
		}
		this.next=newNode;
	}
	
	void print() {
		Node temp=this;
		while(temp!=null) {
			System.out.print(temp.val + "-->");
			temp=temp.next;
		}
	}
}

public class PartitionLinkedList {
	
	public static void partition(Node node, int k) {
		Node head=node;
		Node tail=node;
		
		while(node!=null) {
			Node next = node.next;
			if(node.val<k) {
				node.next=head;
				head =node;
			}
			else {
				tail.next=node;
				tail=node;
			}
			node = next;
		}
		tail.next=null;
		//lesser.next=greater;
		System.out.println("after partition");
		head.print();
		System.out.println("greater");
		tail.print();
	}
	// 3 5 8 5 10 2 1
	public static void main(String[] args) {
		Node node = new Node(3);
		node.add(1);
		node.add(2);
		node.add(10);
		node.add(5);
		node.add(8);
		node.add(5);
		node.print();
		partition(node,5);
	}

}
