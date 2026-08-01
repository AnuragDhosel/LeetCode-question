class Solution {
    long [][] dp;
    public long solve(int row , int col , int [][] nums){
        if(row == 0 && col == 0)  // Base case: reached the starting cell
            return nums[0][0];
        if(row < 0 || col < 0) // Out of bounds -> treat as an invalid path
            return Integer.MAX_VALUE;  // i take long bcz of this and sum after this

        if(dp[row][col] != -1) // memorization
            return dp[row][col];

        long up = nums[row][col] + solve(row-1 , col , nums);
        long left = nums[row][col] + solve(row , col-1 , nums);

        dp[row][col] = Math.min(up , left);

        return dp[row][col];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new long[m][n];
        for(int i=0; i<m; i++)
            Arrays.fill(dp[i] , -1);

        return (int)solve(m-1 , n-1 , grid);
    }
}