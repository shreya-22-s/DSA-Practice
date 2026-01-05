class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n=matrix.length;
        long sum=0;
        long counterneg=0;
        long smallAbs=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0){
                    counterneg++;
                }
                smallAbs=Math.min(smallAbs,Math.abs(matrix[i][j]));
            }
        }
        if(counterneg%2==0){
            return sum;
        }
        return sum-2*smallAbs;
    }
}
