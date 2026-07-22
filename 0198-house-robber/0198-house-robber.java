class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        // int [] dp = new int[n + 1];
        // // dp[i] = max stolen money till i house

        int last_prev = 0;  // dp[0] = 0; -> when no house selected
        int curr_prev = nums[0]; // dp[1] = nums[0]; -> when one house selected

        for(int i=2; i<=n; i++){
            int pick = nums[i-1] + last_prev;
            int skip = curr_prev;

            int curr = Math.max(pick , skip);

            last_prev = curr_prev;
            curr_prev = curr;
        }

        return curr_prev;
    }
}