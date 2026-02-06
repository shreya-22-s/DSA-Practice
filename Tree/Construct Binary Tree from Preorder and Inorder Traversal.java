class Solution {
    int idx = 0;

    public TreeNode solve(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;

        int rootval = preorder[idx++];
        TreeNode root = new TreeNode(rootval);

        int i = start;
        while (inorder[i] != rootval) i++;//find the root in inorder

        root.left = solve(preorder, inorder, start, i - 1);
        root.right = solve(preorder, inorder, i + 1, end);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, 0, inorder.length - 1);
    }
}
