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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode curr = q.remove();
                temp.add(curr.val);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            
            if(level % 2 == 0){ // save in same order
                list.add(temp);
            }
            else{ // save in opposite order
                int i=0 , j=temp.size()-1;
                while(i<j){
                    int t = temp.get(i);
                    temp.set(i , temp.get(j));
                    temp.set(j , t);
                    i++;
                    j--;
                }
                list.add(temp);
            }
            level++;
        }
        return list;
    }
}