/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
      private TreeNode buildHelper(int[] preorder, int[] inorder, int i, int m, int n) {
        if (m + 1 == n)
            return new TreeNode(inorder[m]);
        if (m == n)
            return null;
        TreeNode node = new TreeNode(preorder[i]);
        for (int x = m; x < n; x++) {
            if (inorder[x] == preorder[i]) {
                node.left = buildHelper(preorder, inorder, i + 1, m, x);
                node.right = buildHelper(preorder, inorder, x - m + i + 1, x + 1, n);
                return node;
            }
        }
        return null;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
        return buildHelper(preorder, inorder, 0, 0, inorder.length);
    }
}
