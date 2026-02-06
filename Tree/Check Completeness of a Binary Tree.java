class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode>que=new LinkedList<>();
        que.add(root);
        boolean past=false;
        while(!que.isEmpty()){
            TreeNode node=que.poll();
            if(node==null){
                past=true;
            }
            else{
                if(past==true){
                    return false;
                }
                que.add(node.left);
                que.add(node.right);
            }
        }
        return true;
    }
}
