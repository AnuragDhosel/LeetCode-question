class Solution {
    public String convert(String s, int k) {
        if(k == 1) return s;

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<k; i++){
            int lowerAdd = 2*(k-1-i);
            int upperAdd = 2*i;

            boolean goingLower = true;
            int idx = i;
            while(idx < s.length()){
                sb.append(s.charAt(idx));

                if(i == 0){
                    idx += lowerAdd;
                }
                else if(i == k-1){
                    idx += upperAdd;
                }
                else if(goingLower){
                    idx += lowerAdd;
                    goingLower = false;
                }
                else if(!goingLower){
                    idx += upperAdd;
                    goingLower = true;
                }
            }
        }

        return sb.toString();
    }
}