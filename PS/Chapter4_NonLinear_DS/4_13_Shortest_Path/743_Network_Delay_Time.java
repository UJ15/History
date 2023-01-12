class GraphNode{
    int val;
    int wt;
    List<GraphNode> next;
    GraphNode(int v,int w){
        wt=w;
        val=v;
        next = new ArrayList<>();
    }
}

class MyComparator implements Comparator<GraphNode>{
    public int compare(GraphNode a,GraphNode b){ return a.wt - b.wt;}
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int max = 0;
        GraphNode[] g = new GraphNode[n+1];
        if(n==1) return 0;
        for(int i=1;i<=n;i++) g[i] = new GraphNode(i,Integer.MAX_VALUE);
        for(int i=0;i<times.length;i++){
            g[times[i][0]].next.add(new GraphNode(times[i][1],times[i][2]));
        }
        g[k].wt=0;
        MyComparator tempCompare = new MyComparator();
        PriorityQueue<GraphNode> pq = new PriorityQueue<>(tempCompare);
        pq.add(new GraphNode(k,0));
        while(!pq.isEmpty()){
            GraphNode node = pq.remove();
            if(g[node.val].wt > node.wt) g[node.val].wt = node.wt;
            for(GraphNode next : g[node.val].next){
                if(g[next.val].wt > g[node.val].wt + next.wt)
                    pq.add(new GraphNode(next.val,g[node.val].wt + next.wt));
            }
        }
        for(int i=1;i<=n;i++){
            if(g[i].wt > max) max = g[i].wt;
        }
        return max==Integer.MAX_VALUE?-1:max;
    }
}
