class Solution {
    int [][][] dp;
    public int solve(int row , int col1 , int col2 , int [][] nums){
        // 1. base case 
        // if we reached out of the grid
        if(col1 < 0 || col2 < 0 || col1 >= nums[0].length || col2 >= nums[0].length)
            return 0;

        // if we reach last row
        if(row == nums.length-1)
            return (col1 == col2) ? nums[row][col1] : (nums[row][col1] + nums[row][col2]);
        

        // 2. apply dp
        if(dp[row][col1][col2] != -1)
            return dp[row][col1][col2];
        
        // 3. explore all path for robot1 and robot2 simultanously
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int c1 = -1; c1 <= +1; c1++){
            for(int c2 = -1; c2 <= +1; c2++){
                sum = (col1 == col2) ? nums[row][col1] : (nums[row][col1] + nums[row][col2]);

                sum += solve(row+1 , col1+c1 , col2+c2 , nums); 
                max = Math.max(sum , max);
            }
        }
        
        dp[row][col1][col2] = max;
        return dp[row][col1][col2];
    }
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(0, 0, grid[0].length-1 , grid);
    }
}