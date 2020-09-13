
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> s1=new Stack<>();
        Stack<TreeNode> s2=new Stack<>();
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            Stack<TreeNode> curr=!s1.isEmpty()?s1:s2;
            boolean leftToRight=!s1.isEmpty();
            Stack<TreeNode> currEmpty=s1.isEmpty()?s1:s2;
            int size=curr.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;++i){
                TreeNode currNode=curr.pop();
                list.add(currNode.val);
                if(leftToRight){
                    if(currNode.left!=null) currEmpty.push(currNode.left);
                    if(currNode.right!=null) currEmpty.push(currNode.right);
                }else{
                    if(currNode.right!=null) currEmpty.push(currNode.right);  
                    if(currNode.left!=null) currEmpty.push(currNode.left);
                }

            }
            ans.add(list);
        }
        return ans;
    }
}

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