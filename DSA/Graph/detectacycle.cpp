#include<bits/stdc++.h>
using namespace std;


bool dfs(vector<vector<int>> &adj, vector<int> &vis,int node,int parent ){
    vis[node]=1;
    for(int x : adj[node]){
        if(!vis[x]){
            if(dfs(adj,vis,x,node) == true){ return true; } 
        }
        else if(x!=parent){
            return true;
        }
    }
    return false;
}
bool hasCycle(vector<vector<int>> &adj, int n,vector<int> &vis){
    for(int i = 0;i<n;i++){
        if(!vis[i]){
            if(dfs(adj,vis,i,-1) == true) return true ;
        } 
    }
    return false;
}
// bool detectCycle(vector<vector<int>> &adj, int n,vector<int> &vis,int src){
//     queue<pair<int,int>> q;
//     q.push({src,-1});
//     vis[src] = 1;

//     while(!q.empty()){
//         int node = q.front().first;
//         int parent  = q.front().second;
//         q.pop();
//         for(auto x : adj[node]){
//             if(!vis[x]){
//                 q.push({x,node});
//                 vis[x]=1;
//             } 
//             else if(x != parent){
//                 return true;
//             }
//         }
//     }
//     return false;
// }

int main(){
    int n,m;
    cout<<"Enter nodes and vertices : ";
    cin>>n>>m;
    vector<vector<int>> adj(n);
    cout<<"Enter edges : ";
    
    for(int i=0;i<m;i++){
        int u,v;
        cin>>u>>v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    vector<int> vis(n,0);

    // for(int i=0;i<n;i++){
    //     if(!vis[i]){
    //         if(detectaCycle(adj,n,vis,i)){
    //             cout<<"Cycle detected."<<endl;
    //             return 0;
    //         }
    //     }
    // }

    //for dfs
    if(hasCycle(adj,n,vis)){
        cout<<"Cycle detected."<<endl;
    }else{
        cout<<"No cycle detected.";
    }            
    return 0;
}


// Testcase
// 5 5
// 0 1
// 1 2
// 2 3
// 3 4
// 4 1 

//detect a cycle using bfs
// bool detectaCycle(vector<vector<int>> &adj, int n,vector<int> &vis,int src){
//     queue<pair<int,int>> q;
//     q.push({src,-1});
//     vis[src] =1;

//     while(!q.empty()){
//         int node = q.front().first;
//         int parent = q.front().second;
//         q.pop();
//         for(int x : adj[node]){
//             if(!vis[x]){
//                 q.push({x,node});
//                 vis[x]=1;
//             }
//             else if(x!=parent){
//                 return true;
//             }
//         }
//     }
//     return false;

// }

