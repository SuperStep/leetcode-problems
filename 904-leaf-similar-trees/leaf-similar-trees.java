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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return deep(root2).equals(deep(root1));
    }

    private List<Integer> deep(TreeNode current) {
        List<Integer> res = new ArrayList();
        if(current.left != null)
            res.addAll(deep(current.left));
        if(current.right != null)
            res.addAll(deep(current.right));
        if(current.left == null && current.right == null) {
            System.out.println(current.val);
            return List.of(current.val);
        }   
        return res;
    }
}