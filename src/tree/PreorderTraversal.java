package tree;
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
import java.util.*;

public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);
        System.out.println(preorderTraversal(treeNode));
    }

    //非递归解法
    public static List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            list.add(pop.getVal());
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return list;
    }

    //递归解法
    public  List<Integer> preorderTraversal1(TreeNode root){
        List<Integer> list = new ArrayList<>();
        preOrder(root,list);
        return list;
    }
    public void preOrder(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        list.add(root.getVal());
        preOrder(root.left,list);
        preOrder(root.right,list);
    }
}
