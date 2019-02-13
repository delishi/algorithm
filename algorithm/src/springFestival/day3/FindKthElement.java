package springFestival.day3;
/**
 * O(n)时间复杂度找到数组中第K大元素
 * @author shixianhe
 *
 */
public class FindKthElement {
	public int findKthElement(int[] a,int k){
		
		int n = a.length;
		
		return find(a,0,n-1,k);
	}
	
	public int find(int[] a,int p,int r,int k){
		int q = partition(a,p,r);
		if(q+1 == k){
			return a[q];
		}else if(q+1 > k){
			q = find(a,p,q-1,k);
		}else{
			q = find(a,q+1,r,k);
		}
		return q;
	}
	
	private int partition(int[] nums, int p, int r) {
		// we usually use the last element as the pivot
		int pivot = nums[r];
		int i = p;
		// temporary variable
		int tmp = 0;
		for (int j = p; j < r; j++) {
			if (nums[j] < pivot) {
				tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
				i++;
			}
		}
		tmp = nums[i];
		nums[i] = nums[r];
		nums[r] = tmp;
		return i;
	}
	
	public static void main(String[] args){
		int[] a = new int[]{6,11,3,9,8};
		System.err.println(new FindKthElement().findKthElement(a,5));
//		System.err.println(new FindKthElement().partition(new int[]{6,3,8,9,11}, 0, 2));
	}
}
