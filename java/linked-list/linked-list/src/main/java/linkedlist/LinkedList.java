package linkedlist;

import nodemodel.Node;

public class LinkedList<T> {

	private Node<T> head;
	private Integer linkedSize;

	public LinkedList() {
		this.linkedSize = 0;
	}

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> node) {
		this.head = node;
	}

	public void addElemeent(T element) {
		Node<T> currentNode;
		Node<T> newNode = new Node<T>();

		newNode.setElement(element);
		currentNode = this.head;

		if (this.head == null) {
			this.head = newNode;
			this.head.setNextNode(null);
		} else {
			while (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}

			currentNode.setNextNode(newNode);
			newNode.setNextNode(null);
		}
	}
	
	public boolean hasNextNode(Node<T> node) {
		if(node == null) {
			return false;
		}
		return node.getNextNode() != null ? true : false;
	}

	public Node<T> getNextNode(Node<T> node) {
		return node.getNextNode();
	}
}
