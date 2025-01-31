public static int findLength(char[] arr) {
    HashMap<Character,Integer> map=new HashMap<>();
       int l=0;
    int max=0;
       for(int h=0;h<arr.length;++h){
             if(map.keySet().size()<2){
               map.put(arr[h],map.getOrDefault(arr[h],0)+1);
             }
             else if(map.keySet().size()==2 && !map.containsKey(arr[h])){
               map.remove(arr[l++]);
                map.put(arr[h],1);
             }else if(map.containsKey(arr[h])){
           map.put(arr[h],map.getOrDefault(arr[h],0)+1);
       }
       int temp=0;
       for(int v:map.values()){
           temp=temp+v;
       }
       max=Math.max(max,temp);
       }
      return max;
 }

