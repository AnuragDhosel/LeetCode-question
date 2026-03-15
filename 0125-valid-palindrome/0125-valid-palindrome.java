class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        String s1 = s.toLowerCase();

        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
                sb.append(c);
            }
        }

        int i=0 , j=sb.length()-1;
        while(i < j){
            if(sb.charAt(i) != sb.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}