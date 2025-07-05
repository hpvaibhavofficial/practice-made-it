#include<bits/stdc++.h>
using namespace std;

void findSubsequences(vector<int> &vec, int index,vector<int>&ds,int n){
    if(index >= n){
        for(auto x : ds){
            cout<<x<<" ";
        }
        cout<<endl;
        return;
    }

    ds.push_back(vec[index]);
    findSubsequences(vec,index+1,ds,n);
    ds.pop_back();
    findSubsequences(vec,index+1,ds,n);
}
int main(){
    vector<int> vec;
    string line;
    getline(cin, line);
    stringstream s(line);
    int x;
    while(s >> x){
        vec.push_back(x);
    }
    vector<int> ds;
    findSubsequences(vec,0,ds,vec.size());
    return 0;
}   