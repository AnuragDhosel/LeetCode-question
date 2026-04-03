class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        for(int i=0; i<s.length(); i++){
            // for odd
            checkPalindrome(s , i , i);
            // for even
            checkPalindrome(s , i , i+1);
        }

        return count;
    }
    public void checkPalindrome(String s , int l , int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            count++;
        }
    }
}