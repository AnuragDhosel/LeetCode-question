class Solution {
    public String reverseWords(String s) {
        String tr = s.trim();

        ArrayList<StringBuilder> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
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
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=list.size()-1; i>=0; i--){
            sb.append(list.get(i));
            if(i != 0) sb.append(' ');
        }

        return sb.toString();
    }
}