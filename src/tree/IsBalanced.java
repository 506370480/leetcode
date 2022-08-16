package tree;

//�ж��Ƿ��Ǹ߶�ƽ�������
//ÿ���ڵ���������������ĸ߶Ȳ�ľ���ֵ������1
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

    //�������ű������е��ӽڵ㣬Ȼ�����ٶ��Ż��ŵ����ȥ��
    //����൱���Զ����±������нڵ㣬��������еĸ߶ȣ����������o(n2)��ʱ�临�Ӷȣ���Ҫ�Ż�
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

    //�Ե����ϣ�ʱ�临�Ӷ�o(n)
    //��Ҫ�뷨�ǣ����һ��������ƽ��ģ��򷵻���߶ȣ��߶�һ���ǷǸ������������򷵻� -1��
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
