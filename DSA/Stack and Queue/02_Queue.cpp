// #include<bits/stdc++.h>
// using namespace std;

// class Queue{
// private:
//     int rear;
//     int front;
//     int *arr;
//     int size;
// public:
//     Queue(int capacity){
//         size = capacity ;
//         arr = new int[size];
//         rear=-1;  
//         front =-1;
//     }

//     void enqueue(int x){
//         if(rear >= size-1){
//             cout<<"Queue Overflow"<<endl;
//             return;
//         } 
//         else if(front == -1 && rear == -1){
//             front++; rear++;
//             arr[rear] = x;
//             cout<<arr[rear]<<" added to queue"<<endl;
//         }
//         else{
//             arr[++rear] = x;
//             cout<<arr[rear]<<" added to queue"<<endl;
//         }
//     }

//     void dequeue(){
//         if(front == -1 && rear == -1){
//             cout<<"Queue is empty."<<endl;
//             return;
//         }
//         else if(front == rear){
//             cout<<arr[front]<<" has been removed. Now Queue is empty."<<endl;
//             front = rear = -1;
//         }
//         else{
//             cout<<arr[front]<<" removed successfully."<<endl;
//             front++;
//         }
//    }

//    void display(){
//         if(rear == -1 && front == -1){
//             cout<<"Queue is empty"<<endl;
//             return;
//         }
//         cout<<"Elements in Queue are: ";
//         for(int i= front;i<=rear;i++){
//             cout<<arr[i]<<" ";
//         }
//         cout<<endl;
//    }
   
//    bool isEmpty(){
//     return (rear == -1 && front == -1);
//    }

//    bool isFull(){
//         return (rear == size -1);
//    }

//   void peek(){
//         if(isEmpty()){
//             cout<<"Queue is empty"<<endl;
//         }
//         else{
//             cout<<"Front Element is : "<<arr[front]<<endl;
//         }
//    }
       
// };

// int main(){
//     Queue q(5);
//     q.enqueue(4);
//     q.enqueue(23);
//     q.enqueue(12);
//     q.display();
//     q.dequeue();
//     q.dequeue();
//     q.enqueue(2231);
//     q.peek();
//     q.enqueue(12322);
//     q.dequeue();
//     q.dequeue();
//     q.dequeue();
//     q.dequeue();
// }

//Using linked list
#include<bits/stdc++.h>
using namespace std;

struct Node{
    int data;
    Node * next;
};

class Queue{
private:
    Node* rear;
    Node* front;

public:
    Queue(){
        rear = nullptr;
        front =nullptr;
    }

void enqueue(int x){
    Node * newnode = new Node();
    newnode->data=x;
    newnode->next = nullptr;
    if(front == nullptr && rear ==nullptr){
        front = rear = newnode;
    } 
    else{
        rear->next = newnode;
        rear = newnode;
    }
    cout<<x<<" enqueued to queue."<<endl;
}

void dequeue(){
    if(front == nullptr && rear == nullptr){
        cout<<"Queue is empty.Nothing to dequeue."<<endl;
        return;
    }
    Node* temp = front;
    front = front->next;
    cout<<temp->data<<" dequeued successfully"<<endl;
    delete temp;

    if(front == nullptr){
        rear = nullptr;
    }
}

void peek(){
    if(front == nullptr && rear ==nullptr){
        cout<<"Queue is empty.Nothing to display."<<endl;
    } else{
        cout<<"Front element is : "<<front->data<<endl;
    }
}

bool isEmpty(){
    return front == nullptr;
}
};
int main(){
    Queue q;
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);

    q.peek();        // Should show 10
    q.dequeue();     // Should remove 10
    q.peek();        // Should now show 20

    q.dequeue();     // Removes 20
    q.dequeue();     // Removes 30

    q.dequeue();     // Should show empty message

    if (q.isEmpty()) {
        cout << "Queue is empty now." << endl;
    } else {
        cout << "Queue still has elements." << endl;
    }

    return 0;
}