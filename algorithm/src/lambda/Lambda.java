package lambda;

import java.util.Arrays;
import java.util.List;

public class Lambda {
	
	public static void main(String[] args){
//		
//		(String s) -> { System.out.println(s);}
		
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach(n -> System.out.println(n));
		
		FunctionInterfaceTest fit = (int x, int y)->x+y;
		
		System.err.println(fit.add(3, 4));
		
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		costBeforeTax.stream().map((cost) -> cost + cost*0.12).forEach(System.out::println);
		
	}
}
