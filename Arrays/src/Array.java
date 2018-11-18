
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
}
