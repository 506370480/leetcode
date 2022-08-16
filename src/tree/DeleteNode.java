package tree;

import sun.reflect.generics.tree.Tree;

public class DeleteNode {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(1);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(2);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode.setLeft(treeNode2);
        treeNode2.setRight(treeNode4);
        treeNode.setRight(treeNode3);
        treeNode4.setRight(treeNode5);
        deleteNode(treeNode,3);
        System.out.println(treeNode);
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        //更改为找到父节点，keyNode为父节点，当无父节点时为root
        TreeNode keyNode = bst(root,key);
        if(keyNode==null){
            return root;
        }
        if(keyNode.right==null&&keyNode.left==null){
            return null;
        }
        if(keyNode.left!=null&&keyNode.left.val!=key&&keyNode.right!=null&&keyNode.right.val!=keyNode.val){
            TreeNode minNode = searchMin(keyNode.right);
            TreeNode par = bst(root, minNode.val);
            keyNode.val = minNode.val;
            if(par.left!=null&&par.left.val==minNode.val){
                deleteNode(par.left,par.left.val);
                par.left=null;
            }else{
                deleteNode(par.right,par.right.val);
                par.right=null;
            }
        }
        //删除节点必须找到其父节点
        if(keyNode.left!=null&&keyNode.left.val==key){
            if(keyNode.left.right==null&&keyNode.left.left==null){
                keyNode.left=null;
                return root;
            }


            if(keyNode.left.left!=null&&keyNode.left.right==null){
                keyNode.left=keyNode.left.left;
                return root;
            }

            if(keyNode.left.right!=null&&keyNode.left.left==null){
                keyNode.left=keyNode.left.right;
                return root;
            }

            TreeNode minNode = searchMin(keyNode.left.right);
            TreeNode par = bst(root, minNode.val);
            keyNode.left.val = minNode.val;
            if(par.left!=null&&par.left.val==minNode.val){
                deleteNode(par.left,par.left.val);
                par.left=null;
            }else{
                deleteNode(par.right,par.right.val);
                par.right=null;
            }

        }

        //删除节点必须找到其父节点
        if(keyNode.right!=null&&keyNode.right.val==key){
            if(keyNode.right.right==null&&keyNode.right.left==null){
                keyNode.right=null;
                return root;
            }


            if(keyNode.right.left!=null&&keyNode.right.right==null){
                keyNode.right=keyNode.right.left;
                return root;
            }

            if(keyNode.right.right!=null&&keyNode.right.left==null){
                keyNode.right=keyNode.right.right;
                return root;
            }

            TreeNode minNode = searchMin(keyNode.right.right);
            TreeNode par = bst(root, minNode.val);
            keyNode.right.val = minNode.val;
            if(par.left!=null&&par.left.val==minNode.val){
                deleteNode(par.left,par.left.val);
                par.left=null;
            }else{
                deleteNode(par.right,par.right.val);
                par.right=null;
            }

        }
        return root;

/*        if(keyNode.left==null&&keyNode.right!=null){
            keyNode = keyNode.right;
            keyNode.right=null;
            return root;
        }
        if(keyNode.left!=null&&keyNode.right==null){
            keyNode = keyNode.left;
            keyNode.left=null;
            return root;
        }
        TreeNode minNode = searchMin(keyNode.right);
        deleteNode(keyNode.right,minNode.val);
        keyNode.val = minNode.val;
        return root;*/

    }

    public static TreeNode bst(TreeNode root,int key){
        if(root==null){
            return null;
        }
        if(root.val==key){
            return root;
        }
        if(root.right!=null&&root.right.val==key||root.left!=null&&root.left.val==key){
            return root;
        }
        if(root.val>key){
            return bst(root.left,key);
        }else{
            return bst(root.right,key);
        }
    }

    public static TreeNode searchMin(TreeNode keyNode){
        if(keyNode.left!=null){
            return searchMin(keyNode.left);
        }else{
            return keyNode;
        }
    }

    public static void delete(TreeNode root,TreeNode keyNode){
        if(root==keyNode){
            root = null;
            return;
        }
        if(root.left==keyNode){
            root.left=null;
            return;
        }
        if(root.right==keyNode){
            root.right=null;
            return;
        }
        if(root.val>keyNode.val){
            delete(root.left,keyNode);
        }else{
            delete(root.right,keyNode);
        }
    }
}
