class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();

        int [][] dp = new int [m][n];
        
        for(int col=0; col<m; col++) // initialise last row of dp
            dp[m-1][col] = triangle.get(m-1).get(col);
        
        for(int row=m-2; row>=0; row--){
            for(int col=0; col<triangle.get(row).size(); col++){
                int minValueOfPreviRow = Math.min(dp[row+1][col] , dp[row+1][col+1]);
                dp[row][col] = triangle.get(row).get(col) + minValueOfPreviRow;
            }
        }

        return dp[0][0];
    }
}