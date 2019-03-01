package search;

public class StringMatch {
	
	//contains method
	public boolean isInString(String str1,String str2){
		boolean ret = false;
		int n = str1.length();
		int m = str2.length();
		
		if(n<m) return ret;
		int k = 0;
		for(int i=0;i<n-m+1;i++){
			k = 0;
			for(int j=0;j<m;j++){
			
				if(str1.charAt(i+j) != str2.charAt(j)){
					break;
				}else{
					k++;
					if(k == m){
						return ret = true;
					}
				}
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args){
		System.err.println(new StringMatch().isInString("abcd","bcr"));
		
		int tmp = 26 - 17;
		
		System.err.println(tmp);
	}
}
