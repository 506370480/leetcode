package tree;

import java.util.*;

public class FindMode {
    private static List<Integer> list = new ArrayList<>();
    static int base,count,maxCount;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        treeNode.setLeft(treeNode2);
        treeNode2.setLeft(treeNode4);
        treeNode.setRight(treeNode3);
        System.out.println(Arrays.toString(findMode2(treeNode)));

    }
    public static int[] findMode(TreeNode root) {
        addNode(root);
        int max = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 1;i<list.size();i++) {
            if(list.get(i)==list.get(i-1)){
                map.put(list.get(i), map.getOrDefault(list.get(i),0)+1);
                max = Math.max(max,map.get(list.get(i)));
            }
        }
        int index=0;
        int[] res = new int[map.size()];
        for (Integer key : map.keySet()) {
            if(max!=1) {
                if (map.get(key) == max) {
                    res[index++] = key;
                }
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }

    public static int[] findMode2(TreeNode root){
        addNode(root);
        int[] mode = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            mode[i] = list.get(i);
        }
        return mode;
    }

    public static void addNode(TreeNode root){
        if(root==null){
            return;
        }
        addNode(root.left);
        update(root.val);
        addNode(root.right);
    }

    public static void update(int val){
        if(val==base){
            count++;
        }else {
            count=1;
            base = val;
        }
        if(maxCount==count){
            list.add(val);
            }
        if(maxCount>count){
            maxCount = count;
            list.clear();
            list.add(base);
        }
    }

}
