class Solution {
    public String longestPrefix(String s) {
        int [] lps = calculateLPS(s);

        int l = lps[lps.length - 1];
        return s.substring(0 , l);
    }
    public int[] calculateLPS(String s){
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
                if(len != 0) len = lps[len - 1];
                else i++;
            }
        }
        return lps;
    }
}