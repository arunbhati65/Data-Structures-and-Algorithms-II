public class GraphUsingMatrix{
	public static Boolean matrix[][];
	public static int v;
	
	public GraphUsingMatrix(int v){
		this.v=v;
		this.matrix=new Boolean[v][v];
	}

	public static void addEdge(int i,int j){
		if(i>=0 && j>=0 && j<v && i<v){
			matrix[i][j]=true;
			matrix[j][i]=true;
		}
	}

	public static void removeEdge(int i,int j){
		if(i>=0 && j>=0 && j<v && i<v){
			matrix[i][j]=true;
			matrix[j][i]=true;
		}
	}
	
	public static Boolean isEdge(int i,int j){
		if(i>=0 && j>=0 && j<v && i<v){
			return matrix[i][j]=true;
		}else{
		return false;
		}
	}
	
	//o(n2)- brute force
	public static void printMatrix(){  
		for(int i=0;i<v;++i){
			for(int j=0;j<v;++j){
			System.out.print((matrix[i][j]!=null&&matrix[i][j]?1:0)+" ");			
			}
			System.out.print("\n");
		}
	}
	
	public static void main(String args[]){
		GraphUsingMatrix graphUsingMatrix=new GraphUsingMatrix(3);
		graphUsingMatrix.addEdge(1,1);
		graphUsingMatrix.printMatrix();
	}

}