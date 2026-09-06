class Solution {
    int [][] dp;
    public int solve(int i , int j , String s1 , String s2){
        if(i < 0 && j < 0) return 0;
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        
        if(dp[i][j] != -1)
            return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = solve(i-1 , j-1 , s1 , s2);
        }
        else{
            int insert = 1 + solve(i , j-1 , s1 , s2); // aage replace hogi 
            int delete = 1 + solve(i-1 , j , s1 , s2);
            int replace = 1 + solve(i-1 , j-1 , s1 , s2); // we get, and move 

            dp[i][j] = Math.min(insert , Math.min(delete , replace));
        }

        return dp[i][j];
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        dp = new int[n][m];
        for(int i=0; i<n; i++)
            Arrays.fill(dp[i] , -1);

        return solve(n-1 , m-1 , word1 , word2);
    }
}