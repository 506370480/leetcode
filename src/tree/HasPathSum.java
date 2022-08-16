package tree;

public class HasPathSum {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(1);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);

        System.out.println(hasPathSum1(treeNode, 2));
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null&&root.val==targetSum){
            return true;
        }
        return hasPathSum(root.left,targetSum-root.val)
                ||hasPathSum(root.right,targetSum-root.val);
    }



    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        return sum(root,root.val,root.val,targetSum);
    }
    public static boolean sum(TreeNode root,int sum_left,int sum_right,int targetSum){
        if(root.left==null&&root.right==null){
            if(sum_left!=targetSum&&sum_right!=targetSum){
                return false;
            }
            return true;
        }
        if(root.left==null){
            sum_right+=root.right.val;
            return sum(root.right,sum_right,sum_right,targetSum);
        }
        if(root.right==null){
            sum_left+=root.left.val;
            sum(root.left,sum_left,sum_left,targetSum);
        }
        if(root.left!=null&&root.right!=null){
            sum_right+=root.right.val;
            sum_left+=root.left.val;
        }
        return sum(root.left,sum_left,sum_left,targetSum)||sum(root.right,sum_right,sum_right,targetSum);
    }
}
