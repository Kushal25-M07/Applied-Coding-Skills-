class MyCircularDeque {
    private int[] q;
    private int front;
    private int size;
    private int k;

    public MyCircularDeque(int k) {
        this.k = k;
        this.q = new int[k];
        this.front = 0;
        this.size = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        
        front = (front - 1 + k) % k;
        q[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        
        int rear = (front + size) % k;
        q[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        
        front = (front + 1) % k;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        
        size--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return q[front];
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        
        int rear = (front + size - 1) % k;
        return q[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
    }
}

