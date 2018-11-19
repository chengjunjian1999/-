

public class Array<E> {
	private E[] data;
	private int size;
	
	//构造函数
	public Array(int capacity){
		data = (E[])new Object[capacity];
		size=0;
	}
	//无参构造
	public Array(){
		this(10);
	}
	//获取数组容量
	public int getCapacity(){
		return data.length;
	}
	//获取数组元素个数
	public int getSize(){
		return size;
	}
	//返回数组是否为空
	public boolean isEmpty(){
		return data==null;
	}
	//在所有元素之后插入
	public void addLast(E e){
		add(size,e);
	}
	//在最前面插入
	public void addFirst(E e){
		add(0,e);
	}
	// 在index索引的位置插入一个新元素e
	public void add(int index,E e){
		if(data.length==index){
			resize(data.length * 2);
		}
		if(index<0 || index>size){
			throw new IllegalArgumentException("index<0 or index>size");
		}
		for(int i=size-1;i>=index;i--){
			data[i+1]=data[i];
		}
		data[index]=e;
		size++;
	}
	//获取index索引位置
	public E get(int index){
		if(index<0 || index>=size){
				throw new IllegalArgumentException("index<0 or index>=size！index范围有问题");
		}
		return data[index]; 
	}
	//修改index索引的元素e
	public void set(int index,E e){
		if(index<0 || index>=size){
			throw new IllegalArgumentException("index<0 or index>=size！index范围有问题");
		}
		data[index]=e;
	}
	//查找数组中是否有这个元素
	public boolean contains(E e){
		for(int i=0;i<=data.length-1;i++){
			if(data[i]==e){
				return true;
			}
		}
			 return false;
	}
	//查找元素e所在的索引存在放回索引不存在返回-1
	public int find(E e){
		for(int i=0;i<data.length-1;i++){
			if(data[i]==e){
				return i;
			}
		}
		return -1;
	}
	//从数组中删除index位置的元素,返回删除的元素
	public E remove(int index){
		if(index<0 || index>=size){
			throw new IllegalArgumentException("index<0 or index>=size index取值范围不对！");
		}
		E ret=data[index];
		for(int i=index+1;i<size;i++){
			data[i-1]=data[i];
		}
		size--;
		if(size==data.length/2){
			resize(data.length/2);
		}
		return ret;
	}
	//从数组中删除第一个元素, 返回删除的元素
	public E removeFirst(){
		return remove(0);
	}
	//从数组删除最后一个元素，返回删除元素
	public E remoreLast(){
		return remove(size-1);
	}
	//从数组中删除元素E
	public void removeElement(E e){
		int i=find(e);
		if(i!=-1){
			remove(i);
		}
	}
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array:size=%d,capacity=%d\n", size,data.length));
		res.append('[');
		for(int i=0;i<size;i++){
			res.append(data[i]);
			if(i!=size-1){
				res.append(',');
			}
		}
		res.append(']');
		return res.toString();
	}
	//将数组空间大小容量变成 newCpacity大小
	private void resize(int newCapacity){
		E[] newData = (E[]) new Object[newCapacity];
		for(int i=0;i<=data.length-1;i++){
			newData[i]=data[i];
		}
		data=newData;
	}
}
