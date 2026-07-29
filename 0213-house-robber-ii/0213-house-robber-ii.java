class Solution {
    int [] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        
        dp = new int[n+1];

        Arrays.fill(dp , -1);
        int taking_0th_idx = solve(nums , 0 , n-1);

        Arrays.fill(dp , -1);
        int taking_last_idx = solve(nums , 1 , n);

        return Math.max(taking_0th_idx , taking_last_idx);
    }   
    public int solve(int [] nums , int i , int size){
        if(i >= size) return 0;

        if(dp[i] != -1) return dp[i];

        int pick = solve(nums , i+2 , size) + nums[i];
        int skip = solve(nums , i+1 , size);

        return dp[i] = Math.max(pick , skip);
    }
}