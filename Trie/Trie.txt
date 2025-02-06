public boolean search(TNode node,String s){
    if(s.length()==0) return false;
    int i=0;
    while(i<s.length()){
        if(!node.dic.containsKey(s.charAt(i))) return false;
        node=node.dic.get(s.charAt(i));
        i++;
    }
    return node.isEnd;
}
    
public void insert(TNode node,String word){
    int i=0;
    if(word.length()==0) return;
    while(i<word.length()){
        node.dic.put(word.charAt(i),new TNode());
        node=node.dic.get(word.charAt(i));
        i++;
    }
    node.isEnd=true;
}

class TNode{
    public boolean isEnd;
    public Map<Character,TNode> dic=new HashMap<>();
}