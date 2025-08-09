import java.util.Arrays;

public class Heap {
	private int SIZE;
	public Heap() {
		SIZE = 0;
	}
	
	private void create_heap(int arr[]) {
		for(int i = 1 ; i < arr.length ; i++) {
			//1. increment size of heap
			SIZE++;
			//2. add new value on first empty index from left side
			//3. adjust position of newly added element by comparing with all its ancestors
			int ci = SIZE;
			int pi = ci / 2;
			while(pi >= 1) {
				//3.1 if parent is already max
				if(arr[pi] > arr[ci])
					break;
				//3.2 if child is greater than parent
				int temp = arr[pi];
				arr[pi] = arr[ci];
				arr[ci] = temp;
				//3.3 update parent and child index
				ci = pi;
				pi = ci / 2;
			}
		}
	}
	
	private void delete_heap(int arr[]) {
		for(int i = 1 ; i < arr.length ; i++) {
			//1. swap first and last element of heap
			int max = arr[1];
			arr[1] = arr[SIZE];
			arr[SIZE] = max;
			//2. decrement size of heap by one
			SIZE--;
			//3. adjust position of root by comparing with all its descendents
			int pi = 1;
			int ci = pi * 2;
			while(ci <= SIZE) {
				//3.1 find index of max child
				if((ci + 1) <= SIZE && arr[ci + 1] > arr[ci])
					ci = ci + 1;
				//3.2 if parent is already greater than max child
				if(arr[pi] > arr[ci])
					break;
				//3.3 if max child is greater than parent
				int temp = arr[pi];
				arr[pi] = arr[ci];
				arr[ci] = temp;
				//3.4 update parent and child index
				pi = ci;
				ci = pi * 2;
			}
		}
	}
	
	public void heapSort(int arr[]) {
		//1. create heap from given array
		create_heap(arr);
		System.out.println(Arrays.toString(arr));
		//2. delete all elements from heap one by one
		delete_heap(arr);
	}

}





