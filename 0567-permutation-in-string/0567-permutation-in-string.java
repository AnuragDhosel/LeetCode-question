class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int l = 0;
        for(int i=k; i<=s2.length(); i++){
            String sub = s2.substring(l , i);
            if(isPermuted(s1 , sub)){
                return true;
            }
            l++;
        }
        return false;
    }
    public boolean isPermuted(String s , String t){
        char [] arr1 = s.toCharArray();
        char [] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i=0; i<arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }

        return true;
    }
}