class Solution {
    int [] dp;
    public int solve(int idx , int [] arr){
        if(idx <= 1)
            return 0;
        
        if(dp[idx] != -1)
            return dp[idx];

        int oneStep = arr[idx - 1] + solve(idx-1 , arr);
        int twoStep = Integer.MAX_VALUE;
        if(idx >= 2)
            twoStep = arr[idx - 2] + solve(idx-2 , arr);

        return dp[idx] = Math.min(oneStep , twoStep);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        dp = new int[n+1];
        Arrays.fill(dp , -1);

        return solve(n , cost);
    }
}