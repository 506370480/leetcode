package tree;

import java.util.LinkedList;
import java.util.Map;

public class MaxDepth {
    static int depth;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        node.children = new LinkedList<Node>();
        node.children.add(node2);

        System.out.println(maxDepth(node));

    }

    public static int maxDepth(Node root) {
        return dfs(1,root);
    }
    public static int dfs(int depth,Node root){
        if(root.children==null||root.children.size()==0){
            return 1;
        }
        for(Node child:root.children){
            max = Math.max(depth+1,max);
            dfs(depth+1,child);
        }
        return max;
    }
}
