#include<bits/stdc++.h>
using namespace std;

void revHelper(string s,int i){
    if(i >=s.length()){
        return;
    }
    revHelper(s,i+1);
    cout<<s[i];
}
void rev(string s){
    revHelper(s,0);
}
int main(){
    rev("bvv");   
}