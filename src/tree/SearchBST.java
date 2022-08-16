package tree;

public class SearchBST {
    static TreeNode node;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);

        System.out.println(searchBST(treeNode, 1));
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if(root.val==val){
            node =  root;
        }
        if(root.right==null&&root.left==null){
            return null;
        }
        if(root.val>val){
            if(root.left==null){
                return null;
            }
            searchBST(root.left,val);
        }else{
            if(root.right==null){
                return null;
            }
            searchBST(root.right,val);
        }
        return node;
    }
}
