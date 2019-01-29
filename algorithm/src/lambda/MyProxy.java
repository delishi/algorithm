package lambda;

public class MyProxy implements Hello{
	//被代理对象
	public Hello hello;
	
	public MyProxy(Hello hello){
		this.hello = hello;
	}
	
	public void sayHello(){
		System.err.println("before");
		hello.sayHello();
		System.err.println("after");
	}
	
	public static void main(String[] args){
		Hello hello = new HelloImpl();
		MyProxy p = new MyProxy(hello);
		
		p.sayHello();
		
	}
}
