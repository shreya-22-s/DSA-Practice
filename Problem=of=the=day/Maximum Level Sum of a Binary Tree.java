//using BFS
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>q=new LinkedList<>();
        if(root==null)return 0;
        q.add(root);
        int maxSum=Integer.MIN_VALUE;
        int resultLevel=0;
        int currLevel=1;
        while(!q.isEmpty()){
            int len=q.size();
            int sum=0;
            for(int i=0;i<len;i++){
                TreeNode temp=q.poll();
                sum+=temp.val;
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
           if(sum>maxSum){
            maxSum=sum;
            resultLevel=currLevel;
           }
            currLevel++;
        }
        return resultLevel;
    }
}
