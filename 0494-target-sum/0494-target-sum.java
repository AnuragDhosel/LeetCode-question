class Solution {
    int[][] dp;
    int offset;

    public int solve(int idx, int target, int[] nums) {

        // Target has gone outside the range we can represent
        if (target < -offset || target > offset)
            return 0;

        // Base case
        if (idx == 0) {
            if (nums[0] == 0 && target == 0)
                return 2;

            return nums[0] == Math.abs(target) ? 1 : 0;
        }

        if (dp[idx][target + offset] != -1)
            return dp[idx][target + offset];

        int plus = solve(idx - 1, target - nums[idx], nums);

        int minus = solve(idx - 1, target + nums[idx], nums);

        dp[idx][target + offset] = plus + minus;

        return dp[idx][target + offset];
    }

    public int findTargetSumWays(int[] nums, int target) {

        int n = nums.length;

        int sum = 0;

        for (int num : nums)
            sum += num;

        // Impossible target
        if (Math.abs(target) > sum)
            return 0;

        offset = sum;

        dp = new int[n][2 * sum + 1];

        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        return solve(n - 1, target, nums);
    }
}