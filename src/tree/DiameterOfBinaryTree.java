package tree;

import java.util.LinkedList;
import java.util.Queue;

//ֱ���������������+���������-2����
//���Ǽ򵥵�������Ļ��������߽�����
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

    //ͨ�����������ҵ����
    //����϶������õݹ���
    public static int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left,right)+1;
    }
}
