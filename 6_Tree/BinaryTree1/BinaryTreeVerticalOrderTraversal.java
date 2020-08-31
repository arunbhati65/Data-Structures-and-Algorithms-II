/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
If two nodes are in the same row and column, the order should be from left to right.
*/
class Solution {
    int leftMostOrder=Integer.MAX_VALUE,rightMostOrder=Integer.MIN_VALUE;
    public List<List<Integer>> verticalOrder(TreeNode root) {
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