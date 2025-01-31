public static boolean hasPath(TreeNode root, int sum) {
    if(root==null && sum==0) return true;
    if(root==null) return false;
    if(hasPath(root.left,sum-root.val)) return true;
    if(hasPath(root.right,sum-root.val)) return true;
    return false;
  }