class Solution {
    public int findKthPositive(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        int num = 1;
        for(int i=0; i<arr.length; i++){
            if(i == 0){
                while(num < arr[i] && list.size() < k){
                    list.add(num);
                    num++;
                }
                if(list.size() == k) return list.get(list.size()-1);
            }
            else{
                if(arr[i-1] + 1 != arr[i]){
                    num = arr[i-1] + 1;
                    while(num < arr[i] && list.size() < k){
                        list.add(num);
                        num++;
                    }
                    if(list.size() == k) return list.get(list.size()-1);
                }
            }
        }

        num = arr[arr.length - 1];

        return num + k - list.size();
    }
}