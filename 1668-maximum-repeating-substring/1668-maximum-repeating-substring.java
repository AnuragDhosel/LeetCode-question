class Solution {
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        String temp = word;
        
        while (kmpSearch(sequence, temp)) {
            count++;
            temp += word;
        }
        
        return count;
    }

    private boolean kmpSearch(String text, String pattern) {
        int[] lps = buildLPS(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                if (j == pattern.length()) return true;
            } else {
                if (j != 0) j = lps[j - 1];
                else i++;
            }
        }
        return false;
    }

    private int[] buildLPS(String s) {
        int[] lps = new int[s.length()];
        int i = 1, len = 0;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) len = lps[len - 1];
                else i++;
            }
        }
        return lps;
    }
}