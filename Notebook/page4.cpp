// #include<bits/stdc++.h>
// using namespace std;

// int main(){
//     int n ,m;
//     cin>>n>>m;
//     int u,v;
//     vector<vector<int>> adj(n);
//     for(int i=0;i<m;i++){
//         cin>>u>>v;
//         adj[u].push_back(v);
//         adj[v].push_back(u);
//     }

//     for(int i=0;i<n;i++){
//         cout<<"Neighbours of "<<i<<" are : ";
//         for(auto x : adj[i]){
//             cout<<x<<" ";
//         }
//         cout<<endl;
//     }

// }

// //
// #include<bits/stdc++.h>
// using namespace std;

// void bfs(vector<vector<int>> &adj,int start){
//     vector<int> vis(adj.size(),0);
//     queue<int> q;
//     q.push(start);
//     vis[start] = 1;
  
//     while (!q.empty())
//     {
//         int node = q.front();
//         cout<<node<<" ";
//         q.pop();
//         for(auto x : adj[node]){
//             if(!vis[x]){
//                 q.push(x);
//                 vis[x]=1;
//             }
//         }
//     }
    
    

// }

#include<bits/stdc++.h>
using namespace std;

//dfs
void dfsHlpr(vector<vector<int>> &adj,int start,vector<int> &vis){
   
    vis[start]=1;
    cout<<start<<" ";
    for(auto x : adj[start]){
        if(!vis[x]){
            dfsHlpr(adj,x,vis);
        }
    }

}
void dfs(vector<vector<int>> &adj ,  int start){
    vector<int> vis(adj.size(),0);
    dfsHlpr(adj,start,vis);
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

    //bfs(adj,0);
    dfs(adj,0);
    
}


//