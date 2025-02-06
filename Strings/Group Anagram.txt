class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            String hashCode=getHashCode(str);
            List<String> list=map.getOrDefault(hashCode,new ArrayList<>());
            list.add(str);
            map.put(hashCode,list);
        }
        return new ArrayList(map.values());
    }
    
    private String getHashCode(String str){
        int[] memo=new int[256];
        for(int i=0;i<str.length();++i){
            memo[str.charAt(i)]++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<memo.length;++i){
            sb.append(memo[i]+"#");
        }
        return sb.toString();
    }
}