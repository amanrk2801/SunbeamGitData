
public class Tester {

	public static void main(String[] args) {
		
		List list = new List();
		
		list.addFirst('n');
		list.addFirst('u');
		list.addFirst('s');
		
		list.addLast('b');
		list.addLast('e');
		list.addLast('a');
		list.addLast('m');
		
		//list.addPosition('@', 4);
		//list.addPosition('@', -1);
		//list.addPosition('@', 10);
		//list.addPosition('@', 1);
		//list.addPosition('@', 8);
		
		//list.deleteFirst();
		//list.deleteLast();
		
		//list.deletePosition(3);
		//list.deletePosition(-2);
		//list.deletePosition(100);
		//list.deletePosition(1);
		list.deletePosition(7);
		
		list.forward_display();
		list.backward_display();
		
		System.out.println("size = " + list.size());
		
		list.deleteAll();
	}

}
