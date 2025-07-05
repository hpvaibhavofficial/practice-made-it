// #include<bits/stdc++.h>
// using namespace std;

// int main(){
//     int n , m;
//     cout<<"Enter number of vertices and edges : ";
//     cin>>n>>m;

//     int adj[n+1][n+1];
//     for(int i=0 ;i<m;i++){
//         int u,v;
//         cin>>u>>v;
//         adj[u][v] = 1;
//         adj[v][u] = 1;

//     }
//     return 0;
// }



// #include<bits/stdc++.h>
// using namespace std;

// int main(){
//     int n,m;
//     cin>>n>>m;
//     vector<int> adj[n+1];
//     for(int i=0;i<m;i++){
//         int u,v;
//         cin>>u>>v;
//         adj[u].push_back(v);
//         adj[v].push_back(u);

//     }

//     for(int i=1;i<=n;i++){
//         cout<<"Node "<<i<<": ";
//         for(int x : adj[i]){
//             cout<<x<<" ";
//         }
//         cout<<endl;
//     }
//     return 0;
// }

//weighted
// #include<bits/stdc++.h>
// using namespace std;

// int main(){
//     int n,m;
//     cin>>n>>m;
//     vector<pair<int,int>>adj[n+1];
//     for(int i = 0 ;i<m;i++){
//         int u,v,w;
//         cin>>u>>v>>w;
//         adj[u].push_back({v,w});
//         adj[v].push_back({u,w});
//     }

//     for(int i=1;i<=n;i++){
//         cout<<"Node "<<i<<" : ";
//         for(auto x : adj[i]){
//             cout<<"("<<x.first<<" weight : "<<x.second<<")";
//         }
//         cout<<endl;
//     }
// }


// #include<bits/stdc++.h>
// using namespace std;

// int main(){
//     int n,m;
//     cin>>n>>m;

//     int adj[n+1][n+1];
//     for(int i=0 ;i<m;i++){
//         int u , v;
//         cin>>u>>v;
//         adj[u][v] = 1;
//         adj[v][u] = 1;
//     }

//     for(int i=0;i<=n;i++){
//         cout<<"Node "+i<<" : ";
//         for(int j=0;j<=n;j++){
//             cout<<adj[i][j]<<" ";
//         }
//         cout<<endl;
//     }
// }

#include<bits/stdc++.h>
using namespace std;

int main(){
    int n,m;
    cin>>n>>m;
    vector<int> adj[n+1];
    for(int i=0; i<m;i++){
        int u,v;
        cin>>u>>v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    for(int i=1; i<=n;i++){
        cout<<"Node "<<i<<" :";
        for(int x : adj[i]){
            cout<<x<<" ";
        }
        cout<<endl;

    }

}