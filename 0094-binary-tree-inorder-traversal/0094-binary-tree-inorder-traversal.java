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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<Integer> ();
        inorder(root, inorder);
        return inorder;
    }

    public void inorder(TreeNode root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        inorder(root.left, inorder);
        inorder.add(root.val);
        inorder(root.right, inorder);
    }
}