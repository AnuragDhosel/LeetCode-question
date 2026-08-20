class Solution {
    int [][] dp;
    public int longestPalindromicSubsequence(int i , int j , String s){
        if(i > j) return 0;
        if(i == j) return 1;

        if(dp[i][j] != -1)
            return dp[i][j];

        int matched = 0;
        if(s.charAt(i) == s.charAt(j))
            matched = 2 + longestPalindromicSubsequence(i+1 , j-1 , s);
        
        int i_increase = longestPalindromicSubsequence(i+1 , j , s);
        int j_decrease = longestPalindromicSubsequence(i , j-1 , s);

        dp[i][j] = Math.max(matched , Math.max(i_increase , j_decrease));
        return dp[i][j];
    }
    public int minInsertions(String s) {
        int n = s.length();

        dp = new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i] , -1);

        int LPS = longestPalindromicSubsequence(0 , n-1 , s);

        return n - LPS;
    }
}