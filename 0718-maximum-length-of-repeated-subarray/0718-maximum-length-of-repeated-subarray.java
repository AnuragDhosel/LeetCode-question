class Solution {
    int max = -1;
    int [][] dp;
    public int solve(int i , int j , int [] arr1 , int [] arr2){
        if(i < 0 || j < 0)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int take = 0;
        if(arr1[i] == arr2[j])
            take = 1 + solve(i-1 , j-1 , arr1 , arr2);
        max = Math.max(take , max);

        solve(i-1 , j , arr1 , arr2);
        solve(i , j-1 , arr1 , arr2);

        return dp[i][j] = take;
    }
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        dp = new int[n][m];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i] , -1);
            
        solve(n-1 , m-1 , nums1 , nums2);

        return max;
    }
}