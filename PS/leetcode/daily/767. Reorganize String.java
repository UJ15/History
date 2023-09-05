public class pair{
    char ch;
    int val;
    public pair(char ch,int val){
        this.ch=ch;
        this.val=val;
    }
}
class Solution {
    public String reorganizeString(String s) {
        int n=s.length();
        if(n==0) return "";
        StringBuffer buff=new StringBuffer("");
        int arr[]=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            arr[ch-'a']++;
        }
        PriorityQueue<pair> pq = new PriorityQueue<>(
                (p1, p2) -> Integer.compare(p2.val, p1.val)); // Lambda expression for custom comparison
        for(int i=0;i<26;i++){
            if(arr[i]>0){
                pq.add(new pair((char)(i+97),arr[i]));
            }
        }
        char ch1=' ';
        pair prev=null;
        while (!pq.isEmpty()) {
            pair curr = pq.poll();//removing maximum element so that in next iteration we are not putting the same element
            buff.append(curr.ch);
            curr.val--;
            if (prev != null && prev.val > 0) {
                pq.add(prev);  //in next iterartion we are putting the removed element so that it can be processed for further calculations
            }
            prev = curr;
        }
        if (buff.length() != n) {
            return "";
        }

        return buff.toString();
    }
}