/*
Given two binary search trees, return True if and only if there is a node in the first tree and a node in the second tree whose values sum up to a given integer target.
 */
class Solution {
    Boolean ans=false;
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        dfs(root1,root2,target);
        return ans;
    }
    void dfs(TreeNode root1, TreeNode root2,int target){
        if(root1==null || ans) return;
        dfs(root1.left,root2,target);
        BFSSearch(root2,target-root1.val);
        dfs(root1.right,root2,target);
    }
    
    void BFSSearch(TreeNode root2,int target){
        if(root2==null) return ;
        if(root2.val==target) {
            ans=true;
            return;
        }else if(target<root2.val){
            BFSSearch(root2.left,target);
        }else{
            BFSSearch(root2.right,target);
        }
    }
}