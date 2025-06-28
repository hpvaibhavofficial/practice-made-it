//leetcode 2099. Find Subsequence of Length K With the Largest Sum.

#include<bits/stdc++.h>
using namespace std;

class Solution {
public:

    static bool compareInd(pair<int,int> a,pair<int,int> b){
        return a.second < b.second;
    }

    static bool compareVal(pair<int,int> a,pair<int,int> b){
        return a.first>b.first;
    }

    vector<int> maxSubsequence(vector<int>& arr, int x) {
        vector<pair<int,int>> vec ;vector<int> ans;
        for(int i=0;i<arr.size();i++){
            vec.push_back({arr[i],i});
        }
        sort(vec.begin(),vec.end(),compareVal);
        vector<pair<int,int>> topp(vec.begin(),vec.begin()+x);
        sort(topp.begin(),topp.end(),compareInd);
        for(int i=0;i<x;i++){
            ans.push_back(vec[i].first);
        }
        return ans;
    }
};

int main(){
     Solution sol;
    vector<int> arr = {2, 1, 3, 3};
    int k = 2;

    vector<int> result = sol.maxSubsequence(arr, k);
    for (int val : result) {
        cout << val << " ";
    }
    cout << endl;
    return 0;
}