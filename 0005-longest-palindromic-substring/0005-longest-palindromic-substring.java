class Solution {
    int maxL = -1;
    int st = -1 , end = -1;
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++){
            // for odd size
            palindromeSize(s , i , i);
            // for enven size
            palindromeSize(s , i , i+1);
        }
        return s.substring(st , end+1);
    }
    public void palindromeSize(String s , int l , int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if(maxL < r-l+1){
                maxL = r-l+1;
                st = l;
                end = r;
            }
            l--;
            r++;
        }

    }
}