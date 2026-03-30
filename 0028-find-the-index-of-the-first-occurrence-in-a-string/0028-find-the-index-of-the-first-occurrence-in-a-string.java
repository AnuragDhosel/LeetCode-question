class Solution {
    public int strStr(String haystack, String needle) {
        int [] lps = calculateLPS(needle);

        int i=0 , j=0;
        while(i < haystack.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == needle.length()){
                    return i-j;
                }
            }
            else{ // haystack.charAt(i) != needle.charAt(j)
                if(j != 0) j = lps[j-1];
                else i++;
            }
        }
        return -1;
    }
    public int[] calculateLPS(String pat){
        int [] lps = new int[pat.length()];
        int len = 0;
        int i = 1;
        while(i < pat.length()){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0) len = lps[len - 1];
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}