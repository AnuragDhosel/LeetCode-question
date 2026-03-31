class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if(n != goal.length()) return false;

        for(int st=0; st<s.length(); st++){

            int i = st; // for s string
            int j = 0; // for goal string
            while(j < goal.length()){
                if(s.charAt(i % n) == goal.charAt(j)){
                    i++;
                    j++;
                }
                else break;
            }
            if(j == goal.length()) return true;
        }
        return false;
    }
}