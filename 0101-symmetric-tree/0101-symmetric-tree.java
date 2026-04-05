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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        else if(root.left == null && root.right == null) return true;
        else if(root.left == null || root.right == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        if(root.left.val != root.right.val) return false;
        q.add(root.left);
        q.add(root.right);
        
        while(!q.isEmpty()){
            TreeNode l = q.remove();
            TreeNode r = q.remove();

            if(l == null && r == null) continue; //iske aage ka code iske baad nhi chalega
            if(l == null || r == null) return false;
            if(l.val != r.val) return false;
            
            q.add(l.left);
            q.add(r.right);
            q.add(l.right);
            q.add(r.left);
        }

        return true;
    }
}