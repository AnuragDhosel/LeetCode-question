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
    TreeNode previ = null;
    TreeNode incorr1 = null;
    TreeNode incorr2 = null;
    public void recoverTree(TreeNode root) {
        // 1. find incorrect node
        findIncorrectNode(root);

        // swap by value only
        int temp = incorr1.val;
        incorr1.val = incorr2.val;
        incorr2.val = temp;
    }

    private void findIncorrectNode(TreeNode root){
        if(root == null) return;

        findIncorrectNode(root.left);

        if(previ != null && root.val <= previ.val){
            if(incorr1 == null){
                incorr1 = previ;
                incorr2 = root;
            }
            else incorr2 = root;
        }
        previ = root;

        findIncorrectNode(root.right);
    }
}