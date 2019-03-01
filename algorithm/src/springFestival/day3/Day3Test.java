package springFestival.day3;

public class Day3Test {
	public static void main(String[] args){
//		Day3Test day3 = new Day3Test();
		Sort sort = new Sort();
		int[] origin = {10,9,8,4,5,6,3,2,1};
//		sort.bubbleSort(origin);
//		sort.insertSort(origin);
//		sort.selectSort(origin);
//		sort.mergeSort(origin);
		sort.quickSort(origin);
		
		for(int i=0;i<origin.length;i++){
			System.err.print(origin[i] + " ");
		}
		System.err.println(); 
		
		System.err.println(new BinarySearch().opaque_search(new int[]{1,2,3,5,6,7,8,9},4));
//		System.err.println(new BinarySearch().search_recursive(new int[]{1,2,3,5,6,7,8,9},4));
	}
}
