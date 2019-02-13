package sort;

import java.util.LinkedList;

/*
 * 拓扑排序
 */
public class TuopuSort {
	static class Graph{
		//顶点
		public int v = 0;
		//边
		public LinkedList<Integer>[] adj;
		
		public Graph(int v){
			this.v = v;
			adj = new LinkedList[v];
			for(int i=0;i<v;i++){
				adj[i] = new LinkedList<Integer>();
			}
		}
		//s 先于 t，边 s->t
		public void addEdge(int s , int t){
			adj[s].add(t);
		}
	}
	
	public void topoSortByKahn(Graph graph){
		
		int v = graph.v;
		LinkedList<Integer>[] adj = graph.adj;
		//统计每个顶点的入度
		int[] inDegrees = new int[graph.v];
		for(int i=0;i<graph.v;i++){
			for(int j=0;j<adj[i].size();j++){
				int w = adj[i].get(j);
				inDegrees[w] ++;
			}
		}        
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<v;i++){
			if(inDegrees[i] == 0){
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()){
			int i = queue.remove();
			System.err.print("->" + i);
			for(int j=0;j<adj[i].size();j++){
				int k = adj[i].get(j);
				inDegrees[k] --;
				if(inDegrees[k] == 0){
					queue.add(k);
				}
			}
		}
	}
	
	public static void main(String[] args){
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(3, 2);
		graph.addEdge(2, 4);
		
		new TuopuSort().topoSortByKahn(graph);
	}
}
