class Solution {
    public boolean closeStrings(String s1, String s2) {
        if(s1.length() !=  s2.length()) return false;
        if(isNotSameChar(s1 , s2)) return false;
        
        int [] freq1 = new int[26]; 
        int [] freq2 = new int[26];

        for(int i=0; i<s1.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            freq1[c1-'a']++;
            freq2[c2-'a']++;
        } 

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for(int i=25; i>=0; i--){
            if(freq1[i] != freq2[i]) return false;
        }

        return true;     
    }
    public boolean isNotSameChar(String s , String t){
        HashSet<Character> set = new HashSet<>();

        for(int i=0; i<s.length(); i++) set.add(s.charAt(i));

        for(int i=0; i<t.length(); i++){
            if(!set.contains(t.charAt(i))) return true;
        }
        return false;
    }
}