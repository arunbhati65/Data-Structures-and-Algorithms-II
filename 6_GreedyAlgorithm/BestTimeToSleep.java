// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        String[] strs=S.split("\n");
        HashMap<String,Integer> priority=new HashMap<>();
        priority.put("Sun",7);
        priority.put("Sat",6);
        priority.put("Fri",5);
        priority.put("Thu",4);
        priority.put("Wed",3);
        priority.put("Tue",2);
        priority.put("Mon",1);
        Arrays.sort(strs,new Comparator<String>(){
            public int compare(String ob1,String ob2){
                String[] s1=ob1.split(" ");
                String[] s2=ob2.split(" ");
                if(priority.get(s1[0])==priority.get(s2[0])){
                    return getMin(s1[1].split("-")[0])-getMin(s2[1].split("-")[0]);
                }
                return priority.get(s1[0])-priority.get(s2[0]);
            }
        });
        int maxBreak=getMin(strs[0].split(" ")[1].split("-")[0]);
        for(int i=0;i<strs.length-1;++i){
            int first=getMin(strs[i].split(" ")[1].split("-")[1]);
            int secound=getMin(strs[i+1].split(" ")[1].split("-")[0]);
            int curr=0;
            if(strs[i].split(" ")[0].equals(strs[i+1].split(" ")[0])){
                curr=secound-first;
            }else{
                curr=getMin("24:00")-first+secound;
            }
            maxBreak=Math.max(maxBreak,curr);
        }
        maxBreak=Math.max(maxBreak,getMin("24:00")-getMin(strs[strs.length-1].split(" ")[1].split("-")[1]));
        return maxBreak;
    }

    int getMin(String str){
        String[] arr=str.split(":");
        int min=Integer.parseInt(arr[0])*60;
        min=min+Integer.parseInt(arr[1]);
        return min;
    }
}