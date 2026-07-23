class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int [] dp = new int[n + 1];

        Arrays.fill(dp , -1);
        // take 0th idx element but not take last element
        int taking_0th_idxEle = solve(nums , 0 , dp , n-2);

        Arrays.fill(dp , -1);
        // take last idx element but not take 0th idx element
        int taking_last_idxEle = solve(nums , 1 , dp , n-1);

        return Math.max(taking_0th_idxEle , taking_last_idxEle);
    }
    public int solve(int [] nums , int i , int [] dp , int size){
        if(i > size) return 0;

        if(dp[i] != -1) return dp[i];

        int pick = nums[i] + solve(nums , i+2 , dp , size);
        int skip = solve(nums , i+1 , dp , size);

        dp[i] = Math.max(pick , skip);

        return dp[i];
    }
}