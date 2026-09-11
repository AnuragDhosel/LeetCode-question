class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        int maxFreq = 0;
        int maxLetter = 0;
        
        // Find the most frequent character
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                maxLetter = i;
            }
        }
        
        // If the max frequency is more than half the string (rounded up), it's impossible
        if (maxFreq > (s.length() + 1) / 2) {
            return "";
        }
        
        char[] result = new char[s.length()];
        int index = 0;
        
        // Place the most frequent character at even indices
        while (freq[maxLetter] > 0) {
            result[index] = (char) (maxLetter + 'a');
            index += 2;
            freq[maxLetter]--;
        }
        
        // Place the remaining characters
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                // If we reach the end of even indices, switch to odd indices
                if (index >= s.length()) {
                    index = 1;
                }
                result[index] = (char) (i + 'a');
                index += 2;
                freq[i]--;
            }
        }
        
        return new String(result);
    }
}