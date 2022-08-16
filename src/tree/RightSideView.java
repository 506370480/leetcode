package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);
        treeNode2.setLeft(treeNode4);

        System.out.println(rightSideView(treeNode));

    }

    //最直观的思路，BFS
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while(size-->0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                if(size==0){
                    list.add(poll.val);
                }
            }
        }
        return list;
    }

    //使用DFS
    public static List<Integer> rightSideView1(TreeNode root){
        dfs(root,0);
        return list;
    }
    public static void dfs(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if(depth==list.size()){
            list.add(root.val);
        }
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }
}
