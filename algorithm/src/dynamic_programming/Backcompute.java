package dynamic_programming;
/**
 * 0-1背包问题
 * 回溯解法
 * @author shixianhe
 *背包最大重量9
 *最多5件
 *物品重量2 2 4 6 3
 */
public class Backcompute {
	
	
	// 回溯算法实现。注意：我把输入的变量都定义成了成员变量。
	private int maxW = Integer.MIN_VALUE; // 结果放到 maxW 中
	private int[] weight = {2,2,6,4,2,2};  // 物品重量
	private int n = 6; // 物品个数
	private int w = 9; // 背包承受的最大重量
	public void f(int i, int cw) { // 调用 f(0, 0)
	  if (cw >= w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
	    if (cw > maxW) maxW = cw;
	    return ;
	  }
	  f(i+1, cw); // 选择不装第 i 个物品
	  if (cw + weight[i] <= w) {
	    f(i+1,cw + weight[i]); // 选择装第 i 个物品
	  }
	}

	public static void main(String[] args){
		Backcompute bc = new Backcompute();
		bc.f(0, 0);
		System.err.println(bc.maxW);
	}
}
