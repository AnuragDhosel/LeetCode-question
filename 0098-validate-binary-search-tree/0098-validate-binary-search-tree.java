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
    long currNo = Long.MIN_VALUE;
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        InOrder(root);
        return ans;
    }
    public void InOrder(TreeNode root){
        if(root == null) return;

        InOrder(root.left);

        if(root.val > currNo) currNo = root.val;
        else ans = false;

        InOrder(root.right);
    }
}