package hashset;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//这个是看答案写出来的，需要重新写!!
//关键在于利用递归对树进行序列化，然后加入map中
public class FindDuplicateSubtrees {
    public static void main(String[] args) {

    }

    Map<String,Integer> hashmap;
    List<TreeNode> list;
    //思想就是将每棵树序列化，然后判断序列化后的子树有没有重复的
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
