class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Step 1: Keep appending until length >= b
        while(sb.length() < b.length()){
            sb.append(a);
            count++;
        }

        // Step 2: Check
        if(sb.indexOf(b) != -1) return count;

        // Step 3: One more append (important case)
        sb.append(a);
        count++;
        if(sb.indexOf(b) != -1) return count;

        return -1;
    }
}