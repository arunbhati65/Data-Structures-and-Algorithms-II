class TrieNode{
    public Map<Character,TrieNode> map;
    public boolean isEnd;
    
    public TrieNode() {
        map=new HashMap<>();
    }
}
class Trie {
    TrieNode trieNode;
    public Trie() {
        trieNode=new TrieNode();
    }
    
    public void insert(String word) {
        insertCharacter(trieNode,word,0);
    }
    
    void insertCharacter(TrieNode dict,String word,int i){
        if(word.length()-1==i){
            if(dict.map.containsKey(word.charAt(i))){
                dict.map.get(word.charAt(i)).isEnd=true;
            }else{
                TrieNode trieNode=new TrieNode();
                trieNode.isEnd=true;
                dict.map.put(word.charAt(i),trieNode);
            }
            return;
        }else{
            if(dict.map.containsKey(word.charAt(i))){
                insertCharacter(dict.map.get(word.charAt(i)),word,i+1);
            }else{
                TrieNode trieNode=new TrieNode();
                dict.map.put(word.charAt(i),trieNode);
                insertCharacter(dict.map.get(word.charAt(i)),word,i+1);
            }
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchChar(trieNode,word,0);
    }
    
    boolean searchChar(TrieNode dict,String word,int i){
        if(word.length()-1==i){
          if(dict.map.containsKey(word.charAt(i)) && dict.map.get(word.charAt(i)).isEnd) return true; 
          return false;  
        } 
        if(dict.map.containsKey(word.charAt(i))){
            return searchChar(dict.map.get(word.charAt(i)),word,i+1);
        }
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(trieNode,prefix,0);
    }
    
    boolean searchPrefix(TrieNode dict,String word,int i){
        if(word.length()-1==i){
          if(dict.map.containsKey(word.charAt(i))) return true; 
          return false;  
        } 
        if(dict.map.containsKey(word.charAt(i))){
            return searchPrefix(dict.map.get(word.charAt(i)),word,i+1);
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
