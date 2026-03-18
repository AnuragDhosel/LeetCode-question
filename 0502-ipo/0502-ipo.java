class Element implements Comparable<Element>{
    int profit;
    int capi;
    Element(int profit , int capi){
        this.profit = profit;
        this.capi = capi;
    }

    public int compareTo(Element that){
        return this.capi - that.capi;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Element> minPQ = new PriorityQueue<>();

        for(int i=0; i<capital.length; i++){
            Element elem = new Element(profits[i] , capital[i]);
            minPQ.add(elem);
        }

        // w ke barabar ya kam me maximum profit dekhna hai
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        while(k-- > 0){
        // find all projects whose capital is less than or equal to w
            while(!minPQ.isEmpty() && minPQ.peek().capi <= w){
                maxPQ.add(minPQ.poll().profit);
            }
            if(maxPQ.isEmpty()) break;
            w += maxPQ.poll();
        }

        return w;
    }
}