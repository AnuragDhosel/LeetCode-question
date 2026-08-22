class Solution {
    String [][] dp;
    public String longestCommonSubsequence(int i, int j , String s1 , String s2){
        if(i < 0 || j < 0)
            return "";

        if(!dp[i][j].equals("-1"))
            return dp[i][j];
        
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = longestCommonSubsequence(i-1 , j-1 , s1 , s2) + s1.charAt(i);
            return dp[i][j];
        }
        else{
            String i_decrease = longestCommonSubsequence(i-1 , j , s1 , s2);
            String j_decrease = longestCommonSubsequence(i , j-1 , s1 , s2);

            dp[i][j] = (i_decrease.length() > j_decrease.length()) ? i_decrease : j_decrease;
            return dp[i][j];
        }
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        dp = new String[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i] , "-1");
        }

        String LCS = longestCommonSubsequence(n-1 , m-1 , str1 , str2);

        // make the Supersequence using str1 , str2 and LCS
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;
        for(int idx=0; idx<LCS.length(); idx++){

            // Add characters from str1 until we reach LCS character
            while(str1.charAt(i) != LCS.charAt(idx)){
                sb.append(str1.charAt(i));
                i++;
            }

            // Add characters from str2 until we reach LCS character
            while(str2.charAt(j) != LCS.charAt(idx)){
                sb.append(str2.charAt(j));
                j++;
            }

            sb.append(LCS.charAt(idx));

            // we increase both, bcz both char points to the same LCS word
            i++;
            j++;
        }

        // Add remaining characters
        while(i < n){
            sb.append(str1.charAt(i));
            i++;
        }
        while(j < m){
            sb.append(str2.charAt(j));
            j++;
        }

        return sb.toString();
    }
}