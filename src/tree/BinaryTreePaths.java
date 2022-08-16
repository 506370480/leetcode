package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//关键问题是如何新建String，如何更新String
public class BinaryTreePaths {
    static String s;
    static List<String> list;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode.setLeft(treeNode2);
        treeNode2.setLeft(treeNode4);
        treeNode.setRight(treeNode3);
        System.out.println(binaryTreePaths(treeNode));
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        if(root==null){
            return list;
        }
        s = root.val+"";
        if(root.right==null&&root.left==null){
            list.add(s);
        }
        dfs(root.left);

        s = root.val+"";
        dfs(root.right);
        return list;
    }
    public static void dfs(TreeNode root){
        if(root==null){
            return;
        }

        s+="->"+root.val;
        String sCopy = s;
        if(root.right==null&&root.left==null){
            list.add(s);
        }
        dfs(root.right);
        s = sCopy;
        dfs(root.left);


    }
}
