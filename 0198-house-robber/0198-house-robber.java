class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        int [] dp = new int[n + 1];
        // dp[i] = max stolen money till i house

        dp[0] = 0; // when no house selected
        dp[1] = nums[0]; // when one house selected

        for(int i=2; i<=n; i++){
            int pick = nums[i-1] + dp[i-2];
            int skip = dp[i-1];

            dp[i] = Math.max(pick , skip);
        }

        return dp[n];
    }
}