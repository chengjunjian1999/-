package com.queue;

public class LoopQueue<E> implements Queue<E>{
	
	private E[] data;
	private int front,tail;
	private int size;
	
	public LoopQueue(int capactiy){
		data = (E[])new Object[capactiy+1];
		front=0;
		tail=0;
		size=0;
	}
	public LoopQueue() {
		this(20);
	}
	public int getCapacity(){
		return data.length-1;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return front==tail;
	}

	@Override
	public void enqueue(E e) {
		if((tail+1) % data.length==front){
			resize(getCapacity()*2);
		}
		data[tail]=e;
		tail=(tail+1) % data.length;
		size++;
	}

	@Override
	public E dequeue() {
		if(isEmpty()){
			 throw new IllegalArgumentException("队列值为空");
		}
		E ret = data[front];
		data[front] = null;
		front=(front+1) % data.length;
		size --;
		if(size == getCapacity()/4 && getCapacity()/2!=0 ){
			resize(getCapacity()/2);
		}
		
		return ret;
	}
    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
	@Override
	public E getFront() {
		
		if(isEmpty()){
			throw new IllegalArgumentException("Queue is empty.");
		}
		return data[front];
	}
	private void resize(int newCapacity){
		E[] newData = (E[]) new Object[newCapacity+1];
		for(int i=0;i<size;i++){
			newData[i] = data[(i+front) % data.length];
		}
		data = newData;
		front = 0;
		tail=size;
		
	}
	
	public static void main(String[] args) {
		LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
            	System.out.println("---->");
                queue.dequeue();
                System.out.println(queue);
            }
        }
	}
}
