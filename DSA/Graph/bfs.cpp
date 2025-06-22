// #include<bits/stdc++.h>
// using namespace std;

// vector<int> Bfs(int vertices , vector<int> adj[],int start){
//     queue<int> q;
//     vector<int> vis(vertices+1,0); 
//     q.push(start);
//     vis[start] = 1;
//     vector<int> ans;
//     while(!q.empty()){
//         int val = q.front();
//         q.pop();
//         ans.push_back(val);
//         for(int x : adj[val]){
//             if(!vis[x]){
//             q.push(x);
//             vis[x]=1;
//             }
//         }
//     }
//     return ans;
// }

// int main() {
//     int n, m;
//     cout << "Enter number of vertices and edges: ";
//     cin >> n >> m;

//     vector<int> adj[n+1];

//     cout << "Enter edges :\n";
//     for (int i = 0; i < m; i++) {
//         int u, v;
//         cin >> u >> v;
//         adj[u].push_back(v);
//         adj[v].push_back(u); // For undirected graph
//     }

//     vector<int> result = Bfs(n, adj,0);

//     cout << "BFS Traversal : ";
//     for (int x : result)
//         cout << x << " ";
//     cout << endl;

//     return 0;
// }

// #include<bits/stdc++.h>
// using namespace std;

// vector<int> bfs(vector<vector<int>> adj , int start,int v){
//     vector<int> ans;
//     queue<int> q; 
//     vector<int> visited(v,0);
//     q.push(start);
//     visited[start] = 1;
//     while(!q.empty()){
//         int val = q.front();
//         q.pop();
//         ans.push_back(val);
//         for(int x : adj[val]){
//             if(!visited[x]){
//                 q.push(x);
//                 visited[x]=1;
//             }
//         }
//     }
//     return ans;
// }

// int main(






#include<bits/stdc++.h>
using namespace std;

vector<vector<int>> bfs(vector<vector<int>> &adj,int start){
    int n = adj.size();
    vector<int> vis(n,0);
    vector<vector<int>> ans;
    queue<int> q;
    q.push(start);
    vis[start] = 1;

    while(!q.empty()){
        vector<int> level;
        int val = q.front();
        q.pop();
        int size = q.size();
        while(size--){
            
            level.push_back(val);
        for(auto x: adj[val]){
            if(!vis[x]){
                q.push(x);
            }
        }
    }
    ans.push_back(level);
    }
    return ans;
}
int main(){
    int a;

}