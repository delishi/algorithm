package springFestival.day2;

public class Day2 {
	
	//recursive
	//fibo 1 1 2 3 5 8 13 21 34
	public int fibo(int n){
		if(n==1 || n==2){
			return 1;
		}
		return fibo(n-1) + fibo(n-2);
	}
	//阶乘
	public int jiecheng(int n){
		if(n == 1){
			return 1;
		}
		return n*jiecheng(n-1);
	}
	
	public static void main(String[] args){
		Day2 day2 = new Day2();
		int ret = day2.fibo(8);
		System.err.println(ret);
		
		int ret1 = day2.jiecheng(6);
		System.err.println(ret1);
	}
}
