class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            sb.append(s.charAt(i));
        }

        int i=0 , j=s.length()-1;
        while(i < j){
            char c1 = sb.charAt(i);
            char c2 = sb.charAt(j);

            if(set.contains(c1) && set.contains(c2)){
                char temp = sb.charAt(i);
                sb.setCharAt(i , sb.charAt(j));
                sb.setCharAt(j , temp);
                i++;
                j--;
            }
            else if(set.contains(c1)) j--;
            else if(set.contains(c2)) i++;
            else{
                i++;
                j--;
            }
        }

        return sb.toString();
    }
}