class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i=1; i<=n/2; i++){
            if(n % i == 0){
                String sub = s.substring(0 , i);
                int j = i;
                while(j < n){
                    String sub2 = s.substring(j , j+i);
                    if(sub.equals(sub2)){
                        j += i;
                    }
                    else break;
                }
                if(j >= n) return true;
            }
        }
        return false;
    }
}