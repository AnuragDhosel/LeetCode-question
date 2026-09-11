class Solution {
    public String reorganizeString(String s) {
        HashMap<Character , Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c , 1);
            else map.put(c , map.get(c) + 1);
        }

        StringBuilder sb = new StringBuilder();
        char prevCh = '#';
        while(map.size() > 0){
            // find max freq character
            int maxFreq = 0;
            char currCh = '$'; // maxFreqChar
            for(char key : map.keySet()){
                if(maxFreq < map.get(key) && prevCh != key){
                    maxFreq = map.get(key);
                    currCh = key;
                }
            }
            prevCh = currCh;

            sb.append(currCh);
            if(currCh == '$') return "";
            map.put(currCh , map.get(currCh) - 1);
            
            if(map.get(currCh) == 0) map.remove(currCh);
        }

        return sb.toString();
    }
}