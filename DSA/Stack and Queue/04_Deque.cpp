#include<bits/stdc++.h>
using namespace std;

class Deque{
private:
    int *arr;
    int front;
    int rear;
    int size;
public:
    Deque(int cap){
        size = cap;
        arr = new int[size];
        front = -1;
        rear = -1;
    }
   
    void enqueFront(int x){
        if( (rear+1)%size == front){
            cout<<"Dequeue is full."<<endl;
            return;
        } 
        else if(front == -1 && rear == -1){
            front = rear = 0;  
        } 
        else if(front == 0){
            front = size - 1;
        }
        else{
            front--;
        }
        arr[front] = x;
        cout<<x<<" added to front of deque."<<endl;
    }

    void enqueueRear(int x){
        if((rear+1)%size == front){
            cout<<"Queue is full."<<endl;
            return;
        } 
        else if(front == -1 && rear == -1){
            front = rear = 0;
        } 
        else{
            rear = (rear+1) % size;
        }
        arr[rear] = x;
        cout << x << " added to rear of deque." << endl;

    }

    void display(){
        if(front == -1){
            cout<<"Deque is empty."<<endl;
            return;
        }
        int i = front;
        cout<<"Deque elements are : ";
        while(i != rear){
            cout<<arr[i]<<" ";
            i= (i+1)%size;
        }
        cout<<arr[rear]<<endl;
    }

    void dequeueFront(){
        if(front == -1 && rear == -1){
            cout<<"Dequeue is empty."<<endl;
            return;
        }
        int val = arr[front];
        if(front == rear){
            front = rear = -1;
        } 
        else{
            front = (front+1)%size;
        }
        cout<<val<<" has been removed from front."<<endl;
    }

    void dequeueRear(){
        if(front == -1 && rear == -1){
            cout<<"Dequeue is empty."<<endl;
            return;
        }
        int val = arr[rear];
        if(front == rear){
            front = rear = -1;
        }
        else{
            rear = (rear-1 + size)%size;
        }
        cout<<val<<" has been removed from rear."<<endl;
    }

    bool isFull(){
        return ((rear+1)%size == front);
    }
    
    bool isEmpty(){
        return (front == -1);
    }

    int peekFront(){
        if(front == -1){
            cout << "Deque is empty." << endl;
            return -1; 
        }
        return arr[front];
    }

    int peekRear(){
        if(rear == -1){
            cout << "Deque is empty." << endl;
            return -1; 
        }
        return arr[rear];
    }

    ~Deque() {
        delete[] arr;
    }
    
};

int main() {
    Deque dq(5);

    dq.enqueueRear(10);
    dq.enqueueRear(20);
    dq.enqueFront(5);
    dq.display(); // Expected: 5 10 20

    dq.dequeueFront();
    dq.display(); // Expected: 10 20

    dq.dequeueRear();
    dq.display(); // Expected: 10

    dq.dequeueFront();
    dq.display(); // Expected: Deque is empty.

    return 0;
}
