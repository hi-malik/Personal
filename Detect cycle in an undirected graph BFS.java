class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V + 1];
        Arrays.fill(vis, false);
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                if(isCycleBFS(adj, i, vis)) return true;
            }
        }
        return false;
    }
    public boolean isCycleBFS(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[]){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, -1));
        vis[s] = true;
        
        while(!q.isEmpty()){
            int node = q.peek().first;
            int par = q.peek().second;
            q.remove();
            for(Integer i : adj.get(node)){
                if(vis[i] == false){
                    q.add(new Node(i, node));
                    vis[i] = true;
                }
                else if(par != i) return true;
            }
        }
        return false;
    }
}
class Node{
    int first;
    int second;
    public Node(int first, int second){
        this.first = first;
        this.second = second;
    }
}
