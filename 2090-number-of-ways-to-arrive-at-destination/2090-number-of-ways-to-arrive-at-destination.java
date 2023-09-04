class pair{
    long first;
    long second;
    pair(long a,long b){
        this.first=a;
        this.second=b;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        int len=roads.length;

        ArrayList<ArrayList<pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<len;i++){
            adj.get(roads[i][0]).add(new pair(roads[i][1],roads[i][2]));
             adj.get(roads[i][1]).add(new pair(roads[i][0],roads[i][2]));
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((pair1, pair2) -> Long.compare(pair1.first, pair2.first));
        long []dist=new long[n];
        long []ways=new long [n];
        for(int i=0;i<n;i++){
            dist[i]=Long.MAX_VALUE;
            ways[i]=0;
        }
        long mod=(long)(1e9+7);
        dist[0]=0;
        ways[0]=1;
        pq.add(new pair(0,0));
        while(pq.size()!=0){
            long dis=pq.peek().first ;
            long node=pq.peek().second;
            pq.remove();
            for(pair it:adj.get((int)node)){
                long adj_node=it.first;
                long edj_dist=it.second;
                if(dis+edj_dist<dist[(int)adj_node]){
                    dist[(int)adj_node]=dis+edj_dist;
                    pq.add(new pair(dis+edj_dist,adj_node));
                    ways[(int)adj_node]=ways[(int)node];
                }else if(dist[(int)adj_node]==dis+edj_dist){
                    ways[(int)adj_node]=ways[(int)adj_node]+ways[(int)node] % mod;
                }
            }

        }
        return (int)(ways[n-1] % mod);



    }
}