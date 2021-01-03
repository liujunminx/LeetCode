package com.leetcode.algorithm.twopointers;

import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.*;

/**
 * 在所有数组中返回三个数和为0的三个数，并且不重复
 */
public class ThreeSum {
    class node {
        int i, j, k;

        public node(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }

        public boolean equals(Object cur) {
            if (this == cur) return true;
            node n1 = (node) cur;
            if (this.i == n1.i && this.j == n1.j && this.k == n1.k) return true;
            return false;
        }

        @Override
        public int hashCode() {
            return ((this.i) * 100 + (this.j) * 10 + this.k) % 1000000007;
        }

        /**
         * 排序 折半查找 封装为node类 easy-understanding
         *
         * @param n
         * @return
         */
        public List<List<Integer>> threeSum(int[] n) {
            Arrays.sort(n);
            HashSet<node> hm = new HashSet<>();
            List<List<Integer>> out = new ArrayList<>();
            for (int i = 0; i < n.length - 2; i++) {
                int target = 0 - n[i];
                int low = i + 1;
                int high = n.length - 1;
                while (low < high) {
                    if (n[low] + n[high] > target) {
                        high--;
                    } else if (n[low] + n[high] < target) {
                        low++;
                    } else {
                        if (!hm.contains(new node(n[i], n[low], n[high]))) {
                            out.add(Arrays.asList(n[i], n[low], n[high]));
                            hm.add(new node(n[i], n[low], n[high]));
                        }
                        low++;
                        high--;
                    }
                }
            }
            return out;
        }
    }
}
