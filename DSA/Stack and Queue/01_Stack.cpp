// #include<bits/stdc++.h>
// using namespace std;

// class Stack{    
//     private:
//     int topp;
//     int *arr;
//     int size;

//     public:
//     Stack(int cap){
//         size=cap;
//         arr = new int[size];
//         topp = -1;
//     }

//     void push(int x){
//         if(topp >= size-1){
//             cout<<"Stack Overflow"<<endl;
//             return;
//         } else{
//             arr[++topp] = x;
//             cout<<x<<" added to stack successfully."<<endl;
//         }
//     }

//     void pop(){
//         if(topp == -1){
//             cout<<"Stack Underflow"<<endl;
//             return;
//         } else{
//             cout<<arr[topp]<<" popped out from stack."<<endl;
//             topp--;
//         }
//     }

//     int top(){
//         if(topp == -1){
//             cout<<"Stack is Empty"<<endl;
//             return -1;
//         }
//         return arr[topp];
//     }

//     bool isEmpty(){
//         return topp == -1;
//     }

//     ~Stack(){
//         delete [] arr;
//     }
// };

// int main(){
//     Stack s(5);
//     s.push(5);
//     s.push(6);
//     cout<<"Top element : "<<s.top()<<endl;
//     s.pop();
//     cout<<"Top element : "<<s.top()<<endl;
//     cout<<"Is Stack empty : "<<(s.isEmpty() ? "Yes" : "No")<<endl;
// }

// //Stack using vector

// #include <bits/stdc++.h>
// using namespace std;

// class Stack{
//     private:
//         vector<int> vec;

//     public:
//         void push(int x){
//             vec.push_back(x);
//             cout<<x<<" pushed into the stack successfully"<<endl;
//         }

//         void pop(){
//             if(vec.empty()){
//                 cout<<"Stack Undereflow."<<endl;
//             }
//             else{
//                 cout<<vec.back()<<" popped out successfully."<<endl;
//                 vec.pop_back();
//             }
//         }

//         int top(){
//             if(vec.empty()){
//                 cout<<"Stack is empty"<<endl;
//                 return -1;
//             }
//             else{
//                 return vec.back();
//             }
//         }

//         bool isEmpty(){
//             return vec.empty();
//         }
// };

// int main(){
//     Stack s;
//     s.push(5);
//     s.push(4);
//     cout<<"Top Element : "<<s.top()<<endl;
//     s.pop();
//     cout<<"Is stack empty..? : "<<(s.isEmpty() ? "Yes" : "No")<<endl;
// }

//Stack using Linkded List

// #include<bits/stdc++.h>
// using namespace std;

// struct Node{
//     int data;
//     Node * next;
// };

// class Stack{
// private:
//     Node* top;
// public:
//     Stack(){
//         top = nullptr;
//     }

//     void push(int x){
//         Node* newNode = new Node();
//         newNode->data =x;
//         newNode->next = top;
//         top = newNode;
//         cout<<x<<" pushed into the stack successfully."<<endl;
//     }

//     void pop(){
//         if(top == nullptr){
//             cout<<"Stack Underflow.";
//             return;
//         }
//         Node* temp =top;
//         top = top->next;
//         cout<<temp->data<<" popped out successfully."<<endl;
//         delete temp;
//     }

//     void peek(){
//         if(top == nullptr){
//             cout<<"Stack is empty";
//             return;
//         }
//         cout<<"Top Element : "<<top->data<<endl;
//     }

//     bool isEmpty(){
//         return top == nullptr;
//     }

//     void display(){
//         if(top == nullptr){
//             cout<<"Stack is empty."<<endl;
//             return;
//         }
//         Node* temp = top;
//         cout<<"Stack elements: ";
//         while(temp){
//             cout<<temp->data<<" ";
//             temp=temp->next;
//         }
//         cout<<endl;
//     }
// };


// int main(){
//     Stack s;
//     s.push(4);
//     s.push(43);
//     s.push(121);
//     s.display();
//     s.pop();
//     s.peek();
//     s.display();
// }

//Using List Class
#include<bits/stdc++.h>
#include<stack>
using namespace std;

int main(){
    stack<int> s;
    s.push(33);
    s.push(343);
    s.push(232);
    cout<<"Is stack empty -> "<<(s.empty() ? "Yes" : "No" )<<endl;

    while(!s.empty()){
        cout<<s.top()<<" ";
        s.pop();
    }
    
}
