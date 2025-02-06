class Dijikstra
public static void main(String[] args){
        int[][] graph= {{0,2,4,0,0,0},  //zero means no edge,+ve value means weight of the edge 
                        {0,0,1,7,0,0},
                        {0,0,0,0,3,0},
                        {0,0,0,0,0,1},
                        {0,0,0,2,0,5},				
                        {0,0,0,0,0,0}};
        Integer[] dist=new Integer[graph.length];
        dist[source]=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>(){
                public int compare(Integer ob1,Integer ob2){
                    int d1=	dist[ob1]==null?Integer.MAX_VALUE:dist[ob1];
                    int d2=	dist[ob2]==null?Integer.MAX_VALUE:dist[ob2];
                    return d1-d2;
                }});

        Set<Integer> map=new HashSet<Integer>();
        for(int i=0;i<graph.length;++i){
            map.add(i);
            pq.add(i);			
        }
        while(!pq.isEmpty()){
            int u=pq.peek();
            System.out.print(u);
            map.remove(u);			
            for(int v=0;v<graph.length;++v){
                if(graph[u][v]!=0){
                    dist[v]=Math.min(dist[v]==null? Integer.MAX_VALUE:dist[v],dist[u]+graph[u][v]);					
                }
            }
            int removed=pq.poll();
        }
        System.out.println(dist);
 }
