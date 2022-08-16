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

    //1.�޷����ݱ������Ľ���õ�����ʧ�˴�������Ϣ��
    //2.�Զ����·����Ƿ���ã��Ե�����һ���ò��ˣ��޷��ɸ��ڵ����Ϣ�Ƶ�����һ������Ϣ��
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
