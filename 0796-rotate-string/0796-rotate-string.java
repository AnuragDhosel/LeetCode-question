class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        String s2 = s + s;

        int [] lps = calculateLPS(s2);

        // search goal in s2 -> use KMP
        int i = 0 , j = 0;
        while(i < s2.length()){
            if(s2.charAt(i) == goal.charAt(j)){
                i++;
                j++;
                if(j == goal.length()) return true;
            }
            else{ // s2.charAt(i) != goal.charAt(j)
                if(j != 0) j = lps[j-1];
                else i++;
            }
        }
        return false;
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