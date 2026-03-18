class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();

        int max = 0;
        int j = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            while(j<i && set.contains(c)){
                set.remove(s.charAt(j));
                    j++;
            }
            set.add(c);
            
            max = Math.max(max , i-j+1);
        }

        return max;
    }
}