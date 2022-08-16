package tree;
//每棵树的左子树和右子树都要翻转
public class InvertTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);
        System.out.println(invertTree(treeNode));
    }
    public static TreeNode invertTree(TreeNode root) {
        TreeNode node;
        if(root == null){
            return null;
        }
        node= root.right;
        root.right = root.left;
        root.left = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
