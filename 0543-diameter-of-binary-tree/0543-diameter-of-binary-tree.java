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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter-1;
    }
    public int helper(TreeNode node){
        if(node == null) return 0;

        int leftH = helper(node.left);
        int rightH = helper(node.right);

        int dia = leftH + rightH + 1;
        diameter = Math.max(diameter , dia);

        return Math.max(leftH , rightH) + 1; // height of current node
    }
}