class Element implements Comparable<Element>{
    int num;
    int freq;
    Element(int num , int freq){
        this.num = num;
        this.freq = freq;
    }
    public int compareTo(Element that){
        return that.freq - this.freq; // decreasing order
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])) map.put(nums[i] , 1);
            else map.put(nums[i] , map.get(nums[i]) + 1);
        }

        PriorityQueue<Element> pq = new PriorityQueue<>();
        for(int key : map.keySet()){
            Element elem = new Element(key , map.get(key));
            pq.add(elem);
        }

        int [] ans = new int[k];
        for(int i=0; i<k; i++){
            Element ele = pq.poll();
            ans[i] = ele.num;
        }

        return ans;
    }
}