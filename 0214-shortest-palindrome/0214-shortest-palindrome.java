class Solution {
    public String shortestPalindrome(String s) {
        // Step 1:
        // Create a new string -> original + '#' + reversed
        // '#' is used as a separator to avoid overlap confusion
        String newStr = s + '#' + reverse(s);

        // Step 2:
        // Build LPS array (KMP preprocessing)
        // LPS[i] = longest prefix which is also suffix till index i
        int [] lps = calculateLPS(newStr);

        // Step 3:- IMP
        // Last value of LPS gives:
        // length of longest prefix of original string which is palindrome
        // Extract remaining part (which is NOT part of palindrome prefix)
        String sub = s.substring(lps[lps.length-1] , s.length());

        // Step 4;
        // reverse the string
        String rev = reverse(sub);

        return rev + s;
    }
    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        
        for(int i=s.length()-1; i>=0; i--){
            sb.append(s.charAt(i));
        }

        return sb.toString();
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
                if(len != 0) len = lps[len-1];
                else i++;
            }
        }
        return lps;
    }
}