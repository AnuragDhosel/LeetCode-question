class Solution {
    public boolean closeStrings(String s1, String s2) {
        if(s1.length() !=  s2.length()) return false;
        
        int [] freq1 = new int[26]; 
        int [] freq2 = new int[26];

        for(int i=0; i<s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            freq1[c1-'a']++;
            freq2[c2-'a']++;
        } 

        // character exists in word2 but not in word1 ❌
        // character exists in word1 but not in word2 ❌
        for(int i=0; i<25; i++){
            if((freq2[i] != 0 && freq1[i] == 0)||(freq1[i] != 0 && freq2[i] == 0)){
                return false;
            }
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for(int i=25; i>=0; i--){
            if(freq1[i] != freq2[i]) return false;
        }

        return true;     
    }
}