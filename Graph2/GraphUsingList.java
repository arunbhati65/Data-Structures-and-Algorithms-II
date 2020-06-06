import java.util.ArrayList;

public class GraphUsingList{
	public static ArrayList<ArrayList<Integer>> matrix;	
	static int v;

	public GraphUsingList(int v){
		this.v=v;
		this.matrix=new ArrayList<> (v);
		for(int i=0;i<v;++i){
			this.matrix.add(new ArrayList<>());
		}
	}

	public static void addEdge(int i,int j){
		if(i>=0 && j>=0 && j<v && i<v){
			if(!matrix.get(i).contains(j)){
				matrix.get(i).add(j);
			}
			if(!matrix.get(j).contains(i)){
				matrix.get(j).add(i);
			}
			
		}
	}

	public static void addDirectedEdge(int i,int j){
		if(i>=0 && j>=0 && j<v && i<v){
			if(!matrix.get(i).contains(j)){
				matrix.get(i).add(j);
			}			
		}
	}
	public static void deleteEdge(int i,int j){
		if(i>=0 && j>=0 && j<v && i<v){
			for(int first=0;first<matrix.get(i).size();++first){
				if(matrix.get(i).get(first)==j){
					matrix.get(i).remove(first);
					break;		
				}
			}
			for(int second=0;second<matrix.get(j).size();++second){
				if(matrix.get(j).get(second)==i){
					matrix.get(j).remove(second);
					break;
				}
			}
		}
	}


	//o(n2)- brute force
	public static void printMatrix(){  
		for(int i=0;i<v;++i){
			System.out.println(matrix.get(i));
		}
	}
	
	public static void main(String args[]){
		GraphUsingList graphUsingList=new GraphUsingList(3);
		graphUsingList.addEdge(0,1);
		graphUsingList.addEdge(1,2);
		graphUsingList.addEdge(1,0);
		graphUsingList.printMatrix();
		graphUsingList.deleteEdge(1,0);
		System.out.println("after deleting");
		graphUsingList.printMatrix();

	}

}