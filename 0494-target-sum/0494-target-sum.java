class Solution {
    int [][] dp;
    // how many subarrays whose sum is target
    public int solve(int idx , int target , int [] arr){
        if(idx < 0)
            return (target == 0) ? 1 : 0;

        if(dp[idx][target] != -1)
            return dp[idx][target];

        int take = 0;
        if(arr[idx] <= target)
            take = solve(idx-1 , target - arr[idx] , arr);
        int notTake = solve(idx-1 , target , arr);

        dp[idx][target] = take + notTake;
        return dp[idx][target];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++)
            sum += nums[i];

        if(Math.abs(target) > sum)
            return 0;

        if((target+sum) % 2 != 0) 
            return 0;

        // s1 = (target + sum)/2;
        int realTarget = (target + sum)/2;

        dp = new int[n][realTarget + 1];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i] , -1);
        

        return solve(n-1 , realTarget , nums);
    }
}