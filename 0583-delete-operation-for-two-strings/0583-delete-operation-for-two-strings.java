class Solution {
    int [][] dp;
    public int longestCommonSubsequece(int i , int j , String s1 , String s2){
        if(i < 0 || j < 0)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];
            
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + longestCommonSubsequece(i-1 , j-1 , s1 , s2);
        else{
            int i_decrease = longestCommonSubsequece(i-1 , j , s1 , s2);
            int j_decrease = longestCommonSubsequece(i , j-1 , s1 , s2);
            return dp[i][j] = Math.max(i_decrease , j_decrease);
        }
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        dp = new int[n][m];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i] , -1);

        int LCS = longestCommonSubsequece(n-1 , m-1 , word1 , word2);

        return (n + m - 2*LCS);
    }
}