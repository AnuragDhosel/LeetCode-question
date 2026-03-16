class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        
        int k = p.length();
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i=0; i<p.length(); i++){
            char c = p.charAt(i);
            if(!map.containsKey(c)) map.put(c , 1);
            else map.put(c , map.get(c)+1);
        }

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(map.containsKey(c)) map.put(c , map.get(c)-1);
        
            if(i >= k-1){
                int count = 0;
                for(char key : map.keySet()){
                    if(map.get(key) == 0) count++;
                }
                if(count == map.size()) ans.add(i-k+1);

                if(map.containsKey(s.charAt(i-k+1))){
                    map.put(s.charAt(i-k+1) , map.get(s.charAt(i-k+1))+1);
                } 
            }
            
        }

        return ans;
    }
}