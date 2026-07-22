class Solution {
    public int solve(int [] nums , int i , int [] dp){
        if(i >= nums.length) return 0;

        if(dp[i] != -1) return dp[i];

        int pick = nums[i] + solve(nums , i+2 , dp);
        int skip = solve(nums , i+1 , dp);

        dp[i] = Math.max(pick , skip);
        
        return dp[i];
    }
    public int rob(int[] nums) {
        int [] dp = new int[nums.length];
        Arrays.fill(dp , -1);
        
        return solve(nums , 0 , dp);
    }
}