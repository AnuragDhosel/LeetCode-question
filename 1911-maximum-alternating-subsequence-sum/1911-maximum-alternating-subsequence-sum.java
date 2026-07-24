class Solution {
    long [][] dp;

    public long solve(int [] nums , int i , boolean isEven){
        if(i >= nums.length) return 0;

        int flag = isEven ? 1 : 0;
        if(dp[i][flag] != -1) return dp[i][flag];

        long val = nums[i];
        val = isEven ? val : -val;

        long pick = val + solve(nums , i+1 , !isEven);
        long skip = solve(nums , i+1 , isEven);

        dp[i][flag] = Math.max(pick , skip);

        return dp[i][flag];
    }

    public long maxAlternatingSum(int[] nums) {
        dp = new long[nums.length + 1][2];

        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i] , -1);
        }
        return solve(nums , 0 , true);
    }
    
}