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
    public TreeNode insertIntoBST(TreeNode root, int k) {
        if(root == null){
            TreeNode newN = new TreeNode(k);
            return newN;
        }

        if(k < root.val){
            root.left = insertIntoBST(root.left , k);
        }
        else if(k > root.val){
            root.right = insertIntoBST(root.right , k);
        }

        return root;
    }
}