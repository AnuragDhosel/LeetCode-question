class Solution {
    int [][] dp;
    public int countTargetSubseq(int idx , int target , int [] arr){
        if(idx < 0)
            return (target == 0) ? 1 : 0;

        if(dp[idx][target] != -1)
            return dp[idx][target];

        int take = 0;
        if(arr[idx] <= target)
            take = countTargetSubseq(idx-1 , target - arr[idx] , arr);
        int notTake = countTargetSubseq(idx-1 , target , arr);

        dp[idx][target] = take + notTake;
        return dp[idx][target];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int i=0; i<n; i++)
            total += nums[i];

//impossible TC - math.abs bcz if we substract all element, then we can get negative element
        if(Math.abs(target) > total) return 0;

        // suppose : target = diff , total = totalSum , S1 = realTarget
        // so , s1 = (target + sum)/2; represented as
        int realTarget = (target + total)/2;

// impossible TC - realTarget is even,then how (target + total) is odd
        if((target + total) % 2 != 0) 
            return 0;

        dp = new int[n][realTarget + 1];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i] , -1);
        
        // so how many subarrays whose sum is target or realTarget
        return countTargetSubseq(n-1 , realTarget , nums);
    }
}