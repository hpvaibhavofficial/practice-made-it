// #include<bits/stdc++.h>
// using namespace std;

// void dfsHelper(vector<vector<int>> &adj, int start,vector<int> vis, vector<int> ans){
//     vis[start] =1;
//     ans.push_back(start);
//     for(int x : adj[start]){
//         if(!vis[x])
//         dfsHelper(adj,x,vis,ans);
//     }
// }

// vector<int> dfs(vector<vector<int>> adj,int start,int v){
//     vector<int> ans;
//     vector<int> vis(v,0);
//     dfsHelper(adj,start,vis,ans);
//     return ans;
// }
// int main(){

// }

// #include<bits/stdc++.h>
// using namespace std;

// void dfsHelper(int s,vector<vector<int>>&adj,vector<int> &vis){
//     vis[s] = 1;
//     cout<<s<<" ";
//     for(auto x : adj[s]){
//         if(!vis[x]){
//             dfsHelper(x,adj,vis);
//         }
//     }
// }
// void dfs(vector<vector<int>> &adj,int start){
//     int n = adj.size();
//     vector<int> vis(n,0);
//     dfsHelper(start,adj,vis);
// }
// int main(){
//     vector<vector<int>> adj(6);
//     adj[1] = {2};
//     adj[2] = {1,3,4,5};
//     adj[3] = {2};
//     adj[4] = {2};
//     adj[5] = {2};

//     dfs(adj,2);

// }

#include<bits/stdc++.h>

using namespace std;

void dfsHelper(vector<vector<int>> &adj,int start,vector<int> & vis,vector<int> &ans){
    ans.push_back(start);
    vis[start]=1;
    for(int x : adj[start]){
        if(!vis[x]){
          dfsHelper(adj,x,vis,ans);  
        } 
    } 
}
vector<int> dfs(vector<vector<int>> &adj,int start){
    int n = adj.size();
    vector<int> vis(n,0);
    vector<int> ans;
    dfsHelper(adj,start,vis,ans);
    return ans;
}
int main(){
}