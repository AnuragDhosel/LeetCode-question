class Solution {
    int [][] dp;
    public int solve(int i , int j , String s, String t){
        if(j < 0) // we get t
            return 1;
        if(i < 0) // we can't get t
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s.charAt(i) == t.charAt(j)){
            int take = solve(i-1 , j-1 , s , t); // j decrease , only this condition
            int skip = solve(i-1 , j , s , t);
            return dp[i][j] = take + skip;
        } 
        else{
            return dp[i][j] = solve(i-1 , j , s , t); // skip
        }
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        dp = new int[n][m];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i] , -1);
            
        return solve(n-1 , m-1 , s , t);
    }
}