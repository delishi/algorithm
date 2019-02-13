package springFestival.day2;
/**
 * 实现浏览器的前进后退
 * @author shixianhe
 *
 */
public class BrowserOp {
	
	public ArrayStack as1 = new ArrayStack();
	public ArrayStack as2 = new ArrayStack();
	
	public int forward(){
		int cur = as2.pop();
		as1.push(cur);
		return cur;
	}
	
	public int backward(){
		int cur = as1.pop();
		as2.push(cur);
		return cur;
	}
	
	public void init(){
		as1.push(1);
		as1.push(2);
		as1.push(3);
	}
	
	public static void main(String[] args){
		BrowserOp bo = new BrowserOp();
		bo.init();
		bo.backward();
		bo.backward();
		bo.forward();
		bo.forward();
//		System.err.println(bo.backward());
		
		bo.as1.traverse();
		
		bo.as2.traverse();
	}
}
