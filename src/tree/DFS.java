package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    //DFS����
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

    //����DFS���������
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

