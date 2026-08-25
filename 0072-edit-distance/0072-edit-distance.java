class Solution {
    int [][] dp;
    public int solve(int i , int j , String s1 , String s2){
        if(i < 0 && j < 0) // both string idx exhausted 
            return 0;
        if(i < 0) // s1's idx i exhausted -> rest s2 char need to insert
            return j+1;
        if(j < 0) // s2's idx j exhausted -> rest s1 char need to delete
            return i+1;

        // memorization
        if(dp[i][j] != -1)
            return dp[i][j];
            
        if(s1.charAt(i) == s2.charAt(j)){ // if match both decrease
            return dp[i][j] = 0 + solve(i-1 , j-1 , s1 , s2);
        }
        else{
            int insert = 1 + solve(i , j-1 , s1 , s2); 
            int delete = 1 + solve(i-1 , j , s1 , s2);
            int replace = 1 + solve(i-1 , j-1 , s1 , s2);

            dp[i][j] = Math.min(insert , Math.min(delete , replace));
            return dp[i][j];
        }
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