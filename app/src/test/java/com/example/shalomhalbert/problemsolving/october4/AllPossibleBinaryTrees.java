package com.example.shalomhalbert.problemsolving.october4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleBinaryTrees {



    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) {
            return res;
        }
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }

        N = N - 1;
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode nl : left) {
                for (TreeNode nr : right) {
                    TreeNode cur = new TreeNode(0);
                    cur.left = nl;
                    cur.right = nr;
                    res.add(cur);
                }
            }
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
//        List<List<Integer>> result = new ArrayList<>();
//        List<TreeNode> augs = allPossibleFBT(7);
//        for (TreeNode root : augs) {
//            List<Integer> r = new ArrayList<>();
//            r.add(root.val);
//            preOrder(r, root);
//            result.add(r);
//        }
//        int pause = 0;

        String i = Integer.valueOf(-1).toString();
        int pause = 0;
    }

    private void preOrder(List<Integer> r, TreeNode root) {
        if (root.left == null && root.right == null) {
            r.add(null);
            r.add(null);
            return;
        }
        r.add(root.left.val);
        r.add(root.right.val);

        preOrder(r, root.left);
        preOrder(r, root.right);
    }

}
