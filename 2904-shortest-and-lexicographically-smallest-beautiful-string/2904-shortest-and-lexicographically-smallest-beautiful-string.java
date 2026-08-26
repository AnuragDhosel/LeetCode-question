class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String ans = "";
    
        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            int count = 0;

            for(int j=i; j<n; j++){
                sb.append(s.charAt(j));

                if(s.charAt(j) == '1'){
                    count++;

                    if(count == k){
                        String curr = sb.toString();
                        if(ans == "" || ans.length() > curr.length() || 
                            (ans.length() == curr.length() && curr.compareTo(ans) < 0)
                            ){
                            ans = curr;
                        }
                    }
                }
            }
        }

        return ans;
    }
}