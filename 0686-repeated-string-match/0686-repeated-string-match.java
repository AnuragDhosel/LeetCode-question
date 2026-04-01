class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while(sb.length() < b.length()){
            sb.append(a);
            count++;
        }

        if(check_AcontainsB_usingKMP(sb , b)){
            return count;
        }

        sb.append(a);
        count++;
        if(check_AcontainsB_usingKMP(sb , b)){
            return count;
        }

        return -1;
    }

    public boolean check_AcontainsB_usingKMP(StringBuilder txt , String pat){
        int [] lps = calculateLPS(pat);

        int i = 0;
        int j = 0;
        while(i < txt.length()){
            if(txt.charAt(i) == pat.charAt(j)){
                i++;
                j++;
                if(j == pat.length()) return true;
            }
            else{
                if(j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return false;
    }
    public int[] calculateLPS(String s){
        int [] lps = new int[s.length()];

        int i = 1;
        int len = 0;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0) len = lps[len - 1];
                else i++;
            }
        }
        return lps;
    }
}