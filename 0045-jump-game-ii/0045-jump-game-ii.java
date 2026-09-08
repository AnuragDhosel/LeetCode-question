class Solution {
    int [] dp;
    public int solve(int i , int [] arr){
        if(i >= arr.length-1)
            return 0;
        
        if(dp[i] != -1)
            return dp[i];

        int minJ = (int)(1e9);
        for(int k = i+1; k <= i+arr[i]; k++){
            int currJ = (int)(1e9);
            if(k < arr.length){
                currJ = 1 + solve(k , arr);
            }
            minJ = Math.min(currJ , minJ);
        }

        return dp[i] = minJ;
    }
    public int jump(int[] nums) {
        int n = nums.length;

        dp = new int[n+1];
        Arrays.fill(dp , -1);

        return solve(0 , nums);
    }
}