class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int k = p.length();
        for(int i=0; i<=s.length()-k; i++){
            String sub = s.substring(i , k+i);
            if(areAnagram(sub , p)) ans.add(i);
        }
        return ans;
    }

    public boolean areAnagram(String s1 , String s2){
        char [] arr1 = s1.toCharArray();
        char [] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i=0; i<arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}