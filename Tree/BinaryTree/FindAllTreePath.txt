class FindAllTreePaths {
    static List<List<Integer>> allPaths = new ArrayList<>();
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
      
      helper(root,sum,new LinkedList());
      return allPaths;
    }
  
    static void helper(TreeNode node,int sum,LinkedList<Integer> list){
      if(node==null){
        return;
      }
      if(node.val==sum){
        list.add(node.val);
        allPaths.add(new ArrayList<>(list));
        list.remove(list.size()-1);
        return;
      }
      list.add(node.val);
      helper(node.left,sum-node.val,list);
      helper(node.right,sum-node.val,list);
      list.remove(list.size()-1);
    }