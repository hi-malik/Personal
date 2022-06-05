class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V + 1];
        Arrays.fill(vis, false);
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                if(isCycleDFS(i, -1, vis, adj)) return true;
            }
        }
        return false;
    }
    public boolean isCycleDFS(int node, int par, boolean vis[], ArrayList<ArrayList<Integer>> adj){
        vis[node] = true;
        for(Integer i : adj.get(node)){
            if(vis[i] == false){
                if(isCycleDFS(i, node, vis, adj) == true) return true;
            }
            else if(i != par) return true;
        }
        return false;
    }
}
