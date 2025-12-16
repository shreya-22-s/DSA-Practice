class Solution {
    int arr[]=new int[10001];
    private int helper(int n){
        if(n==0)return 0;
        if(arr[n]!=-1)return arr[n];
        int minCount=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int result=1+helper(n-i*i);
            minCount=Math.min(minCount,result);
        }
        return arr[n]=minCount;
    }
    public int numSquares(int n) {
        Arrays.fill(arr,-1);
        return helper(n);
    }
}
