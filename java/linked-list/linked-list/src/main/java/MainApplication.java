import java.util.List;

import linkedlist.LinkedList;
import nodemodel.Node;

public class MainApplication {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();

//		linkedList.addElement(new String("head"));
//		linkedList.addElement(new String("nodeOne"));
//		linkedList.addElement(new String("nodeTwo"));
		linkedList.addFirst(new String("newHead"));
		linkedList.addFirst(new String("newestHeeead"));
//		linkedList.addElemeent(new String("nodTree"));

		printLinkedList(linkedList);
//		System.out.println("Size: " + linkedList.getSize());
//		System.out.print("Hello");
	}

	public static void printLinkedList(LinkedList linkedList) {
		Node current = linkedList.getHead();

		if (current != null) {
			System.out.println(current.getElement());
		}
		while (linkedList.hasNextNode(current)) {
			current = current.getNextNode();
			System.out.println("node: " + current.getElement());
		}

	}

}
