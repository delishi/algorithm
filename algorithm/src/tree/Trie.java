package tree;
/**
 * TrieTree implement
 * 
 */
public class Trie {
	public static class TrieTreeNode{
		char data ;
		TrieTreeNode[] children = new TrieTreeNode[26];
		
		public TrieTreeNode(char data){
			this.data = data;
		}
		
		public boolean isEndingChar = false;
	}
	
	public TrieTreeNode root = new TrieTreeNode('/');
	
	public void insert(char[] chars){
		TrieTreeNode p = root;
		for(int i=0;i<chars.length;i++){
			int index = chars[i] - 'a';
			if(p.children[index] == null){
				TrieTreeNode newNode = new TrieTreeNode(chars[i]);
				p.children[index] = newNode;
			}
			p = p.children[index];
		}
		p.isEndingChar = true;
	}
	
	public boolean find(char[] data){
		TrieTreeNode p = root;
		for(int i=0;i<data.length;i++){
			int index = data[i] - 'a';
			if(p.children[index] == null){
				return false;
			}
			p = p.children[index];
		}
		if(p.isEndingChar) return true;
		
		return false;
	}
}
