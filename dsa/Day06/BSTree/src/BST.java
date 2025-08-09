import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
	static class Node{
		private int data;
		private Node left, right;
		
		public Node(int value) {
			data = value;
			left = right = null;
		}
	}
	
	private Node root;
	
	public BST() {
		root = null;
	}
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void addNode(int value) {
		//1. create a newnode
		Node newnode = new Node(value);
		//2. if BST is empty
		if(root == null)
			// add newnode into root itself
			root = newnode;
		//3. if BST is not empty
		else {
			//3.1 create trav and start it on root node
			Node trav = root;
			while(true) {
				//3.2 if value is less than current node data
				if(value < trav.data) {
					//3.2.1 if left of current node is empty
					if(trav.left == null) {
						// add newnode into left of current node
						trav.left = newnode;
						break;
					}
					//3.2.2 if left of current node is not empty
					else
						// go on left side
						trav = trav.left;
				}
				//3.3 if value is greater or equal than current node data
				else {	
					//3.3.1 if right of current node is empty
					if(trav.right == null) {
						// add newnode into right of current node
						trav.right = newnode;
						break;
					}
					//3.3.2 if right of current node is not empty
					else
						// go on right side
						trav = trav.right;
				}
			}//3.4 repeat above two steps till node is not added into BST
		}
	}
	
	private void preOrder(Node trav) {
		// stop is trav is null (if tree is empty)
		if(trav == null)
			return;
		System.out.print(" " + trav.data);	// V
		preOrder(trav.left);	// L
		preOrder(trav.right);	// R
	}
	
	// wrapper method
	public void preOrder() {
		System.out.println("Pre Order : ");
		preOrder(root);
		System.out.println("");
	}
	
	private void inOrder(Node trav) {
		// stop is trav is null (if tree is empty)
		if(trav == null)
			return;
		inOrder(trav.left);		// L
		System.out.print(" " + trav.data);	// V
		inOrder(trav.right);	// R
	}
	
	public void inOrder() {
		System.out.println("In Order : ");
		inOrder(root);
		System.out.println("");
	}
	
	private void postOrder(Node trav) {
		// stop is trav is null (if tree is empty)
		if(trav == null)
			return;
		postOrder(trav.left);		// L
		postOrder(trav.right);	// R
		System.out.print(" " + trav.data);	// V
	}
	
	public void postOrder() {
		System.out.println("Post Order : ");
		postOrder(root);
		System.out.println("");
	}
	
	public boolean binarySearch(int key) {
		//1. start from root
		Node trav = root;
		while(trav != null) {
			//2. if key is matching with current node
			if(key == trav.data)
				return true;
			//3. if key is less than current node then search it into left sub tree
			else if(key < trav.data)
				trav = trav.left;
			//4. if key is greater than current node then searchi it into right sub tree
			else
				trav = trav.right;
		}//5. repeat till leaf node
		//6. if key is not found
		return false;
	}
	
	public void deleteNode(int key) {
		//1. search node along with its parent
		Node trav = root;
		Node parent = null;
		while(trav != null) {
			if(key == trav.data)
				break;
			parent = trav;
			if(key < trav.data)
				trav = trav.left;
			else
				trav = trav.right;
		}
		//2. if key is not found
		if(trav == null)
			return;
		//3. if node has two child
		if(trav.left != null && trav.right != null) {
			//a. find predecessor
			Node pred = trav.left;
			parent = trav;
			while(pred.right != null) {
				parent = pred;
				pred = pred.right;
			}
			//b. replace data by predecessor data
			trav.data = pred.data;
			//c. delete predecessor
			trav = pred;
		}		
		//4. if node has single child (left child)
		if(trav.left != null) {
			if(trav == root)
				root = trav.left;
			else if(trav == parent.left)
				parent.left = trav.left;
			else if(trav == parent.right)
				parent.right = trav.left;
		}
		//5. if node has single child (right child)
		else//if(trav.right != null) {
		{
			if(trav == root)
				root = trav.right;
			else if(trav == parent.left)
				parent.left = trav.right;
			else if(trav == parent.right)
				parent.right = trav.right;
		}
	}
	
	public void DFSTraversal() {
		//0. create stack to push nodes
		Stack<Node> st = new Stack<BST.Node>();
		//1. push root node on stack
		st.push(root);
		System.out.println("DFS Traversal : ");
		while(!st.isEmpty()) {
			//2. pop from stack
			Node trav = st.pop();
			//3. print popped node
			System.out.print(" " + trav.data);
			//4. if right exists, push it
			if(trav.right != null)
				st.push(trav.right);
			//5. if left exists, push it
			if(trav.left != null)
				st.push(trav.left);
		}//6. repeat till stack is not empty
		System.out.println("");
	}
	
	public void BFSTraversal() {
		//0. create queue to push nodes
		Queue<Node> q = new LinkedList<BST.Node>();
		//1. push root node on queue
		q.offer(root);
		System.out.println("BFS Traversal : ");
		while(!q.isEmpty()) {
			//2. pop from queue
			Node trav = q.poll();
			//3. print popped node
			System.out.print(" " + trav.data);
			//4. if left, push it
			if(trav.left != null)
				q.offer(trav.left);
			//5. if right, push it
			if(trav.right != null)
				q.offer(trav.right);
		}//6. repeat till queue is not empty
		System.out.println("");
	}
	
	private int height(Node trav) {
		//1. if empty tree, return -1
		if(trav == null)
			return -1;
		//2. find height of left sub tree
		int hl = height(trav.left);
		//3. find height of right sub tree
		int hr = height(trav.right);
		//4. find max height
		int max = hl > hr ? hl : hr;
		//5. return max height + 1
		return max + 1;
	}
	
	public int height() {
		return height(root);
	}
	
	public void deleteAll() {
		root = null;
	}
	
}





















