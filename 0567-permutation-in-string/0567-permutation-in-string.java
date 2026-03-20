class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character , Integer> map = new HashMap<>();
        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            if(!map.containsKey(c)) map.put(c , 1);
            else map.put(c , map.get(c)+1);
        }

        int k = s1.length();
        int l = 0;
        for(int r=0; r<s2.length(); r++){
            char c = s2.charAt(r);

            if(map.containsKey(c)){
                map.put(c , map.get(c)-1);
            } 

            if(r-l+1 == k){
                if(isMapZero(map)) return true;

                // shrink
                char c1 = s2.charAt(l);
                if(map.containsKey(c1)) map.put(c1 , map.get(c1)+1);
                l++;
            }
        }
        return false;
    }
    public boolean isMapZero(HashMap<Character , Integer> map){
        for(char key : map.keySet()){
            if(map.get(key) != 0) return false;
        }
        return true;
    }
}