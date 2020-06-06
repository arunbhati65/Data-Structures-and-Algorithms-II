import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

//1       level 1
//0 3 4   level 2
//4       level 3
//1       level 4
//2 1     level 5
//BFS print level by level
public class BFSAndDFSTraversal{
	
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

	static void doDFSTraverse(ArrayList<ArrayList<Integer>> matrix,int v,int source,Boolean [] visited){
		System.out.print(source+"-");
		visited[source]=true;
			for(int i=0;i<matrix.get(source).size();++i){
				if(matrix.get(source).size()!=0 &&
				  (visited[matrix.get(source).get(i)]==null || !visited[matrix.get(source).get(i)])){
				doDFSTraverse(matrix,v,matrix.get(source).get(i),visited);
				
			}
		}
	}

	static void DFSHandleDisconnectedCases(ArrayList<ArrayList<Integer>> matrix,int v){
		System.out.print("\nDFS traverse");
		Boolean [] visited=new Boolean[v];
		for(int source=0;source<v;++source){
			if(visited[source]==null || visited[source]==false){
			doDFSTraverse(matrix,v,source,visited);
			}
		}
	}

	public static void main(String args[]){
		int v=4;
		GraphUsingList graphUsingList=new GraphUsingList(v);
		graphUsingList.addEdge(0,1);
		graphUsingList.addEdge(1,2);
		graphUsingList.addEdge(2,0);
		graphUsingList.addEdge(2,3);
		graphUsingList.addEdge(3,3);

		graphUsingList.printMatrix();
		
		ArrayList<ArrayList<Integer>> matrix=graphUsingList.matrix;

		BFSHandleDisconnectedCases(matrix,v);

		DFSHandleDisconnectedCases(matrix,v);

		System.out.println("\nDFS from source 2");
		Boolean [] visited=new Boolean[v];
		doDFSTraverse(matrix,v,2,visited);
		
	}

}