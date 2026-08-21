class Solution {
    int [][] dp;
    public int LongestCommonSubsequence(int i , int j , String s1 , String s2){
        if(i < 0 || j < 0) 
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + LongestCommonSubsequence(i-1 , j-1 , s1 , s2);
        else{
            int i_decrease = LongestCommonSubsequence(i-1 , j , s1 , s2);
            int j_decrease = LongestCommonSubsequence(i , j-1 , s1 , s2);
  
            return dp[i][j] = Math.max(i_decrease , j_decrease);
        }
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString(); 

        dp = new int[n][n];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i] , -1);

        return LongestCommonSubsequence(n-1 , n-1 , s , rev);
    }
}