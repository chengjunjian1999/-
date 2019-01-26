public class LinkedList<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
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
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead=new Node();
        size=0;
    }
    public void add(int index,E e){
        if(index<0 || index>size){
            throw new IllegalArgumentException("index argument exception");
        }
        Node prev = dummyHead;
        for(int i=0;i<index;i++){
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next=prev.next;
        prev.next=node;
        size++;
    }
    public void addFirst(E e){
        add(0,e);
        size++;
    }
    public void addLast(E e){
        add(size,e);
    }
    public E get(int index){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("index argument exception");
        }
        Node cur = dummyHead;
        for(int i=0;i<index;i++){
            cur = dummyHead.next;
        }
        return cur.e;
    }
    // 获得链表的第一个元素
    public E getFirst(){
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast(){
        return get(size - 1);
    }
    //修改链表中的元素
    public void set(int index,E e){
        if(index<0 || index>=size){
            throw new IllegalArgumentException("index argument exception");
        }
        Node cur = dummyHead;
        for(int i=0;i<index;i++){
            cur = dummyHead.next;
        }
        cur.e=e;
    }
    //查找链表中是否包含这个元素
    public boolean contains(E e){
        Node cur = dummyHead.next;
        while(cur !=null){
            if(cur.e.equals(e)){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur!=null){
            res.append(cur+"->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
