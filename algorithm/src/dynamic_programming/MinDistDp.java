package dynamic_programming;

public class MinDistDp {
	
	public static int[][] matrix = new int[][]{{1,3,5,9},{2,1,3,4},{5,2,6,7},{8,6,4,3}};
	
	public int minDistDp(int[][] matrix,int n){
		int[][] states = new int[n][n];
		int sum = 0;
		//initial first line
		for(int i=0;i<n;i++){
			sum += matrix[0][i];
			states[0][i] = sum;
		}
		//initial first column
		sum = 0;
		for(int i=0;i<n;i++){
			sum += matrix[i][0];
			states[i][0] = sum;
		}
		//other parts
		for(int i=1;i<n;i++){
			for(int j=1;j<n;j++){
				states[i][j] = matrix[i][j] + Math.min(states[i-1][j], states[i][j-1]);
			}
		}
		return states[n-1][n-1];
	}
	
	public static void main(String[] args){
		int ret = new MinDistDp().minDistDp(matrix, 4);
		System.err.println(ret);
	}
}
