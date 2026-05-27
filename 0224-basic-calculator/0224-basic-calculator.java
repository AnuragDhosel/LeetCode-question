class Solution {
    public int calculate(String s) {
        Stack<Long> st = new Stack<>();
        long result = 0;
        long number = 0;
        long sign = 1;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(c == ' ') continue;
            else if(Character.isDigit(c)){
                number = (number * 10) + (c - '0');
            }

            else if(c == '+'){
                result += number * sign;
                number = 0;
                sign = 1;
            }
            else if(c == '-'){
                result += number * sign;
                number = 0;
                sign = -1;
            }

            else if(c == '('){
                st.push(result);
                st.push(sign);
                result = 0;
                sign = +1;
            }
            else if(c == ')'){
                result += number * sign;
                number = 0;
                result = result * st.pop(); // for sign
                result = result + st.pop(); // for number
            }
        }
        // 
        result += number * sign;

        return (int)result;
    }
}