import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

//1       level 1
//0 3 4   level 2
//4       level 3
//1       level 4
//2 1     level 5
//BFS print level by level
public class BFSTraversal{
	
	static void doBFSTraverse(ArrayList<ArrayList<Integer>> matrix,int v,int source,Boolean [] visited){
		System.out.print("BFS traverse");
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(source);
		visited[source]=true;
		while(!q.isEmpty()){
			int u=q.poll();
			System.out.print(u+"-");
			for(int i=0;i<matrix.get(u).size();++i){
				if(visited[matrix.get(u).get(i)]==null || 
					!visited[matrix.get(u).get(i)]){
					q.add(matrix.get(u).get(i));
					visited[matrix.get(u).get(i)]=true;
				}
			}
		}
	}

	static void BFSHandleDisconnectedCases(ArrayList<ArrayList<Integer>> matrix,int v){
		Boolean [] visited=new Boolean[v];
		for(int source=0;source<v;++source){
			if(visited[source]==null || visited[source]==false){
			doBFSTraverse(matrix,v,source,visited);
			}
		}
	}

	public static void main(String args[]){
		int v=5;
		GraphUsingList graphUsingList=new GraphUsingList(v);
		graphUsingList.addEdge(0,1);
		graphUsingList.addEdge(1,3);
		graphUsingList.addEdge(2,4);
		graphUsingList.addEdge(3,1);
		graphUsingList.addEdge(4,1);

		graphUsingList.printMatrix();
		
		ArrayList<ArrayList<Integer>> matrix=graphUsingList.matrix;
		BFSHandleDisconnectedCases(matrix,v);
		
	}

}