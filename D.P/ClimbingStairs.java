class Solution {
    private int Dp(int n,int dp[]){
       for(int i=2;i<=n;i++){
        dp[i]=dp[i-1]+dp[i-2];
       }
       return dp[n];
    }
    public int climbStairs(int n) {
       int dp[]=new int[n+1];
       dp[0]=1;
       dp[1]=1;
       int ans=Dp(n,dp);
       return ans;
    }
}
