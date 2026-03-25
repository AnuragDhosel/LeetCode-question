class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;

        for(int i=0; i<haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                if(isSame(i , haystack , needle)) return i;
            }
        }
        return -1;
    }
    public boolean isSame(int idx , String s , String t){
        int i=0; 
        while(i<t.length() && idx < s.length()){
            if(s.charAt(idx) != t.charAt(i)) return false;
            i++;
            idx++;
        }
        if(i == t.length()) return true;
        return false;
    }
}