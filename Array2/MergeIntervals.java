//Given a collection of intervals, merge all overlapping intervals.
class PairComparator implements Comparator<int[]>{ 
    public int compare(int[] p1, int[] p2) { 
        return p1[0]-p2[0];
    } 
} 
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0) return intervals;
        Arrays.sort(intervals,new Comparator<int[]>(){
            public int compare(int[] ob1,int[] ob2){
                return ob1[0]-ob2[0];
            }
        });
        LinkedList<int[]> list=new LinkedList<>();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;++i){
            if(list.get(list.size()-1)[1]>=intervals[i][0]){
                list.get(list.size()-1)[1]=Math.max(intervals[i][1],list.get(list.size()-1)[1]);
            }else{
                list.add(intervals[i]);    
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}