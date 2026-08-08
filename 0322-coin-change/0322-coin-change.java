class Solution {
    int [][] dp;
    public int solve(int idx , int target , int [] nums){
        if(idx < 0)
            return (target == 0) ? 0 : (int)1e9;

        if(dp[idx][target] != -1)
            return dp[idx][target];

        int take = Integer.MAX_VALUE;
        if(nums[idx] <= target)
            take = 1 + solve(idx , target - nums[idx] , nums);
        int notTake = 0 + solve(idx - 1 , target , nums);

        dp[idx][target] = Math.min(take , notTake);
        return dp[idx][target];
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        dp = new int[n][amount + 1];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i] , -1);

        int ans = solve(n-1 , amount , coins);
        return (ans >= (int)1e9) ? -1 : ans;
    }
}