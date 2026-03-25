class Solution {
    int maxL = 0;
    int st = -1 , end = -1;
    public String longestPalindrome(String s) {
        for(int i=0; i<s.length(); i++){
            palindromeSize(s , i , i);
            
            palindromeSize(s , i , i+1);
        }
        return s.substring(st , end+1);
    }
    public void palindromeSize(String s , int l , int r){
        while(l >= 0 && r < s.length()){
            if(s.charAt(l) != s.charAt(r)) break;
            
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