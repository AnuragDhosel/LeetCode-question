class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // egde case : starting cell blocked
        if(obstacleGrid[0][0] == 1)
            return 0;

        int [][] dp = new int[m][n];

        dp[0][0] = 1; // total ways to reach from 0,0 to 0,0 is 1

        for(int col=1; col<n; col++){ // fill the 1st row
            if(obstacleGrid[0][col] == 1) break;
            dp[0][col] = 1;
        }

        for(int row=1; row<m; row++){ // fill the 1st col
            if(obstacleGrid[row][0] == 1) break;
            dp[row][0] = 1;
        }

        for(int row=1; row<m; row++){
            for(int col=1; col<n; col++){
                if(obstacleGrid[row][col] == 1)
                    dp[row][col] = 0;
                else    
                    dp[row][col] = dp[row-1][col] + dp[row][col-1];
            }
        }

        return dp[m-1][n-1];
    }
}