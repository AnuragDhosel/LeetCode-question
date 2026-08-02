class Solution {
    int [][] dp;
    public int solve(int row , int col , List<List<Integer>> list){
        if(row == list.size() - 1)
            return list.get(row).get(col);

        if(dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];    

        int same = list.get(row).get(col) + solve(row+1 , col , list);
        int ahead = list.get(row).get(col) + solve(row+1 , col+1 , list);

        dp[row][col] = Math.min(same , ahead);    

        return dp[row][col];
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();

        dp = new int[m][n];
        for(int i=0; i<m; i++)
            Arrays.fill(dp[i] , Integer.MAX_VALUE);
    
        return solve(0 , 0 , triangle);
    }
}