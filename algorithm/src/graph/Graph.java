package graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 无向图
 * @author shixianhe
 */
public class Graph {
	//顶点个数
	int v;
	//邻接表
	public LinkedList<Integer>[] adj;
	@SuppressWarnings("unchecked")
	public Graph(int v){
		this.v = v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int s,int t){
		adj[s].add(t);
		adj[t].add(s);
	}
	//bfs from s to t
	public void bfs(int s,int t){
		if(s == t) return;
		boolean[] visited = new boolean[v];
		visited[s] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		int[] prev = new int[v];
		for(int i=0;i<v;i++){
			prev[i] = -1;
		}
		
		while(queue.size() != 0){
			int w = queue.poll();
			for(int i=0;i<adj[w].size();i++){
				int q = adj[w].get(i);
				if(!visited[q]){
					prev[q] = w;
					if(q == t){
						print(prev,s,t);
						return;
					}
				}
				visited[q] = true;
				queue.add(q);
			}
		}
	}
	//递归打印
	public void print(int[] prev,int s,int t){
		if(prev[t] != -1 && t != s){
			print(prev,s,prev[t]);
		}
		System.err.print(t + " ");
	}
	
	public static void main(String[] args){
		Graph graph = new Graph(8);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 5);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 7);
		
		graph.bfs(0, 7);
		//expected result is : 01324567
	}
}
