class Solution {
    public String shortestPalindrome(String s) {
        String newStr = s + '#' + reverse(s);
        System.out.println(newStr);

        int [] lps = calculateLPS(newStr);

        String sub = s.substring(lps[lps.length-1] , s.length());
        System.out.println(sub);
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