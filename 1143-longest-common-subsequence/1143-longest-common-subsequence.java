
class Solution {
    int [][] dp;
    public int solve(int i , int j , String s1 , String s2){
        // base case
        if(i == 0 || j == 0)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(s1.charAt(i-1) == s2.charAt(j-1)) // if matched the character
            return dp[i][j] = 1 + solve(i-1 , j-1 , s1 , s2);
        
        else{ // if not matched 
            int i_decrease = 0 + solve(i-1 , j , s1 , s2);
            int j_decrease = 0 + solve(i , j-1 , s1 , s2);
            return dp[i][j] = Math.max(i_decrease , j_decrease);
        }

    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        dp = new int[n+1][m+1];
        for(int i=0; i<n+1; i++){
            Arrays.fill(dp[i], -1);
        }

        return solve(n , m , text1 , text2);
    }
}