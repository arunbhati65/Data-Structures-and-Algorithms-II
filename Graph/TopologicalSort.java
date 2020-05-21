import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class TopologicalSort{

	static void doBFSTraverseTopologicalSort(ArrayList<ArrayList<Integer>> matrix,int v){
		System.out.print("BFS traverse - Topological Sort - Khann Algorithm");
		Integer [] indegree=new Integer [v];
		for(int i=0;i<indegree.length;++i){
			indegree[i]=0;
		}
		for(int i=0;i<indegree.length;++i){
			for(int j=0;j<matrix.get(i).size();++j){
				indegree[matrix.get(i).get(j)]++;	
			}
		}
		Queue<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<v;++i){
			if(indegree[i]==0){
				q.add(i);			
			}
		}

		while(!q.isEmpty()){
			int u=q.poll();
			System.out.print(u+"-> ");
			for(int i=0;i<matrix.get(u).size();++i){
				indegree[matrix.get(u).get(i)]--;
				if(indegree[matrix.get(u).get(i)]==0){
					q.add(matrix.get(u).get(i));
				}
			}
		}
	}

	public static void main(String args[]){
		int v=6;
		GraphUsingList g=new GraphUsingList(v);

 	          g.addDirectedEdge(5, 2); 
      		  g.addDirectedEdge(5, 0); 
      		  g.addDirectedEdge(4, 0); 
      		  g.addDirectedEdge(4, 1); 
      		  g.addDirectedEdge(2, 3); 
      		  g.addDirectedEdge(3, 1);

		g.printMatrix();
		
		ArrayList<ArrayList<Integer>> matrix=g.matrix;

		doBFSTraverseTopologicalSort(matrix,v);
	}

}