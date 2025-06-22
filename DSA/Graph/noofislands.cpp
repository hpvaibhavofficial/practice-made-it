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
