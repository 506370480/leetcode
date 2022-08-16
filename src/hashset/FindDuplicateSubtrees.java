package hashset;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//����ǿ���д�����ģ���Ҫ����д!!
//�ؼ��������õݹ�����������л���Ȼ�����map��
public class FindDuplicateSubtrees {
    public static void main(String[] args) {

    }

    Map<String,Integer> hashmap;
    List<TreeNode> list;
    //˼����ǽ�ÿ�������л���Ȼ���ж����л����������û���ظ���
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        hashmap = new HashMap<>();
        list = new ArrayList<>();
        collect(root);
        return list;
    }

    public String collect(TreeNode root){
        if(root==null){
            return "#";
        }
        String s = root.getVal()+","+collect(root.getLeft())+","+collect(root.getRight());
        hashmap.put(s, hashmap.getOrDefault(s,0)+1);
        if(hashmap.get(s)==2){
            list.add(root);
        }
        return s;
    }
}
