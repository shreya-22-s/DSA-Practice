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
//using DFS
class Solution {

    Map<Integer, Integer> mp = new HashMap<>();

    public void DFS(TreeNode root, int currLevel) {
        if (root == null) return;

        mp.put(currLevel, mp.getOrDefault(currLevel, 0) + root.val);

        DFS(root.left, currLevel + 1);
        DFS(root.right, currLevel + 1);
    }

    public int maxLevelSum(TreeNode root) {
        mp.clear();
        DFS(root, 1);

        int maxSum = Integer.MIN_VALUE;
        int result = 0;

        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            int level = entry.getKey();
            int sum = entry.getValue();

            if (sum > maxSum) {
                maxSum = sum;
                result = level;
            }
        }
        return result;
    }
}

