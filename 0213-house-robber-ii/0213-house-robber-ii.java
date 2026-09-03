class Solution {
    int [] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        dp = new int[n+1];
        Arrays.fill(dp , -1);
        
        // take last idx element but not take 0th idx element
        int taking_last_idxEle = solve(n-1 , nums , 1);

        Arrays.fill(dp , -1);
        // not take last idx element but take 0th idx element
        int taking_0th_idxEle = solve(n-2 , nums , 0);

        return Math.max(taking_last_idxEle , taking_0th_idxEle);
    }
    
    public int solve(int idx , int [] nums , int first){
        if(idx < first) return 0;
        if(idx == first) return nums[first];

        if(dp[idx] != -1) 
            return dp[idx];

        int pick = solve(idx-2 , nums , first) + nums[idx];
        int skip = solve(idx-1 , nums , first);

        dp[idx] = Math.max(pick , skip);

        return dp[idx];
    }
}