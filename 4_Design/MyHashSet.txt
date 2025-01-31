class MyHashSet {

    int CAPACITY;
    
    List<Integer>[] hashTable;
    
    public MyHashSet() {
        CAPACITY=2069;
        hashTable = new LinkedList[CAPACITY];
        for (int i = 0; i < this.CAPACITY; ++i) {
            this.hashTable[i]=new LinkedList<>();
        }
    }
    
    int getHash(int key){
       return key%CAPACITY; 
    }
    
    public void add(int key) {
        int hashKey= getHash(key);
        for(Integer bucket:hashTable[hashKey]){
            if(bucket==key){
                hashTable[hashKey].remove(bucket);
                break;
             }
        }
        hashTable[hashKey].add(key); 
    }
    
    public void remove(int key) {
        int hashKey= getHash(key);
        for(Integer bucket:hashTable[hashKey]){
            if(bucket==key){
                hashTable[hashKey].remove(bucket); break;
            }
        }  
    }
    
    public boolean contains(int key) {
        int hashKey= getHash(key);
        for(Integer bucket:hashTable[hashKey]){
            if(bucket==key){
                return true;
            }
        }
        return false;
    }
}
