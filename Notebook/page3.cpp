#include<bits/stdc++.h>
using namespace std;

void RemoveDuplicates(vector<int> & vec,int n){
        unordered_set<int> s;
        for(int i=0;i<n;i++){
            s.insert(vec[i]);
        }
        for(auto x : s){
            cout<<x<<" ";
        }
        
}

int main(){
        int n;
        cout<<"Enter size of array: ";
        cin>>n;
        //Taking user input

        vector<int> vec(n);
        cout<<"Enter Array Elements: ";
        for(int i=0;i<n;i++){
            cin>>vec[i];
        }   

        RemoveDuplicates(vec,n);
    
}