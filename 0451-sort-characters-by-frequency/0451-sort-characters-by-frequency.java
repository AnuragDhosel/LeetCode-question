class Element implements Comparable<Element>{
    char ch;
    int freq;
    Element(char ch , int freq){
        this.ch = ch;
        this.freq = freq;
    }
    public int compareTo(Element that){
        // decreasing order
        return that.freq - this.freq;
    }
}

class Solution {
    public String frequencySort(String s) {
        HashMap<Character , Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)) map.put(c , 1);
            else map.put(c , map.get(c)+1);
        }

        // append elements in PQ
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for(char key : map.keySet()){
            Element element = new Element(key , map.get(key));
            pq.add(element);
        }

        // make stringBuilder 
        StringBuilder sb = new StringBuilder();
        while(pq.size() > 0){
            Element elem = pq.poll();
            while(elem.freq > 0){
                sb.append(elem.ch);
                elem.freq--;
            }
        }

        return sb.toString();
    }
}