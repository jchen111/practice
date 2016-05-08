package CC150;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class DirectedGraph {
	private int numberOfVertex;
	private LinkedList edges[];
	public DirectedGraph(int n){
		numberOfVertex = n;
		edges = (LinkedList<Integer>[]) new LinkedList[numberOfVertex];
		for(int i=0; i< numberOfVertex;i++){
			edges[i] = new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int v, int w){
		edges[v].add(w);
	}
	public LinkedList<Integer> adj(int v){
		return edges[v];
	}
	public int numberOfVertex(){
		return numberOfVertex;
	}
	public int numberOfEdges(){
		int count = 0;
		for(LinkedList<Integer> edge:edges){
			count+= edge.size();
		}
		return count;
	}
	public boolean hasRouteBetween(int source, int dest){
		return (reachable(this,source,dest)||reachable(this,dest,source));
	}
	private boolean reachable(DirectedGraph g, int source, int dest){
		boolean[] visited = new boolean[g.numberOfVertex()];
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(source);
		while(!stack.isEmpty()){
			int temp = stack.pop();
			visited[temp] = true;
//			Iterator<Integer> neighbors = g.adj(temp).iterator();
//			while(neighbors.hasNext()){
//				int neighbor = neighbors.next();
//				if(!visited[neighbor]){
//					if(neighbor == dest){
//						return true;
//					}
//					stack.push(neighbor);
//				}
//			}
			LinkedList<Integer> neighbors = g.adj(temp);
			for(int i=0;i<neighbors.size();i++){
				int neighbor = neighbors.get(i);
				if(!visited[neighbor]){
					if(neighbor == dest){
						return true;
					}
					stack.push(neighbor);
				}
			}
		}
		return false;
	}
	
}
