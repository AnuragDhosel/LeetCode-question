class Solution {
    public String reverseWords(String s) {
        String tr = s.trim(); // remove leading and trailing whitespace from a string

        ArrayList<StringBuilder> list = new ArrayList<>();
        int i = 0;
        while(i<s.length()){
            if(s.charAt(i) != ' '){
                StringBuilder temp = new StringBuilder();
                int j = i;
                while(j<s.length() && s.charAt(j) != ' '){
                    temp.append(s.charAt(j));
                    j++;
                }
                list.add(temp);
                i = j;
            }
            i++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int x=list.size()-1; x>=0; x--){
            sb.append(list.get(x));
            if(x != 0) sb.append(' ');
        }

        return sb.toString();
    }
}