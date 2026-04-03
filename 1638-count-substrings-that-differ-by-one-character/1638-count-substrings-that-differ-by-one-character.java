class Solution {
    public int countSubstrings(String s, String t) {
        ArrayList<String> Slist = findAllSubstring(s);
        ArrayList<String> Tlist = findAllSubstring(t);      

        System.out.println(Slist);
        System.out.println(Tlist);

        // check equal or not
        int count = 0;
        for(int i=0; i<Slist.size(); i++){
            String t_ns = Slist.get(i);

            for(int j=0; j<Tlist.size(); j++){
                String s_ns = Tlist.get(j);
                if(t_ns.length() == s_ns.length()){
                    if(checkDifferent(t_ns , s_ns) == 1){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public ArrayList<String> findAllSubstring(String s){
        ArrayList<String> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                String sub = s.substring(i , j);
                list.add(sub);
            }
        }
        return list;
    }
    public int checkDifferent(String t , String s){
        int diff = 0;
        for(int i=0; i<t.length(); i++){
            if(t.charAt(i) != s.charAt(i)){
                diff++;
                if(diff == 2) return 0;
            }
        }
        if(diff == 1) return 1;
        return 0;
    }
}