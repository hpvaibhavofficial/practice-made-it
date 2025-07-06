
#include<bits/stdc++.h>
using namespace std;

void bfs(vector<vector<int>> &adj,int start){
    vector<int> vis(adj.size(),0);
    queue<int> q;
    q.push(start);
    vis[start] = 1;
  
    while (!q.empty())
    {
        int node = q.front();
        cout<<node<<" ";
        q.pop();
        for(auto x : adj[node]){
            if(!vis[x]){
                q.push(x);
                vis[x]=1;
            }
        }
    }
    
    

}

int main(){
    int n ,m;
    cin>>n>>m;
    int u,v;
    vector<vector<int>> adj(n);
    for(int i=0;i<m;i++){
        cin>>u>>v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    bfs(adj,0);
}