class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int n = s.length();

        int left = 0 , right = 0;
        int count = 0;
        while(right < n){
            if(s.charAt(right) == '1'){
                count++;

                if(count == k){
                    // Remove leading zeros
                    while(left < n && s.charAt(left) == '0'){
                        left++;
                    }

                    String curr = s.substring(left , right+1);

                    if(ans.isEmpty() || ans.length() > curr.length() || 
                    (ans.length() == curr.length() && curr.compareTo(ans) < 0)){
                        ans = curr;
                    }

                    // remove starting 1
                    left++;
                    count--;
                }
            }
            right++;
        }

        return ans;
    }
}