class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        int ans = 0;

        for(int x=0; x<=n-m; x++){
            int count = 0;
            int maxC = 0;
            int i = x;
            while(i <= n-m){
                String sub = sequence.substring(i , i+m);
                if(sub.equals(word)){
                    count++;
                    i += m;
                }
                else{
                    maxC = Math.max(count , maxC);
                    count = 0;
                    i++;
                }   
            }
            maxC = Math.max(count , maxC);
            ans = Math.max(maxC , ans);
        }
        return ans;
    }
}