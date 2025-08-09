
public class Tester {

	public static void main(String[] args) {
		
		List l1 = new List();
		
		l1.addFirst(40);
		l1.addFirst(30);
		l1.addFirst(20);
		l1.addFirst(10);
		
		l1.addLast(50);
		l1.addLast(60);
		
		l1.deleteFirst();
		l1.deleteLast();
		
		l1.fDisplay();
		l1.rDisplay();
	}

}
