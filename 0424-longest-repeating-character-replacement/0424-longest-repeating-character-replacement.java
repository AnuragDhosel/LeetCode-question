class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character , Integer> map = new HashMap<>();

        int l = 0;
        int maxL = 0;
        int maxFreq = 0;
        for(int r=0; r<s.length(); r++){
            char c = s.charAt(r);

            if(!map.containsKey(c)) map.put(c , 1);
            else map.put(c , map.get(c)+1);

            maxFreq = Math.max(maxFreq , map.get(c));
            
            while(l<r && (r-l+1) - maxFreq > k){
                if(map.get(s.charAt(l)) == 1) map.remove(s.charAt(l));
                else map.put(s.charAt(l) , map.get(s.charAt(l))-1);
                l++;
            }

            maxL = Math.max(maxL , r-l+1); 
        }
        return maxL;
    }
}