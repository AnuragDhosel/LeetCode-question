class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character , Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(!map.containsKey(c)) map.put(c , 1);
            else map.put(c , map.get(c)+1);
        }

        int count = 0;
        for(char key : map.keySet()){
            if(map.get(key) % 2 == 0){
                count += map.get(key);
            }
            else if(map.get(key) > 1){
                count += map.get(key)-1;
            }
        }

        if(count < s.length()) count++;

        return count;
    }
}