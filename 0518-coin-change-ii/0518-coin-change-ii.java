class Solution {
    int [][] dp;
    public int solve(int idx , int target ,  int [] arr){
        if(target == 0) return 1;
        if(idx == 0)
            return (target % arr[0] == 0) ? 1 : 0; 


        if(dp[idx][target] != -1)
            return dp[idx][target];

        int take = 0;
        if(arr[idx] <= target)
            take = solve(idx , target - arr[idx] , arr);
        int notTake = solve(idx - 1 , target , arr);

        dp[idx][target] = take + notTake;
        return dp[idx][target];
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;

        dp = new int[n][amount+1];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i] , -1);

        return solve(n-1 , amount , coins);
    }
}