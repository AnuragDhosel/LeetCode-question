class Solution {
    int [][] dp;
    public int solve(int row , int col){
		if(row < 0 || col < 0)
            return 0;
						
        if(row == 0 && col == 0) // we get a valid ans
            return 1;

        if(dp[row][col] != -1)
            return dp[row][col];

        int up = solve(row-1 , col);
        int left = solve(row , col-1);

        dp[row][col] = up + left;
        return dp[row][col];
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int i=0; i<m; i++)
            Arrays.fill(dp[i] , -1);
        
        return solve(m-1 , n-1);
    }
}