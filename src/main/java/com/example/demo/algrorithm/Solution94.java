package com.example.demo.algrorithm;

import java.util.ArrayList;
import java.util.List;

class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    public class TreeNode {
        private TreeNode left;
        private TreeNode right;
        private Integer val;
    }


    public void helper2(TreeNode root, List<Integer> res) {
        if (root.left != null) {
            helper2(root.left, res);
        }
        res.add(root.val);
        if (root.right != null) {
            helper2(root.right, res);
        }

    }


}

