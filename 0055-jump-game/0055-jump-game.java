class Solution {
    int [] dp;
    public boolean solve(int i , int [] arr){
        if(i >= arr.length-1)
            return true;
        
        if(dp[i] != -1)
            return (dp[i] == 1) ? true : false;

        boolean isReached = false;
        for(int k=i+1; k<=i+arr[i]; k++){ // k is next idx
            boolean curr = solve(k , arr);
            if(curr){
                isReached = true;
                break;
            }
        }

        dp[i] = isReached ? 1 : 0;
        return isReached;
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;

        dp = new int[n+1];
        Arrays.fill(dp , -1);

        return solve(0 , nums);
    }
}