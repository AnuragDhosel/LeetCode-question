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

        // 2. handle  sign
        boolean isNeg = false;
        if(i<n && (s.charAt(i) == '-' || s.charAt(i) == '+')){ // + added for +1 tastcase
            if(s.charAt(i) == '-') isNeg = true;
            i++;
        }

        // handle digit
        int num = 0;
        while(i<n && (s.charAt(i) >= '0' && s.charAt(i) <= '9') ){
            int digit = s.charAt(i) - '0';

            // Overflow check
            if((num > Integer.MAX_VALUE / 10) || (num == Integer.MAX_VALUE/10 && digit>7)){
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            num = num*10 + digit;
            i++;
        }

        return isNeg ? -num : num;
    }
}