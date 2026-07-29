class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int [] dp = new int[n+1];
        dp[n] = 1;  // bcz in top-down : if(i == n) return 1

        for(int i=n-1; i>=0; i--){ // opposite bcz dp[i] comes from dp[i+1]
            if(s.charAt(i) == '0'){ // bcz in top-down : if(s[i] == 0) return 0
                dp[i] = 0;
            }
            else{
                int oneEleChoosen = dp[i+1]; // bcz of solve(i+1)

                int twoEleChoosen = 0;
                if(i + 1 < n){
                    if(s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i+1) <= '6'))
                        twoEleChoosen = dp[i+2]; // bcz of solve(i+2)
                }

                dp[i] = oneEleChoosen + twoEleChoosen;
            }
        }

        return dp[0];
    }
}