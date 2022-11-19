/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int countNode=0;
    
    public void DFS(TreeNode root){
        countNode++;
        if(root.left==null && root.right==null){
        }else{
            if(root.left!=null){
                DFS(root.left);
            }
            if(root.right!=null){
                DFS(root.right);
            }
        }
    }
    
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        
        DFS(root);
        
        return countNode;
    }
}