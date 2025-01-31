/*
In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other", we can form a new word "another".
Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has the shortest length.
Return the sentence after the replacement.
Example 1:
Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
*/
class TrieNode{
    Map<Character,TrieNode> map;
    boolean isEnd;
    TrieNode(){
        map=new HashMap<>();
    }
}
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trie=new TrieNode();
        for(String word:dictionary){
            insertWord(trie,word,0);
        }
        String[] arr=sentence.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;++i){
            String prefix=searchHelper(trie,arr[i]);
            if(prefix.length()!=0){
                sb.append(prefix+" ");
            }else{
                sb.append(arr[i]+" ");
            }
        }
        return sb.toString().trim();
        
    }
    String searchHelper(TrieNode dict,String word){
        int index=searchChar(dict,word);
        return word.substring(0,index);
    }
    
    int searchChar(TrieNode dict,String word){
        TrieNode curr=dict;
        int i=0;
        while(i<word.length()){
            if(!curr.map.containsKey(word.charAt(i))){
                return 0;
            }else{
                if(curr.map.get(word.charAt(i)).isEnd){
                    return i+1;
                }
                curr=curr.map.get(word.charAt(i));
            }
            ++i;
        }
        return 0;
    }
    
    private void insertWord(TrieNode dict,String word,int i){
        if(word.length()-1==i){
            if(!dict.map.containsKey(word.charAt(i))){
                TrieNode trieNode=new TrieNode();
                trieNode.isEnd=true;
                dict.map.put(word.charAt(i),trieNode);
            }else{
                dict.map.get(word.charAt(i)).isEnd=true;
            }
            return;
        }else{
            if(dict.map.containsKey(word.charAt(i))){
                insertWord(dict.map.get(word.charAt(i)),word,i+1);
            }else{
                TrieNode trieNode=new TrieNode();
                dict.map.put(word.charAt(i),trieNode);
                insertWord(dict.map.get(word.charAt(i)),word,i+1);
            }
        }        
    }
}
