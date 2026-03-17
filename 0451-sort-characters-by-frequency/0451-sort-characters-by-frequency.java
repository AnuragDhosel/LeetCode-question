class Solution {
    public String frequencySort(String s) {
        HashMap<Character , Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c , 1);
            else map.put(c , map.get(c)+1);
        }

        // make stringBuilder 
        StringBuilder sb = new StringBuilder();
        int n = map.size();
        for(int i=0; i<n; i++){
            int maxFreq = 0;
            char ch = 0;
            for(char key : map.keySet()){
                if(maxFreq < map.get(key)){
                    maxFreq = map.get(key);
                    ch = key;
                }
            }
            while(maxFreq-- > 0){
                sb.append(ch);
            }
            map.remove(ch);
        }
        

        return sb.toString();
    }
}