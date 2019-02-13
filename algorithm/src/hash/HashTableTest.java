package hash;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 1. 假设我们有 10 万条 URL 访问日志，如何按照访问次数给 URL 排序？
 * 2. 有两个字符串数组，每个数组大约有 10 万条字符串，如何快速找出两个数组中相同的字符串？
 * @author shixianhe
 *
 */

public class HashTableTest {

	public String[] init() {
		String[] log = new String[100];
		Random r = new Random();
		for (int i = 0; i < log.length; i++) {
			int tmp = r.nextInt(100);
			log[i] = "www.google" + tmp + ".com";
		}

		return log;
	}

	//question 1
	public Map<String, Integer> sortUrl(String[] url) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < url.length; i++) {
			if (map.containsKey(url[i])) {
				map.put(url[i], map.get(url[i]) + 1);
			} else {
				map.put(url[i], 1);
			}
		}
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}

		});
		Map<String, Integer> map2 = new LinkedHashMap<String, Integer>();

		for (Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();) {
			Map.Entry<String, Integer> entry = iter.next();
			map2.put(entry.getKey(), entry.getValue());
		}

		return map2;
	}
	
	//question 2
	public Collection<String> findSameStrings(String[] str1,String[] str2){
		
		Map<Integer,String> map1 = new HashMap<Integer,String>();
		Map<Integer,String> retMap = new HashMap<Integer,String>();
		for(int i=0;i<str1.length;i++){
			map1.put(i, str1[i]);
		}
		for(int i=0;i<str2.length;i++){
			if(map1.containsValue(str2[i])){
				retMap.put(i, str2[i]);
			}
		}
		
		return retMap.values();

	}

	public static void main(String[] args) {
		/*
		HashTableTest htt = new HashTableTest();
		String[] log = htt.init();
		for (int i = 0; i < log.length; i++) {
			System.err.println(log[i]);
		}
		System.err.println("==========================");
		Map<String, Integer> map = htt.sortUrl(log);
		for (Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator(); iter.hasNext();) {
			Map.Entry<String, Integer> entry = iter.next();
			System.err.print(entry.getKey() + " , " + entry.getValue());
			System.err.println();
		}
		*/
		HashTableTest htt = new HashTableTest();
		String[] str1 = {"china","Jap","an1","US","EU","Korea"};
		String[] str2 = {"china1","Jap","an","US1","EU","Korea"};
		Collection<String> retList = htt.findSameStrings(str1, str2);
		for(Iterator iter=retList.iterator();iter.hasNext();){
			System.err.println(iter.next());
		}
	}
}
