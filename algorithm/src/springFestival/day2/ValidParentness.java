package springFestival.day2;

/*
 * 判断括号是否有效
 */
public class ValidParentness {
	public boolean isValid(String str) {

		char[] charArray = str.toCharArray();

		java.util.Map<Character, Character> map = new java.util.HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		LinkedStack ls = new LinkedStack();
//		ArrayStack ls = new ArrayStack();

		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (c == '(' || c == '[' || c == '{') {
				ls.push(c);
			} else {
				char ch = '0';
				try{
					ch = (char) ls.pop();
					
				}catch(Exception e){
					
				}
				if (map.get(ch) == null || c != map.get(ch)) {
					return false;
				}
			}
		}
		if (ls.isEmpty())
			return true;

		return false;
	}

	public static void main(String[] args) {
		System.err.print(new ValidParentness().isValid("{(()(){}[])}"));
	}
}
