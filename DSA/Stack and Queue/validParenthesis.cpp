#include<bits/stdc++.h>
using namespace std;
class ValidParenthesis{
    public: 
    bool isValid(string str){
        stack<char> st;
        for(char ch : str){
            if(ch == '{' || ch == '(' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.empty()){
                    return false;
                } 
                else{
                    if((st.top() == '(' && ch == ')') ||
                            (st.top() == '{' && ch == '}') ||
                                (st.top() == '[' && ch == ']')){
                                    st.pop();
                    } 
                    else{
                        return false;
                    } 
                }
            }
        }
        return st.empty();
    }
};
int main(){
    ValidParenthesis obj;
    string s;
    cout<<"Enter parenthesis to check: ";
    cin>>s;
    if(obj.isValid(s)){
        cout<<"These are valid Parenthesis."<<endl;
    } else{
        cout<<"These are not valid Parenthesis."<<endl;
    }
}