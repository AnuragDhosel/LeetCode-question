class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;
        int n = s.length();

        HashSet<Character> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;
        for(int i=0; i<s.length(); i++){
            set.add(s.charAt(i));
            if(s.charAt(i) != goal.charAt(i)){
                list.add(i);
            }
        }

        if(list.size() != 2 && list.size() != 0) return false;

        if(list.size() == 2){
            int a = list.get(0);
            int b = list.get(1);
            if(s.charAt(a) == goal.charAt(b) && s.charAt(b) == goal.charAt(a)) return true;
            else return false;
        }
        else if(list.size() == 0){
            if(set.size() == s.length()){ // abcd/abcd , ab/ab , abc/abc
                return false;
            }
            else if(set.size() == 0){ // aaa/aaa  , aa/aa
                return true;
            }
            else{ // aba/aba , abab/abab
                return true;
            }
        }
        return true;
    }
}