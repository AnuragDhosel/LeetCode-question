class Solution {
    public int minBitFlips(int start, int goal) {
        StringBuilder st = convertToBinary(start);
        StringBuilder end = convertToBinary(goal);

        int count = 0;
        int i = st.length()-1 , j = end.length()-1;
        while(i >= 0 && j >= 0){
            if(st.charAt(i) != end.charAt(j)) count++;
            i--;
            j--;
        }
        
        while(i >= 0){
            if(st.charAt(i) == '1') count++;
            i--;
        }
        while(j >= 0){
            if(end.charAt(j) == '1') count++;
            j--;
        }

        return count;
    }
    public StringBuilder convertToBinary(int num){
        StringBuilder sb = new StringBuilder();

        if (num == 0)
            return sb.append('0');

        while(num > 0){
            sb.append(num % 2);
            num /= 2;
        }
        
        sb.reverse();
        return sb;
    }
}