#include<bits/stdc++.h>
using namespace std;

void print(int x){
    if(x == 6){
        return; 
    }
    cout<<x<<endl;
    x++;
    print(x);
}

int main(){
    print(3);
    
    
}