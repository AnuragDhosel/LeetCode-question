class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        long [][] dp = new long[n+1][2];

        for(int i=1; i<n+1; i++){
            dp[i][0] = Math.max(dp[i-1][1] - nums[i-1] , dp[i-1][0]); // even case
            dp[i][1] = Math.max(dp[i-1][0] + nums[i-1] , dp[i-1][1]); // odd case
        }

        return Math.max(dp[n][0] , dp[n][1]);
    }
}