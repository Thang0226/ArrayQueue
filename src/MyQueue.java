public class MyQueue {
	private int capacity;
	private int[] queueArr;
	private int head = 0;
	private int tail = -1;
	private int currentSize = 0;
	// Technique: Circle Array - when head or tail pointer exceed last element, point them to queueArr[0]
	public MyQueue(int queueSize) {
		this.capacity = queueSize;
		queueArr = new int[this.capacity];
	}

	public boolean isQueueFull(){
		boolean status = false;
		if (currentSize == capacity){
			status = true;
		}
		return status;
	}

	public boolean isQueueEmpty(){
		boolean status = false;
		if (currentSize == 0){
			status = true;
		}
		return status;
	}

	public void enqueue(int item) {
		if (isQueueFull()) {
			System.out.println("Overflow ! Unable to add element: " + item);
		} else {
			tail++;
			if (tail == capacity) {
				tail = 0;
			}
			queueArr[tail] = item;
			currentSize++;
			System.out.println("Element " + item + " is pushed to Queue !");
		}
	}

	public void dequeue() {
		if (isQueueEmpty()) {
			System.out.println("Underflow ! Unable to remove element from Queue");
		} else {
			head++;
			System.out.println("Pop operation done ! removed: " + queueArr[head - 1]);
			if (head == capacity) {
				head = 0;
			}
			currentSize--;
		}
	}

	public void printQueue() {
		if (currentSize == 0) {
			System.out.println("Queue is empty !");
			return;
		}
		System.out.println("Elements in the queue:");
		if (head <= tail) {
			for (int i = head; i <= tail; i++) {
				System.out.print(" " + queueArr[i]);
			}
		} else { // when head > tail, queue elements are in 2 parts of the array
			for (int i = head; i <= capacity - 1; i++) {
				System.out.print(" " + queueArr[i]);
			}
			for (int i = 0; i <= tail; i++) {
				System.out.print(" " + queueArr[i]);
			}
		}
		System.out.println();
	}
}
