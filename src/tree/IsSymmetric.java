package tree;

public class IsSymmetric {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(2);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);

        System.out.println(isSymmetric(treeNode));
    }

    //1.无法根据遍历来的结果得到（损失了大量的信息）
    //2.自顶向下方法是否可用？自底向上一定用不了（无法由根节点的信息推导到上一步的信息）
    public static boolean isSymmetric(TreeNode root) {
        return symmetric(root,root);
    }
    public static boolean symmetric(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return (p.val==q.val)&&symmetric(p.left,q.right)&&symmetric(p.right,q.left);
    }
}
