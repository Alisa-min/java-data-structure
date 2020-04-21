package MapTest;

import com.sun.javafx.collections.MappingChange;

//binary search tree
public class MapTest1 {
    public static class BSTNode{
        BSTNode left=null;
        BSTNode right=null;
        int val;

        BSTNode(int val){
            this.val=val;
        }
    }

    private BSTNode root=null;

    //检测val是否在二叉搜索树中
    boolean contains(int val){
        BSTNode cur=root;
        while(cur != null){
            if(val==cur.val){
                return true;
            }
            else if(val<cur.val){
                cur=cur.left;
            }
            else{
                cur=cur.right;
            }
        }
        return false;
    }

    //将val 插入到二叉搜索树中，插入成功返回true
    public boolean put(int val){
        //空树
        if (null==root){
            root=new BSTNode(val);
            return true;
        }

        //非空
        //找待插入元素的位置，保存其双亲
        BSTNode cur=root;
        BSTNode parent=null;
        while(cur!=null){
            parent=cur;
            if(val < cur.val){
                cur=cur.left;
            }
            else if (val>cur.val){
                cur=cur.right;
            }
            else{
                return false;
            }
        }
        //找到待插入节点的位置
        //
        cur=new BSTNode(val);
        if(val<parent.val){
            parent.left=cur;
        }
        else {
            parent.right=cur;

        }
        return true;
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(BSTNode root){
        if(null != root){
            inOrder(root.left);
            System.out.print(root.val+" ");
            inOrder(root.right);
        }
    }
    public int leftMost(){
        if(null==root){

        }
        BSTNode cur = root;
        while(cur.left==null){
            cur=cur.right;
        }
        return cur.val;
    }

    public int rightMost(){
        if(null==root){

        }
        BSTNode cur = root;
        while(cur.right==null){
            cur=cur.right;
        }
        return cur.val;
    }
    boolean remove(int val){
       if (root==null){
           return false;
       }


       BSTNode cur=root;
        BSTNode parent=null;
       while(cur!=null){

           if(val==cur.val){
               break;
           }
           else if (val<cur.val){
               cur=cur.left;
           }
           else{
               cur=cur.right;
           }
       }
       if(cur==null){
           return false;
       }
       if(null==cur.left){
           if (null==parent){
               root=cur.right;
           }
           else{
               if (cur==parent.left){
                   parent.left=cur.right;
               }else{
                   parent.right=cur.right;
               }
           }
           //cur只有左孩子
       }
       else if (null==cur.right){
           //cur只有右孩子
           if (null==parent){
               root=cur.left;
           }
           else{
               if (cur==parent.left){
                   parent.left=cur.left;
               }else{
                   parent.right=cur.left;
               }
           }
       }
       else{
           //cur左右孩子都存在   不能直接删除
           //在cur自述中找一个替代节点删除
           //方式一   在其右子树中找最小节点，即最左侧节点
           //方式二    在其左子树中找最大节点，即最右侧节点

           BSTNode del=cur.right;
           parent=cur;
           while(null!=del.left){
               parent=del;
               del=del.left;
           }

           cur.val=del.val;



           if (del==parent.left){
               parent.left=del.right;
           }
           else{
               parent.left=del.right;
           }

       }
       return true;
    }

    public static void main(String[] args) {
        int[] array={5,3,4,1,7,8,2,6,0,9};

        MapTest1 t=new MapTest1();
        for (int e:array){
            t.put(e);
        }
        t.inOrder();
        System.out.println();
        System.out.println(t.leftMost());
        System.out.println(t.rightMost());

    }
}
