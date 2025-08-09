package com.sunbeam;

public class Heap {
	private int arr[];
	private int SIZE;
	public Heap(int length) {
		arr = new int[length + 1];
		SIZE = 0;
	}
	
	public void add(int value) {
		//1. increase size of heap by one
		SIZE++;
		//2. add value at first empty location of array from left side
		arr[SIZE] = value;
		//3. adjust position of newly added element by comparing it with all its ancestors
		//3.1 find index of newly added element and its parent
		int ci = SIZE;
		int pi = ci / 2;
		while(pi >= 1) {
			//3.2 if parent is already greater than its child
			if(arr[pi] > arr[ci])
				break;
			//3.3 if parent is less than its child, swap parent and child
			int temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci] = temp;
			//3.4 update indices of parent and child
			ci = pi;
			pi = ci / 2;
		}
	}
	
	public int delete() {
		//1. take backup of max element of heap (root)
		int max = arr[1];
		//2. add last element of heap at root position
		arr[1] = arr[SIZE];
		//3. decrease size of heap by one
		SIZE--;
		//4. adjust position of root by comparing it with all its descendents
		//4.1 find indices of parent and child
		int pi = 1;
		int ci = pi * 2;
		while(ci <= SIZE) {
			//4.2 find index if max child
			if((ci + 1) <= SIZE &&  arr[ci + 1] > arr[ci])
				ci = ci + 1;
			//4.3 if max child is already less than parent
			if(arr[ci] < arr[pi])
				break;
			//4.4 if max child is greater than parent, then swap parent and child
			int temp = arr[pi];
			arr[pi] = arr[ci];
			arr[ci] = temp;
			//4.5 update parent and child indices
			pi = ci;
			ci = pi * 2;
		}	
		//5. return maximum element
		return max;
	}
	
	public int getRoot() {
		return arr[1];
	}
	
	public boolean isEmpty() {
		return SIZE == 0;
	}
	
	public boolean isFull() {
		return SIZE == arr.length - 1;
	}
}








