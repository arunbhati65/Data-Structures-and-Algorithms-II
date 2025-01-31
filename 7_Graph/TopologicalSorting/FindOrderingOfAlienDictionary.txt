/*
Input: Words: ["ba", "bc", "ac"]
Output: bac

Input: Words: ["cab", "aaa", "aab"]
Output: cab
*/
void printOrderOfAlienDictionary(String[] words){
    Map<Character,Set<Character>> graph=new HashMap<>();
    Map<Character,Integer> inDegree=new HashMap<>();
    for(int i=0;i<words.length-1;++i){
        char[] first=words[i].toCharArray();
        char[] scond=words[i+1].toCharArray();
        for(int j=0;j<Math.min(first.length,scond.length);++i){
             char firstC=first[j];
             char scondC=scond[j];
             if(!graph.containsKey(firstC)){
                graph.put(firstC,new HashSet<Character>());
             } 
             if(!graph.containsKey(scondC)){
                graph.put(scondC,new HashSet<Character>());
             } 
             if(firstC!=scondC){
                graph.get(firstC).add(scondC);
                inDegree.put(scondC.inDegree.getOrDefault(scondC,0)+1);
                break;
             }
        }
    }
    //Do Topological Sorting on the maps
}