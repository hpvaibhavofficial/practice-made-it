// #include<bits/stdc++.h>
// using namespace std;

// class CircularQueue{
// private:
//     int *arr;
//     int size;
//     int front;
//     int rear;
// public:
//     CircularQueue(int cap){
//         size = cap;
//         arr = new int[size];
//         front = rear =-1;
//     }
//     bool ifEmpty(){
//         return front == -1;
//     }
//     void enqueue(int x){
//         if(rear == -1 && front == -1){
//             rear = front = 0;
//             arr[rear] = x;   
//             cout<<x<<" enqueued successfully."<<endl;
//         }
//         else if(front == (rear + 1) % size){
//             cout<<"Queue is full."<<endl;
//         }
//         else{
//             rear = (rear+1)%size;
//             arr[rear] =x;
//             cout<<x<< " enqueued successfully."<<endl;
//         }
//     }

//     void dequeue(){
//         if(front == -1 && rear == -1){
//             cout<<"Queue is empty.Noting is there."<<endl;
//         } 
//         else if(front == rear){
//             cout << arr[front] << " dequeued successfully." << endl;
//             front = rear = -1;
//         } 
//         else{
//             cout << arr[front] << " dequeued successfully." << endl;
//             front = (front+1)%size;
//         }
//     }
//     void display(){
//         if(front == -1 && rear == -1){
//             cout<<"Queue is Empty."<<endl;
//             return;
//         }
//         int i = front;
//         cout<<"Queue elements are: ";
//         while(i!=rear){
//             cout<<arr[i]<<" ";
//             i = (i+1) % size;
//         }
//         cout<<arr[i];
//         cout<<endl;
//     }

//     void peek(){
//         if(front == -1 && rear == -1){
//             cout<<"Queue is empty."<<endl;
//         }
//         else{
//             cout<<"Front element is: "<<arr[front]<<endl;
//         }
//     }
// };

// int main() {
//     CircularQueue q(5);  // Capacity of 5

//     q.enqueue(10);
//     q.enqueue(20);
//     q.enqueue(30);
//     q.enqueue(40);
//     q.enqueue(50); // Should fill the queue
//     q.display();   // Should show: 10 20 30 40 50

//     q.enqueue(60); // Should show "Queue is full."

//     q.dequeue();   // Removes 10
//     q.dequeue();   // Removes 20
//     q.display();   // Should show: 30 40 50

//     q.enqueue(60); // Should succeed (circular)
//     q.enqueue(70); // Should succeed (circular)
//     q.display();   // Should show: 30 40 50 60 70

//     q.peek();      // Should show front: 30

//     return 0;
// }

//Using Linked List
#include<bits/stdc++.h>
using namespace std;

struct Node{
    int data;
    Node* next;
};

class Queue{
private:
    Node* front;
    Node* rear;
public:
    Queue(){
        front = nullptr;
        rear = nullptr;
    }
    void enqueue(int x){
        Node* newnode = new Node();
        newnode->data = x;
        newnode->next = nullptr;

        if(front == nullptr && rear == nullptr){
            front = rear = newnode;
            rear->next= front;
        }
        else{
            rear->next = newnode;
            rear = newnode;
            rear->next = front;
        }
        cout<<x<<" added to queue successfully."<<endl;
    }

    void dequeue(){
        if(front == nullptr && rear == nullptr){
            cout<<"Queue is empty.";
        }
        else if(front == rear){
            Node* temp = front;
            cout<<front->data<<" dequeued successfully."<<endl;
            front = rear = nullptr;
            delete temp;
        }
        else{
            Node* temp = front;
            cout<<front->data<<" dequeued successfully."<<endl;
            front = front->next;
            rear->next = front;
            delete temp;
        }
    }

    void display(){
        if(front== nullptr && rear == nullptr){
            cout<<"Queue is empty."<<endl;
        } 
        else{
            cout<<"Queue elements are: ";
            Node* temp = front;
            while(temp->next != front){
                cout<<temp->data<<" ";
                temp = temp->next;
            }
            cout<<temp->data<<endl;
        }
    }

    void peek(){
        if(front== nullptr && rear == nullptr){
            cout<<"Queue is empty."<<endl;
        } 
        else{
            cout<<"Front element is: "<<front->data<<endl;
        }
    }

    int size(){
        int size = 0 ;
        if(front == nullptr){
            return size;
        }
        Node* temp = front;
        while(temp->next!= front){
            size++;
            temp= temp->next;
        }
        return size+1;
    }


};
int main() {
    Queue q;
    q.enqueue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.display();          // Output: 10 20 30
    cout << "Size: " << q.size() << endl; // Output: Size: 3
    q.peek();             // Output: Front element is: 10
    q.dequeue();
    q.display();          // Output: 20 30
    cout << "Size: " << q.size() << endl; // Output: Size: 2
    q.peek();             // Output: Front element is: 20
    return 0;
}
