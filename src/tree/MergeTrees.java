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

    //核心思想还是构造一个新的树，如果按照如下这个思想，都弄到root1上边，各种各样的指针关系
    //会导致错误，指针会把自己搞爆炸
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


    //以下是官方解答
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
