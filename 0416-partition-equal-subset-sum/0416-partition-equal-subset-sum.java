class Solution {
    int [][] dp;
    public boolean isSubsequenceExist(int idx , int target , int [] nums){
        if(target == 0) return true;
        if(idx == 0)
            return (nums[idx] == target) ? true : false;

        if(dp[idx][target] != -1)
            return (dp[idx][target] == 1) ? true : false;

        boolean take = false;
        if(nums[idx] <= target)
            take = isSubsequenceExist(idx - 1 , target - nums[idx] , nums);
        boolean notTake = isSubsequenceExist(idx - 1 , target , nums);

        dp[idx][target] = (take || notTake) ? 1 : 0;
        return take || notTake;
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0; 
        for(int i=0; i<n; i++)
            sum += nums[i];
        
        if(sum % 2 != 0) return false;

        int target = sum/2;

        dp = new int[n][target+1];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i] , -1);

        return isSubsequenceExist(n-1 , target , nums);
    }
}