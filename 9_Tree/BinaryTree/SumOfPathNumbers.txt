class SumOfPathNumbers {
    static int sum=0;
    public static int findSumOfPathNumbers(TreeNode root) {
      helper(root,0);
      return sum;
    }
  
    static void helper(TreeNode node,int bSum){
      if(node==null) return;
      bSum=bSum*10+node.val;
      if(node.left==null && node.right==null){
        sum=sum+bSum;
      }
      helper(node.left,bSum);
      helper(node.right,bSum);
    }