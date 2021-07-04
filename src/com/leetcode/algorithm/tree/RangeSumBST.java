package com.leetcode.algorithm.tree;

import org.omg.CORBA.PUBLIC_MEMBER;

public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high){
        if (root == null)
            return 0;
        int tmp = root.val;
        if (tmp < low)
            return rangeSumBST(root.right, low, high);  
        if (tmp > high)
            return rangeSumBST(root.left, low, high);
        return rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high)+ root.val;
    }
}
