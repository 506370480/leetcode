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

    //������������뵽�ĵݹ��㷨�����������ж��ǲ��Եģ�������һ��ÿ���ڵ�����޺�����
    public static boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left != null && root.left.val>=root.val || root.right !=null&&root.right.val<=root.val){
            return false;
        }
        return isValidBST(root.left)&&isValidBST(root.right);
    }

    //�ݹ飬���������Сֵ�����ÿ������ֵ�÷�Χ
    //ע��Ҫ��long����Ϊ���ܵ���2147483647
    //Long��long�İ�װ��
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

    //��������ݹ飬��Ϊ����������г���������ģ�ֻ��Ҫ��һ��������ǰһ����
    //�ݹ��ǻ�����еĳ���ִ��һ��ģ�����˵���list�Ķ���Ҳ�ǻ��ظ�������
    public void order(TreeNode root){
        //���������ݹ飬���Ҫ�ж϶�����������Ҫ���д洢
        //�����ʹ�õݹ��ͬʱ���뵽�������أ��ɻ�
        if (root != null) {
            order(root.left);
            //�����������߶���ģ��������ڷ�����ߣ�����main������
            list.add(root.val);
            order(root.right);
        }
    }


    //��������ǵݹ�
}
