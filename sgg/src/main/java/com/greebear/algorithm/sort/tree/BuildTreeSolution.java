package com.greebear.algorithm.sort.tree;

import java.util.HashMap;


class BuildTreeSolution {
    //利用原理,先序遍历的第一个节点就是根。在中序遍历中通过根 区分哪些是左子树的，哪些是右子树的
    //左右子树，递归
    HashMap<Integer, Integer> map = new HashMap<>();//标记中序遍历
    int[] preorder;//保留的先序遍历

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursive(0,preorder.length-1);
    }

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    /**
//     * @param pre_root_idx  先序遍历的索引
//     * @param in_left_idx  中序遍历的索引
//     * @param in_right_idx 中序遍历的索引
//     */

    public TreeNode recursive(int left_idx, int right_idx) {
        //相等就是自己
        if (left_idx > right_idx) {
            return null;
        }
        //root_idx是在先序里面的
        System.out.println(preorder[left_idx]);
        TreeNode root = new TreeNode(preorder[left_idx]);
        // 有了先序的,再根据先序的，在中序中获 当前根的索引
        int in_root = map.get(preorder[left_idx]);

        //左子树的根节点就是 左子树的(前序遍历）第一个，就是+1,左边边界就是left，右边边界是中间区分的idx-1
        root.left = recursive(left_idx + 1, in_root);

        //由根节点在中序遍历的idx 区分成2段,idx 就是根

        //右子树的根，就是右子树（前序遍历）的第一个,就是当前根节点 加上左子树的数量
        // pre_root_idx 当前的根  左子树的长度 = 左子树的左边-右边 (idx-1 - in_left_idx +1) 。最后+1就是右子树的根了
        if (root.left!=null)
            root.right = recursive(in_root + 1, right_idx);
        return root;
    }

    public static void main(String[] args)
    {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BuildTreeSolution buildTreeSolution = new BuildTreeSolution();
        TreeNode root = buildTreeSolution.buildTree(preorder, inorder);

    }
}