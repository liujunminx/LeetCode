package com.leetcode.algorithm.tree;

import java.util.LinkedList;
import java.util.List;

public class GenerateTrees {
    public List<TreeNode> generateTrees(int n){
        if (n == 0)
            return new LinkedList<TreeNode>();
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end){
            allTrees.add(null);
            return allTrees;
        }

        for (int i = start; i <= end; i++){
            // 左子树
            List<TreeNode> leftTrees = generateTrees(start, i-1);
            // 右子树
            List<TreeNode> rightTrees = generateTrees(i+1, end);
            for (TreeNode left: leftTrees){
                for (TreeNode right: rightTrees){
                    TreeNode curr = new TreeNode();
                    curr.left = left;
                    curr.right = right;
                    allTrees.add(curr);
                }
            }

        }

        return allTrees;
    }
}
