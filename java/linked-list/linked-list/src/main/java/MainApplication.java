import linkedlist.LinkedList;
import nodemodel.Node;

public class MainApplication {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		
		Node<String> nodeHead = new Node<String>(new String("head"));
		Node<String> node = new Node<String>(new String("node"));
		
		linkedList.getNode().setNode(nodeHead);
	}

}
