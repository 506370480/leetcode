package tree;

import java.util.*;

public class SequenceTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);
        treeNode2.setLeft(treeNode4);

        List list = levelOrder(treeNode);
        System.out.println(list);
        System.out.println(DFS(treeNode));
        System.out.println(DFSDepth(treeNode));

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> nodeList = new ArrayList<>();
            int size = deque.size();
            while (size-- > 0) {
                TreeNode remove = deque.remove();
                nodeList.add(remove.val);
                if (remove.left != null) {
                    deque.add(remove.left);
                }
                if (remove.right != null) {
                    deque.add(remove.right);
                }
            }
            list.add(nodeList);
        }
        return list;
    }

    public static List<Integer> DFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //isEmpty() ֱ��ʹ�� elementCount ���бȽ�
        // empty() ��ȥ���� size() ��ȡ elementCount ��ֵ��Ȼ���ٽ��бȽϣ�ʵ��ִ���� isEmpty() ��� empty() ��һ�η������ã����Խ���ʹ�� isEmpty() ������
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return list;
    }

    public static int DFSDepth(TreeNode root) {
        int max=0;
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        stack.push(root);
        level.push(1);
       while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            int temp = level.pop();
           max = Math.max(max, temp);
           if (pop.right != null) {
                stack.push(pop.right);
                level.push(temp+1);
            }
            if (pop.left != null) {
                stack.push(pop.left);
                level.push(temp+1);
            }
        }
        return max;
    }

}
