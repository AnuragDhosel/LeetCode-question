class Solution {
    public int maxDepth(String s) {
        int openB = 0;
        int maxOpenB = 0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c == '('){
                openB++;
                maxOpenB = Math.max(openB , maxOpenB);
            }
            else if(c == ')'){
                openB--;
            }
        }

        return maxOpenB;
    }
}