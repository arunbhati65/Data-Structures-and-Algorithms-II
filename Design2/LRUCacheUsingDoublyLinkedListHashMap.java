
class LRUCache {
    class Node{
        Node next;
        Node prev;
        int key;
        int val;
        
        public Node(){         
        }
        public Node(int key,int value){
            this.key=key; this.val=value;
        }
    }
    Node head ;
    Node tail ;
    HashMap<Integer,Node> map;
    
    int capacity=0;
    
    int size;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.size=0;
        head=new Node();tail=new Node();
        tail.prev=head; head.next=tail;
    }
    
    void deleteNode(Node node){
    Node prev = node.prev;
    Node next = node.next;

    prev.next = next;
    next.prev = prev;
        
    }
    
    void addNodeToHead(Node node){
        node.prev=head;
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
    }
    
    public int get(int key) {
        Node fetchedNode= map.get(key);
        if(fetchedNode==null) return -1;
        deleteNode(fetchedNode);
        addNodeToHead(fetchedNode);
        return fetchedNode.val;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node==null){
            Node newNode=new Node(key,value);
            map.put(key,newNode);
            addNodeToHead(newNode);
            ++size;
            if(size>capacity){Node toDelete=tail.prev;deleteNode(toDelete); map.remove(toDelete.key);--size;}
        }else{
            node.val=value;
            deleteNode(node);
            addNodeToHead(node);
        }
    }
}
