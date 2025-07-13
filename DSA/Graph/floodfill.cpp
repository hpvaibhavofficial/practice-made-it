#include <bits/stdc++.h>
using namespace std;

void bfs(vector<vector<int>> &image, int sr, int sc, int color, int oc, int n, int m, vector<vector<int>> &vis) {
    queue<pair<int,int>> q;
    q.push({sr, sc});
    vis[sr][sc] = 1;
    image[sr][sc] = color;

    // Direction vectors: Right, Left, Down, Up
    int dr[] = {0, 0, 1, -1};
    int dc[] = {1, -1, 0, 0};

    while (!q.empty()) {
        int row = q.front().first;
        int col = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int rw = row + dr[i];
            int rc = col + dc[i];

            // Check for bounds, unvisited, and matching original color
            if (rw >= 0 && rc >= 0 && rw < n && rc < m && !vis[rw][rc] && image[rw][rc] == oc) {
                image[rw][rc] = color;
                vis[rw][rc] = 1;
                q.push({rw, rc});
            }
        }
    }
}

vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
    int n = image.size();
    int m = image[0].size();
    int oc = image[sr][sc];

    // Optimization: if starting pixel already has target color
    if (oc == color) return image;

    vector<vector<int>> vis(n, vector<int>(m, 0));
    bfs(image, sr, sc, color, oc, n, m, vis);
    return image;
}

int main() {
    vector<vector<int>> image = {
        {1, 1, 1},
        {1, 1, 0},
        {1, 0, 1}
    };
    int sr = 1, sc = 1, newColor = 2;

    vector<vector<int>> result = floodFill(image, sr, sc, newColor);

    // Print the modified image
    for (auto row : result) {
        for (int pixel : row) {
            cout << pixel << " ";
        }
        cout << endl;
    }

    return 0;
}
