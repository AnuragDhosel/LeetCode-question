class Solution {
    int [][] dp;
    public long solve(int row , int col , int [][] nums){
        if(row == 0 && col == 0)
            return nums[0][0];
        if(row < 0 || col < 0)
            return Integer.MAX_VALUE;

        if(dp[row][col] != -1)
            return dp[row][col];

        long up = nums[row][col] + solve(row-1 , col , nums);
        long down = nums[row][col] + solve(row , col-1 , nums);

        dp[row][col] = (int)Math.min(up , down);

        return Math.min(up , down);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n];
        for(int i=0; i<m; i++)
            Arrays.fill(dp[i] , -1);

        return (int)solve(m-1 , n-1 , grid);
    }
}