package nodemodel;

public class Node<T> {

	T obj;
	Node<T> node;

	public Node(T obj) {
		this.obj = obj;
	}

	public Node<T> getNode() {
		return node;
	}

	public void setNode(Node<T> node) {
		this.node = node;
	}

	@Override
	public String toString() {
		return "Node [obj=" + obj + ", node=" + node + "]";
	}
}
