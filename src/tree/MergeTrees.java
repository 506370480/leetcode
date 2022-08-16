package tree;

public class MergeTrees {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(1);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);

        System.out.println(mergeTrees(treeNode, treeNode4));


    }

    //����˼�뻹�ǹ���һ���µ�������������������˼�룬��Ū��root1�ϱߣ����ָ�����ָ���ϵ
    //�ᵼ�´���ָ�����Լ��㱬ը
    public static TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if(root1==null){
            root1 = root2;
            return root1;
        }
        if(root2==null){
            return root1;
        }
        root1.val = root1.val+root2.val;
        mergeTrees1(root1.left,root2.left);
        mergeTrees1(root1.right,root2.right);
        return root1;
    }


    //�����ǹٷ����
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        TreeNode merged = new TreeNode(root1.val+root2.val);
        merged.left = mergeTrees(root1.left,root2.left);
        merged.right = mergeTrees(root1.right,root2.right);
        return merged;
    }
}
