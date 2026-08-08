class Solution {
    // how many subarrays whose sum is target
    public int solve(int idx , int target , int [] arr){
        if(idx < 0)
            return (0 == target) ? 1 : 0;

        int take = 0;
        if(arr[idx] <= target)
            take = solve(idx-1 , target - arr[idx] , arr);
        int notTake = solve(idx-1 , target , arr);

        return take + notTake;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++)
            sum += nums[i];

        // s1 = (target + sum)/2;
        int realTarget = (target + sum)/2;

        if((target+sum) % 2 != 0) return 0;

        return solve(n-1 , realTarget , nums);
    }
}