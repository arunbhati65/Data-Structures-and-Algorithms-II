/*
Design a HashMap without using any built-in hash table libraries.

To be specific, your design should include these functions:

put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
*/
class MyPair<T,Y>{
    public T key;
    public Y value;
    
    public MyPair(){
        
    }
    
    public MyPair(T key,Y value){
        this.key=key;
        this.value=value;
    }
    
    @Override
    public String toString(){
        return "key: "+key+" Value: "+value;  
    } 
}
class MyHashMap {
    int CAPACITY;
    List<MyPair<Integer,Integer>>[] hashTable;
    public MyHashMap() {
        CAPACITY=2069;
        hashTable = new LinkedList[CAPACITY];
        for (int i = 0; i < this.CAPACITY; ++i) {
            this.hashTable[i]=new LinkedList<>();
        }
    }
    
    int getHash(int key){
       return key%CAPACITY; 
    }
    
    public void put(int key, int value) {
        int hashKey= getHash(key);
            boolean found=false;
            for(MyPair<Integer,Integer> bucket:hashTable[hashKey]){
                if(bucket.key==key){
                    hashTable[hashKey].remove(bucket);
                    break;
                 }
            }
            MyPair<Integer,Integer> newPair=new MyPair<>(key,value);
            hashTable[hashKey].add(newPair); 
    }
    
    public int get(int key) {
        int hashKey= getHash(key);
        if(null==hashTable[hashKey]){
            return -1;
        }
        for(MyPair<Integer,Integer> bucket:hashTable[hashKey]){
            if(bucket.key==key){
                return bucket.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hashKey= getHash(key);
        if(null==hashTable[hashKey]){
            return;
        }
        for(MyPair<Integer,Integer> bucket:hashTable[hashKey]){
            if(bucket.key==key){
                hashTable[hashKey].remove(bucket); break;
            }
        }
    }
}

