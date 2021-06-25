package BinarySearchTree;

public class BinarySearch{
	
	
	public static void main(String args[]) {
		
		
		 int [] list = new int [] {1,3,6,10,12,15,19,21,25,28,34,47,50,53,59,61};
		 int target = 47;
		 System.out.println(binarySearch(list,target));

	}
	
	public static int binarySearch(int [] array, int target) {
		
		
		int first = 0;
		int last = array.length - 1;
		int middle = 0;
		
		while(first <= last) {
			
		
			middle = first + (last - first)/2;
			
			if(array[middle] == target) {
				
				return array[middle];
			}
			
			if(target < array[middle]) {
				
				last = middle - 1;
			}
			else {
				
				first = middle + 1;
			}
			
		
		}
		
		return -1;
	}
	
	
}
