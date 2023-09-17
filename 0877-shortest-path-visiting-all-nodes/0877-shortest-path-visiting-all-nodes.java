class Solution {
    
    public int shortestPathLength(int[][] graph) {
        
        if (graph.length == 1)
            return 0;
        
        int n = graph.length;
        Set<Integer> [] visited = new HashSet[n];
        Queue<Node> queue = new LinkedList<>();
        
        int finalMask = (1 << n) - 1;   // (2^n) - 1 -> all bit set
        
        // Add all nodes to queue, as all of them can be starting nodes
        for (int i = 0; i < n; i++) {
            int mask = (1 << i);
            queue.offer(new Node(i, 0, mask));
            visited[i] = new HashSet<>();
            visited[i].add(mask);
        }
     
        // BFS traversal
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.mask == finalMask)
                return curNode.steps;
            for (int neighbor : graph[curNode.nodeVal]) {
                int newMask = curNode.mask | (1 << neighbor);

                if (!visited[neighbor].contains(newMask)) {
                    visited[neighbor].add(newMask);
                    queue.offer(new Node(neighbor, curNode.steps+1, newMask));
                }
            }
        }
        return -1;
        
    }
    
    
    public class Node {
        int nodeVal;
        int steps;
        int mask;
        
        Node (int nodeVal, int steps, int mask) {
            this.nodeVal = nodeVal;
            this.steps = steps;
            this.mask = mask;
        }
        
    }
    
    
}