package tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchtree {
    List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);


    }

    //这个是最容易想到的递归算法，但是这样判断是不对的，忽略了一个每个节点的上限和下限
    public static boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left != null && root.left.val>=root.val || root.right !=null&&root.right.val<=root.val){
            return false;
        }
        return isValidBST(root.left)&&isValidBST(root.right);
    }

    //递归，传入最大最小值，获得每个数的值得范围
    //注意要用long，因为不能等于2147483647
    //Long是long的包装类
    public static boolean isValidBST1(TreeNode root,int max,int min){
        if(root==null){
            return true;
        }
        if(root.val<=min||root.val>=max){
            return false;
        }
        return isValidBST1(root.left, root.val, min)&&isValidBST1(root.right,max,root.val);
    }


    public boolean isValidBST2(TreeNode root){
        isValidBST2(root);
        System.out.println(list);
        for (int i = 1; i < list.size(); i++) {
            Integer integer = list.get(i);
            Integer integer1 = list.get(i-1);
            if(integer<=integer1){
                return false;
            }
        }
        return true;
    }

    //中序遍历递归，因为中序遍历排列出来是有序的，只需要后一个数大于前一个数
    //递归是会把所有的程序都执行一遍的，所以说这个list的定义也是会重复创建的
    public void order(TreeNode root){
        //这个是中序递归，如果要判断二叉搜索树需要进行存储
        //如何在使用递归的同时存入到数组中呢，疑惑
        if (root != null) {
            order(root.left);
            //这个是在类里边定义的，而不是在方法里边（包括main方法）
            list.add(root.val);
            order(root.right);
        }
    }


    //中序遍历非递归
}
