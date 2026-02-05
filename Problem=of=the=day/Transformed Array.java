class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];
        for(int i=0;i<n;i++){
            int k=0;
            if(nums[i]>0){
              k= (i + nums[i]) % n;
              result[i]=nums[k];
            }
            else if(nums[i]<0){
              int steps = Math.abs(nums[i]);
               k = ((i + nums[i]) % n + n) % n;
               result[i]=nums[k];

            }
            else{
                k= (i + nums[i]) % n;
                result[i]=nums[k];
            }
        }
        return result;
    }
}
