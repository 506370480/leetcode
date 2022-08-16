package tree;

import java.util.*;

public class DepthOfTree {
    private static int answer = 0;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(1);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);

        int i = maxDepth3(treeNode);
        System.out.println(i);


        //LinkedList即实现了List接口，又实现了Queue接口
        //这就是面向抽象编程
        Queue<String> queue = new LinkedList<>();


    }

    //给定一个二叉树，找出其最大深度。
    //有三种方法：递归、DFS（深度优先）、BFS（广度优先）
    //下边为第一种递归方法
    public static int maxDepth(TreeNode root) {
        //这个是边界条件，当=null的时候，返回0.
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }


    //下边是使用BFS的方法，使用到了Queue队列
    //Deque继承自Queue接口，可以实现双端出入
    //LinkedList即实现了List接口，又实现了Queue接口
    //这就是面向抽象编程
    public static int maxDepth1(TreeNode root){
        Deque<TreeNode> deque  = new LinkedList<>();
        deque.add(root);
        int count = 0;
        //while(deque!=null){
        //当出现的是一个类的时候，即使为空，也不应用用!=null去判断了!!!
        while(!deque.isEmpty()){
            int size = deque.size();
            while(size-->0){
                TreeNode remove = deque.remove();
                if(remove.left!=null){
                    deque.add(remove.left);
                }
                if(remove.right!=null){
                    deque.add(remove.right);
                }

            }
            count++;
        }
        return count;
    }

    //22.04.13重做此题
    //1.自顶向下的解决方案
    public static int maxDepth2(TreeNode root){
        return max_depth(root,1);
    }
    public static int max_depth(TreeNode root,int depth){
        if(root == null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            //answer是类中的公共变量，是提前定义好的，递归中不能包含变量的定义
            answer =  Math.max(depth,answer);
        }
        max_depth(root.left,depth+1);
        max_depth(root.right,depth+1);
        return answer;
    }

    //22.04.13重做，自底向上的解决方案
    public static int maxDepth3(TreeNode root){
        //边界条件
        if(root == null){
            return 0;
        }
        int left_depth = maxDepth3(root.left);
        int right_depth = maxDepth3(root.right);
        return Math.max(left_depth,right_depth)+1;
    }


}
