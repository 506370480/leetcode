package tree;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeaf {
    //�����new����ֿ�ָ���쳣
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);
        dfs1(root,0);
        return;
    }
    public static int sumRootToLeaf(TreeNode root) {

        List<Integer> list1 = new ArrayList<>();
        dfs(root,list1);
        int sum = 0;
        for (List<Integer> integerList : list) {
            int temp = 0;
            for (int i = 0; i < integerList.size(); i++) {
                temp = temp*2+integerList.get(i);
            }
            sum+=temp;
        }
        return sum;
    }
    public static void dfs(TreeNode root,List<Integer> list1){
        //list��ָ�룬��������new
        //�ж��Ƿ�Ϊnull
        if(root==null||root.left==null&&root.right==null){
            if(root==null){
                return;
            }
            list1.add(root.val);
            list.add(new ArrayList<>(list1));
            return;
        }
        list1.add(root.val);
        dfs(root.left,list1);
        //������û�оͲ���remove��
        if(root.left!=null){
            list1.remove(list1.size()-1);
        }
        dfs(root.right,list1);
        list1.remove(list1.size()-1);
    }

    //ֱ��ʹ��dfs�����ˣ������Ĳ��ù�
    public static int dfs1(TreeNode node,int val){
        if(node == null){
            return 0;
        }
        val = (val << 1) | node.val;
        if(node.left==null&&node.right==null){
            return val;
        }
        return dfs1(node.left,val)+dfs1(node.right,val);
    }
}
