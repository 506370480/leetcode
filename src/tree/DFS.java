package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    //DFS方法
    public static List<Integer> DFS(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //isEmpty() 直接使用 elementCount 进行比较
        // empty() 会去调用 size() 获取 elementCount 的值，然后再进行比较，实际执行中 isEmpty() 会比 empty() 少一次方法调用，所以建议使用 isEmpty() 方法。
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

    //利用DFS方法求深度
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

