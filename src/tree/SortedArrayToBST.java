package tree;
//二叉搜索树 左<根<右
//高度平衡：每个节点的左右两个子树的高度差的绝对值不超过 1
public class SortedArrayToBST {
    int low;
    int high;
    int mid;
    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));

    }
    public static TreeNode sortedArrayToBST(int[] nums) {
        return Bst(nums,0,nums.length-1);
    }
    public static TreeNode Bst(int nums[],int low,int high){
        if(nums==null||nums.length==0){
            return null;
        }
        if(low==high){
            return new TreeNode(nums[low]);
        }
        if(low>=high){
            return null;
        }
        int mid = (high-low)%2==0?(low+high)/2:(low+high)/2+1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = Bst(nums,low,mid-1);
        node.right = Bst(nums,mid+1,high);
        return node;
    }
}
