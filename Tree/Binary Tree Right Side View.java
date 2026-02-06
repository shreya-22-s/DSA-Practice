class Solution {
    public static void preorder(TreeNode root,int level,List<Integer>l){
        if(root==null)return;
        if(l.size()<level){
            l.add(root.val);
        }
        preorder(root.right,level+1,l);
        preorder(root.left,level+1,l);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>l=new ArrayList<>();
        preorder(root,1,l);
        return l;
    }
}
