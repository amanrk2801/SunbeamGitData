
public class SearchingMain {
	
	public static int linearSearch(int arr[], int key) {
		//1. traverse array from one end to another
		for(int i = 0 ; i < arr.length ; i++) {
			//2. compare current element and key
			if(key == arr[i])
				// if matching then return index of current element
				return i;
		}
		//3. if key is not found return -1
		return -1;
	}
	
	public static int binarySearch(int arr[], int key) {
		int left = 0, right = arr.length-1, mid;
		while(left <= right) {
			//1. find middle index of the array
			mid = (left + right) / 2;
			//2. compare key with middle element
			//2.1 if key is matching, return index
			if(key == arr[mid])
				return mid;
			//2.2 if key is less than middle element, search key in left partition
			else if(key < arr[mid])
				right = mid - 1;
			//2.3 if key is greater than middle element, search key in right partition
			else
				left = mid + 1;
		}//3. repeat till valid partition
		//4. if key is not found, then return -1
		return -1;
	}
	
	public static int binarySearch(int arr[], int key, int left, int right) {
		//0. stop if partition is invalid
		if(left > right)
			return -1;
		//1. find middle index
		int mid = (left + right) / 2;
		//2. compare middle element and key
		//2.1 if matching
		if(key == arr[mid])
			return mid;
		//2.2 if key is less than middle element
		else if(key < arr[mid])
			return binarySearch(arr, key, left, mid-1);
		//2.3 if key is greater than middle element
		else
			return binarySearch(arr, key, mid+1, right);
	}
	
	

	public static void main(String[] args) {
		int arr[] = {11, 22, 33, 44, 55, 66, 77, 88, 99};
		
		int index = binarySearch(arr, 25);
		if(index != -1)
			System.out.println("Key is found at index " + index);
		else
			System.out.println("Key is not found");

	}

}







