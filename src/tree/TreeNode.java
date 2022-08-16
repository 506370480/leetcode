package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        List<List<String>> list = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(this);
        while (!deque.isEmpty()) {
            List<String> nodeList = new ArrayList<>();
            int size = deque.size();
            while (size-- > 0) {
                TreeNode remove = deque.remove();
                if(remove==null){
                    nodeList.add("null");
                }else{
                    nodeList.add(String.valueOf(remove.val));
                    deque.add(remove.left);
                    deque.add(remove.right);
                }
            }
            list.add(nodeList);
        }
        list.remove(list.size()-1);
        return list.toString();
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}