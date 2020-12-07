class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {
      return helper(root,0,sequence);
    }
  
    static boolean helper(TreeNode root, int index, int[] arr){
      if(root==null) return false;
      if(root.val!=arr[index]) return false;
      if(index==arr.length-1) return true;
      if(helper(root.left,index+1,arr)) return true;
      if(helper(root.right,index+1,arr)) return true;
      return false;
    }