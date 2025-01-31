class Solution {
    HashMap<String,Boolean> map=new HashMap<>();
    public boolean wordBreak(String s, List<String> words) {
        TNode node=new TNode();
        for(String word:words){
            insert(node,word);            
        }
        return searchHelper(node,s);
    }
    
    public boolean searchHelper(TNode node,String s){
       if(map.containsKey(s)) return map.get(s);
       if(s.length()==0) return true;
       for(int i=1;i<=s.length();++i){
           if(search(node,s.substring(0,i)) && searchHelper(node,s.substring(i,s.length()))){
               map.put(s,true);
               return true;
           } 
       }
       map.put(s,false);
       return false; 
    }
    
    public boolean search(TNode node,String s){
        if(map.containsKey(s)) return map.get(s);
        if(s.length()==0) return false;
        int i=0;
        while(i<s.length()){
            if(!node.dic.containsKey(s.charAt(i))) return false;
            node=node.dic.get(s.charAt(i));
            i++;
        }
        map.put(s,node.isEnd);
        return node.isEnd;
    }
    
    public void insert(TNode node,String word){
        int i=0;
        if(word.length()==0) return;
        while(i<word.length()){
            if(!node.dic.containsKey(word.charAt(i))){
                node.dic.put(word.charAt(i),new TNode());
            }
            node=node.dic.get(word.charAt(i));
            i++;
        }
        node.isEnd=true;
    }
}

class TNode{
    public boolean isEnd;
    public Map<Character,TNode> dic=new HashMap<>();
}