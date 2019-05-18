import java.util.List;

import linkedlist.LinkedList;
import nodemodel.Node;

public class MainApplication {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();

		linkedList.addElemeent(new String("head"));
//		linkedList.addElemeent(new String("nodeOne"));
//		linkedList.addElemeent(new String("nodeTwo"));
//		linkedList.addElemeent(new String("nodTree"));

		printLinkedList(linkedList);

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
