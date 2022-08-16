package tree;

import java.util.LinkedList;
import java.util.Queue;

//直径等于左子树深度+右子树深度-2即可
//但是简单的这样算的话会遇到边界问题
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);

        System.out.println(depth(treeNode));

    }
    public static int diameterOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return 0;
        }
        int max  = 0;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            if(poll.right!=null){
                queue.add(poll.right);
            }
            if(poll.left!=null){
                queue.add(poll.left);
            }
            max = Math.max(max,depth(poll.left)+depth(poll.right));
        }
        return max;
    }

    //通过遍历求左右的深度
    //这里肯定不能用递归了
    public static int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left,right)+1;
    }
}
