class Solution {
    // leading " "(space) or 0 -> ignore 
    // if start from alphabet -> 0
    // if start from number -> number
    // "-123" -> -123 , "+123" -> 123
    public int myAtoi(String s) {
        int i = 0; 
        int n = s.length();

        // 1. handle leading spaces
        while(i < n && s.charAt(i) == ' '){
            i++;
        }

        // 2. handle sign
        boolean isNeg = false;
        if(i<n && (s.charAt(i) == '-' || s.charAt(i) == '+')){ // + added for +1 tastcase
            if(s.charAt(i) == '-') isNeg = true;
            i++;
        }

        // handle digit
        long num = 0;
        while(i<n && (s.charAt(i) >= '0' && s.charAt(i) <= '9') ){
            long digit = s.charAt(i) - '0';
            num = num*10 + digit;

            // Overflow check (imp)
            if(!isNeg && num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if(isNeg && num > (long)Integer.MAX_VALUE+1) return Integer.MIN_VALUE;
            
            i++;
        }

        return isNeg ? -(int)num : (int)num;
    }
}