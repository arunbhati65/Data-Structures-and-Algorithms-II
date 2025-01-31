/**
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory
 buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization
 algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized
 to the original tree structure.
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        return helperS(root);
    }
    
    String helperS(TreeNode root){
        String s="";
        if(root==null){
            s=s+"null,";
        }else{
            s=s+root.val+",";
            s=s+helperS(root.left);
            s=s+helperS(root.right);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    int i=0;
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        String [] arr=data.split(",");
        return helperD(arr);
    }
    
    TreeNode helperD(String[] arr){
        if(i==arr.length) return null;
        Integer val=Integer.parseInt(arr[i]);
        TreeNode root=new TreeNode(val);
        ++i;
        root.left=arr[i].equals("null")?null:helperD(arr);
        ++i;
        root.right=arr[i].equals("null")?null:helperD(arr);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));