class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i=0; i<s.length(); i++){
            int charNum = s.charAt(i) - 'a';
            ans += (26 - charNum) * (i+1);
        }
        return ans;
    }
}