class Solution {
    int [][] dp;
    public int solve(int row , int col , int [][] arr){
        if(row < 0 || col < 0) // we don't get a valid path, don't count it
            return 0;  
            
        if(arr[row][col] == 1) // we get a obstacle, go back, don't count it
            return 0;   

        if(row == 0 && col == 0) // we get a valid path , count it
            return 1;
         
        if(dp[row][col] != -1)
            return dp[row][col];

        int up = solve(row-1 , col , arr);
        int left = solve(row , col-1 , arr);

        return dp[row][col] = up+left;    
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        dp = new int[m][n];
        for(int i=0; i<m; i++)
            Arrays.fill(dp[i] , -1);

        if(m==1 && n==1)
            return obstacleGrid[0][0] == 0 ? 1 : 0;

        return solve(m-1 , n-1 , obstacleGrid);
    }
}