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


        //LinkedList��ʵ����List�ӿڣ���ʵ����Queue�ӿ�
        //��������������
        Queue<String> queue = new LinkedList<>();


    }

    //����һ�����������ҳ��������ȡ�
    //�����ַ������ݹ顢DFS��������ȣ���BFS��������ȣ�
    //�±�Ϊ��һ�ֵݹ鷽��
    public static int maxDepth(TreeNode root) {
        //����Ǳ߽���������=null��ʱ�򣬷���0.
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }


    //�±���ʹ��BFS�ķ�����ʹ�õ���Queue����
    //Deque�̳���Queue�ӿڣ�����ʵ��˫�˳���
    //LinkedList��ʵ����List�ӿڣ���ʵ����Queue�ӿ�
    //��������������
    public static int maxDepth1(TreeNode root){
        Deque<TreeNode> deque  = new LinkedList<>();
        deque.add(root);
        int count = 0;
        //while(deque!=null){
        //�����ֵ���һ�����ʱ�򣬼�ʹΪ�գ�Ҳ��Ӧ����!=nullȥ�ж���!!!
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

    //22.04.13��������
    //1.�Զ����µĽ������
    public static int maxDepth2(TreeNode root){
        return max_depth(root,1);
    }
    public static int max_depth(TreeNode root,int depth){
        if(root == null){
            return 0;
        }
        if(root.left==null&&root.right==null){
            //answer�����еĹ�������������ǰ����õģ��ݹ��в��ܰ��������Ķ���
            answer =  Math.max(depth,answer);
        }
        max_depth(root.left,depth+1);
        max_depth(root.right,depth+1);
        return answer;
    }

    //22.04.13�������Ե����ϵĽ������
    public static int maxDepth3(TreeNode root){
        //�߽�����
        if(root == null){
            return 0;
        }
        int left_depth = maxDepth3(root.left);
        int right_depth = maxDepth3(root.right);
        return Math.max(left_depth,right_depth)+1;
    }


}
