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
    int[] depth;
    int[] levelArray;
    int[] max1;
    int[] max2;

    public int height(TreeNode root, int level) {
        if (root == null) {
            return 0;
        }

        levelArray[root.val] = level;
        depth[root.val] = 1 + Math.max(height(root.left, level + 1), height(root.right, level + 1));

        if (max1[level] < depth[root.val]) {
            max2[level] = max1[level];
            max1[level] = depth[root.val];
        } else if (max2[level] < depth[root.val]) {
            max2[level] = depth[root.val];
        }

        return depth[root.val];
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        depth = new int[100001];
        levelArray = new int[100001];
        max1 = new int[100001];
        max2 = new int[100001];

        height(root, 0);

        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int level = levelArray[query];

            queries[i] = (max1[level] == depth[query] ? max2[level] : max1[level]) + level - 1;
        }

        return queries;
    }
}