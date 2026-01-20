class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int max = Collections.max(nums);
        int n=nums.size();
        int ans[]=new int[n];

        for(int i=0;i<n;i++){
            ans[i]=-1;
            for(int j=0;j<max;j++){
                int x=j;
                if ((x | (x + 1)) == nums.get(i)){
                    ans[i]=j;
                    break;
                }
                
            }
        }
        return ans;
    }
}
