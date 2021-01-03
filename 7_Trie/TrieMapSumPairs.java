class TrieNode{
    public Map<Character,TrieNode> map;
    public int sum;
    
    public TrieNode() {
        map=new HashMap<>();
    }
}

class MapSum {
    TrieNode trieNode;
    Map<String,Integer> map;
    public MapSum() {
        trieNode=new TrieNode();
        map=new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int existingValue=map.getOrDefault(key,0);
        map.put(key,val);
        insertCharacter(trieNode,key,0,val,existingValue);
    }
    
    void insertCharacter(TrieNode dict,String word,int i,int val,int existingValue){
        if(word.length()-1==i){
            if(dict.map.containsKey(word.charAt(i))){
                dict.map.get(word.charAt(i)).sum=dict.map.get(word.charAt(i)).sum + val - existingValue; 
            }else{
                TrieNode trieNode=new TrieNode();
                trieNode.sum=val;
                dict.map.put(word.charAt(i),trieNode);
            }
            return;
        }else{
            if(dict.map.containsKey(word.charAt(i))){
                dict.map.get(word.charAt(i)).sum=dict.map.get(word.charAt(i)).sum+val- existingValue;
                insertCharacter(dict.map.get(word.charAt(i)),word,i+1,val,existingValue);
            }else{
                TrieNode trieNode=new TrieNode();
                trieNode.sum=val;
                dict.map.put(word.charAt(i),trieNode);
                insertCharacter(dict.map.get(word.charAt(i)),word,i+1,val,existingValue);
            }
        }
    }
    
    public int sum(String prefix) {
        return searchChar(trieNode,prefix,0);
    }
    
    int searchChar(TrieNode dict,String word,int i){
        if(word.length()-1==i){
          if(dict.map.containsKey(word.charAt(i))) {
              return dict.map.get(word.charAt(i)).sum;
          }
        } 
        if(dict.map.containsKey(word.charAt(i))){
            return searchChar(dict.map.get(word.charAt(i)),word,i+1);
        }
        return 0;
    }
}
