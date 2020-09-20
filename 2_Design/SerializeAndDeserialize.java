/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null ) return "";
        StringBuilder sb=new StringBuilder();
        helper(sb,root);
        return sb.toString().trim();
    }
    
    void helper(StringBuilder sb,TreeNode root){
        if(root==null){
            sb.append("null ");
            return;
        }
        sb.append(root.val+" ");
        helper(sb,root.left);
        helper(sb,root.right);
    }
    
    

    // Decodes your encoded data to tree.
    //1 2 null null 3 4 null null 5 null null
    int i=-1;
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String[] dataS=data.split(" ");
        for(String str:dataS){
            System.out.print(str+" ");    
        }
        TreeNode head=null;
        head=helperC(head,dataS);
        return head;
    }
    
    TreeNode helperC(TreeNode head,String[] dataS){
        ++i;
        if(i==dataS.length) return null;
        if(dataS[i].equals("null")){
            head=null;
            return null;
        }else{
            head=new TreeNode(Integer.parseInt(dataS[i]));
        }
        head.left=helperC(head.left,dataS);
        head.right=helperC(head.right,dataS);
        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
