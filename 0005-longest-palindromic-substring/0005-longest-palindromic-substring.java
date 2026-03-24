class Solution {
    public String longestPalindrome(String s) {
        // if(s.length() <= 1) return s;

        String maxPal = "";
        for(int i=0; i<s.length(); i++){
            for(int j=i; j<s.length(); j++){
                String sub = s.substring(i , j+1);
                
                if(isPalindrome(sub)){
                    if(maxPal.length() < sub.length()){
                        maxPal = sub;
                    }
                }
            }
        }
        return maxPal;
    }
    public boolean isPalindrome(String s){
        int i=0 , j=s.length()-1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}