class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            String s = strs[i];
            char [] arr = s.toCharArray();
            Arrays.sort(arr);

            StringBuilder sb = new StringBuilder();
            for(int j=0; j<arr.length; j++){
                sb.append(arr[j]);
            }
            String s2 = sb.toString();

            if(!map.containsKey(s2)){
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s2 , list);
            }
            else{
                List<String> list = map.get(s2);
                list.add(strs[i]);
                map.put(s2 , list);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()){
            List<String> list = map.get(key);
            ans.add(list);
        }

        return ans;
    }
}