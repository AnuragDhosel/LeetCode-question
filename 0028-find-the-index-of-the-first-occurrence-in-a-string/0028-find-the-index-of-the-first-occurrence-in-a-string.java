class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;

        int i = 0 , j = needle.length(); 
        while(j <= haystack.length()){
            String sub = haystack.substring(i , j);
            if(needle.equals(sub)) return i;
            i++;
            j++;
        }
        return -1;
    }
}