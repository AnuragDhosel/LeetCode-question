class Solution {
    public int solve(int idx , int target , int [] arr){
        if(idx < 0)
            return (0 == Math.abs(target)) ? 1 : 0;

        int plus = solve(idx-1 , target-arr[idx] , arr);
        int minus = solve(idx-1 , target+arr[idx] , arr);

        return plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        return solve(n-1 , target , nums);
    }
}