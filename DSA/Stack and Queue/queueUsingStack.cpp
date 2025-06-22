#include<bits/stdc++.h>
using namespace std;

class Queue{
    stack<int> s1,s2;
    int count=0;
public:
    void enqueue(int x){
        while(!s1.empty()){
            s2.push(s1.top());
            s1.pop();
        }
        s1.push(x);
        cout<<x<<" pushed (enqueued) successfully."<<endl;
        while(!s2.empty()){ 
            s1.push(s2.top());
            s2.pop();
        }
    }

    void dequeue(){
        if(s1.empty()){
            cout<<"Queue is empty."<<endl;
            return;
        }
        cout<<s1.top()<<" popped out successdully."<<endl;
        s1.pop();
    }

    void front(){
        if(s1.empty()){
            cout<<"Queue is empty."<<endl;
            return;
        }
        cout<<"Front element is : "<<s1.top()<<endl;
    }

};

int main() {
    Queue q;
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);

    q.front();    // Should print Front element is : 10
    q.dequeue();  // Should print 10 popped out successfully.
    q.front();    // Should print Front element is : 20
    q.dequeue();  // Should print 20 popped out successfully.
    q.dequeue();  // Should print 30 popped out successfully.
    q.dequeue();  // Should print Queue is empty.

    return 0;
}
