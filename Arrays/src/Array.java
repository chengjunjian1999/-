

public class Array {
	private int[] data;
	private int size;
	
	//构造函数
	public Array(int capacity){
		data = new int[capacity];
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
	public void addLast(int e){
		add(size,e);
	}
	//在最前面插入
	public void addFirst(int e){
		add(0,e);
	}
	// 在index索引的位置插入一个新元素e
	public void add(int index,int e){
		if(data.length==index){
			throw new IllegalArgumentException("容量已满");
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
	public int get(int index){
		if(index<0 || index>=size){
				throw new IllegalArgumentException("index<0 or index>=size！index范围有问题");
		}
		return data[index]; 
	}
	//修改index索引的元素e
	public void set(int index,int e){
		if(index<0 || index>=size){
			throw new IllegalArgumentException("index<0 or index>=size！index范围有问题");
		}
		data[index]=e;
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
	
}
