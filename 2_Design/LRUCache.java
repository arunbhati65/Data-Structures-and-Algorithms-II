public class Node{
    int val;
    int key;
    Node next;
    Node prev;
    
    Node(){
        
    }
    
    Node(int val,int key){
        this.val=val;
        this.key=key;
    }
}
class LRUCache {
    int capacity;
    Map<Integer,Node> map=new HashMap<>();
    Node head;
    Node tail;
    int size;
    public LRUCache(int capacity) {
        this.capacity=capacity;
            head=new Node();
            tail=new Node();
            head.next=tail;
            tail.prev=head;
            size=0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int toReturn=this.map.get(key).val;
        deleteNode(this.map.get(key));
        addNodeToHead(map.get(key));
        return toReturn;
    }
    
      void addNodeToHead(Node node){
        node.prev=head;
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
    }
    
    void deleteNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public void put(int key, int value) {
        Node node=new Node(value,key);
        if(map.containsKey(key)){
             deleteNode(map.get(key));
             --size;
        }
        ++size;
        addNodeToHead(node);
        map.put(key,node);
        if(size>capacity && size!=0){
            Node toRemove=tail.prev;
            deleteNode(toRemove);
            map.remove(toRemove.key);
            --size;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
