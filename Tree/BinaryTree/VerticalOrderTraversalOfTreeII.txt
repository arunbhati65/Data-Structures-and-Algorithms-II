/*//987. Vertical Order Traversal of a Binary Tree
Given a binary tree, return the vertical order traversal of its nodes values.
For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
*/
class Solution {
    int leftMostOrder=Integer.MAX_VALUE,rightMostOrder=Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result=new LinkedList<>();
        if(root==null) return result;
        HashMap<Integer,List<Pair<Integer,Integer>>> map=new HashMap<>();
        helper(map,root,0,0);
        
        return getListFromMap(map,result);
    }
    
    List<List<Integer>> getListFromMap(HashMap<Integer,List<Pair<Integer,Integer>>> map,List<List<Integer>> result){
        for(int i=leftMostOrder;i<=rightMostOrder;++i){
            Collections.sort(map.get(i),new Comparator<Pair<Integer,Integer>>(){
                @Override
                public int compare(Pair<Integer,Integer> ob1,Pair<Integer,Integer> ob2){
                    if(ob1.getKey().equals(ob2.getKey())){
                        return ob1.getValue()-ob2.getValue();
                    }
                    return ob1.getKey()-ob2.getKey();
                }
            });
            List<Integer> sortedListByLevel=new LinkedList<>();
            for(Pair<Integer,Integer> p:map.get(i)){
                sortedListByLevel.add(p.getValue());
            }
            result.add(sortedListByLevel);
        }
        return result;
    }
    
    void helper(HashMap<Integer,List<Pair<Integer,Integer>>> map,TreeNode root,int order,int level){
        if(root==null) return;
        leftMostOrder=Math.min(leftMostOrder,order);
        rightMostOrder=Math.max(rightMostOrder,order);
        if(map.containsKey(order)){
            map.get(order).add(new Pair<Integer,Integer>(level,root.val));
        }else{
            LinkedList<Pair<Integer,Integer>> newList=new LinkedList<>();
            newList.add(new Pair<Integer,Integer>(level,root.val));
            map.put(order,newList);
        }
        helper(map,root.left,order-1,level+1);
        helper(map,root.right,order+1,level+1);
    }
}