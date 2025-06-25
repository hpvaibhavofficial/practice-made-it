#include<bits/stdc++.h>
using namespace std;

void dfs(int row, int col,vector<vector<char>> &grid,vector<vector<int>> &vis){
    
    if(row<0 || col < 0 || row >= grid.size() || col >= grid[0].size() || vis[row][col] == 1 || grid[row][col] == '0'){
        return;
    }

    vis[row][col] = 1;
    

    int r[] = {0,0,1,-1};
    int c[] = {1,-1,0,0};

    for(int i=0;i<4;i++){
        dfs(row + r[i], col + c[i], grid, vis);

    }
    // dfs(row-1,col,grid,vis);
    // dfs(row+1,col,grid,vis);
    // dfs(row,col-1,grid,vis);
    // dfs(row,col+1,grid,vis);
}

int noOfIslands(vector<vector<char>> &grid){
    vector<vector<int>> vis(grid.size(),vector<int>(grid[0].size(),0)); int cnt =0;
    for(int i=0;i<grid.size();i++){
        for(int j=0;j<grid[0].size();j++){
            if(grid[i][j]=='1' && vis[i][j] == 0){
                cnt++;
                dfs(i,j,grid,vis);
            }
        }
    }
    return cnt;
}

void bfs(int row, int col,vector<vector<char>> &grid,vector<vector<int>> &vis){
    int n = grid.size();
    int m = grid[0].size();
    queue<pair<int,int>> q;
    q.push({row,col});
    vis[row][col]=1;

    while(!q.empty()){
        int rr = q.front().first;
        int cc = q.front().second;
        q.pop();
        int r[] = {0,0,1,-1};
        int c[] = {1,-1,0,0};

    for(int i=0;i<4;i++){
        int delrow = rr+r[i];
        int delcol = cc+c[i];
        if(delrow >= 0 && delcol >= 0 && delrow < n && delcol < m &&
                !vis[delrow][delcol] && grid[delrow][delcol] == '1'){
            q.push({delrow,delcol});
            vis[delrow][delcol] =1;
        }
    }
    }
}

int main() {
    vector<vector<char>> grid = {
        {'1','1','0','0','0'},
        {'1','1','0','1','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}
    };

    cout << "Number of islands: " << noOfIslands(grid) << endl;
    return 0;
}

