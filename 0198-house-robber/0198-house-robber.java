class Solution {
    int [] dp;
    public int solve(int idx , int [] nums){
        if(idx < 0) return 0;
        if(idx == 0) return nums[0];

        if(dp[idx] != -1) 
            return dp[idx];

        int pick = solve(idx-2 , nums) + nums[idx];
        int skip = solve(idx-1 , nums);

        dp[idx] = Math.max(pick , skip);
        return dp[idx];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        Arrays.fill(dp , -1);

        return solve(n-1 , nums);
    }
}