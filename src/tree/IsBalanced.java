package tree;

//判定是否是高度平衡二叉树
//每个节点的左右两个子树的高度差的绝对值不超过1
public class IsBalanced {
    private static boolean ans = true;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(1);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);

        System.out.println(isBalanced(treeNode));
    }

    //首先试着遍历所有的子节点，然后求，速度优化放到后边去做
    //这个相当于自顶向下遍历所有节点，求出其所有的高度，但是这个是o(n2)的时间复杂度，需要优化
    public static boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if(Math.abs(left-right)>1){
            return false;
        }
        return ans&&isBalanced(root.right)&&isBalanced(root.left);
    }
    public static int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.max(left,right)+1;
    }

    //自底向上，时间复杂度o(n)
    //主要想法是：如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回 -1。
    public static boolean isBalanced2(TreeNode root){
        return depth2(root)!=-1;
    }
    public static int depth2(TreeNode root){
        if(root==null){
            return 0;
        }
        if(depth2(root.left)==-1||
            depth2(root.right)==-1||
            Math.abs(depth2(root.left)-depth2(root.right))>=1){
            return -1;
        }
        return Math.max(depth2(root.left),depth2(root.right))+1;
    }

}
