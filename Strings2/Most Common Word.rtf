class Solution {
    public String mostCommonWord(String p, String[] banned) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<banned.length;++i){
            set.add(banned[i]);
        }
        String ans=null;int count=0;
        HashMap<String,Integer> map=new HashMap<>();
        StringBuilder temp=null;
        for(int i=0;i<p.length();++i){
            char c=p.charAt(i);
            if((c>='A'&& c<='Z')||(c>='a'&& c<='z')){
                if(temp==null){
                    temp=new StringBuilder();
                }
                temp.append(c);
            }else{
                if(temp!=null && temp.length()!=0){
                    String sTemp= temp.toString();
                    sTemp=sTemp.toLowerCase();
                    if(set.contains(sTemp)){
                        temp=null;
                        continue;
                    }
                    map.put(sTemp,map.getOrDefault(sTemp,0)+1);
                    if(count<map.get(sTemp)){
                        count=map.get(sTemp);
                        ans=sTemp;
                    }
                    temp=null;
                }
            }
        }
        if(temp!=null && temp.length()!=0){
            String sTemp= temp.toString();
            sTemp=sTemp.toLowerCase();
            if(!set.contains(sTemp)){
                map.put(sTemp,map.getOrDefault(sTemp,0)+1);
                if(count<map.get(sTemp)){
                    count=map.get(sTemp);
                    ans=sTemp;
                }
            }
            temp=null;
        }
        return ans;
    }
}