class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int [] lps = calculateLPS(s);

        int n = s.length();
        int patternLength = n - lps[n-1];
        if(lps[n-1] > 0 && (n % patternLength == 0)){
            return true;
        }
        return false;
    }
    public int [] calculateLPS(String s){
        int [] lps = new int[s.length()];

        int i = 1;
        int len = 0;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0) len = lps[len-1];
                else i++;
            }
        }
        return lps;
    }
}