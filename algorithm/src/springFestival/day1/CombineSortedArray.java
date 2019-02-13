package springFestival.day1;

public class CombineSortedArray {
	
	public int[] combineSortedArrays(int[] a,int[] b){
		int[] ret = new int[a.length + b.length];
		int i=0;
		int j=0;
		int k=0;
		while(i<a.length && j<b.length){
			if(a[i] <= b[j]){
				ret[k++] = a[i++];
			}else{
				ret[k++] = b[j++];
			}
		}
		while(i<a.length){
			ret[k++] = a[i++];
		}
		while(j<b.length){
			ret[k++] = b[j++];
		}
		
		return ret;
	}
	
	public static void main(String[] args){
		int[] a = new int[]{2,3,5,7,8,10};
		int[] b = new int[]{1,6,11,18};
		CombineSortedArray csa = new CombineSortedArray();
		int[] ret = csa.combineSortedArrays(a, b);
		for(int i=0;i<ret.length;i++){
			System.err.print(ret[i] + " ");
		}
	}
}
