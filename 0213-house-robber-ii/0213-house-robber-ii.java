class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        int [] dp = new int[n+1];

        int taking_0th_idx = solve1(nums , n-1 , dp);
        Arrays.fill(dp , 0);
        int taking_last_idx = solve2(nums , n , dp);

        return Math.max(taking_0th_idx , taking_last_idx);
    }
    public int solve1(int [] nums , int size , int [] dp){
        dp[0] = 0;
        dp[1] = nums[0]; // take 1st house

        for(int i=2; i<=size; i++){
            int pick = nums[i-1] + dp[i-2];
            int skip = dp[i-1];
            dp[i] = Math.max(pick , skip);
        }
        System.out.println(Arrays.toString(dp));

        return dp[size];
    }

    public int solve2(int [] nums , int size , int [] dp){
        dp[0] = 0;
        dp[1] = 0; // skip 1st house

        for(int i=2; i<=size; i++){
            int pick = nums[i-1] + dp[i-2];
            int skip = dp[i-1];
            dp[i] = Math.max(pick , skip);
        }
        System.out.println(Arrays.toString(dp));

        return dp[size];
    } 
}