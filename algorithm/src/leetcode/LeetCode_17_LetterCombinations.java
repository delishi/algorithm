package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_17_LetterCombinations {

	public List<String> letterCombinations(String digits) {
		if(digits.length() == 0){
			return null;
		}
		List<String> list = new ArrayList<String>();
		for(int i=0;i<digits.length();i++){
			switch(digits.substring(i, i+1)){
				case "2": list.add("abc"); break;
				case "3": list.add("def"); break;
				case "4": list.add("ghi"); break;
				case "5": list.add("jkl"); break;
				case "6": list.add("mno"); break;
				case "7": list.add("pqrs"); break;
				case "8": list.add("tuv"); break;
				case "9": list.add("wxyz"); break;
			}
		}
		
		return letterCombinations(list);
	}

	public List<String> letterCombinations(List<String> digits) {
		int position = 0;	
		List<String> retList = new ArrayList<>();
		
		letterCombinationRecur(digits,position,retList,"");
		return retList;
	}
	
	public void letterCombinationRecur(List<String> digits,int position,List<String> retList,String stemp){
		if(position == digits.size() - 1){
			String tmp = digits.get(position);
			for(int i=0;i<tmp.length();i++){
				
				retList.add(stemp+tmp.substring(i, i + 1));
			}
			
		}else{
			for(int i=0;i<digits.get(position).length();i++){
				String tmp = digits.get(position);
				letterCombinationRecur(digits,position+1,retList,stemp+tmp.substring(i, i + 1));
			}
			position++;
			
		}
	}

	public static void main(String[] args) {
		List<String> retList = new LeetCode_17_LetterCombinations().letterCombinations("");
		for(int i=0;i<retList.size();i++){
			System.err.print(retList.get(i) + " ");
		}
	}
}
