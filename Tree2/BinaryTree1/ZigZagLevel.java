class ZigZagLevel{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new LinkedList<>();
        if(root ==null) return result;
        Stack<TreeNode> LtR = new Stack<>();
        Stack<TreeNode> RtL = new Stack<>();
        LtR.push(root);
        Boolean leftToRight=true;
        TreeNode curr=null;
        while(!LtR.isEmpty() || !RtL.isEmpty()){
            if(leftToRight){
               LinkedList<Integer> level=new LinkedList<>();
               while(!LtR.isEmpty()){
                  curr= LtR.pop();
                  if(curr!=null){
                      level.add(curr.val);
                      if(curr.left!=null) RtL.add(curr.left);
                      if(curr.right!=null) RtL.add(curr.right); 
                  } 
               }     
               result.add(level); 
            }else{
                LinkedList<Integer> level=new LinkedList<>();
                while(!RtL.isEmpty()){
                  curr= RtL.pop();
                  if(curr!=null){
                      level.add(curr.val);
                      if(curr.right!=null) LtR.add(curr.right);
                      if(curr.left!=null) LtR.add(curr.left); 
                  }    
               }
                result.add(level);
            }
            leftToRight=!leftToRight;
        }
        return result;
    }
}