package com.example.shalomhalbert.problemsolving.october2;

import org.junit.Test;

public class BinaryTreePruning {

    @Test
    public void test(){

    }

    public TreeNode pruneTree(TreeNode root) {
        prune(root);
        return root;
    }

    private void prune(TreeNode root) {
        if (root == null) {
            return;
        }

        prune(root.left);
        prune(root.right);

        if (root.val == 0 && root.left == null && root.right == null) {
            root = null;
        }
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
