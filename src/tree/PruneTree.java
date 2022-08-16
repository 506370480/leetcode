package tree;

public class PruneTree {
    public static void main(String[] args) {

    }
    public static TreeNode pruneTree(TreeNode root) {
        if(root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if(root.left != null||root.right != null) return root;
        return root.val==0?null:root;
    }
}
