package search;

public class BinarySearch {
	
	public int binarySearch(int[] nums,int target){
		//循环实现
		/*
		int low = 0;
		
		int high = nums.length;
		int mid = 0;
		while(low <= high){
			mid = (low + high) /2;
			if(nums[mid] == target){
				return mid;
			}else if(nums[mid] < target){
				low = mid;
			}else{
				high = mid;
			}
		}
		return mid;
		*/
		//递归实现
		int low = 0;
		int high = nums.length;
		return binarySearch(nums,low,high,target);
		
	}
	
	private int binarySearch(int[] nums,int low,int high,int target){

		int mid = (low+high)/2;
		if(nums[mid] == target){
			return mid;
		}else if(nums[mid] < target){
			return binarySearch(nums,mid,high,target);
		}else{
			return binarySearch(nums,low,mid,target);
		}
	}
	
	public static void main(String[] args){
		int ret = new BinarySearch().binarySearch(new int[]{8,11,19,23,27,33,45,55,67,98}, 98);
		System.err.println(ret);
	}
}
