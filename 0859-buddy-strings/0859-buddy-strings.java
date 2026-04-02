class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;

        // if strings are equal :- abab/abab , aaa/aaa , ab/ab , abcd/abcd
        if(s.equals(goal)){
            // check any character may occcurs more than 1 time -> then it same 
            int [] freq = new int[26];
            
            for(int i=0; i<s.length(); i++){
                char c = s.charAt(i);
                freq[c-'a']++;
                if(freq[c-'a'] > 1){ // it contain same char , still same -> swap
                    return true;
                }
            }
            return false;
        }

        // if string are mismatched
        int first = -1 , second = -1;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)){
                if(first == -1){
                    first = i;
                }
                else if(second == -1){
                    second = i;
                }
                else{
                    return false;
                }
            }
        }

        // check mismatched
        if(second != -1 &&
            s.charAt(first) == goal.charAt(second) && 
            s.charAt(second) == goal.charAt(first)
            ){
                return true;
            }
        return false;  
    }
}