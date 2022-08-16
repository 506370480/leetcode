package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Flatten {
    static List<TreeNode> list;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);
        treeNode2.setLeft(treeNode4);

        flatten(treeNode);
        System.out.println(treeNode);
    }
    public static void flatten(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        for (int i = 1;i<list.size();i++) {
            root.left = null;
            root.right = list.get(i);
            root = root.right;
        }
    }
    public static void dfs(TreeNode root){
        if(root==null) {
            return;
        }
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}
