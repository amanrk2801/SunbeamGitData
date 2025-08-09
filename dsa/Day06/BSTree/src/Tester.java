
public class Tester {

	public static void main(String[] args) {
		
		BST bst = new BST();
		
		bst.addNode(8);
		bst.addNode(3);
		bst.addNode(10);
		bst.addNode(2);
		bst.addNode(15);
		bst.addNode(6);
		bst.addNode(14);
		bst.addNode(4);
		bst.addNode(7);
		/*
		bst.preOrder();
		bst.inOrder();
		bst.postOrder();
		
		if(bst.binarySearch(16))
			System.out.println("Key is found");
		else
			System.out.println("Key is not found");
		
		
		bst.inOrder();
		bst.deleteNode(8);
		bst.inOrder();
		*/
		
		bst.DFSTraversal();
		bst.BFSTraversal();
		
		System.out.println("Height : " + bst.height());
		
		bst.deleteAll();
	}

}






