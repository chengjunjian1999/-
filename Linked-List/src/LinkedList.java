public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e = e;
            this.next=next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }
    private Node head;
    private int size;

    //获取链表个数
    public int getSize(){
        return size;
    }
    //链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }
    //在表头添加元素
    public void addFirst(E e){
        Node node = new Node(e);
        node.next=head;
        head = node;
        size++;
    }

    public void add(int index,E e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("index参数异常");
        }
        if(index==0){
            addFirst(e);
        }else{
            Node prev = head;
            for(int i=0;i<index-1;i++){
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;
            size++;
        }
    }

    //在表尾添加元素
    public void addLast(E e){
        add(size,e);
    }

}
