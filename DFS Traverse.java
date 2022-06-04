class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> dfs = new ArrayList<>();
        boolean vis[] = new boolean[V + 1];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                solve(i, vis, dfs, adj);
            }
        }
        return dfs;
    }
    public void solve(int node, boolean vis[], ArrayList<Integer> dfs, ArrayList<ArrayList<Integer>> adj){
        dfs.add(node);
        vis[node] = true;
        
        for(Integer i : adj.get(node)){
            if(vis[i] == false){
                solve(i, vis, dfs, adj);
            }
        }
    }
}
